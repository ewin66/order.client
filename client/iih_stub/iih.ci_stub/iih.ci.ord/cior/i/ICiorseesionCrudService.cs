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
    public interface ICiorseesionCrudService
    {
        void delete(CiOrSeesionDO[] dos);
        CiOrSeesionDO[] insert(CiOrSeesionDO[] dos);
        CiOrSeesionDO[] save(CiOrSeesionDO[] dos);
        CiOrSeesionDO[] update(CiOrSeesionDO[] dos);
        void logicDelete(CiOrSeesionDO[] dos);
        CiOrSeesionDO findById(String id);
        CiOrSeesionDO[] findByIds(String[] ids, FBoolean isLazy);
        CiOrSeesionDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiOrSeesionDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiOrSeesionDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiOrSeesionDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiOrSeesionDO[] enableWithoutFilter(CiOrSeesionDO[] dos) ;
	    DOWithErrLog enableDO(CiOrSeesionDO[] dos) ;
	    CiOrSeesionDO[] disableVOWithoutFilter(CiOrSeesionDO[] dos);
	    DOWithErrLog disableDO(CiOrSeesionDO[] dos) ;
	    PagingRtnData<CiOrSeesionDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiOrSeesionDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiOrSeesionDO[] findByAttrValString(String attr, String value);
	    CiOrSeesionDO[] findByAttrValStrings(String attr, String[] values);
	    CiOrSeesionDO[] findByAttrValList(String attr, FArrayList values);
    }
}
