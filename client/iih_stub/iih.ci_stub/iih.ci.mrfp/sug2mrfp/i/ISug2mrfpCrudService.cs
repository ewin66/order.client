using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrfp.sug2mrfp.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrfp.sug2mrfp.i
{
    public interface ISug2mrfpCrudService
    {
        void delete(CiMrFpSugDO[] dos);
        CiMrFpSugDO[] insert(CiMrFpSugDO[] dos);
        CiMrFpSugDO[] save(CiMrFpSugDO[] dos);
        CiMrFpSugDO[] update(CiMrFpSugDO[] dos);
        void logicDelete(CiMrFpSugDO[] dos);
        CiMrFpSugDO findById(String id);
        CiMrFpSugDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrFpSugDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrFpSugDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrFpSugDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrFpSugDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrFpSugDO[] enableWithoutFilter(CiMrFpSugDO[] dos) ;
	    DOWithErrLog enableDO(CiMrFpSugDO[] dos) ;
	    CiMrFpSugDO[] disableVOWithoutFilter(CiMrFpSugDO[] dos);
	    DOWithErrLog disableDO(CiMrFpSugDO[] dos) ;
	    PagingRtnData<CiMrFpSugDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrFpSugDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrFpSugDO[] findByAttrValString(String attr, String value);
	    CiMrFpSugDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrFpSugDO[] findByAttrValList(String attr, FArrayList values);
    }
}
