using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.container;
using xap.cli.sdk.controller.action;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.statehandler
{
    class OrdConfirmStateHandlr : IXStateHandler
    {

        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {

            var action = sender as XBroadcastAction;
            switch (newState)
            {
                //case UIState.EDIT:
                //    action.Visible = false;
                //    break;
                //case UIState.VIEW:
                //    action.Visible = false;
                //    break;
                //case UIState.INIT:
                //    action.Visible = true;
                //    action.Enabled = true;
                //    break;
                //case UIState.NODE_SELECTED:
                //    action.Enabled = true;
                //    break;
                default:
                    //action.Enabled = false;
                    //action.Visible = false;
                    action.Enabled = true;
                    break;
            }


        }
    }
}
