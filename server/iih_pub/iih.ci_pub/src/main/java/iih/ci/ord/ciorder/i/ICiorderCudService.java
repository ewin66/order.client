package iih.ci.ord.ciorder.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;

/**
* 临床医嘱数据维护服务
*/
public interface ICiorderCudService {
	/**
	*  临床医嘱数据真删除
	*/
    public abstract void delete(CiorderAggDO[] aggdos) throws BizException;
    
    /**
	*  临床医嘱数据插入保存
	*/
	public abstract CiorderAggDO[] insert(CiorderAggDO[] aggdos) throws BizException;
	
    /**
	*  临床医嘱数据保存
	*/
	public abstract CiorderAggDO[] save(CiorderAggDO[] aggdos) throws BizException;
	
    /**
	*  临床医嘱数据更新
	*/
	public abstract CiorderAggDO[] update(CiorderAggDO[] aggdos) throws BizException;
	
	/**
	*  临床医嘱数据逻辑删除
	*/
	public abstract void logicDelete(CiorderAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对临床医嘱数据真删除
	 */
	public abstract void deleteByParentDO(CiOrderDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对临床医嘱数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiOrderDO[] mainDos) throws BizException;
}
