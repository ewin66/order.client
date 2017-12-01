using System;
using xap.rui.engine.statehandlers;
using System.Collections.Generic;
using xap.rui.engine;
using xap.rui.engine.xactions;
using iih.ci.ord.dicertificate.viewmodel;

namespace iih.ci.ord.dicertificate.statehandler
{
    public class PrintStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {
            XBroadcastAction action = sender as XBroadcastAction;
            switch (uiEvent)
            {
                case UIEvent.SAVE:
                case Utils.SELECTROWONLYSAVED:
                case Utils.SELECTROWITEM:
                    action.Visible = true;
                    action.Enabled = true;
                    break;
                case UIEvent.DELETE:
                case UIEvent.PRINT:
                case Utils.TOADD:
                case Utils.TOSAVE:
                case Utils.SAVESUCESS:
                case Utils.PRINTSUCESS:
                    break;
                default:
                    action.Visible = true;
                    action.Enabled = false;
                    break;
            }
        }
    }
}
