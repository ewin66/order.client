using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.app.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.app.i
{
    public interface ICiapptreatexecCrudService
    {
        void delete(CiapptreatexecAggDO[] dos);
        CiapptreatexecAggDO[] insert(CiapptreatexecAggDO[] dos);
        CiapptreatexecAggDO[] save(CiapptreatexecAggDO[] dos);
        CiapptreatexecAggDO[] update(CiapptreatexecAggDO[] dos);
        void logicDelete(CiapptreatexecAggDO[] dos);
        CiapptreatexecAggDO findById(String id);
        CiapptreatexecAggDO[] findByIds(String[] ids, FBoolean isLazy);
        CiapptreatexecAggDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiapptreatexecAggDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiapptreatexecAggDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiapptreatexecAggDO[] findByQScheme(IQryScheme qscheme);//暂不用
		PagingRtnData<CiapptreatexecAggDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart,FBoolean isLazy);
		PagingRtnData<CiapptreatexecAggDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr,FBoolean isLazy);
		PagingRtnData<CiapptreatexecAggDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg,FBoolean isLazy);
		void deleteByParentDO(CiAppTreatExecDO[] mainDos);
		void logicDeleteByParentDO(CiAppTreatExecDO[] mainDos);
	    CiapptreatexecAggDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiapptreatexecAggDO[] findByAttrValString(String attr, String value);
	    CiapptreatexecAggDO[] findByAttrValStrings(String attr, String[] values);
	    CiapptreatexecAggDO[] findByAttrValList(String attr, FArrayList values);
    }
}