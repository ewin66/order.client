using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.cimr.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;
using xap.wf.af.vos.i;

namespace iih.ci.mr.cimr.i
{
    public interface ICiemrCrudService
    {
        void delete(CiMrDO[] dos);
        bool deleteAndStop(string idUser, WfFormInfoCtx formInfo);
        CiMrDO[] insert(CiMrDO[] dos);
        CiMrDO[] save(CiMrDO[] dos);
        CiMrDO[] update(CiMrDO[] dos);
        void logicDelete(CiMrDO[] dos);
        CiMrDO findById(String id);
        CiMrDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrDO[] enableWithoutFilter(CiMrDO[] dos) ;
	    DOWithErrLog enableDO(CiMrDO[] dos) ;
	    CiMrDO[] disableVOWithoutFilter(CiMrDO[] dos);
	    DOWithErrLog disableDO(CiMrDO[] dos) ;
	    PagingRtnData<CiMrDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrDO[] findByAttrValString(String attr, String value);
	    CiMrDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrDO[] findByAttrValList(String attr, FArrayList values);
    }
}
