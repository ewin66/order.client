using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class InfectiousDiseaseAction: XBroadcastAction
    {
        public InfectiousDiseaseAction()
            : base("InfectiousDiseaseAction", "InfectiousDiseaseAction", Keys.None, "传染病登记",
                "传染病登记"
                )
        {
            
        }
    }
}
