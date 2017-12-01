using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.criticalillrec.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.criticalillrec.i
{
    public interface ICriticalillrecMDOCrudService
    {
        void delete(CriticalillDO[] dos);
        CriticalillDO[] insert(CriticalillDO[] dos);
        CriticalillDO[] save(CriticalillDO[] dos);
        CriticalillDO[] update(CriticalillDO[] dos);
        void logicDelete(CriticalillDO[] dos);
        CriticalillDO findById(String id);
        CriticalillDO[] findByIds(String[] ids, FBoolean isLazy);
        CriticalillDO[] findByBIds(String[] ids, FBoolean isLazy);
        CriticalillDO[] find(String condition, string orderStr, FBoolean isLazy);
        CriticalillDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CriticalillDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CriticalillDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CriticalillDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CriticalillDO[] enableWithoutFilter(CriticalillDO[] aggdos) ;
	    DOWithErrLog enableDO(CriticalillDO[] aggdos) ;
	    CriticalillDO[] disableVOWithoutFilter(CriticalillDO[] aggdos);
	    DOWithErrLog disableDO(CriticalillDO[] aggdos) ;
	    CriticalillDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CriticalillDO[] findByAttrValString(String attr, String value);
	    CriticalillDO[] findByAttrValStrings(String attr, String[] values);
	    CriticalillDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CriticalillDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
