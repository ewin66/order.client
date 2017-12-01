
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action.shortcut
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action.shortcut</para>    
    /// <para>类 名 称 :  ShortCutMkrMsAppView</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/28 11:46:27</para>
    /// <para>更新时间 :  2016/12/28 11:46:27</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class ShortCutMkrMsAppView : XBroadcastAction
    {
        public ShortCutMkrMsAppView()
            : base("ShortCutMkrMsAppView", "ShortCutMkrMsAppView", Keys.Alt | Keys.M, "门诊组套", "门诊组套")
        { }
    }
}
