package iih.ci.mr.nu.obstetrics.birthrec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecInfoDO;
import iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecAggDO;

/**
* 临产记录数据维护服务
*/
public interface IBirthrecCudService {
	/**
	*  临产记录数据真删除
	*/
    public abstract void delete(BirthrecAggDO[] aggdos) throws BizException;
    
    /**
	*  临产记录数据插入保存
	*/
	public abstract BirthrecAggDO[] insert(BirthrecAggDO[] aggdos) throws BizException;
	
    /**
	*  临产记录数据保存
	*/
	public abstract BirthrecAggDO[] save(BirthrecAggDO[] aggdos) throws BizException;
	
    /**
	*  临产记录数据更新
	*/
	public abstract BirthrecAggDO[] update(BirthrecAggDO[] aggdos) throws BizException;
	
	/**
	*  临产记录数据逻辑删除
	*/
	public abstract void logicDelete(BirthrecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对临产记录数据真删除
	 */
	public abstract void deleteByParentDO(BirthrecInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对临产记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BirthrecInfoDO[] mainDos) throws BizException;
}
