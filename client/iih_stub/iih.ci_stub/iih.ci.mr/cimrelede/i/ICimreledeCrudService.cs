using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.cimrelede.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.cimrelede.i
{
    public interface ICimreledeCrudService
    {
        void delete(CiMrEleDeDO[] dos);
        CiMrEleDeDO[] insert(CiMrEleDeDO[] dos);
        CiMrEleDeDO[] save(CiMrEleDeDO[] dos);
        CiMrEleDeDO[] update(CiMrEleDeDO[] dos);
        void logicDelete(CiMrEleDeDO[] dos);
        CiMrEleDeDO findById(String id);
        CiMrEleDeDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrEleDeDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrEleDeDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrEleDeDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        CiMrEleDeDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrEleDeDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<CiMrEleDeDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    CiMrEleDeDO[] enableWithoutFilter(CiMrEleDeDO[] dos) ;
	    DOWithErrLog enableDO(CiMrEleDeDO[] dos) ;
	    CiMrEleDeDO[] disableVOWithoutFilter(CiMrEleDeDO[] dos);
	    DOWithErrLog disableDO(CiMrEleDeDO[] dos) ;
	    PagingRtnData<CiMrEleDeDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrEleDeDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrEleDeDO[] findByAttrValString(String attr, String value);
	    CiMrEleDeDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrEleDeDO[] findByAttrValList(String attr, FArrayList values);
    }
}