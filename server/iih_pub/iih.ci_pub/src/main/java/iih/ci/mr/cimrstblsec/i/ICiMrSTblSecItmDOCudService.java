package iih.ci.mr.cimrstblsec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimrstblsec.d.CiMrSTblSecItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 临床医疗记录智能表格段落数据维护服务
*/
public interface ICiMrSTblSecItmDOCudService {
	/**
	*  临床医疗记录智能表格段落数据真删除
	*/
    public abstract void delete(CiMrSTblSecItmDO[] aggdos) throws BizException;
    
    /**
	*  临床医疗记录智能表格段落数据插入保存
	*/
	public abstract CiMrSTblSecItmDO[] insert(CiMrSTblSecItmDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录智能表格段落数据保存
	*/
	public abstract CiMrSTblSecItmDO[] save(CiMrSTblSecItmDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录智能表格段落数据更新
	*/
	public abstract CiMrSTblSecItmDO[] update(CiMrSTblSecItmDO[] aggdos) throws BizException;
	
	/**
	*  临床医疗记录智能表格段落数据逻辑删除
	*/
	public abstract void logicDelete(CiMrSTblSecItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrSTblSecItmDO[] enableWithoutFilter(CiMrSTblSecItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrSTblSecItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrSTblSecItmDO[] disableVOWithoutFilter(CiMrSTblSecItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrSTblSecItmDO[] aggdos) throws BizException ;
	
}
