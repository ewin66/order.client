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
    public interface IHealthyedunsrecCrudService
    {
        void delete(HealthyedunsrecAggDO[] dos);
        HealthyedunsrecAggDO[] insert(HealthyedunsrecAggDO[] dos);
        HealthyedunsrecAggDO[] save(HealthyedunsrecAggDO[] dos);
        HealthyedunsrecAggDO[] update(HealthyedunsrecAggDO[] dos);
        void logicDelete(HealthyedunsrecAggDO[] dos);
        HealthyedunsrecAggDO findById(String id);
        HealthyedunsrecAggDO[] findByIds(String[] ids, FBoolean isLazy);
        HealthyedunsrecAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        HealthyedunsrecAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        HealthyedunsrecAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        HealthyedunsrecAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<HealthyedunsrecAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<HealthyedunsrecAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<HealthyedunsrecAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(HealthyEduNsDO[] mainDos);
		void logicDeleteByParentDO(HealthyEduNsDO[] mainDos);
	    HealthyedunsrecAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    HealthyedunsrecAggDO[] findByAttrValString(String attr, String value);
	    HealthyedunsrecAggDO[] findByAttrValStrings(String attr, String[] values);
	    HealthyedunsrecAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}