using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// 医技常规按钮快捷键触发
    /// </summary>
    public class ShortcutOpMedicalTechmologyAction : XBroadcastAction
    {
        public ShortcutOpMedicalTechmologyAction()
            : base("ShortcutOpMedicalTechmology", "ShortcutOpMedicalTechmology", Keys.None, "医技常规", "医技常规")
        { }
    }
}
