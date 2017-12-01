package iih.ci.ord.app.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;

/**
* 检验申请单数据维护服务
*/
public interface ICiapplissheetCudService {
	/**
	*  检验申请单数据真删除
	*/
    public abstract void delete(CiapplissheetAggDO[] aggdos) throws BizException;
    
    /**
	*  检验申请单数据插入保存
	*/
	public abstract CiapplissheetAggDO[] insert(CiapplissheetAggDO[] aggdos) throws BizException;
	
    /**
	*  检验申请单数据保存
	*/
	public abstract CiapplissheetAggDO[] save(CiapplissheetAggDO[] aggdos) throws BizException;
	
    /**
	*  检验申请单数据更新
	*/
	public abstract CiapplissheetAggDO[] update(CiapplissheetAggDO[] aggdos) throws BizException;
	
	/**
	*  检验申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiapplissheetAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对检验申请单数据真删除
	 */
	public abstract void deleteByParentDO(CiAppLisSheetDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对检验申请单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiAppLisSheetDO[] mainDos) throws BizException;
}
