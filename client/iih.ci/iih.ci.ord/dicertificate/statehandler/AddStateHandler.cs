using System;
using xap.rui.engine.statehandlers;
using xap.rui.engine.xactions;
using System.Collections.Generic;
using xap.rui.engine;
using iih.ci.ord.dicertificate.viewmodel;

namespace iih.ci.ord.dicertificate.statehandler
{
    public class AddStateHandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {
            XBroadcastAction action = sender as XBroadcastAction;
            switch (uiEvent)
            {
                case UIEvent.DELETE:
                case UIEvent.SAVE:
                case UIEvent.PRINT:
                case Utils.TOADD:
                case Utils.TOSAVE:
                case Utils.SAVESUCESS:
                case Utils.PRINTSUCESS:
                    break;
                case Utils.SELECTROWNOTONLY:
                    action.Visible = true;
                    action.Enabled = true;
                    break;
                default:
                    action.Visible = true;
                    action.Enabled = false;
                    break;
            }
        }
    }
}
