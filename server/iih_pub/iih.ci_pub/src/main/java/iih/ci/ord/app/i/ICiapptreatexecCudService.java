package iih.ci.ord.app.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import iih.ci.ord.app.d.CiapptreatexecAggDO;

/**
* 门诊诊疗执行单数据维护服务
*/
public interface ICiapptreatexecCudService {
	/**
	*  门诊诊疗执行单数据真删除
	*/
    public abstract void delete(CiapptreatexecAggDO[] aggdos) throws BizException;
    
    /**
	*  门诊诊疗执行单数据插入保存
	*/
	public abstract CiapptreatexecAggDO[] insert(CiapptreatexecAggDO[] aggdos) throws BizException;
	
    /**
	*  门诊诊疗执行单数据保存
	*/
	public abstract CiapptreatexecAggDO[] save(CiapptreatexecAggDO[] aggdos) throws BizException;
	
    /**
	*  门诊诊疗执行单数据更新
	*/
	public abstract CiapptreatexecAggDO[] update(CiapptreatexecAggDO[] aggdos) throws BizException;
	
	/**
	*  门诊诊疗执行单数据逻辑删除
	*/
	public abstract void logicDelete(CiapptreatexecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对门诊诊疗执行单数据真删除
	 */
	public abstract void deleteByParentDO(CiAppTreatExecDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对门诊诊疗执行单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiAppTreatExecDO[] mainDos) throws BizException;
}
