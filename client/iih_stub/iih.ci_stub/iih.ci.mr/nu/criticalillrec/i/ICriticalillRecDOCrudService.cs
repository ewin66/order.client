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
    public interface ICriticalillRecDOCrudService
    {
        void delete(CriticalillRecDO[] dos);
        CriticalillRecDO[] insert(CriticalillRecDO[] dos);
        CriticalillRecDO[] save(CriticalillRecDO[] dos);
        CriticalillRecDO[] update(CriticalillRecDO[] dos);
        void logicDelete(CriticalillRecDO[] dos);
        CriticalillRecDO findById(String id);
        CriticalillRecDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        CriticalillRecDO[] findByIds(String[] ids, FBoolean isLazy);
        CriticalillRecDO[] findByBIds(String[] ids, FBoolean isLazy);
        CriticalillRecDO[] find(String condition, string orderStr, FBoolean isLazy);
        CriticalillRecDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CriticalillRecDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CriticalillRecDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CriticalillRecDO[] enableWithoutFilter(CriticalillRecDO[] aggdos) ;
	    DOWithErrLog enableDO(CriticalillRecDO[] aggdos) ;
	    CriticalillRecDO[] disableVOWithoutFilter(CriticalillRecDO[] aggdos);
	    DOWithErrLog disableDO(CriticalillRecDO[] aggdos) ;
	    CriticalillRecDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CriticalillRecDO[] findByAttrValString(String attr, String value);
	    CriticalillRecDO[] findByAttrValStrings(String attr, String[] values);
	    CriticalillRecDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CriticalillRecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
