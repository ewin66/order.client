package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.CiorappbtAggDO;

/**
* 备血申请单数据维护服务
*/
public interface ICiorappbtCudService {
	/**
	*  备血申请单数据真删除
	*/
    public abstract void delete(CiorappbtAggDO[] aggdos) throws BizException;
    
    /**
	*  备血申请单数据插入保存
	*/
	public abstract CiorappbtAggDO[] insert(CiorappbtAggDO[] aggdos) throws BizException;
	
    /**
	*  备血申请单数据保存
	*/
	public abstract CiorappbtAggDO[] save(CiorappbtAggDO[] aggdos) throws BizException;
	
    /**
	*  备血申请单数据更新
	*/
	public abstract CiorappbtAggDO[] update(CiorappbtAggDO[] aggdos) throws BizException;
	
	/**
	*  备血申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiorappbtAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对备血申请单数据真删除
	 */
	public abstract void deleteByParentDO(OrdApBtDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对备血申请单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OrdApBtDO[] mainDos) throws BizException;
}
