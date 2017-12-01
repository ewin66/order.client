package iih.ci.mr.i;

import iih.ci.mr.auditdto.d.AuditDTO;
import iih.ci.mr.cimripbasedto.d.CiMrIPBaseDTO;
import iih.ci.mr.cimrpatinfodto.d.CiMrPatInfoDTO;
import iih.ci.mr.secinfodto.d.SecInfoDTO;
import xap.mw.core.data.BizException;

public interface ICiMrIPService {

	
	/**
	 * 获取集成平台需要的基本信息(ryp)
	 * 
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrIPBaseDTO[] getCiMrIPBaseDTO(String id_mr) throws BizException;
	
	public abstract AuditDTO[] getAuditDTO(String id_mr) throws BizException;
	
	public abstract SecInfoDTO[] getSecInfoDTO(String id_mr) throws BizException;
	
	public abstract SecInfoDTO[] getSecInfoDTOForInsertAfter(String id_en) throws BizException;
	
	public abstract CiMrPatInfoDTO[] getCiMrPatInfoDTO(String id_ent) throws BizException;
	
}
