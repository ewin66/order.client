using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// 病历打印按钮
    /// </summary>
    public class EmrPrintAction : XBroadcastAction
    {
        public EmrPrintAction()
            : base("EmrPrintAction", "EmrPrintAction", Keys.None, "病历打印", "打印病历")
        { }
    }
}
