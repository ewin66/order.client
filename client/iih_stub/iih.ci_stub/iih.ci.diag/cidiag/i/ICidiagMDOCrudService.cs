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
    public interface ICidiagMDOCrudService
    {
        void delete(CiDiagDO[] dos);
        CiDiagDO[] insert(CiDiagDO[] dos);
        CiDiagDO[] save(CiDiagDO[] dos);
        CiDiagDO[] update(CiDiagDO[] dos);
        void logicDelete(CiDiagDO[] dos);
        CiDiagDO findById(String id);
        CiDiagDO[] findByIds(String[] ids, FBoolean isLazy);
        CiDiagDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiDiagDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiDiagDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiDiagDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiDiagDO[] enableWithoutFilter(CiDiagDO[] aggdos) ;
	    DOWithErrLog enableDO(CiDiagDO[] aggdos) ;
	    CiDiagDO[] disableVOWithoutFilter(CiDiagDO[] aggdos);
	    DOWithErrLog disableDO(CiDiagDO[] aggdos) ;
	    CiDiagDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiDiagDO[] findByAttrValString(String attr, String value);
	    CiDiagDO[] findByAttrValStrings(String attr, String[] values);
	    CiDiagDO[] findByAttrValList(String attr, FArrayList values);
    }
}
