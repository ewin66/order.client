using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.ciconsresponse.action
{
    class ConsDepResAction : XBroadcastAction
    {
        public ConsDepResAction()
            : base("consres", "consres", Keys.None, "科室应答",
                "医嘱确认"
                )
        {

        }
    }
}
