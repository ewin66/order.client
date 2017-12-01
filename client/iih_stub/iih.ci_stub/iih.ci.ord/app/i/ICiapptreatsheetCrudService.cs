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
    public interface ICiapptreatsheetCrudService
    {
        void delete(CiapptreatsheetAggDO[] dos);
        CiapptreatsheetAggDO[] insert(CiapptreatsheetAggDO[] dos);
        CiapptreatsheetAggDO[] save(CiapptreatsheetAggDO[] dos);
        CiapptreatsheetAggDO[] update(CiapptreatsheetAggDO[] dos);
        void logicDelete(CiapptreatsheetAggDO[] dos);
        CiapptreatsheetAggDO findById(String id);
        CiapptreatsheetAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiapptreatsheetAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiapptreatsheetAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiapptreatsheetAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiapptreatsheetAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiapptreatsheetAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(CiAppTreatSheetDO[] mainDos);
		void logicDeleteByParentDO(CiAppTreatSheetDO[] mainDos);
	    CiapptreatsheetAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiapptreatsheetAggDO[] findByAttrValString(String attr, String value);
	    CiapptreatsheetAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiapptreatsheetAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
