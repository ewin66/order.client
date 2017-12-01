using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.render;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.action
{
    class CiBackAction : XBroadcastAction
    {
        public CiBackAction()
            : base("CiBack", "CiBack", Keys.None, "作废",
                "取消提交"
                )
        {

        }
    }
}
