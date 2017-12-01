package iih.ci.rcm.consite.i;

import iih.ci.rcm.consite.d.ConSiteDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 院感感染部位数据维护服务
 */
public interface IConsitedoRService {
	/**
	 * 根据id值查找院感感染部位数据
	 */
	public abstract ConSiteDO findById(String id) throws BizException;

	/**
	 * 根据id值集合查找院感感染部位数据集合
	 */
	public abstract ConSiteDO[] findByIds(String[] ids, FBoolean isLazy)
			throws BizException;

	/**
	 * 根据id值集合查找院感感染部位数据集合--大数据量
	 */
	public abstract ConSiteDO[] findByBIds(String[] ids, FBoolean isLazy)
			throws BizException;

	/**
	 * 根据condition条件查找院感感染部位数据集合
	 */
	public abstract ConSiteDO[] find(String whereStr, String orderStr,
			FBoolean isLazy) throws BizException;

	/**
	 * 根据查询方案查找院感感染部位数据集合
	 */
	public abstract ConSiteDO[] findByQScheme(IQryScheme qscheme)
			throws BizException;// 暂不用

	/**
	 * 根据分页信息及查询与分组条件获得分页数据
	 */
	public abstract PagingRtnData<ConSiteDO> findByPageInfo(PaginationInfo pg,
			String wherePart, String orderByPart) throws BizException;

	/**
	 * 根据查询方案查询聚合数据集合
	 * 
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public ConSiteDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, FBoolean isLazy) throws BizException;

	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * 
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract ConSiteDO[] findByAttrValString(String attr, String value)
			throws BizException;

	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * 
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract ConSiteDO[] findByAttrValStrings(String attr,
			String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * 
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract ConSiteDO[] findByAttrValList(String attr, FArrayList values)
			throws BizException;

	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ConSiteDO> findByQCondAndPageInfo(
			QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException;
}