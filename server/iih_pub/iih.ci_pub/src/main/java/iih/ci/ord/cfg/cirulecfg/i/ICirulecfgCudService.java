package iih.ci.ord.cfg.cirulecfg.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import iih.ci.ord.cfg.cirulecfg.d.CirulecfgAggDO;

/**
* 医嘱规则配置数据维护服务
*/
public interface ICirulecfgCudService {
	/**
	*  医嘱规则配置数据真删除
	*/
    public abstract void delete(CirulecfgAggDO[] aggdos) throws BizException;
    
    /**
	*  医嘱规则配置数据插入保存
	*/
	public abstract CirulecfgAggDO[] insert(CirulecfgAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱规则配置数据保存
	*/
	public abstract CirulecfgAggDO[] save(CirulecfgAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱规则配置数据更新
	*/
	public abstract CirulecfgAggDO[] update(CirulecfgAggDO[] aggdos) throws BizException;
	
	/**
	*  医嘱规则配置数据逻辑删除
	*/
	public abstract void logicDelete(CirulecfgAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医嘱规则配置数据真删除
	 */
	public abstract void deleteByParentDO(CiRuleCfg[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医嘱规则配置数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiRuleCfg[] mainDos) throws BizException;
}
