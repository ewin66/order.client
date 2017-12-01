package iih.ci.mr.nu.obstetrics.gynurbefore.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.gynurbefore.d.GyNurBeforeAssDO;
import iih.ci.mr.nu.obstetrics.gynurbefore.d.GynurbeforeAggDO;

/**
* 妇科护理记录单(非手术、术前)数据维护服务
*/
public interface IGynurbeforeCudService {
	/**
	*  妇科护理记录单(非手术、术前)数据真删除
	*/
    public abstract void delete(GynurbeforeAggDO[] aggdos) throws BizException;
    
    /**
	*  妇科护理记录单(非手术、术前)数据插入保存
	*/
	public abstract GynurbeforeAggDO[] insert(GynurbeforeAggDO[] aggdos) throws BizException;
	
    /**
	*  妇科护理记录单(非手术、术前)数据保存
	*/
	public abstract GynurbeforeAggDO[] save(GynurbeforeAggDO[] aggdos) throws BizException;
	
    /**
	*  妇科护理记录单(非手术、术前)数据更新
	*/
	public abstract GynurbeforeAggDO[] update(GynurbeforeAggDO[] aggdos) throws BizException;
	
	/**
	*  妇科护理记录单(非手术、术前)数据逻辑删除
	*/
	public abstract void logicDelete(GynurbeforeAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对妇科护理记录单(非手术、术前)数据真删除
	 */
	public abstract void deleteByParentDO(GyNurBeforeAssDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对妇科护理记录单(非手术、术前)数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(GyNurBeforeAssDO[] mainDos) throws BizException;
}
