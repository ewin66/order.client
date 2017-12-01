using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.gynurafter.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.gynurafter.i
{
    public interface IGynurafterMDOCrudService
    {
        void delete(GyNurAfterAssDO[] dos);
        GyNurAfterAssDO[] insert(GyNurAfterAssDO[] dos);
        GyNurAfterAssDO[] save(GyNurAfterAssDO[] dos);
        GyNurAfterAssDO[] update(GyNurAfterAssDO[] dos);
        void logicDelete(GyNurAfterAssDO[] dos);
        GyNurAfterAssDO findById(String id);
        GyNurAfterAssDO[] findByIds(String[] ids, FBoolean isLazy);
        GyNurAfterAssDO[] findByBIds(String[] ids, FBoolean isLazy);
        GyNurAfterAssDO[] find(String condition, string orderStr, FBoolean isLazy);
        GyNurAfterAssDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        GyNurAfterAssDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<GyNurAfterAssDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<GyNurAfterAssDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    GyNurAfterAssDO[] enableWithoutFilter(GyNurAfterAssDO[] aggdos) ;
	    DOWithErrLog enableDO(GyNurAfterAssDO[] aggdos) ;
	    GyNurAfterAssDO[] disableVOWithoutFilter(GyNurAfterAssDO[] aggdos);
	    DOWithErrLog disableDO(GyNurAfterAssDO[] aggdos) ;
	    GyNurAfterAssDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    GyNurAfterAssDO[] findByAttrValString(String attr, String value);
	    GyNurAfterAssDO[] findByAttrValStrings(String attr, String[] values);
	    GyNurAfterAssDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<GyNurAfterAssDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
