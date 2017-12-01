package iih.ci.ord.app.i;

import xap.sys.appfw.tmpl.qryscheme.IQryScheme;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
* 门诊诊疗执行单数据维护服务
*/
public interface ICiapptreatexecMDORService {
	/**
	*  根据id值查找门诊诊疗执行单数据
	*/	
	public abstract CiAppTreatExecDO findById(String id) throws BizException;
	
	/**
	*  根据id值集合查找门诊诊疗执行单数据集合
	*/	
	public abstract CiAppTreatExecDO[] findByIds(String[] ids, FBoolean isLazy) throws BizException;
	
	/**
	*  根据id值集合查找门诊诊疗执行单数据集合--大数据量
	*/	
	public abstract CiAppTreatExecDO[] findByBIds(String[] ids, FBoolean isLazy) throws BizException;	
    
    /**
	*  根据condition条件查找门诊诊疗执行单数据集合
	*/	
	public abstract CiAppTreatExecDO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;

	/**
	 * 根据condition条件及管控查找门诊诊疗执行单数据集合
	 */
//	public abstract CiAppTreatExecDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
		
	/**
	*  根据查询方案查找门诊诊疗执行单数据集合
	*/	
	public abstract CiAppTreatExecDO[] findByQScheme(IQryScheme qscheme) throws BizException;//暂不用
	
	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<CiAppTreatExecDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 根据分页信息、查询与分组条件及管控获得分页数据
	 */
//	public abstract PagingRtnData<CiAppTreatExecDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr) throws BizException;
	
	/**
	 * 根据查询方案查询聚合数据集合
	 * @param qscheme
	 * @return
	 * @throws BizException
	 */
	public CiAppTreatExecDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值查询DO数据
	 * @param attr
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public abstract CiAppTreatExecDO[] findByAttrValString(String attr, String value) throws BizException;
	
	/**
	 * 根据DO某一字符类型属性值数组查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract CiAppTreatExecDO[] findByAttrValStrings(String attr, String[] values) throws BizException;
	
	/**
	 * 根据DO某一属性值List查询DO数据
	 * @param attr
	 * @param values
	 * @return
	 * @throws BizException
	 */
	public abstract CiAppTreatExecDO[] findByAttrValList(String attr, FArrayList values) throws BizException;
	
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CiAppTreatExecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
}