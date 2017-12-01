using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cirptlab.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cirptlab.i
{
    public interface ICirptlabCrudService
    {
        void delete(CirptlabAggDO[] dos);
        CirptlabAggDO[] insert(CirptlabAggDO[] dos);
        CirptlabAggDO[] save(CirptlabAggDO[] dos);
        CirptlabAggDO[] update(CirptlabAggDO[] dos);
        void logicDelete(CirptlabAggDO[] dos);
        CirptlabAggDO findById(String id);
        CirptlabAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CirptlabAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CirptlabAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CirptlabAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CirptlabAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CirptlabAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy); 
	    CirptlabAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CirptlabAggDO[] findByAttrValString(String attr, String value);
	    CirptlabAggDO[] findByAttrValStrings(String attr, String[] values);
	    CirptlabAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
