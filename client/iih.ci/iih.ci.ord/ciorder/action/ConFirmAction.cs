using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.action
{
   public  class ConFirmAction : XBroadcastAction
    {
       public ConFirmAction()
           : base("confirm", "confirm", Keys.F8, "确认", "确认")
       {
       }
    }
}
