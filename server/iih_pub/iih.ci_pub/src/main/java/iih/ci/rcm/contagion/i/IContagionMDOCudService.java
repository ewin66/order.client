package iih.ci.rcm.contagion.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.contagion.d.ContagionDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 传染病报告卡数据维护服务
*/
public interface IContagionMDOCudService {
	/**
	*  传染病报告卡数据真删除
	*/
    public abstract void delete(ContagionDO[] aggdos) throws BizException;
    
    /**
	*  传染病报告卡数据插入保存
	*/
	public abstract ContagionDO[] insert(ContagionDO[] aggdos) throws BizException;
	
    /**
	*  传染病报告卡数据保存
	*/
	public abstract ContagionDO[] save(ContagionDO[] aggdos) throws BizException;
	
    /**
	*  传染病报告卡数据更新
	*/
	public abstract ContagionDO[] update(ContagionDO[] aggdos) throws BizException;
	
	/**
	*  传染病报告卡数据逻辑删除
	*/
	public abstract void logicDelete(ContagionDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ContagionDO[] enableWithoutFilter(ContagionDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ContagionDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ContagionDO[] disableVOWithoutFilter(ContagionDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ContagionDO[] aggdos) throws BizException ;
	
}
