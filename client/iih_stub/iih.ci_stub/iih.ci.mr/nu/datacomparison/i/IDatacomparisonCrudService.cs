using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.datacomparison.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.datacomparison.i
{
    public interface IDatacomparisonCrudService
    {
        void delete(DataComparisonDO[] dos);
        DataComparisonDO[] insert(DataComparisonDO[] dos);
        DataComparisonDO[] save(DataComparisonDO[] dos);
        DataComparisonDO[] update(DataComparisonDO[] dos);
        void logicDelete(DataComparisonDO[] dos);
        DataComparisonDO findById(String id);
        DataComparisonDO[] findByIds(String[] ids, FBoolean isLazy);
        DataComparisonDO[] findByBIds(String[] ids, FBoolean isLazy);
        DataComparisonDO[] find(String condition, string orderStr, FBoolean isLazy);
        DataComparisonDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        DataComparisonDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<DataComparisonDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<DataComparisonDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    DataComparisonDO[] enableWithoutFilter(DataComparisonDO[] dos) ;
	    DOWithErrLog enableDO(DataComparisonDO[] dos) ;
	    DataComparisonDO[] disableVOWithoutFilter(DataComparisonDO[] dos);
	    DOWithErrLog disableDO(DataComparisonDO[] dos) ;
	    PagingRtnData<DataComparisonDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    DataComparisonDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    DataComparisonDO[] findByAttrValString(String attr, String value);
	    DataComparisonDO[] findByAttrValStrings(String attr, String[] values);
	    DataComparisonDO[] findByAttrValList(String attr, FArrayList values);
    }
}