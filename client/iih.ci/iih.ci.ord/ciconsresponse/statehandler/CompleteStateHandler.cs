using System;
using System.Collections.Generic;
using System.Linq;
using iih.bd.bc.udi;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.container;
using xap.cli.sdk.controller.action;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciconsresponse.statehandler
{
    class CompleteStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {
            XBroadcastAction action = sender as XBroadcastAction;
            switch (uiEvent)
            {
                case "complete":
                case CiDictCodeConst.SD_SU_RPT_SIGN:
                    action.Visible = true;
                    action.Enabled = true;
                    break;
                case "unity":
                  action.Visible = true;
                    action.Enabled = false;
                    break;
                case "0":
                case "ununity":
                case "conscom":
                case UIEvent.SAVE:
                case UIEvent.SUBMIT:
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