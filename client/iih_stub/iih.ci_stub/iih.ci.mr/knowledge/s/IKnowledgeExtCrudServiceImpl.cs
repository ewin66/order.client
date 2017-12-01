using System.Collections.Generic;
using iih.ci.mr.knowledge.d;
using iih.ci.mr.knowledgetype.d;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.knowledge.i
{
    /// <summary>
    /// 知识库模板扩展服务
    /// <para>author: hao_wu</para>
    /// </summary>
    class IKnowledgeExtCrudServiceImpl : IKnowledgeExtCrudService
    {
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.knowledge.i.IKnowledgeExtCudService";//ConfigUtil.getServiceUrl();
        private string url_r = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.knowledge.i.IKnowledgeExtRService";//ConfigUtil.getServiceUrl();

        private ServiceInvocation si;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IKnowledgeExtCrudServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public PagingRtnData<KnowledgeDO> FindPagingByQcondAndKnowledgeType(int attribute, KnowledgeTypeDO knowledgeTypeDo, QryRootNodeDTO qryRootNodeDto,
            PaginationInfo pg)
        {
            List<object> param = new List<object>();
            param.Add(attribute);
            param.Add(knowledgeTypeDo);
            param.Add(qryRootNodeDto);
            param.Add(pg);
            si.url = url_r;
            PagingRtnData<KnowledgeDO> rtn = si.invokePaging<KnowledgeDO>("FindPagingByQcondAndKnowledgeType", param.ToArray());
            return rtn;
        }

        public int GetNewSortNoByKnowledgeType(KnowledgeTypeDO knowledgeTypeDo)
        {
            List<object> param = new List<object>();
            param.Add(knowledgeTypeDo);
            si.url = url_r;
            int rtn = si.invoke<int>("GetNewSortNoByKnowledgeType", param.ToArray());
            return rtn;
        }
    }
}
