package iih.ci.mr.nu.obstetrics.operationnurvisit.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.operationnurvisit.d.OperationNurVisitDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 手术患者术前术后护理访视表数据维护服务
*/
public interface IOperationnurvisitCudService {
	/**
	*  手术患者术前术后护理访视表数据真删除
	*/
    public abstract void delete(OperationNurVisitDO[] aggdos) throws BizException;
    
    /**
	*  手术患者术前术后护理访视表数据插入保存
	*/
	public abstract OperationNurVisitDO[] insert(OperationNurVisitDO[] aggdos) throws BizException;
	
    /**
	*  手术患者术前术后护理访视表数据保存
	*/
	public abstract OperationNurVisitDO[] save(OperationNurVisitDO[] aggdos) throws BizException;
	
    /**
	*  手术患者术前术后护理访视表数据更新
	*/
	public abstract OperationNurVisitDO[] update(OperationNurVisitDO[] aggdos) throws BizException;
	
	/**
	*  手术患者术前术后护理访视表数据逻辑删除
	*/
	public abstract void logicDelete(OperationNurVisitDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OperationNurVisitDO[] enableWithoutFilter(OperationNurVisitDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OperationNurVisitDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OperationNurVisitDO[] disableVOWithoutFilter(OperationNurVisitDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OperationNurVisitDO[] dos) throws BizException ;
}
