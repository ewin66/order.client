package iih.ci.mr.nu.painassessment.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.painassessment.d.PainAssessDO;
import iih.ci.mr.nu.painassessment.d.PainassessmentAggDO;

/**
* 疼痛护理评估表数据维护服务
*/
public interface IPainassessmentCudService {
	/**
	*  疼痛护理评估表数据真删除
	*/
    public abstract void delete(PainassessmentAggDO[] aggdos) throws BizException;
    
    /**
	*  疼痛护理评估表数据插入保存
	*/
	public abstract PainassessmentAggDO[] insert(PainassessmentAggDO[] aggdos) throws BizException;
	
    /**
	*  疼痛护理评估表数据保存
	*/
	public abstract PainassessmentAggDO[] save(PainassessmentAggDO[] aggdos) throws BizException;
	
    /**
	*  疼痛护理评估表数据更新
	*/
	public abstract PainassessmentAggDO[] update(PainassessmentAggDO[] aggdos) throws BizException;
	
	/**
	*  疼痛护理评估表数据逻辑删除
	*/
	public abstract void logicDelete(PainassessmentAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对疼痛护理评估表数据真删除
	 */
	public abstract void deleteByParentDO(PainAssessDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对疼痛护理评估表数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PainAssessDO[] mainDos) throws BizException;
}
