package iih.ci.mr.i;

import iih.ci.mr.d.MrSginDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ICiMrSignService {

	/**
	 * 根据当前登录用用户的ID及状态获取审签的任务
	 * 
	 * @param id_user
	 *            登录用户的ID
	 * @return MrSginDTO[]
	 * @throws BizException
	 */
	public abstract PagingRtnData<MrSginDTO> getMrSignDTO(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException;

	// /**
	// * 根据当前登录用用户的ID及状态获取审签的任务
	// * @param qryRootNodeDTO
	// * @return MrSginDTO[]
	// * @throws BizException
	// */
	// public abstract MrSginDTO[] getMrSigndto(QryRootNodeDTO qryRootNodeDTO)
	// throws BizException;
	//
}
