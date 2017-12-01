package iih.ci.mrqc.qaflt.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 质控缺陷数据维护服务
*/
public interface IQafltCudService {
	/**
	*  质控缺陷数据真删除
	*/
    public abstract void delete(QaFltDO[] aggdos) throws BizException;
    
    /**
	*  质控缺陷数据插入保存
	*/
	public abstract QaFltDO[] insert(QaFltDO[] aggdos) throws BizException;
	
    /**
	*  质控缺陷数据保存
	*/
	public abstract QaFltDO[] save(QaFltDO[] aggdos) throws BizException;
	
    /**
	*  质控缺陷数据更新
	*/
	public abstract QaFltDO[] update(QaFltDO[] aggdos) throws BizException;
	
	/**
	*  质控缺陷数据逻辑删除
	*/
	public abstract void logicDelete(QaFltDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public QaFltDO[] enableWithoutFilter(QaFltDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(QaFltDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public QaFltDO[] disableVOWithoutFilter(QaFltDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(QaFltDO[] dos) throws BizException ;
}
