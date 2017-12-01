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
    public interface IStdDOCrudService
    {
        void delete(StdDO[] dos);
        StdDO[] insert(StdDO[] dos);
        StdDO[] save(StdDO[] dos);
        StdDO[] update(StdDO[] dos);
        void logicDelete(StdDO[] dos);
        StdDO findById(String id);
        StdDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        StdDO[] findByIds(String[] ids, FBoolean isLazy);
        StdDO[] findByBIds(String[] ids, FBoolean isLazy);
        StdDO[] find(String condition, string orderStr, FBoolean isLazy);
        StdDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<StdDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<StdDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    StdDO[] enableWithoutFilter(StdDO[] aggdos) ;
	    DOWithErrLog enableDO(StdDO[] aggdos) ;
	    StdDO[] disableVOWithoutFilter(StdDO[] aggdos);
	    DOWithErrLog disableDO(StdDO[] aggdos) ;
	    StdDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    StdDO[] findByAttrValString(String attr, String value);
	    StdDO[] findByAttrValStrings(String attr, String[] values);
	    StdDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<StdDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
