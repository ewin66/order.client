using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.adl.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.adl.i
{
    public interface IAdlCrudService
    {
        void delete(ADLDO[] dos);
        ADLDO[] insert(ADLDO[] dos);
        ADLDO[] save(ADLDO[] dos);
        ADLDO[] update(ADLDO[] dos);
        void logicDelete(ADLDO[] dos);
        ADLDO findById(String id);
        ADLDO[] findByIds(String[] ids, FBoolean isLazy);
        ADLDO[] findByBIds(String[] ids, FBoolean isLazy);
        ADLDO[] find(String condition, string orderStr, FBoolean isLazy);
        ADLDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        ADLDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<ADLDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<ADLDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    ADLDO[] enableWithoutFilter(ADLDO[] dos) ;
	    DOWithErrLog enableDO(ADLDO[] dos) ;
	    ADLDO[] disableVOWithoutFilter(ADLDO[] dos);
	    DOWithErrLog disableDO(ADLDO[] dos) ;
	    PagingRtnData<ADLDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    ADLDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    ADLDO[] findByAttrValString(String attr, String value);
	    ADLDO[] findByAttrValStrings(String attr, String[] values);
	    ADLDO[] findByAttrValList(String attr, FArrayList values);
    }
}