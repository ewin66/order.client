using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.cimrvt.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.cimrvt.i
{
    public interface ICimrvtCrudService
    {
        void delete(CimrvtAggDO[] dos);
        CimrvtAggDO[] insert(CimrvtAggDO[] dos);
        CimrvtAggDO[] save(CimrvtAggDO[] dos);
        CimrvtAggDO[] update(CimrvtAggDO[] dos);
        void logicDelete(CimrvtAggDO[] dos);
        CimrvtAggDO findById(String id);
        CimrvtAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CimrvtAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CimrvtAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CimrvtAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CimrvtAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CimrvtAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy); 
	    CimrvtAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CimrvtAggDO[] findByAttrValString(String attr, String value);
	    CimrvtAggDO[] findByAttrValStrings(String attr, String[] values);
	    CimrvtAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
