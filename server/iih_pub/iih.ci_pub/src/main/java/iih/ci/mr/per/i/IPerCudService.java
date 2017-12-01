package iih.ci.mr.per.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.per.d.PerDO;
import iih.ci.mr.per.d.PerAggDO;

/**
* 组件数据维护服务
*/
public interface IPerCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(PerAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract PerAggDO[] insert(PerAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract PerAggDO[] save(PerAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract PerAggDO[] update(PerAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(PerAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(PerDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PerDO[] mainDos) throws BizException;
}
