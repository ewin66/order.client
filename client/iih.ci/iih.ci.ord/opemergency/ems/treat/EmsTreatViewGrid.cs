using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view.basic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.control.formcontrol.model;
using xap.rui.control.refcontrol.events;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.controls;

namespace iih.ci.ord.opemergency.ems
{
    public class EmsTreatViewGrid : EmsDrugSrvGridView
    {
        public EmsTreatViewGrid(IEventDelegate o = null)
            :base(o)
        {  }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsTreatViewGrid);//20170522074903628000
        }

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            AttachQuanMedEditor();
            bool nullCheck = !SysParamUtils.getSysParam().BD_PP_FG_NULL_UNIT_PRICE.OrgParam.Equals("true");
            this.GetGridControl().DataTable.Columns["customercolumn_med_unit"].AllowCheckNull = nullCheck;
        }

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            if (e.PropName.Equals("Name_srv") && null != this.GetViewModel() && !System.String.IsNullOrEmpty(GetViewModel().getCiEmsDTO().Id_or))
            {
                e.Cancel = true;
            }
            else
            {
                base.OnXapFormControl_AllowEditing(sender, e);
            }
        }

        protected override BaseValueUnitTableCell CreateQuanMedControl()
        {
            BaseValueUnitTableCell ctl = base.CreateQuanMedControl();
            ctl.AllowUnitNull = SysParamUtils.getSysParam().BD_PP_FG_NULL_UNIT_PRICE.OrgParam.Equals("true");
            return ctl;
        }        

        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                if (e.RefResultSet.IsEmpty)
                {
                    SentNotify(EventCodeType.NM_EMS_CLOSE);
                }
                else
                {
                    this.GetViewModel().LoadMedSrv(new EmsCreatedParameter(new bd.srv.medsrv.d.MedSrvDO() { Id_srv = (e.DataObject as EmsOrDrug).Id_srv }, null));
                }
            }
            else
            {
                base.OnXapFormControl_RefResult(sender, e);
            }
        }
    }
}
