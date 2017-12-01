using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    internal class entAppointmentAction : XBroadcastAction
    {
        public entAppointmentAction()
            : base("entAppointmentAction", "entAppointmentAction", Keys.None, "诊间预约",
                "诊间预约"
                )
        {

        }
    }
}
