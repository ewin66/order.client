using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action.statehandler
{
    public class OpPreCalcFeeActionStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, System.Collections.Generic.Dictionary<string, object> data, xap.rui.engine.BaseContext baseContext)
        {
            var action = sender as XBroadcastAction;
            switch (uiEvent)
            {// UIEvent.LOAD事件统一放到OpActionStatusHandler中处理
                case UIEvent.LOAD:
                   // action.Visible = false;
                    break;

            }
        }
    }
    public class OpPresCancelFeeActionStateHandler : IXStateHandler
    {

        public void HandleState(object sender, string oldState, string uiEvent, string newState, System.Collections.Generic.Dictionary<string, object> data, xap.rui.engine.BaseContext baseContext)
        {
            var action = sender as XBroadcastAction;
            switch (uiEvent)
            {// UIEvent.LOAD事件统一放到OpActionStatusHandler中处理
                case UIEvent.LOAD:
                    //action.Visible = false;
                    break;

            }
        }
    }
}
