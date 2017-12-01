using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.action
{
    class CiTrendAction : XBroadcastAction
    {
        public CiTrendAction()
            : base("CiTrend", "CiTrend", Keys.None, "趋势图",
                "趋势图"
                )
        {
        }
    }
}
