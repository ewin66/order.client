using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.breathmachnur.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.breathmachnur.i
{
    public interface IBreathmachnurMDOCrudService
    {
        void delete(BreathMachInfoDO[] dos);
        BreathMachInfoDO[] insert(BreathMachInfoDO[] dos);
        BreathMachInfoDO[] save(BreathMachInfoDO[] dos);
        BreathMachInfoDO[] update(BreathMachInfoDO[] dos);
        void logicDelete(BreathMachInfoDO[] dos);
        BreathMachInfoDO findById(String id);
        BreathMachInfoDO[] findByIds(String[] ids, FBoolean isLazy);
        BreathMachInfoDO[] findByBIds(String[] ids, FBoolean isLazy);
        BreathMachInfoDO[] find(String condition, string orderStr, FBoolean isLazy);
        BreathMachInfoDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        BreathMachInfoDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<BreathMachInfoDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<BreathMachInfoDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    BreathMachInfoDO[] enableWithoutFilter(BreathMachInfoDO[] aggdos) ;
	    DOWithErrLog enableDO(BreathMachInfoDO[] aggdos) ;
	    BreathMachInfoDO[] disableVOWithoutFilter(BreathMachInfoDO[] aggdos);
	    DOWithErrLog disableDO(BreathMachInfoDO[] aggdos) ;
	    BreathMachInfoDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    BreathMachInfoDO[] findByAttrValString(String attr, String value);
	    BreathMachInfoDO[] findByAttrValStrings(String attr, String[] values);
	    BreathMachInfoDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<BreathMachInfoDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
