package iih.ci.mr.cimrfs.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 临床医疗记录流数据数据维护服务
*/
public interface ICimrfsRService {
	/**
	*  根据id值查找临床医疗记录流数据数据
	*/	
	public abstract CiMrFsDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找临床医疗记录流数据数据集合
	*/	
	public abstract CiMrFsDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找临床医疗记录流数据数据集合--大数据量
	*/	
	public abstract CiMrFsDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找临床医疗记录流数据数据集合
	*/	
	public abstract CiMrFsDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	*  根据查询方案查找临床医疗记录流数据数据集合
	*/	
	public abstract CiMrFsDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<CiMrFsDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public CiMrFsDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;

}