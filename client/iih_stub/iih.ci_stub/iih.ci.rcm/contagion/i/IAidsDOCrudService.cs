using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.contagion.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.contagion.i
{
    public interface IAidsDOCrudService
    {
        void delete(AidsDO[] dos);
        AidsDO[] insert(AidsDO[] dos);
        AidsDO[] save(AidsDO[] dos);
        AidsDO[] update(AidsDO[] dos);
        void logicDelete(AidsDO[] dos);
        AidsDO findById(String id);
        AidsDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        AidsDO[] findByIds(String[] ids, FBoolean isLazy);
        AidsDO[] findByBIds(String[] ids, FBoolean isLazy);
        AidsDO[] find(String condition, string orderStr, FBoolean isLazy);
        AidsDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AidsDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<AidsDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    AidsDO[] enableWithoutFilter(AidsDO[] aggdos) ;
	    DOWithErrLog enableDO(AidsDO[] aggdos) ;
	    AidsDO[] disableVOWithoutFilter(AidsDO[] aggdos);
	    DOWithErrLog disableDO(AidsDO[] aggdos) ;
	    AidsDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AidsDO[] findByAttrValString(String attr, String value);
	    AidsDO[] findByAttrValStrings(String attr, String[] values);
	    AidsDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<AidsDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
