using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciorder.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciorder.i
{
    public interface IOrdSrvDOCrudService
    {
        void delete(OrdSrvDO[] dos);
        OrdSrvDO[] insert(OrdSrvDO[] dos);
        OrdSrvDO[] save(OrdSrvDO[] dos);
        OrdSrvDO[] update(OrdSrvDO[] dos);
        void logicDelete(OrdSrvDO[] dos);
        OrdSrvDO findById(String id);
        OrdSrvDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdSrvDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdSrvDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdSrvDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdSrvDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdSrvDO[] enableWithoutFilter(OrdSrvDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdSrvDO[] aggdos) ;
	    OrdSrvDO[] disableVOWithoutFilter(OrdSrvDO[] aggdos);
	    DOWithErrLog disableDO(OrdSrvDO[] aggdos) ;
	    OrdSrvDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdSrvDO[] findByAttrValString(String attr, String value);
	    OrdSrvDO[] findByAttrValStrings(String attr, String[] values);
	    OrdSrvDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdSrvDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}