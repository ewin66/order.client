package iih.ci.mr.nu.obstetrics.adhgeneralnursing.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.AdhNursingDO;
import iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.AdhgeneralnursingAggDO;

/**
* 妇产科护理观察记录数据维护服务
*/
public interface IAdhgeneralnursingCudService {
	/**
	*  妇产科护理观察记录数据真删除
	*/
    public abstract void delete(AdhgeneralnursingAggDO[] aggdos) throws BizException;
    
    /**
	*  妇产科护理观察记录数据插入保存
	*/
	public abstract AdhgeneralnursingAggDO[] insert(AdhgeneralnursingAggDO[] aggdos) throws BizException;
	
    /**
	*  妇产科护理观察记录数据保存
	*/
	public abstract AdhgeneralnursingAggDO[] save(AdhgeneralnursingAggDO[] aggdos) throws BizException;
	
    /**
	*  妇产科护理观察记录数据更新
	*/
	public abstract AdhgeneralnursingAggDO[] update(AdhgeneralnursingAggDO[] aggdos) throws BizException;
	
	/**
	*  妇产科护理观察记录数据逻辑删除
	*/
	public abstract void logicDelete(AdhgeneralnursingAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对妇产科护理观察记录数据真删除
	 */
	public abstract void deleteByParentDO(AdhNursingDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对妇产科护理观察记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(AdhNursingDO[] mainDos) throws BizException;
}
