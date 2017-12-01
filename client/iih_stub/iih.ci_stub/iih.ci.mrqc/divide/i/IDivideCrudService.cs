using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.divide.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.divide.i
{
    public interface IDivideCrudService
    {
        void delete(DivideDO[] dos);
        DivideDO[] insert(DivideDO[] dos);
        DivideDO[] save(DivideDO[] dos);
        DivideDO[] update(DivideDO[] dos);
        void logicDelete(DivideDO[] dos);
        DivideDO findById(String id);
        DivideDO[] findByIds(String[] ids, FBoolean isLazy);
        DivideDO[] findByBIds(String[] ids, FBoolean isLazy);
        DivideDO[] find(String condition, string orderStr, FBoolean isLazy);
        DivideDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        DivideDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<DivideDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<DivideDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    DivideDO[] enableWithoutFilter(DivideDO[] dos) ;
	    DOWithErrLog enableDO(DivideDO[] dos) ;
	    DivideDO[] disableVOWithoutFilter(DivideDO[] dos);
	    DOWithErrLog disableDO(DivideDO[] dos) ;
	    PagingRtnData<DivideDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    DivideDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    DivideDO[] findByAttrValString(String attr, String value);
	    DivideDO[] findByAttrValStrings(String attr, String[] values);
	    DivideDO[] findByAttrValList(String attr, FArrayList values);
    }
}