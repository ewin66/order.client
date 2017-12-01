
using System;
using xap.cli.sdk.render.labelcontrol;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.cards    </para>    
    /// <para>类 名 称 :  OrderPathgyHDWView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/4/1 9:27:06             </para>
    /// <para>更新时间 :  2017/4/1 9:27:06             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class OrderPathgyHDWView : OrderPathgyView
    {
        private XLabelBaseUserRender urMensCycle;
        private XLabelBaseUserRender urMensTime;
        private XLabelBaseUserRender urMensLast;
        private XLabelBaseUserRender urMensThis;
        private XLabelBaseUserRender urBloodV;
        private XLabelBaseUserRender urHasCure;
        private XLabelBaseUserRender urTreatTime;
        private XLabelBaseUserRender urDosage;

        private XLabelBaseUserRender urTumourTime;
        private XLabelBaseUserRender urTumourTimeUnit;
        private XLabelBaseUserRender urTumourSize;
        private XLabelBaseUserRender urTumourPlace;
        private XLabelBaseUserRender urTumourTransfer;

        public OrderPathgyHDWView()
            : base()
        { }

        protected override void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            base.xapFormControl1_FormCreated(sender, e);

            urMensCycle = this.xapFormControl1.GetUserRender("note", "urMensCycle") as XLabelBaseUserRender;
            urMensCycle.MaxLength = 5;
            urMensCycle.MultilineNum = 1;
            (urMensCycle.UserRender as XUnitTextBoxMul).IsNumber = true;
            (urMensCycle.UserRender as XUnitTextBoxMul).MinValue = 0;
            (urMensCycle.UserRender as XUnitTextBoxMul).UnitText = "天";

            urMensTime = this.xapFormControl1.GetUserRender("note", "urMensTime") as XLabelBaseUserRender;
            urMensTime.MaxLength = 5;
            urMensTime.MultilineNum = 1;
            (urMensTime.UserRender as XUnitTextBoxMul).IsNumber = true;
            (urMensTime.UserRender as XUnitTextBoxMul).MinValue = 0;
            (urMensTime.UserRender as XUnitTextBoxMul).UnitText = "天";

            urMensLast = this.xapFormControl1.GetUserRender("note", "urMensLast") as XLabelBaseUserRender;
            urMensLast.ValueTextChanged += new EventHandler(urMensLast_ValueTextChanged);
            urMensThis = this.xapFormControl1.GetUserRender("note", "urMensThis") as XLabelBaseUserRender;
            urMensThis.ValueTextChanged += new EventHandler(urMensThis_ValueTextChanged);
            urBloodV = this.xapFormControl1.GetUserRender("note", "urBloodV") as XLabelBaseUserRender;
            urHasCure = this.xapFormControl1.GetUserRender("note", "urHasCure") as XLabelBaseUserRender;
            urTreatTime = this.xapFormControl1.GetUserRender("note", "urTreatTime") as XLabelBaseUserRender;
            urDosage = this.xapFormControl1.GetUserRender("note", "urDosage") as XLabelBaseUserRender;

            urTumourTime = this.xapFormControl1.GetUserRender("note", "urTumourTime") as XLabelBaseUserRender;
            urTumourTimeUnit = this.xapFormControl1.GetUserRender("note", "urTumourTimeUnit") as XLabelBaseUserRender;
            urTumourSize = this.xapFormControl1.GetUserRender("note", "urTumourSize") as XLabelBaseUserRender;
            urTumourPlace = this.xapFormControl1.GetUserRender("note", "urTumourPlace") as XLabelBaseUserRender;
            urTumourTransfer = this.xapFormControl1.GetUserRender("note", "urTumourTransfer") as XLabelBaseUserRender;

            (urMensLast.UserRender as XCalendarComboBox).MaxDate = urMensThis.ValueText != null && urMensThis.ValueText.Length > 0 ? DateTime.Parse(urMensThis.ValueText) : DateTime.Today;
            if (urMensLast.ValueText != null && urMensLast.ValueText.Length > 0)
                (urMensThis.UserRender as XCalendarComboBox).MinDate =  DateTime.Parse(urMensLast.ValueText);
            (urMensThis.UserRender as XCalendarComboBox).MaxDate = DateTime.Today;
        }

        protected override void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            base.xapFormControl1_ModelFilled(sender, e);

            (urMensCycle.UserRender as XUnitTextBoxMul).ValueText = this.EmsHeadDO.Emsappathgy.Def1;
            (urMensTime.UserRender as XUnitTextBoxMul).ValueText = this.EmsHeadDO.Emsappathgy.Def2;
            urMensLast.ValueText = this.EmsHeadDO.Emsappathgy.Def3;
            urMensThis.ValueText = this.EmsHeadDO.Emsappathgy.Def4;
            urBloodV.ValueText = this.EmsHeadDO.Emsappathgy.Def5;
            urHasCure.ValueText = this.EmsHeadDO.Emsappathgy.Def6;
            urTreatTime.ValueText = this.EmsHeadDO.Emsappathgy.Def7;
            urDosage.ValueText = this.EmsHeadDO.Emsappathgy.Def8;

            urTumourTime.ValueText = this.EmsHeadDO.Emsappathgy.Def9;
            urTumourTimeUnit.ValueText = this.EmsHeadDO.Emsappathgy.Def10;
            urTumourSize.ValueText = this.EmsHeadDO.Emsappathgy.Def11;
            urTumourPlace.ValueText = this.EmsHeadDO.Emsappathgy.Def12;
            urTumourTransfer.ValueText = this.EmsHeadDO.Emsappathgy.Def13;
        }

        private void urMensThis_ValueTextChanged(object sender, EventArgs e)
        {
            if (urMensThis.ValueText != null && urMensThis.ValueText.Length > 0)
                (urMensLast.UserRender as XCalendarComboBox).MaxDate = DateTime.Parse(urMensThis.ValueText);
            else
                (urMensLast.UserRender as XCalendarComboBox).MaxDate = DateTime.Today;
        }

        private void urMensLast_ValueTextChanged(object sender, EventArgs e)
        {
            if (urMensLast.ValueText != null && urMensLast.ValueText.Length > 0)
               (urMensThis.UserRender as XCalendarComboBox).MinDate = DateTime.Parse(urMensLast.ValueText);
            else
               (urMensThis.UserRender as XCalendarComboBox).MinDate = (urMensThis.UserRender as XCalendarComboBox).SysMinDate;
        }

        public override void SaveBefore()
        {
            base.SaveBefore();

            this.EmsHeadDO.Emsappathgy.Def1 = (urMensCycle.UserRender as XUnitTextBoxMul).ValueText;
            this.EmsHeadDO.Emsappathgy.Def2 = (urMensTime.UserRender as XUnitTextBoxMul).ValueText;
            this.EmsHeadDO.Emsappathgy.Def3 = urMensLast.ValueText;
            this.EmsHeadDO.Emsappathgy.Def4 = urMensThis.ValueText;
            this.EmsHeadDO.Emsappathgy.Def5 = urBloodV.ValueText;
            this.EmsHeadDO.Emsappathgy.Def6 = urHasCure.ValueText;
            this.EmsHeadDO.Emsappathgy.Def7 = urTreatTime.ValueText;
            this.EmsHeadDO.Emsappathgy.Def8 = urDosage.ValueText;

            this.EmsHeadDO.Emsappathgy.Def9 = urTumourTime.ValueText;
            this.EmsHeadDO.Emsappathgy.Def10 = urTumourTimeUnit.ValueText;
            this.EmsHeadDO.Emsappathgy.Def11 = urTumourSize.ValueText;
            this.EmsHeadDO.Emsappathgy.Def12 = urTumourPlace.ValueText;
            this.EmsHeadDO.Emsappathgy.Def13 = urTumourTransfer.ValueText;
        }

        protected override string getFormId()
        {
            return "20170331051943281000";
        }
    }
}
