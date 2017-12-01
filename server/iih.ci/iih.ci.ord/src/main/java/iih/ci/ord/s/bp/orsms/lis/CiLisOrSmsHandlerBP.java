package iih.ci.ord.s.bp.orsms.lis;

import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.List;

import xap.mw.core.data.BizException;

public class CiLisOrSmsHandlerBP  {


	public List<CiLisOrSmsIoDTO> exec(CiOrderDO[] ciors,CiOrSessionDO session)
			throws BizException {
		long startTIme1 = System.currentTimeMillis();
		long startTIme = System.currentTimeMillis();
		CiOrdUtils.getlogger().info("" + System.currentTimeMillis() + "毫秒");
		ciors=smsLisOrFilterHandle(ciors);
		if(CiOrdUtils.isEmpty(ciors))return null;
		
		List<CiLisOrSmsIoDTO> orsmsiolists=convertCiOr2CiOrSmsIoList(ciors);
		if(CiOrdUtils.isEmpty(orsmsiolists))return null;
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单查询合单数据时间  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		
		startTIme = System.currentTimeMillis();
		//合单规则编排
		orsmsiolists=ciOrSmsIoRuleArrangePluginExec(orsmsiolists);
		
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单合单规则编排  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		startTIme = System.currentTimeMillis();
       //获取注意事项
		orsmsiolists=getAnnouncements(orsmsiolists);
		
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单获取注意事项  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		startTIme = System.currentTimeMillis();
		//生成检验申请单并保存检验申请单
		genLisSheetByOrdSmsInfo(ciors,orsmsiolists, session); 
		
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单保存  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单总耗时  .." + (System.currentTimeMillis() - startTIme1) + "毫秒");
		return orsmsiolists;
	}
	
	/**
	 * 临床医嘱分方时，分方医嘱过滤与处理
	 * @param ciorder
	 * @param session
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] smsLisOrFilterHandle(CiOrderDO[] ciorder) throws BizException{
		CiOrSmsLisOrFilterHandleBP bp=new CiOrSmsLisOrFilterHandleBP();
		return bp.exec(ciorder);
	}
	
	private List<CiLisOrSmsIoDTO> convertCiOr2CiOrSmsIoList(CiOrderDO[] ciors)throws BizException {
		CiOr2CiOrSmsIoListBP bp=new CiOr2CiOrSmsIoListBP();
		return bp.exec(ciors);
	}
	
	private List<CiLisOrSmsIoDTO> ciOrSmsIoRuleArrangePluginExec(List<CiLisOrSmsIoDTO> orpressplitlists) throws BizException{
		CiLisOrSmsRuleDefaultArrangeBP bp=new CiLisOrSmsRuleDefaultArrangeBP();
		return bp.exec(orpressplitlists);
	}
	
	/**
	 * 生成处方并保存
	 * @return
	 * @throws BizException 
	 */
	private CiapplissheetAggDO[] genLisSheetByOrdSmsInfo(CiOrderDO[] ciors,List<CiLisOrSmsIoDTO> orpressplitlists,CiOrSessionDO session) throws BizException{
		CiOrSmsList2CiOrLisSheetHandleBP  bp = new CiOrSmsList2CiOrLisSheetHandleBP();
		  return bp.exec(ciors,orpressplitlists,session);
	}
	
	/**
	 * 获取注意事项
	 * @return
	 * @throws BizException 
	 */
	private List<CiLisOrSmsIoDTO> getAnnouncements(List<CiLisOrSmsIoDTO> orpressplitlists) throws BizException{
		CiLisSmsGetAnnouncementsBP  bp = new CiLisSmsGetAnnouncementsBP();
		  return bp.exec(orpressplitlists);
	}
}
