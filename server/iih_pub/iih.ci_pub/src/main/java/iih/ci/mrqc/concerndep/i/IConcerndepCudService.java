package iih.ci.mrqc.concerndep.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.concerndep.d.ConcernDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门诊质控科室关注数据维护服务
*/
public interface IConcerndepCudService {
	/**
	*  门诊质控科室关注数据真删除
	*/
    public abstract void delete(ConcernDepDO[] aggdos) throws BizException;
    
    /**
	*  门诊质控科室关注数据插入保存
	*/
	public abstract ConcernDepDO[] insert(ConcernDepDO[] aggdos) throws BizException;
	
    /**
	*  门诊质控科室关注数据保存
	*/
	public abstract ConcernDepDO[] save(ConcernDepDO[] aggdos) throws BizException;
	
    /**
	*  门诊质控科室关注数据更新
	*/
	public abstract ConcernDepDO[] update(ConcernDepDO[] aggdos) throws BizException;
	
	/**
	*  门诊质控科室关注数据逻辑删除
	*/
	public abstract void logicDelete(ConcernDepDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ConcernDepDO[] enableWithoutFilter(ConcernDepDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ConcernDepDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ConcernDepDO[] disableVOWithoutFilter(ConcernDepDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ConcernDepDO[] dos) throws BizException ;
}
