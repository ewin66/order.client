using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ordprn.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ordprn.i
{
    public interface IOrdprintcfgCrudService
    {
        void delete(OrdPrintCfgDO[] dos);
        OrdPrintCfgDO[] insert(OrdPrintCfgDO[] dos);
        OrdPrintCfgDO[] save(OrdPrintCfgDO[] dos);
        OrdPrintCfgDO[] update(OrdPrintCfgDO[] dos);
        void logicDelete(OrdPrintCfgDO[] dos);
        OrdPrintCfgDO findById(String id);
        OrdPrintCfgDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdPrintCfgDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdPrintCfgDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdPrintCfgDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdPrintCfgDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdPrintCfgDO[] enableWithoutFilter(OrdPrintCfgDO[] dos) ;
	    DOWithErrLog enableDO(OrdPrintCfgDO[] dos) ;
	    OrdPrintCfgDO[] disableVOWithoutFilter(OrdPrintCfgDO[] dos);
	    DOWithErrLog disableDO(OrdPrintCfgDO[] dos) ;
	    PagingRtnData<OrdPrintCfgDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OrdPrintCfgDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdPrintCfgDO[] findByAttrValString(String attr, String value);
	    OrdPrintCfgDO[] findByAttrValStrings(String attr, String[] values);
	    OrdPrintCfgDO[] findByAttrValList(String attr, FArrayList values);
    }
}
