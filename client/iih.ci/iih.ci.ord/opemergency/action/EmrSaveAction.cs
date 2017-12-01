
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// <para>描    述 :  病历保存                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action    </para>    
    /// <para>类 名 称 :  EmrSaveAction					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  10/25/2016 1:41:31 PM             </para>
    /// <para>更新时间 :  10/25/2016 1:41:31 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmrSaveAction : XBroadcastAction
    {
        /// <summary>
        /// 病历打印预览按钮
        /// </summary>
        public EmrSaveAction()
            : base(xap.rui.engine.UIEvent.SAVE, "EmrSaveAction", Keys.Shift|Keys.S, "病历保存", "保存")
        { }
    
    }
}
