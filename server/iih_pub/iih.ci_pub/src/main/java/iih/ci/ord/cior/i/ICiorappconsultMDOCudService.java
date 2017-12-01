package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.OrdApConsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 会诊申请单数据维护服务
*/
public interface ICiorappconsultMDOCudService {
	/**
	*  会诊申请单数据真删除
	*/
    public abstract void delete(OrdApConsDO[] aggdos) throws BizException;
    
    /**
	*  会诊申请单数据插入保存
	*/
	public abstract OrdApConsDO[] insert(OrdApConsDO[] aggdos) throws BizException;
	
    /**
	*  会诊申请单数据保存
	*/
	public abstract OrdApConsDO[] save(OrdApConsDO[] aggdos) throws BizException;
	
    /**
	*  会诊申请单数据更新
	*/
	public abstract OrdApConsDO[] update(OrdApConsDO[] aggdos) throws BizException;
	
	/**
	*  会诊申请单数据逻辑删除
	*/
	public abstract void logicDelete(OrdApConsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrdApConsDO[] enableWithoutFilter(OrdApConsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrdApConsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrdApConsDO[] disableVOWithoutFilter(OrdApConsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrdApConsDO[] aggdos) throws BizException ;
	
}
