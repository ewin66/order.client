using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.diag.cidiag.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.diag.cidiag.i
{
    public interface ICiDiagItemDOCrudService
    {
        void delete(CiDiagItemDO[] dos);
        CiDiagItemDO[] insert(CiDiagItemDO[] dos);
        CiDiagItemDO[] save(CiDiagItemDO[] dos);
        CiDiagItemDO[] update(CiDiagItemDO[] dos);
        void logicDelete(CiDiagItemDO[] dos);
        CiDiagItemDO findById(String id);
        CiDiagItemDO[] findByIds(String[] ids, FBoolean isLazy);
        CiDiagItemDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiDiagItemDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiDiagItemDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiDiagItemDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiDiagItemDO[] enableWithoutFilter(CiDiagItemDO[] aggdos) ;
	    DOWithErrLog enableDO(CiDiagItemDO[] aggdos) ;
	    CiDiagItemDO[] disableVOWithoutFilter(CiDiagItemDO[] aggdos);
	    DOWithErrLog disableDO(CiDiagItemDO[] aggdos) ;
	    CiDiagItemDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiDiagItemDO[] findByAttrValString(String attr, String value);
	    CiDiagItemDO[] findByAttrValStrings(String attr, String[] values);
	    CiDiagItemDO[] findByAttrValList(String attr, FArrayList values);
    }
}
