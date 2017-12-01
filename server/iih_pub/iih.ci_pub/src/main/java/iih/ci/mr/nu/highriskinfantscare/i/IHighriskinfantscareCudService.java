package iih.ci.mr.nu.highriskinfantscare.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.highriskinfantscare.d.ChildrenCareDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 高危儿护理观察记录单数据维护服务
*/
public interface IHighriskinfantscareCudService {
	/**
	*  高危儿护理观察记录单数据真删除
	*/
    public abstract void delete(ChildrenCareDO[] aggdos) throws BizException;
    
    /**
	*  高危儿护理观察记录单数据插入保存
	*/
	public abstract ChildrenCareDO[] insert(ChildrenCareDO[] aggdos) throws BizException;
	
    /**
	*  高危儿护理观察记录单数据保存
	*/
	public abstract ChildrenCareDO[] save(ChildrenCareDO[] aggdos) throws BizException;
	
    /**
	*  高危儿护理观察记录单数据更新
	*/
	public abstract ChildrenCareDO[] update(ChildrenCareDO[] aggdos) throws BizException;
	
	/**
	*  高危儿护理观察记录单数据逻辑删除
	*/
	public abstract void logicDelete(ChildrenCareDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ChildrenCareDO[] enableWithoutFilter(ChildrenCareDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ChildrenCareDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ChildrenCareDO[] disableVOWithoutFilter(ChildrenCareDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ChildrenCareDO[] dos) throws BizException ;
}
