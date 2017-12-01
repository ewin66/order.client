using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.operinciinfect.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.operinciinfect.i
{
    public interface IOperinciinfectCrudService
    {
        void delete(OperIncInfectDO[] dos);
        OperIncInfectDO[] insert(OperIncInfectDO[] dos);
        OperIncInfectDO[] save(OperIncInfectDO[] dos);
        OperIncInfectDO[] update(OperIncInfectDO[] dos);
        void logicDelete(OperIncInfectDO[] dos);
        OperIncInfectDO findById(String id);
        OperIncInfectDO[] findByIds(String[] ids, FBoolean isLazy);
        OperIncInfectDO[] findByBIds(String[] ids, FBoolean isLazy);
        OperIncInfectDO[] find(String condition, string orderStr, FBoolean isLazy);
        OperIncInfectDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OperIncInfectDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OperIncInfectDO[] enableWithoutFilter(OperIncInfectDO[] dos) ;
	    DOWithErrLog enableDO(OperIncInfectDO[] dos) ;
	    OperIncInfectDO[] disableVOWithoutFilter(OperIncInfectDO[] dos);
	    DOWithErrLog disableDO(OperIncInfectDO[] dos) ;
	    PagingRtnData<OperIncInfectDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    OperIncInfectDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OperIncInfectDO[] findByAttrValString(String attr, String value);
	    OperIncInfectDO[] findByAttrValStrings(String attr, String[] values);
	    OperIncInfectDO[] findByAttrValList(String attr, FArrayList values);
    }
}
