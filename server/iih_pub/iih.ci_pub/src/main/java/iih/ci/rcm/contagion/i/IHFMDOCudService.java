package iih.ci.rcm.contagion.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.contagion.d.HFMDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 传染病报告卡数据维护服务
*/
public interface IHFMDOCudService {
	/**
	*  传染病报告卡数据真删除
	*/
    public abstract void delete(HFMDO[] aggdos) throws BizException;
    
    /**
	*  传染病报告卡数据插入保存
	*/
	public abstract HFMDO[] insert(HFMDO[] aggdos) throws BizException;
	
    /**
	*  传染病报告卡数据保存
	*/
	public abstract HFMDO[] save(HFMDO[] aggdos) throws BizException;
	
    /**
	*  传染病报告卡数据更新
	*/
	public abstract HFMDO[] update(HFMDO[] aggdos) throws BizException;
	
	/**
	*  传染病报告卡数据逻辑删除
	*/
	public abstract void logicDelete(HFMDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HFMDO[] enableWithoutFilter(HFMDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HFMDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HFMDO[] disableVOWithoutFilter(HFMDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HFMDO[] aggdos) throws BizException ;
	
}
