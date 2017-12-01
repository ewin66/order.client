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
    public interface ICriticalillrecCrudService
    {
        void delete(CriticalillrecAggDO[] dos);
        CriticalillrecAggDO[] insert(CriticalillrecAggDO[] dos);
        CriticalillrecAggDO[] save(CriticalillrecAggDO[] dos);
        CriticalillrecAggDO[] update(CriticalillrecAggDO[] dos);
        void logicDelete(CriticalillrecAggDO[] dos);
        CriticalillrecAggDO findById(String id);
        CriticalillrecAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CriticalillrecAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CriticalillrecAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CriticalillrecAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CriticalillrecAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CriticalillrecAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CriticalillrecAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<CriticalillrecAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(CriticalillDO[] mainDos);
		void logicDeleteByParentDO(CriticalillDO[] mainDos);
	    CriticalillrecAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CriticalillrecAggDO[] findByAttrValString(String attr, String value);
	    CriticalillrecAggDO[] findByAttrValStrings(String attr, String[] values);
	    CriticalillrecAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}