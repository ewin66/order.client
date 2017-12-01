using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.per.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.per.i
{
    public interface IPerCrudService
    {
        void delete(PerAggDO[] dos);
        PerAggDO[] insert(PerAggDO[] dos);
        PerAggDO[] save(PerAggDO[] dos);
        PerAggDO[] update(PerAggDO[] dos);
        void logicDelete(PerAggDO[] dos);
        PerAggDO findById(String id);
        PerAggDO[] findByIds(String[] ids, FBoolean isLazy);
        PerAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        PerAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        PerAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<PerAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<PerAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(PerDO[] mainDos);
		void logicDeleteByParentDO(PerDO[] mainDos);
	    PerAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    PerAggDO[] findByAttrValString(String attr, String value);
	    PerAggDO[] findByAttrValStrings(String attr, String[] values);
	    PerAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
