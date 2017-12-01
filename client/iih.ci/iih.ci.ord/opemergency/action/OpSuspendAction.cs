using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    class OpSuspendAction : XBroadcastAction
    {
        public OpSuspendAction()
            : base("OpSuspend", "OpSuspend", Keys.None, "待回诊",
                "暂停"
                ){}
    }
}
