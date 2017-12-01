package iih.ci.mrfp.pat2mrfp.i;

import xap.mw.core.data.BizException;
import iih.ci.mrfp.pat2mrfp.d.CiMrFpPatDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病案首页患者信息数据维护服务
*/
public interface IPat2mrfpCudService {
	/**
	*  病案首页患者信息数据真删除
	*/
    public abstract void delete(CiMrFpPatDO[] aggdos) throws BizException;
    
    /**
	*  病案首页患者信息数据插入保存
	*/
	public abstract CiMrFpPatDO[] insert(CiMrFpPatDO[] aggdos) throws BizException;
	
    /**
	*  病案首页患者信息数据保存
	*/
	public abstract CiMrFpPatDO[] save(CiMrFpPatDO[] aggdos) throws BizException;
	
    /**
	*  病案首页患者信息数据更新
	*/
	public abstract CiMrFpPatDO[] update(CiMrFpPatDO[] aggdos) throws BizException;
	
	/**
	*  病案首页患者信息数据逻辑删除
	*/
	public abstract void logicDelete(CiMrFpPatDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrFpPatDO[] enableWithoutFilter(CiMrFpPatDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrFpPatDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrFpPatDO[] disableVOWithoutFilter(CiMrFpPatDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrFpPatDO[] dos) throws BizException ;
}
