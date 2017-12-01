using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.pressuresoreass.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.pressuresoreass.i
{
    public interface IPressuresoreassCrudService
    {
        void delete(PressureSoreAssDO[] dos);
        PressureSoreAssDO[] insert(PressureSoreAssDO[] dos);
        PressureSoreAssDO[] save(PressureSoreAssDO[] dos);
        PressureSoreAssDO[] update(PressureSoreAssDO[] dos);
        void logicDelete(PressureSoreAssDO[] dos);
        PressureSoreAssDO findById(String id);
        PressureSoreAssDO[] findByIds(String[] ids, FBoolean isLazy);
        PressureSoreAssDO[] findByBIds(String[] ids, FBoolean isLazy);
        PressureSoreAssDO[] find(String condition, string orderStr, FBoolean isLazy);
        PressureSoreAssDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        PressureSoreAssDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<PressureSoreAssDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<PressureSoreAssDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    PressureSoreAssDO[] enableWithoutFilter(PressureSoreAssDO[] dos) ;
	    DOWithErrLog enableDO(PressureSoreAssDO[] dos) ;
	    PressureSoreAssDO[] disableVOWithoutFilter(PressureSoreAssDO[] dos);
	    DOWithErrLog disableDO(PressureSoreAssDO[] dos) ;
	    PagingRtnData<PressureSoreAssDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    PressureSoreAssDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    PressureSoreAssDO[] findByAttrValString(String attr, String value);
	    PressureSoreAssDO[] findByAttrValStrings(String attr, String[] values);
	    PressureSoreAssDO[] findByAttrValList(String attr, FArrayList values);
    }
}