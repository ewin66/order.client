using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.cimrfs.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.cimrfs.i
{
    public interface ICimrfsCrudService
    {
        void delete(CiMrFsDO[] dos);
        CiMrFsDO[] insert(CiMrFsDO[] dos);
        CiMrFsDO[] save(CiMrFsDO[] dos);
        CiMrFsDO[] update(CiMrFsDO[] dos);
        void logicDelete(CiMrFsDO[] dos);
        CiMrFsDO findById(String id);
        CiMrFsDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrFsDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrFsDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrFsDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrFsDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrFsDO[] enableWithoutFilter(CiMrFsDO[] dos) ;
	    DOWithErrLog enableDO(CiMrFsDO[] dos) ;
	    CiMrFsDO[] disableVOWithoutFilter(CiMrFsDO[] dos);
	    DOWithErrLog disableDO(CiMrFsDO[] dos) ;
	    CiMrFsDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
    }
}
