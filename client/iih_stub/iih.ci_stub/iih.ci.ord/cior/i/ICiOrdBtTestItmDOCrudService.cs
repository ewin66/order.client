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
    public interface ICiOrdBtTestItmDOCrudService
    {
        void delete(CiOrdBtTestItmDO[] dos);
        CiOrdBtTestItmDO[] insert(CiOrdBtTestItmDO[] dos);
        CiOrdBtTestItmDO[] save(CiOrdBtTestItmDO[] dos);
        CiOrdBtTestItmDO[] update(CiOrdBtTestItmDO[] dos);
        void logicDelete(CiOrdBtTestItmDO[] dos);
        CiOrdBtTestItmDO findById(String id);
        CiOrdBtTestItmDO[] findByIds(String[] ids, FBoolean isLazy);
        CiOrdBtTestItmDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiOrdBtTestItmDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiOrdBtTestItmDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiOrdBtTestItmDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiOrdBtTestItmDO[] enableWithoutFilter(CiOrdBtTestItmDO[] aggdos) ;
	    DOWithErrLog enableDO(CiOrdBtTestItmDO[] aggdos) ;
	    CiOrdBtTestItmDO[] disableVOWithoutFilter(CiOrdBtTestItmDO[] aggdos);
	    DOWithErrLog disableDO(CiOrdBtTestItmDO[] aggdos) ;
	    CiOrdBtTestItmDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiOrdBtTestItmDO[] findByAttrValString(String attr, String value);
	    CiOrdBtTestItmDO[] findByAttrValStrings(String attr, String[] values);
	    CiOrdBtTestItmDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiOrdBtTestItmDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
