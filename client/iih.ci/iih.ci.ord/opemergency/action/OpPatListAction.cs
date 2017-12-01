using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class OpPatListAction : XBroadcastAction
    {
        public OpPatListAction()
            : base("OpPatList", "OpPatList", Keys.None, "患者列表",
                "患者列表"
                ) { }
    }
}
