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
    public interface ICiordInviteConsDOCrudService
    {
        void delete(CiordInviteConsDO[] dos);
        CiordInviteConsDO[] insert(CiordInviteConsDO[] dos);
        CiordInviteConsDO[] save(CiordInviteConsDO[] dos);
        CiordInviteConsDO[] update(CiordInviteConsDO[] dos);
        void logicDelete(CiordInviteConsDO[] dos);
        CiordInviteConsDO findById(String id);
        CiordInviteConsDO[] findByIds(String[] ids, FBoolean isLazy);
        CiordInviteConsDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiordInviteConsDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiordInviteConsDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiordInviteConsDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiordInviteConsDO[] enableWithoutFilter(CiordInviteConsDO[] aggdos) ;
	    DOWithErrLog enableDO(CiordInviteConsDO[] aggdos) ;
	    CiordInviteConsDO[] disableVOWithoutFilter(CiordInviteConsDO[] aggdos);
	    DOWithErrLog disableDO(CiordInviteConsDO[] aggdos) ;
	    CiordInviteConsDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiordInviteConsDO[] findByAttrValString(String attr, String value);
	    CiordInviteConsDO[] findByAttrValStrings(String attr, String[] values);
	    CiordInviteConsDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiordInviteConsDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
