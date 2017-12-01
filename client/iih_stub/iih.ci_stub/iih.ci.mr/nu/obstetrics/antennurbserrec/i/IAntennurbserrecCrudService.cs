using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.antennurbserrec.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.antennurbserrec.i
{
    public interface IAntennurbserrecCrudService
    {
        void delete(AntenNurBserRecDO[] dos);
        AntenNurBserRecDO[] insert(AntenNurBserRecDO[] dos);
        AntenNurBserRecDO[] save(AntenNurBserRecDO[] dos);
        AntenNurBserRecDO[] update(AntenNurBserRecDO[] dos);
        void logicDelete(AntenNurBserRecDO[] dos);
        AntenNurBserRecDO findById(String id);
        AntenNurBserRecDO[] findByIds(String[] ids, FBoolean isLazy);
        AntenNurBserRecDO[] findByBIds(String[] ids, FBoolean isLazy);
        AntenNurBserRecDO[] find(String condition, string orderStr, FBoolean isLazy);
        AntenNurBserRecDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AntenNurBserRecDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    AntenNurBserRecDO[] enableWithoutFilter(AntenNurBserRecDO[] dos) ;
	    DOWithErrLog enableDO(AntenNurBserRecDO[] dos) ;
	    AntenNurBserRecDO[] disableVOWithoutFilter(AntenNurBserRecDO[] dos);
	    DOWithErrLog disableDO(AntenNurBserRecDO[] dos) ;
	    PagingRtnData<AntenNurBserRecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    AntenNurBserRecDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AntenNurBserRecDO[] findByAttrValString(String attr, String value);
	    AntenNurBserRecDO[] findByAttrValStrings(String attr, String[] values);
	    AntenNurBserRecDO[] findByAttrValList(String attr, FArrayList values);
    }
}