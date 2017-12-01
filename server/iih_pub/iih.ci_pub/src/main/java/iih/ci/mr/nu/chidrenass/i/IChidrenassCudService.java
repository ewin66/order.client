package iih.ci.mr.nu.chidrenass.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.chidrenass.d.ChildrenInAsseDO;
import iih.ci.mr.nu.chidrenass.d.ChidrenassAggDO;

/**
* 高危儿入室评估数据维护服务
*/
public interface IChidrenassCudService {
	/**
	*  高危儿入室评估数据真删除
	*/
    public abstract void delete(ChidrenassAggDO[] aggdos) throws BizException;
    
    /**
	*  高危儿入室评估数据插入保存
	*/
	public abstract ChidrenassAggDO[] insert(ChidrenassAggDO[] aggdos) throws BizException;
	
    /**
	*  高危儿入室评估数据保存
	*/
	public abstract ChidrenassAggDO[] save(ChidrenassAggDO[] aggdos) throws BizException;
	
    /**
	*  高危儿入室评估数据更新
	*/
	public abstract ChidrenassAggDO[] update(ChidrenassAggDO[] aggdos) throws BizException;
	
	/**
	*  高危儿入室评估数据逻辑删除
	*/
	public abstract void logicDelete(ChidrenassAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对高危儿入室评估数据真删除
	 */
	public abstract void deleteByParentDO(ChildrenInAsseDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对高危儿入室评估数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ChildrenInAsseDO[] mainDos) throws BizException;
}
