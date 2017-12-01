package iih.ci.rcm.contagion.i;

import iih.ci.rcm.contagion.dto.d.Contagiondto;
import iih.ci.rcm.contagion.dto.d.EntDto;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 组件数据维护服务
 */
public interface IContagionCudServiceExt {
	/**
	 * 查询传染上报卡DTO
	 */
	public abstract Contagiondto[] getCotagions(String id_ent)
			throws BizException;

	/**
	 * 查询传染上报卡DTO
	 */
	public abstract Contagiondto[] getCotagionlist(String id_ent)
			throws BizException;

	/**
	 * 查询传染上报卡DTO
	 */
	public abstract Contagiondto[] getChildCotagions(String p_id)
			throws BizException;

	/**
	 * 查询有上报卡审核的就诊DTO
	 */
	public abstract EntDto[] getEnts(QryRootNodeDTO qryRootNodeDTO)
			throws BizException;

	/**
	 * 查询漏报的就诊DTO
	 */
	public abstract EntDto[] getEnts2(QryRootNodeDTO qryRootNodeDTO)
			throws BizException;

	/*
	 * 分页查询传染漏报列表数据
	 */
	public abstract PagingRtnData<EntDto> getEntDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException;

	public abstract EntDto[] getAllPageData() throws BizException;
}
