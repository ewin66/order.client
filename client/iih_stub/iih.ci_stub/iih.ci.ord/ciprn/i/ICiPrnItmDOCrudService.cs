using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciprn.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciprn.i
{
    public interface ICiPrnItmDOCrudService
    {
        void delete(CiPrnItmDO[] dos);
        CiPrnItmDO[] insert(CiPrnItmDO[] dos);
        CiPrnItmDO[] save(CiPrnItmDO[] dos);
        CiPrnItmDO[] update(CiPrnItmDO[] dos);
        void logicDelete(CiPrnItmDO[] dos);
        CiPrnItmDO findById(String id);
        CiPrnItmDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        CiPrnItmDO[] findByIds(String[] ids, FBoolean isLazy);
        CiPrnItmDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiPrnItmDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiPrnItmDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiPrnItmDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiPrnItmDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiPrnItmDO[] enableWithoutFilter(CiPrnItmDO[] aggdos) ;
	    DOWithErrLog enableDO(CiPrnItmDO[] aggdos) ;
	    CiPrnItmDO[] disableVOWithoutFilter(CiPrnItmDO[] aggdos);
	    DOWithErrLog disableDO(CiPrnItmDO[] aggdos) ;
	    CiPrnItmDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiPrnItmDO[] findByAttrValString(String attr, String value);
	    CiPrnItmDO[] findByAttrValStrings(String attr, String[] values);
	    CiPrnItmDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiPrnItmDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
