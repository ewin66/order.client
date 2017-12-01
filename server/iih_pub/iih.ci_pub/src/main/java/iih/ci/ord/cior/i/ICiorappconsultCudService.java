package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;

/**
* 会诊申请单数据维护服务
*/
public interface ICiorappconsultCudService {
	/**
	*  会诊申请单数据真删除
	*/
    public abstract void delete(CiorappconsultAggDO[] aggdos) throws BizException;
    
    /**
	*  会诊申请单数据插入保存
	*/
	public abstract CiorappconsultAggDO[] insert(CiorappconsultAggDO[] aggdos) throws BizException;
	
    /**
	*  会诊申请单数据保存
	*/
	public abstract CiorappconsultAggDO[] save(CiorappconsultAggDO[] aggdos) throws BizException;
	
    /**
	*  会诊申请单数据更新
	*/
	public abstract CiorappconsultAggDO[] update(CiorappconsultAggDO[] aggdos) throws BizException;
	
	/**
	*  会诊申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiorappconsultAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对会诊申请单数据真删除
	 */
	public abstract void deleteByParentDO(OrdApConsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对会诊申请单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OrdApConsDO[] mainDos) throws BizException;
}
