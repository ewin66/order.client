using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.hosmiddle.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.hosmiddle.i
{
    public interface IHosmiddleCrudService
    {
        void delete(HOSMIDDLEDO[] dos);
        HOSMIDDLEDO[] insert(HOSMIDDLEDO[] dos);
        HOSMIDDLEDO[] save(HOSMIDDLEDO[] dos);
        HOSMIDDLEDO[] update(HOSMIDDLEDO[] dos);
        void logicDelete(HOSMIDDLEDO[] dos);
        HOSMIDDLEDO findById(String id);
        HOSMIDDLEDO[] findByIds(String[] ids, FBoolean isLazy);
        HOSMIDDLEDO[] findByBIds(String[] ids, FBoolean isLazy);
        HOSMIDDLEDO[] find(String condition, string orderStr, FBoolean isLazy);
        HOSMIDDLEDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        HOSMIDDLEDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<HOSMIDDLEDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<HOSMIDDLEDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    HOSMIDDLEDO[] enableWithoutFilter(HOSMIDDLEDO[] dos) ;
	    DOWithErrLog enableDO(HOSMIDDLEDO[] dos) ;
	    HOSMIDDLEDO[] disableVOWithoutFilter(HOSMIDDLEDO[] dos);
	    DOWithErrLog disableDO(HOSMIDDLEDO[] dos) ;
	    PagingRtnData<HOSMIDDLEDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    HOSMIDDLEDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    HOSMIDDLEDO[] findByAttrValString(String attr, String value);
	    HOSMIDDLEDO[] findByAttrValStrings(String attr, String[] values);
	    HOSMIDDLEDO[] findByAttrValList(String attr, FArrayList values);
    }
}