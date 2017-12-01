using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.app.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.app.i
{
    public interface ICiAppTreatExecOrDOCrudService
    {
        void delete(CiAppTreatExecOrDO[] dos);
        CiAppTreatExecOrDO[] insert(CiAppTreatExecOrDO[] dos);
        CiAppTreatExecOrDO[] save(CiAppTreatExecOrDO[] dos);
        CiAppTreatExecOrDO[] update(CiAppTreatExecOrDO[] dos);
        void logicDelete(CiAppTreatExecOrDO[] dos);
        CiAppTreatExecOrDO findById(String id);
        CiAppTreatExecOrDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        CiAppTreatExecOrDO[] findByIds(String[] ids, FBoolean isLazy);
        CiAppTreatExecOrDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiAppTreatExecOrDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiAppTreatExecOrDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiAppTreatExecOrDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiAppTreatExecOrDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiAppTreatExecOrDO[] enableWithoutFilter(CiAppTreatExecOrDO[] aggdos) ;
	    DOWithErrLog enableDO(CiAppTreatExecOrDO[] aggdos) ;
	    CiAppTreatExecOrDO[] disableVOWithoutFilter(CiAppTreatExecOrDO[] aggdos);
	    DOWithErrLog disableDO(CiAppTreatExecOrDO[] aggdos) ;
	    CiAppTreatExecOrDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiAppTreatExecOrDO[] findByAttrValString(String attr, String value);
	    CiAppTreatExecOrDO[] findByAttrValStrings(String attr, String[] values);
	    CiAppTreatExecOrDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiAppTreatExecOrDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
