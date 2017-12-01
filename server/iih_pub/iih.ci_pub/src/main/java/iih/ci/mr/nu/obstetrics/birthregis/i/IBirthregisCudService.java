package iih.ci.mr.nu.obstetrics.birthregis.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.birthregis.d.BirthRegistrationDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 分娩登记薄数据维护服务
*/
public interface IBirthregisCudService {
	/**
	*  分娩登记薄数据真删除
	*/
    public abstract void delete(BirthRegistrationDO[] aggdos) throws BizException;
    
    /**
	*  分娩登记薄数据插入保存
	*/
	public abstract BirthRegistrationDO[] insert(BirthRegistrationDO[] aggdos) throws BizException;
	
    /**
	*  分娩登记薄数据保存
	*/
	public abstract BirthRegistrationDO[] save(BirthRegistrationDO[] aggdos) throws BizException;
	
    /**
	*  分娩登记薄数据更新
	*/
	public abstract BirthRegistrationDO[] update(BirthRegistrationDO[] aggdos) throws BizException;
	
	/**
	*  分娩登记薄数据逻辑删除
	*/
	public abstract void logicDelete(BirthRegistrationDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BirthRegistrationDO[] enableWithoutFilter(BirthRegistrationDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BirthRegistrationDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BirthRegistrationDO[] disableVOWithoutFilter(BirthRegistrationDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BirthRegistrationDO[] dos) throws BizException ;
}
