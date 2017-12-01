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
    public interface ICirptlabMDOCrudService
    {
        void delete(CiRptLabDO[] dos);
        CiRptLabDO[] insert(CiRptLabDO[] dos);
        CiRptLabDO[] save(CiRptLabDO[] dos);
        CiRptLabDO[] update(CiRptLabDO[] dos);
        void logicDelete(CiRptLabDO[] dos);
        CiRptLabDO findById(String id);
        CiRptLabDO[] findByIds(String[] ids, FBoolean isLazy);
        CiRptLabDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiRptLabDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiRptLabDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiRptLabDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiRptLabDO[] enableWithoutFilter(CiRptLabDO[] aggdos) ;
	    DOWithErrLog enableDO(CiRptLabDO[] aggdos) ;
	    CiRptLabDO[] disableVOWithoutFilter(CiRptLabDO[] aggdos);
	    DOWithErrLog disableDO(CiRptLabDO[] aggdos) ;
	    CiRptLabDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
    }
}
