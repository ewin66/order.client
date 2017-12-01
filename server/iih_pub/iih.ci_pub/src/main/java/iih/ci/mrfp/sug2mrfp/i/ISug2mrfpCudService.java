package iih.ci.mrfp.sug2mrfp.i;

import xap.mw.core.data.BizException;
import iih.ci.mrfp.sug2mrfp.d.CiMrFpSugDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院病案首页_手术数据维护服务
*/
public interface ISug2mrfpCudService {
	/**
	*  住院病案首页_手术数据真删除
	*/
    public abstract void delete(CiMrFpSugDO[] aggdos) throws BizException;
    
    /**
	*  住院病案首页_手术数据插入保存
	*/
	public abstract CiMrFpSugDO[] insert(CiMrFpSugDO[] aggdos) throws BizException;
	
    /**
	*  住院病案首页_手术数据保存
	*/
	public abstract CiMrFpSugDO[] save(CiMrFpSugDO[] aggdos) throws BizException;
	
    /**
	*  住院病案首页_手术数据更新
	*/
	public abstract CiMrFpSugDO[] update(CiMrFpSugDO[] aggdos) throws BizException;
	
	/**
	*  住院病案首页_手术数据逻辑删除
	*/
	public abstract void logicDelete(CiMrFpSugDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrFpSugDO[] enableWithoutFilter(CiMrFpSugDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrFpSugDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrFpSugDO[] disableVOWithoutFilter(CiMrFpSugDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrFpSugDO[] dos) throws BizException ;
}
