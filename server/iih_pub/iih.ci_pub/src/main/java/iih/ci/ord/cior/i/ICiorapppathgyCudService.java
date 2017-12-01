package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;

/**
* 病理申请单数据维护服务
*/
public interface ICiorapppathgyCudService {
	/**
	*  病理申请单数据真删除
	*/
    public abstract void delete(CiorapppathgyAggDO[] aggdos) throws BizException;
    
    /**
	*  病理申请单数据插入保存
	*/
	public abstract CiorapppathgyAggDO[] insert(CiorapppathgyAggDO[] aggdos) throws BizException;
	
    /**
	*  病理申请单数据保存
	*/
	public abstract CiorapppathgyAggDO[] save(CiorapppathgyAggDO[] aggdos) throws BizException;
	
    /**
	*  病理申请单数据更新
	*/
	public abstract CiorapppathgyAggDO[] update(CiorapppathgyAggDO[] aggdos) throws BizException;
	
	/**
	*  病理申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiorapppathgyAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病理申请单数据真删除
	 */
	public abstract void deleteByParentDO(OrdApPathgyDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病理申请单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OrdApPathgyDO[] mainDos) throws BizException;
}
