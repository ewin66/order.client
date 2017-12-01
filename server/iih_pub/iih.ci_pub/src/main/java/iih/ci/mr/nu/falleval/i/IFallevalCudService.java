package iih.ci.mr.nu.falleval.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.falleval.d.FallEvalDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 跌倒评估表数据维护服务
*/
public interface IFallevalCudService {
	/**
	*  跌倒评估表数据真删除
	*/
    public abstract void delete(FallEvalDO[] aggdos) throws BizException;
    
    /**
	*  跌倒评估表数据插入保存
	*/
	public abstract FallEvalDO[] insert(FallEvalDO[] aggdos) throws BizException;
	
    /**
	*  跌倒评估表数据保存
	*/
	public abstract FallEvalDO[] save(FallEvalDO[] aggdos) throws BizException;
	
    /**
	*  跌倒评估表数据更新
	*/
	public abstract FallEvalDO[] update(FallEvalDO[] aggdos) throws BizException;
	
	/**
	*  跌倒评估表数据逻辑删除
	*/
	public abstract void logicDelete(FallEvalDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public FallEvalDO[] enableWithoutFilter(FallEvalDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(FallEvalDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public FallEvalDO[] disableVOWithoutFilter(FallEvalDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(FallEvalDO[] dos) throws BizException ;
}
