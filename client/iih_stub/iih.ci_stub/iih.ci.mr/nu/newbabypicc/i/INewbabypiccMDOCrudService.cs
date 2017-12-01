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
    public interface INewbabypiccMDOCrudService
    {
        void delete(NewBabyPiccDO[] dos);
        NewBabyPiccDO[] insert(NewBabyPiccDO[] dos);
        NewBabyPiccDO[] save(NewBabyPiccDO[] dos);
        NewBabyPiccDO[] update(NewBabyPiccDO[] dos);
        void logicDelete(NewBabyPiccDO[] dos);
        NewBabyPiccDO findById(String id);
        NewBabyPiccDO[] findByIds(String[] ids, FBoolean isLazy);
        NewBabyPiccDO[] findByBIds(String[] ids, FBoolean isLazy);
        NewBabyPiccDO[] find(String condition, string orderStr, FBoolean isLazy);
        NewBabyPiccDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        NewBabyPiccDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<NewBabyPiccDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<NewBabyPiccDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    NewBabyPiccDO[] enableWithoutFilter(NewBabyPiccDO[] aggdos) ;
	    DOWithErrLog enableDO(NewBabyPiccDO[] aggdos) ;
	    NewBabyPiccDO[] disableVOWithoutFilter(NewBabyPiccDO[] aggdos);
	    DOWithErrLog disableDO(NewBabyPiccDO[] aggdos) ;
	    NewBabyPiccDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    NewBabyPiccDO[] findByAttrValString(String attr, String value);
	    NewBabyPiccDO[] findByAttrValStrings(String attr, String[] values);
	    NewBabyPiccDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<NewBabyPiccDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
