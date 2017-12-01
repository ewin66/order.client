package iih.ci.mr.nu.healthyedunsrec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.healthyedunsrec.d.HealthyEduNsDO;
import iih.ci.mr.nu.healthyedunsrec.d.HealthyedunsrecAggDO;

/**
* 健康教育记录数据维护服务
*/
public interface IHealthyedunsrecCudService {
	/**
	*  健康教育记录数据真删除
	*/
    public abstract void delete(HealthyedunsrecAggDO[] aggdos) throws BizException;
    
    /**
	*  健康教育记录数据插入保存
	*/
	public abstract HealthyedunsrecAggDO[] insert(HealthyedunsrecAggDO[] aggdos) throws BizException;
	
    /**
	*  健康教育记录数据保存
	*/
	public abstract HealthyedunsrecAggDO[] save(HealthyedunsrecAggDO[] aggdos) throws BizException;
	
    /**
	*  健康教育记录数据更新
	*/
	public abstract HealthyedunsrecAggDO[] update(HealthyedunsrecAggDO[] aggdos) throws BizException;
	
	/**
	*  健康教育记录数据逻辑删除
	*/
	public abstract void logicDelete(HealthyedunsrecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康教育记录数据真删除
	 */
	public abstract void deleteByParentDO(HealthyEduNsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康教育记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HealthyEduNsDO[] mainDos) throws BizException;
}
