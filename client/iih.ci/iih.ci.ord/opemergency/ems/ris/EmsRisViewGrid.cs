using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.controls;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view.basic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.opemergency.ems.dp;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.controls.DataView.Repository;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.control.formcontrol.model;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.opemergency.declare;
using xap.rui.control.forms.control;

namespace iih.ci.ord.opemergency.ems
{
    class EmsRisViewGrid : EmsDrugSrvGridView
    {
        public EmsRisViewGrid(IEventDelegate o = null)
            : base(o)
        {
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsRisViewGrid);//20170614031334566000
        }

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            this.AttachDetailInfoRefEditor();
        }

        protected override void OnXapFormControl_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            base.OnXapFormControl_DataDisplay(sender, e);

            EmsObsItemDO model = this.GetViewModel().GetFormDataSource() as EmsObsItemDO;
            if (model != null)
                this.updateCustomerControlInfo(sender as XDataRow, model);
        }

        private void AttachDetailInfoRefEditor()
        {
            XRepositoryRefEdit edit = new XRepositoryRefEdit(this.GetGridControl());
            edit.RefEditor = new CustomRefSetItmsControl(this, edit, this.allowEdit);

            this.GetGridControl().DataTable.Columns["customercolumn_details"].ColumnEdit = edit;
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        protected void updateCustomerControlInfo(XDataRow row, EmsObsItemDO model)
        {
            if (row != null && model != null)
            {
                if (row.ColumnCellDict.ContainsKey("customercolumn_details"))
                {
                    row.ColumnCellDict["customercolumn_details"].SetValue(
                        model.Fg_set == true ? CustomRefSetItmsControl.ConstructDetialInfo(model.EmsOrObsList) : model.Name_body);
                }
            }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            if (e.PropName.Equals("Name_srv") && null != this.GetViewModel() && String.IsNullOrEmpty(GetViewModel().getCiEmsDTO().Id_or))
            {
                e.Cancel = false;
            }
            else
            {
                base.OnXapFormControl_AllowEditing(sender, e);
            }
               
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
