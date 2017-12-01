package iih.ci.mr.cimrstblsec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimrstblsec.d.CiMrSTblSecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 临床医疗记录智能表格段落数据维护服务
*/
public interface ICimrstblsecMDOCudService {
	/**
	*  临床医疗记录智能表格段落数据真删除
	*/
    public abstract void delete(CiMrSTblSecDO[] aggdos) throws BizException;
    
    /**
	*  临床医疗记录智能表格段落数据插入保存
	*/
	public abstract CiMrSTblSecDO[] insert(CiMrSTblSecDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录智能表格段落数据保存
	*/
	public abstract CiMrSTblSecDO[] save(CiMrSTblSecDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录智能表格段落数据更新
	*/
	public abstract CiMrSTblSecDO[] update(CiMrSTblSecDO[] aggdos) throws BizException;
	
	/**
	*  临床医疗记录智能表格段落数据逻辑删除
	*/
	public abstract void logicDelete(CiMrSTblSecDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrSTblSecDO[] enableWithoutFilter(CiMrSTblSecDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrSTblSecDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrSTblSecDO[] disableVOWithoutFilter(CiMrSTblSecDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrSTblSecDO[] aggdos) throws BizException ;
	
}
