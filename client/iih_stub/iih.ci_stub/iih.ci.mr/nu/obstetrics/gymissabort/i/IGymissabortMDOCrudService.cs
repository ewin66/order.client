using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.gymissabort.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.gymissabort.i
{
    public interface IGymissabortMDOCrudService
    {
        void delete(GyMissAbortAssDO[] dos);
        GyMissAbortAssDO[] insert(GyMissAbortAssDO[] dos);
        GyMissAbortAssDO[] save(GyMissAbortAssDO[] dos);
        GyMissAbortAssDO[] update(GyMissAbortAssDO[] dos);
        void logicDelete(GyMissAbortAssDO[] dos);
        GyMissAbortAssDO findById(String id);
        GyMissAbortAssDO[] findByIds(String[] ids, FBoolean isLazy);
        GyMissAbortAssDO[] findByBIds(String[] ids, FBoolean isLazy);
        GyMissAbortAssDO[] find(String condition, string orderStr, FBoolean isLazy);
        GyMissAbortAssDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        GyMissAbortAssDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<GyMissAbortAssDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<GyMissAbortAssDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    GyMissAbortAssDO[] enableWithoutFilter(GyMissAbortAssDO[] aggdos) ;
	    DOWithErrLog enableDO(GyMissAbortAssDO[] aggdos) ;
	    GyMissAbortAssDO[] disableVOWithoutFilter(GyMissAbortAssDO[] aggdos);
	    DOWithErrLog disableDO(GyMissAbortAssDO[] aggdos) ;
	    GyMissAbortAssDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    GyMissAbortAssDO[] findByAttrValString(String attr, String value);
	    GyMissAbortAssDO[] findByAttrValStrings(String attr, String[] values);
	    GyMissAbortAssDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<GyMissAbortAssDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
