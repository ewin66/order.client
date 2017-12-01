using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciorder.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciorder.i
{
    public interface ICiorderMDOCrudService
    {
        void delete(CiOrderDO[] dos);
        CiOrderDO[] insert(CiOrderDO[] dos);
        CiOrderDO[] save(CiOrderDO[] dos);
        CiOrderDO[] update(CiOrderDO[] dos);
        void logicDelete(CiOrderDO[] dos);
        CiOrderDO findById(String id);
        CiOrderDO[] findByIds(String[] ids, FBoolean isLazy);
        CiOrderDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiOrderDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiOrderDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiOrderDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiOrderDO[] enableWithoutFilter(CiOrderDO[] aggdos) ;
	    DOWithErrLog enableDO(CiOrderDO[] aggdos) ;
	    CiOrderDO[] disableVOWithoutFilter(CiOrderDO[] aggdos);
	    DOWithErrLog disableDO(CiOrderDO[] aggdos) ;
	    CiOrderDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiOrderDO[] findByAttrValString(String attr, String value);
	    CiOrderDO[] findByAttrValStrings(String attr, String[] values);
	    CiOrderDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiOrderDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
