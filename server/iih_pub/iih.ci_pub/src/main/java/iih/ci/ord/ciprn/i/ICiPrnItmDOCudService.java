package iih.ci.ord.ciprn.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciprn.d.CiPrnItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 临床打印单数据维护服务
*/
public interface ICiPrnItmDOCudService {
	/**
	*  临床打印单数据真删除
	*/
    public abstract void delete(CiPrnItmDO[] aggdos) throws BizException;
    
    /**
	*  临床打印单数据插入保存
	*/
	public abstract CiPrnItmDO[] insert(CiPrnItmDO[] aggdos) throws BizException;
	
    /**
	*  临床打印单数据保存
	*/
	public abstract CiPrnItmDO[] save(CiPrnItmDO[] aggdos) throws BizException;
	
    /**
	*  临床打印单数据更新
	*/
	public abstract CiPrnItmDO[] update(CiPrnItmDO[] aggdos) throws BizException;
	
	/**
	*  临床打印单数据逻辑删除
	*/
	public abstract void logicDelete(CiPrnItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiPrnItmDO[] enableWithoutFilter(CiPrnItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiPrnItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiPrnItmDO[] disableVOWithoutFilter(CiPrnItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiPrnItmDO[] aggdos) throws BizException ;
	
}
