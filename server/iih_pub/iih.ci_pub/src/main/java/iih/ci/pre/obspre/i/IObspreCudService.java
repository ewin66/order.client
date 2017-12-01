package iih.ci.pre.obspre.i;

import xap.mw.core.data.BizException;
import  iih.ci.pre.obspre.d.ObspreAggDO;

/**
* 预检数据维护服务
*/
public interface IObspreCudService {
	/**
	*  预检数据真删除
	*/
    public abstract void delete(ObspreAggDO[] aggdos) throws BizException;
    
    /**
	*  预检数据插入保存
	*/
	public abstract ObspreAggDO[] insert(ObspreAggDO[] aggdos) throws BizException;
	
    /**
	*  预检数据保存
	*/
	public abstract ObspreAggDO[] save(ObspreAggDO[] aggdos) throws BizException;
	
    /**
	*  预检数据更新
	*/
	public abstract ObspreAggDO[] update(ObspreAggDO[] aggdos) throws BizException;
	
	/**
	*  预检数据逻辑删除
	*/
	public abstract void logicDelete(ObspreAggDO[] aggdos) throws BizException;
}
