using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.hospitalreport.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.hospitalreport.i
{
    public interface IHospitalreportCrudService
    {
        void delete(HospitalReportDO[] dos);
        HospitalReportDO[] insert(HospitalReportDO[] dos);
        HospitalReportDO[] save(HospitalReportDO[] dos);
        HospitalReportDO[] update(HospitalReportDO[] dos);
        void logicDelete(HospitalReportDO[] dos);
        HospitalReportDO findById(String id);
        HospitalReportDO[] findByIds(String[] ids, FBoolean isLazy);
        HospitalReportDO[] findByBIds(String[] ids, FBoolean isLazy);
        HospitalReportDO[] find(String condition, string orderStr, FBoolean isLazy);
        HospitalReportDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        HospitalReportDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<HospitalReportDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<HospitalReportDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    HospitalReportDO[] enableWithoutFilter(HospitalReportDO[] dos) ;
	    DOWithErrLog enableDO(HospitalReportDO[] dos) ;
	    HospitalReportDO[] disableVOWithoutFilter(HospitalReportDO[] dos);
	    DOWithErrLog disableDO(HospitalReportDO[] dos) ;
	    PagingRtnData<HospitalReportDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    HospitalReportDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    HospitalReportDO[] findByAttrValString(String attr, String value);
	    HospitalReportDO[] findByAttrValStrings(String attr, String[] values);
	    HospitalReportDO[] findByAttrValList(String attr, FArrayList values);
    }
}