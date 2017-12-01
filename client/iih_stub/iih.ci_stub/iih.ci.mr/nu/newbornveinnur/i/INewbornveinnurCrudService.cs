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
    public interface INewbornveinnurCrudService
    {
        void delete(NewbornveinnurAggDO[] dos);
        NewbornveinnurAggDO[] insert(NewbornveinnurAggDO[] dos);
        NewbornveinnurAggDO[] save(NewbornveinnurAggDO[] dos);
        NewbornveinnurAggDO[] update(NewbornveinnurAggDO[] dos);
        void logicDelete(NewbornveinnurAggDO[] dos);
        NewbornveinnurAggDO findById(String id);
        NewbornveinnurAggDO[] findByIds(String[] ids, FBoolean isLazy);
        NewbornveinnurAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        NewbornveinnurAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        NewbornveinnurAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        NewbornveinnurAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<NewbornveinnurAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<NewbornveinnurAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<NewbornveinnurAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(NewBornVeinNurDO[] mainDos);
		void logicDeleteByParentDO(NewBornVeinNurDO[] mainDos);
	    NewbornveinnurAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    NewbornveinnurAggDO[] findByAttrValString(String attr, String value);
	    NewbornveinnurAggDO[] findByAttrValStrings(String attr, String[] values);
	    NewbornveinnurAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}