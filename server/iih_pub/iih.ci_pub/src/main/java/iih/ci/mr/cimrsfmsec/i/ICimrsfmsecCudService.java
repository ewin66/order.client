package iih.ci.mr.cimrsfmsec.i;

import xap.mw.core.data.BizException;
import  iih.ci.mr.cimrsfmsec.d.CimrsfmsecAggDO;

/**
* 医疗记录智能表单段落数据维护服务
*/
public interface ICimrsfmsecCudService {
	/**
	*  医疗记录智能表单段落数据删除
	*/
    public abstract void delete(CimrsfmsecAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录智能表单段落数据插入保存
	*/
	public abstract CimrsfmsecAggDO[] insert(CimrsfmsecAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录智能表单段落数据保存
	*/
	public abstract CimrsfmsecAggDO[] save(CimrsfmsecAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录智能表单段落数据更新
	*/
	public abstract CimrsfmsecAggDO[] update(CimrsfmsecAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录智能表单段落数据真删
	*/
	public abstract void logicDelete(CimrsfmsecAggDO[] aggdos) throws BizException;
}
