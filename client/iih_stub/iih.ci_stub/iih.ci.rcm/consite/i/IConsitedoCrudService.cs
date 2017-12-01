using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.consite.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.consite.i
{
    public interface IConsitedoCrudService
    {
        void delete(ConSiteDO[] dos);
        ConSiteDO[] insert(ConSiteDO[] dos);
        ConSiteDO[] save(ConSiteDO[] dos);
        ConSiteDO[] update(ConSiteDO[] dos);
        void logicDelete(ConSiteDO[] dos);
        ConSiteDO findById(String id);
        ConSiteDO[] findByIds(String[] ids, FBoolean isLazy);
        ConSiteDO[] findByBIds(String[] ids, FBoolean isLazy);
        ConSiteDO[] find(String condition, string orderStr, FBoolean isLazy);
        ConSiteDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        ConSiteDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<ConSiteDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<ConSiteDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    ConSiteDO[] enableWithoutFilter(ConSiteDO[] dos) ;
	    DOWithErrLog enableDO(ConSiteDO[] dos) ;
	    ConSiteDO[] disableVOWithoutFilter(ConSiteDO[] dos);
	    DOWithErrLog disableDO(ConSiteDO[] dos) ;
	    PagingRtnData<ConSiteDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    ConSiteDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ConSiteDO[] findByAttrValString(String attr, String value);
	    ConSiteDO[] findByAttrValStrings(String attr, String[] values);
	    ConSiteDO[] findByAttrValList(String attr, FArrayList values);
    }
}