package iih.ci.ord.cior.i;

import xap.mw.core.data.BizException;
import  iih.ci.ord.cior.d.CiordrptbttestAggDO;

/**
* 备血检验结果数据维护服务
*/
public interface ICiordrptbttestCudService {
	/**
	*  备血检验结果数据真删除
	*/
    public abstract void delete(CiordrptbttestAggDO[] aggdos) throws BizException;
    
    /**
	*  备血检验结果数据插入保存
	*/
	public abstract CiordrptbttestAggDO[] insert(CiordrptbttestAggDO[] aggdos) throws BizException;
	
    /**
	*  备血检验结果数据保存
	*/
	public abstract CiordrptbttestAggDO[] save(CiordrptbttestAggDO[] aggdos) throws BizException;
	
    /**
	*  备血检验结果数据更新
	*/
	public abstract CiordrptbttestAggDO[] update(CiordrptbttestAggDO[] aggdos) throws BizException;
	
	/**
	*  备血检验结果数据逻辑删除
	*/
	public abstract void logicDelete(CiordrptbttestAggDO[] aggdos) throws BizException;
}
