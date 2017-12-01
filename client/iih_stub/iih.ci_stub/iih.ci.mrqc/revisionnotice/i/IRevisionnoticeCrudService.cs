using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mrqc.revisionnotice.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mrqc.revisionnotice.i
{
    public interface IRevisionnoticeCrudService
    {
        void delete(RevisionNoticeDO[] dos);
        RevisionNoticeDO[] insert(RevisionNoticeDO[] dos);
        RevisionNoticeDO[] save(RevisionNoticeDO[] dos);
        RevisionNoticeDO[] update(RevisionNoticeDO[] dos);
        void logicDelete(RevisionNoticeDO[] dos);
        RevisionNoticeDO findById(String id);
        RevisionNoticeDO[] findByIds(String[] ids, FBoolean isLazy);
        RevisionNoticeDO[] findByBIds(String[] ids, FBoolean isLazy);
        RevisionNoticeDO[] find(String condition, string orderStr, FBoolean isLazy);
        RevisionNoticeDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<RevisionNoticeDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    RevisionNoticeDO[] enableWithoutFilter(RevisionNoticeDO[] dos) ;
	    DOWithErrLog enableDO(RevisionNoticeDO[] dos) ;
	    RevisionNoticeDO[] disableVOWithoutFilter(RevisionNoticeDO[] dos);
	    DOWithErrLog disableDO(RevisionNoticeDO[] dos) ;
	    PagingRtnData<RevisionNoticeDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    RevisionNoticeDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    RevisionNoticeDO[] findByAttrValString(String attr, String value);
	    RevisionNoticeDO[] findByAttrValStrings(String attr, String[] values);
	    RevisionNoticeDO[] findByAttrValList(String attr, FArrayList values);
    }
}
