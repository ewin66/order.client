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
    public interface ICiapplissheetMDOCrudService
    {
        void delete(CiAppLisSheetDO[] dos);
        CiAppLisSheetDO[] insert(CiAppLisSheetDO[] dos);
        CiAppLisSheetDO[] save(CiAppLisSheetDO[] dos);
        CiAppLisSheetDO[] update(CiAppLisSheetDO[] dos);
        void logicDelete(CiAppLisSheetDO[] dos);
        CiAppLisSheetDO findById(String id);
        CiAppLisSheetDO[] findByIds(String[] ids, FBoolean isLazy);
        CiAppLisSheetDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiAppLisSheetDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiAppLisSheetDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiAppLisSheetDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiAppLisSheetDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiAppLisSheetDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiAppLisSheetDO[] enableWithoutFilter(CiAppLisSheetDO[] aggdos) ;
	    DOWithErrLog enableDO(CiAppLisSheetDO[] aggdos) ;
	    CiAppLisSheetDO[] disableVOWithoutFilter(CiAppLisSheetDO[] aggdos);
	    DOWithErrLog disableDO(CiAppLisSheetDO[] aggdos) ;
	    CiAppLisSheetDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiAppLisSheetDO[] findByAttrValString(String attr, String value);
	    CiAppLisSheetDO[] findByAttrValStrings(String attr, String[] values);
	    CiAppLisSheetDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiAppLisSheetDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
