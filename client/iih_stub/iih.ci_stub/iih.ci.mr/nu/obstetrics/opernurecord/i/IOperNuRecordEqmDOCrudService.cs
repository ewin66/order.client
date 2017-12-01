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
    public interface IOperNuRecordEqmDOCrudService
    {
        void delete(OperNuRecordEqmDO[] dos);
        OperNuRecordEqmDO[] insert(OperNuRecordEqmDO[] dos);
        OperNuRecordEqmDO[] save(OperNuRecordEqmDO[] dos);
        OperNuRecordEqmDO[] update(OperNuRecordEqmDO[] dos);
        void logicDelete(OperNuRecordEqmDO[] dos);
        OperNuRecordEqmDO findById(String id);
        OperNuRecordEqmDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        OperNuRecordEqmDO[] findByIds(String[] ids, FBoolean isLazy);
        OperNuRecordEqmDO[] findByBIds(String[] ids, FBoolean isLazy);
        OperNuRecordEqmDO[] find(String condition, string orderStr, FBoolean isLazy);
        OperNuRecordEqmDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OperNuRecordEqmDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<OperNuRecordEqmDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    OperNuRecordEqmDO[] enableWithoutFilter(OperNuRecordEqmDO[] aggdos) ;
	    DOWithErrLog enableDO(OperNuRecordEqmDO[] aggdos) ;
	    OperNuRecordEqmDO[] disableVOWithoutFilter(OperNuRecordEqmDO[] aggdos);
	    DOWithErrLog disableDO(OperNuRecordEqmDO[] aggdos) ;
	    OperNuRecordEqmDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OperNuRecordEqmDO[] findByAttrValString(String attr, String value);
	    OperNuRecordEqmDO[] findByAttrValStrings(String attr, String[] values);
	    OperNuRecordEqmDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OperNuRecordEqmDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
