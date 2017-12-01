package iih.ci.mr.nu.obstetrics.opersafechecktab.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.opersafechecktab.d.OperSafeCheckTableDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 手术安全核查表数据维护服务
*/
public interface IOpersafechecktabCudService {
	/**
	*  手术安全核查表数据真删除
	*/
    public abstract void delete(OperSafeCheckTableDO[] aggdos) throws BizException;
    
    /**
	*  手术安全核查表数据插入保存
	*/
	public abstract OperSafeCheckTableDO[] insert(OperSafeCheckTableDO[] aggdos) throws BizException;
	
    /**
	*  手术安全核查表数据保存
	*/
	public abstract OperSafeCheckTableDO[] save(OperSafeCheckTableDO[] aggdos) throws BizException;
	
    /**
	*  手术安全核查表数据更新
	*/
	public abstract OperSafeCheckTableDO[] update(OperSafeCheckTableDO[] aggdos) throws BizException;
	
	/**
	*  手术安全核查表数据逻辑删除
	*/
	public abstract void logicDelete(OperSafeCheckTableDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OperSafeCheckTableDO[] enableWithoutFilter(OperSafeCheckTableDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OperSafeCheckTableDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OperSafeCheckTableDO[] disableVOWithoutFilter(OperSafeCheckTableDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OperSafeCheckTableDO[] dos) throws BizException ;
}
