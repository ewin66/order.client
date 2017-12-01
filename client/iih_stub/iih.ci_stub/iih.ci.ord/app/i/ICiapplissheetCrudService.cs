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
    public interface ICiapplissheetCrudService
    {
        void delete(CiapplissheetAggDO[] dos);
        CiapplissheetAggDO[] insert(CiapplissheetAggDO[] dos);
        CiapplissheetAggDO[] save(CiapplissheetAggDO[] dos);
        CiapplissheetAggDO[] update(CiapplissheetAggDO[] dos);
        void logicDelete(CiapplissheetAggDO[] dos);
        CiapplissheetAggDO findById(String id);
        CiapplissheetAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiapplissheetAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiapplissheetAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiapplissheetAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiapplissheetAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiapplissheetAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiapplissheetAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<CiapplissheetAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(CiAppLisSheetDO[] mainDos);
		void logicDeleteByParentDO(CiAppLisSheetDO[] mainDos);
	    CiapplissheetAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiapplissheetAggDO[] findByAttrValString(String attr, String value);
	    CiapplissheetAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiapplissheetAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}