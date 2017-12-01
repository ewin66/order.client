using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.action
{
    class CiCancelSubmitAction : XBroadcastAction
    {
        public CiCancelSubmitAction()
            : base("CancelSubmit", "CancelSubmit", Keys.None, "撤回",
                "撤销"
                )
        {

        }
    }
}
