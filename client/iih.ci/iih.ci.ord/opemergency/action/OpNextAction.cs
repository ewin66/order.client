using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class OpNextAction : XBroadcastAction
    {
        public OpNextAction()
            : base("OpNext", "OpNext", Keys.None, "下一位",
                "下一位"
                ) { }
    }
}
