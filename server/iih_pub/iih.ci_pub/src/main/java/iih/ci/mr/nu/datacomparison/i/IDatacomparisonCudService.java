package iih.ci.mr.nu.datacomparison.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.datacomparison.d.DataComparisonDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理文书数据对照数据维护服务
*/
public interface IDatacomparisonCudService {
	/**
	*  护理文书数据对照数据真删除
	*/
    public abstract void delete(DataComparisonDO[] aggdos) throws BizException;
    
    /**
	*  护理文书数据对照数据插入保存
	*/
	public abstract DataComparisonDO[] insert(DataComparisonDO[] aggdos) throws BizException;
	
    /**
	*  护理文书数据对照数据保存
	*/
	public abstract DataComparisonDO[] save(DataComparisonDO[] aggdos) throws BizException;
	
    /**
	*  护理文书数据对照数据更新
	*/
	public abstract DataComparisonDO[] update(DataComparisonDO[] aggdos) throws BizException;
	
	/**
	*  护理文书数据对照数据逻辑删除
	*/
	public abstract void logicDelete(DataComparisonDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DataComparisonDO[] enableWithoutFilter(DataComparisonDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DataComparisonDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DataComparisonDO[] disableVOWithoutFilter(DataComparisonDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DataComparisonDO[] dos) throws BizException ;
}
