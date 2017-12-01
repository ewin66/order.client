package iih.ci.ord.app.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.app.d.CiAppTreatSheetDO;
import iih.ci.ord.app.d.CiapptreatsheetAggDO;

/**
* 诊疗申请单数据维护服务
*/
public interface ICiapptreatsheetCudService {
	/**
	*  诊疗申请单数据真删除
	*/
    public abstract void delete(CiapptreatsheetAggDO[] aggdos) throws BizException;
    
    /**
	*  诊疗申请单数据插入保存
	*/
	public abstract CiapptreatsheetAggDO[] insert(CiapptreatsheetAggDO[] aggdos) throws BizException;
	
    /**
	*  诊疗申请单数据保存
	*/
	public abstract CiapptreatsheetAggDO[] save(CiapptreatsheetAggDO[] aggdos) throws BizException;
	
    /**
	*  诊疗申请单数据更新
	*/
	public abstract CiapptreatsheetAggDO[] update(CiapptreatsheetAggDO[] aggdos) throws BizException;
	
	/**
	*  诊疗申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiapptreatsheetAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对诊疗申请单数据真删除
	 */
	public abstract void deleteByParentDO(CiAppTreatSheetDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对诊疗申请单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiAppTreatSheetDO[] mainDos) throws BizException;
}
