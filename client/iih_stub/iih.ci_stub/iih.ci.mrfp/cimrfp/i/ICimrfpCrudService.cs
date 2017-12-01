using System;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrfp.cimrfp.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrfp.cimrfp.i
{
    public interface ICimrfpCrudService
    {
        void delete(CiMrFpDO[] dos);
        CiMrFpDO[] insert(CiMrFpDO[] dos);
        CiMrFpDO[] save(CiMrFpDO[] dos);
        CiMrFpDO[] update(CiMrFpDO[] dos);
        void logicDelete(CiMrFpDO[] dos);
        CiMrFpDO findById(String id);
        CiMrFpDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrFpDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrFpDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrFpDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrFpDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrFpDO[] enableWithoutFilter(CiMrFpDO[] dos) ;
	    DOWithErrLog enableDO(CiMrFpDO[] dos) ;
	    CiMrFpDO[] disableVOWithoutFilter(CiMrFpDO[] dos);
	    DOWithErrLog disableDO(CiMrFpDO[] dos) ;
	    PagingRtnData<CiMrFpDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrFpDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrFpDO[] findByAttrValString(String attr, String value);
	    CiMrFpDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrFpDO[] findByAttrValList(String attr, FArrayList values);
    }
}
