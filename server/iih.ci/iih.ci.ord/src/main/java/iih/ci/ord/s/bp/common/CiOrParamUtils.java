package iih.ci.ord.s.bp.common;

import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 获得临床医嘱系统参数值
 */
public class CiOrParamUtils {

	/**
	 * 获得 医嘱执行流向科室处理模式及相关默认设置 组织级组参数CIOR0170
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public static String[] getCiOrExFlowDeptHandleModeInfo(String id_org, String code_entp) {
		// 参数设置
		String[] rtns = new String[2];

		// 获得医嘱执行流向科室处理模式
		rtns[0] = getCiOrExFlowDeptHandleMode(id_org);

		// 是否医嘱执行流向科室处理模式之0 流向配置模式时，直接返回
		if (isCiOrExFlowDeptHandleModeDeptFlowCfg(rtns[0]))
			return rtns;

		if (CiOrdUtils.isOpWf(code_entp)) {// 门诊
			rtns[1] = getCiOrExFlowDefaultDeptSet4Op(id_org);
		} else if (CiOrdUtils.isIpWf(code_entp)) {// 住院
			rtns[1] = getCiOrExFlowDefaultDeptSet4Ip(id_org);
		} else if (CiOrdUtils.isUrgentWf(code_entp)) {// 急诊
			rtns[1] = getCiOrExFlowDefaultDeptSet4Er(id_org);
		} else {
			// 体检 与 家床逻辑分支还有待加入进来
		}
		return rtns;
	}

	/**
	 * 是否医嘱执行流向科室处理模式之0 流向配置模式 TRUE：0 流向配置模式 FALSE：1 流向配置+模式
	 * 
	 * @param modev
	 * @return
	 */
	public static boolean isCiOrExFlowDeptHandleModeDeptFlowCfg(String modev) {
		if (ICiOrdNSysParamConst.PARAMV_CiOrExFlowDeptHandleMode_DeptFlowCfg.equals(modev))
			return true;
		return false;
	}

	/**
	 * 医嘱执行流向科室处理模式 组织级参数CIOR0170
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public static String getCiOrExFlowDeptHandleMode(String id_org) {
		try {
			String rtn = ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_CiOrExFlowDeptHandleMode);
			if (CiOrdUtils.isEmpty(rtn))
				return ICiOrdNSysParamConst.PARAMV_CiOrExFlowDeptHandleMode_DefaultV;
			return rtn;
		} catch (BizException e) {
			return ICiOrdNSysParamConst.PARAMV_CiOrExFlowDeptHandleMode_DefaultV;
		}
	}

	/**
	 * 急诊执行流向默认科室设置 组织级参数CIOR0185
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public static String getCiOrExFlowDefaultDeptSet4Er(String id_org) {
		try {
			String rtn = ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_CiOrExFlowDefaultDeptSet4Er);
			if (CiOrdUtils.isEmpty(rtn))
				return ICiOrdNSysParamConst.PARAMV_CiOrExFlowDefaultDeptSet4Er_DefaultV;
			return rtn;
		} catch (BizException e) {
			return ICiOrdNSysParamConst.PARAMV_CiOrExFlowDefaultDeptSet4Er_DefaultV;
		}
	}

	/**
	 * 住院执行流向默认科室设置 组织级参数CIOR0180
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public static String getCiOrExFlowDefaultDeptSet4Ip(String id_org) {
		try {
			String rtn = ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_CiOrExFlowDefaultDeptSet4Ip);
			if (CiOrdUtils.isEmpty(rtn))
				return ICiOrdNSysParamConst.PARAMV_CiOrExFlowDefaultDeptSet4Ip_DefaultV;
			return rtn;
		} catch (BizException e) {
			return ICiOrdNSysParamConst.PARAMV_CiOrExFlowDefaultDeptSet4Ip_DefaultV;
		}
	}

	/**
	 * 门诊执行流向默认科室设置 组织级参数CIOR0175
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public static String getCiOrExFlowDefaultDeptSet4Op(String id_org) {
		try {
			String rtn = ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_CiOrExFlowDefaultDeptSet4Op);
			if (CiOrdUtils.isEmpty(rtn))
				return ICiOrdNSysParamConst.PARAMV_CiOrExFlowDefaultDeptSet4Op_DefaultV;
			return rtn;
		} catch (BizException e) {
			return ICiOrdNSysParamConst.PARAMV_CiOrExFlowDefaultDeptSet4Op_DefaultV;
		}
	}

	/**
	 * 是否开启皮试医嘱自动生成逻辑 组织级参数CIOR0165 属于增强型参数（发生错误或未设置时返回模板级默认值TRUE）
	 * 每个参数的错误返回方式需逐条分析确定
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public static boolean IsAutoGenSkinTestOrEnable(String id_org) {
		try {
			FBoolean rtn = ParamsetQryUtil.getParaBoolean(id_org, ICiOrdNSysParamConst.SYS_PARAM_IsAutoGenSkinTestOrEnable);
			if (CiOrdUtils.isEmpty(rtn))
				return ICiOrdNSysParamConst.PARAMV_IsAutoGenSkinTestOrEnable_DefaultV;
			return rtn.booleanValue();
		} catch (BizException e) {
			return ICiOrdNSysParamConst.PARAMV_IsAutoGenSkinTestOrEnable_DefaultV;
		}
	}

	/**
	 * 无皮试结果是否可先开立用药医嘱逻辑 组织级参数CIOR0200 属于增强型参数（发生错误或未设置时返回模板级默认值TRUE）
	 * 每个参数的错误返回方式需逐条分析确定
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public static boolean IsAdmitDrugOrBeforeSkinTestRst(String id_org) {
		try {
			FBoolean rtn = ParamsetQryUtil.getParaBoolean(id_org, ICiOrdNSysParamConst.SYS_PARAM_IsAdmitDrugOrBeforeSkinTestRst);
			if (CiOrdUtils.isEmpty(rtn))
				return ICiOrdNSysParamConst.PARAMV_IsAdmitDrugOrBeforeSkinTestRst_DefaultV;
			return rtn.booleanValue();
		} catch (BizException e) {
			return ICiOrdNSysParamConst.PARAMV_IsAdmitDrugOrBeforeSkinTestRst_DefaultV;
		}
	}

	/**
	 * 医嘱费用清单数据范围设置参数 组织+部门级 CIOR0205
	 * 
	 * @param id_org
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public static String getCiOrChargeListDataRangeSet(String id_org, String id_dept) {
		try {
			// 先去部门下的参数配置
			if (!CiOrdUtils.isEmpty(id_dept)) {
				String rtn = ParamsetQryUtil.getParaString(id_dept, ICiOrdNSysParamConst.SYS_PARAM_CiOrChargeListDataRangeSet);
				if (!CiOrdUtils.isEmpty(rtn))
					return rtn;
			}
			// 部门下没有参数配置，则去组织下的参数配置
			if (!CiOrdUtils.isEmpty(id_org)) {
				String rtn = ParamsetQryUtil.getParaString(id_org, ICiOrdNSysParamConst.SYS_PARAM_CiOrChargeListDataRangeSet);
				if (!CiOrdUtils.isEmpty(rtn))
					return rtn;
			}
			// 部门与组织下都没有配置参数，则返回默认值
			return ICiOrdNSysParamConst.PARAMV_CiOrChargeListDataRangeSet_DefaultV;
		} catch (BizException e) {
			return ICiOrdNSysParamConst.PARAMV_CiOrChargeListDataRangeSet_DefaultV;
		}
	}

	/**
	 * 获得组织id
	 * 
	 * @param oragginfo
	 * @return
	 */
	public static String getOrgID(CiOrAggAndRelDatum oragginfo) {
		if (oragginfo == null)
			return null;
		if (oragginfo.getOraggdo() == null)
			return null;
		if (oragginfo.getOraggdo().getParentDO() == null)
			return null;
		return oragginfo.getOraggdo().getParentDO().getId_org();
	}

