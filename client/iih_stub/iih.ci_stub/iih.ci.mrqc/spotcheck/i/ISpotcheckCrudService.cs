using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.spotcheck.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.spotcheck.i
{
    public interface ISpotcheckCrudService
    {
        void delete(CiAmrSpotCheckRecordDO[] dos);
        CiAmrSpotCheckRecordDO[] insert(CiAmrSpotCheckRecordDO[] dos);
        CiAmrSpotCheckRecordDO[] save(CiAmrSpotCheckRecordDO[] dos);
        CiAmrSpotCheckRecordDO[] update(CiAmrSpotCheckRecordDO[] dos);
        void logicDelete(CiAmrSpotCheckRecordDO[] dos);
        CiAmrSpotCheckRecordDO findById(String id);
        CiAmrSpotCheckRecordDO[] findByIds(String[] ids, FBoolean isLazy);
        CiAmrSpotCheckRecordDO[] findByBIds(String[] ids, FBoolean isLazy);
        CiAmrSpotCheckRecordDO[] find(String condition, string orderStr, FBoolean isLazy);
        CiAmrSpotCheckRecordDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<CiAmrSpotCheckRecordDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    CiAmrSpotCheckRecordDO[] enableWithoutFilter(CiAmrSpotCheckRecordDO[] dos) ;
	    DOWithErrLog enableDO(CiAmrSpotCheckRecordDO[] dos) ;
	    CiAmrSpotCheckRecordDO[] disableVOWithoutFilter(CiAmrSpotCheckRecordDO[] dos);
	    DOWithErrLog disableDO(CiAmrSpotCheckRecordDO[] dos) ;
	    PagingRtnData<CiAmrSpotCheckRecordDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    CiAmrSpotCheckRecordDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    CiAmrSpotCheckRecordDO[] findByAttrValString(String attr, String value);
	    CiAmrSpotCheckRecordDO[] findByAttrValStrings(String attr, String[] values);
	    CiAmrSpotCheckRecordDO[] findByAttrValList(String attr, FArrayList values);
    }
}
