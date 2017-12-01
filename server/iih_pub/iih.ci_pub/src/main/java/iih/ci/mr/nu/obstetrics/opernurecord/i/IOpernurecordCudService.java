package iih.ci.mr.nu.obstetrics.opernurecord.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordDO;
import iih.ci.mr.nu.obstetrics.opernurecord.d.OpernurecordAggDO;

/**
* 手术护理记录单数据维护服务
*/
public interface IOpernurecordCudService {
	/**
	*  手术护理记录单数据真删除
	*/
    public abstract void delete(OpernurecordAggDO[] aggdos) throws BizException;
    
    /**
	*  手术护理记录单数据插入保存
	*/
	public abstract OpernurecordAggDO[] insert(OpernurecordAggDO[] aggdos) throws BizException;
	
    /**
	*  手术护理记录单数据保存
	*/
	public abstract OpernurecordAggDO[] save(OpernurecordAggDO[] aggdos) throws BizException;
	
    /**
	*  手术护理记录单数据更新
	*/
	public abstract OpernurecordAggDO[] update(OpernurecordAggDO[] aggdos) throws BizException;
	
	/**
	*  手术护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(OpernurecordAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对手术护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(OperNuRecordDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对手术护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OperNuRecordDO[] mainDos) throws BizException;
}
