using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.pre.obspre.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.pre.obspre.i
{
    public interface IObspreMDOCrudService
    {
        void delete(ObsPreDO[] dos);
        ObsPreDO[] insert(ObsPreDO[] dos);
        ObsPreDO[] save(ObsPreDO[] dos);
        ObsPreDO[] update(ObsPreDO[] dos);
        void logicDelete(ObsPreDO[] dos);
        ObsPreDO findById(String id);
        ObsPreDO[] findByIds(String[] ids, FBoolean isLazy);
        ObsPreDO[] findByBIds(String[] ids, FBoolean isLazy);
        ObsPreDO[] find(String condition, string orderStr, FBoolean isLazy);
        ObsPreDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<ObsPreDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    ObsPreDO[] enableWithoutFilter(ObsPreDO[] aggdos) ;
	    DOWithErrLog enableDO(ObsPreDO[] aggdos) ;
	    ObsPreDO[] disableVOWithoutFilter(ObsPreDO[] aggdos);
	    DOWithErrLog disableDO(ObsPreDO[] aggdos) ;
	    ObsPreDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
    }
}
