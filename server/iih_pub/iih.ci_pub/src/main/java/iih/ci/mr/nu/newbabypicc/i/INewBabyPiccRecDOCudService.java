package iih.ci.mr.nu.newbabypicc.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.newbabypicc.d.NewBabyPiccRecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 新生儿科picc护理信息数据维护服务
*/
public interface INewBabyPiccRecDOCudService {
	/**
	*  新生儿科picc护理信息数据真删除
	*/
    public abstract void delete(NewBabyPiccRecDO[] aggdos) throws BizException;
    
    /**
	*  新生儿科picc护理信息数据插入保存
	*/
	public abstract NewBabyPiccRecDO[] insert(NewBabyPiccRecDO[] aggdos) throws BizException;
	
    /**
	*  新生儿科picc护理信息数据保存
	*/
	public abstract NewBabyPiccRecDO[] save(NewBabyPiccRecDO[] aggdos) throws BizException;
	
    /**
	*  新生儿科picc护理信息数据更新
	*/
	public abstract NewBabyPiccRecDO[] update(NewBabyPiccRecDO[] aggdos) throws BizException;
	
	/**
	*  新生儿科picc护理信息数据逻辑删除
	*/
	public abstract void logicDelete(NewBabyPiccRecDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NewBabyPiccRecDO[] enableWithoutFilter(NewBabyPiccRecDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NewBabyPiccRecDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NewBabyPiccRecDO[] disableVOWithoutFilter(NewBabyPiccRecDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NewBabyPiccRecDO[] aggdos) throws BizException ;
	
}
