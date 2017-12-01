package iih.ci.ord.labordernoview.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.labordernoview.d.LabOrderNoView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 检验申请单号数据维护服务
*/
public interface ILabordernoviewCudService {
	/**
	*  检验申请单号数据真删除
	*/
    public abstract void delete(LabOrderNoView[] aggdos) throws BizException;
    
    /**
	*  检验申请单号数据插入保存
	*/
	public abstract LabOrderNoView[] insert(LabOrderNoView[] aggdos) throws BizException;
	
    /**
	*  检验申请单号数据保存
	*/
	public abstract LabOrderNoView[] save(LabOrderNoView[] aggdos) throws BizException;
	
    /**
	*  检验申请单号数据更新
	*/
	public abstract LabOrderNoView[] update(LabOrderNoView[] aggdos) throws BizException;
	
	/**
	*  检验申请单号数据逻辑删除
	*/
	public abstract void logicDelete(LabOrderNoView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public LabOrderNoView[] enableWithoutFilter(LabOrderNoView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(LabOrderNoView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public LabOrderNoView[] disableVOWithoutFilter(LabOrderNoView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(LabOrderNoView[] dos) throws BizException ;
}
