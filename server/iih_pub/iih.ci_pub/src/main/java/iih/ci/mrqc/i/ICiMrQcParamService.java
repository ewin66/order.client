package iih.ci.mrqc.i;

import xap.mw.core.data.BizException;

public interface ICiMrQcParamService {

	/**
	 * 获取门诊病历召回最大申请天数
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public abstract String GetSysParamOpRcMaxDays(String id_org) throws BizException;
	
	/**
	 * 
	 * @param id_org
	 * @return 门诊病历召回默认时间
	 * @throws BizException
	 */
	public abstract String GetSysParamOpRcDefaultDays(String id_org) throws BizException;
}
