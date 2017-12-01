using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cfg.cirulecfg.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cfg.cirulecfg.i
{
    public interface IRuleentityCrudService
    {
        void delete(CiRuleEntity[] dos);
        CiRuleEntity[] insert(CiRuleEntity[] dos);
        CiRuleEntity[] save(CiRuleEntity[] dos);
        CiRuleEntity[] update(CiRuleEntity[] dos);
        void logicDelete(CiRuleEntity[] dos);
        CiRuleEntity findById(String id);
        CiRuleEntity[] findByIds(String[] ids, FBoolean isLazy);
        CiRuleEntity[] findByBIds(String[] ids, FBoolean isLazy);
        CiRuleEntity[] find(String condition, string orderStr, FBoolean isLazy);
        CiRuleEntity[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiRuleEntity> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiRuleEntity[] enableWithoutFilter(CiRuleEntity[] dos) ;
	    DOWithErrLog enableDO(CiRuleEntity[] dos) ;
	    CiRuleEntity[] disableVOWithoutFilter(CiRuleEntity[] dos);
	    DOWithErrLog disableDO(CiRuleEntity[] dos) ;
	    PagingRtnData<CiRuleEntity> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiRuleEntity[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiRuleEntity[] findByAttrValString(String attr, String value);
	    CiRuleEntity[] findByAttrValStrings(String attr, String[] values);
	    CiRuleEntity[] findByAttrValList(String attr, FArrayList values);
    }
}