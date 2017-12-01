using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cior.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cior.i
{
    public interface ICiorappconsultCrudService
    {
        void delete(CiorappconsultAggDO[] dos);
        CiorappconsultAggDO[] insert(CiorappconsultAggDO[] dos);
        CiorappconsultAggDO[] save(CiorappconsultAggDO[] dos);
        CiorappconsultAggDO[] update(CiorappconsultAggDO[] dos);
        void logicDelete(CiorappconsultAggDO[] dos);
        CiorappconsultAggDO findById(String id);
        CiorappconsultAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiorappconsultAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiorappconsultAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiorappconsultAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiorappconsultAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiorappconsultAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(OrdApConsDO[] mainDos);
		void logicDeleteByParentDO(OrdApConsDO[] mainDos);
	    CiorappconsultAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiorappconsultAggDO[] findByAttrValString(String attr, String value);
	    CiorappconsultAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiorappconsultAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
