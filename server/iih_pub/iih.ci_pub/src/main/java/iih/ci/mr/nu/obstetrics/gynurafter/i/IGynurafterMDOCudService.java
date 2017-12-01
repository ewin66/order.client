package iih.ci.mr.nu.obstetrics.gynurafter.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.gynurafter.d.GyNurAfterAssDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 妇科护理记录单(术后)数据维护服务
*/
public interface IGynurafterMDOCudService {
	/**
	*  妇科护理记录单(术后)数据真删除
	*/
    public abstract void delete(GyNurAfterAssDO[] aggdos) throws BizException;
    
    /**
	*  妇科护理记录单(术后)数据插入保存
	*/
	public abstract GyNurAfterAssDO[] insert(GyNurAfterAssDO[] aggdos) throws BizException;
	
    /**
	*  妇科护理记录单(术后)数据保存
	*/
	public abstract GyNurAfterAssDO[] save(GyNurAfterAssDO[] aggdos) throws BizException;
	
    /**
	*  妇科护理记录单(术后)数据更新
	*/
	public abstract GyNurAfterAssDO[] update(GyNurAfterAssDO[] aggdos) throws BizException;
	
	/**
	*  妇科护理记录单(术后)数据逻辑删除
	*/
	public abstract void logicDelete(GyNurAfterAssDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public GyNurAfterAssDO[] enableWithoutFilter(GyNurAfterAssDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(GyNurAfterAssDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public GyNurAfterAssDO[] disableVOWithoutFilter(GyNurAfterAssDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(GyNurAfterAssDO[] aggdos) throws BizException ;
	
}
