using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciprn.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciprn.i
{
    public interface ICiprintMDOCrudService
    {
        void delete(CiPrnDO[] dos);
        CiPrnDO[] insert(CiPrnDO[] dos);
        CiPrnDO[] save(CiPrnDO[] dos);
        CiPrnDO[] update(CiPrnDO[] dos);
        void logicDelete(CiPrnDO[] dos);
        CiPrnDO findById(String id);
        CiPrnDO[] findByIds(String[] ids, FBoolean isLazy);
        CiPrnDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiPrnDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiPrnDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiPrnDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiPrnDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiPrnDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiPrnDO[] enableWithoutFilter(CiPrnDO[] aggdos) ;
	    DOWithErrLog enableDO(CiPrnDO[] aggdos) ;
	    CiPrnDO[] disableVOWithoutFilter(CiPrnDO[] aggdos);
	    DOWithErrLog disableDO(CiPrnDO[] aggdos) ;
	    CiPrnDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiPrnDO[] findByAttrValString(String attr, String value);
	    CiPrnDO[] findByAttrValStrings(String attr, String[] values);
	    CiPrnDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiPrnDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
