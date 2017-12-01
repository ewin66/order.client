using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.antenatalassess.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.antenatalassess.i
{
    public interface IAntenatalassessMDOCrudService
    {
        void delete(AntenAssDO[] dos);
        AntenAssDO[] insert(AntenAssDO[] dos);
        AntenAssDO[] save(AntenAssDO[] dos);
        AntenAssDO[] update(AntenAssDO[] dos);
        void logicDelete(AntenAssDO[] dos);
        AntenAssDO findById(String id);
        AntenAssDO[] findByIds(String[] ids, FBoolean isLazy);
        AntenAssDO[] findByBIds(String[] ids, FBoolean isLazy);
        AntenAssDO[] find(String condition, string orderStr, FBoolean isLazy);
        AntenAssDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        AntenAssDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<AntenAssDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<AntenAssDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    AntenAssDO[] enableWithoutFilter(AntenAssDO[] aggdos) ;
	    DOWithErrLog enableDO(AntenAssDO[] aggdos) ;
	    AntenAssDO[] disableVOWithoutFilter(AntenAssDO[] aggdos);
	    DOWithErrLog disableDO(AntenAssDO[] aggdos) ;
	    AntenAssDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    AntenAssDO[] findByAttrValString(String attr, String value);
	    AntenAssDO[] findByAttrValStrings(String attr, String[] values);
	    AntenAssDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<AntenAssDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
