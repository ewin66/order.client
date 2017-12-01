package iih.ci.mr.cimrfs.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 临床医疗记录流数据数据维护服务
*/
public interface ICimrfsCudService {
	/**
	*  临床医疗记录流数据数据删除
	*/
    public abstract void delete(CiMrFsDO[] aggdos) throws BizException;
    
    /**
	*  临床医疗记录流数据数据插入保存
	*/
	public abstract CiMrFsDO[] insert(CiMrFsDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录流数据数据保存
	*/
	public abstract CiMrFsDO[] save(CiMrFsDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录流数据数据更新
	*/
	public abstract CiMrFsDO[] update(CiMrFsDO[] aggdos) throws BizException;
	
	/**
	*  临床医疗记录流数据数据真删
	*/
	public abstract void logicDelete(CiMrFsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrFsDO[] enableWithoutFilter(CiMrFsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrFsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrFsDO[] disableVOWithoutFilter(CiMrFsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrFsDO[] aggdos) throws BizException ;
}
