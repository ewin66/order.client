using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrfp.other2mrfp.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrfp.other2mrfp.i
{
    public interface ICiMrfpIntenCareDOCrudService
    {
        void delete(CiMrfpIntenCareDO[] dos);
        CiMrfpIntenCareDO[] insert(CiMrfpIntenCareDO[] dos);
        CiMrfpIntenCareDO[] save(CiMrfpIntenCareDO[] dos);
        CiMrfpIntenCareDO[] update(CiMrfpIntenCareDO[] dos);
        void logicDelete(CiMrfpIntenCareDO[] dos);
        CiMrfpIntenCareDO findById(String id);
        CiMrfpIntenCareDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrfpIntenCareDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrfpIntenCareDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrfpIntenCareDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrfpIntenCareDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrfpIntenCareDO[] enableWithoutFilter(CiMrfpIntenCareDO[] aggdos) ;
	    DOWithErrLog enableDO(CiMrfpIntenCareDO[] aggdos) ;
	    CiMrfpIntenCareDO[] disableVOWithoutFilter(CiMrfpIntenCareDO[] aggdos);
	    DOWithErrLog disableDO(CiMrfpIntenCareDO[] aggdos) ;
	    CiMrfpIntenCareDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrfpIntenCareDO[] findByAttrValString(String attr, String value);
	    CiMrfpIntenCareDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrfpIntenCareDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiMrfpIntenCareDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
