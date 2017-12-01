using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.breathmachnur.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.breathmachnur.i
{
    public interface IBreathmachnurCrudService
    {
        void delete(BreathmachnurAggDO[] dos);
        BreathmachnurAggDO[] insert(BreathmachnurAggDO[] dos);
        BreathmachnurAggDO[] save(BreathmachnurAggDO[] dos);
        BreathmachnurAggDO[] update(BreathmachnurAggDO[] dos);
        void logicDelete(BreathmachnurAggDO[] dos);
        BreathmachnurAggDO findById(String id);
        BreathmachnurAggDO[] findByIds(String[] ids, FBoolean isLazy);
        BreathmachnurAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        BreathmachnurAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        BreathmachnurAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        BreathmachnurAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<BreathmachnurAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<BreathmachnurAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<BreathmachnurAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(BreathMachInfoDO[] mainDos);
		void logicDeleteByParentDO(BreathMachInfoDO[] mainDos);
	    BreathmachnurAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    BreathmachnurAggDO[] findByAttrValString(String attr, String value);
	    BreathmachnurAggDO[] findByAttrValStrings(String attr, String[] values);
	    BreathmachnurAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}