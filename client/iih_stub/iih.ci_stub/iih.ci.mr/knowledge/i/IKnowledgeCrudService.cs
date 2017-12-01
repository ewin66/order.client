using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.knowledge.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.knowledge.i
{
    public interface IKnowledgeCrudService
    {
        void delete(KnowledgeDO[] dos);
        KnowledgeDO[] insert(KnowledgeDO[] dos);
        KnowledgeDO[] save(KnowledgeDO[] dos);
        KnowledgeDO[] update(KnowledgeDO[] dos);
        void logicDelete(KnowledgeDO[] dos);
        KnowledgeDO findById(String id);
        KnowledgeDO[] findByIds(String[] ids, FBoolean isLazy);
        KnowledgeDO[] findByBIds(String[] ids, FBoolean isLazy);
        KnowledgeDO[] find(String condition, string orderStr, FBoolean isLazy);
        KnowledgeDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<KnowledgeDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    KnowledgeDO[] enableWithoutFilter(KnowledgeDO[] dos) ;
	    DOWithErrLog enableDO(KnowledgeDO[] dos) ;
	    KnowledgeDO[] disableVOWithoutFilter(KnowledgeDO[] dos);
	    DOWithErrLog disableDO(KnowledgeDO[] dos) ;
	    PagingRtnData<KnowledgeDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    KnowledgeDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    KnowledgeDO[] findByAttrValString(String attr, String value);
	    KnowledgeDO[] findByAttrValStrings(String attr, String[] values);
	    KnowledgeDO[] findByAttrValList(String attr, FArrayList values);
    }
}