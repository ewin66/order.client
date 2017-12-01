using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.action
{
    public class CancelAction : XBroadcastAction
    {
        public CancelAction()
            : base("Cancel", "Cancel", Keys.F12, "取消", "取消")
        {
        }
    }
}
