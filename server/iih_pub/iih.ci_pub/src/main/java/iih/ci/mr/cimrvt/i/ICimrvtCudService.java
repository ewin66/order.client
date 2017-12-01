package iih.ci.mr.cimrvt.i;

import xap.mw.core.data.BizException;
import  iih.ci.mr.cimrvt.d.CimrvtAggDO;

/**
* 临床生命体征测量数据维护服务
*/
public interface ICimrvtCudService {
	/**
	*  临床生命体征测量数据真删除
	*/
    public abstract void delete(CimrvtAggDO[] aggdos) throws BizException;
    
    /**
	*  临床生命体征测量数据插入保存
	*/
	public abstract CimrvtAggDO[] insert(CimrvtAggDO[] aggdos) throws BizException;
	
    /**
	*  临床生命体征测量数据保存
	*/
	public abstract CimrvtAggDO[] save(CimrvtAggDO[] aggdos) throws BizException;
	
    /**
	*  临床生命体征测量数据更新
	*/
	public abstract CimrvtAggDO[] update(CimrvtAggDO[] aggdos) throws BizException;
	
	/**
	*  临床生命体征测量数据逻辑删除
	*/
	public abstract void logicDelete(CimrvtAggDO[] aggdos) throws BizException;
}
