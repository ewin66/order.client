using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    public class EmrPrintViewAction : XBroadcastAction
    {
        /// <summary>
        /// 病历打印预览按钮
        /// </summary>
        public EmrPrintViewAction()
            : base("EmrPrintViewAction", "EmrPrintViewAction", Keys.None, "病历打印", "病历预览打印")
        { }
    }
}
