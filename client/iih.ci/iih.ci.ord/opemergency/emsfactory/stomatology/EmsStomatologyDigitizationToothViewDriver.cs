
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.trorder;
using iih.ci.ord.opemergency.view.basic;

namespace iih.ci.ord.opemergency.emsfactory
{
    /// <summary>
    /// <para>描    述 :  XRay数字化牙片【00010733】        			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emsfactory    </para>    
    /// <para>类 名 称 :  EmsRisDriver					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/19 8:52:15             </para>
    /// <para>更新时间 :  2016/7/19 8:52:15             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsStomatologyDigitizationToothViewDriver : EmsRisDriver
    {
        protected override BaseEmsViewModel CreateEmsModel(en.pv.dto.d.Ent4BannerDTO e)
        {
            if (null != e)
            {
                return new EmsStomatologyDigitizationToothViewModel(e);
            }
            return null;
        }

        protected override ems.common.BaseEmsView CreateEmsView(IEventDelegate o)
        {
            if (null != o)
            {
                return new TrOrderStomatologyDigitizationToothView(o);
            }
            return null;
        }
    }
}
