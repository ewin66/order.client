using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.opersafechecktab.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.opersafechecktab.i
{
    public interface IOpersafechecktabCrudService
    {
        void delete(OperSafeCheckTableDO[] dos);
        OperSafeCheckTableDO[] insert(OperSafeCheckTableDO[] dos);
        OperSafeCheckTableDO[] save(OperSafeCheckTableDO[] dos);
        OperSafeCheckTableDO[] update(OperSafeCheckTableDO[] dos);
        void logicDelete(OperSafeCheckTableDO[] dos);
        OperSafeCheckTableDO findById(String id);
        OperSafeCheckTableDO[] findByIds(String[] ids, FBoolean isLazy);
        OperSafeCheckTableDO[] findByBIds(String[] ids, FBoolean isLazy);
        OperSafeCheckTableDO[] find(String condition, string orderStr, FBoolean isLazy);
        OperSafeCheckTableDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        OperSafeCheckTableDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OperSafeCheckTableDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<OperSafeCheckTableDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    OperSafeCheckTableDO[] enableWithoutFilter(OperSafeCheckTableDO[] dos) ;
	    DOWithErrLog enableDO(OperSafeCheckTableDO[] dos) ;
	    OperSafeCheckTableDO[] disableVOWithoutFilter(OperSafeCheckTableDO[] dos);
	    DOWithErrLog disableDO(OperSafeCheckTableDO[] dos) ;
	    PagingRtnData<OperSafeCheckTableDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OperSafeCheckTableDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OperSafeCheckTableDO[] findByAttrValString(String attr, String value);
	    OperSafeCheckTableDO[] findByAttrValStrings(String attr, String[] values);
	    OperSafeCheckTableDO[] findByAttrValList(String attr, FArrayList values);
    }
}