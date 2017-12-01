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
    public interface IOpernurecordMDOCrudService
    {
        void delete(OperNuRecordDO[] dos);
        OperNuRecordDO[] insert(OperNuRecordDO[] dos);
        OperNuRecordDO[] save(OperNuRecordDO[] dos);
        OperNuRecordDO[] update(OperNuRecordDO[] dos);
        void logicDelete(OperNuRecordDO[] dos);
        OperNuRecordDO findById(String id);
        OperNuRecordDO[] findByIds(String[] ids, FBoolean isLazy);
        OperNuRecordDO[] findByBIds(String[] ids, FBoolean isLazy);
        OperNuRecordDO[] find(String condition, string orderStr, FBoolean isLazy);
        OperNuRecordDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        OperNuRecordDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OperNuRecordDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<OperNuRecordDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    OperNuRecordDO[] enableWithoutFilter(OperNuRecordDO[] aggdos) ;
	    DOWithErrLog enableDO(OperNuRecordDO[] aggdos) ;
	    OperNuRecordDO[] disableVOWithoutFilter(OperNuRecordDO[] aggdos);
	    DOWithErrLog disableDO(OperNuRecordDO[] aggdos) ;
	    OperNuRecordDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OperNuRecordDO[] findByAttrValString(String attr, String value);
	    OperNuRecordDO[] findByAttrValStrings(String attr, String[] values);
	    OperNuRecordDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OperNuRecordDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
