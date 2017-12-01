using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.action
{
    public class CiVideoAction : XBroadcastAction
    {
        public CiVideoAction()
            : base("CiVideo", "CiVideo", Keys.None, "影像",
                "影像"
                )
        {
        }
    }
}
