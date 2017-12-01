using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cipres.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cipres.i
{
    public interface ICipresCrudService
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
        CiPresDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiPresDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiPresDO[] enableWithoutFilter(CiPresDO[] dos) ;
	    DOWithErrLog enableDO(CiPresDO[] dos) ;
	    CiPresDO[] disableVOWithoutFilter(CiPresDO[] dos);
	    DOWithErrLog disableDO(CiPresDO[] dos) ;
	    CiPresDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
    }
}
