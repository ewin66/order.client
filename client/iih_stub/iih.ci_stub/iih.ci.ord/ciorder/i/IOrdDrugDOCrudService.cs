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
    public interface IOrdDrugDOCrudService
    {
        void delete(OrdDrugDO[] dos);
        OrdDrugDO[] insert(OrdDrugDO[] dos);
        OrdDrugDO[] save(OrdDrugDO[] dos);
        OrdDrugDO[] update(OrdDrugDO[] dos);
        void logicDelete(OrdDrugDO[] dos);
        OrdDrugDO findById(String id);
        OrdDrugDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdDrugDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdDrugDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdDrugDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdDrugDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdDrugDO[] enableWithoutFilter(OrdDrugDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdDrugDO[] aggdos) ;
	    OrdDrugDO[] disableVOWithoutFilter(OrdDrugDO[] aggdos);
	    DOWithErrLog disableDO(OrdDrugDO[] aggdos) ;
	    OrdDrugDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdDrugDO[] findByAttrValString(String attr, String value);
	    OrdDrugDO[] findByAttrValStrings(String attr, String[] values);
	    OrdDrugDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdDrugDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}