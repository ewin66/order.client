using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// 医嘱模板按钮快捷键触发
    /// </summary>
    public class ShortcutOpOrdTemplatAction : XBroadcastAction
    {
        public ShortcutOpOrdTemplatAction()
            : base("ShortcutOpOrdTemplat", "ShortcutOpOrdTemplat", Keys.F10, "医嘱模板", "医嘱模板")
        { }
    }
}
