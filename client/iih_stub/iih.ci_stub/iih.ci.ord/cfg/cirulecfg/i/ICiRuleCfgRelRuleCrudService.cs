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
    public interface ICiRuleCfgRelRuleCrudService
    {
        void delete(CiRuleCfgRelRule[] dos);
        CiRuleCfgRelRule[] insert(CiRuleCfgRelRule[] dos);
        CiRuleCfgRelRule[] save(CiRuleCfgRelRule[] dos);
        CiRuleCfgRelRule[] update(CiRuleCfgRelRule[] dos);
        void logicDelete(CiRuleCfgRelRule[] dos);
        CiRuleCfgRelRule findById(String id);
        CiRuleCfgRelRule[] findByIds(String[] ids, FBoolean isLazy);
        CiRuleCfgRelRule[] findByBIds(String[] ids, FBoolean isLazy);
        CiRuleCfgRelRule[] find(String condition, string orderStr, FBoolean isLazy);
        CiRuleCfgRelRule[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiRuleCfgRelRule> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiRuleCfgRelRule[] enableWithoutFilter(CiRuleCfgRelRule[] aggdos) ;
	    DOWithErrLog enableDO(CiRuleCfgRelRule[] aggdos) ;
	    CiRuleCfgRelRule[] disableVOWithoutFilter(CiRuleCfgRelRule[] aggdos);
	    DOWithErrLog disableDO(CiRuleCfgRelRule[] aggdos) ;
	    CiRuleCfgRelRule[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiRuleCfgRelRule[] findByAttrValString(String attr, String value);
	    CiRuleCfgRelRule[] findByAttrValStrings(String attr, String[] values);
	    CiRuleCfgRelRule[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiRuleCfgRelRule> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}