
using iih.ci.ord.opemergency.action.costant;
using iih.ci.ord.opemergency.operateaction.baseoperate;
using iih.ci.ord.opemergency.operateaction.dto;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.operateaction.opcomplete.view
{
    /// <summary>
    /// <para>描    述 :  加载打印中心</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.opcomplete.view</para>    
    /// <para>类 名 称 :  LoadPrintCenter</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/11/2 15:04:52</para>
    /// <para>更新时间 :  2016/11/2 15:04:52</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class LoadPrintCenter : AbstractActionHandler
    {


        /// <summary>
        /// 发送加载打印中心事件
        /// </summary>
        /// <param name="request"></param>
        protected override void DoSendAction(RequestParam request, ResponseParam response)
        {
            this.FireBizEventSent(this, OpActionConstant.OP_COMPLETE_PRINT_ACTION, OpOperateActionEvent.PRINT_COMPLETE, null);
        }

        /// <summary>
        /// 接收打印中心状态处理结束事件
        /// </summary>
        /// <param name="dataDic"></param>
        public override void ReceiveBizEvent(Dictionary<string, object> dataDic)
        {
            //包括key值PrintComplete 表示处方打印结束
            if (dataDic.ContainsKey(OpOperateActionEvent.PRINT_COMPLETE))
            {
                this.DoReceiveAction(this.request, this.response);
            }
        }

    }
}
