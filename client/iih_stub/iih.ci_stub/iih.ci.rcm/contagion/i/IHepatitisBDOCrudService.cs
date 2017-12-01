using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.rcm.contagion.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.contagion.i
{
    public interface IHepatitisBDOCrudService
    {
        void delete(HepatitisBDO[] dos);
        HepatitisBDO[] insert(HepatitisBDO[] dos);
        HepatitisBDO[] save(HepatitisBDO[] dos);
        HepatitisBDO[] update(HepatitisBDO[] dos);
        void logicDelete(HepatitisBDO[] dos);
        HepatitisBDO findById(String id);
        HepatitisBDO[] findByBDMode(String whereStr,String orderStr,FBoolean isLazy);
        HepatitisBDO[] findByIds(String[] ids, FBoolean isLazy);
        HepatitisBDO[] findByBIds(String[] ids, FBoolean isLazy);
        HepatitisBDO[] find(String condition, string orderStr, FBoolean isLazy);
        HepatitisBDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<HepatitisBDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
        PagingRtnData<HepatitisBDO> findByPageInfoAndBDMode(PaginationInfo pg, String whereStr,String orderStr);
	    HepatitisBDO[] enableWithoutFilter(HepatitisBDO[] aggdos) ;
	    DOWithErrLog enableDO(HepatitisBDO[] aggdos) ;
	    HepatitisBDO[] disableVOWithoutFilter(HepatitisBDO[] aggdos);
	    DOWithErrLog disableDO(HepatitisBDO[] aggdos) ;
	    HepatitisBDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    HepatitisBDO[] findByAttrValString(String attr, String value);
	    HepatitisBDO[] findByAttrValStrings(String attr, String[] values);
	    HepatitisBDO[] findByAttrValList(String attr, FArrayList values);
	    PagingRtnData<HepatitisBDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
    }
}
