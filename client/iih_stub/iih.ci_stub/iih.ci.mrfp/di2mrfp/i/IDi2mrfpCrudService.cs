using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrfp.di2mrfp.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrfp.di2mrfp.i
{
    public interface IDi2mrfpCrudService
    {
        void delete(Di2mrfpAggDO[] dos);
        Di2mrfpAggDO[] insert(Di2mrfpAggDO[] dos);
        Di2mrfpAggDO[] save(Di2mrfpAggDO[] dos);
        Di2mrfpAggDO[] update(Di2mrfpAggDO[] dos);
        void logicDelete(Di2mrfpAggDO[] dos);
        Di2mrfpAggDO findById(String id);
        Di2mrfpAggDO[] findByIds(String[] ids, FBoolean isLazy);
        Di2mrfpAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        Di2mrfpAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        Di2mrfpAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<Di2mrfpAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<Di2mrfpAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy); 
	    Di2mrfpAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    Di2mrfpAggDO[] findByAttrValString(String attr, String value);
	    Di2mrfpAggDO[] findByAttrValStrings(String attr, String[] values);
	    Di2mrfpAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
