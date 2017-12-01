using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.skintest.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.skintest.i
{
    public interface ISkintestCrudService
    {
        void delete(CiSkinTestRstDO[] dos);
        CiSkinTestRstDO[] insert(CiSkinTestRstDO[] dos);
        CiSkinTestRstDO[] save(CiSkinTestRstDO[] dos);
        CiSkinTestRstDO[] update(CiSkinTestRstDO[] dos);
        void logicDelete(CiSkinTestRstDO[] dos);
        CiSkinTestRstDO findById(String id);
        CiSkinTestRstDO[] findByIds(String[] ids, FBoolean isLazy);
        CiSkinTestRstDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiSkinTestRstDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiSkinTestRstDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiSkinTestRstDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiSkinTestRstDO[] enableWithoutFilter(CiSkinTestRstDO[] dos) ;
	    DOWithErrLog enableDO(CiSkinTestRstDO[] dos) ;
	    CiSkinTestRstDO[] disableVOWithoutFilter(CiSkinTestRstDO[] dos);
	    DOWithErrLog disableDO(CiSkinTestRstDO[] dos) ;
	    PagingRtnData<CiSkinTestRstDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiSkinTestRstDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiSkinTestRstDO[] findByAttrValString(String attr, String value);
	    CiSkinTestRstDO[] findByAttrValStrings(String attr, String[] values);
	    CiSkinTestRstDO[] findByAttrValList(String attr, FArrayList values);
    }
}
