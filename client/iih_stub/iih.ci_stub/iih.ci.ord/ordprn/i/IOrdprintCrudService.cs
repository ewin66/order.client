using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ordprn.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ordprn.i
{
    public interface IOrdprintCrudService
    {
        void delete(OrdPrintDO[] dos);
        OrdPrintDO[] insert(OrdPrintDO[] dos);
        OrdPrintDO[] save(OrdPrintDO[] dos);
        OrdPrintDO[] update(OrdPrintDO[] dos);
        void logicDelete(OrdPrintDO[] dos);
        OrdPrintDO findById(String id);
        OrdPrintDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdPrintDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdPrintDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdPrintDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdPrintDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdPrintDO[] enableWithoutFilter(OrdPrintDO[] dos) ;
	    DOWithErrLog enableDO(OrdPrintDO[] dos) ;
	    OrdPrintDO[] disableVOWithoutFilter(OrdPrintDO[] dos);
	    DOWithErrLog disableDO(OrdPrintDO[] dos) ;
	    PagingRtnData<OrdPrintDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OrdPrintDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdPrintDO[] findByAttrValString(String attr, String value);
	    OrdPrintDO[] findByAttrValStrings(String attr, String[] values);
	    OrdPrintDO[] findByAttrValList(String attr, FArrayList values);
    }
}
