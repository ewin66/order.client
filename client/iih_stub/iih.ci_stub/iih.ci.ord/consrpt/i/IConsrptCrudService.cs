using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.consrpt.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.consrpt.i
{
    public interface IConsrptCrudService
    {
        void delete(CiOrdConsRptDO[] dos);
        CiOrdConsRptDO[] insert(CiOrdConsRptDO[] dos);
        CiOrdConsRptDO[] save(CiOrdConsRptDO[] dos);
        CiOrdConsRptDO[] update(CiOrdConsRptDO[] dos);
        void logicDelete(CiOrdConsRptDO[] dos);
        CiOrdConsRptDO findById(String id);
        CiOrdConsRptDO[] findByIds(String[] ids, FBoolean isLazy);
        CiOrdConsRptDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiOrdConsRptDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiOrdConsRptDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiOrdConsRptDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiOrdConsRptDO[] enableWithoutFilter(CiOrdConsRptDO[] dos) ;
	    DOWithErrLog enableDO(CiOrdConsRptDO[] dos) ;
	    CiOrdConsRptDO[] disableVOWithoutFilter(CiOrdConsRptDO[] dos);
	    DOWithErrLog disableDO(CiOrdConsRptDO[] dos) ;
	    PagingRtnData<CiOrdConsRptDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiOrdConsRptDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiOrdConsRptDO[] findByAttrValString(String attr, String value);
	    CiOrdConsRptDO[] findByAttrValStrings(String attr, String[] values);
	    CiOrdConsRptDO[] findByAttrValList(String attr, FArrayList values);
    }
}
