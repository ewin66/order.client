using System;
using System.Data;
using xap.mw.coreitf.d;
using xap.mw.core.data; 
using xap.sys.appfw.tmpl.qryscheme;
using iih.ci.mr.knowledgetype.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.knowledgetype.i
{
    public interface IKnowledgetypeCrudService
    {
        void delete(KnowledgeTypeDO[] dos);
        KnowledgeTypeDO[] insert(KnowledgeTypeDO[] dos);
        KnowledgeTypeDO[] save(KnowledgeTypeDO[] dos);
        KnowledgeTypeDO[] update(KnowledgeTypeDO[] dos);
        void logicDelete(KnowledgeTypeDO[] dos);
        KnowledgeTypeDO findById(String id);
        KnowledgeTypeDO[] findByIds(String[] ids, FBoolean isLazy);
        KnowledgeTypeDO[] findByBIds(String[] ids, FBoolean isLazy);
        KnowledgeTypeDO[] find(String condition, string orderStr, FBoolean isLazy);
        KnowledgeTypeDO[] findByQScheme(IQryScheme qscheme);//暂不用
        PagingRtnData<KnowledgeTypeDO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart);
	    KnowledgeTypeDO[] enableWithoutFilter(KnowledgeTypeDO[] dos) ;
	    DOWithErrLog enableDO(KnowledgeTypeDO[] dos) ;
	    KnowledgeTypeDO[] disableVOWithoutFilter(KnowledgeTypeDO[] dos);
	    DOWithErrLog disableDO(KnowledgeTypeDO[] dos) ;
	    PagingRtnData<KnowledgeTypeDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg);
	    KnowledgeTypeDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy); 
	    KnowledgeTypeDO[] findByAttrValString(String attr, String value);
	    KnowledgeTypeDO[] findByAttrValStrings(String attr, String[] values);
	    KnowledgeTypeDO[] findByAttrValList(String attr, FArrayList values);
    }
}