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
    public interface IDi2mrfpMDOCrudService
    {
        void delete(CiMrfpDiDO[] dos);
        CiMrfpDiDO[] insert(CiMrfpDiDO[] dos);
        CiMrfpDiDO[] save(CiMrfpDiDO[] dos);
        CiMrfpDiDO[] update(CiMrfpDiDO[] dos);
        void logicDelete(CiMrfpDiDO[] dos);
        CiMrfpDiDO findById(String id);
        CiMrfpDiDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrfpDiDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrfpDiDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrfpDiDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrfpDiDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrfpDiDO[] enableWithoutFilter(CiMrfpDiDO[] aggdos) ;
	    DOWithErrLog enableDO(CiMrfpDiDO[] aggdos) ;
	    CiMrfpDiDO[] disableVOWithoutFilter(CiMrfpDiDO[] aggdos);
	    DOWithErrLog disableDO(CiMrfpDiDO[] aggdos) ;
	    CiMrfpDiDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrfpDiDO[] findByAttrValString(String attr, String value);
	    CiMrfpDiDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrfpDiDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiMrfpDiDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
