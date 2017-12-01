using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.ciconsresponse.action
{
    class ConsPrint : XBroadcastAction
    {
        public ConsPrint()
            : base("print", "print", Keys.None, "打印",
                "打印"
                )
        {

        }
    }
}
