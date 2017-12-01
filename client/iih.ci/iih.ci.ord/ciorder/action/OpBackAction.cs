using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.action
{
    class OpBackAction : XBroadcastAction
    {
        public OpBackAction()
            : base("OpBack", "OpBack", Keys.None, "撤回",
                "撤销"
                )
        {

        }
    }
}
