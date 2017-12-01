package iih.ci.mr.cimrsfmsec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimrsfmsec.d.CimrsfmsecitmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗记录智能表单段落数据维护服务
*/
public interface ICimrsfmsecitmDOCudService {
	/**
	*  医疗记录智能表单段落数据删除
	*/
    public abstract void delete(CimrsfmsecitmDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录智能表单段落数据插入保存
	*/
	public abstract CimrsfmsecitmDO[] insert(CimrsfmsecitmDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录智能表单段落数据保存
	*/
	public abstract CimrsfmsecitmDO[] save(CimrsfmsecitmDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录智能表单段落数据更新
	*/
	public abstract CimrsfmsecitmDO[] update(CimrsfmsecitmDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录智能表单段落数据真删
	*/
	public abstract void logicDelete(CimrsfmsecitmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CimrsfmsecitmDO[] enableWithoutFilter(CimrsfmsecitmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CimrsfmsecitmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CimrsfmsecitmDO[] disableVOWithoutFilter(CimrsfmsecitmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CimrsfmsecitmDO[] aggdos) throws BizException ;
	
}
