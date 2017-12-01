using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.contagion.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.contagion.i
{
    public interface ISyphilisDOCrudService
    {
        void delete(SyphilisDO[] dos);
        SyphilisDO[] insert(SyphilisDO[] dos);
        SyphilisDO[] save(SyphilisDO[] dos);
        SyphilisDO[] update(SyphilisDO[] dos);
        void logicDelete(SyphilisDO[] dos);
        SyphilisDO findById(String id);
        SyphilisDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        SyphilisDO[] findByIds(String[] ids, FBoolean isLazy);
        SyphilisDO[] findByBIds(String[] ids, FBoolean isLazy);
        SyphilisDO[] find(String condition, string orderStr, FBoolean isLazy);
        SyphilisDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<SyphilisDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<SyphilisDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    SyphilisDO[] enableWithoutFilter(SyphilisDO[] aggdos) ;
	    DOWithErrLog enableDO(SyphilisDO[] aggdos) ;
	    SyphilisDO[] disableVOWithoutFilter(SyphilisDO[] aggdos);
	    DOWithErrLog disableDO(SyphilisDO[] aggdos) ;
	    SyphilisDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    SyphilisDO[] findByAttrValString(String attr, String value);
	    SyphilisDO[] findByAttrValStrings(String attr, String[] values);
	    SyphilisDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<SyphilisDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
