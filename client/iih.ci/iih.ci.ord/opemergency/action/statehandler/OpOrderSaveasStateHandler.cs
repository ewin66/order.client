
using System;
using xap.rui.engine.statehandlers;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action.statehandler
{
    public class OpOrderSaveasStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, System.Collections.Generic.Dictionary<string, object> data, xap.rui.engine.BaseContext baseContext)
        {
            var action = sender as XBroadcastAction;
            switch (uiEvent)
            {
                case "OrderSaveasAction":
                    break;
                default:
                    break;
            }
        }
    }
}
