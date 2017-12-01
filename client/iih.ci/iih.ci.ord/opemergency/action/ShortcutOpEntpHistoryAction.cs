using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// 就诊历史快捷键触发
    /// </summary>
    public class ShortcutOpEntpHistoryAction : XBroadcastAction
    {
        public ShortcutOpEntpHistoryAction()
            : base("ShortcutOpEntpHistory", "ShortcutOpEntpHistory", Keys.Alt|Keys.Q, "历史", "历史")
        { }
    }
}
