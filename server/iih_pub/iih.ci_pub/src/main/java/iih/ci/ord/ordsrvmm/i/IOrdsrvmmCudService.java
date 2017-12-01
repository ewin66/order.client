package iih.ci.ord.ordsrvmm.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱服务项目物品数据维护服务
*/
public interface IOrdsrvmmCudService {
	/**
	*  医嘱服务项目物品数据真删除
	*/
    public abstract void delete(OrdSrvMmDO[] aggdos) throws BizException;
    
    /**
	*  医嘱服务项目物品数据插入保存
	*/
	public abstract OrdSrvMmDO[] insert(OrdSrvMmDO[] aggdos) throws BizException;
	
    /**
	*  医嘱服务项目物品数据保存
	*/
	public abstract OrdSrvMmDO[] save(OrdSrvMmDO[] aggdos) throws BizException;
	
    /**
	*  医嘱服务项目物品数据更新
	*/
	public abstract OrdSrvMmDO[] update(OrdSrvMmDO[] aggdos) throws BizException;
	
	/**
	*  医嘱服务项目物品数据逻辑删除
	*/
	public abstract void logicDelete(OrdSrvMmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrdSrvMmDO[] enableWithoutFilter(OrdSrvMmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrdSrvMmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrdSrvMmDO[] disableVOWithoutFilter(OrdSrvMmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrdSrvMmDO[] dos) throws BizException ;
}
