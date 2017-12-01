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
    public interface IOrdApSugViewItemDOCrudService
    {
        void delete(OrdApSugViewItemDO[] dos);
        OrdApSugViewItemDO[] insert(OrdApSugViewItemDO[] dos);
        OrdApSugViewItemDO[] save(OrdApSugViewItemDO[] dos);
        OrdApSugViewItemDO[] update(OrdApSugViewItemDO[] dos);
        void logicDelete(OrdApSugViewItemDO[] dos);
        OrdApSugViewItemDO findById(String id);
        OrdApSugViewItemDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApSugViewItemDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApSugViewItemDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApSugViewItemDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApSugViewItemDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApSugViewItemDO[] enableWithoutFilter(OrdApSugViewItemDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdApSugViewItemDO[] aggdos) ;
	    OrdApSugViewItemDO[] disableVOWithoutFilter(OrdApSugViewItemDO[] aggdos);
	    DOWithErrLog disableDO(OrdApSugViewItemDO[] aggdos) ;
	    OrdApSugViewItemDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApSugViewItemDO[] findByAttrValString(String attr, String value);
	    OrdApSugViewItemDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApSugViewItemDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdApSugViewItemDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
