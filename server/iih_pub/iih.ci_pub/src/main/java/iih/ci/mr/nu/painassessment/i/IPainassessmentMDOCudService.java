package iih.ci.mr.nu.painassessment.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.painassessment.d.PainAssessDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 疼痛护理评估表数据维护服务
*/
public interface IPainassessmentMDOCudService {
	/**
	*  疼痛护理评估表数据真删除
	*/
    public abstract void delete(PainAssessDO[] aggdos) throws BizException;
    
    /**
	*  疼痛护理评估表数据插入保存
	*/
	public abstract PainAssessDO[] insert(PainAssessDO[] aggdos) throws BizException;
	
    /**
	*  疼痛护理评估表数据保存
	*/
	public abstract PainAssessDO[] save(PainAssessDO[] aggdos) throws BizException;
	
    /**
	*  疼痛护理评估表数据更新
	*/
	public abstract PainAssessDO[] update(PainAssessDO[] aggdos) throws BizException;
	
	/**
	*  疼痛护理评估表数据逻辑删除
	*/
	public abstract void logicDelete(PainAssessDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PainAssessDO[] enableWithoutFilter(PainAssessDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PainAssessDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PainAssessDO[] disableVOWithoutFilter(PainAssessDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PainAssessDO[] aggdos) throws BizException ;
	
}
