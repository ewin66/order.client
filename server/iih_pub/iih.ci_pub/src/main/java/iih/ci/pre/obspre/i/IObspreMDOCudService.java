package iih.ci.pre.obspre.i;

import xap.mw.core.data.BizException;
import iih.ci.pre.obspre.d.ObsPreDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 预检数据维护服务
*/
public interface IObspreMDOCudService {
	/**
	*  预检数据删除
	*/
    public abstract void delete(ObsPreDO[] aggdos) throws BizException;
    
    /**
	*  预检数据插入保存
	*/
	public abstract ObsPreDO[] insert(ObsPreDO[] aggdos) throws BizException;
	
    /**
	*  预检数据保存
	*/
	public abstract ObsPreDO[] save(ObsPreDO[] aggdos) throws BizException;
	
    /**
	*  预检数据更新
	*/
	public abstract ObsPreDO[] update(ObsPreDO[] aggdos) throws BizException;
	
	/**
	*  预检数据真删
	*/
	public abstract void logicDelete(ObsPreDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ObsPreDO[] enableWithoutFilter(ObsPreDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ObsPreDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ObsPreDO[] disableVOWithoutFilter(ObsPreDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ObsPreDO[] aggdos) throws BizException ;
	
}
