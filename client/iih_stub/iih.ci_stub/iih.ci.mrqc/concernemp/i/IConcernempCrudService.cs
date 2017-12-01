using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.concernemp.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.concernemp.i
{
    public interface IConcernempCrudService
    {
        void delete(ConcernEmpDO[] dos);
        ConcernEmpDO[] insert(ConcernEmpDO[] dos);
        ConcernEmpDO[] save(ConcernEmpDO[] dos);
        ConcernEmpDO[] update(ConcernEmpDO[] dos);
        void logicDelete(ConcernEmpDO[] dos);
        ConcernEmpDO findById(String id);
        ConcernEmpDO[] findByIds(String[] ids, FBoolean isLazy);
        ConcernEmpDO[] findByBIds(String[] ids, FBoolean isLazy);
        ConcernEmpDO[] find(String condition, string orderStr, FBoolean isLazy);
        ConcernEmpDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<ConcernEmpDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    ConcernEmpDO[] enableWithoutFilter(ConcernEmpDO[] dos) ;
	    DOWithErrLog enableDO(ConcernEmpDO[] dos) ;
	    ConcernEmpDO[] disableVOWithoutFilter(ConcernEmpDO[] dos);
	    DOWithErrLog disableDO(ConcernEmpDO[] dos) ;
	    PagingRtnData<ConcernEmpDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    ConcernEmpDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ConcernEmpDO[] findByAttrValString(String attr, String value);
	    ConcernEmpDO[] findByAttrValStrings(String attr, String[] values);
	    ConcernEmpDO[] findByAttrValList(String attr, FArrayList values);
    }
}
