using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// 处方打印按钮
    /// </summary>
    public class OrdPresPrintAction : XBroadcastAction
    {
        public OrdPresPrintAction()
            : base("OrdPresPrint", "OrdPresPrint", Keys.None, "处方打印", "打印病历")
        { }
    }
}
