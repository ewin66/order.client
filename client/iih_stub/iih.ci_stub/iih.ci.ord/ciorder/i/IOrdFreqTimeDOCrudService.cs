using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.ciorder.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.ciorder.i
{
    public interface IOrdFreqTimeDOCrudService
    {
        void delete(OrdFreqTimeDO[] dos);
        OrdFreqTimeDO[] insert(OrdFreqTimeDO[] dos);
        OrdFreqTimeDO[] save(OrdFreqTimeDO[] dos);
        OrdFreqTimeDO[] update(OrdFreqTimeDO[] dos);
        void logicDelete(OrdFreqTimeDO[] dos);
        OrdFreqTimeDO findById(String id);
        OrdFreqTimeDO[] findByIds(String[] ids, FBoolean isLazy);
        OrdFreqTimeDO[] findByBIds(String[] ids, FBoolean isLazy);
        OrdFreqTimeDO[] find(String condition, string orderStr, FBoolean isLazy);
        OrdFreqTimeDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<OrdFreqTimeDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    OrdFreqTimeDO[] enableWithoutFilter(OrdFreqTimeDO[] aggdos) ;
	    DOWithErrLog enableDO(OrdFreqTimeDO[] aggdos) ;
	    OrdFreqTimeDO[] disableVOWithoutFilter(OrdFreqTimeDO[] aggdos);
	    DOWithErrLog disableDO(OrdFreqTimeDO[] aggdos) ;
	    OrdFreqTimeDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    OrdFreqTimeDO[] findByAttrValString(String attr, String value);
	    OrdFreqTimeDO[] findByAttrValStrings(String attr, String[] values);
	    OrdFreqTimeDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<OrdFreqTimeDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}