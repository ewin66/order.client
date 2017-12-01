using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cior.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cior.i
{
    public interface ICiorappbtCrudService
    {
        void delete(CiorappbtAggDO[] dos);
        CiorappbtAggDO[] insert(CiorappbtAggDO[] dos);
        CiorappbtAggDO[] save(CiorappbtAggDO[] dos);
        CiorappbtAggDO[] update(CiorappbtAggDO[] dos);
        void logicDelete(CiorappbtAggDO[] dos);
        CiorappbtAggDO findById(String id);
        CiorappbtAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiorappbtAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiorappbtAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiorappbtAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiorappbtAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiorappbtAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(OrdApBtDO[] mainDos);
		void logicDeleteByParentDO(OrdApBtDO[] mainDos);
	    CiorappbtAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiorappbtAggDO[] findByAttrValString(String attr, String value);
	    CiorappbtAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiorappbtAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
