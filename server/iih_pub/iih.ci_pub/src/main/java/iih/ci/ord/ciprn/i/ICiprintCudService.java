package iih.ci.ord.ciprn.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ciprn.d.CiprintAggDO;

/**
* 临床打印单数据维护服务
*/
public interface ICiprintCudService {
	/**
	*  临床打印单数据真删除
	*/
    public abstract void delete(CiprintAggDO[] aggdos) throws BizException;
    
    /**
	*  临床打印单数据插入保存
	*/
	public abstract CiprintAggDO[] insert(CiprintAggDO[] aggdos) throws BizException;
	
    /**
	*  临床打印单数据保存
	*/
	public abstract CiprintAggDO[] save(CiprintAggDO[] aggdos) throws BizException;
	
    /**
	*  临床打印单数据更新
	*/
	public abstract CiprintAggDO[] update(CiprintAggDO[] aggdos) throws BizException;
	
	/**
	*  临床打印单数据逻辑删除
	*/
	public abstract void logicDelete(CiprintAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对临床打印单数据真删除
	 */
	public abstract void deleteByParentDO(CiPrnDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对临床打印单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiPrnDO[] mainDos) throws BizException;
}
