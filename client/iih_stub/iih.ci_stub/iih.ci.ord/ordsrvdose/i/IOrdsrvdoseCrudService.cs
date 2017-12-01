using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ordsrvdose.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ordsrvdose.i
{
    public interface IOrdsrvdoseCrudService
    {
        void delete(OrdSrvDoseDO[] dos);
        OrdSrvDoseDO[] insert(OrdSrvDoseDO[] dos);
        OrdSrvDoseDO[] save(OrdSrvDoseDO[] dos);
        OrdSrvDoseDO[] update(OrdSrvDoseDO[] dos);
        void logicDelete(OrdSrvDoseDO[] dos);
        OrdSrvDoseDO findById(String id);
        OrdSrvDoseDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdSrvDoseDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdSrvDoseDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdSrvDoseDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdSrvDoseDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdSrvDoseDO[] enableWithoutFilter(OrdSrvDoseDO[] dos) ;
	    DOWithErrLog enableDO(OrdSrvDoseDO[] dos) ;
	    OrdSrvDoseDO[] disableVOWithoutFilter(OrdSrvDoseDO[] dos);
	    DOWithErrLog disableDO(OrdSrvDoseDO[] dos) ;
	    OrdSrvDoseDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
    }
}
