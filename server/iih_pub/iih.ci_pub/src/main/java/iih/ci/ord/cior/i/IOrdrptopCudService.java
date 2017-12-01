package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import  iih.ci.ord.cior.d.OrdrptopAggDO;

/**
* 医嘱手术记录数据维护服务
*/
public interface IOrdrptopCudService {
	/**
	*  医嘱手术记录数据删除
	*/
    public abstract void delete(OrdrptopAggDO[] aggdos) throws BizException;
    
    /**
	*  医嘱手术记录数据插入保存
	*/
	public abstract OrdrptopAggDO[] insert(OrdrptopAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱手术记录数据保存
	*/
	public abstract OrdrptopAggDO[] save(OrdrptopAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱手术记录数据更新
	*/
	public abstract OrdrptopAggDO[] update(OrdrptopAggDO[] aggdos) throws BizException;
	
	/**
	*  医嘱手术记录数据真删
	*/
	public abstract void logicDelete(OrdrptopAggDO[] aggdos) throws BizException;
}
