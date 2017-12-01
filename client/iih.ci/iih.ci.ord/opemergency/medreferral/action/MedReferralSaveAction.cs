
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.engine.xactions;

namespace iih.ci.ord.opemergency.medreferral.action
{
    /// <summary>
    /// <para>描    述 :  保存医疗转诊单       			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.medreferral.action    </para>    
    /// <para>类 名 称 :  MedReferralSaveAction					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  10/21/2016 8:47:58 AM             </para>
    /// <para>更新时间 :  10/21/2016 8:47:58 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class MedReferralSaveAction : XBroadcastAction
    {
        public MedReferralSaveAction()
            : base("MedReferralSaveAction", "MedReferralSaveAction", Keys.None, "保存", "保存")
        { }
    
    }
}
