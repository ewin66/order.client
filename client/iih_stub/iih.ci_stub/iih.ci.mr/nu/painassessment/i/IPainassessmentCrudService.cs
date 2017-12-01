using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.painassessment.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.painassessment.i
{
    public interface IPainassessmentCrudService
    {
        void delete(PainassessmentAggDO[] dos);
        PainassessmentAggDO[] insert(PainassessmentAggDO[] dos);
        PainassessmentAggDO[] save(PainassessmentAggDO[] dos);
        PainassessmentAggDO[] update(PainassessmentAggDO[] dos);
        void logicDelete(PainassessmentAggDO[] dos);
        PainassessmentAggDO findById(String id);
        PainassessmentAggDO[] findByIds(String[] ids, FBoolean isLazy);
        PainassessmentAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        PainassessmentAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        PainassessmentAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        PainassessmentAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<PainassessmentAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<PainassessmentAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<PainassessmentAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(PainAssessDO[] mainDos);
		void logicDeleteByParentDO(PainAssessDO[] mainDos);
	    PainassessmentAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    PainassessmentAggDO[] findByAttrValString(String attr, String value);
	    PainassessmentAggDO[] findByAttrValStrings(String attr, String[] values);
	    PainassessmentAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}