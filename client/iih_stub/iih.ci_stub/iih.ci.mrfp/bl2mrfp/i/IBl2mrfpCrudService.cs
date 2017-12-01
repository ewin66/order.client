using System;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrfp.bl2mrfp.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrfp.bl2mrfp.i
{
    public interface IBl2MrfpCrudService
    {
        void delete(CiMrFpBlDO[] dos);
        CiMrFpBlDO[] insert(CiMrFpBlDO[] dos);
        CiMrFpBlDO[] save(CiMrFpBlDO[] dos);
        CiMrFpBlDO[] update(CiMrFpBlDO[] dos);
        void logicDelete(CiMrFpBlDO[] dos);
        CiMrFpBlDO findById(String id);
        CiMrFpBlDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrFpBlDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrFpBlDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrFpBlDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrFpBlDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrFpBlDO[] enableWithoutFilter(CiMrFpBlDO[] dos) ;
	    DOWithErrLog enableDO(CiMrFpBlDO[] dos) ;
	    CiMrFpBlDO[] disableVOWithoutFilter(CiMrFpBlDO[] dos);
	    DOWithErrLog disableDO(CiMrFpBlDO[] dos) ;
	    PagingRtnData<CiMrFpBlDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrFpBlDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrFpBlDO[] findByAttrValString(String attr, String value);
	    CiMrFpBlDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrFpBlDO[] findByAttrValList(String attr, FArrayList values);
    }
}
