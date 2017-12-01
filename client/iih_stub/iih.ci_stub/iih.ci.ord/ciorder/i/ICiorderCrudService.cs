using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciorder.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciorder.i
{
    public interface ICiorderCrudService
    {
        void delete(CiorderAggDO[] dos);
        CiorderAggDO[] insert(CiorderAggDO[] dos);
        CiorderAggDO[] save(CiorderAggDO[] dos);
        CiorderAggDO[] update(CiorderAggDO[] dos);
        void logicDelete(CiorderAggDO[] dos);
        CiorderAggDO findById(String id);
        CiorderAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiorderAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiorderAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiorderAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiorderAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiorderAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(CiOrderDO[] mainDos);
		void logicDeleteByParentDO(CiOrderDO[] mainDos);
	    CiorderAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiorderAggDO[] findByAttrValString(String attr, String value);
	    CiorderAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiorderAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}