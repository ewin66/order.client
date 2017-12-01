using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.operationnurvisit.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.operationnurvisit.i
{
    public interface IOperationnurvisitCrudService
    {
        void delete(OperationNurVisitDO[] dos);
        OperationNurVisitDO[] insert(OperationNurVisitDO[] dos);
        OperationNurVisitDO[] save(OperationNurVisitDO[] dos);
        OperationNurVisitDO[] update(OperationNurVisitDO[] dos);
        void logicDelete(OperationNurVisitDO[] dos);
        OperationNurVisitDO findById(String id);
        OperationNurVisitDO[] findByIds(String[] ids, FBoolean isLazy);
        OperationNurVisitDO[] findByBIds(String[] ids, FBoolean isLazy);
        OperationNurVisitDO[] find(String condition, string orderStr, FBoolean isLazy);
        OperationNurVisitDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        OperationNurVisitDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OperationNurVisitDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<OperationNurVisitDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    OperationNurVisitDO[] enableWithoutFilter(OperationNurVisitDO[] dos) ;
	    DOWithErrLog enableDO(OperationNurVisitDO[] dos) ;
	    OperationNurVisitDO[] disableVOWithoutFilter(OperationNurVisitDO[] dos);
	    DOWithErrLog disableDO(OperationNurVisitDO[] dos) ;
	    PagingRtnData<OperationNurVisitDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OperationNurVisitDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OperationNurVisitDO[] findByAttrValString(String attr, String value);
	    OperationNurVisitDO[] findByAttrValStrings(String attr, String[] values);
	    OperationNurVisitDO[] findByAttrValList(String attr, FArrayList values);
    }
}