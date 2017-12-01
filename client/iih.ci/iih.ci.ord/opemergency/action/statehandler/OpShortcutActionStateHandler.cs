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
    /// <para>描    述 :  医嘱模板快捷键的事件     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action.statehandler    </para>    
    /// <para>类 名 称 :  SignActionStateHandler					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :           				</para> 
    /// <para>修 改 人 :           				</para> 
    /// <para>创建时间 :             </para>
    /// <para>更新时间 :            </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpShortcutActionStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, System.Collections.Generic.Dictionary<string, object> data, xap.rui.engine.BaseContext baseContext)
        {
            var action = sender as XBroadcastAction;
            switch (uiEvent)
            {
                default:
                    action.Visible = false;
                    break;
            }
        }
    }
}
