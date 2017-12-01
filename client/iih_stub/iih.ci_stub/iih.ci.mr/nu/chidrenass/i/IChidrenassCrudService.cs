using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.chidrenass.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.chidrenass.i
{
    public interface IChidrenassCrudService
    {
        void delete(ChidrenassAggDO[] dos);
        ChidrenassAggDO[] insert(ChidrenassAggDO[] dos);
        ChidrenassAggDO[] save(ChidrenassAggDO[] dos);
        ChidrenassAggDO[] update(ChidrenassAggDO[] dos);
        void logicDelete(ChidrenassAggDO[] dos);
        ChidrenassAggDO findById(String id);
        ChidrenassAggDO[] findByIds(String[] ids, FBoolean isLazy);
        ChidrenassAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        ChidrenassAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        ChidrenassAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        ChidrenassAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<ChidrenassAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<ChidrenassAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<ChidrenassAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(ChildrenInAsseDO[] mainDos);
		void logicDeleteByParentDO(ChildrenInAsseDO[] mainDos);
	    ChidrenassAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ChidrenassAggDO[] findByAttrValString(String attr, String value);
	    ChidrenassAggDO[] findByAttrValStrings(String attr, String[] values);
	    ChidrenassAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}