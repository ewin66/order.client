using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using xap.rui.engine;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.action
{
    class CipresAction : XBroadcastAction
    {
        public CipresAction()
            : base("Cipres", "Cipres", Keys.None, "打印",
                       "打印预览"
                       )
            {
            }
    }
}
