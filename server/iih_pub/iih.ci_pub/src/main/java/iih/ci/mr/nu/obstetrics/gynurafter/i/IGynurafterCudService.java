package iih.ci.mr.nu.obstetrics.gynurafter.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.gynurafter.d.GyNurAfterAssDO;
import iih.ci.mr.nu.obstetrics.gynurafter.d.GynurafterAggDO;

/**
* 妇科护理记录单(术后)数据维护服务
*/
public interface IGynurafterCudService {
	/**
	*  妇科护理记录单(术后)数据真删除
	*/
    public abstract void delete(GynurafterAggDO[] aggdos) throws BizException;
    
    /**
	*  妇科护理记录单(术后)数据插入保存
	*/
	public abstract GynurafterAggDO[] insert(GynurafterAggDO[] aggdos) throws BizException;
	
    /**
	*  妇科护理记录单(术后)数据保存
	*/
	public abstract GynurafterAggDO[] save(GynurafterAggDO[] aggdos) throws BizException;
	
    /**
	*  妇科护理记录单(术后)数据更新
	*/
	public abstract GynurafterAggDO[] update(GynurafterAggDO[] aggdos) throws BizException;
	
	/**
	*  妇科护理记录单(术后)数据逻辑删除
	*/
	public abstract void logicDelete(GynurafterAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对妇科护理记录单(术后)数据真删除
	 */
	public abstract void deleteByParentDO(GyNurAfterAssDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对妇科护理记录单(术后)数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(GyNurAfterAssDO[] mainDos) throws BizException;
}
