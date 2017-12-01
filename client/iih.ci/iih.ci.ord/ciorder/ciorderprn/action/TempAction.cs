
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;
using iih.ci.ord.ciorder.ciorderprn.viewmodel;

namespace iih.ci.ord.ciorder.ciorderprn.action
{
    public class TempAction : XBroadcastAction
    {
        public TempAction()
            : base(OrdPrintConst.TEMPACTION, OrdPrintConst.TEMPACTION, Keys.None, "临时医嘱单",
                       "住院医嘱"
                   )
        {
        }
    }
}
