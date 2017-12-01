package iih.ci.mrqc.concernemp.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.concernemp.d.ConcernEmpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门诊质控人员关注数据维护服务
*/
public interface IConcernempCudService {
	/**
	*  门诊质控人员关注数据真删除
	*/
    public abstract void delete(ConcernEmpDO[] aggdos) throws BizException;
    
    /**
	*  门诊质控人员关注数据插入保存
	*/
	public abstract ConcernEmpDO[] insert(ConcernEmpDO[] aggdos) throws BizException;
	
    /**
	*  门诊质控人员关注数据保存
	*/
	public abstract ConcernEmpDO[] save(ConcernEmpDO[] aggdos) throws BizException;
	
    /**
	*  门诊质控人员关注数据更新
	*/
	public abstract ConcernEmpDO[] update(ConcernEmpDO[] aggdos) throws BizException;
	
	/**
	*  门诊质控人员关注数据逻辑删除
	*/
	public abstract void logicDelete(ConcernEmpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ConcernEmpDO[] enableWithoutFilter(ConcernEmpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ConcernEmpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ConcernEmpDO[] disableVOWithoutFilter(ConcernEmpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ConcernEmpDO[] dos) throws BizException ;
}
