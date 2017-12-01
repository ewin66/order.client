package iih.ci.mr.nu.obstetrics.gymissabort.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.gymissabort.d.GyMissAbortAssDO;
import iih.ci.mr.nu.obstetrics.gymissabort.d.GymissabortAggDO;

/**
* 妇科稽留流产护理记录单数据维护服务
*/
public interface IGymissabortCudService {
	/**
	*  妇科稽留流产护理记录单数据真删除
	*/
    public abstract void delete(GymissabortAggDO[] aggdos) throws BizException;
    
    /**
	*  妇科稽留流产护理记录单数据插入保存
	*/
	public abstract GymissabortAggDO[] insert(GymissabortAggDO[] aggdos) throws BizException;
	
    /**
	*  妇科稽留流产护理记录单数据保存
	*/
	public abstract GymissabortAggDO[] save(GymissabortAggDO[] aggdos) throws BizException;
	
    /**
	*  妇科稽留流产护理记录单数据更新
	*/
	public abstract GymissabortAggDO[] update(GymissabortAggDO[] aggdos) throws BizException;
	
	/**
	*  妇科稽留流产护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(GymissabortAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对妇科稽留流产护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(GyMissAbortAssDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对妇科稽留流产护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(GyMissAbortAssDO[] mainDos) throws BizException;
}
