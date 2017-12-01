using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.adhgeneralnursing.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.adhgeneralnursing.i
{
    public interface IAdhgeneralnursingCrudService
    {
        void delete(AdhgeneralnursingAggDO[] dos);
        AdhgeneralnursingAggDO[] insert(AdhgeneralnursingAggDO[] dos);
        AdhgeneralnursingAggDO[] save(AdhgeneralnursingAggDO[] dos);
        AdhgeneralnursingAggDO[] update(AdhgeneralnursingAggDO[] dos);
        void logicDelete(AdhgeneralnursingAggDO[] dos);
        AdhgeneralnursingAggDO findById(String id);
        AdhgeneralnursingAggDO[] findByIds(String[] ids, FBoolean isLazy);
        AdhgeneralnursingAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        AdhgeneralnursingAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        AdhgeneralnursingAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        AdhgeneralnursingAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<AdhgeneralnursingAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<AdhgeneralnursingAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<AdhgeneralnursingAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(AdhNursingDO[] mainDos);
		void logicDeleteByParentDO(AdhNursingDO[] mainDos);
	    AdhgeneralnursingAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AdhgeneralnursingAggDO[] findByAttrValString(String attr, String value);
	    AdhgeneralnursingAggDO[] findByAttrValStrings(String attr, String[] values);
	    AdhgeneralnursingAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}