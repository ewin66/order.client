using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.view.basic;

namespace iih.ci.ord.opemergency.controls
{
    /// <summary>
    /// <para>描    述 :  备血医疗单按钮组               </para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.controls    </para>    
    /// <para>类 名 称 :  EmsUseSaveCancelGroupView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  8/11/2016 7:24:32 AM             </para>
    /// <para>更新时间 :  8/11/2016 7:24:32 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsUseSaveCancelGroupView : BaseButtonGroupView
    {
        public EmsUseSaveCancelGroupView(BaseFormBizView o):base(o, new EmsButtonViewCardItem[]{
        new EmsButtonViewCardItem("用血",EventCodeType.NM_EMS_APBU_ADD),
        new EmsButtonViewCardItem("确认",EventCodeType.NM_EMS_SAVE),
        new EmsButtonViewCardItem("取消",EventCodeType.NM_EMS_CLOSE)})
        { }
    
    }
}
