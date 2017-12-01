using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.mrlog.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.mrlog.i
{
    public interface ICimrlogCrudService
    {
        void delete(CiMrLogDO[] dos);
        CiMrLogDO[] insert(CiMrLogDO[] dos);
        CiMrLogDO[] save(CiMrLogDO[] dos);
        CiMrLogDO[] update(CiMrLogDO[] dos);
        void logicDelete(CiMrLogDO[] dos);
        CiMrLogDO findById(String id);
        CiMrLogDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrLogDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrLogDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrLogDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrLogDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrLogDO[] enableWithoutFilter(CiMrLogDO[] dos) ;
	    DOWithErrLog enableDO(CiMrLogDO[] dos) ;
	    CiMrLogDO[] disableVOWithoutFilter(CiMrLogDO[] dos);
	    DOWithErrLog disableDO(CiMrLogDO[] dos) ;
	    PagingRtnData<CiMrLogDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrLogDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrLogDO[] findByAttrValString(String attr, String value);
	    CiMrLogDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrLogDO[] findByAttrValList(String attr, FArrayList values);
    }
}
