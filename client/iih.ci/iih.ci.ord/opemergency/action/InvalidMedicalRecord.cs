using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class InvalidMedicalRecord: XBroadcastAction
    {
        public InvalidMedicalRecord()
            : base("InvalidMedicalRecord", "InvalidMedicalRecord", Keys.None, "作废病历",
                "作废病历"
                )
        {
            
        }
    }
}
