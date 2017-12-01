using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cirptobs.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cirptobs.i
{
    public interface ICirptobsCrudService
    {
        void delete(CiRptObsDO[] dos);
        CiRptObsDO[] insert(CiRptObsDO[] dos);
        CiRptObsDO[] save(CiRptObsDO[] dos);
        CiRptObsDO[] update(CiRptObsDO[] dos);
        void logicDelete(CiRptObsDO[] dos);
        CiRptObsDO findById(String id);
        CiRptObsDO[] findByIds(String[] ids, FBoolean isLazy);
        CiRptObsDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiRptObsDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiRptObsDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiRptObsDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiRptObsDO[] enableWithoutFilter(CiRptObsDO[] dos) ;
	    DOWithErrLog enableDO(CiRptObsDO[] dos) ;
	    CiRptObsDO[] disableVOWithoutFilter(CiRptObsDO[] dos);
	    DOWithErrLog disableDO(CiRptObsDO[] dos) ;
	    PagingRtnData<CiRptObsDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiRptObsDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiRptObsDO[] findByAttrValString(String attr, String value);
	    CiRptObsDO[] findByAttrValStrings(String attr, String[] values);
	    CiRptObsDO[] findByAttrValList(String attr, FArrayList values);
    }
}
