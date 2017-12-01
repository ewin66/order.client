package iih.ci.ord.cirptpathgy.s;

import java.util.Map;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.i.ICiorapppathgyRService;
import iih.ci.ord.cirptpathgy.d.CiRptPathgyDO;
import iih.ci.ord.cirptpathgy.i.ICiRptPathgyService;
import iih.ci.ord.cirptpathgy.i.ICirptpathgyRService;
import iih.ci.ord.s.bp.rpt.CiReportCommBP;
@Service(serviceInterfaces={ICiRptPathgyService.class}, binding=Binding.JSONRPC)
public class CiRptPathgyServiceImpl  implements ICiRptPathgyService{

	@Override
	public CiRptPathgyDO getRptPathgyByReqNo(CiRptPathgyDO ciRptPathgy) throws BizException {
		//◎ 根据检查申请单号查找检查报告单，如果能够找到直接返回检查报告单信息。
		CiRptPathgyDO ciRptDO = findRptObsByReqNo(ciRptPathgy.getNo_applyform());
		if (ciRptDO != null) {
			return ciRptDO;
		}
				
		//◎根据检查申请单号查找检查申请单，如果没找到直接返回空。
		OrdApPathgyDO ordApObsDO = findRisByReqNo(ciRptPathgy.getNo_applyform());
		if (ordApObsDO == null) {
			return null;
		}
				
		//◎根据检查申请单信息构造检查报告单并返回。
		ciRptDO = new CiRptPathgyDO();
		//申请单号
		ciRptDO.setNo_applyform(ordApObsDO.getNo_applyform());
		//检查申请单主键
		ciRptDO.setId_appathgy(ordApObsDO.getId_appathgy());
		//医嘱ID
		String orId = ordApObsDO.getId_or();
		ciRptDO.setId_or(orId);
		//设置就诊Id、就诊号、患者姓名
		Map<String,Object> entInfo = CiReportCommBP.findEntInfoByOrId(orId);
		if (entInfo != null) {
			ciRptDO.setId_ent((String)entInfo.get("id_ent"));
			ciRptDO.setEnt_code((String)entInfo.get("ent_code"));
			ciRptDO.setName_pat((String)entInfo.get("name_pat"));
			ciRptDO.setDt_effe(ciRptPathgy.getDt_effe());
			ciRptDO.setSex_name(ciRptPathgy.getSex_name());
			ciRptDO.setPsn_name(ciRptPathgy.getPsn_name());
			ciRptDO.setName_or(ciRptPathgy.getName_or());
		}
				 
		return ciRptDO;
	}
	
	/** 
	 * 根据病理申请单号获取检查申请单。
	 */
	private OrdApPathgyDO findRisByReqNo(String reqNo) throws BizException {
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" a0.no_applyform='" + reqNo + "'");
		ICiorapppathgyRService cirptobsRService = ServiceFinder.find(ICiorapppathgyRService.class);
		CiorapppathgyAggDO[] ciRptObsDOs = cirptobsRService.find(whereStr.toString(), null, FBoolean.TRUE);
		
		if (ciRptObsDOs == null || ciRptObsDOs.length <= 0) {
			return null;
		}
		OrdApPathgyDO ordApPathgyDO = ciRptObsDOs[0].getParentDO();
		return ordApPathgyDO;
	}
	
	private CiRptPathgyDO findRptObsByReqNo(String reqNo) throws BizException {
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" a0.no_applyform='" + reqNo + "'");
		ICirptpathgyRService cirptobsRService = ServiceFinder.find(ICirptpathgyRService.class);
		CiRptPathgyDO[] ciRptDOs = cirptobsRService.find(whereStr.toString(), null, FBoolean.TRUE);
		
		if (ciRptDOs == null || ciRptDOs.length <= 0) {
			return null;
		}
		return ciRptDOs[0];
	}

}
