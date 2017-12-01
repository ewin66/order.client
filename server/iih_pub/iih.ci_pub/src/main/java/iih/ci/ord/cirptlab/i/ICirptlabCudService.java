package iih.ci.ord.cirptlab.i;

import xap.mw.core.data.BizException;
import  iih.ci.ord.cirptlab.d.CirptlabAggDO;

/**
* 组件数据维护服务
*/
public interface ICirptlabCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(CirptlabAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract CirptlabAggDO[] insert(CirptlabAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract CirptlabAggDO[] save(CirptlabAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract CirptlabAggDO[] update(CirptlabAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(CirptlabAggDO[] aggdos) throws BizException;
}
