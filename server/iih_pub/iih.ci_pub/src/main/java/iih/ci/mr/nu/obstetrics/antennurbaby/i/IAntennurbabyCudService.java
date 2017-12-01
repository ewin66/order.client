package iih.ci.mr.nu.obstetrics.antennurbaby.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.antennurbaby.d.AntNurBabyDO;
import iih.ci.mr.nu.obstetrics.antennurbaby.d.AntennurbabyAggDO;

/**
* 产科婴儿护理记录数据维护服务
*/
public interface IAntennurbabyCudService {
	/**
	*  产科婴儿护理记录数据真删除
	*/
    public abstract void delete(AntennurbabyAggDO[] aggdos) throws BizException;
    
    /**
	*  产科婴儿护理记录数据插入保存
	*/
	public abstract AntennurbabyAggDO[] insert(AntennurbabyAggDO[] aggdos) throws BizException;
	
    /**
	*  产科婴儿护理记录数据保存
	*/
	public abstract AntennurbabyAggDO[] save(AntennurbabyAggDO[] aggdos) throws BizException;
	
    /**
	*  产科婴儿护理记录数据更新
	*/
	public abstract AntennurbabyAggDO[] update(AntennurbabyAggDO[] aggdos) throws BizException;
	
	/**
	*  产科婴儿护理记录数据逻辑删除
	*/
	public abstract void logicDelete(AntennurbabyAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对产科婴儿护理记录数据真删除
	 */
	public abstract void deleteByParentDO(AntNurBabyDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对产科婴儿护理记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(AntNurBabyDO[] mainDos) throws BizException;
}
