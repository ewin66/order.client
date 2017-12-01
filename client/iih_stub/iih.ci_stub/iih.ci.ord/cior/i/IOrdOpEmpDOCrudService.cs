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
    public interface IOrdOpEmpDOCrudService
    {
        void delete(OrdOpEmpDO[] dos);
        OrdOpEmpDO[] insert(OrdOpEmpDO[] dos);
        OrdOpEmpDO[] save(OrdOpEmpDO[] dos);
        OrdOpEmpDO[] update(OrdOpEmpDO[] dos);
        void logicDelete(OrdOpEmpDO[] dos);
        OrdOpEmpDO findById(String id);
        OrdOpEmpDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdOpEmpDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdOpEmpDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdOpEmpDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdOpEmpDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdOpEmpDO[] enableWithoutFilter(OrdOpEmpDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdOpEmpDO[] aggdos) ;
	    OrdOpEmpDO[] disableVOWithoutFilter(OrdOpEmpDO[] aggdos);
	    DOWithErrLog disableDO(OrdOpEmpDO[] aggdos) ;
	    OrdOpEmpDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdOpEmpDO[] findByAttrValString(String attr, String value);
	    OrdOpEmpDO[] findByAttrValStrings(String attr, String[] values);
	    OrdOpEmpDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdOpEmpDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
