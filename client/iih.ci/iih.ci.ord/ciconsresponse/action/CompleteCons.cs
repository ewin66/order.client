using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.ciconsresponse.action
{
    class CompleteCons : XBroadcastAction
    {
        public CompleteCons()
            : base("conscom", "conscom", Keys.None, "完成会诊",
                "医嘱确认"
                )
        {

        }
    }
}
