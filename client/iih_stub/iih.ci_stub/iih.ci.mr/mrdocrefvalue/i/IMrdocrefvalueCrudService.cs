using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.mrdocrefvalue.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.mrdocrefvalue.i
{
    public interface IMrdocrefvalueCrudService
    {
        void delete(MrDocRefValueDO[] dos);
        MrDocRefValueDO[] insert(MrDocRefValueDO[] dos);
        MrDocRefValueDO[] save(MrDocRefValueDO[] dos);
        MrDocRefValueDO[] update(MrDocRefValueDO[] dos);
        void logicDelete(MrDocRefValueDO[] dos);
        MrDocRefValueDO findById(String id);
        MrDocRefValueDO[] findByIds(String[] ids, FBoolean isLazy);
        MrDocRefValueDO[] findByBIds(String[] ids, FBoolean isLazy);
        MrDocRefValueDO[] find(String condition, string orderStr, FBoolean isLazy);
        MrDocRefValueDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<MrDocRefValueDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    MrDocRefValueDO[] enableWithoutFilter(MrDocRefValueDO[] dos) ;
	    DOWithErrLog enableDO(MrDocRefValueDO[] dos) ;
	    MrDocRefValueDO[] disableVOWithoutFilter(MrDocRefValueDO[] dos);
	    DOWithErrLog disableDO(MrDocRefValueDO[] dos) ;
	    MrDocRefValueDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
    }
}
