package iih.ci.ord.cirptlab.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.cirptlab.d.CiRptLabDO;
import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import iih.ci.ord.cirptlab.i.ICirptlabCudService;
import iih.ci.ord.dto.reportstatus.d.EnumRptTp;
import iih.ci.ord.dto.reportstatus.d.ReportStatusDTO;
import iih.ci.ord.s.bp.reportstatus.UpdateReportStatusBp;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.i.IMporInternalService;
import iih.mp.pub.IMpFunCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2016年11月18日 下午8:12:59 
 * 类说明：检验报告结果录入
 */
public class SaveCirptlabAggDOBp {

	public CirptlabAggDO exec(CirptlabAggDO cirptlabAggDOs) throws BizException {

		if (cirptlabAggDOs == null) {

			return null;

		}

		// 保存报告
		CirptlabAggDO rtn = ServiceFinder.find(ICirptlabCudService.class).save(new CirptlabAggDO[] { cirptlabAggDOs })[0];

		// 修改报告状态
		UpdateReportStatus(rtn);

		// 修改医嘱状态
		updateOrStatus(rtn);

		return rtn;
	}

	/**
	 * 更改报告状态
	 * 
	 * @param cirptlabAggDOs
	 * @throws BizException
	 */
	private void UpdateReportStatus(CirptlabAggDO cirptlabAggDOs) throws BizException {

		CiRptLabDO ciRptLabDO = cirptlabAggDOs.getParentDO();

		ReportStatusDTO dto = new ReportStatusDTO();
		dto.setId_or(ciRptLabDO.getId_or());
		dto.setRpt_status(ICiDictCodeConst.SD_CI_RPT_LAB_FBBG);
		dto.setRpt_tp(EnumRptTp.RPTLAB);

		new UpdateReportStatusBp().exec(new ReportStatusDTO[] { dto });

	}

	/**
	 * 更新医嘱状态
	 * 
	 * @param idors
	 * @throws BizException
	 */
	private void updateOrStatus(CirptlabAggDO cirptlabAggDOs) throws BizException {

		CiRptLabDO ciRptLabDO = cirptlabAggDOs.getParentDO();
		ICiorderMDORService rService = ServiceFinder.find(ICiorderMDORService.class);
		IMporInternalService internalService = ServiceFinder.find(IMporInternalService.class);
		CiOrderDO orderDO = rService.findById(ciRptLabDO.getId_or());

		OrPlanDTO planDTO = new OrPlanDTO();
		planDTO.setId_or(orderDO.getId_or());
		planDTO.setDt_mp_plan(orderDO.getDt_effe());
		planDTO.setEu_tp(1);

		internalService.updateOrpltpByOr(new OrPlanDTO[] { planDTO }, IMpFunCodeConst.FUN_CODE_MTLISRSTENTER, "");

	}

}
