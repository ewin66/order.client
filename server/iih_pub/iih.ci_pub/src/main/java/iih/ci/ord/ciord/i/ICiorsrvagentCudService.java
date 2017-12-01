package iih.ci.ord.ciord.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱项目患者与代理人信息核对登录数据维护服务
*/
public interface ICiorsrvagentCudService {
	/**
	*  医嘱项目患者与代理人信息核对登录数据真删除
	*/
    public abstract void delete(OrSrvAgentInfoDO[] aggdos) throws BizException;
    
    /**
	*  医嘱项目患者与代理人信息核对登录数据插入保存
	*/
	public abstract OrSrvAgentInfoDO[] insert(OrSrvAgentInfoDO[] aggdos) throws BizException;
	
    /**
	*  医嘱项目患者与代理人信息核对登录数据保存
	*/
	public abstract OrSrvAgentInfoDO[] save(OrSrvAgentInfoDO[] aggdos) throws BizException;
	
    /**
	*  医嘱项目患者与代理人信息核对登录数据更新
	*/
	public abstract OrSrvAgentInfoDO[] update(OrSrvAgentInfoDO[] aggdos) throws BizException;
	
	/**
	*  医嘱项目患者与代理人信息核对登录数据逻辑删除
	*/
	public abstract void logicDelete(OrSrvAgentInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrSrvAgentInfoDO[] enableWithoutFilter(OrSrvAgentInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrSrvAgentInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrSrvAgentInfoDO[] disableVOWithoutFilter(OrSrvAgentInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrSrvAgentInfoDO[] dos) throws BizException ;
}
