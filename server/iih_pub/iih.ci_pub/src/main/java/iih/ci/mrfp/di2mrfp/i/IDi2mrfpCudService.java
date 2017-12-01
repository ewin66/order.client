package iih.ci.mrfp.di2mrfp.i;

import xap.mw.core.data.BizException;
import  iih.ci.mrfp.di2mrfp.d.Di2mrfpAggDO;

/**
* 住院病案首页_诊断数据维护服务
*/
public interface IDi2mrfpCudService {
	/**
	*  住院病案首页_诊断数据真删除
	*/
    public abstract void delete(Di2mrfpAggDO[] aggdos) throws BizException;
    
    /**
	*  住院病案首页_诊断数据插入保存
	*/
	public abstract Di2mrfpAggDO[] insert(Di2mrfpAggDO[] aggdos) throws BizException;
	
    /**
	*  住院病案首页_诊断数据保存
	*/
	public abstract Di2mrfpAggDO[] save(Di2mrfpAggDO[] aggdos) throws BizException;
	
    /**
	*  住院病案首页_诊断数据更新
	*/
	public abstract Di2mrfpAggDO[] update(Di2mrfpAggDO[] aggdos) throws BizException;
	
	/**
	*  住院病案首页_诊断数据逻辑删除
	*/
	public abstract void logicDelete(Di2mrfpAggDO[] aggdos) throws BizException;
}
