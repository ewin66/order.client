using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.newbabypicc.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.newbabypicc.i
{
    public interface INewBabyPiccRecDOCrudService
    {
        void delete(NewBabyPiccRecDO[] dos);
        NewBabyPiccRecDO[] insert(NewBabyPiccRecDO[] dos);
        NewBabyPiccRecDO[] save(NewBabyPiccRecDO[] dos);
        NewBabyPiccRecDO[] update(NewBabyPiccRecDO[] dos);
        void logicDelete(NewBabyPiccRecDO[] dos);
        NewBabyPiccRecDO findById(String id);
        NewBabyPiccRecDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        NewBabyPiccRecDO[] findByIds(String[] ids, FBoolean isLazy);
        NewBabyPiccRecDO[] findByBIds(String[] ids, FBoolean isLazy);
        NewBabyPiccRecDO[] find(String condition, string orderStr, FBoolean isLazy);
        NewBabyPiccRecDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<NewBabyPiccRecDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<NewBabyPiccRecDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    NewBabyPiccRecDO[] enableWithoutFilter(NewBabyPiccRecDO[] aggdos) ;
	    DOWithErrLog enableDO(NewBabyPiccRecDO[] aggdos) ;
	    NewBabyPiccRecDO[] disableVOWithoutFilter(NewBabyPiccRecDO[] aggdos);
	    DOWithErrLog disableDO(NewBabyPiccRecDO[] aggdos) ;
	    NewBabyPiccRecDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    NewBabyPiccRecDO[] findByAttrValString(String attr, String value);
	    NewBabyPiccRecDO[] findByAttrValStrings(String attr, String[] values);
	    NewBabyPiccRecDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<NewBabyPiccRecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
