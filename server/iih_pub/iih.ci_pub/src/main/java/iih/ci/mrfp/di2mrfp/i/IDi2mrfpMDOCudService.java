package iih.ci.mrfp.di2mrfp.i;

import xap.mw.core.data.BizException;
import iih.ci.mrfp.di2mrfp.d.CiMrfpDiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 住院病案首页_诊断数据维护服务
*/
public interface IDi2mrfpMDOCudService {
	/**
	*  住院病案首页_诊断数据真删除
	*/
    public abstract void delete(CiMrfpDiDO[] aggdos) throws BizException;
    
    /**
	*  住院病案首页_诊断数据插入保存
	*/
	public abstract CiMrfpDiDO[] insert(CiMrfpDiDO[] aggdos) throws BizException;
	
    /**
	*  住院病案首页_诊断数据保存
	*/
	public abstract CiMrfpDiDO[] save(CiMrfpDiDO[] aggdos) throws BizException;
	
    /**
	*  住院病案首页_诊断数据更新
	*/
	public abstract CiMrfpDiDO[] update(CiMrfpDiDO[] aggdos) throws BizException;
	
	/**
	*  住院病案首页_诊断数据逻辑删除
	*/
	public abstract void logicDelete(CiMrfpDiDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrfpDiDO[] enableWithoutFilter(CiMrfpDiDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrfpDiDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrfpDiDO[] disableVOWithoutFilter(CiMrfpDiDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrfpDiDO[] aggdos) throws BizException ;
	
}
