package iih.ci.diag.cidiag.i;

import xap.mw.core.data.BizException;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;

/**
* 临床诊断数据维护服务
*/
public interface ICidiagCudService {
	/**
	*  临床诊断数据真删除
	*/
    public abstract void delete(CidiagAggDO[] aggdos) throws BizException;
    
    /**
	*  临床诊断数据插入保存
	*/
	public abstract CidiagAggDO[] insert(CidiagAggDO[] aggdos) throws BizException;
	
    /**
	*  临床诊断数据保存
	*/
	public abstract CidiagAggDO[] save(CidiagAggDO[] aggdos) throws BizException;
	
    /**
	*  临床诊断数据更新
	*/
	public abstract CidiagAggDO[] update(CidiagAggDO[] aggdos) throws BizException;
	
	/**
	*  临床诊断数据逻辑删除
	*/
	public abstract void logicDelete(CidiagAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对临床诊断数据真删除
	 */
	public abstract void deleteByParentDO(CiDiagDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对临床诊断数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiDiagDO[] mainDos) throws BizException;
}
