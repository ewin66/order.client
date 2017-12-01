using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    class OpOtherAction : XBroadcastAction
    {
        public OpOtherAction()
            : base("OpOther", "OpOther", Keys.None, "其他",
                "其他"
                ) { }
    }
    
}
