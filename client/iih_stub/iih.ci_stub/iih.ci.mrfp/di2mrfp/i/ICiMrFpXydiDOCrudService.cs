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
    public interface ICiMrFpXydiDOCrudService
    {
        void delete(CiMrFpXydiDO[] dos);
        CiMrFpXydiDO[] insert(CiMrFpXydiDO[] dos);
        CiMrFpXydiDO[] save(CiMrFpXydiDO[] dos);
        CiMrFpXydiDO[] update(CiMrFpXydiDO[] dos);
        void logicDelete(CiMrFpXydiDO[] dos);
        CiMrFpXydiDO findById(String id);
        CiMrFpXydiDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrFpXydiDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrFpXydiDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrFpXydiDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrFpXydiDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrFpXydiDO[] enableWithoutFilter(CiMrFpXydiDO[] aggdos) ;
	    DOWithErrLog enableDO(CiMrFpXydiDO[] aggdos) ;
	    CiMrFpXydiDO[] disableVOWithoutFilter(CiMrFpXydiDO[] aggdos);
	    DOWithErrLog disableDO(CiMrFpXydiDO[] aggdos) ;
	    CiMrFpXydiDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrFpXydiDO[] findByAttrValString(String attr, String value);
	    CiMrFpXydiDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrFpXydiDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiMrFpXydiDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
