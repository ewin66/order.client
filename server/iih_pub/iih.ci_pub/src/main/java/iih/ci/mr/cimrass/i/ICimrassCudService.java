package iih.ci.mr.cimrass.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimrass.d.CimrassDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗记录评估数据维护服务
*/
public interface ICimrassCudService {
	/**
	*  医疗记录评估数据删除
	*/
    public abstract void delete(CimrassDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录评估数据插入保存
	*/
	public abstract CimrassDO[] insert(CimrassDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录评估数据保存
	*/
	public abstract CimrassDO[] save(CimrassDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录评估数据更新
	*/
	public abstract CimrassDO[] update(CimrassDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录评估数据真删
	*/
	public abstract void logicDelete(CimrassDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CimrassDO[] enableWithoutFilter(CimrassDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CimrassDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CimrassDO[] disableVOWithoutFilter(CimrassDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CimrassDO[] dos) throws BizException ;
}
