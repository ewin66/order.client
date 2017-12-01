package iih.ci.ord.ciorcof.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciorcof.d.CiOrSrvVsSheet;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 组件数据维护服务
*/
public interface ISrvvssheetCudService {
	/**
	*  组件数据删除
	*/
    public abstract void delete(CiOrSrvVsSheet[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract CiOrSrvVsSheet[] insert(CiOrSrvVsSheet[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract CiOrSrvVsSheet[] save(CiOrSrvVsSheet[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract CiOrSrvVsSheet[] update(CiOrSrvVsSheet[] aggdos) throws BizException;
	
	/**
	*  组件数据真删
	*/
	public abstract void logicDelete(CiOrSrvVsSheet[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiOrSrvVsSheet[] enableWithoutFilter(CiOrSrvVsSheet[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiOrSrvVsSheet[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiOrSrvVsSheet[] disableVOWithoutFilter(CiOrSrvVsSheet[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiOrSrvVsSheet[] dos) throws BizException ;
}
