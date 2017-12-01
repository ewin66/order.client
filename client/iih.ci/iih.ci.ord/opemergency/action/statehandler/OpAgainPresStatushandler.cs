using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.emreditor.viewmodel;
using xap.rui.engine;
using xap.rui.engine.statehandlers;

namespace iih.ci.ord.opemergency.action.statehandler
{
    public class OpAgainPresStatushandler : IXStateHandler
    {
        public void HandleState(object sender, string oldState, string uiEvent, string newState, Dictionary<string, object> data, BaseContext baseContext)
        {

            var action = sender as OpRevokeEnAction;
            if (action != null)
            {
                switch (uiEvent)
                {
                    case UIEvent.LOAD:
                        action.Visible = true;
                        action.Enabled = false;
                        break;
                    case EmrEditorConst.OPREVOKEEN_ACTION_OPERABLE:
                        action.Visible = true;
                        action.Enabled = true;
                        break;
                    case EmrEditorConst.OPREVOKEEN_ACTION_READONLY:
                        action.Visible = true;
                        action.Enabled = false;
                        break;
                    case EmrEditorConst.OPREVOKEEN_ACTION_HIDDEN:
                        action.Visible = true;
                        action.Enabled = false;
                        break;

                }
            }



        }
    }
}
