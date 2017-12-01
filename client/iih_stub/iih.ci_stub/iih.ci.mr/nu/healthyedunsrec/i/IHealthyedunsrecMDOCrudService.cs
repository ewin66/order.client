using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.healthyedunsrec.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.healthyedunsrec.i
{
    public interface IHealthyedunsrecMDOCrudService
    {
        void delete(HealthyEduNsDO[] dos);
        HealthyEduNsDO[] insert(HealthyEduNsDO[] dos);
        HealthyEduNsDO[] save(HealthyEduNsDO[] dos);
        HealthyEduNsDO[] update(HealthyEduNsDO[] dos);
        void logicDelete(HealthyEduNsDO[] dos);
        HealthyEduNsDO findById(String id);
        HealthyEduNsDO[] findByIds(String[] ids, FBoolean isLazy);
        HealthyEduNsDO[] findByBIds(String[] ids, FBoolean isLazy);
        HealthyEduNsDO[] find(String condition, string orderStr, FBoolean isLazy);
        HealthyEduNsDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        HealthyEduNsDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<HealthyEduNsDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<HealthyEduNsDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    HealthyEduNsDO[] enableWithoutFilter(HealthyEduNsDO[] aggdos) ;
	    DOWithErrLog enableDO(HealthyEduNsDO[] aggdos) ;
	    HealthyEduNsDO[] disableVOWithoutFilter(HealthyEduNsDO[] aggdos);
	    DOWithErrLog disableDO(HealthyEduNsDO[] aggdos) ;
	    HealthyEduNsDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    HealthyEduNsDO[] findByAttrValString(String attr, String value);
	    HealthyEduNsDO[] findByAttrValStrings(String attr, String[] values);
	    HealthyEduNsDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<HealthyEduNsDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
