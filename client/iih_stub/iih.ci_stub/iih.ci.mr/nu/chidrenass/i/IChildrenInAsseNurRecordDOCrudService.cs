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
    public interface IChildrenInAsseNurRecordDOCrudService
    {
        void delete(ChildrenInAsseNurRecordDO[] dos);
        ChildrenInAsseNurRecordDO[] insert(ChildrenInAsseNurRecordDO[] dos);
        ChildrenInAsseNurRecordDO[] save(ChildrenInAsseNurRecordDO[] dos);
        ChildrenInAsseNurRecordDO[] update(ChildrenInAsseNurRecordDO[] dos);
        void logicDelete(ChildrenInAsseNurRecordDO[] dos);
        ChildrenInAsseNurRecordDO findById(String id);
        ChildrenInAsseNurRecordDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        ChildrenInAsseNurRecordDO[] findByIds(String[] ids, FBoolean isLazy);
        ChildrenInAsseNurRecordDO[] findByBIds(String[] ids, FBoolean isLazy);
        ChildrenInAsseNurRecordDO[] find(String condition, string orderStr, FBoolean isLazy);
        ChildrenInAsseNurRecordDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<ChildrenInAsseNurRecordDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<ChildrenInAsseNurRecordDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    ChildrenInAsseNurRecordDO[] enableWithoutFilter(ChildrenInAsseNurRecordDO[] aggdos) ;
	    DOWithErrLog enableDO(ChildrenInAsseNurRecordDO[] aggdos) ;
	    ChildrenInAsseNurRecordDO[] disableVOWithoutFilter(ChildrenInAsseNurRecordDO[] aggdos);
	    DOWithErrLog disableDO(ChildrenInAsseNurRecordDO[] aggdos) ;
	    ChildrenInAsseNurRecordDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ChildrenInAsseNurRecordDO[] findByAttrValString(String attr, String value);
	    ChildrenInAsseNurRecordDO[] findByAttrValStrings(String attr, String[] values);
	    ChildrenInAsseNurRecordDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<ChildrenInAsseNurRecordDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
