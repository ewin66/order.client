using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.ciorderprn.action
{
    public class PreviewAction : XBroadcastAction
    {
        public PreviewAction()
            : base(UIEvent.PREVIEW, UIEvent.PREVIEW, Keys.None, "预览",
                       "预览"
                   )
        {
        }
    }
}
