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
    public interface IOrdrptopCrudService
    {
        void delete(OrdrptopAggDO[] dos);
        OrdrptopAggDO[] insert(OrdrptopAggDO[] dos);
        OrdrptopAggDO[] save(OrdrptopAggDO[] dos);
        OrdrptopAggDO[] update(OrdrptopAggDO[] dos);
        void logicDelete(OrdrptopAggDO[] dos);
        OrdrptopAggDO findById(String id);
        OrdrptopAggDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdrptopAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdrptopAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdrptopAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<OrdrptopAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<OrdrptopAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy); 
	    OrdrptopAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdrptopAggDO[] findByAttrValString(String attr, String value);
	    OrdrptopAggDO[] findByAttrValStrings(String attr, String[] values);
	    OrdrptopAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
