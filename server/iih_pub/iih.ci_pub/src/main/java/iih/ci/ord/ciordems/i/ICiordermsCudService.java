package iih.ci.ord.ciordems.i;

import iih.ci.ord.ciordems.d.EmsHeadDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import xap.mw.core.data.BizException;

public interface ICiordermsCudService {
	/**
	*  临床医嘱数据删除
	*/
    public abstract void delete(EmsHeadDO[] aggdos,Integer type) throws BizException;
    
    /**
	*  临床医嘱数据插入保存
	*/
	public abstract EmsHeadDO[] insert(EmsHeadDO[] aggdos,Integer ordertype) throws BizException;
	
    /**
	*  临床医嘱数据保存
	*/
	public abstract EmsHeadDO[] save(EmsHeadDO[] aggdos,Integer type) throws BizException;
	
    /**
	*  临床医嘱数据更新
	*/
	public abstract EmsHeadDO[] update(EmsHeadDO[] aggdos,Integer type) throws BizException;
	
	/**
	*  临床医嘱数据真删
	*/
	public abstract void logicDelete(EmsHeadDO[] aggdos,Integer type) throws BizException;

}
