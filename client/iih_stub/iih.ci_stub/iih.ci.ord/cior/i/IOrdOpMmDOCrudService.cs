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
    public interface IOrdOpMmDOCrudService
    {
        void delete(OrdOpMmDO[] dos);
        OrdOpMmDO[] insert(OrdOpMmDO[] dos);
        OrdOpMmDO[] save(OrdOpMmDO[] dos);
        OrdOpMmDO[] update(OrdOpMmDO[] dos);
        void logicDelete(OrdOpMmDO[] dos);
        OrdOpMmDO findById(String id);
        OrdOpMmDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdOpMmDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdOpMmDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdOpMmDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdOpMmDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdOpMmDO[] enableWithoutFilter(OrdOpMmDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdOpMmDO[] aggdos) ;
	    OrdOpMmDO[] disableVOWithoutFilter(OrdOpMmDO[] aggdos);
	    DOWithErrLog disableDO(OrdOpMmDO[] aggdos) ;
	    OrdOpMmDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdOpMmDO[] findByAttrValString(String attr, String value);
	    OrdOpMmDO[] findByAttrValStrings(String attr, String[] values);
	    OrdOpMmDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdOpMmDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
