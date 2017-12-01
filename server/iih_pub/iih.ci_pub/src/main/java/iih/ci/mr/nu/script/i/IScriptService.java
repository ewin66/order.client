package iih.ci.mr.nu.script.i;

import xap.mw.core.data.BizException;

/**
 * 脚本服务接口
 * 
 * @author hao_wu
 *
 */
public interface IScriptService {
	/**
	 * 编译脚本
	 * 
	 * @param billFormId
	 *            表单模板id
	 * @return 返回信息
	 * @throws BizException
	 */
	public abstract String compileScript(String billFormId) throws BizException;
}
