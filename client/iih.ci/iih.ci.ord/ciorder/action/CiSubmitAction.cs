using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.action
{
    class CiSubmitAction : XBroadcastAction
    {
        public CiSubmitAction()
            : base("CiSubmit", "CiSubmit", Keys.None, "签署",
                "签署"
                )
        {

        }
    }
}
