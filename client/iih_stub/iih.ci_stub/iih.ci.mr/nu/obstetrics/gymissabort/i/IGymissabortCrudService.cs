using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.gymissabort.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.gymissabort.i
{
    public interface IGymissabortCrudService
    {
        void delete(GymissabortAggDO[] dos);
        GymissabortAggDO[] insert(GymissabortAggDO[] dos);
        GymissabortAggDO[] save(GymissabortAggDO[] dos);
        GymissabortAggDO[] update(GymissabortAggDO[] dos);
        void logicDelete(GymissabortAggDO[] dos);
        GymissabortAggDO findById(String id);
        GymissabortAggDO[] findByIds(String[] ids, FBoolean isLazy);
        GymissabortAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        GymissabortAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        GymissabortAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        GymissabortAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<GymissabortAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<GymissabortAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<GymissabortAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(GyMissAbortAssDO[] mainDos);
		void logicDeleteByParentDO(GyMissAbortAssDO[] mainDos);
	    GymissabortAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    GymissabortAggDO[] findByAttrValString(String attr, String value);
	    GymissabortAggDO[] findByAttrValStrings(String attr, String[] values);
	    GymissabortAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}