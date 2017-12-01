using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.contagion.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.contagion.i
{
    public interface IContagionCrudService
    {
        void delete(ContagionAggDO[] dos);
        ContagionAggDO[] insert(ContagionAggDO[] dos);
        ContagionAggDO[] save(ContagionAggDO[] dos);
        ContagionAggDO[] update(ContagionAggDO[] dos);
        void logicDelete(ContagionAggDO[] dos);
        ContagionAggDO findById(String id);
        ContagionAggDO[] findByIds(String[] ids, FBoolean isLazy);
        ContagionAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        ContagionAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        ContagionAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<ContagionAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<ContagionAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(ContagionDO[] mainDos);
		void logicDeleteByParentDO(ContagionDO[] mainDos);
	    ContagionAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ContagionAggDO[] findByAttrValString(String attr, String value);
	    ContagionAggDO[] findByAttrValStrings(String attr, String[] values);
	    ContagionAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}