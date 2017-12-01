package iih.ci.ciet.cievent.i;

import xap.mw.core.data.BizException;
import iih.ci.ciet.cievent.d.CiEventDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 临床事件数据维护服务
*/
public interface ICieventCudService {
	/**
	*  临床事件数据删除
	*/
    public abstract void delete(CiEventDO[] aggdos) throws BizException;
    
    /**
	*  临床事件数据插入保存
	*/
	public abstract CiEventDO[] insert(CiEventDO[] aggdos) throws BizException;
	
    /**
	*  临床事件数据保存
	*/
	public abstract CiEventDO[] save(CiEventDO[] aggdos) throws BizException;
	
    /**
	*  临床事件数据更新
	*/
	public abstract CiEventDO[] update(CiEventDO[] aggdos) throws BizException;
	
	/**
	*  临床事件数据真删
	*/
	public abstract void logicDelete(CiEventDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiEventDO[] enableWithoutFilter(CiEventDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiEventDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiEventDO[] disableVOWithoutFilter(CiEventDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiEventDO[] dos) throws BizException ;
}
