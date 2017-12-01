using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    class OpCallingAction : XBroadcastAction
    {
        public OpCallingAction()
            : base("OpCalling", "OpCalling", Keys.None, "呼叫",
                "呼叫"
                ) { }
    }
    
}
