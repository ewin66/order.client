using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ciet.cievent.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ciet.cievent.i
{
    public interface ICieventCrudService
    {
        void delete(CiEventDO[] dos);
        CiEventDO[] insert(CiEventDO[] dos);
        CiEventDO[] save(CiEventDO[] dos);
        CiEventDO[] update(CiEventDO[] dos);
        void logicDelete(CiEventDO[] dos);
        CiEventDO findById(String id);
        CiEventDO[] findByIds(String[] ids, FBoolean isLazy);
        CiEventDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiEventDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiEventDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiEventDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiEventDO[] enableWithoutFilter(CiEventDO[] dos) ;
	    DOWithErrLog enableDO(CiEventDO[] dos) ;
	    CiEventDO[] disableVOWithoutFilter(CiEventDO[] dos);
	    DOWithErrLog disableDO(CiEventDO[] dos) ;
	    CiEventDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiEventDO[] findByAttrValString(String attr, String value);
	    CiEventDO[] findByAttrValStrings(String attr, String[] values);
	    CiEventDO[] findByAttrValList(String attr, FArrayList values);
    }
}
