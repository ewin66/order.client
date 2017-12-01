using System;
using System.Collections.Generic;
using System.Linq;

using iih.ci.mr.d;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.mr.cimrsign.i
{
    public interface ICiMrSignService
    {
   
        /// <summary>
        /// 根据当前登录用用户的ID及状态获取审签的任务
        /// </summary>
        /// <param name="id_user"> 登录用户的ID</param>
        /// <returns>MrSginDTO[] </returns>
        PagingRtnData<MrSginDTO> getMrSignDTO(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);

      // MrSginDTO[] getMrSigndto();
    }
}
