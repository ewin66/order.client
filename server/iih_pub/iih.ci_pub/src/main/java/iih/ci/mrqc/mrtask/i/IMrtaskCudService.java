package iih.ci.mrqc.mrtask.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历任务数据维护服务
*/
public interface IMrtaskCudService {
	/**
	*  病历任务数据真删除
	*/
    public abstract void delete(MrTaskDO[] aggdos) throws BizException;
    
    /**
	*  病历任务数据插入保存
	*/
	public abstract MrTaskDO[] insert(MrTaskDO[] aggdos) throws BizException;
	
    /**
	*  病历任务数据保存
	*/
	public abstract MrTaskDO[] save(MrTaskDO[] aggdos) throws BizException;
	
    /**
	*  病历任务数据更新
	*/
	public abstract MrTaskDO[] update(MrTaskDO[] aggdos) throws BizException;
	
	/**
	*  病历任务数据逻辑删除
	*/
	public abstract void logicDelete(MrTaskDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrTaskDO[] enableWithoutFilter(MrTaskDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrTaskDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrTaskDO[] disableVOWithoutFilter(MrTaskDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrTaskDO[] dos) throws BizException ;
}
