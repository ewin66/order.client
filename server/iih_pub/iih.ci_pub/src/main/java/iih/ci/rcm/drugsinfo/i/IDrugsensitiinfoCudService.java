package iih.ci.rcm.drugsinfo.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.drugsinfo.d.DrugSensitiInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 药敏信息数据维护服务
*/
public interface IDrugsensitiinfoCudService {
	/**
	*  药敏信息数据真删除
	*/
    public abstract void delete(DrugSensitiInfoDO[] aggdos) throws BizException;
    
    /**
	*  药敏信息数据插入保存
	*/
	public abstract DrugSensitiInfoDO[] insert(DrugSensitiInfoDO[] aggdos) throws BizException;
	
    /**
	*  药敏信息数据保存
	*/
	public abstract DrugSensitiInfoDO[] save(DrugSensitiInfoDO[] aggdos) throws BizException;
	
    /**
	*  药敏信息数据更新
	*/
	public abstract DrugSensitiInfoDO[] update(DrugSensitiInfoDO[] aggdos) throws BizException;
	
	/**
	*  药敏信息数据逻辑删除
	*/
	public abstract void logicDelete(DrugSensitiInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DrugSensitiInfoDO[] enableWithoutFilter(DrugSensitiInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DrugSensitiInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DrugSensitiInfoDO[] disableVOWithoutFilter(DrugSensitiInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DrugSensitiInfoDO[] dos) throws BizException ;
}
