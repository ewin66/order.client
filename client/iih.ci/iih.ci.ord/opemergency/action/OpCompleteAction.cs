using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class OpCompleteAction  : XBroadcastAction
    {
        public OpCompleteAction()
            : base("OpComplete","OpComplete", Keys.None, "诊毕",
                "完成"
                ){}
    }
}
