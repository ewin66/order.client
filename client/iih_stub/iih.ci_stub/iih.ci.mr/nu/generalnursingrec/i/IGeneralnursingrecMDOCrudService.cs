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
    public interface IGeneralnursingrecMDOCrudService
    {
        void delete(GeneralNursingDO[] dos);
        GeneralNursingDO[] insert(GeneralNursingDO[] dos);
        GeneralNursingDO[] save(GeneralNursingDO[] dos);
        GeneralNursingDO[] update(GeneralNursingDO[] dos);
        void logicDelete(GeneralNursingDO[] dos);
        GeneralNursingDO findById(String id);
        GeneralNursingDO[] findByIds(String[] ids, FBoolean isLazy);
        GeneralNursingDO[] findByBIds(String[] ids, FBoolean isLazy);
        GeneralNursingDO[] find(String condition, string orderStr, FBoolean isLazy);
        GeneralNursingDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        GeneralNursingDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<GeneralNursingDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<GeneralNursingDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    GeneralNursingDO[] enableWithoutFilter(GeneralNursingDO[] aggdos) ;
	    DOWithErrLog enableDO(GeneralNursingDO[] aggdos) ;
	    GeneralNursingDO[] disableVOWithoutFilter(GeneralNursingDO[] aggdos);
	    DOWithErrLog disableDO(GeneralNursingDO[] aggdos) ;
	    GeneralNursingDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    GeneralNursingDO[] findByAttrValString(String attr, String value);
	    GeneralNursingDO[] findByAttrValStrings(String attr, String[] values);
	    GeneralNursingDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<GeneralNursingDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
