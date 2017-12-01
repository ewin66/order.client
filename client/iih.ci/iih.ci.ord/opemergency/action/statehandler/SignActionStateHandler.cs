using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action.statehandler
{
    /// <summary>
    /// <para>描    述 :  签署按钮状态控制器     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action.statehandler    </para>    
    /// <para>类 名 称 :  SignActionStateHandler					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  8/24/2016 7:49:43 AM             </para>
    /// <para>更新时间 :  8/24/2016 7:49:43 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class SignActionStateHandler : IXStateHandler
    {
        public const String Event_Enable_Sign  = "Event_Enable_Sign";
        public const String Event_Disable_Sign = "Event_Disable_Sign";
        public void HandleState(object sender, string oldState, string uiEvent, string newState, System.Collections.Generic.Dictionary<string, object> data, xap.rui.engine.BaseContext baseContext)
        {
            var action = sender as XBroadcastAction;
            switch (uiEvent)
            {// UIEvent.LOAD事件统一放到OpActionStatusHandler中处理
                case UIEvent.LOAD:
                    break;
                case Event_Enable_Sign:
                   
                    action.Enabled = true;
                    break;
                case Event_Disable_Sign:
                    
                    action.Enabled = false;
                    break;               
                default:
                    break;
            }
        }
    }
}
