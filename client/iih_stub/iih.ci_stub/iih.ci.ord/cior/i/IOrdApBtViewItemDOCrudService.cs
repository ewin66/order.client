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
    public interface IOrdApBtViewItemDOCrudService
    {
        void delete(OrdApBtViewItemDO[] dos);
        OrdApBtViewItemDO[] insert(OrdApBtViewItemDO[] dos);
        OrdApBtViewItemDO[] save(OrdApBtViewItemDO[] dos);
        OrdApBtViewItemDO[] update(OrdApBtViewItemDO[] dos);
        void logicDelete(OrdApBtViewItemDO[] dos);
        OrdApBtViewItemDO findById(String id);
        OrdApBtViewItemDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApBtViewItemDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApBtViewItemDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApBtViewItemDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApBtViewItemDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApBtViewItemDO[] enableWithoutFilter(OrdApBtViewItemDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdApBtViewItemDO[] aggdos) ;
	    OrdApBtViewItemDO[] disableVOWithoutFilter(OrdApBtViewItemDO[] aggdos);
	    DOWithErrLog disableDO(OrdApBtViewItemDO[] aggdos) ;
	    OrdApBtViewItemDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApBtViewItemDO[] findByAttrValString(String attr, String value);
	    OrdApBtViewItemDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApBtViewItemDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdApBtViewItemDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
