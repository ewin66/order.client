package iih.ci.rcm.contagion.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.contagion.d.ContagionDO;
import iih.ci.rcm.contagion.d.ContagionAggDO;

/**
* 传染病报告卡数据维护服务
*/
public interface IContagionCudService {
	/**
	*  传染病报告卡数据真删除
	*/
    public abstract void delete(ContagionAggDO[] aggdos) throws BizException;
    
    /**
	*  传染病报告卡数据插入保存
	*/
	public abstract ContagionAggDO[] insert(ContagionAggDO[] aggdos) throws BizException;
	
    /**
	*  传染病报告卡数据保存
	*/
	public abstract ContagionAggDO[] save(ContagionAggDO[] aggdos) throws BizException;
	
    /**
	*  传染病报告卡数据更新
	*/
	public abstract ContagionAggDO[] update(ContagionAggDO[] aggdos) throws BizException;
	
	/**
	*  传染病报告卡数据逻辑删除
	*/
	public abstract void logicDelete(ContagionAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对传染病报告卡数据真删除
	 */
	public abstract void deleteByParentDO(ContagionDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对传染病报告卡数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ContagionDO[] mainDos) throws BizException;
}
