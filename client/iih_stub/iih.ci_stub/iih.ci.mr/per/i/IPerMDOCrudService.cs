using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.per.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.per.i
{
    public interface IPerMDOCrudService
    {
        void delete(PerDO[] dos);
        PerDO[] insert(PerDO[] dos);
        PerDO[] save(PerDO[] dos);
        PerDO[] update(PerDO[] dos);
        void logicDelete(PerDO[] dos);
        PerDO findById(String id);
        PerDO[] findByIds(String[] ids, FBoolean isLazy);
        PerDO[] findByBIds(String[] ids, FBoolean isLazy);
        PerDO[] find(String condition, string orderStr, FBoolean isLazy);
        PerDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<PerDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    PerDO[] enableWithoutFilter(PerDO[] aggdos) ;
	    DOWithErrLog enableDO(PerDO[] aggdos) ;
	    PerDO[] disableVOWithoutFilter(PerDO[] aggdos);
	    DOWithErrLog disableDO(PerDO[] aggdos) ;
	    PerDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    PerDO[] findByAttrValString(String attr, String value);
	    PerDO[] findByAttrValStrings(String attr, String[] values);
	    PerDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<PerDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
