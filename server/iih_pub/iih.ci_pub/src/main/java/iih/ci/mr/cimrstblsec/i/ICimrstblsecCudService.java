package iih.ci.mr.cimrstblsec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimrstblsec.d.CiMrSTblSecDO;
import iih.ci.mr.cimrstblsec.d.CimrstblsecAggDO;

/**
* 临床医疗记录智能表格段落数据维护服务
*/
public interface ICimrstblsecCudService {
	/**
	*  临床医疗记录智能表格段落数据真删除
	*/
    public abstract void delete(CimrstblsecAggDO[] aggdos) throws BizException;
    
    /**
	*  临床医疗记录智能表格段落数据插入保存
	*/
	public abstract CimrstblsecAggDO[] insert(CimrstblsecAggDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录智能表格段落数据保存
	*/
	public abstract CimrstblsecAggDO[] save(CimrstblsecAggDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录智能表格段落数据更新
	*/
	public abstract CimrstblsecAggDO[] update(CimrstblsecAggDO[] aggdos) throws BizException;
	
	/**
	*  临床医疗记录智能表格段落数据逻辑删除
	*/
	public abstract void logicDelete(CimrstblsecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对临床医疗记录智能表格段落数据真删除
	 */
	public abstract void deleteByParentDO(CiMrSTblSecDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对临床医疗记录智能表格段落数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiMrSTblSecDO[] mainDos) throws BizException;
}
