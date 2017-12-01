package iih.ci.mr.i;

import xap.mw.core.data.BizException;

public interface ICiMrParamService {

	/**
	 * 获取编辑器配置参数
	 * @return
	 * @throws BizException
	 */
	public abstract String GetEditorConfig(String id_org) throws BizException;
	
	/**
	 * 获取门诊病历保存时是否判断必填项标识
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getCiMrRequiredField(String id_org);
	
	/**
	 * 获取门诊病历保存时是否判断互斥项标识
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getCiMrMutexField(String id_org);
	
	/**
	 * 获取门诊病历打印时是否预览
	 * @param id_org
	 * @return
	 */
	public abstract Boolean getSysParamCiMrPrintPreView(String id_org);
}
