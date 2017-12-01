using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.gynurafter.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.gynurafter.i
{
    public interface IGynurafterCrudService
    {
        void delete(GynurafterAggDO[] dos);
        GynurafterAggDO[] insert(GynurafterAggDO[] dos);
        GynurafterAggDO[] save(GynurafterAggDO[] dos);
        GynurafterAggDO[] update(GynurafterAggDO[] dos);
        void logicDelete(GynurafterAggDO[] dos);
        GynurafterAggDO findById(String id);
        GynurafterAggDO[] findByIds(String[] ids, FBoolean isLazy);
        GynurafterAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        GynurafterAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        GynurafterAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        GynurafterAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<GynurafterAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<GynurafterAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<GynurafterAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(GyNurAfterAssDO[] mainDos);
		void logicDeleteByParentDO(GyNurAfterAssDO[] mainDos);
	    GynurafterAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    GynurafterAggDO[] findByAttrValString(String attr, String value);
	    GynurafterAggDO[] findByAttrValStrings(String attr, String[] values);
	    GynurafterAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}