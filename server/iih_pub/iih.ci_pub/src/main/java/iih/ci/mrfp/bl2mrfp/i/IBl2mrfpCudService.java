package iih.ci.mrfp.bl2mrfp.i;

import xap.mw.core.data.BizException;
import iih.ci.mrfp.bl2mrfp.d.CiMrFpBlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 组件数据维护服务
*/
public interface IBl2mrfpCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(CiMrFpBlDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract CiMrFpBlDO[] insert(CiMrFpBlDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract CiMrFpBlDO[] save(CiMrFpBlDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract CiMrFpBlDO[] update(CiMrFpBlDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(CiMrFpBlDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrFpBlDO[] enableWithoutFilter(CiMrFpBlDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrFpBlDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrFpBlDO[] disableVOWithoutFilter(CiMrFpBlDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrFpBlDO[] dos) throws BizException ;
}
