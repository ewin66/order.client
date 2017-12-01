using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.action
{
    class EnOverAction : XBroadcastAction
    {
        public EnOverAction() 
            : base("EnOver", "EnOver", Keys.None, "诊毕",
                "诊毕"
                )
        {

        }
    }
}
