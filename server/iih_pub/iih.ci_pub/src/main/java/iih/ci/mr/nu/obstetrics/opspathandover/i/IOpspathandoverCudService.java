package iih.ci.mr.nu.obstetrics.opspathandover.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.opspathandover.d.OpsPatHandoverDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 手术病人情况交接登记单数据维护服务
*/
public interface IOpspathandoverCudService {
	/**
	*  手术病人情况交接登记单数据真删除
	*/
    public abstract void delete(OpsPatHandoverDO[] aggdos) throws BizException;
    
    /**
	*  手术病人情况交接登记单数据插入保存
	*/
	public abstract OpsPatHandoverDO[] insert(OpsPatHandoverDO[] aggdos) throws BizException;
	
    /**
	*  手术病人情况交接登记单数据保存
	*/
	public abstract OpsPatHandoverDO[] save(OpsPatHandoverDO[] aggdos) throws BizException;
	
    /**
	*  手术病人情况交接登记单数据更新
	*/
	public abstract OpsPatHandoverDO[] update(OpsPatHandoverDO[] aggdos) throws BizException;
	
	/**
	*  手术病人情况交接登记单数据逻辑删除
	*/
	public abstract void logicDelete(OpsPatHandoverDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OpsPatHandoverDO[] enableWithoutFilter(OpsPatHandoverDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OpsPatHandoverDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OpsPatHandoverDO[] disableVOWithoutFilter(OpsPatHandoverDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OpsPatHandoverDO[] dos) throws BizException ;
}
