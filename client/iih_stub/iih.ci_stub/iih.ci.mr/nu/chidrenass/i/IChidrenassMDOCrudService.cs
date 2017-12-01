using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.chidrenass.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.chidrenass.i
{
    public interface IChidrenassMDOCrudService
    {
        void delete(ChildrenInAsseDO[] dos);
        ChildrenInAsseDO[] insert(ChildrenInAsseDO[] dos);
        ChildrenInAsseDO[] save(ChildrenInAsseDO[] dos);
        ChildrenInAsseDO[] update(ChildrenInAsseDO[] dos);
        void logicDelete(ChildrenInAsseDO[] dos);
        ChildrenInAsseDO findById(String id);
        ChildrenInAsseDO[] findByIds(String[] ids, FBoolean isLazy);
        ChildrenInAsseDO[] findByBIds(String[] ids, FBoolean isLazy);
        ChildrenInAsseDO[] find(String condition, string orderStr, FBoolean isLazy);
        ChildrenInAsseDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        ChildrenInAsseDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<ChildrenInAsseDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<ChildrenInAsseDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    ChildrenInAsseDO[] enableWithoutFilter(ChildrenInAsseDO[] aggdos) ;
	    DOWithErrLog enableDO(ChildrenInAsseDO[] aggdos) ;
	    ChildrenInAsseDO[] disableVOWithoutFilter(ChildrenInAsseDO[] aggdos);
	    DOWithErrLog disableDO(ChildrenInAsseDO[] aggdos) ;
	    ChildrenInAsseDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ChildrenInAsseDO[] findByAttrValString(String attr, String value);
	    ChildrenInAsseDO[] findByAttrValStrings(String attr, String[] values);
	    ChildrenInAsseDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<ChildrenInAsseDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
