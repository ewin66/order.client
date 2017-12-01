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
    public interface ICiorappouthospCrudService
    {
        void delete(OrdApOutDO[] dos);
        OrdApOutDO[] insert(OrdApOutDO[] dos);
        OrdApOutDO[] save(OrdApOutDO[] dos);
        OrdApOutDO[] update(OrdApOutDO[] dos);
        void logicDelete(OrdApOutDO[] dos);
        OrdApOutDO findById(String id);
        OrdApOutDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApOutDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApOutDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApOutDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApOutDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApOutDO[] enableWithoutFilter(OrdApOutDO[] dos) ;
	    DOWithErrLog enableDO(OrdApOutDO[] dos) ;
	    OrdApOutDO[] disableVOWithoutFilter(OrdApOutDO[] dos);
	    DOWithErrLog disableDO(OrdApOutDO[] dos) ;
	    OrdApOutDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApOutDO[] findByAttrValString(String attr, String value);
	    OrdApOutDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApOutDO[] findByAttrValList(String attr, FArrayList values);
    }
}
