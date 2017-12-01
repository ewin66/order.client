package iih.ci.mrqc.cimrrecall.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.cimrrecall.d.CiMrRecallDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历召回申请数据维护服务
*/
public interface ICimrrecallCudService {
	/**
	*  病历召回申请数据真删除
	*/
    public abstract void delete(CiMrRecallDO[] aggdos) throws BizException;
    
    /**
	*  病历召回申请数据插入保存
	*/
	public abstract CiMrRecallDO[] insert(CiMrRecallDO[] aggdos) throws BizException;
	
    /**
	*  病历召回申请数据保存
	*/
	public abstract CiMrRecallDO[] save(CiMrRecallDO[] aggdos) throws BizException;
	
    /**
	*  病历召回申请数据更新
	*/
	public abstract CiMrRecallDO[] update(CiMrRecallDO[] aggdos) throws BizException;
	
	/**
	*  病历召回申请数据逻辑删除
	*/
	public abstract void logicDelete(CiMrRecallDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrRecallDO[] enableWithoutFilter(CiMrRecallDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrRecallDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrRecallDO[] disableVOWithoutFilter(CiMrRecallDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrRecallDO[] dos) throws BizException ;
}
