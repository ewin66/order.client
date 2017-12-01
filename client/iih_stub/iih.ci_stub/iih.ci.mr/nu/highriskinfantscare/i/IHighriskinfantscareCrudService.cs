using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.highriskinfantscare.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.highriskinfantscare.i
{
    public interface IHighriskinfantscareCrudService
    {
        void delete(ChildrenCareDO[] dos);
        ChildrenCareDO[] insert(ChildrenCareDO[] dos);
        ChildrenCareDO[] save(ChildrenCareDO[] dos);
        ChildrenCareDO[] update(ChildrenCareDO[] dos);
        void logicDelete(ChildrenCareDO[] dos);
        ChildrenCareDO findById(String id);
        ChildrenCareDO[] findByIds(String[] ids, FBoolean isLazy);
        ChildrenCareDO[] findByBIds(String[] ids, FBoolean isLazy);
        ChildrenCareDO[] find(String condition, string orderStr, FBoolean isLazy);
        ChildrenCareDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<ChildrenCareDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    ChildrenCareDO[] enableWithoutFilter(ChildrenCareDO[] dos) ;
	    DOWithErrLog enableDO(ChildrenCareDO[] dos) ;
	    ChildrenCareDO[] disableVOWithoutFilter(ChildrenCareDO[] dos);
	    DOWithErrLog disableDO(ChildrenCareDO[] dos) ;
	    PagingRtnData<ChildrenCareDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    ChildrenCareDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ChildrenCareDO[] findByAttrValString(String attr, String value);
	    ChildrenCareDO[] findByAttrValStrings(String attr, String[] values);
	    ChildrenCareDO[] findByAttrValList(String attr, FArrayList values);
    }
}