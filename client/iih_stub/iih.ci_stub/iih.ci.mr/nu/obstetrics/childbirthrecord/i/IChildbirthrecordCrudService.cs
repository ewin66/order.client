using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.childbirthrecord.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.childbirthrecord.i
{
    public interface IChildbirthrecordCrudService
    {
        void delete(ChildBirthRecordDO[] dos);
        ChildBirthRecordDO[] insert(ChildBirthRecordDO[] dos);
        ChildBirthRecordDO[] save(ChildBirthRecordDO[] dos);
        ChildBirthRecordDO[] update(ChildBirthRecordDO[] dos);
        void logicDelete(ChildBirthRecordDO[] dos);
        ChildBirthRecordDO findById(String id);
        ChildBirthRecordDO[] findByIds(String[] ids, FBoolean isLazy);
        ChildBirthRecordDO[] findByBIds(String[] ids, FBoolean isLazy);
        ChildBirthRecordDO[] find(String condition, string orderStr, FBoolean isLazy);
        ChildBirthRecordDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        ChildBirthRecordDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<ChildBirthRecordDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<ChildBirthRecordDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    ChildBirthRecordDO[] enableWithoutFilter(ChildBirthRecordDO[] dos) ;
	    DOWithErrLog enableDO(ChildBirthRecordDO[] dos) ;
	    ChildBirthRecordDO[] disableVOWithoutFilter(ChildBirthRecordDO[] dos);
	    DOWithErrLog disableDO(ChildBirthRecordDO[] dos) ;
	    PagingRtnData<ChildBirthRecordDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    ChildBirthRecordDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ChildBirthRecordDO[] findByAttrValString(String attr, String value);
	    ChildBirthRecordDO[] findByAttrValStrings(String attr, String[] values);
	    ChildBirthRecordDO[] findByAttrValList(String attr, FArrayList values);
    }
}