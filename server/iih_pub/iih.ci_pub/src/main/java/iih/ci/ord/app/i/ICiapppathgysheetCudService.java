package iih.ci.ord.app.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.d.CiapppathgysheetAggDO;

/**
* 病理打印申请单数据维护服务
*/
public interface ICiapppathgysheetCudService {
	/**
	*  病理打印申请单数据真删除
	*/
    public abstract void delete(CiapppathgysheetAggDO[] aggdos) throws BizException;
    
    /**
	*  病理打印申请单数据插入保存
	*/
	public abstract CiapppathgysheetAggDO[] insert(CiapppathgysheetAggDO[] aggdos) throws BizException;
	
    /**
	*  病理打印申请单数据保存
	*/
	public abstract CiapppathgysheetAggDO[] save(CiapppathgysheetAggDO[] aggdos) throws BizException;
	
    /**
	*  病理打印申请单数据更新
	*/
	public abstract CiapppathgysheetAggDO[] update(CiapppathgysheetAggDO[] aggdos) throws BizException;
	
	/**
	*  病理打印申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiapppathgysheetAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病理打印申请单数据真删除
	 */
	public abstract void deleteByParentDO(CiAppPathgySheetDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病理打印申请单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiAppPathgySheetDO[] mainDos) throws BizException;
}
