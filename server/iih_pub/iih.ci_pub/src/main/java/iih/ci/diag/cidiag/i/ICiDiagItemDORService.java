package iih.ci.diag.cidiag.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 临床诊断数据维护服务
*/
public interface ICiDiagItemDORService {
	/**
	*  根据id值查找临床诊断数据
	*/	
	public abstract CiDiagItemDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找临床诊断数据集合
	*/	
	public abstract CiDiagItemDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找临床诊断数据集合--大数据量
	*/	
	public abstract CiDiagItemDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找临床诊断数据集合
	*/	
	public abstract CiDiagItemDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找临床诊断数据集合
	*/	
	public abstract CiDiagItemDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<CiDiagItemDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public CiDiagItemDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract CiDiagItemDO[] findByAttrValString(String attr, String value) throws BizException;
	
	public abstract CiDiagItemDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	public abstract CiDiagItemDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
}