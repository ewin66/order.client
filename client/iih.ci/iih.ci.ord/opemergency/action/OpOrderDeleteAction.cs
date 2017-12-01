
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// <para>描    述 :  处置删除                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.action    </para>    
    /// <para>类 名 称 :  OpOrderDeleteAction					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  10/25/2016 2:08:25 PM             </para>
    /// <para>更新时间 :  10/25/2016 2:08:25 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpOrderDeleteAction : XBroadcastAction
    {
        public OpOrderDeleteAction()
            : base(UIEvent.DELETE, "OpOrderDeleteAction", Keys.Alt|Keys.D, "处置删除", "删除") { }
    
    }
}
