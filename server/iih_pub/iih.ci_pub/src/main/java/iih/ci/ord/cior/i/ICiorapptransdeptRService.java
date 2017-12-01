package iih.ci.ord.cior.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.ci.ord.cior.d.OrdApTransDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 医嘱转科申请数据维护服务
*/
public interface ICiorapptransdeptRService {
	/**
	*  根据id值查找医嘱转科申请数据
	*/	
	public abstract OrdApTransDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找医嘱转科申请数据集合
	*/	
	public abstract OrdApTransDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找医嘱转科申请数据集合--大数据量
	*/	
	public abstract OrdApTransDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找医嘱转科申请数据集合
	*/	
	public abstract OrdApTransDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找医嘱转科申请数据集合
	*/	
	public abstract OrdApTransDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<OrdApTransDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public OrdApTransDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract OrdApTransDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract OrdApTransDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract OrdApTransDO[] findByAttrValList(String attr, FArrayList values) throws BizException;

}