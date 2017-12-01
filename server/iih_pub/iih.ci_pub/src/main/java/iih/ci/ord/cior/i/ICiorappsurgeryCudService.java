package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;

/**
* 手术申请数据维护服务
*/
public interface ICiorappsurgeryCudService {
	/**
	*  手术申请数据真删除
	*/
    public abstract void delete(CiorappsurgeryAggDO[] aggdos) throws BizException;
    
    /**
	*  手术申请数据插入保存
	*/
	public abstract CiorappsurgeryAggDO[] insert(CiorappsurgeryAggDO[] aggdos) throws BizException;
	
    /**
	*  手术申请数据保存
	*/
	public abstract CiorappsurgeryAggDO[] save(CiorappsurgeryAggDO[] aggdos) throws BizException;
	
    /**
	*  手术申请数据更新
	*/
	public abstract CiorappsurgeryAggDO[] update(CiorappsurgeryAggDO[] aggdos) throws BizException;
	
	/**
	*  手术申请数据逻辑删除
	*/
	public abstract void logicDelete(CiorappsurgeryAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对手术申请数据真删除
	 */
	public abstract void deleteByParentDO(OrdApOpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对手术申请数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OrdApOpDO[] mainDos) throws BizException;
}
