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
    public interface ICirulecfgCrudService
    {
        void delete(CirulecfgAggDO[] dos);
        CirulecfgAggDO[] insert(CirulecfgAggDO[] dos);
        CirulecfgAggDO[] save(CirulecfgAggDO[] dos);
        CirulecfgAggDO[] update(CirulecfgAggDO[] dos);
        void logicDelete(CirulecfgAggDO[] dos);
        CirulecfgAggDO findById(String id);
        CirulecfgAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CirulecfgAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CirulecfgAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CirulecfgAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CirulecfgAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CirulecfgAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(CiRuleCfg[] mainDos);
		void logicDeleteByParentDO(CiRuleCfg[] mainDos);
	    CirulecfgAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CirulecfgAggDO[] findByAttrValString(String attr, String value);
	    CirulecfgAggDO[] findByAttrValStrings(String attr, String[] values);
	    CirulecfgAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}