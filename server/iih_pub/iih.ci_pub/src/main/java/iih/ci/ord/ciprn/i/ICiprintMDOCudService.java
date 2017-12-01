package iih.ci.ord.ciprn.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciprn.d.CiPrnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 临床打印单数据维护服务
*/
public interface ICiprintMDOCudService {
	/**
	*  临床打印单数据真删除
	*/
    public abstract void delete(CiPrnDO[] aggdos) throws BizException;
    
    /**
	*  临床打印单数据插入保存
	*/
	public abstract CiPrnDO[] insert(CiPrnDO[] aggdos) throws BizException;
	
    /**
	*  临床打印单数据保存
	*/
	public abstract CiPrnDO[] save(CiPrnDO[] aggdos) throws BizException;
	
    /**
	*  临床打印单数据更新
	*/
	public abstract CiPrnDO[] update(CiPrnDO[] aggdos) throws BizException;
	
	/**
	*  临床打印单数据逻辑删除
	*/
	public abstract void logicDelete(CiPrnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiPrnDO[] enableWithoutFilter(CiPrnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiPrnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiPrnDO[] disableVOWithoutFilter(CiPrnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiPrnDO[] aggdos) throws BizException ;
	
}
