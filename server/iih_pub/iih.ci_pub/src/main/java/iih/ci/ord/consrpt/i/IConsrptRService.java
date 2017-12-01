package iih.ci.ord.consrpt.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.ci.ord.consrpt.d.CiOrdConsRptDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 组件数据维护服务
*/
public interface IConsrptRService {
	/**
	*  根据id值查找组件数据
	*/	
	public abstract CiOrdConsRptDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找组件数据集合
	*/	
	public abstract CiOrdConsRptDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找组件数据集合--大数据量
	*/	
	public abstract CiOrdConsRptDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找组件数据集合
	*/	
	public abstract CiOrdConsRptDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找组件数据集合
	*/	
	public abstract CiOrdConsRptDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<CiOrdConsRptDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public CiOrdConsRptDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract CiOrdConsRptDO[] findByAttrValString(String attr, String value, FBoolean isIncludeNullReturn) throws BizException;
	
	public abstract CiOrdConsRptDO[] findByAttrValStrings(String attr, String[] values, FBoolean isIncludeNullReturn) throws BizException;
	
	public abstract CiOrdConsRptDO[] findByAttrValList(String attr, FArrayList values, FBoolean isIncludeNullReturn) throws BizException;

}