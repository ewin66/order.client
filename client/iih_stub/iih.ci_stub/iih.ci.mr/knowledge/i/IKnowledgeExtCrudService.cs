using iih.ci.mr.knowledge.d;
using iih.ci.mr.knowledgetype.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.knowledge.i
{
    /// <summary>
    /// 知识库模板扩展服务接口
    /// <para>author: hao_wu</para>
    /// </summary>
    public interface IKnowledgeExtCrudService
    {
        /// <summary>
        /// 根据查询方案和知识库模板分类查询知识库模板分页数据
        /// </summary>
        /// <param name="attribute">所属科室还是个人</param>
        /// <param name="knowledgeTypeDo">知识库模板分类</param>
        /// <param name="qryRootNodeDto">查询方案</param>
        /// <param name="pg">分页信息</param>
        /// <returns>知识库模板分页数据</returns>
        PagingRtnData<KnowledgeDO> FindPagingByQcondAndKnowledgeType(int attribute, KnowledgeTypeDO knowledgeTypeDo, QryRootNodeDTO qryRootNodeDto,
            PaginationInfo pg);

        /// <summary>
        /// 获取知识库模板分类下新序号
        /// </summary>
        /// <param name="knowledgeTypeDo">知识库模板分类</param>
        /// <returns>新序号</returns>
        int GetNewSortNoByKnowledgeType(KnowledgeTypeDO knowledgeTypeDo);
    }
}
