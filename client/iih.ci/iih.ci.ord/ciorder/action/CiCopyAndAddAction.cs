using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.action
{
    class CiCopyAndAddAction : XBroadcastAction
    {
        public CiCopyAndAddAction()
            : base("CopyAdd", "CopyAdd", Keys.None, "复制",
                "复制新增"
                )
        {

        }
    }
}
