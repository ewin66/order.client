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
    public interface ICiAppLisSheetOrDOCrudService
    {
        void delete(CiAppLisSheetOrDO[] dos);
        CiAppLisSheetOrDO[] insert(CiAppLisSheetOrDO[] dos);
        CiAppLisSheetOrDO[] save(CiAppLisSheetOrDO[] dos);
        CiAppLisSheetOrDO[] update(CiAppLisSheetOrDO[] dos);
        void logicDelete(CiAppLisSheetOrDO[] dos);
        CiAppLisSheetOrDO findById(String id);
        CiAppLisSheetOrDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        CiAppLisSheetOrDO[] findByIds(String[] ids, FBoolean isLazy);
        CiAppLisSheetOrDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiAppLisSheetOrDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiAppLisSheetOrDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiAppLisSheetOrDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiAppLisSheetOrDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiAppLisSheetOrDO[] enableWithoutFilter(CiAppLisSheetOrDO[] aggdos) ;
	    DOWithErrLog enableDO(CiAppLisSheetOrDO[] aggdos) ;
	    CiAppLisSheetOrDO[] disableVOWithoutFilter(CiAppLisSheetOrDO[] aggdos);
	    DOWithErrLog disableDO(CiAppLisSheetOrDO[] aggdos) ;
	    CiAppLisSheetOrDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiAppLisSheetOrDO[] findByAttrValString(String attr, String value);
	    CiAppLisSheetOrDO[] findByAttrValStrings(String attr, String[] values);
	    CiAppLisSheetOrDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiAppLisSheetOrDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
