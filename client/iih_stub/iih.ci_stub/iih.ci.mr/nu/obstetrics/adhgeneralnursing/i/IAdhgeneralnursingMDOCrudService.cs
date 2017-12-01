using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.adhgeneralnursing.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.adhgeneralnursing.i
{
    public interface IAdhgeneralnursingMDOCrudService
    {
        void delete(AdhNursingDO[] dos);
        AdhNursingDO[] insert(AdhNursingDO[] dos);
        AdhNursingDO[] save(AdhNursingDO[] dos);
        AdhNursingDO[] update(AdhNursingDO[] dos);
        void logicDelete(AdhNursingDO[] dos);
        AdhNursingDO findById(String id);
        AdhNursingDO[] findByIds(String[] ids, FBoolean isLazy);
        AdhNursingDO[] findByBIds(String[] ids, FBoolean isLazy);
        AdhNursingDO[] find(String condition, string orderStr, FBoolean isLazy);
        AdhNursingDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        AdhNursingDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AdhNursingDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<AdhNursingDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    AdhNursingDO[] enableWithoutFilter(AdhNursingDO[] aggdos) ;
	    DOWithErrLog enableDO(AdhNursingDO[] aggdos) ;
	    AdhNursingDO[] disableVOWithoutFilter(AdhNursingDO[] aggdos);
	    DOWithErrLog disableDO(AdhNursingDO[] aggdos) ;
	    AdhNursingDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AdhNursingDO[] findByAttrValString(String attr, String value);
	    AdhNursingDO[] findByAttrValStrings(String attr, String[] values);
	    AdhNursingDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<AdhNursingDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
