
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using xap.rui.engine;
using System.Windows.Forms;
using iih.ci.ord.ciorder.ciorderprn.viewmodel;

namespace iih.ci.ord.ciorder.ciorderprn.action
{
    public class LongAction : XBroadcastAction
    {
        public LongAction()
            : base(OrdPrintConst.LONGACTION, OrdPrintConst.LONGACTION, Keys.None, "长期医嘱单",
                       "住院医嘱"
                   )
        {
        }
    }
}
