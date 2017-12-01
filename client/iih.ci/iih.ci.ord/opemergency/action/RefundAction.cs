using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class RefundAction: XBroadcastAction
    {
        public RefundAction()
            : base("RefundAction", "RefundAction", Keys.None, "退费",
                "退费"
                )
        {
            
        }
    }
}
