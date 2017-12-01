using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.action
{
    class EnStayAction : XBroadcastAction
    {
        public EnStayAction()
            : base("EnStay", "EnStay", Keys.None, "急诊留观",
                "撤销"
                )
        {
        }
    }
}
