
using System;
using iih.ci.ord.i.ortmpl;
using iih.bd.srv.ortpl.d;
using iih.bd.srv.ortpl.dto;
using xap.mw.serviceframework;
using System.Collections.Generic;
using iih.ci.iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.ord.ems.d;


namespace iih.ci.ord.i.ortmpl
{
    /// <summary>
    /// <para>描    述 :  医嘱模板加载服务 			</para>
    /// <para>说    明 :  医嘱模板加载服务   			</para>
    /// <para>项目名称 :  iih.ci.ord.i.ortmpl    </para>    
    /// <para>类 名 称 :  OrTmplApplyServiceImpl					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Young         				</para> 
    /// <para>修 改 人 :  Young         				</para> 
    /// <para>创建时间 :  2017/10/19 15:17:16             </para>
    /// <para>更新时间 :  2017/10/19 15:17:16             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class IOrTmplApplyServiceImpl : IOrTmplApplyService
    {
        private readonly string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ortmpl.IOrTmplApplyService";
        private readonly ServiceInvocation si;

        /// <summary>
        /// 构造函数
        /// </summary>
        public IOrTmplApplyServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
        }

        public OrTmplCaDO[] getOrTmplCaDOs(String id_grp, String id_org, String id_dep, String id_emp, String sd_ortmpltp)
        {
            List<object> param = new List<object>();
            param.Add(id_grp);
            param.Add(id_org);
            param.Add(id_dep);
            param.Add(id_emp);
            param.Add(sd_ortmpltp);
            si.url = url_r;
            var result = si.invokeList<OrTmplCaDO>("getOrTmplCaDOs", param.ToArray());
            return result;
        }

        public OrTmplDTO[] getOrTmplDTOs(String id_ortmplca, String sd_ortmpltp)
        {
            List<object> param = new List<object>();
            param.Add(id_ortmplca);
            param.Add(sd_ortmpltp);
            si.url = url_r;
            var result = si.invokeList<OrTmplDTO>("getOrTmplDTOs", param.ToArray());
            return result;
        }

        public OrTplNItmDO[] getOrTplNItmDOs(String id_ortmpl)
        {
            List<object> param = new List<object>();
            param.Add(id_ortmpl);
            si.url = url_r;
            var result = si.invokeList<OrTplNItmDO>("getOrTplNItmDOs", param.ToArray());
            return result;
        }

        public OrderTemplateRstDTO getOrTemplateCache(String[] id_ortmpls, CiEnContextDTO ctx)
        {
            List<object> param = new List<object>();
            param.Add(id_ortmpls);
            param.Add(ctx);
            si.url = url_r;
            var result = si.invoke<OrderTemplateRstDTO>("getOrTemplateCache", param.ToArray());
            return result;
        }
    }
}
