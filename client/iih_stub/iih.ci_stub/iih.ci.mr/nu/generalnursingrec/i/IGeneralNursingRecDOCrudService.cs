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
    public interface IGeneralNursingRecDOCrudService
    {
        void delete(GeneralNursingRecDO[] dos);
        GeneralNursingRecDO[] insert(GeneralNursingRecDO[] dos);
        GeneralNursingRecDO[] save(GeneralNursingRecDO[] dos);
        GeneralNursingRecDO[] update(GeneralNursingRecDO[] dos);
        void logicDelete(GeneralNursingRecDO[] dos);
        GeneralNursingRecDO findById(String id);
        GeneralNursingRecDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        GeneralNursingRecDO[] findByIds(String[] ids, FBoolean isLazy);
        GeneralNursingRecDO[] findByBIds(String[] ids, FBoolean isLazy);
        GeneralNursingRecDO[] find(String condition, string orderStr, FBoolean isLazy);
        GeneralNursingRecDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<GeneralNursingRecDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<GeneralNursingRecDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    GeneralNursingRecDO[] enableWithoutFilter(GeneralNursingRecDO[] aggdos) ;
	    DOWithErrLog enableDO(GeneralNursingRecDO[] aggdos) ;
	    GeneralNursingRecDO[] disableVOWithoutFilter(GeneralNursingRecDO[] aggdos);
	    DOWithErrLog disableDO(GeneralNursingRecDO[] aggdos) ;
	    GeneralNursingRecDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    GeneralNursingRecDO[] findByAttrValString(String attr, String value);
	    GeneralNursingRecDO[] findByAttrValStrings(String attr, String[] values);
	    GeneralNursingRecDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<GeneralNursingRecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
