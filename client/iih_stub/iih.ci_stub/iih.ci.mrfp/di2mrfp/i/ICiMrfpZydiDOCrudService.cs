using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrfp.di2mrfp.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrfp.di2mrfp.i
{
    public interface ICiMrfpZydiDOCrudService
    {
        void delete(CiMrfpZydiDO[] dos);
        CiMrfpZydiDO[] insert(CiMrfpZydiDO[] dos);
        CiMrfpZydiDO[] save(CiMrfpZydiDO[] dos);
        CiMrfpZydiDO[] update(CiMrfpZydiDO[] dos);
        void logicDelete(CiMrfpZydiDO[] dos);
        CiMrfpZydiDO findById(String id);
        CiMrfpZydiDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrfpZydiDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrfpZydiDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrfpZydiDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrfpZydiDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrfpZydiDO[] enableWithoutFilter(CiMrfpZydiDO[] aggdos) ;
	    DOWithErrLog enableDO(CiMrfpZydiDO[] aggdos) ;
	    CiMrfpZydiDO[] disableVOWithoutFilter(CiMrfpZydiDO[] aggdos);
	    DOWithErrLog disableDO(CiMrfpZydiDO[] aggdos) ;
	    CiMrfpZydiDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrfpZydiDO[] findByAttrValString(String attr, String value);
	    CiMrfpZydiDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrfpZydiDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiMrfpZydiDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
