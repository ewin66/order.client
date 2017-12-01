
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.ems;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.troeder;
using iih.ci.ord.opemergency.view.basic;

namespace iih.ci.ord.opemergency.emsfactory
{
 
    

    /// <summary>
    /// <para>描    述 :  西成药医疗单驱动      			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emsfactory    </para>    
    /// <para>类 名 称 :  EmsDrugsDriver					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/18 16:48:33             </para>
    /// <para>更新时间 :  2016/7/18 16:48:33             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsDrugsDriver : BaseEmsDriver
    {
        
        protected override BaseEmsViewModel CreateEmsModel(en.pv.dto.d.Ent4BannerDTO e)
        {
            if (null != e)
            {
                return new EmsDrugsViewModel(e);
            }
            return null;
        }

        protected override BaseEmsView CreateEmsView(IEventDelegate o)
        {
            if (null != o)
            {
                return new TrOrderDrugsView(o);
            }
            return null;
        }
        
    }
}
