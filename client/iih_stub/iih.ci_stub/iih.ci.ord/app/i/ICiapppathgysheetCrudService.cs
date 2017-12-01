using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.app.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.app.i
{
    public interface ICiapppathgysheetCrudService
    {
        void delete(CiapppathgysheetAggDO[] dos);
        CiapppathgysheetAggDO[] insert(CiapppathgysheetAggDO[] dos);
        CiapppathgysheetAggDO[] save(CiapppathgysheetAggDO[] dos);
        CiapppathgysheetAggDO[] update(CiapppathgysheetAggDO[] dos);
        void logicDelete(CiapppathgysheetAggDO[] dos);
        CiapppathgysheetAggDO findById(String id);
        CiapppathgysheetAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiapppathgysheetAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiapppathgysheetAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiapppathgysheetAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiapppathgysheetAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiapppathgysheetAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiapppathgysheetAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<CiapppathgysheetAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(CiAppPathgySheetDO[] mainDos);
		void logicDeleteByParentDO(CiAppPathgySheetDO[] mainDos);
	    CiapppathgysheetAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiapppathgysheetAggDO[] findByAttrValString(String attr, String value);
	    CiapppathgysheetAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiapppathgysheetAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}