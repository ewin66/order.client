using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.concerndep.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.concerndep.i
{
    public interface IConcerndepCrudService
    {
        void delete(ConcernDepDO[] dos);
        ConcernDepDO[] insert(ConcernDepDO[] dos);
        ConcernDepDO[] save(ConcernDepDO[] dos);
        ConcernDepDO[] update(ConcernDepDO[] dos);
        void logicDelete(ConcernDepDO[] dos);
        ConcernDepDO findById(String id);
        ConcernDepDO[] findByIds(String[] ids, FBoolean isLazy);
        ConcernDepDO[] findByBIds(String[] ids, FBoolean isLazy);
        ConcernDepDO[] find(String condition, string orderStr, FBoolean isLazy);
        ConcernDepDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<ConcernDepDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    ConcernDepDO[] enableWithoutFilter(ConcernDepDO[] dos) ;
	    DOWithErrLog enableDO(ConcernDepDO[] dos) ;
	    ConcernDepDO[] disableVOWithoutFilter(ConcernDepDO[] dos);
	    DOWithErrLog disableDO(ConcernDepDO[] dos) ;
	    PagingRtnData<ConcernDepDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    ConcernDepDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ConcernDepDO[] findByAttrValString(String attr, String value);
	    ConcernDepDO[] findByAttrValStrings(String attr, String[] values);
	    ConcernDepDO[] findByAttrValList(String attr, FArrayList values);
    }
}
