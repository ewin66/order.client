using System;
using System.Collections.Generic;
using System.Linq;
using xap.rui.engine;
using xap.rui.engine.statehandlers;
using xap.rui.engine.container;
using xap.cli.sdk.controller.action;
using xap.rui.engine.xactions;
using xap.rui.engine.xactions.standard;
using iih.ci.ord.ciorder.cards.extend;
namespace iih.ci.ord.ciorder.statehandler
{
    class RefreshStateHandler : IXStateHandler
    {
        private bool ViewEditState = true;
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {

            var action = sender as XBroadcastAction;
            switch (uiEvent)
            {
                case "Reload":
                    return;
                default:
                    if (!ViewEditState)
                    {
                        action.Visible = true;
                        action.Enabled = false;
                    }
                    else {

                        if (uiEvent == "IsReadOnly")
                        {
                            action.Visible = true;
                            action.Enabled = false;
                            ViewEditState = false;
                        }else if(uiEvent == "NoData"){
                            if (sender is RefreshAction)
                            {
                                action.Visible = true;
                                action.Enabled = true;
                            }
                            else {
                                action.Visible = true;
                                action.Enabled = false;
                            }
                        }
                        else if (uiEvent == "HasData") {
                            action.Visible = true;
                            action.Enabled = true;
                        }
                        else
                        {
                            if (data != null)
                            {
                                if (data.ContainsKey("newListSelected") && data["newListSelected"] != null && (data["newListSelected"] is OrScArgs))
                                {
                                    return;
                                }
                            }
                            if (uiEvent.Equals("Refresh"))
                            {
                                return;
                            }
                            action.Visible = true;
                            action.Enabled = true;
                        }
                    }
                    break;
            }


        }
    }
}