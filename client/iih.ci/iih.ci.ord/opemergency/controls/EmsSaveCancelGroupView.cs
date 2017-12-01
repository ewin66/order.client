using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.controls
{
    /// <summary>
    /// <para>描    述 :  保存和取消按钮组合                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.controls    </para>    
    /// <para>类 名 称 :  EmsSaveCancelGroupView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  8/11/2016 7:11:29 AM             </para>
    /// <para>更新时间 :  8/11/2016 7:11:29 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsSaveCancelGroupView : BaseButtonGroupView
    {
        public EmsSaveCancelGroupView(BaseFormBizView o)
            : base(o, new EmsButtonViewCardItem[] {
                new EmsButtonViewCardItem("确认", EventCodeType.NM_EMS_SAVE),
                new EmsButtonViewCardItem("取消", EventCodeType.NM_EMS_CLOSE)})
        {

        }

        public override bool OnEventHandle(object sender, DictionaryEventArgs e)
        {
            bool ret = base.OnEventHandle(sender, e);
            if (AssToolEx.EventCodeOfEventArgs(e).Equals(EventCodeType.EVENT_EMS_SAVE_FOCUS) && this.Visible)
            {
                SetButtonFocus(0);
            }
            return ret;
        }
    }
}
