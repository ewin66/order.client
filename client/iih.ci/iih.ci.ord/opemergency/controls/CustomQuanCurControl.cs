using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render.Items;
using xap.rui.control.forms.control;
using xap.cli.sdk.controls.DataView.Repository;
using xap.cli.sdk.controls.DataView;
using System.Windows.Forms;
using iih.ci.ord.opemergency.dialog;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.ems;
using System.Diagnostics;
using iih.ci.ord.opemergency.tool;

namespace iih.ci.ord.opemergency.controls
{
    class CustomQuanCurControl : QuanCurTableCell
    {
        private BaseEmsView emsView;

        public CustomQuanCurControl(BaseEmsView emsView)
            : base()
        {
            this.emsView = emsView;
        }
      
        protected override void editorWillAppear(object rowDataSource, XBaseUserRender ctrl)
        {
            base.editorWillAppear(rowDataSource, ctrl);
            // 获取总量编辑模式：1，可以编辑；0，不可以编辑
            var sysParamValue = SysParamUtils.getSysParam().SYS_PARAM_OpTotalQuanEditControlMode.DeptParam;
            (ctrl as XComboBoxUnit).TextBoxIsEnable = (1 == Convert.ToInt32(sysParamValue));
        }
        protected override void onUnitSelectChanged(object sender, object ds)
        {
            if (null != ds)
            {
                EmsOrDrug drug = ds as EmsOrDrug;
                if (this.emsView is EmsDrugSrvGridView)
                {
                    XComboBoxUnit ctrl = sender as XComboBoxUnit;
                    drug.Name_unit_sale = ctrl.ValueUnit;
                    string selectKey = ctrl.SelectKey.ToString();
                    string id_unit_sale = selectKey.Split(',')[0];
                    string factor = selectKey.Split(',')[1];
                    drug.Id_unit_sale = id_unit_sale;
                    drug.Factor_cb = string.IsNullOrEmpty(factor) ? 0 : Convert.ToDouble(factor);
                    this.emsView.GetViewModel().OnDataChanged(drug, "customercolumn_sale_unit_Name_unit_sale", drug.Name_unit_sale);
                    ctrl.ValueText = drug.Quan_cur.ToString();
                }

            }
            
        }
        protected override void onTextValueChanged(object sender, object ds)
        {
            if (null != ds)
            {
                EmsOrDrug drug = ds as EmsOrDrug;
                if (this.emsView is EmsDrugSrvGridView)
                {
                    XComboBoxUnit ctrl = sender as XComboBoxUnit;
                    //Debug.WriteLine(DateTime.Now + " ValueText:" + ctrl.ValueText);
                    
                    drug.Quan_cur = double.Parse(ctrl.ValueText);
                    this.emsView.GetViewModel().OnDataChanged(drug, "customercolumn_sale_unit_Quan_cur", drug.Quan_cur.ToString());
                }

            }
        }
        
    }
}
