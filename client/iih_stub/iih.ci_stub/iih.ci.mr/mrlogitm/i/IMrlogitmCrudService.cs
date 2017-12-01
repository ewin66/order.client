using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.mrlogitm.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.mrlogitm.i
{
    public interface IMrlogitmCrudService
    {
        void delete(CiMrLogItmDO[] dos);
        CiMrLogItmDO[] insert(CiMrLogItmDO[] dos);
        CiMrLogItmDO[] save(CiMrLogItmDO[] dos);
        CiMrLogItmDO[] update(CiMrLogItmDO[] dos);
        void logicDelete(CiMrLogItmDO[] dos);
        CiMrLogItmDO findById(String id);
        CiMrLogItmDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrLogItmDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrLogItmDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrLogItmDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrLogItmDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrLogItmDO[] enableWithoutFilter(CiMrLogItmDO[] dos) ;
	    DOWithErrLog enableDO(CiMrLogItmDO[] dos) ;
	    CiMrLogItmDO[] disableVOWithoutFilter(CiMrLogItmDO[] dos);
	    DOWithErrLog disableDO(CiMrLogItmDO[] dos) ;
	    PagingRtnData<CiMrLogItmDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrLogItmDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrLogItmDO[] findByAttrValString(String attr, String value);
	    CiMrLogItmDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrLogItmDO[] findByAttrValList(String attr, FArrayList values);
    }
}
