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
    public interface ICiapprissheetCrudService
    {
        void delete(CiAppRisSheetDO[] dos);
        CiAppRisSheetDO[] insert(CiAppRisSheetDO[] dos);
        CiAppRisSheetDO[] save(CiAppRisSheetDO[] dos);
        CiAppRisSheetDO[] update(CiAppRisSheetDO[] dos);
        void logicDelete(CiAppRisSheetDO[] dos);
        CiAppRisSheetDO findById(String id);
        CiAppRisSheetDO[] findByIds(String[] ids, FBoolean isLazy);
        CiAppRisSheetDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiAppRisSheetDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiAppRisSheetDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiAppRisSheetDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiAppRisSheetDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiAppRisSheetDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiAppRisSheetDO[] enableWithoutFilter(CiAppRisSheetDO[] dos) ;
	    DOWithErrLog enableDO(CiAppRisSheetDO[] dos) ;
	    CiAppRisSheetDO[] disableVOWithoutFilter(CiAppRisSheetDO[] dos);
	    DOWithErrLog disableDO(CiAppRisSheetDO[] dos) ;
	    PagingRtnData<CiAppRisSheetDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiAppRisSheetDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiAppRisSheetDO[] findByAttrValString(String attr, String value);
	    CiAppRisSheetDO[] findByAttrValStrings(String attr, String[] values);
	    CiAppRisSheetDO[] findByAttrValList(String attr, FArrayList values);
    }
}