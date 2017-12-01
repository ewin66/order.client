using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.generalnursingrec.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.generalnursingrec.i
{
    public interface IGeneralnursingrecCrudService
    {
        void delete(GeneralnursingrecAggDO[] dos);
        GeneralnursingrecAggDO[] insert(GeneralnursingrecAggDO[] dos);
        GeneralnursingrecAggDO[] save(GeneralnursingrecAggDO[] dos);
        GeneralnursingrecAggDO[] update(GeneralnursingrecAggDO[] dos);
        void logicDelete(GeneralnursingrecAggDO[] dos);
        GeneralnursingrecAggDO findById(String id);
        GeneralnursingrecAggDO[] findByIds(String[] ids, FBoolean isLazy);
        GeneralnursingrecAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        GeneralnursingrecAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        GeneralnursingrecAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        GeneralnursingrecAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<GeneralnursingrecAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<GeneralnursingrecAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<GeneralnursingrecAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(GeneralNursingDO[] mainDos);
		void logicDeleteByParentDO(GeneralNursingDO[] mainDos);
	    GeneralnursingrecAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    GeneralnursingrecAggDO[] findByAttrValString(String attr, String value);
	    GeneralnursingrecAggDO[] findByAttrValStrings(String attr, String[] values);
	    GeneralnursingrecAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}