using System.Collections.Generic;
using iih.bd.bc.udi;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciconsresponse.statehandler
{
    class SaveStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {

            var action = sender as XBroadcastAction;
            switch (uiEvent)
            {
                case UIEvent.SUBMIT:
                case CiDictCodeConst.SD_SU_RPT_SIGN:
                     action.Visible = true;
                     action.Enabled = false;
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
                    action.Enabled = true;
                    break;
            }


        }
    }
}