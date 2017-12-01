package iih.ci.ord.skintest.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 皮试结果记录数据维护服务
*/
public interface ISkintestCudService {
	/**
	*  皮试结果记录数据删除
	*/
    public abstract void delete(CiSkinTestRstDO[] aggdos) throws BizException;
    
    /**
	*  皮试结果记录数据插入保存
	*/
	public abstract CiSkinTestRstDO[] insert(CiSkinTestRstDO[] aggdos) throws BizException;
	
    /**
	*  皮试结果记录数据保存
	*/
	public abstract CiSkinTestRstDO[] save(CiSkinTestRstDO[] aggdos) throws BizException;
	
    /**
	*  皮试结果记录数据更新
	*/
	public abstract CiSkinTestRstDO[] update(CiSkinTestRstDO[] aggdos) throws BizException;
	
	/**
	*  皮试结果记录数据真删
	*/
	public abstract void logicDelete(CiSkinTestRstDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiSkinTestRstDO[] enableWithoutFilter(CiSkinTestRstDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiSkinTestRstDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiSkinTestRstDO[] disableVOWithoutFilter(CiSkinTestRstDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiSkinTestRstDO[] aggdos) throws BizException ;
}
