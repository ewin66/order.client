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
    public interface ICiorappbuCrudService
    {
        void delete(OrdAppBtUseDO[] dos);
        OrdAppBtUseDO[] insert(OrdAppBtUseDO[] dos);
        OrdAppBtUseDO[] save(OrdAppBtUseDO[] dos);
        OrdAppBtUseDO[] update(OrdAppBtUseDO[] dos);
        void logicDelete(OrdAppBtUseDO[] dos);
        OrdAppBtUseDO findById(String id);
        OrdAppBtUseDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdAppBtUseDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdAppBtUseDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdAppBtUseDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdAppBtUseDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdAppBtUseDO[] enableWithoutFilter(OrdAppBtUseDO[] dos) ;
	    DOWithErrLog enableDO(OrdAppBtUseDO[] dos) ;
	    OrdAppBtUseDO[] disableVOWithoutFilter(OrdAppBtUseDO[] dos);
	    DOWithErrLog disableDO(OrdAppBtUseDO[] dos) ;
	    PagingRtnData<OrdAppBtUseDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OrdAppBtUseDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdAppBtUseDO[] findByAttrValString(String attr, String value);
	    OrdAppBtUseDO[] findByAttrValStrings(String attr, String[] values);
	    OrdAppBtUseDO[] findByAttrValList(String attr, FArrayList values);
    }
}
