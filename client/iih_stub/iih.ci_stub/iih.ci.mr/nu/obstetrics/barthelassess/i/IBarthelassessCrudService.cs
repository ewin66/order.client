using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.barthelassess.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.barthelassess.i
{
    public interface IBarthelassessCrudService
    {
        void delete(BarthelAssessDO[] dos);
        BarthelAssessDO[] insert(BarthelAssessDO[] dos);
        BarthelAssessDO[] save(BarthelAssessDO[] dos);
        BarthelAssessDO[] update(BarthelAssessDO[] dos);
        void logicDelete(BarthelAssessDO[] dos);
        BarthelAssessDO findById(String id);
        BarthelAssessDO[] findByIds(String[] ids, FBoolean isLazy);
        BarthelAssessDO[] findByBIds(String[] ids, FBoolean isLazy);
        BarthelAssessDO[] find(String condition, string orderStr, FBoolean isLazy);
        BarthelAssessDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<BarthelAssessDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    BarthelAssessDO[] enableWithoutFilter(BarthelAssessDO[] dos) ;
	    DOWithErrLog enableDO(BarthelAssessDO[] dos) ;
	    BarthelAssessDO[] disableVOWithoutFilter(BarthelAssessDO[] dos);
	    DOWithErrLog disableDO(BarthelAssessDO[] dos) ;
	    PagingRtnData<BarthelAssessDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    BarthelAssessDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    BarthelAssessDO[] findByAttrValString(String attr, String value);
	    BarthelAssessDO[] findByAttrValStrings(String attr, String[] values);
	    BarthelAssessDO[] findByAttrValList(String attr, FArrayList values);
    }
}
