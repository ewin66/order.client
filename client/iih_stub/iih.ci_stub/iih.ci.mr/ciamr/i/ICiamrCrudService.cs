using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.ciamr.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.ciamr.i
{
    public interface ICiamrCrudService
    {
        void delete(AMrDO[] dos);
        AMrDO[] insert(AMrDO[] dos);
        AMrDO[] save(AMrDO[] dos);
        AMrDO[] update(AMrDO[] dos);
        void logicDelete(AMrDO[] dos);
        AMrDO findById(String id);
        AMrDO[] findByIds(String[] ids, FBoolean isLazy);
        AMrDO[] findByBIds(String[] ids, FBoolean isLazy);
        AMrDO[] find(String condition, string orderStr, FBoolean isLazy);
        AMrDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AMrDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    AMrDO[] enableWithoutFilter(AMrDO[] dos) ;
	    DOWithErrLog enableDO(AMrDO[] dos) ;
	    AMrDO[] disableVOWithoutFilter(AMrDO[] dos);
	    DOWithErrLog disableDO(AMrDO[] dos) ;
	    PagingRtnData<AMrDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    AMrDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AMrDO[] findByAttrValString(String attr, String value);
	    AMrDO[] findByAttrValStrings(String attr, String[] values);
	    AMrDO[] findByAttrValList(String attr, FArrayList values);
    }
}