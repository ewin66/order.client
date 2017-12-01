package iih.ci.mr.cimr.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimr.d.CiMrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
import xap.wf.af.server.WfFormInfoCtx;

/**
* 临床医疗记录数据维护服务
*/
public interface ICiemrCudService {
	/**
	*  临床医疗记录数据真删除
	*/
    public abstract void delete(CiMrDO[] aggdos) throws BizException;
    
    /**
     * 
     * @param userid
     * @param aggdos
     */
    public abstract boolean deleteAndStop(String userid,WfFormInfoCtx formInfo) throws BizException;
    
    /**
	*  临床医疗记录数据插入保存
	*/
	public abstract CiMrDO[] insert(CiMrDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录数据保存
	*/
	public abstract CiMrDO[] save(CiMrDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录数据更新
	*/
	public abstract CiMrDO[] update(CiMrDO[] aggdos) throws BizException;
	
	/**
	*  临床医疗记录数据逻辑删除
	*/
	public abstract void logicDelete(CiMrDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrDO[] enableWithoutFilter(CiMrDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrDO[] disableVOWithoutFilter(CiMrDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrDO[] dos) throws BizException ;
}
