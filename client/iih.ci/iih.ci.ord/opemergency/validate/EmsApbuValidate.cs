using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.dto.d;

namespace iih.ci.ord.opemergency.validate
{
    /// <summary>
    /// <para>描    述 :  用血医疗单有效性检查    			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.validate    </para>    
    /// <para>类 名 称 :  EmsApbuValidate					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/12 13:31:48             </para>
    /// <para>更新时间 :  2016/7/12 13:31:48             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsApbuValidate : BaseEmsValidate
    {
        public override bool OrdValivate(object model, BaseEmsView sender)
        {
            bool bRet = true;
            bRet &= base.OrdValivate(model, sender);

            EmsApbuViewModel ubm = model as EmsApbuViewModel;

            CiordubDTO ubItem = ubm.GetFormDataSource() as CiordubDTO;

            // 用血量小于等于备血量
            if (ubItem.Quan_medu_ub > ubItem.Quan_medu)
            {
                sender.OrdErrorList.Add("用血量不能大于备血量！");
            }

            return sender.OrdErrorList.Count == 0;
        }
    }
}
