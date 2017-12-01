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
    public interface ICiMrVtEvDOCrudService
    {
        void delete(CiMrVtEvDO[] dos);
        CiMrVtEvDO[] insert(CiMrVtEvDO[] dos);
        CiMrVtEvDO[] save(CiMrVtEvDO[] dos);
        CiMrVtEvDO[] update(CiMrVtEvDO[] dos);
        void logicDelete(CiMrVtEvDO[] dos);
        CiMrVtEvDO findById(String id);
        CiMrVtEvDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrVtEvDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrVtEvDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrVtEvDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrVtEvDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrVtEvDO[] enableWithoutFilter(CiMrVtEvDO[] aggdos) ;
	    DOWithErrLog enableDO(CiMrVtEvDO[] aggdos) ;
	    CiMrVtEvDO[] disableVOWithoutFilter(CiMrVtEvDO[] aggdos);
	    DOWithErrLog disableDO(CiMrVtEvDO[] aggdos) ;
	    CiMrVtEvDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrVtEvDO[] findByAttrValString(String attr, String value);
	    CiMrVtEvDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrVtEvDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiMrVtEvDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
