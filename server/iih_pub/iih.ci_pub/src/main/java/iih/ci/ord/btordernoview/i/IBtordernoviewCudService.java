package iih.ci.ord.btordernoview.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.btordernoview.d.BtOrderNoView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 交叉备血申请单号数据维护服务
*/
public interface IBtordernoviewCudService {
	/**
	*  交叉备血申请单号数据真删除
	*/
    public abstract void delete(BtOrderNoView[] aggdos) throws BizException;
    
    /**
	*  交叉备血申请单号数据插入保存
	*/
	public abstract BtOrderNoView[] insert(BtOrderNoView[] aggdos) throws BizException;
	
    /**
	*  交叉备血申请单号数据保存
	*/
	public abstract BtOrderNoView[] save(BtOrderNoView[] aggdos) throws BizException;
	
    /**
	*  交叉备血申请单号数据更新
	*/
	public abstract BtOrderNoView[] update(BtOrderNoView[] aggdos) throws BizException;
	
	/**
	*  交叉备血申请单号数据逻辑删除
	*/
	public abstract void logicDelete(BtOrderNoView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BtOrderNoView[] enableWithoutFilter(BtOrderNoView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BtOrderNoView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BtOrderNoView[] disableVOWithoutFilter(BtOrderNoView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BtOrderNoView[] dos) throws BizException ;
}
