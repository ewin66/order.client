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
    class SaveAddStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {

            XBroadcastAction action = sender as XBroadcastAction;
            switch (newState)
            {
                case UIState.EDIT:
                    action.Visible = true;
                    action.Enabled = true;
                    break;
                case UIState.VIEW:
                    action.Visible = true;
                    action.Enabled = false;
                    break;
                default:
                    action.Visible = false;
                    break;
            }


        }
    }
}