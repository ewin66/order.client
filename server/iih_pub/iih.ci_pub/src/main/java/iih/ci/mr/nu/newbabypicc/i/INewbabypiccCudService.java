package iih.ci.mr.nu.newbabypicc.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.newbabypicc.d.NewBabyPiccDO;
import iih.ci.mr.nu.newbabypicc.d.NewbabypiccAggDO;

/**
* 新生儿科picc护理信息数据维护服务
*/
public interface INewbabypiccCudService {
	/**
	*  新生儿科picc护理信息数据真删除
	*/
    public abstract void delete(NewbabypiccAggDO[] aggdos) throws BizException;
    
    /**
	*  新生儿科picc护理信息数据插入保存
	*/
	public abstract NewbabypiccAggDO[] insert(NewbabypiccAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿科picc护理信息数据保存
	*/
	public abstract NewbabypiccAggDO[] save(NewbabypiccAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿科picc护理信息数据更新
	*/
	public abstract NewbabypiccAggDO[] update(NewbabypiccAggDO[] aggdos) throws BizException;
	
	/**
	*  新生儿科picc护理信息数据逻辑删除
	*/
	public abstract void logicDelete(NewbabypiccAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对新生儿科picc护理信息数据真删除
	 */
	public abstract void deleteByParentDO(NewBabyPiccDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对新生儿科picc护理信息数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NewBabyPiccDO[] mainDos) throws BizException;
}
