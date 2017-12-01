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
    public interface ICiAppPathgySheetSampDOCrudService
    {
        void delete(CiAppPathgySheetSampDO[] dos);
        CiAppPathgySheetSampDO[] insert(CiAppPathgySheetSampDO[] dos);
        CiAppPathgySheetSampDO[] save(CiAppPathgySheetSampDO[] dos);
        CiAppPathgySheetSampDO[] update(CiAppPathgySheetSampDO[] dos);
        void logicDelete(CiAppPathgySheetSampDO[] dos);
        CiAppPathgySheetSampDO findById(String id);
        CiAppPathgySheetSampDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        CiAppPathgySheetSampDO[] findByIds(String[] ids, FBoolean isLazy);
        CiAppPathgySheetSampDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiAppPathgySheetSampDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiAppPathgySheetSampDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiAppPathgySheetSampDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiAppPathgySheetSampDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiAppPathgySheetSampDO[] enableWithoutFilter(CiAppPathgySheetSampDO[] aggdos) ;
	    DOWithErrLog enableDO(CiAppPathgySheetSampDO[] aggdos) ;
	    CiAppPathgySheetSampDO[] disableVOWithoutFilter(CiAppPathgySheetSampDO[] aggdos);
	    DOWithErrLog disableDO(CiAppPathgySheetSampDO[] aggdos) ;
	    CiAppPathgySheetSampDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiAppPathgySheetSampDO[] findByAttrValString(String attr, String value);
	    CiAppPathgySheetSampDO[] findByAttrValStrings(String attr, String[] values);
	    CiAppPathgySheetSampDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiAppPathgySheetSampDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
