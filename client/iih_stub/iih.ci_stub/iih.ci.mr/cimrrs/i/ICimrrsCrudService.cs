using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.cimrrs.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.cimrrs.i
{
    public interface ICimrrsCrudService
    {
        void delete(CiMrRsDO[] dos);
        CiMrRsDO[] insert(CiMrRsDO[] dos);
        CiMrRsDO[] save(CiMrRsDO[] dos);
        CiMrRsDO[] update(CiMrRsDO[] dos);
        void logicDelete(CiMrRsDO[] dos);
        CiMrRsDO findById(String id);
        CiMrRsDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrRsDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrRsDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrRsDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrRsDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrRsDO[] enableWithoutFilter(CiMrRsDO[] dos) ;
	    DOWithErrLog enableDO(CiMrRsDO[] dos) ;
	    CiMrRsDO[] disableVOWithoutFilter(CiMrRsDO[] dos);
	    DOWithErrLog disableDO(CiMrRsDO[] dos) ;
	    PagingRtnData<CiMrRsDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrRsDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrRsDO[] findByAttrValString(String attr, String value);
	    CiMrRsDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrRsDO[] findByAttrValList(String attr, FArrayList values);
    }
}
