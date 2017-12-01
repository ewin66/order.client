using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// 处方西药打印按钮
    /// </summary>
    public class OrdWestDrugPresPrintAction : XBroadcastAction
    {
        public OrdWestDrugPresPrintAction()
            : base("OrdWestPresPrint", "OrdWestPresPrint", Keys.None, "处方西药打印", "打印病历")
        { }
    }
}
