using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.ciorderprn.action
{
    public class PrintAction : XBroadcastAction
    {
        public PrintAction()
            : base(UIEvent.PRINT, UIEvent.PRINT, Keys.None, "打印",
                       "打印"
                   )
        {
        }
    }
}
