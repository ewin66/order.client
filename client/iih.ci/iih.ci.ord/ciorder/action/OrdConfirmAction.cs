using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using xap.rui.engine;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.action
{
   public class OrdConfirmAction : XBroadcastAction
    {

       public OrdConfirmAction()
           : base("Ordfirm", "Ordfirm", Keys.None, "医嘱确认",
                       "医嘱确认"
                       )
            {
            }
    }
}
