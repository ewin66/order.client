using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.amrapply.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.amrapply.i
{
    public interface IAmrapplyCrudService
    {
        void delete(AmrApplyDO[] dos);
        AmrApplyDO[] insert(AmrApplyDO[] dos);
        AmrApplyDO[] save(AmrApplyDO[] dos);
        AmrApplyDO[] update(AmrApplyDO[] dos);
        void logicDelete(AmrApplyDO[] dos);
        AmrApplyDO findById(String id);
        AmrApplyDO[] findByIds(String[] ids, FBoolean isLazy);
        AmrApplyDO[] findByBIds(String[] ids, FBoolean isLazy);
        AmrApplyDO[] find(String condition, string orderStr, FBoolean isLazy);
        AmrApplyDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AmrApplyDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    AmrApplyDO[] enableWithoutFilter(AmrApplyDO[] dos) ;
	    DOWithErrLog enableDO(AmrApplyDO[] dos) ;
	    AmrApplyDO[] disableVOWithoutFilter(AmrApplyDO[] dos);
	    DOWithErrLog disableDO(AmrApplyDO[] dos) ;
	    PagingRtnData<AmrApplyDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    AmrApplyDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AmrApplyDO[] findByAttrValString(String attr, String value);
	    AmrApplyDO[] findByAttrValStrings(String attr, String[] values);
	    AmrApplyDO[] findByAttrValList(String attr, FArrayList values);
    }
}
