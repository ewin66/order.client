using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.opspathandover.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.opspathandover.i
{
    public interface IOpspathandoverCrudService
    {
        void delete(OpsPatHandoverDO[] dos);
        OpsPatHandoverDO[] insert(OpsPatHandoverDO[] dos);
        OpsPatHandoverDO[] save(OpsPatHandoverDO[] dos);
        OpsPatHandoverDO[] update(OpsPatHandoverDO[] dos);
        void logicDelete(OpsPatHandoverDO[] dos);
        OpsPatHandoverDO findById(String id);
        OpsPatHandoverDO[] findByIds(String[] ids, FBoolean isLazy);
        OpsPatHandoverDO[] findByBIds(String[] ids, FBoolean isLazy);
        OpsPatHandoverDO[] find(String condition, string orderStr, FBoolean isLazy);
        OpsPatHandoverDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        OpsPatHandoverDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OpsPatHandoverDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<OpsPatHandoverDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    OpsPatHandoverDO[] enableWithoutFilter(OpsPatHandoverDO[] dos) ;
	    DOWithErrLog enableDO(OpsPatHandoverDO[] dos) ;
	    OpsPatHandoverDO[] disableVOWithoutFilter(OpsPatHandoverDO[] dos);
	    DOWithErrLog disableDO(OpsPatHandoverDO[] dos) ;
	    PagingRtnData<OpsPatHandoverDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OpsPatHandoverDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OpsPatHandoverDO[] findByAttrValString(String attr, String value);
	    OpsPatHandoverDO[] findByAttrValStrings(String attr, String[] values);
	    OpsPatHandoverDO[] findByAttrValList(String attr, FArrayList values);
    }
}