	/**
	 * 获取医嘱或服务拆分截止时间与当前时间最大允许的天数间隔
	 * 
	 * @param id_org
	 * @return
	 */
	public static Integer getOrSrvSplitDtEndMaxAllowDays(String id_org) {
		try {
			Integer rtn = ParamsetQryUtil.getParaInt(id_org, ICiOrdNSysParamConst.SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS);
			return rtn;
		} catch (BizException e) {
			return ICiOrdNSysParamConst.PARAMV_ORSRVSPLITDTENDMAXALLOWDAYS_DefaultV;
		}
	}

	/**
	 * 护士医嘱停止确认时，医嘱停止确认最大可提前时间（分钟）
	 * 
	 * @param id_org
	 * @return
	 */
	public static Integer getOrStopChkMaxLeadTime(String id_org) {
		try {
			Integer rtn = ParamsetQryUtil.getParaInt(id_org, ICiOrdNSysParamConst.SYS_PARAM_OrStopChkMaxLeadTime);
			return rtn;
		} catch (BizException e) {
			return ICiOrdNSysParamConst.PARAMV_OrStopChkMaxLeadTime_DefaultV;
		}
	}
	/**
	 * 医保共享组织级参数 是否启用
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public static FBoolean getIsOrgEnableOrDatumShared(String id_org)throws BizException{
		FBoolean rtn = ParamsetQryUtil.getParaBoolean(id_org, ICiOrdNSysParamConst.SYS_PARAM_IsOrgEnableOrDatumShared);
	     return rtn;
	}
	
	/**
	 * 医保共享 科室级参数 是否启用 默认启用 true
	 * @param id_org
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public static FBoolean getIsDeptEnableOrDatumShared(String id_org,String id_dept)throws BizException{
		FBoolean orgBoolean = getIsOrgEnableOrDatumShared(id_org);
	    if(FBoolean.TRUE== orgBoolean){
	    	FBoolean DeptBoolean = ParamsetQryUtil.getParaBoolean(id_dept,ICiOrdNSysParamConst.SYS_PARAM_IsDeptEnableOrDatumShared);
	  	   return DeptBoolean;
	    }
		return orgBoolean;
	}
	
	
	/**
	 * 医嘱模板开立医嘱的限制的设置
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public static int getOrHelperOpenOrCountLimitSet(String id_org)throws BizException{
		 int numset = ParamsetQryUtil.getParaInt(id_org,ICiOrdNSysParamConst.SYS_PARAM_OrHelperOpenOrCountLimitSet);
		 return numset;
	    }
	
	/**
	 * 医保适应症提示信息模式设置   0  医保适应症医保限制条件提示信息 ，1 医保适应症 院内限制提示信息 ，2 医保适应症 医保限制+院内限制 信息
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public static int getMedInsuranceIndicInfoModelSet(String id_org)throws BizException{
		 int numset = ParamsetQryUtil.getParaInt(id_org,ICiOrdNSysParamConst.SYS_PARAM_MedInsuranceIndicInfoModelSet);
		 return numset;
	    }
}
