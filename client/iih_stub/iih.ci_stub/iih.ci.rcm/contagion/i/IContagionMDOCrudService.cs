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
    public interface IContagionMDOCrudService
    {
        void delete(ContagionDO[] dos);
        ContagionDO[] insert(ContagionDO[] dos);
        ContagionDO[] save(ContagionDO[] dos);
        ContagionDO[] update(ContagionDO[] dos);
        void logicDelete(ContagionDO[] dos);
        ContagionDO findById(String id);
        ContagionDO[] findByIds(String[] ids, FBoolean isLazy);
        ContagionDO[] findByBIds(String[] ids, FBoolean isLazy);
        ContagionDO[] find(String condition, string orderStr, FBoolean isLazy);
        ContagionDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<ContagionDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    ContagionDO[] enableWithoutFilter(ContagionDO[] aggdos) ;
	    DOWithErrLog enableDO(ContagionDO[] aggdos) ;
	    ContagionDO[] disableVOWithoutFilter(ContagionDO[] aggdos);
	    DOWithErrLog disableDO(ContagionDO[] aggdos) ;
	    ContagionDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ContagionDO[] findByAttrValString(String attr, String value);
	    ContagionDO[] findByAttrValStrings(String attr, String[] values);
	    ContagionDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<ContagionDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
