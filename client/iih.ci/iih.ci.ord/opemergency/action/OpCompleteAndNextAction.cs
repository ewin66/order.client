using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class OpCompleteAndNextAction: XBroadcastAction
    {
        public OpCompleteAndNextAction()
            : base("OpCompleteAndNextAction", "OpCompleteAndNextAction", Keys.None, "诊毕并叫下一个",
                "完成并下一个"
                ){}
    }
}
