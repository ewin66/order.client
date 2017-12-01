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
    public interface ISrvvssheetCrudService
    {
        void delete(CiOrSrvVsSheet[] dos);
        CiOrSrvVsSheet[] insert(CiOrSrvVsSheet[] dos);
        CiOrSrvVsSheet[] save(CiOrSrvVsSheet[] dos);
        CiOrSrvVsSheet[] update(CiOrSrvVsSheet[] dos);
        void logicDelete(CiOrSrvVsSheet[] dos);
        CiOrSrvVsSheet findById(String id);
        CiOrSrvVsSheet[] findByIds(String[] ids, FBoolean isLazy);
        CiOrSrvVsSheet[] findByBIds(String[] ids, FBoolean isLazy);
        CiOrSrvVsSheet[] find(String condition, string orderStr, FBoolean isLazy);
        CiOrSrvVsSheet[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiOrSrvVsSheet> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiOrSrvVsSheet[] enableWithoutFilter(CiOrSrvVsSheet[] dos) ;
	    DOWithErrLog enableDO(CiOrSrvVsSheet[] dos) ;
	    CiOrSrvVsSheet[] disableVOWithoutFilter(CiOrSrvVsSheet[] dos);
	    DOWithErrLog disableDO(CiOrSrvVsSheet[] dos) ;
	    PagingRtnData<CiOrSrvVsSheet> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiOrSrvVsSheet[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiOrSrvVsSheet[] findByAttrValString(String attr, String value);
	    CiOrSrvVsSheet[] findByAttrValStrings(String attr, String[] values);
	    CiOrSrvVsSheet[] findByAttrValList(String attr, FArrayList values);
    }
}
