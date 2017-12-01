using System;
using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.opemergency.emsfactory;

namespace iih.ci.ord.opemergency.trorder
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.trorder    </para>    
    /// <para>类 名 称 :  TrOrderPathgyPKUView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/3/30 18:15:52             </para>
    /// <para>更新时间 :  2017/3/30 18:15:52             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class TrOrderPathgyPKUView : EmsPathgyViewCard
    {
        public TrOrderPathgyPKUView(EnumPathyCardTp enumPathyCardTp, IEventDelegate o = null)
            : base(o)
        {
            this.enumPathyCardTp = enumPathyCardTp;
        }
    }
}
