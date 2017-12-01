package iih.ci.mr.nu.obstetrics.afterdeliverobsec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.AfterDeliveInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 产后观察记录数据维护服务
*/
public interface IAfterdeliverobsecMDOCudService {
	/**
	*  产后观察记录数据真删除
	*/
    public abstract void delete(AfterDeliveInfoDO[] aggdos) throws BizException;
    
    /**
	*  产后观察记录数据插入保存
	*/
	public abstract AfterDeliveInfoDO[] insert(AfterDeliveInfoDO[] aggdos) throws BizException;
	
    /**
	*  产后观察记录数据保存
	*/
	public abstract AfterDeliveInfoDO[] save(AfterDeliveInfoDO[] aggdos) throws BizException;
	
    /**
	*  产后观察记录数据更新
	*/
	public abstract AfterDeliveInfoDO[] update(AfterDeliveInfoDO[] aggdos) throws BizException;
	
	/**
	*  产后观察记录数据逻辑删除
	*/
	public abstract void logicDelete(AfterDeliveInfoDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AfterDeliveInfoDO[] enableWithoutFilter(AfterDeliveInfoDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AfterDeliveInfoDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AfterDeliveInfoDO[] disableVOWithoutFilter(AfterDeliveInfoDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AfterDeliveInfoDO[] aggdos) throws BizException ;
	
}
