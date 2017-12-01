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
    public interface IOrdApRptOpItemDOCrudService
    {
        void delete(OrdApRptOpItemDO[] dos);
        OrdApRptOpItemDO[] insert(OrdApRptOpItemDO[] dos);
        OrdApRptOpItemDO[] save(OrdApRptOpItemDO[] dos);
        OrdApRptOpItemDO[] update(OrdApRptOpItemDO[] dos);
        void logicDelete(OrdApRptOpItemDO[] dos);
        OrdApRptOpItemDO findById(String id);
        OrdApRptOpItemDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApRptOpItemDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApRptOpItemDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApRptOpItemDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApRptOpItemDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApRptOpItemDO[] enableWithoutFilter(OrdApRptOpItemDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdApRptOpItemDO[] aggdos) ;
	    OrdApRptOpItemDO[] disableVOWithoutFilter(OrdApRptOpItemDO[] aggdos);
	    DOWithErrLog disableDO(OrdApRptOpItemDO[] aggdos) ;
	    OrdApRptOpItemDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApRptOpItemDO[] findByAttrValString(String attr, String value);
	    OrdApRptOpItemDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApRptOpItemDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdApRptOpItemDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
