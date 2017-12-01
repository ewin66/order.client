package iih.ci.mr.nu.obstetrics.antennurbserrec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.antennurbserrec.d.AntenNurBserRecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 产科护理观察记录（产后、术后）数据维护服务
*/
public interface IAntennurbserrecCudService {
	/**
	*  产科护理观察记录（产后、术后）数据真删除
	*/
    public abstract void delete(AntenNurBserRecDO[] aggdos) throws BizException;
    
    /**
	*  产科护理观察记录（产后、术后）数据插入保存
	*/
	public abstract AntenNurBserRecDO[] insert(AntenNurBserRecDO[] aggdos) throws BizException;
	
    /**
	*  产科护理观察记录（产后、术后）数据保存
	*/
	public abstract AntenNurBserRecDO[] save(AntenNurBserRecDO[] aggdos) throws BizException;
	
    /**
	*  产科护理观察记录（产后、术后）数据更新
	*/
	public abstract AntenNurBserRecDO[] update(AntenNurBserRecDO[] aggdos) throws BizException;
	
	/**
	*  产科护理观察记录（产后、术后）数据逻辑删除
	*/
	public abstract void logicDelete(AntenNurBserRecDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AntenNurBserRecDO[] enableWithoutFilter(AntenNurBserRecDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AntenNurBserRecDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AntenNurBserRecDO[] disableVOWithoutFilter(AntenNurBserRecDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AntenNurBserRecDO[] dos) throws BizException ;
}
