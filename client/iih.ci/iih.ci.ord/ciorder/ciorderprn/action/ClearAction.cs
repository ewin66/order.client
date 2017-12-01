using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.ciorderprn.action
{
    public class ClearAction : XBroadcastAction
    {
        public ClearAction()
            : base(UIEvent.DELETE, UIEvent.DELETE, Keys.None, "清空",
                       "删除"
                   )
        {
        }
    }
}
