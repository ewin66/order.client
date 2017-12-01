
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.assi.asscommon.viewmodel
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon.viewmodel</para>    
    /// <para>类 名 称 :  AssistantConstant</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/10/21 18:23:25</para>
    /// <para>更新时间 :  2016/10/21 18:23:25</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class AssistantConstant
    {
        #region 事件

        /// <summary>
        /// 打印事件调用
        /// </summary>
        public const string CI_EMR_PRINT_EVENT = "CiEmrPrintEvent";

        /// <summary>
        /// 打印预览事件调用
        /// </summary>
        public const string CI_EMR_PRINT_PRIVEW_EVENT = "CiEmrPrintPrivewEvent";

        /// <summary>
        /// 发送病历段落回写事件，用于EmrEditorInitEvent中接收的状态
        /// </summary>
        public const string CI_EMR_WRITE_BACK_EVENT = "CiEmrWriteBackEvent";

        /// <summary>
        /// 病历段落回写的key值
        /// </summary>
        public const string CI_EMR_WRITE_BACK_DATA = "lsPhase";

        #endregion

        #region 常量

        /// <summary>
        /// 功能节点编码：传染病上报卡
        /// </summary>
        public const string FUN_CODE_CONTAGION_REPORT_CARD = "46601607";
        #endregion
    }
}
