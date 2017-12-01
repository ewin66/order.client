package iih.ci.mr.nu.generalnursingrec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.generalnursingrec.d.GeneralNursingDO;
import iih.ci.mr.nu.generalnursingrec.d.GeneralnursingrecAggDO;

/**
* 一般护理记录数据维护服务
*/
public interface IGeneralnursingrecCudService {
	/**
	*  一般护理记录数据真删除
	*/
    public abstract void delete(GeneralnursingrecAggDO[] aggdos) throws BizException;
    
    /**
	*  一般护理记录数据插入保存
	*/
	public abstract GeneralnursingrecAggDO[] insert(GeneralnursingrecAggDO[] aggdos) throws BizException;
	
    /**
	*  一般护理记录数据保存
	*/
	public abstract GeneralnursingrecAggDO[] save(GeneralnursingrecAggDO[] aggdos) throws BizException;
	
    /**
	*  一般护理记录数据更新
	*/
	public abstract GeneralnursingrecAggDO[] update(GeneralnursingrecAggDO[] aggdos) throws BizException;
	
	/**
	*  一般护理记录数据逻辑删除
	*/
	public abstract void logicDelete(GeneralnursingrecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对一般护理记录数据真删除
	 */
	public abstract void deleteByParentDO(GeneralNursingDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对一般护理记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(GeneralNursingDO[] mainDos) throws BizException;
}
