using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.action
{
    /// <summary>
    /// <para>描    述 :  门诊休假证明 书                  			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.action    </para>    
    /// <para>类 名 称 :  Class1					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  9/29/2016 8:17:16 PM             </para>
    /// <para>更新时间 :  9/29/2016 8:17:16 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpVacationProofFileAction : XBroadcastAction 
      
    {
        public OpVacationProofFileAction()
            : base("VacationProofFile", "VacationProofFile", Keys.None, "休假证明书", "休假证明书")
        { }
    }
}
