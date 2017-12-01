using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.xactions;
using iih.ci.ord.opemergency.action.costant;

namespace iih.ci.ord.opemergency.action.statehandler
{
    /// <summary>
    /// <para>描    述 :  撤销签署状态处理                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action.statehandler    </para>    
    /// <para>类 名 称 :  OpRevertSignStateHandler					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  10/10/2016 12:04:09 PM             </para>
    /// <para>更新时间 :  10/10/2016 12:04:09 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpRevertSignStateHandler : IXStateHandler
    {
        public const String Event_Enable_UnSign  = "Event_Enable_UnSign";
        public const String Event_Disable_UnSign = "Event_Disable_UnSign";
        public void HandleState(object sender, string oldState, string uiEvent, string newState, System.Collections.Generic.Dictionary<string, object> data, xap.rui.engine.BaseContext baseContext)
        {
            var action = sender as XBroadcastAction;
            switch (uiEvent)
            {// UIEvent.LOAD事件统一放到OpActionStatusHandler中处理
                case UIEvent.LOAD:
                    action.Visible = true;
                    break;
                case OpActionConstant.OP_CANCEL_REVERT_VISIBLE_ACTION:
                    string strParam = data[OpActionConstant.OP_CANCEL_REVERT_VISIBLE_ACTION] as string;
                    action.Visible = String.IsNullOrEmpty(strParam) || "00".Equals(strParam);
                    break;
                case Event_Enable_UnSign:
                    action.Enabled = true;
                    break;
                case Event_Disable_UnSign:

                    action.Enabled = false;
                    break;
                case "ListSelected":
                    action.Enabled = true;
                    break;
                default:
                    break;
            }
        }
    }
}
