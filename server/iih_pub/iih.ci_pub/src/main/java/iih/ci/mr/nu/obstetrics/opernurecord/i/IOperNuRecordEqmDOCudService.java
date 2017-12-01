package iih.ci.mr.nu.obstetrics.opernurecord.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordEqmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 手术护理记录单数据维护服务
*/
public interface IOperNuRecordEqmDOCudService {
	/**
	*  手术护理记录单数据真删除
	*/
    public abstract void delete(OperNuRecordEqmDO[] aggdos) throws BizException;
    
    /**
	*  手术护理记录单数据插入保存
	*/
	public abstract OperNuRecordEqmDO[] insert(OperNuRecordEqmDO[] aggdos) throws BizException;
	
    /**
	*  手术护理记录单数据保存
	*/
	public abstract OperNuRecordEqmDO[] save(OperNuRecordEqmDO[] aggdos) throws BizException;
	
    /**
	*  手术护理记录单数据更新
	*/
	public abstract OperNuRecordEqmDO[] update(OperNuRecordEqmDO[] aggdos) throws BizException;
	
	/**
	*  手术护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(OperNuRecordEqmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OperNuRecordEqmDO[] enableWithoutFilter(OperNuRecordEqmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OperNuRecordEqmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OperNuRecordEqmDO[] disableVOWithoutFilter(OperNuRecordEqmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OperNuRecordEqmDO[] aggdos) throws BizException ;
	
}
