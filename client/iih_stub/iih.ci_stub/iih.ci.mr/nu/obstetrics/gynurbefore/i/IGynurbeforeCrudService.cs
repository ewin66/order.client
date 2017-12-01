using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.gynurbefore.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.gynurbefore.i
{
    public interface IGynurbeforeCrudService
    {
        void delete(GynurbeforeAggDO[] dos);
        GynurbeforeAggDO[] insert(GynurbeforeAggDO[] dos);
        GynurbeforeAggDO[] save(GynurbeforeAggDO[] dos);
        GynurbeforeAggDO[] update(GynurbeforeAggDO[] dos);
        void logicDelete(GynurbeforeAggDO[] dos);
        GynurbeforeAggDO findById(String id);
        GynurbeforeAggDO[] findByIds(String[] ids, FBoolean isLazy);
        GynurbeforeAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        GynurbeforeAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        GynurbeforeAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        GynurbeforeAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<GynurbeforeAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<GynurbeforeAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<GynurbeforeAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(GyNurBeforeAssDO[] mainDos);
		void logicDeleteByParentDO(GyNurBeforeAssDO[] mainDos);
	    GynurbeforeAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    GynurbeforeAggDO[] findByAttrValString(String attr, String value);
	    GynurbeforeAggDO[] findByAttrValStrings(String attr, String[] values);
	    GynurbeforeAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}