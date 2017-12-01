using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.antennurbaby.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.antennurbaby.i
{
    public interface IAntennurbabyMDOCrudService
    {
        void delete(AntNurBabyDO[] dos);
        AntNurBabyDO[] insert(AntNurBabyDO[] dos);
        AntNurBabyDO[] save(AntNurBabyDO[] dos);
        AntNurBabyDO[] update(AntNurBabyDO[] dos);
        void logicDelete(AntNurBabyDO[] dos);
        AntNurBabyDO findById(String id);
        AntNurBabyDO[] findByIds(String[] ids, FBoolean isLazy);
        AntNurBabyDO[] findByBIds(String[] ids, FBoolean isLazy);
        AntNurBabyDO[] find(String condition, string orderStr, FBoolean isLazy);
        AntNurBabyDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        AntNurBabyDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AntNurBabyDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<AntNurBabyDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    AntNurBabyDO[] enableWithoutFilter(AntNurBabyDO[] aggdos) ;
	    DOWithErrLog enableDO(AntNurBabyDO[] aggdos) ;
	    AntNurBabyDO[] disableVOWithoutFilter(AntNurBabyDO[] aggdos);
	    DOWithErrLog disableDO(AntNurBabyDO[] aggdos) ;
	    AntNurBabyDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AntNurBabyDO[] findByAttrValString(String attr, String value);
	    AntNurBabyDO[] findByAttrValStrings(String attr, String[] values);
	    AntNurBabyDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<AntNurBabyDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
