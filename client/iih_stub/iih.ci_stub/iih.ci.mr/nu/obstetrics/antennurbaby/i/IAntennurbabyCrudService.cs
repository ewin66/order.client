using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.antennurbaby.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.antennurbaby.i
{
    public interface IAntennurbabyCrudService
    {
        void delete(AntennurbabyAggDO[] dos);
        AntennurbabyAggDO[] insert(AntennurbabyAggDO[] dos);
        AntennurbabyAggDO[] save(AntennurbabyAggDO[] dos);
        AntennurbabyAggDO[] update(AntennurbabyAggDO[] dos);
        void logicDelete(AntennurbabyAggDO[] dos);
        AntennurbabyAggDO findById(String id);
        AntennurbabyAggDO[] findByIds(String[] ids, FBoolean isLazy);
        AntennurbabyAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        AntennurbabyAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        AntennurbabyAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        AntennurbabyAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<AntennurbabyAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<AntennurbabyAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<AntennurbabyAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(AntNurBabyDO[] mainDos);
		void logicDeleteByParentDO(AntNurBabyDO[] mainDos);
	    AntennurbabyAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AntennurbabyAggDO[] findByAttrValString(String attr, String value);
	    AntennurbabyAggDO[] findByAttrValStrings(String attr, String[] values);
	    AntennurbabyAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}