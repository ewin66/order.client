package iih.ci.rcm.hosmiddle.i;

import iih.ci.rcm.hosmiddle.d.HOSMIDDLEDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 组件数据维护服务
 */
public interface IHosmiddleRService {
	/**
	 * 根据id值查找组件数据
	 */
	public abstract HOSMIDDLEDO findById(String id) throws BizException;

	/**
	 * 根据id值集合查找组件数据集合
	 */
	public abstract HOSMIDDLEDO[] findByIds(String[] ids, FBoolean isLazy)
			throws BizException;

	/**
	 * 根据id值集合查找组件数据集合--大数据量
	 */
	public abstract HOSMIDDLEDO[] findByBIds(String[] ids, FBoolean isLazy)
			throws BizException;

	/**
	 * 根据condition条件查找组件数据集合
	 */
	public abstract HOSMIDDLEDO[] find(String whereStr, String orderStr,
			FBoolean isLazy) throws BizException;

	/**
	 * 根据查询方案查找组件数据集合
	 */
	public abstract HOSMIDDLEDO[] findByQScheme(IQryScheme qscheme)
			throws BizException;// 暂不用

	/**
	 * 根据分页信息及查询与分组条件获得分页数据
	 */
	public abstract PagingRtnData<HOSMIDDLEDO> findByPageInfo(
			PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException;

	/**
	 * 根据查询方案查询聚合数据集合
	 * 
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public HOSMIDDLEDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, FBoolean isLazy) throws BizException;

	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * 
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract HOSMIDDLEDO[] findByAttrValString(String attr, String value)
			throws BizException;

	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * 
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract HOSMIDDLEDO[] findByAttrValStrings(String attr,
			String[] values) throws BizException;

	/**
	 * 根据DO某一属性值List查询DO数据
	 * 
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract HOSMIDDLEDO[] findByAttrValList(String attr,
			FArrayList values) throws BizException;

	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HOSMIDDLEDO> findByQCondAndPageInfo(
			QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException;
}