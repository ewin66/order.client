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
    public interface IOrConsApAuditDOCrudService
    {
        void delete(OrConsApAuditDO[] dos);
        OrConsApAuditDO[] insert(OrConsApAuditDO[] dos);
        OrConsApAuditDO[] save(OrConsApAuditDO[] dos);
        OrConsApAuditDO[] update(OrConsApAuditDO[] dos);
        void logicDelete(OrConsApAuditDO[] dos);
        OrConsApAuditDO findById(String id);
        OrConsApAuditDO[] findByIds(String[] ids, FBoolean isLazy);
        OrConsApAuditDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrConsApAuditDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrConsApAuditDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrConsApAuditDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrConsApAuditDO[] enableWithoutFilter(OrConsApAuditDO[] aggdos) ;
	    DOWithErrLog enableDO(OrConsApAuditDO[] aggdos) ;
	    OrConsApAuditDO[] disableVOWithoutFilter(OrConsApAuditDO[] aggdos);
	    DOWithErrLog disableDO(OrConsApAuditDO[] aggdos) ;
	    OrConsApAuditDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrConsApAuditDO[] findByAttrValString(String attr, String value);
	    OrConsApAuditDO[] findByAttrValStrings(String attr, String[] values);
	    OrConsApAuditDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrConsApAuditDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
