using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.au.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.au.i
{
    public interface IAntibioticusedoCrudService
    {
        void delete(AntibioticUseDO[] dos);
        AntibioticUseDO[] insert(AntibioticUseDO[] dos);
        AntibioticUseDO[] save(AntibioticUseDO[] dos);
        AntibioticUseDO[] update(AntibioticUseDO[] dos);
        void logicDelete(AntibioticUseDO[] dos);
        AntibioticUseDO findById(String id);
        AntibioticUseDO[] findByIds(String[] ids, FBoolean isLazy);
        AntibioticUseDO[] findByBIds(String[] ids, FBoolean isLazy);
        AntibioticUseDO[] find(String condition, string orderStr, FBoolean isLazy);
        AntibioticUseDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AntibioticUseDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    AntibioticUseDO[] enableWithoutFilter(AntibioticUseDO[] dos) ;
	    DOWithErrLog enableDO(AntibioticUseDO[] dos) ;
	    AntibioticUseDO[] disableVOWithoutFilter(AntibioticUseDO[] dos);
	    DOWithErrLog disableDO(AntibioticUseDO[] dos) ;
	    PagingRtnData<AntibioticUseDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    AntibioticUseDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AntibioticUseDO[] findByAttrValString(String attr, String value);
	    AntibioticUseDO[] findByAttrValStrings(String attr, String[] values);
	    AntibioticUseDO[] findByAttrValList(String attr, FArrayList values);
    }
}
