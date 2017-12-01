/*======================================================================
* Filename: ICiMrRecallResultServiceImpl
* Date: 2017/5/12 20:30:54
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
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.iih.ci.mrqc.cimrrecallresultdto.i
{
    public class ICiMrRecallResultServiceImpl:ICiMrRecallResultService
    {

        private string url = XapSvrConfig.BaseUrl + "iihci.mrqc/iih.ci.mrqc.cimrrecallresultdto.i.ICiMrRecallResultService";//ConfigUtil.getServiceUrl();
      
        private ServiceInvocation si;
        private CacheHelper<CiMrRecallResultDTO> ch;

        public ICiMrRecallResultServiceImpl()
        {
          
            ch = new CacheHelper<CiMrRecallResultDTO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 获取查阅列表
        /// </summary>
        /// <param name="qryRootNodeDTO"></param>
        /// <param name="paginationInfo"></param>
        /// <returns></returns>
        public PagingRtnData<CiMrRecallResultDTO> GetCiMrRecallResults(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<CiMrRecallResultDTO> rtn = si.invokePaging<CiMrRecallResultDTO>("getCiMrRecallResults", param.ToArray());

            return rtn;
        }

        /// <summary>
        /// 获取驳回列表
        /// </summary>
        /// <param name="qryRootNodeDTO"></param>
        /// <param name="paginationInfo"></param>
        /// <returns></returns>
        public PagingRtnData<CiMrRecallResultDTO> GetCiMrRecallResults4MySelf(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<CiMrRecallResultDTO> rtn = si.invokePaging<CiMrRecallResultDTO>("getCiMrRecallResults4MySelf", param.ToArray());

            return rtn;
        }
    }
}
