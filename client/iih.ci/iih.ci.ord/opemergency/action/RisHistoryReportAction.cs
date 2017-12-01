
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// <para>描    述 :  用于第三方检查报告查看</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action</para>    
    /// <para>类 名 称 :  RisHistoryReportAction</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/11/23 13:36:58</para>
    /// <para>更新时间 :  2016/11/23 13:36:58</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class RisHistoryReportAction : XBroadcastAction
    {
        public RisHistoryReportAction()
            : base("RisHistoryReportAction", "RisHistoryReportAction", Keys.None, "检查报告", "检查报告")
        { }
    }
}
