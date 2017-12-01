using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.mrsign.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.mrsign.i
{
    public interface IMrsignCrudService
    {
        void delete(CiMrSignDO[] dos);
        CiMrSignDO[] insert(CiMrSignDO[] dos);
        CiMrSignDO[] save(CiMrSignDO[] dos);
        CiMrSignDO[] update(CiMrSignDO[] dos);
        void logicDelete(CiMrSignDO[] dos);
        CiMrSignDO findById(String id);
        CiMrSignDO[] findByIds(String[] ids, FBoolean isLazy);
        CiMrSignDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiMrSignDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiMrSignDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiMrSignDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiMrSignDO[] enableWithoutFilter(CiMrSignDO[] dos) ;
	    DOWithErrLog enableDO(CiMrSignDO[] dos) ;
	    CiMrSignDO[] disableVOWithoutFilter(CiMrSignDO[] dos);
	    DOWithErrLog disableDO(CiMrSignDO[] dos) ;
	    PagingRtnData<CiMrSignDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiMrSignDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiMrSignDO[] findByAttrValString(String attr, String value);
	    CiMrSignDO[] findByAttrValStrings(String attr, String[] values);
	    CiMrSignDO[] findByAttrValList(String attr, FArrayList values);
    }
}
