using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.bc.udi;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.container;
using xap.cli.sdk.controller.action;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.statehandler
{
    class StopStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {

            XBroadcastAction action = sender as XBroadcastAction;
            switch (uiEvent)
            {
                case CiDictCodeConst.SD_SU_CHECKTHROUGH:
                    action.Enabled = true;
                    break;
                default:
                    action.Enabled = false;
                    break;
            }


        }
    }
}