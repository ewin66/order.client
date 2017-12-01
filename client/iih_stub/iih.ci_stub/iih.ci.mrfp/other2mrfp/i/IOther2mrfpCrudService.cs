using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrfp.other2mrfp.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrfp.other2mrfp.i
{
    public interface IOther2mrfpCrudService
    {
        void delete(Other2mrfpAggDO[] dos);
        Other2mrfpAggDO[] insert(Other2mrfpAggDO[] dos);
        Other2mrfpAggDO[] save(Other2mrfpAggDO[] dos);
        Other2mrfpAggDO[] update(Other2mrfpAggDO[] dos);
        void logicDelete(Other2mrfpAggDO[] dos);
        Other2mrfpAggDO findById(String id);
        Other2mrfpAggDO[] findByIds(String[] ids, FBoolean isLazy);
        Other2mrfpAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        Other2mrfpAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        Other2mrfpAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<Other2mrfpAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<Other2mrfpAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy); 
	    Other2mrfpAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    Other2mrfpAggDO[] findByAttrValString(String attr, String value);
	    Other2mrfpAggDO[] findByAttrValStrings(String attr, String[] values);
	    Other2mrfpAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
