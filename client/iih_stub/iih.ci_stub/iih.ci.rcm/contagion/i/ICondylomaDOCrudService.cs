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
    public interface ICondylomaDOCrudService
    {
        void delete(CondylomaDO[] dos);
        CondylomaDO[] insert(CondylomaDO[] dos);
        CondylomaDO[] save(CondylomaDO[] dos);
        CondylomaDO[] update(CondylomaDO[] dos);
        void logicDelete(CondylomaDO[] dos);
        CondylomaDO findById(String id);
        CondylomaDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        CondylomaDO[] findByIds(String[] ids, FBoolean isLazy);
        CondylomaDO[] findByBIds(String[] ids, FBoolean isLazy);
        CondylomaDO[] find(String condition, string orderStr, FBoolean isLazy);
        CondylomaDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CondylomaDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CondylomaDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CondylomaDO[] enableWithoutFilter(CondylomaDO[] aggdos) ;
	    DOWithErrLog enableDO(CondylomaDO[] aggdos) ;
	    CondylomaDO[] disableVOWithoutFilter(CondylomaDO[] aggdos);
	    DOWithErrLog disableDO(CondylomaDO[] aggdos) ;
	    CondylomaDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CondylomaDO[] findByAttrValString(String attr, String value);
	    CondylomaDO[] findByAttrValStrings(String attr, String[] values);
	    CondylomaDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CondylomaDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
