package iih.ci.ord.app.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 病理打印申请单数据维护服务
*/
public interface ICiapppathgysheetMDOCudService {
	/**
	*  病理打印申请单数据真删除
	*/
    public abstract void delete(CiAppPathgySheetDO[] aggdos) throws BizException;
    
    /**
	*  病理打印申请单数据插入保存
	*/
	public abstract CiAppPathgySheetDO[] insert(CiAppPathgySheetDO[] aggdos) throws BizException;
	
    /**
	*  病理打印申请单数据保存
	*/
	public abstract CiAppPathgySheetDO[] save(CiAppPathgySheetDO[] aggdos) throws BizException;
	
    /**
	*  病理打印申请单数据更新
	*/
	public abstract CiAppPathgySheetDO[] update(CiAppPathgySheetDO[] aggdos) throws BizException;
	
	/**
	*  病理打印申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiAppPathgySheetDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiAppPathgySheetDO[] enableWithoutFilter(CiAppPathgySheetDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiAppPathgySheetDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiAppPathgySheetDO[] disableVOWithoutFilter(CiAppPathgySheetDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiAppPathgySheetDO[] aggdos) throws BizException ;
	
}
