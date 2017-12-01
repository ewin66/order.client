using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.cimreledg.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.cimreledg.i
{
    public interface ICiemreledgCrudService
    {
        void delete(CiMrEleDgDO[] dos);
        CiMrEleDgDO[] insert(CiMrEleDgDO[] dos);
        CiMrEleDgDO[] save(CiMrEleDgDO[] dos);
        CiMrEleDgDO[] update(CiMrEleDgDO[] dos);
        void logicDelete(CiMrEleDgDO[] dos);
        CiMrEleDgDO findById(String id);
        CiMrEleDgDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrEleDgDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrEleDgDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrEleDgDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiMrEleDgDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrEleDgDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiMrEleDgDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiMrEleDgDO[] enableWithoutFilter(CiMrEleDgDO[] dos) ;
	    DOWithErrLog enableDO(CiMrEleDgDO[] dos) ;
	    CiMrEleDgDO[] disableVOWithoutFilter(CiMrEleDgDO[] dos);
	    DOWithErrLog disableDO(CiMrEleDgDO[] dos) ;
	    PagingRtnData<CiMrEleDgDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrEleDgDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrEleDgDO[] findByAttrValString(String attr, String value);
	    CiMrEleDgDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrEleDgDO[] findByAttrValList(String attr, FArrayList values);
    }
}