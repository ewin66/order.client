/*======================================================================
* Filename: ICiMrRecallEntRService
* Date: 2017/5/8 17:26:54
* Compiler: Visual Studio 2010
* Author: 张静波
* Company: Copyright 2017 by PKU healthcare IT Co.,Ltd.
* Description: 
*======================================================================
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.cimrrecallentdto.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;
using xap.rui.control.querycontrol;

namespace iih.ci.iih.ci.mrqc.cimrrecallentdto.i
{
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
	  CiMrRecallEntDTO[] GetCiMrRecallEntDTOs(String dt_ent,String id_deps ,String code_ents ,String pat_names ) ;

      PagingRtnData<CiMrRecallEntDTO> GetCiMrRecallEntDTOsFromNode(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
}
}
