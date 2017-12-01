
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using xap.rui.engine;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.ciorderprn.action
{
    public class BrowseAction : XBroadcastAction
    {
        public BrowseAction()
            : base(UIEvent.QUERY, UIEvent.QUERY, Keys.None, "查询",
                       "查询"
                   )
        {
        }
    }
}
