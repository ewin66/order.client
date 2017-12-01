using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.birthregis.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.birthregis.i
{
    public interface IBirthregisCrudService
    {
        void delete(BirthRegistrationDO[] dos);
        BirthRegistrationDO[] insert(BirthRegistrationDO[] dos);
        BirthRegistrationDO[] save(BirthRegistrationDO[] dos);
        BirthRegistrationDO[] update(BirthRegistrationDO[] dos);
        void logicDelete(BirthRegistrationDO[] dos);
        BirthRegistrationDO findById(String id);
        BirthRegistrationDO[] findByIds(String[] ids, FBoolean isLazy);
        BirthRegistrationDO[] findByBIds(String[] ids, FBoolean isLazy);
        BirthRegistrationDO[] find(String condition, string orderStr, FBoolean isLazy);
        BirthRegistrationDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        BirthRegistrationDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<BirthRegistrationDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<BirthRegistrationDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    BirthRegistrationDO[] enableWithoutFilter(BirthRegistrationDO[] dos) ;
	    DOWithErrLog enableDO(BirthRegistrationDO[] dos) ;
	    BirthRegistrationDO[] disableVOWithoutFilter(BirthRegistrationDO[] dos);
	    DOWithErrLog disableDO(BirthRegistrationDO[] dos) ;
	    PagingRtnData<BirthRegistrationDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    BirthRegistrationDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    BirthRegistrationDO[] findByAttrValString(String attr, String value);
	    BirthRegistrationDO[] findByAttrValStrings(String attr, String[] values);
	    BirthRegistrationDO[] findByAttrValList(String attr, FArrayList values);
    }
}