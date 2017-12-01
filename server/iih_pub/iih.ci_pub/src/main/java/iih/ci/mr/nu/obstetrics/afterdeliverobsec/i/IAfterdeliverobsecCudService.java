package iih.ci.mr.nu.obstetrics.afterdeliverobsec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.AfterDeliveInfoDO;
import iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.AfterdeliverobsecAggDO;

/**
* 产后观察记录数据维护服务
*/
public interface IAfterdeliverobsecCudService {
	/**
	*  产后观察记录数据真删除
	*/
    public abstract void delete(AfterdeliverobsecAggDO[] aggdos) throws BizException;
    
    /**
	*  产后观察记录数据插入保存
	*/
	public abstract AfterdeliverobsecAggDO[] insert(AfterdeliverobsecAggDO[] aggdos) throws BizException;
	
    /**
	*  产后观察记录数据保存
	*/
	public abstract AfterdeliverobsecAggDO[] save(AfterdeliverobsecAggDO[] aggdos) throws BizException;
	
    /**
	*  产后观察记录数据更新
	*/
	public abstract AfterdeliverobsecAggDO[] update(AfterdeliverobsecAggDO[] aggdos) throws BizException;
	
	/**
	*  产后观察记录数据逻辑删除
	*/
	public abstract void logicDelete(AfterdeliverobsecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对产后观察记录数据真删除
	 */
	public abstract void deleteByParentDO(AfterDeliveInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对产后观察记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(AfterDeliveInfoDO[] mainDos) throws BizException;
}
