
using System;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.action
{
    public class CiSaveasAction : XBroadcastAction
    {
        public CiSaveasAction()
            : base("CiSaveas", "CiSaveas", Keys.None, "另存为模板",
                "保存"
                )
        {

        }
    }
}
