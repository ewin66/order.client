package iih.ci.ord.ordsrvset.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱服务服务套数据维护服务
*/
public interface IOrdsrvsetCudService {
	/**
	*  医嘱服务服务套数据删除
	*/
    public abstract void delete(OrdSrvSetDO[] aggdos) throws BizException;
    
    /**
	*  医嘱服务服务套数据插入保存
	*/
	public abstract OrdSrvSetDO[] insert(OrdSrvSetDO[] aggdos) throws BizException;
	
    /**
	*  医嘱服务服务套数据保存
	*/
	public abstract OrdSrvSetDO[] save(OrdSrvSetDO[] aggdos) throws BizException;
	
    /**
	*  医嘱服务服务套数据更新
	*/
	public abstract OrdSrvSetDO[] update(OrdSrvSetDO[] aggdos) throws BizException;
	
	/**
	*  医嘱服务服务套数据真删
	*/
	public abstract void logicDelete(OrdSrvSetDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrdSrvSetDO[] enableWithoutFilter(OrdSrvSetDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrdSrvSetDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrdSrvSetDO[] disableVOWithoutFilter(OrdSrvSetDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrdSrvSetDO[] aggdos) throws BizException ;
}
