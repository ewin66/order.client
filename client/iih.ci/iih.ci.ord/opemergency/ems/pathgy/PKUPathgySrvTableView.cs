
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
    /// <para>类 名 称 :  PKUPathgySrvTableView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/3/31 11:09:19             </para>
    /// <para>更新时间 :  2017/3/31 11:09:19             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class PKUPathgySrvTableView : PathgySrvTableView
    {
        private XLabelBaseUserRender urMensCycle;
        private XLabelBaseUserRender urMensThis;
        private XLabelBaseUserRender urOpDate;

        public PKUPathgySrvTableView(BaseEmsViewModel model)
            : base(model)
        { }

        protected override void OnLoadData()
        {
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_PKUPathgySrvTableView/*"20170331072330114000"*/);
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

            urMensThis = this.GetXapFormControl().GetUserRender("pathgy", "urMensThis") as XLabelBaseUserRender;
            urOpDate = this.GetXapFormControl().GetUserRender("pathgy", "urOpDate") as XLabelBaseUserRender;

            (urMensThis.UserRender as XCalendarComboBox).MaxDate = DateTime.Today;

            bool isFemale = (this.model.GetEmsUIDTO() as EmsUIDTO).PatInfo.Sd_sex == "2";
            urMensCycle.Visible = isFemale;
            urMensThis.Visible = isFemale;
            urOpDate.Visible = isFemale;
        }

        protected override void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            base.xapFormControl_ModelFilled(sender, e);

            (urMensCycle.UserRender as XUnitTextBoxMul).ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def1;
            urMensThis.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def4;
            urOpDate.ValueText = (this.model.GetFormDataSource() as EmsPathgyItemDO).Def14;
        }

        public override void SaveBefore()
        {
            base.SaveBefore();
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def1 = (urMensCycle.UserRender as XUnitTextBoxMul).ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def4 = urMensThis.ValueText;
            (this.model.GetFormDataSource() as EmsPathgyItemDO).Def14 = urOpDate.ValueText;
        }
    }
}
