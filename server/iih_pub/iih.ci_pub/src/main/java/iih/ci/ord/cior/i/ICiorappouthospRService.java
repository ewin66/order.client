package iih.ci.ord.cior.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.ci.ord.cior.d.OrdApOutDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医嘱出院申请数据维护服务
*/
public interface ICiorappouthospRService {
	/**
	*  根据id值查找医嘱出院申请数据
	*/	
	public abstract OrdApOutDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医嘱出院申请数据集合
	*/	
	public abstract OrdApOutDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医嘱出院申请数据集合--大数据量
	*/	
	public abstract OrdApOutDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医嘱出院申请数据集合
	*/	
	public abstract OrdApOutDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医嘱出院申请数据集合
	*/	
	public abstract OrdApOutDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<OrdApOutDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public OrdApOutDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract OrdApOutDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract OrdApOutDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract OrdApOutDO[] findByAttrValList(String attr, FArrayList values) throws BizException;

}