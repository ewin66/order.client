package iih.ci.ord.ordmp.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ordmp.d.CimpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱关键执行事件及状态数据维护服务
*/
public interface IOrdmpCudService {
	/**
	*  医嘱关键执行事件及状态数据真删除
	*/
    public abstract void delete(CimpDO[] aggdos) throws BizException;
    
    /**
	*  医嘱关键执行事件及状态数据插入保存
	*/
	public abstract CimpDO[] insert(CimpDO[] aggdos) throws BizException;
	
    /**
	*  医嘱关键执行事件及状态数据保存
	*/
	public abstract CimpDO[] save(CimpDO[] aggdos) throws BizException;
	
    /**
	*  医嘱关键执行事件及状态数据更新
	*/
	public abstract CimpDO[] update(CimpDO[] aggdos) throws BizException;
	
	/**
	*  医嘱关键执行事件及状态数据逻辑删除
	*/
	public abstract void logicDelete(CimpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CimpDO[] enableWithoutFilter(CimpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CimpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CimpDO[] disableVOWithoutFilter(CimpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CimpDO[] dos) throws BizException ;
}
