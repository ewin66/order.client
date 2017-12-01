using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cirptlab.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cirptlab.i
{
    public interface ICiRptLabItmDOCrudService
    {
        void delete(CiRptLabItmDO[] dos);
        CiRptLabItmDO[] insert(CiRptLabItmDO[] dos);
        CiRptLabItmDO[] save(CiRptLabItmDO[] dos);
        CiRptLabItmDO[] update(CiRptLabItmDO[] dos);
        void logicDelete(CiRptLabItmDO[] dos);
        CiRptLabItmDO findById(String id);
        CiRptLabItmDO[] findByIds(String[] ids, FBoolean isLazy);
        CiRptLabItmDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiRptLabItmDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiRptLabItmDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiRptLabItmDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiRptLabItmDO[] enableWithoutFilter(CiRptLabItmDO[] aggdos) ;
	    DOWithErrLog enableDO(CiRptLabItmDO[] aggdos) ;
	    CiRptLabItmDO[] disableVOWithoutFilter(CiRptLabItmDO[] aggdos);
	    DOWithErrLog disableDO(CiRptLabItmDO[] aggdos) ;
	    CiRptLabItmDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
    }
}
