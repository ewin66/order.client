using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cior.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cior.i
{
    public interface ICiorappsurgeryCrudService
    {
        void delete(CiorappsurgeryAggDO[] dos);
        CiorappsurgeryAggDO[] insert(CiorappsurgeryAggDO[] dos);
        CiorappsurgeryAggDO[] save(CiorappsurgeryAggDO[] dos);
        CiorappsurgeryAggDO[] update(CiorappsurgeryAggDO[] dos);
        void logicDelete(CiorappsurgeryAggDO[] dos);
        CiorappsurgeryAggDO findById(String id);
        CiorappsurgeryAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiorappsurgeryAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiorappsurgeryAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiorappsurgeryAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiorappsurgeryAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiorappsurgeryAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(OrdApOpDO[] mainDos);
		void logicDeleteByParentDO(OrdApOpDO[] mainDos);
	    CiorappsurgeryAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiorappsurgeryAggDO[] findByAttrValString(String attr, String value);
	    CiorappsurgeryAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiorappsurgeryAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}
