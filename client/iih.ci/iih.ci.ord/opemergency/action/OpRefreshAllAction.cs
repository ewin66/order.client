
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// <para>描    述 :  门诊刷新                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action    </para>    
    /// <para>类 名 称 :  OpRefreshAllAction					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  12/16/2016 5:59:20 PM             </para>
    /// <para>更新时间 :  12/16/2016 5:59:20 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpRefreshAllAction : XBroadcastAction
    {
        public OpRefreshAllAction()
            : base("OpRefreshAllAction", "OpRefreshAllAction", Keys.None, "刷新",
                "刷新"
                )
        {
        }
    }
}
