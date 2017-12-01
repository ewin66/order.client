using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.engine.xactions;
using System.Windows.Forms;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// 服务分类按钮快捷键触发
    /// </summary>
    public class ShortcutOpMedSrvCatgAction : XBroadcastAction
    {
        public ShortcutOpMedSrvCatgAction()
            : base("ShortcutOpMedSrvCatg", "ShortcutOpMedSrvCatg", Keys.None, "服务分类", "服务分类")
        { }
    }
}
