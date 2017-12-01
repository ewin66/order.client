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
    public interface IHealthyEduNsRecDOCrudService
    {
        void delete(HealthyEduNsRecDO[] dos);
        HealthyEduNsRecDO[] insert(HealthyEduNsRecDO[] dos);
        HealthyEduNsRecDO[] save(HealthyEduNsRecDO[] dos);
        HealthyEduNsRecDO[] update(HealthyEduNsRecDO[] dos);
        void logicDelete(HealthyEduNsRecDO[] dos);
        HealthyEduNsRecDO findById(String id);
        HealthyEduNsRecDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        HealthyEduNsRecDO[] findByIds(String[] ids, FBoolean isLazy);
        HealthyEduNsRecDO[] findByBIds(String[] ids, FBoolean isLazy);
        HealthyEduNsRecDO[] find(String condition, string orderStr, FBoolean isLazy);
        HealthyEduNsRecDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<HealthyEduNsRecDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<HealthyEduNsRecDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    HealthyEduNsRecDO[] enableWithoutFilter(HealthyEduNsRecDO[] aggdos) ;
	    DOWithErrLog enableDO(HealthyEduNsRecDO[] aggdos) ;
	    HealthyEduNsRecDO[] disableVOWithoutFilter(HealthyEduNsRecDO[] aggdos);
	    DOWithErrLog disableDO(HealthyEduNsRecDO[] aggdos) ;
	    HealthyEduNsRecDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    HealthyEduNsRecDO[] findByAttrValString(String attr, String value);
	    HealthyEduNsRecDO[] findByAttrValStrings(String attr, String[] values);
	    HealthyEduNsRecDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<HealthyEduNsRecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
