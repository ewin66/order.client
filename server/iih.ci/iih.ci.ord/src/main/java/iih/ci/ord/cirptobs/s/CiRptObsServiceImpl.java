package iih.ci.ord.cirptobs.s;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.cirptobs.i.ICiRptObsService;
import iih.ci.ord.cirptobs.i.ICirptobsRService;
import iih.ci.ord.s.bp.rpt.CiReportCommBP;

public class CiRptObsServiceImpl implements ICiRptObsService {

	@Override
	public CiRptObsDO getRptObsByReqNo(String reqNo) throws BizException {
		// ◎ 根据检查申请单号查找检查报告单，如果能够找到直接返回检查报告单信息。
		CiRptObsDO ciRptObsDO = findRptObsByReqNo(reqNo);
		if (ciRptObsDO != null) {
			return ciRptObsDO;
		}

		// ◎根据检查申请单号查找检查申请单，如果没找到直接返回空。
		OrdApObsDO ordApObsDO = findRisByReqNo(reqNo);
		if (ordApObsDO == null) {
			return null;
		}

		// ◎根据检查申请单信息构造检查报告单并返回。
		ciRptObsDO = new CiRptObsDO();
		// 申请单号
		ciRptObsDO.setNo_applyform(ordApObsDO.getNo_applyform());
		// 检查申请单主键
		ciRptObsDO.setId_orobs(ordApObsDO.getId_orobs());
		// 医嘱ID
		String orId = ordApObsDO.getId_or();
		ciRptObsDO.setId_or(orId);
		// 设置就诊Id、就诊号、患者姓名
		Map<String, Object> entInfo = CiReportCommBP.findEntInfoByOrId(orId);
		if (entInfo != null) {
			ciRptObsDO.setId_ent((String) entInfo.get("id_ent"));
			ciRptObsDO.setEnt_code((String) entInfo.get("ent_code"));
			ciRptObsDO.setName_pat((String) entInfo.get("name_pat"));
		}

		return ciRptObsDO;
	}

	private OrdApObsDO findRisByReqNo(String reqNo) throws BizException {
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" a0.no_applyform='" + reqNo + "'");
		ICiorapprisRService ciorapprisRService = ServiceFinder.find(ICiorapprisRService.class);
		OrdApObsDO[] ordApObsDOs = ciorapprisRService.find(whereStr.toString(), null, FBoolean.TRUE);

		if (ordApObsDOs == null || ordApObsDOs.length <= 0) {
			return null;
		}

		if (ordApObsDOs.length > 1) {
			throw new BizException("申请单【" + reqNo + "】不唯一！");
		}

		return ordApObsDOs[0];
	}

	/**
	 * 根据检查申请单号获取检查申请单。
	 */
	private CiRptObsDO findRptObsByReqNo(String reqNo) throws BizException {
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" a0.no_applyform='" + reqNo + "'");
		ICirptobsRService cirptobsRService = ServiceFinder.find(ICirptobsRService.class);
		CiRptObsDO[] ciRptObsDOs = cirptobsRService.find(whereStr.toString(), null, FBoolean.TRUE);

		if (ciRptObsDOs == null || ciRptObsDOs.length <= 0) {
			return null;
		}
		return ciRptObsDOs[0];
	}

}
