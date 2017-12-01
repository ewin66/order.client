using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// 门诊组套按钮快捷键触发
    /// </summary>
    public class ShortcutOpMedclingrpAppAction : XBroadcastAction
    {
        public ShortcutOpMedclingrpAppAction()
            : base("ShortcutOpMedclingrpApp", "ShortcutOpMedclingrpApp", Keys.None, "门诊组套", "门诊组套")
        { }
    }
}
