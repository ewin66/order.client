package iih.ci.ord.app.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.app.d.CiAppPathgySheetSampDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 病理打印申请单数据维护服务
*/
public interface ICiAppPathgySheetSampDOCudService {
	/**
	*  病理打印申请单数据真删除
	*/
    public abstract void delete(CiAppPathgySheetSampDO[] aggdos) throws BizException;
    
    /**
	*  病理打印申请单数据插入保存
	*/
	public abstract CiAppPathgySheetSampDO[] insert(CiAppPathgySheetSampDO[] aggdos) throws BizException;
	
    /**
	*  病理打印申请单数据保存
	*/
	public abstract CiAppPathgySheetSampDO[] save(CiAppPathgySheetSampDO[] aggdos) throws BizException;
	
    /**
	*  病理打印申请单数据更新
	*/
	public abstract CiAppPathgySheetSampDO[] update(CiAppPathgySheetSampDO[] aggdos) throws BizException;
	
	/**
	*  病理打印申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiAppPathgySheetSampDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiAppPathgySheetSampDO[] enableWithoutFilter(CiAppPathgySheetSampDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiAppPathgySheetSampDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiAppPathgySheetSampDO[] disableVOWithoutFilter(CiAppPathgySheetSampDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiAppPathgySheetSampDO[] aggdos) throws BizException ;
	
}
