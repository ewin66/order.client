using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciorder.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciorder.i
{
    public interface IOrdNurseCareDOCrudService
    {
        void delete(OrdNurseCareDO[] dos);
        OrdNurseCareDO[] insert(OrdNurseCareDO[] dos);
        OrdNurseCareDO[] save(OrdNurseCareDO[] dos);
        OrdNurseCareDO[] update(OrdNurseCareDO[] dos);
        void logicDelete(OrdNurseCareDO[] dos);
        OrdNurseCareDO findById(String id);
        OrdNurseCareDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdNurseCareDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdNurseCareDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdNurseCareDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdNurseCareDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdNurseCareDO[] enableWithoutFilter(OrdNurseCareDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdNurseCareDO[] aggdos) ;
	    OrdNurseCareDO[] disableVOWithoutFilter(OrdNurseCareDO[] aggdos);
	    DOWithErrLog disableDO(OrdNurseCareDO[] aggdos) ;
	    OrdNurseCareDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
    }
}
