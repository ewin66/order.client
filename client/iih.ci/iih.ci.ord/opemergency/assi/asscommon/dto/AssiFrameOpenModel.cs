
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.assi.asscommon.dto
{
    /// <summary>
    /// <para>描    述 :  助手弹出窗口打开方式</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon.dto</para>    
    /// <para>类 名 称 :  AssiFrameOpenModel</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/15 15:28:03</para>
    /// <para>更新时间 :  2016/12/15 15:28:03</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public enum AssiFrameOpenModel
    {
        /// <summary>
        /// 非模式窗口1
        /// </summary>
        [Description("非模式对话框")]
        SHOW = 0,
        /// <summary>
        /// 模式对话框
        /// </summary>
        [Description("模式对话框")]
        SHOW_DIALOG = 1,
    }
}
