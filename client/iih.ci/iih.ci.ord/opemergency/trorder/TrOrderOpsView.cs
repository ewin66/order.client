using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.ems;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.control.basecontrol;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.trorder
{
    /// <summary>
    /// <para>描    述 :  手术医疗单视图                   	</para>
    /// <para>说    明 :  简洁                   			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.trorder    </para>    
    /// <para>类 名 称 :  TrOrderOpsView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  7/28/2016 5:22:13 PM             </para>
    /// <para>更新时间 :  7/28/2016 5:22:13 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class TrOrderOpsView : EmsOpsViewCard
    {
        public TrOrderOpsView(IEventDelegate o = null)
            : base(o)
        {}

        public override bool OnChildNotify(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            if (AssToolEx.EventCodeOfEventArgs(e) == EventCodeType.NM_UIMSG_LAYOUTCHANGED)
            {
                this.AdjustLayout();
                return true;
            }
            return base.OnChildNotify(sender, e);
        }

       
    }
}
