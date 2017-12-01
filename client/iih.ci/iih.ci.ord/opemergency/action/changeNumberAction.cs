using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class changeNumberAction: XBroadcastAction
    {
        public changeNumberAction()
            : base("changeNumberAction", "changeNumberAction", Keys.None, "换号",
                "换号"
                )
        {
            
        }
    }
}

