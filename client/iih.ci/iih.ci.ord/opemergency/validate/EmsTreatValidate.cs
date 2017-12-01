using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;

namespace iih.ci.ord.opemergency.validate
{
    /// <summary>
    /// <para>描    述 :  治疗医疗单有效性检查    			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.validate    </para>    
    /// <para>类 名 称 :  EmsTreatValidate					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/12 13:31:48             </para>
    /// <para>更新时间 :  2016/7/12 13:31:48             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    class EmsTreatValidate : BaseEmsValidate
    {

        public override bool OrdValivate(object model, BaseEmsView sender)
        {
            base.OrdValivate(model, sender);
            XapDataList<EmsOrDrug> emsdrugs = (model as EmsTreatViewModel).GetTableDataSource() as XapDataList<EmsOrDrug>;
            #region 剂|总量大于0
            foreach (EmsOrDrug item in emsdrugs)
            {
                if (item.Quan_med == null || item.Quan_med.ToDouble() <= 0)
                {
                    sender.OrdErrorList.Add(item.Name_mm + "剂量必须大于0！");
                }
               
            }
            #endregion
            return sender.OrdErrorList.Count == 0;
        }
    }
}
