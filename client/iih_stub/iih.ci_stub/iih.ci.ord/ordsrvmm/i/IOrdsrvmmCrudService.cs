using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ordsrvmm.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ordsrvmm.i
{
    public interface IOrdsrvmmCrudService
    {
        void delete(OrdSrvMmDO[] dos);
        OrdSrvMmDO[] insert(OrdSrvMmDO[] dos);
        OrdSrvMmDO[] save(OrdSrvMmDO[] dos);
        OrdSrvMmDO[] update(OrdSrvMmDO[] dos);
        void logicDelete(OrdSrvMmDO[] dos);
        OrdSrvMmDO findById(String id);
        OrdSrvMmDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdSrvMmDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdSrvMmDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdSrvMmDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdSrvMmDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdSrvMmDO[] enableWithoutFilter(OrdSrvMmDO[] dos) ;
	    DOWithErrLog enableDO(OrdSrvMmDO[] dos) ;
	    OrdSrvMmDO[] disableVOWithoutFilter(OrdSrvMmDO[] dos);
	    DOWithErrLog disableDO(OrdSrvMmDO[] dos) ;
	    PagingRtnData<OrdSrvMmDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OrdSrvMmDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdSrvMmDO[] findByAttrValString(String attr, String value);
	    OrdSrvMmDO[] findByAttrValStrings(String attr, String[] values);
	    OrdSrvMmDO[] findByAttrValList(String attr, FArrayList values);
    }
}
