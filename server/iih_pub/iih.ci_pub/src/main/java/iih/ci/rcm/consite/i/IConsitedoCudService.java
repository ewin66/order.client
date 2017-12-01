package iih.ci.rcm.consite.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.consite.d.ConSiteDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 院感感染部位数据维护服务
*/
public interface IConsitedoCudService {
	/**
	*  院感感染部位数据真删除
	*/
    public abstract void delete(ConSiteDO[] aggdos) throws BizException;
    
    /**
	*  院感感染部位数据插入保存
	*/
	public abstract ConSiteDO[] insert(ConSiteDO[] aggdos) throws BizException;
	
    /**
	*  院感感染部位数据保存
	*/
	public abstract ConSiteDO[] save(ConSiteDO[] aggdos) throws BizException;
	
    /**
	*  院感感染部位数据更新
	*/
	public abstract ConSiteDO[] update(ConSiteDO[] aggdos) throws BizException;
	
	/**
	*  院感感染部位数据逻辑删除
	*/
	public abstract void logicDelete(ConSiteDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ConSiteDO[] enableWithoutFilter(ConSiteDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ConSiteDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ConSiteDO[] disableVOWithoutFilter(ConSiteDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ConSiteDO[] dos) throws BizException ;
}
