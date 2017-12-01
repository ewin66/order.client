package iih.ci.mr.nu.obstetrics.breathmachnur.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.breathmachnur.d.BreathMachInfoDO;
import iih.ci.mr.nu.obstetrics.breathmachnur.d.BreathmachnurAggDO;

/**
* 呼吸机治疗观察记录单数据维护服务
*/
public interface IBreathmachnurCudService {
	/**
	*  呼吸机治疗观察记录单数据真删除
	*/
    public abstract void delete(BreathmachnurAggDO[] aggdos) throws BizException;
    
    /**
	*  呼吸机治疗观察记录单数据插入保存
	*/
	public abstract BreathmachnurAggDO[] insert(BreathmachnurAggDO[] aggdos) throws BizException;
	
    /**
	*  呼吸机治疗观察记录单数据保存
	*/
	public abstract BreathmachnurAggDO[] save(BreathmachnurAggDO[] aggdos) throws BizException;
	
    /**
	*  呼吸机治疗观察记录单数据更新
	*/
	public abstract BreathmachnurAggDO[] update(BreathmachnurAggDO[] aggdos) throws BizException;
	
	/**
	*  呼吸机治疗观察记录单数据逻辑删除
	*/
	public abstract void logicDelete(BreathmachnurAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对呼吸机治疗观察记录单数据真删除
	 */
	public abstract void deleteByParentDO(BreathMachInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对呼吸机治疗观察记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BreathMachInfoDO[] mainDos) throws BizException;
}
