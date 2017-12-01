package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.RptOpEmpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医嘱手术记录数据维护服务
*/
public interface IRptOpEmpDOCudService {
	/**
	*  医嘱手术记录数据删除
	*/
    public abstract void delete(RptOpEmpDO[] aggdos) throws BizException;
    
    /**
	*  医嘱手术记录数据插入保存
	*/
	public abstract RptOpEmpDO[] insert(RptOpEmpDO[] aggdos) throws BizException;
	
    /**
	*  医嘱手术记录数据保存
	*/
	public abstract RptOpEmpDO[] save(RptOpEmpDO[] aggdos) throws BizException;
	
    /**
	*  医嘱手术记录数据更新
	*/
	public abstract RptOpEmpDO[] update(RptOpEmpDO[] aggdos) throws BizException;
	
	/**
	*  医嘱手术记录数据真删
	*/
	public abstract void logicDelete(RptOpEmpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public RptOpEmpDO[] enableWithoutFilter(RptOpEmpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(RptOpEmpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public RptOpEmpDO[] disableVOWithoutFilter(RptOpEmpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(RptOpEmpDO[] aggdos) throws BizException ;
	
}
