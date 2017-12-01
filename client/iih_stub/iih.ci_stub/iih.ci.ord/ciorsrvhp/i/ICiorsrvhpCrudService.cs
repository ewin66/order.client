using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciorsrvhp.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciorsrvhp.i
{
    public interface ICiorsrvhpCrudService
    {
        void delete(CiOrSrvHpDO[] dos);
        CiOrSrvHpDO[] insert(CiOrSrvHpDO[] dos);
        CiOrSrvHpDO[] save(CiOrSrvHpDO[] dos);
        CiOrSrvHpDO[] update(CiOrSrvHpDO[] dos);
        void logicDelete(CiOrSrvHpDO[] dos);
        CiOrSrvHpDO findById(String id);
        CiOrSrvHpDO[] findByIds(String[] ids, FBoolean isLazy);
        CiOrSrvHpDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiOrSrvHpDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiOrSrvHpDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiOrSrvHpDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiOrSrvHpDO[] enableWithoutFilter(CiOrSrvHpDO[] dos) ;
	    DOWithErrLog enableDO(CiOrSrvHpDO[] dos) ;
	    CiOrSrvHpDO[] disableVOWithoutFilter(CiOrSrvHpDO[] dos);
	    DOWithErrLog disableDO(CiOrSrvHpDO[] dos) ;
	    PagingRtnData<CiOrSrvHpDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiOrSrvHpDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiOrSrvHpDO[] findByAttrValString(String attr, String value);
	    CiOrSrvHpDO[] findByAttrValStrings(String attr, String[] values);
	    CiOrSrvHpDO[] findByAttrValList(String attr, FArrayList values);
    }
}