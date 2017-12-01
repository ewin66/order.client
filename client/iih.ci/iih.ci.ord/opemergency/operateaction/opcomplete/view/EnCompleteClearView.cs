
using iih.ci.ord.opemergency.operateaction.baseoperate;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.operateaction.dto;
using xap.rui.engine.eventbroker;
using xap.rui.engine;
using iih.ci.ord.opemergency.action.costant;

namespace iih.ci.ord.opemergency.operateaction.opcomplete.view
{
    /// <summary>
    /// <para>描    述 :  清空banner事件</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.opcomplete.view</para>    
    /// <para>类 名 称 :  EnCompleteClearView</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/11/1 10:56:08</para>
    /// <para>更新时间 :  2016/11/1 10:56:08</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EnCompleteClearView : AbstractActionHandler
    {

        /// <summary>
        /// 发送清空banner事件
        /// </summary>
        /// <param name="request"></param>
        /// <param name="response"></param>
        protected override void DoSendAction(RequestParam request, ResponseParam response)
        {
            Dictionary<string, object> dataDic = new Dictionary<string, object>();         
            dataDic.Add(OpOperateActionEvent.CLEAR_BANNER, request.actionName);
            this.FireBizEventSent(this, OpOperateActionEvent.CLEAR_BANNER, null, dataDic);
        }
    }
}
