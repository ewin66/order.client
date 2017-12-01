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
    public interface ICiapptreatexecMDOCrudService
    {
        void delete(CiAppTreatExecDO[] dos);
        CiAppTreatExecDO[] insert(CiAppTreatExecDO[] dos);
        CiAppTreatExecDO[] save(CiAppTreatExecDO[] dos);
        CiAppTreatExecDO[] update(CiAppTreatExecDO[] dos);
        void logicDelete(CiAppTreatExecDO[] dos);
        CiAppTreatExecDO findById(String id);
        CiAppTreatExecDO[] findByIds(String[] ids, FBoolean isLazy);
        CiAppTreatExecDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiAppTreatExecDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiAppTreatExecDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiAppTreatExecDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiAppTreatExecDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiAppTreatExecDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiAppTreatExecDO[] enableWithoutFilter(CiAppTreatExecDO[] aggdos) ;
	    DOWithErrLog enableDO(CiAppTreatExecDO[] aggdos) ;
	    CiAppTreatExecDO[] disableVOWithoutFilter(CiAppTreatExecDO[] aggdos);
	    DOWithErrLog disableDO(CiAppTreatExecDO[] aggdos) ;
	    CiAppTreatExecDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiAppTreatExecDO[] findByAttrValString(String attr, String value);
	    CiAppTreatExecDO[] findByAttrValStrings(String attr, String[] values);
	    CiAppTreatExecDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiAppTreatExecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
