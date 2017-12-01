package iih.ci.mr.nu.obstetrics.adhgeneralnursingrec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.adhgeneralnursingrec.d.AdhNursingRecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 妇产科护理观察记录数据维护服务
*/
public interface IAdhgeneralnursingrecCudService {
	/**
	*  妇产科护理观察记录数据真删除
	*/
    public abstract void delete(AdhNursingRecDO[] aggdos) throws BizException;
    
    /**
	*  妇产科护理观察记录数据插入保存
	*/
	public abstract AdhNursingRecDO[] insert(AdhNursingRecDO[] aggdos) throws BizException;
	
    /**
	*  妇产科护理观察记录数据保存
	*/
	public abstract AdhNursingRecDO[] save(AdhNursingRecDO[] aggdos) throws BizException;
	
    /**
	*  妇产科护理观察记录数据更新
	*/
	public abstract AdhNursingRecDO[] update(AdhNursingRecDO[] aggdos) throws BizException;
	
	/**
	*  妇产科护理观察记录数据逻辑删除
	*/
	public abstract void logicDelete(AdhNursingRecDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AdhNursingRecDO[] enableWithoutFilter(AdhNursingRecDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AdhNursingRecDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AdhNursingRecDO[] disableVOWithoutFilter(AdhNursingRecDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AdhNursingRecDO[] dos) throws BizException ;
}
