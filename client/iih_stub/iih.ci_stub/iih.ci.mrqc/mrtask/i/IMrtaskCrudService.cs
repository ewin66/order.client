using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.mrtask.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.mrtask.i
{
    public interface IMrtaskCrudService
    {
        void delete(MrTaskDO[] dos);
        MrTaskDO[] insert(MrTaskDO[] dos);
        MrTaskDO[] save(MrTaskDO[] dos);
        MrTaskDO[] update(MrTaskDO[] dos);
        void logicDelete(MrTaskDO[] dos);
        MrTaskDO findById(String id);
        MrTaskDO[] findByIds(String[] ids, FBoolean isLazy);
        MrTaskDO[] findByBIds(String[] ids, FBoolean isLazy);
        MrTaskDO[] find(String condition, string orderStr, FBoolean isLazy);
        MrTaskDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<MrTaskDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    MrTaskDO[] enableWithoutFilter(MrTaskDO[] dos) ;
	    DOWithErrLog enableDO(MrTaskDO[] dos) ;
	    MrTaskDO[] disableVOWithoutFilter(MrTaskDO[] dos);
	    DOWithErrLog disableDO(MrTaskDO[] dos) ;
	    PagingRtnData<MrTaskDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    MrTaskDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    MrTaskDO[] findByAttrValString(String attr, String value);
	    MrTaskDO[] findByAttrValStrings(String attr, String[] values);
	    MrTaskDO[] findByAttrValList(String attr, FArrayList values);
    }
}
