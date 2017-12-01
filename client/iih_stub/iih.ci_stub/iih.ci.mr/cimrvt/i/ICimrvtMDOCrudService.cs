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
    public interface ICimrvtMDOCrudService
    {
        void delete(CiMrVtDO[] dos);
        CiMrVtDO[] insert(CiMrVtDO[] dos);
        CiMrVtDO[] save(CiMrVtDO[] dos);
        CiMrVtDO[] update(CiMrVtDO[] dos);
        void logicDelete(CiMrVtDO[] dos);
        CiMrVtDO findById(String id);
        CiMrVtDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrVtDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrVtDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrVtDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrVtDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrVtDO[] enableWithoutFilter(CiMrVtDO[] aggdos) ;
	    DOWithErrLog enableDO(CiMrVtDO[] aggdos) ;
	    CiMrVtDO[] disableVOWithoutFilter(CiMrVtDO[] aggdos);
	    DOWithErrLog disableDO(CiMrVtDO[] aggdos) ;
	    CiMrVtDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrVtDO[] findByAttrValString(String attr, String value);
	    CiMrVtDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrVtDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiMrVtDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
