using System;
using iih.ci.ord.opemergency.medreferral.model;
using iih.ci.ord.opemergency.view;
using iih.ci.ord.opemergency.view.basic;
using iih.en.pv.dto.d;
using xap.rui.control.engine.attributes;
using xap.rui.control.forms.view;
using xap.rui.control.formcontrol.model;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.medreferral.view
{
    /// <summary>
    /// <para>描    述 :  医疗转诊单                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.medreferral    </para>    
    /// <para>类 名 称 :  CiMedReferralView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  10/20/2016 8:33:43 PM             </para>
    /// <para>更新时间 :  10/20/2016 8:33:43 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiMedReferralView : BaseFormBizView
    {
        private CiMedReferralViewModel model;

        private XCalendarTimerComboBox endDateTiem;

        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_CiMedReferralView/*"20161021080909883000"*/);
            this.RegisteFormEventImpl(); 
        }

        protected override void OnFillData()
        {
            base.OnFillData();
        }

        protected override void OnLoadData()
        {
            base.OnLoadData();

            if (null != model)
            {
                this.SetFormDataSource(model.GetFormDataSource());

                this.model.Reload();
            }
        }

        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            base.OnXapFormControl_ModelFilled(sender, e);

            this.setWaterMark();
        }

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);

            endDateTiem = this.GetXapFormControl().GetUserRender("card", "dt_referralperiodend").Renders[0] as XCalendarTimerComboBox;
            endDateTiem.MinDate = model.MedReferralDO.Dt_open;
        }

        public void ReloadForm(Object sender, EventArgs e)
        {
            this.LoadData();

            setWaterMark();
        }

        private void setWaterMark()
        {
            string str = "";
            if (null != model)
            {
                int? num = this.model.GetPrintNum();
                if (num == null || num == 0)
                    str = "未打印";
                else
                    str = "已打印" + num.ToString() + "次";
            }
            this.GetXapFormControl().SetWaterMark("card", str);
        }

        [XapCommand(Name = "MedReferralSaveAction")]
        public void OnMedReferralSaveAction()
        {

        }

        [XapCommand(Name = "MedReferralPrintAction")]
        public void OnMedReferralPrintAction()
        {

        }

        public override void OnStatus()
        {
            this.SetEnable("MedReferralSaveAction", true);
            if (this.model != null && this.model.MedReferralDO != null)
                this.SetEnable("MedReferralPrintAction", this.model.MedReferralDO.Id_medreferral != null);
        }

        public void SetModel(CiMedReferralViewModel m)
        {
            this.model = m;

            this.LoadData();
        }
    }
}
