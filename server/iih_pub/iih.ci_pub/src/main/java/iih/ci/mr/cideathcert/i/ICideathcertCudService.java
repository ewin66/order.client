package iih.ci.mr.cideathcert.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cideathcert.d.CideathcertDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 死亡诊断证明书数据维护服务
*/
public interface ICideathcertCudService {
	/**
	*  死亡诊断证明书数据真删除
	*/
    public abstract void delete(CideathcertDO[] aggdos) throws BizException;
    
    /**
	*  死亡诊断证明书数据插入保存
	*/
	public abstract CideathcertDO[] insert(CideathcertDO[] aggdos) throws BizException;
	
    /**
	*  死亡诊断证明书数据保存
	*/
	public abstract CideathcertDO[] save(CideathcertDO[] aggdos) throws BizException;
	
    /**
	*  死亡诊断证明书数据更新
	*/
	public abstract CideathcertDO[] update(CideathcertDO[] aggdos) throws BizException;
	
	/**
	*  死亡诊断证明书数据逻辑删除
	*/
	public abstract void logicDelete(CideathcertDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CideathcertDO[] enableWithoutFilter(CideathcertDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CideathcertDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CideathcertDO[] disableVOWithoutFilter(CideathcertDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CideathcertDO[] dos) throws BizException ;
}
