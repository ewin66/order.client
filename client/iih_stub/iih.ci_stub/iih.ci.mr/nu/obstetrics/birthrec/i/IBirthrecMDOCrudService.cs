using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.nu.obstetrics.birthrec.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.nu.obstetrics.birthrec.i
{
    public interface IBirthrecMDOCrudService
    {
        void delete(BirthrecInfoDO[] dos);
        BirthrecInfoDO[] insert(BirthrecInfoDO[] dos);
        BirthrecInfoDO[] save(BirthrecInfoDO[] dos);
        BirthrecInfoDO[] update(BirthrecInfoDO[] dos);
        void logicDelete(BirthrecInfoDO[] dos);
        BirthrecInfoDO findById(String id);
        BirthrecInfoDO[] findByIds(String[] ids, FBoolean isLazy);
        BirthrecInfoDO[] findByBIds(String[] ids, FBoolean isLazy);
        BirthrecInfoDO[] find(String condition, string orderStr, FBoolean isLazy);
        BirthrecInfoDO[] findByBDMode(String whereStr,string orderStr,FBoolean isLazy);
        BirthrecInfoDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<BirthrecInfoDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<BirthrecInfoDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    BirthrecInfoDO[] enableWithoutFilter(BirthrecInfoDO[] aggdos) ;
	    DOWithErrLog enableDO(BirthrecInfoDO[] aggdos) ;
	    BirthrecInfoDO[] disableVOWithoutFilter(BirthrecInfoDO[] aggdos);
	    DOWithErrLog disableDO(BirthrecInfoDO[] aggdos) ;
	    BirthrecInfoDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    BirthrecInfoDO[] findByAttrValString(String attr, String value);
	    BirthrecInfoDO[] findByAttrValStrings(String attr, String[] values);
	    BirthrecInfoDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<BirthrecInfoDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
