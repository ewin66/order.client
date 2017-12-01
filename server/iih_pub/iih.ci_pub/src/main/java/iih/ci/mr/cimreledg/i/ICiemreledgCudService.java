package iih.ci.mr.cimreledg.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimreledg.d.CiMrEleDgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 临床医疗记录元素_数据组数据维护服务
*/
public interface ICiemreledgCudService {
	/**
	*  临床医疗记录元素_数据组数据真删除
	*/
    public abstract void delete(CiMrEleDgDO[] aggdos) throws BizException;
    
    /**
	*  临床医疗记录元素_数据组数据插入保存
	*/
	public abstract CiMrEleDgDO[] insert(CiMrEleDgDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录元素_数据组数据保存
	*/
	public abstract CiMrEleDgDO[] save(CiMrEleDgDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录元素_数据组数据更新
	*/
	public abstract CiMrEleDgDO[] update(CiMrEleDgDO[] aggdos) throws BizException;
	
	/**
	*  临床医疗记录元素_数据组数据逻辑删除
	*/
	public abstract void logicDelete(CiMrEleDgDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrEleDgDO[] enableWithoutFilter(CiMrEleDgDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrEleDgDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrEleDgDO[] disableVOWithoutFilter(CiMrEleDgDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrEleDgDO[] dos) throws BizException ;
}
