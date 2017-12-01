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
    public interface ICiapptreatsheetMDOCrudService
    {
        void delete(CiAppTreatSheetDO[] dos);
        CiAppTreatSheetDO[] insert(CiAppTreatSheetDO[] dos);
        CiAppTreatSheetDO[] save(CiAppTreatSheetDO[] dos);
        CiAppTreatSheetDO[] update(CiAppTreatSheetDO[] dos);
        void logicDelete(CiAppTreatSheetDO[] dos);
        CiAppTreatSheetDO findById(String id);
        CiAppTreatSheetDO[] findByIds(String[] ids, FBoolean isLazy);
        CiAppTreatSheetDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiAppTreatSheetDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiAppTreatSheetDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiAppTreatSheetDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiAppTreatSheetDO[] enableWithoutFilter(CiAppTreatSheetDO[] aggdos) ;
	    DOWithErrLog enableDO(CiAppTreatSheetDO[] aggdos) ;
	    CiAppTreatSheetDO[] disableVOWithoutFilter(CiAppTreatSheetDO[] aggdos);
	    DOWithErrLog disableDO(CiAppTreatSheetDO[] aggdos) ;
	    CiAppTreatSheetDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiAppTreatSheetDO[] findByAttrValString(String attr, String value);
	    CiAppTreatSheetDO[] findByAttrValStrings(String attr, String[] values);
	    CiAppTreatSheetDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiAppTreatSheetDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
