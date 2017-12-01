using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.diag.cidiag.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.diag.cidiag.i
{
    public interface ICidiagCrudService
    {
        void delete(CidiagAggDO[] dos);
        CidiagAggDO[] insert(CidiagAggDO[] dos);
        CidiagAggDO[] save(CidiagAggDO[] dos);
        CidiagAggDO[] update(CidiagAggDO[] dos);
        void logicDelete(CidiagAggDO[] dos);
        CidiagAggDO findById(String id);
        CidiagAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CidiagAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CidiagAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CidiagAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CidiagAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CidiagAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(CiDiagDO[] mainDos);
		void logicDeleteByParentDO(CiDiagDO[] mainDos);
	    CidiagAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CidiagAggDO[] findByAttrValString(String attr, String value);
	    CidiagAggDO[] findByAttrValStrings(String attr, String[] values);
	    CidiagAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
