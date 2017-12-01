package iih.ci.rcm.au.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.au.d.AntibioticUseDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 抗菌用药数据维护服务
*/
public interface IAntibioticusedoCudService {
	/**
	*  抗菌用药数据真删除
	*/
    public abstract void delete(AntibioticUseDO[] aggdos) throws BizException;
    
    /**
	*  抗菌用药数据插入保存
	*/
	public abstract AntibioticUseDO[] insert(AntibioticUseDO[] aggdos) throws BizException;
	
    /**
	*  抗菌用药数据保存
	*/
	public abstract AntibioticUseDO[] save(AntibioticUseDO[] aggdos) throws BizException;
	
    /**
	*  抗菌用药数据更新
	*/
	public abstract AntibioticUseDO[] update(AntibioticUseDO[] aggdos) throws BizException;
	
	/**
	*  抗菌用药数据逻辑删除
	*/
	public abstract void logicDelete(AntibioticUseDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AntibioticUseDO[] enableWithoutFilter(AntibioticUseDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AntibioticUseDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AntibioticUseDO[] disableVOWithoutFilter(AntibioticUseDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AntibioticUseDO[] dos) throws BizException ;
}
