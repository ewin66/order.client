using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    class OpCancelDiAction : XBroadcastAction
    {
        public OpCancelDiAction()
            : base("OpCancelDi", "OpCancelDi", Keys.None, "取消接诊",
                "取消接诊"
                ) { }
    
    }
    
}
