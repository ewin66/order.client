package iih.ci.mr.nu.criticalillrec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.criticalillrec.d.CriticalillDO;
import iih.ci.mr.nu.criticalillrec.d.CriticalillrecAggDO;

/**
* 危重症护理记录单数据维护服务
*/
public interface ICriticalillrecCudService {
	/**
	*  危重症护理记录单数据真删除
	*/
    public abstract void delete(CriticalillrecAggDO[] aggdos) throws BizException;
    
    /**
	*  危重症护理记录单数据插入保存
	*/
	public abstract CriticalillrecAggDO[] insert(CriticalillrecAggDO[] aggdos) throws BizException;
	
    /**
	*  危重症护理记录单数据保存
	*/
	public abstract CriticalillrecAggDO[] save(CriticalillrecAggDO[] aggdos) throws BizException;
	
    /**
	*  危重症护理记录单数据更新
	*/
	public abstract CriticalillrecAggDO[] update(CriticalillrecAggDO[] aggdos) throws BizException;
	
	/**
	*  危重症护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(CriticalillrecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对危重症护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(CriticalillDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对危重症护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CriticalillDO[] mainDos) throws BizException;
}
