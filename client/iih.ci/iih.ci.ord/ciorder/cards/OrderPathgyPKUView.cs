
using System;
using xap.cli.sdk.render.labelcontrol;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.cards    </para>    
    /// <para>类 名 称 :  OrderPathgyPKUView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/4/1 9:26:33             </para>
    /// <para>更新时间 :  2017/4/1 9:26:33             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class OrderPathgyPKUView : OrderPathgyView
    {
        private XLabelBaseUserRender urMensCycle;
        private XLabelBaseUserRender urMensThis;
        private XLabelBaseUserRender urOpDate;

        public OrderPathgyPKUView()
            : base()
        { }

        protected override void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            base.xapFormControl1_FormCreated(sender, e);

            urMensCycle = this.xapFormControl1.GetUserRender("pathgy", "urMensCycle") as XLabelBaseUserRender;
            urMensCycle.MaxLength = 5;
            urMensCycle.MultilineNum = 1;
            (urMensCycle.UserRender as XUnitTextBoxMul).IsNumber = true;
            (urMensCycle.UserRender as XUnitTextBoxMul).MinValue = 0;
            (urMensCycle.UserRender as XUnitTextBoxMul).UnitText = "天";

            urMensThis = this.xapFormControl1.GetUserRender("pathgy", "urMensThis") as XLabelBaseUserRender;
            urOpDate = this.xapFormControl1.GetUserRender("pathgy", "urOpDate") as XLabelBaseUserRender;

            (urMensThis.UserRender as XCalendarComboBox).MaxDate = DateTime.Today;
        }

        protected override void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            base.xapFormControl1_ModelFilled(sender, e);

            (urMensCycle.UserRender as XUnitTextBoxMul).ValueText = this.EmsHeadDO.Emsappathgy.Def1;
            urMensThis.ValueText = this.EmsHeadDO.Emsappathgy.Def4;
            urOpDate.ValueText = this.EmsHeadDO.Emsappathgy.Def14;
        }

        public override void SaveBefore()
        {
            base.SaveBefore();

            this.EmsHeadDO.Emsappathgy.Def1 = (urMensCycle.UserRender as XUnitTextBoxMul).ValueText;
            this.EmsHeadDO.Emsappathgy.Def4 = urMensThis.ValueText;
            this.EmsHeadDO.Emsappathgy.Def14 = urOpDate.ValueText;
        }

        protected override string getFormId()
        {
            return "20170331051555022000";
        }
    }
}
