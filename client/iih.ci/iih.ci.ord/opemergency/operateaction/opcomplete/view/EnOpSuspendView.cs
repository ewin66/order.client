
using iih.ci.ord.opemergency.operateaction.baseoperate;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.operateaction.dto;

namespace iih.ci.ord.opemergency.operateaction.opcomplete.view
{
    /// <summary>
    /// <para>描    述 :  触发当前患者就诊待回诊处理</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.opcomplete.view</para>    
    /// <para>类 名 称 :  EnOpSuspendView</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/7 13:36:18</para>
    /// <para>更新时间 :  2016/12/7 13:36:18</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EnOpSuspendView : AbstractActionHandler
    {
        protected override void DoSendAction(RequestParam request, ResponseParam response)
        {
            this.FireBizEventSent(this, OpOperateActionEvent.EN_PAT_SUSPEND, null, null);
            this.DoReceiveAction(request, response);
        }
    }
}
