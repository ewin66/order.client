using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using xap.cli.sdk.layouts;
using xap.rui.engine;
using xap.rui.engine.statehandlers;

namespace iih.ci.ord.ciorder.statehandler
{
    class PanelManagerStateHandler : IXStateHandler
    {
  

        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data,BaseContext baseContext)
        {
            PanelManager panelManager = sender as PanelManager;
            string state = newState;
            switch (uiEvent)
            {
                case UIState.INIT:
                    panelManager.SelectedIndex = 0;
                    break;
                case UIState.EDIT:
                    panelManager.SelectedIndex = 1;
                    break;
                case "Ordfirm":
                case UIState.VIEW:
                    panelManager.SelectedIndex = 1;
                    break;
              
                default:
                    panelManager.SelectedIndex = 0;
                    break;
            }
        }
    }
}
