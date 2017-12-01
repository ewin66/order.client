
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;
using iih.ci.ord.ciorder.ciorderprn.viewmodel;

namespace iih.ci.ord.ciorder.ciorderprn.action
{
    public class OrderAction : XBroadcastAction
    {
        public OrderAction()
            : base(OrdPrintConst.ORDERACTION, OrdPrintConst.ORDERACTION, Keys.None, "医嘱单",
                       "住院医嘱"
                   )
        {
        }
    }
}
