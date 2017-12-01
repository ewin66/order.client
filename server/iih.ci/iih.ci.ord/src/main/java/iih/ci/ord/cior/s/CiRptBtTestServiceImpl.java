package iih.ci.ord.cior.s;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import iih.ci.ord.cior.d.CiOrdBtTestDO;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiordrptbttestAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.i.ICiRptBtTestService;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.cior.i.ICiordrptbttestRService;
import iih.ci.ord.s.bp.rpt.CiReportCommBP;

public class CiRptBtTestServiceImpl implements ICiRptBtTestService {

	@Override
	public CiordrptbttestAggDO getRptBtTestByReqNo(String reqNo)
			throws BizException {
		//◎ 根据申请单号查找交叉备血结果单，如果能够找到直接返回。
		CiordrptbttestAggDO bttestAggDO = findRptBtTestByReqNo(reqNo);
		if (bttestAggDO != null) {
			return bttestAggDO;
		}
		
		//◎根据申请单号查找交叉备血申请单，如果没找到直接返回空。
		CiorappbtAggDO ciorappbtAggDO = findBtTestByReqNo(reqNo);
		if (ciorappbtAggDO == null) {
			return null;
		}
		OrdApBtDO ordApBtDO = ciorappbtAggDO.getParentDO();
		
		//◎根据交叉备血申请单信息构造交叉备血结果单并返回。
		bttestAggDO = new CiordrptbttestAggDO();
		//--------主信息
		CiOrdBtTestDO ciOrdBtTestDO = new CiOrdBtTestDO();
		bttestAggDO.setParentDO(ciOrdBtTestDO);
		//申请单号
		ciOrdBtTestDO.setNo_applyform(reqNo);
		//备血申请单主键
		ciOrdBtTestDO.setId_apbt(ordApBtDO.getId_apbt());
		//医嘱主键
		String orId = ordApBtDO.getId_or();
		ciOrdBtTestDO.setId_or(orId);
		//设置就诊Id、就诊号、患者姓名
		Map<String,Object> entInfo = CiReportCommBP.findEntInfoByOrId(orId);
		if (entInfo != null) {
			ciOrdBtTestDO.setId_ent((String)entInfo.get("id_ent"));
			ciOrdBtTestDO.setEnt_code((String)entInfo.get("ent_code"));
			ciOrdBtTestDO.setName_pat((String)entInfo.get("name_pat"));
			
			//输血服务项目及相关信息
			String srvId = (String)entInfo.get("id_srv");
			ciOrdBtTestDO.setId_srv_bt(srvId);
			Map<String,Object> orSrvInfo = CiReportCommBP.findQuanInfoByOrId(orId);
			if (orSrvInfo != null) {
				ciOrdBtTestDO.setName_bt((String)orSrvInfo.get("name_bt"));
				String quanMedu = (String)orSrvInfo.get("quan_medu");
				if (!StringUtils.isBlank(quanMedu)) {
					ciOrdBtTestDO.setQuan_medu(new FDouble(Double.parseDouble(quanMedu)));
				}
				ciOrdBtTestDO.setId_medu((String)orSrvInfo.get("id_medu"));
				ciOrdBtTestDO.setMedu_name((String)orSrvInfo.get("medu_name"));
			}
		}
		
		return bttestAggDO;
	}
	
	private CiorappbtAggDO findBtTestByReqNo(String reqNo) throws BizException {
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
	 * 根据申请单号获取交叉备血结果单。
	 */
	private CiordrptbttestAggDO findRptBtTestByReqNo(String reqNo) throws BizException {
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" a0.no_applyform='" + reqNo + "'");
		ICiordrptbttestRService cirptbttestRService = ServiceFinder.find(ICiordrptbttestRService.class);
		CiordrptbttestAggDO[] cibttestAggDOs = cirptbttestRService.find(whereStr.toString(), null, FBoolean.FALSE);
		
		if (cibttestAggDOs == null || cibttestAggDOs.length <= 0) {
			return null;
		}
		return cibttestAggDOs[0];
	}
}
