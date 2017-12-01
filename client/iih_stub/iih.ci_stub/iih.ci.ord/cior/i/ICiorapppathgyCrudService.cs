using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cior.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cior.i
{
    public interface ICiorapppathgyCrudService
    {
        void delete(CiorapppathgyAggDO[] dos);
        CiorapppathgyAggDO[] insert(CiorapppathgyAggDO[] dos);
        CiorapppathgyAggDO[] save(CiorapppathgyAggDO[] dos);
        CiorapppathgyAggDO[] update(CiorapppathgyAggDO[] dos);
        void logicDelete(CiorapppathgyAggDO[] dos);
        CiorapppathgyAggDO findById(String id);
        CiorapppathgyAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiorapppathgyAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiorapppathgyAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiorapppathgyAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiorapppathgyAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiorapppathgyAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiorapppathgyAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<CiorapppathgyAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(OrdApPathgyDO[] mainDos);
		void logicDeleteByParentDO(OrdApPathgyDO[] mainDos);
	    CiorapppathgyAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiorapppathgyAggDO[] findByAttrValString(String attr, String value);
	    CiorapppathgyAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiorapppathgyAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}