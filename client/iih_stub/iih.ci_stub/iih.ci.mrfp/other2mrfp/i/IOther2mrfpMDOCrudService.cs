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
    public interface IOther2mrfpMDOCrudService
    {
        void delete(CiMrFpOtherDO[] dos);
        CiMrFpOtherDO[] insert(CiMrFpOtherDO[] dos);
        CiMrFpOtherDO[] save(CiMrFpOtherDO[] dos);
        CiMrFpOtherDO[] update(CiMrFpOtherDO[] dos);
        void logicDelete(CiMrFpOtherDO[] dos);
        CiMrFpOtherDO findById(String id);
        CiMrFpOtherDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrFpOtherDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrFpOtherDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrFpOtherDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrFpOtherDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrFpOtherDO[] enableWithoutFilter(CiMrFpOtherDO[] aggdos) ;
	    DOWithErrLog enableDO(CiMrFpOtherDO[] aggdos) ;
	    CiMrFpOtherDO[] disableVOWithoutFilter(CiMrFpOtherDO[] aggdos);
	    DOWithErrLog disableDO(CiMrFpOtherDO[] aggdos) ;
	    CiMrFpOtherDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrFpOtherDO[] findByAttrValString(String attr, String value);
	    CiMrFpOtherDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrFpOtherDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiMrFpOtherDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
