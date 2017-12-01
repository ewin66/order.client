package iih.ci.mr.knowledgetype.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.knowledgetype.d.KnowledgeTypeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 知识库类型数据维护服务
*/
public interface IKnowledgetypeCudService {
	/**
	*  知识库类型数据真删除
	*/
    public abstract void delete(KnowledgeTypeDO[] aggdos) throws BizException;
    
    /**
	*  知识库类型数据插入保存
	*/
	public abstract KnowledgeTypeDO[] insert(KnowledgeTypeDO[] aggdos) throws BizException;
	
    /**
	*  知识库类型数据保存
	*/
	public abstract KnowledgeTypeDO[] save(KnowledgeTypeDO[] aggdos) throws BizException;
	
    /**
	*  知识库类型数据更新
	*/
	public abstract KnowledgeTypeDO[] update(KnowledgeTypeDO[] aggdos) throws BizException;
	
	/**
	*  知识库类型数据逻辑删除
	*/
	public abstract void logicDelete(KnowledgeTypeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public KnowledgeTypeDO[] enableWithoutFilter(KnowledgeTypeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(KnowledgeTypeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public KnowledgeTypeDO[] disableVOWithoutFilter(KnowledgeTypeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(KnowledgeTypeDO[] dos) throws BizException ;
}
