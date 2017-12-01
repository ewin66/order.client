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
    public interface ICiorapplisCrudService
    {
        void delete(OrdApLabDO[] dos);
        OrdApLabDO[] insert(OrdApLabDO[] dos);
        OrdApLabDO[] save(OrdApLabDO[] dos);
        OrdApLabDO[] update(OrdApLabDO[] dos);
        void logicDelete(OrdApLabDO[] dos);
        OrdApLabDO findById(String id);
        OrdApLabDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApLabDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApLabDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApLabDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApLabDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApLabDO[] enableWithoutFilter(OrdApLabDO[] dos) ;
	    DOWithErrLog enableDO(OrdApLabDO[] dos) ;
	    OrdApLabDO[] disableVOWithoutFilter(OrdApLabDO[] dos);
	    DOWithErrLog disableDO(OrdApLabDO[] dos) ;
	    PagingRtnData<OrdApLabDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OrdApLabDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApLabDO[] findByAttrValString(String attr, String value);
	    OrdApLabDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApLabDO[] findByAttrValList(String attr, FArrayList values);
    }
}
