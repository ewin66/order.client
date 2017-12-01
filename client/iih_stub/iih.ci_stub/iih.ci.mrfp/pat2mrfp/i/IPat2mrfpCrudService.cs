using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrfp.pat2mrfp.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrfp.pat2mrfp.i
{
    public interface IPat2mrfpCrudService
    {
        void delete(CiMrFpPatDO[] dos);
        CiMrFpPatDO[] insert(CiMrFpPatDO[] dos);
        CiMrFpPatDO[] save(CiMrFpPatDO[] dos);
        CiMrFpPatDO[] update(CiMrFpPatDO[] dos);
        void logicDelete(CiMrFpPatDO[] dos);
        CiMrFpPatDO findById(String id);
        CiMrFpPatDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrFpPatDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrFpPatDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrFpPatDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrFpPatDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrFpPatDO[] enableWithoutFilter(CiMrFpPatDO[] dos) ;
	    DOWithErrLog enableDO(CiMrFpPatDO[] dos) ;
	    CiMrFpPatDO[] disableVOWithoutFilter(CiMrFpPatDO[] dos);
	    DOWithErrLog disableDO(CiMrFpPatDO[] dos) ;
	    PagingRtnData<CiMrFpPatDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrFpPatDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrFpPatDO[] findByAttrValString(String attr, String value);
	    CiMrFpPatDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrFpPatDO[] findByAttrValList(String attr, FArrayList values);
    }
}
