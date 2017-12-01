using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.trorder;
using iih.ci.ord.opemergency.view.basic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.emsfactory
{
    /// <summary>
    /// <para>描    述 :  会诊医疗单驱动       			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emsfactory    </para>    
    /// <para>类 名 称 :  EmsConsDriver					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  7/29/2016 1:32:26 PM             </para>
    /// <para>更新时间 :  7/29/2016 1:32:26 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsConsDriver : BaseEmsDriver
    {
        protected override ems.dp.BaseEmsViewModel CreateEmsModel(en.pv.dto.d.Ent4BannerDTO e)
        {
            if (null != e)
            {
                return new EmsConsViewModel(e);
            }
            return null;
        }

        protected override ems.common.BaseEmsView CreateEmsView(IEventDelegate o)
        {
            if (null != o)
            {
                return new TrOrderConsView(o);
            }
            return null;
        }
       

    }
}
