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
    public interface INewbabypiccCrudService
    {
        void delete(NewbabypiccAggDO[] dos);
        NewbabypiccAggDO[] insert(NewbabypiccAggDO[] dos);
        NewbabypiccAggDO[] save(NewbabypiccAggDO[] dos);
        NewbabypiccAggDO[] update(NewbabypiccAggDO[] dos);
        void logicDelete(NewbabypiccAggDO[] dos);
        NewbabypiccAggDO findById(String id);
        NewbabypiccAggDO[] findByIds(String[] ids, FBoolean isLazy);
        NewbabypiccAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        NewbabypiccAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        NewbabypiccAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        NewbabypiccAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<NewbabypiccAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<NewbabypiccAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<NewbabypiccAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(NewBabyPiccDO[] mainDos);
		void logicDeleteByParentDO(NewBabyPiccDO[] mainDos);
	    NewbabypiccAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    NewbabypiccAggDO[] findByAttrValString(String attr, String value);
	    NewbabypiccAggDO[] findByAttrValStrings(String attr, String[] values);
	    NewbabypiccAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}