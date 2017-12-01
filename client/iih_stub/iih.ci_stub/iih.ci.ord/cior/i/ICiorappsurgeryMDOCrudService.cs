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
    public interface ICiorappsurgeryMDOCrudService
    {
        void delete(OrdApOpDO[] dos);
        OrdApOpDO[] insert(OrdApOpDO[] dos);
        OrdApOpDO[] save(OrdApOpDO[] dos);
        OrdApOpDO[] update(OrdApOpDO[] dos);
        void logicDelete(OrdApOpDO[] dos);
        OrdApOpDO findById(String id);
        OrdApOpDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApOpDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApOpDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApOpDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApOpDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApOpDO[] enableWithoutFilter(OrdApOpDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdApOpDO[] aggdos) ;
	    OrdApOpDO[] disableVOWithoutFilter(OrdApOpDO[] aggdos);
	    DOWithErrLog disableDO(OrdApOpDO[] aggdos) ;
	    OrdApOpDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApOpDO[] findByAttrValString(String attr, String value);
	    OrdApOpDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApOpDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdApOpDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
