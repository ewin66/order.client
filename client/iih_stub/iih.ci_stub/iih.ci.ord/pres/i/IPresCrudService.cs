using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.pres.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.pres.i
{
    public interface IPresCrudService
    {
        void delete(CiPresDO[] dos);
        CiPresDO[] insert(CiPresDO[] dos);
        CiPresDO[] save(CiPresDO[] dos);
        CiPresDO[] update(CiPresDO[] dos);
        void logicDelete(CiPresDO[] dos);
        CiPresDO findById(String id);
        CiPresDO[] findByIds(String[] ids, FBoolean isLazy);
        CiPresDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiPresDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiPresDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiPresDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiPresDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiPresDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiPresDO[] enableWithoutFilter(CiPresDO[] dos) ;
	    DOWithErrLog enableDO(CiPresDO[] dos) ;
	    CiPresDO[] disableVOWithoutFilter(CiPresDO[] dos);
	    DOWithErrLog disableDO(CiPresDO[] dos) ;
	    PagingRtnData<CiPresDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiPresDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiPresDO[] findByAttrValString(String attr, String value);
	    CiPresDO[] findByAttrValStrings(String attr, String[] values);
	    CiPresDO[] findByAttrValList(String attr, FArrayList values);
    }
}