using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciorcof.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciorcof.i
{
    public interface IOrdsheetCrudService
    {
        void delete(CiOrdSheet[] dos);
        CiOrdSheet[] insert(CiOrdSheet[] dos);
        CiOrdSheet[] save(CiOrdSheet[] dos);
        CiOrdSheet[] update(CiOrdSheet[] dos);
        void logicDelete(CiOrdSheet[] dos);
        CiOrdSheet findById(String id);
        CiOrdSheet[] findByIds(String[] ids, FBoolean isLazy);
        CiOrdSheet[] findByBIds(String[] ids, FBoolean isLazy);
        CiOrdSheet[] find(String condition, string orderStr, FBoolean isLazy);
        CiOrdSheet[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiOrdSheet> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiOrdSheet[] enableWithoutFilter(CiOrdSheet[] dos) ;
	    DOWithErrLog enableDO(CiOrdSheet[] dos) ;
	    CiOrdSheet[] disableVOWithoutFilter(CiOrdSheet[] dos);
	    DOWithErrLog disableDO(CiOrdSheet[] dos) ;
	    PagingRtnData<CiOrdSheet> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiOrdSheet[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiOrdSheet[] findByAttrValString(String attr, String value);
	    CiOrdSheet[] findByAttrValStrings(String attr, String[] values);
	    CiOrdSheet[] findByAttrValList(String attr, FArrayList values);
    }
}
