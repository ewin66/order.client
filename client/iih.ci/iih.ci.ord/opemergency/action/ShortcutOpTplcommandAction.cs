using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// 病历模板按钮快捷键触发
    /// </summary>
    public class ShortcutOpTplcommandAction : XBroadcastAction
    {
        public ShortcutOpTplcommandAction()
            : base("ShortcutOpTplcommand", "ShortcutOpTplcommand", Keys.None, "病历模板", "病历模板")
        { }
    }
}
