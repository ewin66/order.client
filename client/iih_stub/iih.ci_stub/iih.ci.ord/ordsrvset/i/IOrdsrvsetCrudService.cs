using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ordsrvset.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ordsrvset.i
{
    public interface IOrdsrvsetCrudService
    {
        void delete(OrdSrvSetDO[] dos);
        OrdSrvSetDO[] insert(OrdSrvSetDO[] dos);
        OrdSrvSetDO[] save(OrdSrvSetDO[] dos);
        OrdSrvSetDO[] update(OrdSrvSetDO[] dos);
        void logicDelete(OrdSrvSetDO[] dos);
        OrdSrvSetDO findById(String id);
        OrdSrvSetDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdSrvSetDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdSrvSetDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdSrvSetDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdSrvSetDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdSrvSetDO[] enableWithoutFilter(OrdSrvSetDO[] dos) ;
	    DOWithErrLog enableDO(OrdSrvSetDO[] dos) ;
	    OrdSrvSetDO[] disableVOWithoutFilter(OrdSrvSetDO[] dos);
	    DOWithErrLog disableDO(OrdSrvSetDO[] dos) ;
	    PagingRtnData<OrdSrvSetDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OrdSrvSetDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdSrvSetDO[] findByAttrValString(String attr, String value);
	    OrdSrvSetDO[] findByAttrValStrings(String attr, String[] values);
	    OrdSrvSetDO[] findByAttrValList(String attr, FArrayList values);
    }
}
