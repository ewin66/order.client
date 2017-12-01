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
    public interface IAfterdeliverobsecCrudService
    {
        void delete(AfterdeliverobsecAggDO[] dos);
        AfterdeliverobsecAggDO[] insert(AfterdeliverobsecAggDO[] dos);
        AfterdeliverobsecAggDO[] save(AfterdeliverobsecAggDO[] dos);
        AfterdeliverobsecAggDO[] update(AfterdeliverobsecAggDO[] dos);
        void logicDelete(AfterdeliverobsecAggDO[] dos);
        AfterdeliverobsecAggDO findById(String id);
        AfterdeliverobsecAggDO[] findByIds(String[] ids, FBoolean isLazy);
        AfterdeliverobsecAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        AfterdeliverobsecAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        AfterdeliverobsecAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        AfterdeliverobsecAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<AfterdeliverobsecAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<AfterdeliverobsecAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<AfterdeliverobsecAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(AfterDeliveInfoDO[] mainDos);
		void logicDeleteByParentDO(AfterDeliveInfoDO[] mainDos);
	    AfterdeliverobsecAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AfterdeliverobsecAggDO[] findByAttrValString(String attr, String value);
	    AfterdeliverobsecAggDO[] findByAttrValStrings(String attr, String[] values);
	    AfterdeliverobsecAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}