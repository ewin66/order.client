
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// <para>描    述 : 历次检查就诊检查报告</para>
    /// <para>说    明 : 调用第三方检查报告</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action    </para>    
    /// <para>类 名 称 :  LisHistoryReportAction					</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  hums</para> 
    /// <para>修 改 人 :  hums</para> 
    /// <para>创建时间 :  2016/9/27 15:23:34</para>
    /// <para>更新时间 :  2016/9/27 15:23:34</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class LisHistoryReportAction : XBroadcastAction
    {
        public LisHistoryReportAction()
            : base("LisHistoryReportAction", "LisHistoryReportAction", Keys.None, "检验报告",
                "检验报告"
                )
        {

        }
    }
}
