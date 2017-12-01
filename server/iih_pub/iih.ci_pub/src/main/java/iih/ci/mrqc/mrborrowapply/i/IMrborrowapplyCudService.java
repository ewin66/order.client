package iih.ci.mrqc.mrborrowapply.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.mrborrowapply.d.AmrBorrowApplyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病案借阅申请数据维护服务
*/
public interface IMrborrowapplyCudService {
	/**
	*  病案借阅申请数据真删除
	*/
    public abstract void delete(AmrBorrowApplyDO[] aggdos) throws BizException;
    
    /**
	*  病案借阅申请数据插入保存
	*/
	public abstract AmrBorrowApplyDO[] insert(AmrBorrowApplyDO[] aggdos) throws BizException;
	
    /**
	*  病案借阅申请数据保存
	*/
	public abstract AmrBorrowApplyDO[] save(AmrBorrowApplyDO[] aggdos) throws BizException;
	
    /**
	*  病案借阅申请数据更新
	*/
	public abstract AmrBorrowApplyDO[] update(AmrBorrowApplyDO[] aggdos) throws BizException;
	
	/**
	*  病案借阅申请数据逻辑删除
	*/
	public abstract void logicDelete(AmrBorrowApplyDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AmrBorrowApplyDO[] enableWithoutFilter(AmrBorrowApplyDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AmrBorrowApplyDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AmrBorrowApplyDO[] disableVOWithoutFilter(AmrBorrowApplyDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AmrBorrowApplyDO[] dos) throws BizException ;
}
