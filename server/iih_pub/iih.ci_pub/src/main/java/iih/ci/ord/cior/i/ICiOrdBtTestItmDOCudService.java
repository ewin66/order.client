package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.CiOrdBtTestItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 备血检验结果数据维护服务
*/
public interface ICiOrdBtTestItmDOCudService {
	/**
	*  备血检验结果数据删除
	*/
    public abstract void delete(CiOrdBtTestItmDO[] aggdos) throws BizException;
    
    /**
	*  备血检验结果数据插入保存
	*/
	public abstract CiOrdBtTestItmDO[] insert(CiOrdBtTestItmDO[] aggdos) throws BizException;
	
    /**
	*  备血检验结果数据保存
	*/
	public abstract CiOrdBtTestItmDO[] save(CiOrdBtTestItmDO[] aggdos) throws BizException;
	
    /**
	*  备血检验结果数据更新
	*/
	public abstract CiOrdBtTestItmDO[] update(CiOrdBtTestItmDO[] aggdos) throws BizException;
	
	/**
	*  备血检验结果数据真删
	*/
	public abstract void logicDelete(CiOrdBtTestItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiOrdBtTestItmDO[] enableWithoutFilter(CiOrdBtTestItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiOrdBtTestItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiOrdBtTestItmDO[] disableVOWithoutFilter(CiOrdBtTestItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiOrdBtTestItmDO[] aggdos) throws BizException ;
	
}
