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
    public interface ICiorapprisCrudService
    {
        void delete(OrdApObsDO[] dos);
        OrdApObsDO[] insert(OrdApObsDO[] dos);
        OrdApObsDO[] save(OrdApObsDO[] dos);
        OrdApObsDO[] update(OrdApObsDO[] dos);
        void logicDelete(OrdApObsDO[] dos);
        OrdApObsDO findById(String id);
        OrdApObsDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApObsDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApObsDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApObsDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApObsDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApObsDO[] enableWithoutFilter(OrdApObsDO[] dos) ;
	    DOWithErrLog enableDO(OrdApObsDO[] dos) ;
	    OrdApObsDO[] disableVOWithoutFilter(OrdApObsDO[] dos);
	    DOWithErrLog disableDO(OrdApObsDO[] dos) ;
	    PagingRtnData<OrdApObsDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OrdApObsDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApObsDO[] findByAttrValString(String attr, String value);
	    OrdApObsDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApObsDO[] findByAttrValList(String attr, FArrayList values);
    }
}
