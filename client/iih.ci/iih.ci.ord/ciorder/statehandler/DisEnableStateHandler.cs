using System;
using System.Collections.Generic;
using System.Linq;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.container;
using xap.cli.sdk.controller.action;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.statehandler
{
    class DisEnableStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {

            XBroadcastAction action = sender as XBroadcastAction;
            switch (newState)
            {
                case UIState.INIT:
                    action.Visible = true;
                    action.Enabled = false;
                    break;
                case UIState.ROW_SELECTED:
                    action.Visible = true;
                    action.Enabled = true;
                    break;
                default:
                    action.Visible = false;
                    break;
            }


        }
    }
}