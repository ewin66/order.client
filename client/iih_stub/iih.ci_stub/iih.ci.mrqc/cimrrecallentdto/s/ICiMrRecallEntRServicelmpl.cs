/*======================================================================
* Filename: CiMrRecallEntRService
* Date: 2017/5/8 17:27:23
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
using iih.ci.iih.ci.mrqc.cimrrecallentdto.i;
using iih.ci.mrqc.cimrrecallentdto.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme.qrydto;
using xap.rui.control.querycontrol;
using xap.mw.core.utils;

namespace iih.ci.iih.ci.mrqc.cimrrecallentdto.i
{
    public class ICiMrRecallEntRServiceImpl:ICiMrRecallEntRService
    {

        private string url = XapSvrConfig.BaseUrl + "iihci.mrqc/iih.ci.mrqc.cimrrecallentdto.i.ICiMrRecallEntRService";//ConfigUtil.getServiceUrl();
      
        private ServiceInvocation si;
        private CacheHelper<CiMrRecallEntDTO> ch;

        public ICiMrRecallEntRServiceImpl()
        {
            string str = ConfigUtil.getServiceUrl();
            ch = new CacheHelper<CiMrRecallEntDTO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 获取就诊列表（用于门诊病历召回）
        /// </summary>
        /// <param name="dt_ent">就诊时间范围</param>
        /// <param name="id_deps">就诊科室组</param>
        /// <param name="code_ents">门诊号组</param>
        /// <param name="pat_names">姓名组</param>
        /// <returns></returns>
        public CiMrRecallEntDTO[] GetCiMrRecallEntDTOs(String dt_ent, String id_deps, String code_ents, String pat_names)
        {
            List<object> param = new List<object>();
            //string[] dts = dt_ent.Split(',');
            //string dt_ent_start = dts[0];
            //string dt_ent_end = dts.Length > 0 ? dts[1] : dts[0];
            //param.Add(dt_ent_start);
            //param.Add(dt_ent_end);
            param.Add(dt_ent); 
            param.Add(id_deps);
            param.Add(code_ents);
            param.Add(pat_names);
            si.url = url;
            CiMrRecallEntDTO[] rtn = si.invokeList<CiMrRecallEntDTO>("GetCiMrRecallEntDTOs", param.ToArray());
            return rtn;

        }

        public PagingRtnData<CiMrRecallEntDTO> GetCiMrRecallEntDTOsFromNode(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<CiMrRecallEntDTO> rtn = si.invokePaging<CiMrRecallEntDTO>("GetCiMrRecallEntDTOsFromNode", param.ToArray());

           // PagingRtnData<CiMrRecallEntDTO> rtn = si.invokePaging<CiMrRecallEntDTO>("GetCiMrRecallEntDTOsFromNode", param.ToArray());

            return rtn;
        }
       
    }
}
