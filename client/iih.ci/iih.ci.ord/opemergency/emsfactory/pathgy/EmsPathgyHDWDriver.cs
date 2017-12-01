
using System;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.opemergency.trorder;

namespace iih.ci.ord.opemergency.emsfactory
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emsfactory    </para>    
    /// <para>类 名 称 :  EmsPathgyHDWDriver					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/3/31 11:25:07             </para>
    /// <para>更新时间 :  2017/3/31 11:25:07             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EmsPathgyHDWDriver : EmsPathgyDriver
    {
        protected override BaseEmsViewModel CreateEmsModel(en.pv.dto.d.Ent4BannerDTO e)
        {
            if (null != e)
            {
                return new EmsPathgyHDWViewModel(e);
            }
            return null;
        }

        protected override ems.common.BaseEmsView CreateEmsView(IEventDelegate o)
        {
            if (null != o)
            {
                return new TrOrderPathgyHDWView(EnumPathyCardTp.HDW, o);
            }
            return null;
        }
    }
}
