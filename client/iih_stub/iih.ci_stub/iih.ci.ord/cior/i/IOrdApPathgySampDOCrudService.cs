using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cior.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cior.i
{
    public interface IOrdApPathgySampDOCrudService
    {
        void delete(OrdApPathgySampDO[] dos);
        OrdApPathgySampDO[] insert(OrdApPathgySampDO[] dos);
        OrdApPathgySampDO[] save(OrdApPathgySampDO[] dos);
        OrdApPathgySampDO[] update(OrdApPathgySampDO[] dos);
        void logicDelete(OrdApPathgySampDO[] dos);
        OrdApPathgySampDO findById(String id);
        OrdApPathgySampDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        OrdApPathgySampDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApPathgySampDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApPathgySampDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApPathgySampDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApPathgySampDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<OrdApPathgySampDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    OrdApPathgySampDO[] enableWithoutFilter(OrdApPathgySampDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdApPathgySampDO[] aggdos) ;
	    OrdApPathgySampDO[] disableVOWithoutFilter(OrdApPathgySampDO[] aggdos);
	    DOWithErrLog disableDO(OrdApPathgySampDO[] aggdos) ;
	    OrdApPathgySampDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApPathgySampDO[] findByAttrValString(String attr, String value);
	    OrdApPathgySampDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApPathgySampDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdApPathgySampDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
