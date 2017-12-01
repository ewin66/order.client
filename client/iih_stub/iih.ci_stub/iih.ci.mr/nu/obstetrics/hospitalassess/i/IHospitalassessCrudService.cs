using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.hospitalassess.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.hospitalassess.i
{
    public interface IHospitalassessCrudService
    {
        void delete(HospAssessDO[] dos);
        HospAssessDO[] insert(HospAssessDO[] dos);
        HospAssessDO[] save(HospAssessDO[] dos);
        HospAssessDO[] update(HospAssessDO[] dos);
        void logicDelete(HospAssessDO[] dos);
        HospAssessDO findById(String id);
        HospAssessDO[] findByIds(String[] ids, FBoolean isLazy);
        HospAssessDO[] findByBIds(String[] ids, FBoolean isLazy);
        HospAssessDO[] find(String condition, string orderStr, FBoolean isLazy);
        HospAssessDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<HospAssessDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    HospAssessDO[] enableWithoutFilter(HospAssessDO[] dos) ;
	    DOWithErrLog enableDO(HospAssessDO[] dos) ;
	    HospAssessDO[] disableVOWithoutFilter(HospAssessDO[] dos);
	    DOWithErrLog disableDO(HospAssessDO[] dos) ;
	    PagingRtnData<HospAssessDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    HospAssessDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    HospAssessDO[] findByAttrValString(String attr, String value);
	    HospAssessDO[] findByAttrValStrings(String attr, String[] values);
	    HospAssessDO[] findByAttrValList(String attr, FArrayList values);
    }
}
