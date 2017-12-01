package iih.ci.mr.nu.newbornveinnur.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.newbornveinnur.d.NewBornVeinNurDO;
import iih.ci.mr.nu.newbornveinnur.d.NewbornveinnurAggDO;

/**
* 新生儿科脐静脉护理记录单（一）数据维护服务
*/
public interface INewbornveinnurCudService {
	/**
	*  新生儿科脐静脉护理记录单（一）数据真删除
	*/
    public abstract void delete(NewbornveinnurAggDO[] aggdos) throws BizException;
    
    /**
	*  新生儿科脐静脉护理记录单（一）数据插入保存
	*/
	public abstract NewbornveinnurAggDO[] insert(NewbornveinnurAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿科脐静脉护理记录单（一）数据保存
	*/
	public abstract NewbornveinnurAggDO[] save(NewbornveinnurAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿科脐静脉护理记录单（一）数据更新
	*/
	public abstract NewbornveinnurAggDO[] update(NewbornveinnurAggDO[] aggdos) throws BizException;
	
	/**
	*  新生儿科脐静脉护理记录单（一）数据逻辑删除
	*/
	public abstract void logicDelete(NewbornveinnurAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对新生儿科脐静脉护理记录单（一）数据真删除
	 */
	public abstract void deleteByParentDO(NewBornVeinNurDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对新生儿科脐静脉护理记录单（一）数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NewBornVeinNurDO[] mainDos) throws BizException;
}
