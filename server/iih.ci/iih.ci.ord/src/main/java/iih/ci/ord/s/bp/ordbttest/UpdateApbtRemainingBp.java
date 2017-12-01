package iih.ci.ord.s.bp.ordbttest;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiOrdBtTestDO;
import iih.ci.ord.cior.d.CiOrdBtTestItmDO;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiordrptbttestAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.i.ICiorappbtCudService;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.cior.i.ICiordrptbttestCudService;
import iih.ci.ord.cior.i.ICiordrptbttestRService;

public class UpdateApbtRemainingBp {

	/**
	 * 更新备血余量
	 * @return
	 * @author shao_yuan2016-08-03
	 * @throws BizException 
	 */
	public String exec(String Id_rptbttest) throws BizException
	{
		if(StringUtil.isEmpty(Id_rptbttest)){
			
			throw new BizException("参数 [Id_rptbttest]不能为空 ");
		}
		//◎ 根据申请单号查找交叉备血结果单，如果能够找到直接返回。
		CiordrptbttestAggDO cibttestAggDO = findRptBtTestByReqNo(Id_rptbttest);
		if(cibttestAggDO == null){
			
			throw new BizException("未找到交叉备血结果单");
		}
		
		//◎ 更新交叉备血结果单状态
		updaterptbtState(cibttestAggDO);
		
		//◎ 根据交叉备血结果单，获取输血总量
		int bloodnum = getBloodnum(cibttestAggDO);
		
		//◎ 根据申请单号查找备血申请单，如果能够找到直接返回。
		CiorappbtAggDO ciorappbtAggDO = findCiorappbtByReqNo(cibttestAggDO);
		if(ciorappbtAggDO == null){
			
			throw new BizException("未找到备血申请单");
		}
		
		//◎ 更新备血余量。
		updateNumbu(ciorappbtAggDO,bloodnum);
		
		//OrdBtTestSaveBp bp = new OrdBtTestSaveBp();
		//bp.exec(cibttestAggDO);
		
		return "";
	}
	/** 
	 * 更新交叉备血结果单状态。
	 * @throws BizException 
	 */
	private void updaterptbtState(CiordrptbttestAggDO cibttestAggDO) throws BizException {
		CiOrdBtTestDO ciOrdBtDO = cibttestAggDO.getParentDO();
		ciOrdBtDO.setSd_su_bttest(ICiDictCodeConst.SD_BTTEST_TJ);
		ciOrdBtDO.setStatus(DOStatus.UPDATED);
		ICiordrptbttestCudService ciorappbtRService = ServiceFinder.find(ICiordrptbttestCudService.class);
		ciorappbtRService.update(new CiordrptbttestAggDO[]{cibttestAggDO});
	}

	/** 
	 * 更新备血余量。
	 */
	private void updateNumbu(CiorappbtAggDO ciorappbtAggDO,int bloodnum) throws BizException {
		OrdApBtDO ordApBtDO = ciorappbtAggDO.getParentDO();
		ordApBtDO.setNum_margin_bu(new FDouble(bloodnum));
		ordApBtDO.setStatus(DOStatus.UPDATED);
		
		ICiorappbtCudService ciorappbtCudService = ServiceFinder.find(ICiorappbtCudService.class);
		ciorappbtCudService.update(new CiorappbtAggDO[]{ciorappbtAggDO});
	}
	/** 
	 * 根据申请单号查找备血申请单。
	 */
	private CiorappbtAggDO findCiorappbtByReqNo(CiordrptbttestAggDO cibttestAggDO) throws BizException {
		CiOrdBtTestDO ciOrdBtTestDO = cibttestAggDO.getParentDO();
		String reqNo = ciOrdBtTestDO.getNo_applyform();
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" a0.no_applyform='" + reqNo + "'");
		ICiorappbtRService ciorappbtRService = ServiceFinder.find(ICiorappbtRService.class);
		CiorappbtAggDO[] ordApObsDOs = ciorappbtRService.find(whereStr.toString(), null, FBoolean.TRUE);
		
		if (ordApObsDOs == null || ordApObsDOs.length <= 0) {
			return null;
		}
		return ordApObsDOs[0];
	}
	
	
	/** 
	 * 根据交叉备血结果单，获取输血总量。
	 */
	private int getBloodnum(CiordrptbttestAggDO cibttestAggDO) throws BizException {
		CiOrdBtTestItmDO[] ItemDos = cibttestAggDO.getCiOrdBtTestItmDO();
		int result = 0;
		for(CiOrdBtTestItmDO re: ItemDos)
		{
			result += re.getNum_bb();
		}
		return result;
	}
	
	/** 
	 * 根据申请单号获取交叉备血结果单。
	 */
	private CiordrptbttestAggDO findRptBtTestByReqNo(String Id_rptbttest) throws BizException {
		
		ICiordrptbttestRService cirptbttestRService = ServiceFinder.find(ICiordrptbttestRService.class);
		
		return cirptbttestRService.findById(Id_rptbttest);
	}
}
