
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.statehandlers;
using iih.ci.ord.opemergency.emreditor.viewmodel;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.action.statehandler
{
    /// <summary>
    /// <para>描    述 : </para>
    /// <para>说    明 : </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action.statehandler    </para>    
    /// <para>类 名 称 :  OpRevokeEnStateHandler					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/8/9 16:01:31</para>
    /// <para>更新时间 :  2016/8/9 16:01:31</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpRevokeEnStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {

            var action = sender as OpRevokeEnAction;
            if (action != null)
            {
                switch (uiEvent)
                {
                    case UIEvent.LOAD:
                        action.Visible = true;
                        action.Enabled = false;
                        break;
                    case EmrEditorConst.OPREVOKEEN_ACTION_OPERABLE:
                        action.Visible = true;
                        action.Enabled = true;
                        break;
                    case EmrEditorConst.OPREVOKEEN_ACTION_READONLY:
                        action.Visible = true;
                        action.Enabled = false;
                        break;
                    case EmrEditorConst.OPREVOKEEN_ACTION_HIDDEN:
                        action.Visible = true;
                        action.Enabled = false;
                        break;

                }
            }



        }
    }
}
