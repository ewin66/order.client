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
    public interface ICirulecfgMDOCrudService
    {
        void delete(CiRuleCfg[] dos);
        CiRuleCfg[] insert(CiRuleCfg[] dos);
        CiRuleCfg[] save(CiRuleCfg[] dos);
        CiRuleCfg[] update(CiRuleCfg[] dos);
        void logicDelete(CiRuleCfg[] dos);
        CiRuleCfg findById(String id);
        CiRuleCfg[] findByIds(String[] ids, FBoolean isLazy);
        CiRuleCfg[] findByBIds(String[] ids, FBoolean isLazy);
        CiRuleCfg[] find(String condition, string orderStr, FBoolean isLazy);
        CiRuleCfg[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiRuleCfg> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiRuleCfg[] enableWithoutFilter(CiRuleCfg[] aggdos) ;
	    DOWithErrLog enableDO(CiRuleCfg[] aggdos) ;
	    CiRuleCfg[] disableVOWithoutFilter(CiRuleCfg[] aggdos);
	    DOWithErrLog disableDO(CiRuleCfg[] aggdos) ;
	    CiRuleCfg[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiRuleCfg[] findByAttrValString(String attr, String value);
	    CiRuleCfg[] findByAttrValStrings(String attr, String[] values);
	    CiRuleCfg[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<CiRuleCfg> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
