package iih.ci.ord.ciorsrvhp.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciorsrvhp.d.CiOrSrvHpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱项目的医保信息数据维护服务
*/
public interface ICiorsrvhpCudService {
	/**
	*  医嘱项目的医保信息数据真删除
	*/
    public abstract void delete(CiOrSrvHpDO[] aggdos) throws BizException;
    
    /**
	*  医嘱项目的医保信息数据插入保存
	*/
	public abstract CiOrSrvHpDO[] insert(CiOrSrvHpDO[] aggdos) throws BizException;
	
    /**
	*  医嘱项目的医保信息数据保存
	*/
	public abstract CiOrSrvHpDO[] save(CiOrSrvHpDO[] aggdos) throws BizException;
	
    /**
	*  医嘱项目的医保信息数据更新
	*/
	public abstract CiOrSrvHpDO[] update(CiOrSrvHpDO[] aggdos) throws BizException;
	
	/**
	*  医嘱项目的医保信息数据逻辑删除
	*/
	public abstract void logicDelete(CiOrSrvHpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiOrSrvHpDO[] enableWithoutFilter(CiOrSrvHpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiOrSrvHpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiOrSrvHpDO[] disableVOWithoutFilter(CiOrSrvHpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiOrSrvHpDO[] dos) throws BizException ;
}
