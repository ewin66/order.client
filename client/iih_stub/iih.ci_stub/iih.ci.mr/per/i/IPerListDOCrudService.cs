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
    public interface IPerListDOCrudService
    {
        void delete(PerListDO[] dos);
        PerListDO[] insert(PerListDO[] dos);
        PerListDO[] save(PerListDO[] dos);
        PerListDO[] update(PerListDO[] dos);
        void logicDelete(PerListDO[] dos);
        PerListDO findById(String id);
        PerListDO[] findByIds(String[] ids, FBoolean isLazy);
        PerListDO[] findByBIds(String[] ids, FBoolean isLazy);
        PerListDO[] find(String condition, string orderStr, FBoolean isLazy);
        PerListDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<PerListDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    PerListDO[] enableWithoutFilter(PerListDO[] aggdos) ;
	    DOWithErrLog enableDO(PerListDO[] aggdos) ;
	    PerListDO[] disableVOWithoutFilter(PerListDO[] aggdos);
	    DOWithErrLog disableDO(PerListDO[] aggdos) ;
	    PerListDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    PerListDO[] findByAttrValString(String attr, String value);
	    PerListDO[] findByAttrValStrings(String attr, String[] values);
	    PerListDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<PerListDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
