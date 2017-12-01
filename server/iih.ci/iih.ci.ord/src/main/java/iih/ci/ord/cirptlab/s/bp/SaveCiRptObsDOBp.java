package iih.ci.ord.cirptlab.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.cirptobs.i.ICirptobsCudService;
import iih.ci.ord.dto.reportstatus.d.EnumRptTp;
import iih.ci.ord.dto.reportstatus.d.ReportStatusDTO;
import iih.ci.ord.s.bp.reportstatus.UpdateReportStatusBp;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.i.IMporInternalService;
import iih.mp.pub.IMpFunCodeConst;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2016年11月18日 下午8:08:22 
 * 类说明：检查报告结果录入
 */
public class SaveCiRptObsDOBp {

	public CiRptObsDO[] exec(CiRptObsDO[] ciRptObsDOs) throws BizException {

		if (ciRptObsDOs == null || ciRptObsDOs.length == 0) {
			return null;
		}

		// 保存报告
		CiRptObsDO[] rtn = ServiceFinder.find(ICirptobsCudService.class).save(ciRptObsDOs);

		// 修改报告状态
		UpdateReportStatus(rtn);
		
		// 获取医嘱ID集合
		String[] idors = getIdors(ciRptObsDOs);

		// 修改医嘱状态
		updateOrStatus(idors);
		

		return rtn;
	}

	/**
	 * 更改报告状态
	 * 
	 * @param cirptlabAggDOs
	 * @throws BizException
	 */
	private void UpdateReportStatus(CiRptObsDO[] ciRptObsDOs) throws BizException {

		ReportStatusDTO[] reportStatusDTOs = new ReportStatusDTO[ciRptObsDOs.length];

		for (int i = 0; i < ciRptObsDOs.length; i++) {

			ReportStatusDTO dto = new ReportStatusDTO();
			dto.setId_or(ciRptObsDOs[i].getId_or());
			dto.setRpt_status(ICiDictCodeConst.SD_SU_OBSRPT_FINALDEPLOY);
			dto.setRpt_tp(EnumRptTp.RPTOBS);
			reportStatusDTOs[i] = dto;
		}

		new UpdateReportStatusBp().exec(reportStatusDTOs);

	}

	/**
	 * 获取医嘱ID
	 * @param ciRptObsDOs
	 * @return
	 */
	private String[] getIdors(CiRptObsDO[] ciRptObsDOs) {

		String[] idors = new String[ciRptObsDOs.length];

		for (int i = 0; i < ciRptObsDOs.length; i++) {

			idors[i] = ciRptObsDOs[i].getId_or();

		}

		return idors;
	}

	/**
	 * 更新医嘱状态
	 * @param idors
	 * @throws BizException
	 */
	private void updateOrStatus(String[] idors) throws BizException {

		ICiorderMDORService rService = ServiceFinder.find(ICiorderMDORService.class);
		IMporInternalService internalService = ServiceFinder.find(IMporInternalService.class);
		CiOrderDO[] orderDOs=rService.findByBIds(idors, FBoolean.FALSE);
	
		OrPlanDTO[] planDTOs = new OrPlanDTO[orderDOs.length];
		int i=0;
		for (CiOrderDO ciOrderDO : orderDOs) {
			OrPlanDTO planDTO = new OrPlanDTO();
			planDTO.setId_or(ciOrderDO.getId_or());
			planDTO.setDt_mp_plan(ciOrderDO.getDt_effe());
			planDTO.setEu_tp(1);
			planDTOs[i] = planDTO;
			i++;
		}
		internalService.updateOrpltpByOr(planDTOs, IMpFunCodeConst.FUN_CODE_MTRISRSTENTER, "");
		
	}

}
