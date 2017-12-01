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
    public interface IHFMDOCrudService
    {
        void delete(HFMDO[] dos);
        HFMDO[] insert(HFMDO[] dos);
        HFMDO[] save(HFMDO[] dos);
        HFMDO[] update(HFMDO[] dos);
        void logicDelete(HFMDO[] dos);
        HFMDO findById(String id);
        HFMDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        HFMDO[] findByIds(String[] ids, FBoolean isLazy);
        HFMDO[] findByBIds(String[] ids, FBoolean isLazy);
        HFMDO[] find(String condition, string orderStr, FBoolean isLazy);
        HFMDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<HFMDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<HFMDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    HFMDO[] enableWithoutFilter(HFMDO[] aggdos) ;
	    DOWithErrLog enableDO(HFMDO[] aggdos) ;
	    HFMDO[] disableVOWithoutFilter(HFMDO[] aggdos);
	    DOWithErrLog disableDO(HFMDO[] aggdos) ;
	    HFMDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    HFMDO[] findByAttrValString(String attr, String value);
	    HFMDO[] findByAttrValStrings(String attr, String[] values);
	    HFMDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<HFMDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
