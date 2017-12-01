package iih.ci.mr.knowledge.i;

import iih.ci.mr.knowledge.d.KnowledgeDO;
import iih.ci.mr.knowledgetype.d.Attribute;
import iih.ci.mr.knowledgetype.d.KnowledgeTypeDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 知识库模板扩展查询服务
 * 
 * @author hao_wu
 *
 */
public interface IKnowledgeExtRService {

	/**
	 * 根据查询方案和知识库模板分类查询知识库模板分页数据
	 * 
	 * @param attribute
	 *            所属科室还是个人
	 * @param knowledgeTypeDo
	 *            知识库模板分类
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param pg
	 *            分页信息
	 * @return 知识库模板分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<KnowledgeDO> FindPagingByQcondAndKnowledgeType(Integer attribute,
			KnowledgeTypeDO knowledgeTypeDo, QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException;

	/**
	 * 获取知识库模板分类下新序号
	 * 
	 * @param knowledgeTypeDo
	 *            知识库模板分类
	 * @return 新序号
	 * @throws BizException
	 */
	public abstract Integer GetNewSortNoByKnowledgeType(KnowledgeTypeDO knowledgeTypeDo) throws BizException;

}
