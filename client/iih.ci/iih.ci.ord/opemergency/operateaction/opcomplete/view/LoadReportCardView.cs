
using iih.ci.ord.opemergency.operateaction.baseoperate;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.operateaction.dto;
using iih.ci.ord.opemergency.action.costant;
using iih.ci.ord.reportcard;
using xap.mw.coreitf.d;

namespace iih.ci.ord.opemergency.operateaction.opcomplete.view
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.opcomplete.view</para>    
    /// <para>类 名 称 :  LoadReportCardView</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/11/4 8:55:17</para>
    /// <para>更新时间 :  2016/11/4 8:55:17</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class LoadReportCardView : AbstractActionHandler
    {
        /// <summary>
        /// 传染病上报
        /// </summary>
        /// <param name="request"></param>
        protected override void DoSendAction(RequestParam request, ResponseParam response)
        {   
            ReportCardFillJudge report = new ReportCardFillJudge(request.ent4BannerDTO);
            bool fg = report.IsInfectionReport();
            this.DoReceiveAction(this.request, this.response);            
        }        
    }
}
