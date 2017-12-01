package iih.ci.ord.s.checkparam;

import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.devcfg.paramset.d.ParamSetDO;
import xap.sys.devcfg.paramset.i.ICheckPara;
import xap.sys.devcfg.paramset.util.CheckParaDO;

/**
 * 医嘱最大拆分时间与最大停止确认时间参数校验
 * 
 * @author xuxing_2017-06-07
 *
 */
public class CheckOrMaxSplitParam implements ICheckPara {

	@Override
	public CheckParaDO paraBeforeSavingCheck(ParamSetDO savingdo) {

		CheckParaDO paraVO = new CheckParaDO();

		Integer maxOrSplit = CiOrParamUtils.getOrSrvSplitDtEndMaxAllowDays(savingdo.getId_org());
		Integer maxOrStopCheck = CiOrParamUtils.getOrStopChkMaxLeadTime(savingdo.getId_org());

		// 获取医嘱或服务拆分截止时间与当前时间最大允许的天数间隔
		if (ICiOrdNSysParamConst.SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS.equals(savingdo.getParamcode())) {
			maxOrSplit = Integer.parseInt(savingdo.getValue());
		}

		// 护士医嘱停止确认时，医嘱停止确认最大可提前时间（分钟）
		if (ICiOrdNSysParamConst.SYS_PARAM_OrStopChkMaxLeadTime.equals(savingdo.getParamcode())) {
			maxOrStopCheck = Integer.parseInt(savingdo.getValue());
		}

		Integer remainder = maxOrStopCheck % 1440;
		Integer days = maxOrStopCheck / 1440;
		if (remainder > 0) {
			days++;
		}

		if (days > maxOrSplit) {

			paraVO.setIsLegal(FBoolean.FALSE);
			paraVO.setErrMsg("医嘱最大拆分时间与医嘱停止确认最大可提前时间相互依赖，最大拆分时间必须大于最大可停止确认时间！");

		}

		return paraVO;
	}
}
