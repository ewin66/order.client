using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.abortionrecord.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.abortionrecord.i
{
    public interface IAbortionrecordCrudService
    {
        void delete(AbortionRecordDO[] dos);
        AbortionRecordDO[] insert(AbortionRecordDO[] dos);
        AbortionRecordDO[] save(AbortionRecordDO[] dos);
        AbortionRecordDO[] update(AbortionRecordDO[] dos);
        void logicDelete(AbortionRecordDO[] dos);
        AbortionRecordDO findById(String id);
        AbortionRecordDO[] findByIds(String[] ids, FBoolean isLazy);
        AbortionRecordDO[] findByBIds(String[] ids, FBoolean isLazy);
        AbortionRecordDO[] find(String condition, string orderStr, FBoolean isLazy);
        AbortionRecordDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        AbortionRecordDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AbortionRecordDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<AbortionRecordDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    AbortionRecordDO[] enableWithoutFilter(AbortionRecordDO[] dos) ;
	    DOWithErrLog enableDO(AbortionRecordDO[] dos) ;
	    AbortionRecordDO[] disableVOWithoutFilter(AbortionRecordDO[] dos);
	    DOWithErrLog disableDO(AbortionRecordDO[] dos) ;
	    PagingRtnData<AbortionRecordDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    AbortionRecordDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AbortionRecordDO[] findByAttrValString(String attr, String value);
	    AbortionRecordDO[] findByAttrValStrings(String attr, String[] values);
	    AbortionRecordDO[] findByAttrValList(String attr, FArrayList values);
    }
}