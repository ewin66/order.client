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
    public interface ICiordrptbttestMDOCrudService
    {
        void delete(CiOrdBtTestDO[] dos);
        CiOrdBtTestDO[] insert(CiOrdBtTestDO[] dos);
        CiOrdBtTestDO[] save(CiOrdBtTestDO[] dos);
        CiOrdBtTestDO[] update(CiOrdBtTestDO[] dos);
        void logicDelete(CiOrdBtTestDO[] dos);
        CiOrdBtTestDO findById(String id);
        CiOrdBtTestDO[] findByIds(String[] ids, FBoolean isLazy);
        CiOrdBtTestDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiOrdBtTestDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiOrdBtTestDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiOrdBtTestDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiOrdBtTestDO[] enableWithoutFilter(CiOrdBtTestDO[] aggdos) ;
	    DOWithErrLog enableDO(CiOrdBtTestDO[] aggdos) ;
	    CiOrdBtTestDO[] disableVOWithoutFilter(CiOrdBtTestDO[] aggdos);
	    DOWithErrLog disableDO(CiOrdBtTestDO[] aggdos) ;
	    CiOrdBtTestDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiOrdBtTestDO[] findByAttrValString(String attr, String value);
	    CiOrdBtTestDO[] findByAttrValStrings(String attr, String[] values);
	    CiOrdBtTestDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiOrdBtTestDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
