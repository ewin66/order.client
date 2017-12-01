using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cior.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cior.i
{
    public interface ICiorappconsultMDOCrudService
    {
        void delete(OrdApConsDO[] dos);
        OrdApConsDO[] insert(OrdApConsDO[] dos);
        OrdApConsDO[] save(OrdApConsDO[] dos);
        OrdApConsDO[] update(OrdApConsDO[] dos);
        void logicDelete(OrdApConsDO[] dos);
        OrdApConsDO findById(String id);
        OrdApConsDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApConsDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApConsDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApConsDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApConsDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApConsDO[] enableWithoutFilter(OrdApConsDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdApConsDO[] aggdos) ;
	    OrdApConsDO[] disableVOWithoutFilter(OrdApConsDO[] aggdos);
	    DOWithErrLog disableDO(OrdApConsDO[] aggdos) ;
	    OrdApConsDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApConsDO[] findByAttrValString(String attr, String value);
	    OrdApConsDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApConsDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdApConsDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
