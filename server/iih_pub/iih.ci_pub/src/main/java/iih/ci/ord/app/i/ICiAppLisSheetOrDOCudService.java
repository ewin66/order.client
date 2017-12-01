package iih.ci.ord.app.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 检验申请单数据维护服务
*/
public interface ICiAppLisSheetOrDOCudService {
	/**
	*  检验申请单数据真删除
	*/
    public abstract void delete(CiAppLisSheetOrDO[] aggdos) throws BizException;
    
    /**
	*  检验申请单数据插入保存
	*/
	public abstract CiAppLisSheetOrDO[] insert(CiAppLisSheetOrDO[] aggdos) throws BizException;
	
    /**
	*  检验申请单数据保存
	*/
	public abstract CiAppLisSheetOrDO[] save(CiAppLisSheetOrDO[] aggdos) throws BizException;
	
    /**
	*  检验申请单数据更新
	*/
	public abstract CiAppLisSheetOrDO[] update(CiAppLisSheetOrDO[] aggdos) throws BizException;
	
	/**
	*  检验申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiAppLisSheetOrDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiAppLisSheetOrDO[] enableWithoutFilter(CiAppLisSheetOrDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiAppLisSheetOrDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiAppLisSheetOrDO[] disableVOWithoutFilter(CiAppLisSheetOrDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiAppLisSheetOrDO[] aggdos) throws BizException ;
	
}
