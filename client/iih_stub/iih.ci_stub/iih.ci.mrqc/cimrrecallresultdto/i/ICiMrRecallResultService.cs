/*======================================================================
* Filename: ICiMrRecallResultService
* Date: 2017/5/12 20:30:32
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
using xap.mw.core.data;
using iih.ci.mrqc.cimrrecallresultdto.d;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.iih.ci.mrqc.cimrrecallresultdto.i
{
    public interface ICiMrRecallResultService
    {
        /// <summary>
        /// 获取查阅列表
        /// </summary>
        /// <param name="qryRootNodeDTO"></param>
        /// <param name="paginationInfo"></param>
        /// <returns></returns>
         PagingRtnData<CiMrRecallResultDTO> GetCiMrRecallResults(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);

        /// <summary>
        /// 获取驳回列表
        /// </summary>
        /// <param name="qryRootNodeDTO"></param>
        /// <param name="paginationInfo"></param>
        /// <returns></returns>
         PagingRtnData<CiMrRecallResultDTO> GetCiMrRecallResults4MySelf(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo);
    }
}
