package iih.ci.ord.ciorder.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciorder.d.OrdFreqTimeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 临床医嘱数据维护服务
*/
public interface IOrdFreqTimeDOCudService {
	/**
	*  临床医嘱数据真删除
	*/
    public abstract void delete(OrdFreqTimeDO[] aggdos) throws BizException;
    
    /**
	*  临床医嘱数据插入保存
	*/
	public abstract OrdFreqTimeDO[] insert(OrdFreqTimeDO[] aggdos) throws BizException;
	
    /**
	*  临床医嘱数据保存
	*/
	public abstract OrdFreqTimeDO[] save(OrdFreqTimeDO[] aggdos) throws BizException;
	
    /**
	*  临床医嘱数据更新
	*/
	public abstract OrdFreqTimeDO[] update(OrdFreqTimeDO[] aggdos) throws BizException;
	
	/**
	*  临床医嘱数据逻辑删除
	*/
	public abstract void logicDelete(OrdFreqTimeDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrdFreqTimeDO[] enableWithoutFilter(OrdFreqTimeDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrdFreqTimeDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrdFreqTimeDO[] disableVOWithoutFilter(OrdFreqTimeDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrdFreqTimeDO[] aggdos) throws BizException ;
	
}
