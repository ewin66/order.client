package iih.ci.ord.s.bp.splitpres;

import java.util.List;

import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.cfg.CiRuleCfgExecutorBP;
import xap.mw.core.data.BizException;

/**
 * 临床医嘱分方操作BP
 */
public class CiOrPresSplitHandleBP {
	/**
	 * 临床医嘱分方
	 * @param ciors
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public List<CiOrPresSplitList> exec(CiOrderDO[] ciors, CiOrSessionDO session) throws BizException {
		//临床医嘱分方时，分方医嘱过滤与处理
		long startTime = System.currentTimeMillis();
		
		ciors = orPresSplitOrFilterHandle(ciors, session);
		if (CiOrdUtils.isEmpty(ciors))
			return null;
		
		long endTime1 = System.currentTimeMillis();
		long time1 = endTime1 - startTime;

		//分方医嘱到临床医嘱分方数据信息列表集合的转换
		List<CiOrPresSplitList> presList = convertCiOr2CiOrPresSplitList(ciors);
		
		long endTime2 = System.currentTimeMillis();
		long time2 = endTime2 - endTime1;

		
		// 重构分方逻辑
		CiRuleCfgExecutorBP executorBP = new CiRuleCfgExecutorBP();
		presList = executorBP.execSplitPres(presList);
		
		//原分方接口 获得分方规则编排插件并执行插件
		//presList = ciOrPresSplitRuleArrangePluginExec(presList);
		
		long endTime3 = System.currentTimeMillis();
		long time3 = endTime3 - endTime2;

		//生成处方并保存处方
		CiPresDO[] cipres = genPresByOrdPresSplit(presList, session);
		
		long endTime4 = System.currentTimeMillis();
		long time4 = endTime4 - endTime3;

		//临床医嘱处方分方后执行域相关处理
		ciOrPresSplitMpHandle(cipres);
		
		long endTime5 = System.currentTimeMillis();
		long time5 = endTime5 - endTime4;

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==分方1：" + time1
				+ "ms\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==分方2：" + time2
				+ "ms\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==分方3：" + time3
				+ "ms\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==分方4：" + time4
				+ "ms\n" + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==分方5：" + time5);
		
		//返回
		return presList;
	}
	
	/**
	 * 临床医嘱分方时，分方医嘱过滤与处理
	 * @param ciorder
	 * @param session
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] orPresSplitOrFilterHandle(CiOrderDO[] ciorder, CiOrSessionDO session) throws BizException {
		CiOrPresSplitOrFilterHandleBP bp = new CiOrPresSplitOrFilterHandleBP();
		return bp.exec(ciorder, session);
	}
	
	/**
	 * 分方医嘱到临床医嘱分方数据信息列表集合的转换
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	private List<CiOrPresSplitList> convertCiOr2CiOrPresSplitList(CiOrderDO[] ciors)throws BizException {
		CiOr2CiOrPresSplitListBP bp=new CiOr2CiOrPresSplitListBP();
		return bp.exec(ciors);
	}
	
	/**
	 * 生成处方并保存
	 * @return
	 * @throws BizException 
	 */
	private CiPresDO[] genPresByOrdPresSplit(List<CiOrPresSplitList> orpressplitlists,CiOrSessionDO session) throws BizException{
		CiOrPresSplitList2CiOrPresHandleBP  bp = new CiOrPresSplitList2CiOrPresHandleBP();
		  return bp.exec(orpressplitlists,session);
	}
	
	/**
	 * 临床医嘱处方分方后执行域相关处理
	 * @param cipres
	 * @throws BizException
	 */
	private void ciOrPresSplitMpHandle(CiPresDO[] cipres) throws BizException{
		CiOrPresSplitMpHandleBP bp=new CiOrPresSplitMpHandleBP();
		bp.exec(cipres);
	}
	
	/**
	 *  获得分方规则编排插件并执行编排
	 * @param orpressplitlists
	 * @return
	 * @throws BizException 
	 */
	private List<CiOrPresSplitList> ciOrPresSplitRuleArrangePluginExec(List<CiOrPresSplitList> orpressplitlists) throws BizException{
		CiOrPresSplitRuleArrangeExeBP bp=new CiOrPresSplitRuleArrangeExeBP();
		return bp.exec(orpressplitlists);
	}

}
