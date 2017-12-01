using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.newbornveinnur.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.newbornveinnur.i
{
    public interface INewBornVeinNurRecordDOCrudService
    {
        void delete(NewBornVeinNurRecordDO[] dos);
        NewBornVeinNurRecordDO[] insert(NewBornVeinNurRecordDO[] dos);
        NewBornVeinNurRecordDO[] save(NewBornVeinNurRecordDO[] dos);
        NewBornVeinNurRecordDO[] update(NewBornVeinNurRecordDO[] dos);
        void logicDelete(NewBornVeinNurRecordDO[] dos);
        NewBornVeinNurRecordDO findById(String id);
        NewBornVeinNurRecordDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        NewBornVeinNurRecordDO[] findByIds(String[] ids, FBoolean isLazy);
        NewBornVeinNurRecordDO[] findByBIds(String[] ids, FBoolean isLazy);
        NewBornVeinNurRecordDO[] find(String condition, string orderStr, FBoolean isLazy);
        NewBornVeinNurRecordDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<NewBornVeinNurRecordDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<NewBornVeinNurRecordDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    NewBornVeinNurRecordDO[] enableWithoutFilter(NewBornVeinNurRecordDO[] aggdos) ;
	    DOWithErrLog enableDO(NewBornVeinNurRecordDO[] aggdos) ;
	    NewBornVeinNurRecordDO[] disableVOWithoutFilter(NewBornVeinNurRecordDO[] aggdos);
	    DOWithErrLog disableDO(NewBornVeinNurRecordDO[] aggdos) ;
	    NewBornVeinNurRecordDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    NewBornVeinNurRecordDO[] findByAttrValString(String attr, String value);
	    NewBornVeinNurRecordDO[] findByAttrValStrings(String attr, String[] values);
	    NewBornVeinNurRecordDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<NewBornVeinNurRecordDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
