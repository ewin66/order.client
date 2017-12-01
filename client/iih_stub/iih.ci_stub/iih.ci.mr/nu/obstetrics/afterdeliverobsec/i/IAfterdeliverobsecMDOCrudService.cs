using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.afterdeliverobsec.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.afterdeliverobsec.i
{
    public interface IAfterdeliverobsecMDOCrudService
    {
        void delete(AfterDeliveInfoDO[] dos);
        AfterDeliveInfoDO[] insert(AfterDeliveInfoDO[] dos);
        AfterDeliveInfoDO[] save(AfterDeliveInfoDO[] dos);
        AfterDeliveInfoDO[] update(AfterDeliveInfoDO[] dos);
        void logicDelete(AfterDeliveInfoDO[] dos);
        AfterDeliveInfoDO findById(String id);
        AfterDeliveInfoDO[] findByIds(String[] ids, FBoolean isLazy);
        AfterDeliveInfoDO[] findByBIds(String[] ids, FBoolean isLazy);
        AfterDeliveInfoDO[] find(String condition, string orderStr, FBoolean isLazy);
        AfterDeliveInfoDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        AfterDeliveInfoDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AfterDeliveInfoDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<AfterDeliveInfoDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    AfterDeliveInfoDO[] enableWithoutFilter(AfterDeliveInfoDO[] aggdos) ;
	    DOWithErrLog enableDO(AfterDeliveInfoDO[] aggdos) ;
	    AfterDeliveInfoDO[] disableVOWithoutFilter(AfterDeliveInfoDO[] aggdos);
	    DOWithErrLog disableDO(AfterDeliveInfoDO[] aggdos) ;
	    AfterDeliveInfoDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AfterDeliveInfoDO[] findByAttrValString(String attr, String value);
	    AfterDeliveInfoDO[] findByAttrValStrings(String attr, String[] values);
	    AfterDeliveInfoDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<AfterDeliveInfoDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
