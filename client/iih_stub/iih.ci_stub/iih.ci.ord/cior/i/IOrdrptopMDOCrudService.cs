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
    public interface IOrdrptopMDOCrudService
    {
        void delete(OrdApRptOpDO[] dos);
        OrdApRptOpDO[] insert(OrdApRptOpDO[] dos);
        OrdApRptOpDO[] save(OrdApRptOpDO[] dos);
        OrdApRptOpDO[] update(OrdApRptOpDO[] dos);
        void logicDelete(OrdApRptOpDO[] dos);
        OrdApRptOpDO findById(String id);
        OrdApRptOpDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApRptOpDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApRptOpDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApRptOpDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApRptOpDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApRptOpDO[] enableWithoutFilter(OrdApRptOpDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdApRptOpDO[] aggdos) ;
	    OrdApRptOpDO[] disableVOWithoutFilter(OrdApRptOpDO[] aggdos);
	    DOWithErrLog disableDO(OrdApRptOpDO[] aggdos) ;
	    OrdApRptOpDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApRptOpDO[] findByAttrValString(String attr, String value);
	    OrdApRptOpDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApRptOpDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdApRptOpDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
