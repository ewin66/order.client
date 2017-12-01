package iih.ci.mrqc.cimrrecallentdto.i;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mrqc.cimrrecallentdto.d.CiMrRecallEntDTO;

/**
* 病历召回申请数据维护服务
*/
public interface ICiMrRecallEntRService {
	
	 /**
	  * 
	  * @param dt_ent_start就诊时间范围，用逗号隔开最小和最大时间
	  * @param id_deps 就诊部门
	  * @param id_ents 就诊号
	  * @param pat_names 姓名
	  * @return
	  * @throws BizException
	  */
	  CiMrRecallEntDTO[] GetCiMrRecallEntDTOs(String dt_ent,String id_deps ,String code_ents ,String pat_names ) throws BizException;

     PagingRtnData<CiMrRecallEntDTO> GetCiMrRecallEntDTOsFromNode(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException;
}