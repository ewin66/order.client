package iih.ci.mr.nu.adl.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.adl.d.ADLDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* ADL指数评估数据维护服务
*/
public interface IAdlCudService {
	/**
	*  ADL指数评估数据真删除
	*/
    public abstract void delete(ADLDO[] aggdos) throws BizException;
    
    /**
	*  ADL指数评估数据插入保存
	*/
	public abstract ADLDO[] insert(ADLDO[] aggdos) throws BizException;
	
    /**
	*  ADL指数评估数据保存
	*/
	public abstract ADLDO[] save(ADLDO[] aggdos) throws BizException;
	
    /**
	*  ADL指数评估数据更新
	*/
	public abstract ADLDO[] update(ADLDO[] aggdos) throws BizException;
	
	/**
	*  ADL指数评估数据逻辑删除
	*/
	public abstract void logicDelete(ADLDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ADLDO[] enableWithoutFilter(ADLDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ADLDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ADLDO[] disableVOWithoutFilter(ADLDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ADLDO[] dos) throws BizException ;
}
