package iih.ci.mr.nu.obstetrics.antenatalassess.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.obstetrics.antenatalassess.d.AntenAssDO;
import iih.ci.mr.nu.obstetrics.antenatalassess.d.AntenatalassessAggDO;

/**
* 产科护理记录单(产后、术后)数据维护服务
*/
public interface IAntenatalassessCudService {
	/**
	*  产科护理记录单(产后、术后)数据真删除
	*/
    public abstract void delete(AntenatalassessAggDO[] aggdos) throws BizException;
    
    /**
	*  产科护理记录单(产后、术后)数据插入保存
	*/
	public abstract AntenatalassessAggDO[] insert(AntenatalassessAggDO[] aggdos) throws BizException;
	
    /**
	*  产科护理记录单(产后、术后)数据保存
	*/
	public abstract AntenatalassessAggDO[] save(AntenatalassessAggDO[] aggdos) throws BizException;
	
    /**
	*  产科护理记录单(产后、术后)数据更新
	*/
	public abstract AntenatalassessAggDO[] update(AntenatalassessAggDO[] aggdos) throws BizException;
	
	/**
	*  产科护理记录单(产后、术后)数据逻辑删除
	*/
	public abstract void logicDelete(AntenatalassessAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对产科护理记录单(产后、术后)数据真删除
	 */
	public abstract void deleteByParentDO(AntenAssDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对产科护理记录单(产后、术后)数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(AntenAssDO[] mainDos) throws BizException;
}
