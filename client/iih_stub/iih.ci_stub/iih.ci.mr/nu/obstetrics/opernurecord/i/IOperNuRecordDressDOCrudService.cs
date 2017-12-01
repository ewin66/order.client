using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.opernurecord.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.opernurecord.i
{
    public interface IOperNuRecordDressDOCrudService
    {
        void delete(OperNuRecordDressDO[] dos);
        OperNuRecordDressDO[] insert(OperNuRecordDressDO[] dos);
        OperNuRecordDressDO[] save(OperNuRecordDressDO[] dos);
        OperNuRecordDressDO[] update(OperNuRecordDressDO[] dos);
        void logicDelete(OperNuRecordDressDO[] dos);
        OperNuRecordDressDO findById(String id);
        OperNuRecordDressDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        OperNuRecordDressDO[] findByIds(String[] ids, FBoolean isLazy);
        OperNuRecordDressDO[] findByBIds(String[] ids, FBoolean isLazy);
        OperNuRecordDressDO[] find(String condition, string orderStr, FBoolean isLazy);
        OperNuRecordDressDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OperNuRecordDressDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<OperNuRecordDressDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    OperNuRecordDressDO[] enableWithoutFilter(OperNuRecordDressDO[] aggdos) ;
	    DOWithErrLog enableDO(OperNuRecordDressDO[] aggdos) ;
	    OperNuRecordDressDO[] disableVOWithoutFilter(OperNuRecordDressDO[] aggdos);
	    DOWithErrLog disableDO(OperNuRecordDressDO[] aggdos) ;
	    OperNuRecordDressDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OperNuRecordDressDO[] findByAttrValString(String attr, String value);
	    OperNuRecordDressDO[] findByAttrValStrings(String attr, String[] values);
	    OperNuRecordDressDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OperNuRecordDressDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
