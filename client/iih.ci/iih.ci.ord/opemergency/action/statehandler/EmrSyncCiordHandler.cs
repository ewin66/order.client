﻿
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.statehandlers;
using xap.rui.engine.xactions;
using xap.rui.engine;
using iih.ci.ord.opemergency.action.costant;
using iih.ci.ord.opemergency.tool;

namespace iih.ci.ord.opemergency.action.statehandler
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action.statehandler    </para>    
    /// <para>类 名 称 :  EmrSyncCiordHandler					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/8/31 9:02:46             </para>
    /// <para>更新时间 :  2017/8/31 9:02:46             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EmrSyncCiordHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, System.Collections.Generic.Dictionary<string, object> data, xap.rui.engine.BaseContext baseContext)
        {
            var action = sender as XBroadcastAction;
            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    action.Visible = true;
                    break;
                case OpActionConstant.OP_CANCEL_REVERT_VISIBLE_ACTION:
                    string strParam = SysParamUtils.getSysParam().SYS_PARAM_OpOrSysncro2MrHandleMode.DeptParam;
                    action.Visible = "1".Equals(strParam);
                    break;
                default:
                    break;
            }
        }
    }
}
