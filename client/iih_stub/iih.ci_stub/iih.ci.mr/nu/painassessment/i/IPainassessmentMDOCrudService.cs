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
    public interface IPainassessmentMDOCrudService
    {
        void delete(PainAssessDO[] dos);
        PainAssessDO[] insert(PainAssessDO[] dos);
        PainAssessDO[] save(PainAssessDO[] dos);
        PainAssessDO[] update(PainAssessDO[] dos);
        void logicDelete(PainAssessDO[] dos);
        PainAssessDO findById(String id);
        PainAssessDO[] findByIds(String[] ids, FBoolean isLazy);
        PainAssessDO[] findByBIds(String[] ids, FBoolean isLazy);
        PainAssessDO[] find(String condition, string orderStr, FBoolean isLazy);
        PainAssessDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        PainAssessDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<PainAssessDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<PainAssessDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    PainAssessDO[] enableWithoutFilter(PainAssessDO[] aggdos) ;
	    DOWithErrLog enableDO(PainAssessDO[] aggdos) ;
	    PainAssessDO[] disableVOWithoutFilter(PainAssessDO[] aggdos);
	    DOWithErrLog disableDO(PainAssessDO[] aggdos) ;
	    PainAssessDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    PainAssessDO[] findByAttrValString(String attr, String value);
	    PainAssessDO[] findByAttrValStrings(String attr, String[] values);
	    PainAssessDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<PainAssessDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
