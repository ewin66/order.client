package iih.ci.mr.knowledge.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.knowledge.d.KnowledgeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 知识库数据维护服务
*/
public interface IKnowledgeCudService {
	/**
	*  知识库数据真删除
	*/
    public abstract void delete(KnowledgeDO[] aggdos) throws BizException;
    
    /**
	*  知识库数据插入保存
	*/
	public abstract KnowledgeDO[] insert(KnowledgeDO[] aggdos) throws BizException;
	
    /**
	*  知识库数据保存
	*/
	public abstract KnowledgeDO[] save(KnowledgeDO[] aggdos) throws BizException;
	
    /**
	*  知识库数据更新
	*/
	public abstract KnowledgeDO[] update(KnowledgeDO[] aggdos) throws BizException;
	
	/**
	*  知识库数据逻辑删除
	*/
	public abstract void logicDelete(KnowledgeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public KnowledgeDO[] enableWithoutFilter(KnowledgeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(KnowledgeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public KnowledgeDO[] disableVOWithoutFilter(KnowledgeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(KnowledgeDO[] dos) throws BizException ;
}
