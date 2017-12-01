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
    public interface ICiorappbtMDOCrudService
    {
        void delete(OrdApBtDO[] dos);
        OrdApBtDO[] insert(OrdApBtDO[] dos);
        OrdApBtDO[] save(OrdApBtDO[] dos);
        OrdApBtDO[] update(OrdApBtDO[] dos);
        void logicDelete(OrdApBtDO[] dos);
        OrdApBtDO findById(String id);
        OrdApBtDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdApBtDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdApBtDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdApBtDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdApBtDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdApBtDO[] enableWithoutFilter(OrdApBtDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdApBtDO[] aggdos) ;
	    OrdApBtDO[] disableVOWithoutFilter(OrdApBtDO[] aggdos);
	    DOWithErrLog disableDO(OrdApBtDO[] aggdos) ;
	    OrdApBtDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdApBtDO[] findByAttrValString(String attr, String value);
	    OrdApBtDO[] findByAttrValStrings(String attr, String[] values);
	    OrdApBtDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdApBtDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
