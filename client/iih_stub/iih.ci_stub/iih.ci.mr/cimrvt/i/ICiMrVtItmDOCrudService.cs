using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.cimrvt.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.cimrvt.i
{
    public interface ICiMrVtItmDOCrudService
    {
        void delete(CiMrVtItmDO[] dos);
        CiMrVtItmDO[] insert(CiMrVtItmDO[] dos);
        CiMrVtItmDO[] save(CiMrVtItmDO[] dos);
        CiMrVtItmDO[] update(CiMrVtItmDO[] dos);
        void logicDelete(CiMrVtItmDO[] dos);
        CiMrVtItmDO findById(String id);
        CiMrVtItmDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrVtItmDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrVtItmDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrVtItmDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrVtItmDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrVtItmDO[] enableWithoutFilter(CiMrVtItmDO[] aggdos) ;
	    DOWithErrLog enableDO(CiMrVtItmDO[] aggdos) ;
	    CiMrVtItmDO[] disableVOWithoutFilter(CiMrVtItmDO[] aggdos);
	    DOWithErrLog disableDO(CiMrVtItmDO[] aggdos) ;
	    CiMrVtItmDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrVtItmDO[] findByAttrValString(String attr, String value);
	    CiMrVtItmDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrVtItmDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiMrVtItmDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
