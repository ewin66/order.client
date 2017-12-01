using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    class HospitalNoticeAction: XBroadcastAction
    {
        public HospitalNoticeAction()
            : base("HospitalNoticeAction", "HospitalNoticeAction", Keys.None, "入院申请单",
                "住院通知"
                )
        {
            
        }
    }
}
