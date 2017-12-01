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
    public interface ICiorapppathgyMDOCrudService
    {
        void delete(OrdApPathgyDO[] dos);
        OrdApPathgyDO[] insert(OrdApPathgyDO[] dos);
        OrdApPathgyDO[] save(OrdApPathgyDO[] dos);
        OrdApPathgyDO[] update(OrdApPathgyDO[] dos);
        void logicDelete(OrdApPathgyDO[] dos);
        OrdApPathgyDO findById(String id);
        OrdApPathgyDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApPathgyDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApPathgyDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApPathgyDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        OrdApPathgyDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApPathgyDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<OrdApPathgyDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    OrdApPathgyDO[] enableWithoutFilter(OrdApPathgyDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdApPathgyDO[] aggdos) ;
	    OrdApPathgyDO[] disableVOWithoutFilter(OrdApPathgyDO[] aggdos);
	    DOWithErrLog disableDO(OrdApPathgyDO[] aggdos) ;
	    OrdApPathgyDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApPathgyDO[] findByAttrValString(String attr, String value);
	    OrdApPathgyDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApPathgyDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdApPathgyDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
