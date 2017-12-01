using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.cideathcert.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.cideathcert.i
{
    public interface ICideathcertCrudService
    {
        void delete(CideathcertDO[] dos);
        CideathcertDO[] insert(CideathcertDO[] dos);
        CideathcertDO[] save(CideathcertDO[] dos);
        CideathcertDO[] update(CideathcertDO[] dos);
        void logicDelete(CideathcertDO[] dos);
        CideathcertDO findById(String id);
        CideathcertDO[] findByIds(String[] ids, FBoolean isLazy);
        CideathcertDO[] findByBIds(String[] ids, FBoolean isLazy);
        CideathcertDO[] find(String condition, string orderStr, FBoolean isLazy);
        CideathcertDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CideathcertDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CideathcertDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CideathcertDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CideathcertDO[] enableWithoutFilter(CideathcertDO[] dos) ;
	    DOWithErrLog enableDO(CideathcertDO[] dos) ;
	    CideathcertDO[] disableVOWithoutFilter(CideathcertDO[] dos);
	    DOWithErrLog disableDO(CideathcertDO[] dos) ;
	    PagingRtnData<CideathcertDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CideathcertDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CideathcertDO[] findByAttrValString(String attr, String value);
	    CideathcertDO[] findByAttrValStrings(String attr, String[] values);
	    CideathcertDO[] findByAttrValList(String attr, FArrayList values);
    }
}