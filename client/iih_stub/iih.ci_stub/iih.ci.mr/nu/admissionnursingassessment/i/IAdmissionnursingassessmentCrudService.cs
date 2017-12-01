using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.admissionnursingassessment.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.admissionnursingassessment.i
{
    public interface IAdmissionnursingassessmentCrudService
    {
        void delete(AdmissionNursingAssessmentDO[] dos);
        AdmissionNursingAssessmentDO[] insert(AdmissionNursingAssessmentDO[] dos);
        AdmissionNursingAssessmentDO[] save(AdmissionNursingAssessmentDO[] dos);
        AdmissionNursingAssessmentDO[] update(AdmissionNursingAssessmentDO[] dos);
        void logicDelete(AdmissionNursingAssessmentDO[] dos);
        AdmissionNursingAssessmentDO findById(String id);
        AdmissionNursingAssessmentDO[] findByIds(String[] ids, FBoolean isLazy);
        AdmissionNursingAssessmentDO[] findByBIds(String[] ids, FBoolean isLazy);
        AdmissionNursingAssessmentDO[] find(String condition, string orderStr, FBoolean isLazy);
        AdmissionNursingAssessmentDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        AdmissionNursingAssessmentDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AdmissionNursingAssessmentDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<AdmissionNursingAssessmentDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    AdmissionNursingAssessmentDO[] enableWithoutFilter(AdmissionNursingAssessmentDO[] dos) ;
	    DOWithErrLog enableDO(AdmissionNursingAssessmentDO[] dos) ;
	    AdmissionNursingAssessmentDO[] disableVOWithoutFilter(AdmissionNursingAssessmentDO[] dos);
	    DOWithErrLog disableDO(AdmissionNursingAssessmentDO[] dos) ;
	    PagingRtnData<AdmissionNursingAssessmentDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    AdmissionNursingAssessmentDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AdmissionNursingAssessmentDO[] findByAttrValString(String attr, String value);
	    AdmissionNursingAssessmentDO[] findByAttrValStrings(String attr, String[] values);
	    AdmissionNursingAssessmentDO[] findByAttrValList(String attr, FArrayList values);
    }
}