using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.ciorderprn.action
{
    public class AdjustAction : XBroadcastAction
    {
        public AdjustAction()
            : base(UIEvent.REFRESH, UIEvent.REFRESH, Keys.None, "调整",
                       "刷新"
                   )
        {
        }
    }
}
