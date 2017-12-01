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
    public interface ICiapppathgysheetMDOCrudService
    {
        void delete(CiAppPathgySheetDO[] dos);
        CiAppPathgySheetDO[] insert(CiAppPathgySheetDO[] dos);
        CiAppPathgySheetDO[] save(CiAppPathgySheetDO[] dos);
        CiAppPathgySheetDO[] update(CiAppPathgySheetDO[] dos);
        void logicDelete(CiAppPathgySheetDO[] dos);
        CiAppPathgySheetDO findById(String id);
        CiAppPathgySheetDO[] findByIds(String[] ids, FBoolean isLazy);
        CiAppPathgySheetDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiAppPathgySheetDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiAppPathgySheetDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiAppPathgySheetDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiAppPathgySheetDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiAppPathgySheetDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiAppPathgySheetDO[] enableWithoutFilter(CiAppPathgySheetDO[] aggdos) ;
	    DOWithErrLog enableDO(CiAppPathgySheetDO[] aggdos) ;
	    CiAppPathgySheetDO[] disableVOWithoutFilter(CiAppPathgySheetDO[] aggdos);
	    DOWithErrLog disableDO(CiAppPathgySheetDO[] aggdos) ;
	    CiAppPathgySheetDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiAppPathgySheetDO[] findByAttrValString(String attr, String value);
	    CiAppPathgySheetDO[] findByAttrValStrings(String attr, String[] values);
	    CiAppPathgySheetDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiAppPathgySheetDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
