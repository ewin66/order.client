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
    public interface ICiordrptbttestCrudService
    {
        void delete(CiordrptbttestAggDO[] dos);
        CiordrptbttestAggDO[] insert(CiordrptbttestAggDO[] dos);
        CiordrptbttestAggDO[] save(CiordrptbttestAggDO[] dos);
        CiordrptbttestAggDO[] update(CiordrptbttestAggDO[] dos);
        void logicDelete(CiordrptbttestAggDO[] dos);
        CiordrptbttestAggDO findById(String id);
        CiordrptbttestAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiordrptbttestAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiordrptbttestAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiordrptbttestAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiordrptbttestAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiordrptbttestAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy); 
	    CiordrptbttestAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiordrptbttestAggDO[] findByAttrValString(String attr, String value);
	    CiordrptbttestAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiordrptbttestAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
