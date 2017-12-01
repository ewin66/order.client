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
    public interface ICiorapptransdeptCrudService
    {
        void delete(OrdApTransDO[] dos);
        OrdApTransDO[] insert(OrdApTransDO[] dos);
        OrdApTransDO[] save(OrdApTransDO[] dos);
        OrdApTransDO[] update(OrdApTransDO[] dos);
        void logicDelete(OrdApTransDO[] dos);
        OrdApTransDO findById(String id);
        OrdApTransDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApTransDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApTransDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApTransDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApTransDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApTransDO[] enableWithoutFilter(OrdApTransDO[] dos) ;
	    DOWithErrLog enableDO(OrdApTransDO[] dos) ;
	    OrdApTransDO[] disableVOWithoutFilter(OrdApTransDO[] dos);
	    DOWithErrLog disableDO(OrdApTransDO[] dos) ;
	    OrdApTransDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApTransDO[] findByAttrValString(String attr, String value);
	    OrdApTransDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApTransDO[] findByAttrValList(String attr, FArrayList values);
    }
}
