using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.ord.cirptpathgy.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.ord.cirptpathgy.i
{
    public interface ICirptpathgyCrudService
    {
        void delete(CiRptPathgyDO[] dos);
        CiRptPathgyDO[] insert(CiRptPathgyDO[] dos);
        CiRptPathgyDO[] save(CiRptPathgyDO[] dos);
        CiRptPathgyDO[] update(CiRptPathgyDO[] dos);
        void logicDelete(CiRptPathgyDO[] dos);
        CiRptPathgyDO findById(String id);
        CiRptPathgyDO[] findByIds(String[] ids, FBoolean isLazy);
        CiRptPathgyDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiRptPathgyDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiRptPathgyDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiRptPathgyDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiRptPathgyDO[] enableWithoutFilter(CiRptPathgyDO[] dos) ;
	    DOWithErrLog enableDO(CiRptPathgyDO[] dos) ;
	    CiRptPathgyDO[] disableVOWithoutFilter(CiRptPathgyDO[] dos);
	    DOWithErrLog disableDO(CiRptPathgyDO[] dos) ;
	    PagingRtnData<CiRptPathgyDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiRptPathgyDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiRptPathgyDO[] findByAttrValString(String attr, String value);
	    CiRptPathgyDO[] findByAttrValStrings(String attr, String[] values);
	    CiRptPathgyDO[] findByAttrValList(String attr, FArrayList values);
    }
}
