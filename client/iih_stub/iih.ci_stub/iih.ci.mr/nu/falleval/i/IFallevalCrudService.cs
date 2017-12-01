using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.falleval.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.falleval.i
{
    public interface IFallevalCrudService
    {
        void delete(FallEvalDO[] dos);
        FallEvalDO[] insert(FallEvalDO[] dos);
        FallEvalDO[] save(FallEvalDO[] dos);
        FallEvalDO[] update(FallEvalDO[] dos);
        void logicDelete(FallEvalDO[] dos);
        FallEvalDO findById(String id);
        FallEvalDO[] findByIds(String[] ids, FBoolean isLazy);
        FallEvalDO[] findByBIds(String[] ids, FBoolean isLazy);
        FallEvalDO[] find(String condition, string orderStr, FBoolean isLazy);
        FallEvalDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        FallEvalDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<FallEvalDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<FallEvalDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    FallEvalDO[] enableWithoutFilter(FallEvalDO[] dos) ;
	    DOWithErrLog enableDO(FallEvalDO[] dos) ;
	    FallEvalDO[] disableVOWithoutFilter(FallEvalDO[] dos);
	    DOWithErrLog disableDO(FallEvalDO[] dos) ;
	    PagingRtnData<FallEvalDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    FallEvalDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    FallEvalDO[] findByAttrValString(String attr, String value);
	    FallEvalDO[] findByAttrValStrings(String attr, String[] values);
	    FallEvalDO[] findByAttrValList(String attr, FArrayList values);
    }
}