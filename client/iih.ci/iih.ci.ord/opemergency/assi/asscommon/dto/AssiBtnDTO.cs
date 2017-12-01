
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.assi.asscommon.dto
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon.dto</para>    
    /// <para>类 名 称 :  AssistantBtnDTO</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/12/15 14:33:42</para>
    /// <para>更新时间 :  2016/12/15 14:33:42</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class AssiBtnDTO
    {
        /// <summary>
        /// 按钮id
        /// </summary>
        public string ButtonId { get; set; }

        /// <summary>
        /// 按钮的text
        /// </summary>
        public string Text { get; set; }

        /// <summary>
        /// 按钮提示
        /// </summary>
        public string TipText { get; set; }

        /// <summary>
        /// 点击按钮打开的tab页签下的classId
        /// </summary>
        public string ViewClassId { get; set; }

        /// <summary>
        /// 对应配置文件中显示的PanelManagerId，用于确定显示哪个PanelManager
        /// </summary>
        public string PanelManagerId { get; set; }

        /// <summary>
        /// 点击按钮时确定将PanelManager中哪个XTabPage设置为激活状态
        /// </summary>
        public string XTabPageId { get; set; }

        /// <summary>
        /// 点击按钮弹出窗口的位置
        /// </summary>
        public AssiFrameLocation FrameLocation { get; set; }

        /// <summary>
        /// 点击按钮弹出窗口模式
        /// </summary>
        public AssiFrameOpenModel OpenFrameModel { get; set; }
        /// <summary>
        /// 模板弹出类型
        /// </summary>
        public String modelType { get; set; }

    }
}
