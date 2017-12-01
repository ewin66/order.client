package iih.ci.mrfp.other2mrfp.i;

import xap.mw.core.data.BizException;
import  iih.ci.mrfp.other2mrfp.d.Other2mrfpAggDO;

/**
* 病案首页其他信息数据维护服务
*/
public interface IOther2mrfpCudService {
	/**
	*  病案首页其他信息数据真删除
	*/
    public abstract void delete(Other2mrfpAggDO[] aggdos) throws BizException;
    
    /**
	*  病案首页其他信息数据插入保存
	*/
	public abstract Other2mrfpAggDO[] insert(Other2mrfpAggDO[] aggdos) throws BizException;
	
    /**
	*  病案首页其他信息数据保存
	*/
	public abstract Other2mrfpAggDO[] save(Other2mrfpAggDO[] aggdos) throws BizException;
	
    /**
	*  病案首页其他信息数据更新
	*/
	public abstract Other2mrfpAggDO[] update(Other2mrfpAggDO[] aggdos) throws BizException;
	
	/**
	*  病案首页其他信息数据逻辑删除
	*/
	public abstract void logicDelete(Other2mrfpAggDO[] aggdos) throws BizException;
}
