using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.ciorderprn.action
{
    public class SetupAction : XBroadcastAction
    {
        public SetupAction()
            : base(UIEvent.EDIT, UIEvent.EDIT, Keys.None, "设置",
                       "设置默认"
                   )
        {
        }
    }
}
