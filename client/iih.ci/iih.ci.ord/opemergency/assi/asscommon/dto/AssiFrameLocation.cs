
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.assi.asscommon.dto
{
    /// <summary>
    /// <para>描    述 :  弹出窗口位置</para>
    /// <para>说    明 :  如果以下弹出位置不足，可以补充</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon.dto</para>    
    /// <para>类 名 称 :  AssiFrameLocation</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/15 15:30:16</para>
    /// <para>更新时间 :  2016/12/15 15:30:16</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public enum AssiFrameLocation
    {
        /// <summary>
        /// 左侧
        /// </summary>
        LEFT = 11,
        /// <summary>
        /// 左侧模式对话框
        /// </summary>
        LEFT_DIALOG = 12,
        /// <summary>
        /// 右侧
        /// </summary>
        RIGHT = 21,
        /// <summary>
        /// 右侧模式对话框
        /// </summary>
        RIGHT_DIALOG = 22,
        /// <summary>
        /// 顶部
        /// </summary>
        TOP = 31,
        /// <summary>
        /// 顶部模式对话框
        /// </summary>
        TOP_DIALOG = 32,
        /// <summary>
        /// 中间
        /// </summary>
        CENTER = 41,
        /// <summary>
        /// 中间模式对话框
        /// </summary>
        CENTER_DIALOG = 42,
        /// <summary>
        /// 底部
        /// </summary>
        BOTTOM = 51,
        /// <summary>
        /// 底部模式对话框
        /// </summary>
        BOTTOM_DIALOG = 52
    }
}
