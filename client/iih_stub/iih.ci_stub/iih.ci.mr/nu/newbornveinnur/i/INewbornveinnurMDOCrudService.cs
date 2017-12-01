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
    public interface INewbornveinnurMDOCrudService
    {
        void delete(NewBornVeinNurDO[] dos);
        NewBornVeinNurDO[] insert(NewBornVeinNurDO[] dos);
        NewBornVeinNurDO[] save(NewBornVeinNurDO[] dos);
        NewBornVeinNurDO[] update(NewBornVeinNurDO[] dos);
        void logicDelete(NewBornVeinNurDO[] dos);
        NewBornVeinNurDO findById(String id);
        NewBornVeinNurDO[] findByIds(String[] ids, FBoolean isLazy);
        NewBornVeinNurDO[] findByBIds(String[] ids, FBoolean isLazy);
        NewBornVeinNurDO[] find(String condition, string orderStr, FBoolean isLazy);
        NewBornVeinNurDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        NewBornVeinNurDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<NewBornVeinNurDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<NewBornVeinNurDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    NewBornVeinNurDO[] enableWithoutFilter(NewBornVeinNurDO[] aggdos) ;
	    DOWithErrLog enableDO(NewBornVeinNurDO[] aggdos) ;
	    NewBornVeinNurDO[] disableVOWithoutFilter(NewBornVeinNurDO[] aggdos);
	    DOWithErrLog disableDO(NewBornVeinNurDO[] aggdos) ;
	    NewBornVeinNurDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    NewBornVeinNurDO[] findByAttrValString(String attr, String value);
	    NewBornVeinNurDO[] findByAttrValStrings(String attr, String[] values);
	    NewBornVeinNurDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<NewBornVeinNurDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
