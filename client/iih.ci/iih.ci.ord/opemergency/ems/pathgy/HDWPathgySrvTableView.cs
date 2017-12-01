
using System;
using iih.ci.ord.opemergency.ems.dp;
using xap.cli.sdk.render.labelcontrol;
using xap.cli.sdk.render.Items;
using iih.ci.ord.ciordems.d;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.ems
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems    </para>    
    /// <para>类 名 称 :  HDWPathgySrvTableView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/3/31 11:09:49             </para>
    /// <para>更新时间 :  2017/3/31 11:09:49             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class HDWPathgySrvTableView : PathgySrvTableView
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

        public HDWPathgySrvTableView(BaseEmsViewModel model)
            : base(model)
        { }

        protected override void OnLoadData()
        {
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_HDWPathgySrvTableView);
        }

        protected override void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.xapFormControl_FormCreated(sender, e);

            urMensCycle = this.GetXapFormControl().GetUserRender("pathgy", "urMensCycle") as XLabelBaseUserRender;
            urMensCycle.MaxLength = 5;
            urMensCycle.MultilineNum = 1;
            (urMensCycle.UserRender as XUnitTextBoxMul).IsNumber = true;
            (urMensCycle.UserRender as XUnitTextBoxMul).MinValue = 0;
            (urMensCycle.UserRender as XUnitTextBoxMul).UnitText = "天";

            urMensTime = this.GetXapFormControl().GetUserRender("pathgy", "urMensTime") as XLabelBaseUserRender;
            urMensTime.MaxLength = 5;
            urMensTime.MultilineNum = 1;
            (urMensTime.UserRender as XUnitTextBoxMul).IsNumber = true;
            (urMensTime.UserRender as XUnitTextBoxMul).MinValue = 0;
            (urMensTime.UserRender as XUnitTextBoxMul).UnitText = "天";

            urMensLast = this.GetXapFormControl().GetUserRender("pathgy", "urMensLast") as XLabelBaseUserRender;
            urMensLast.ValueTextChanged += new EventHandler(urMensLast_ValueTextChanged);
            urMensThis = this.GetXapFormControl().GetUserRender("pathgy", "urMensThis") as XLabelBaseUserRender;
            urMensThis.ValueTextChanged += new EventHandler(urMensThis_ValueTextChanged);
            urBloodV = this.GetXapFormControl().GetUserRender("pathgy", "urBloodV") as XLabelBaseUserRender;
            urHasCure = this.GetXapFormControl().GetUserRender("pathgy", "urHasCure") as XLabelBaseUserRender;
            urTreatTime = this.GetXapFormControl().GetUserRender("pathgy", "urTreatTime") as XLabelBaseUserRender;
            urDosage = this.GetXapFormControl().GetUserRender("pathgy", "urDosage") as XLabelBaseUserRender;

            urTumourTime = this.GetXapFormControl().GetUserRender("pathgy", "urTumourTime") as XLabelBaseUserRender;
            urTumourTimeUnit = this.GetXapFormControl().GetUserRender("pathgy", "urTumourTimeUnit") as XLabelBaseUserRender;
            urTumourSize = this.GetXapFormControl().GetUserRender("pathgy", "urTumourSize") as XLabelBaseUserRender;
            urTumourPlace = this.GetXapFormControl().GetUserRender("pathgy", "urTumourPlace") as XLabelBaseUserRender;
            urTumourTransfer = this.GetXapFormControl().GetUserRender("pathgy", "urTumourTransfer") as XLabelBaseUserRender;

            (urMensLast.UserRender as XCalendarComboBox).MaxDate = urMensThis.ValueText != null && urMensThis.ValueText.Length > 0 ? DateTime.Parse(urMensThis.ValueText) : DateTime.Today;
            if (urMensLast.ValueText != null && urMensLast.ValueText.Length > 0)
                (urMensThis.UserRender as XCalendarComboBox).MinDate = DateTime.Parse(urMensLast.ValueText);
            (urMensThis.UserRender as XCalendarComboBox).MaxDate = DateTime.Today;
        }

        protected override void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            base.xapFormControl_ModelFilled(sender, e);

            (urMensCycle.UserRender as XUnitTextBoxMul).ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def1;
            (urMensTime.UserRender as XUnitTextBoxMul).ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def2;
            urMensLast.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def3;
            urMensThis.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def4;
            urBloodV.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def5;
            urHasCure.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def6;
            urTreatTime.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def7;
            urDosage.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def8;

            urTumourTime.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def9;
            urTumourTimeUnit.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def10;
            urTumourSize.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def11;
            urTumourPlace.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def12;
            urTumourTransfer.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def13;
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
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def1 = (urMensCycle.UserRender as XUnitTextBoxMul).ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def2 = (urMensTime.UserRender as XUnitTextBoxMul).ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def3 = urMensLast.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def4 = urMensThis.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def5 = urBloodV.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def6 = urHasCure.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def7 = urTreatTime.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def8 = urDosage.ValueText;

            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def9 = urTumourTime.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def10 = urTumourTimeUnit.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def11 = urTumourSize.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def12 = urTumourPlace.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def13 = urTumourTransfer.ValueText;
        }
    }
}
