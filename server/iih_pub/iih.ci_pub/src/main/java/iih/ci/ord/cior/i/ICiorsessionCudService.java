package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.CiOrSessionDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 门诊医嘱开立区间数据维护服务
*/
public interface ICiorsessionCudService {
	/**
	*  门诊医嘱开立区间数据删除
	*/
    public abstract void delete(CiOrSessionDO[] aggdos) throws BizException;
    
    /**
	*  门诊医嘱开立区间数据插入保存
	*/
	public abstract CiOrSessionDO[] insert(CiOrSessionDO[] aggdos) throws BizException;
	
    /**
	*  门诊医嘱开立区间数据保存
	*/
	public abstract CiOrSessionDO[] save(CiOrSessionDO[] aggdos) throws BizException;
	
    /**
	*  门诊医嘱开立区间数据更新
	*/
	public abstract CiOrSessionDO[] update(CiOrSessionDO[] aggdos) throws BizException;
	
	/**
	*  门诊医嘱开立区间数据真删
	*/
	public abstract void logicDelete(CiOrSessionDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiOrSessionDO[] enableWithoutFilter(CiOrSessionDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiOrSessionDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiOrSessionDO[] disableVOWithoutFilter(CiOrSessionDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiOrSessionDO[] dos) throws BizException ;
}
