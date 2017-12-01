using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.gynurbefore.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.gynurbefore.i
{
    public interface IGynurbeforeMDOCrudService
    {
        void delete(GyNurBeforeAssDO[] dos);
        GyNurBeforeAssDO[] insert(GyNurBeforeAssDO[] dos);
        GyNurBeforeAssDO[] save(GyNurBeforeAssDO[] dos);
        GyNurBeforeAssDO[] update(GyNurBeforeAssDO[] dos);
        void logicDelete(GyNurBeforeAssDO[] dos);
        GyNurBeforeAssDO findById(String id);
        GyNurBeforeAssDO[] findByIds(String[] ids, FBoolean isLazy);
        GyNurBeforeAssDO[] findByBIds(String[] ids, FBoolean isLazy);
        GyNurBeforeAssDO[] find(String condition, string orderStr, FBoolean isLazy);
        GyNurBeforeAssDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        GyNurBeforeAssDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<GyNurBeforeAssDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<GyNurBeforeAssDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    GyNurBeforeAssDO[] enableWithoutFilter(GyNurBeforeAssDO[] aggdos) ;
	    DOWithErrLog enableDO(GyNurBeforeAssDO[] aggdos) ;
	    GyNurBeforeAssDO[] disableVOWithoutFilter(GyNurBeforeAssDO[] aggdos);
	    DOWithErrLog disableDO(GyNurBeforeAssDO[] aggdos) ;
	    GyNurBeforeAssDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    GyNurBeforeAssDO[] findByAttrValString(String attr, String value);
	    GyNurBeforeAssDO[] findByAttrValStrings(String attr, String[] values);
	    GyNurBeforeAssDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<GyNurBeforeAssDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
