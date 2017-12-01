using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.bc.udi;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciconsresponse.statehandler
{
    class SubmitStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {
            XBroadcastAction action = sender as XBroadcastAction;
            switch (uiEvent)
            {
                case UIEvent.SAVE:
                case CiDictCodeConst.SD_SU_RPT_OPEN:
                    action.Visible = true;
                    action.Enabled = true;
                    break;
                case "unity":
                    action.Visible = true;
                    action.Enabled = false;
                    break;
                case "complete":
                case "conscom":
                case "print":
                    break;
                default:
                    action.Visible = true;
                    action.Enabled = false;
                    break;
            }


        }
    }
}