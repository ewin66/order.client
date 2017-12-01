using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.action
{
    class CiStopAction : XBroadcastAction
    {
        public CiStopAction()
            : base("CiStop", "CiStop", Keys.None, "停止",
                "停止"
                )
        {

        }
    }
}
