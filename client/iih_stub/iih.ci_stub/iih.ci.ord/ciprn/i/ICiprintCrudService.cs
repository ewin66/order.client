using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciprn.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciprn.i
{
    public interface ICiprintCrudService
    {
        void delete(CiprintAggDO[] dos);
        CiprintAggDO[] insert(CiprintAggDO[] dos);
        CiprintAggDO[] save(CiprintAggDO[] dos);
        CiprintAggDO[] update(CiprintAggDO[] dos);
        void logicDelete(CiprintAggDO[] dos);
        CiprintAggDO findById(String id);
        CiprintAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiprintAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiprintAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiprintAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiprintAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiprintAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiprintAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<CiprintAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(CiPrnDO[] mainDos);
		void logicDeleteByParentDO(CiPrnDO[] mainDos);
	    CiprintAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiprintAggDO[] findByAttrValString(String attr, String value);
	    CiprintAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiprintAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}