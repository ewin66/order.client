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
    public interface IAdhNursingRecDOCrudService
    {
        void delete(AdhNursingRecDO[] dos);
        AdhNursingRecDO[] insert(AdhNursingRecDO[] dos);
        AdhNursingRecDO[] save(AdhNursingRecDO[] dos);
        AdhNursingRecDO[] update(AdhNursingRecDO[] dos);
        void logicDelete(AdhNursingRecDO[] dos);
        AdhNursingRecDO findById(String id);
        AdhNursingRecDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        AdhNursingRecDO[] findByIds(String[] ids, FBoolean isLazy);
        AdhNursingRecDO[] findByBIds(String[] ids, FBoolean isLazy);
        AdhNursingRecDO[] find(String condition, string orderStr, FBoolean isLazy);
        AdhNursingRecDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AdhNursingRecDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<AdhNursingRecDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    AdhNursingRecDO[] enableWithoutFilter(AdhNursingRecDO[] aggdos) ;
	    DOWithErrLog enableDO(AdhNursingRecDO[] aggdos) ;
	    AdhNursingRecDO[] disableVOWithoutFilter(AdhNursingRecDO[] aggdos);
	    DOWithErrLog disableDO(AdhNursingRecDO[] aggdos) ;
	    AdhNursingRecDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AdhNursingRecDO[] findByAttrValString(String attr, String value);
	    AdhNursingRecDO[] findByAttrValStrings(String attr, String[] values);
	    AdhNursingRecDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<AdhNursingRecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
