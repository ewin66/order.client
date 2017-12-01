package iih.ci.ord.pres.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.pres.d.CiPresDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 药品处方数据维护服务
*/
public interface IPresCudService {
	/**
	*  药品处方数据真删除
	*/
    public abstract void delete(CiPresDO[] aggdos) throws BizException;
    
    /**
	*  药品处方数据插入保存
	*/
	public abstract CiPresDO[] insert(CiPresDO[] aggdos) throws BizException;
	
    /**
	*  药品处方数据保存
	*/
	public abstract CiPresDO[] save(CiPresDO[] aggdos) throws BizException;
	
    /**
	*  药品处方数据更新
	*/
	public abstract CiPresDO[] update(CiPresDO[] aggdos) throws BizException;
	
	/**
	*  药品处方数据逻辑删除
	*/
	public abstract void logicDelete(CiPresDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiPresDO[] enableWithoutFilter(CiPresDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiPresDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiPresDO[] disableVOWithoutFilter(CiPresDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiPresDO[] dos) throws BizException ;
}
