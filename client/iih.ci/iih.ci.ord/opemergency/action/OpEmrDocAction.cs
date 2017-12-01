using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class OpEmrDocAction : XBroadcastAction
    {
        public OpEmrDocAction()
            : base("OpEmrDoc", "OpEmrDoc", Keys.None, "工作表单",
                "工作表单"
                ) { }
    }
}
