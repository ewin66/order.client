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
    public interface IRptOpEmpDOCrudService
    {
        void delete(RptOpEmpDO[] dos);
        RptOpEmpDO[] insert(RptOpEmpDO[] dos);
        RptOpEmpDO[] save(RptOpEmpDO[] dos);
        RptOpEmpDO[] update(RptOpEmpDO[] dos);
        void logicDelete(RptOpEmpDO[] dos);
        RptOpEmpDO findById(String id);
        RptOpEmpDO[] findByIds(String[] ids, FBoolean isLazy);
        RptOpEmpDO[] findByBIds(String[] ids, FBoolean isLazy);
        RptOpEmpDO[] find(String condition, string orderStr, FBoolean isLazy);
        RptOpEmpDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<RptOpEmpDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    RptOpEmpDO[] enableWithoutFilter(RptOpEmpDO[] aggdos) ;
	    DOWithErrLog enableDO(RptOpEmpDO[] aggdos) ;
	    RptOpEmpDO[] disableVOWithoutFilter(RptOpEmpDO[] aggdos);
	    DOWithErrLog disableDO(RptOpEmpDO[] aggdos) ;
	    RptOpEmpDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    RptOpEmpDO[] findByAttrValString(String attr, String value);
	    RptOpEmpDO[] findByAttrValStrings(String attr, String[] values);
	    RptOpEmpDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<RptOpEmpDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
