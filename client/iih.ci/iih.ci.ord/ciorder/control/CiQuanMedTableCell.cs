using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render.Items;
using iih.ci.ord.opemergency.controls;

namespace iih.ci.ord.ciorder.controls
{
    /// <summary>
    /// 计量单位
    /// </summary>
    class CiQuanMedTableCell : QuanMedTableCell
    {
        protected override void initCellControlFormat(XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            //xComboBoxUnit.ComboboxWidthPercent = 0.38;
            xComboBoxUnit.TextAlignment = System.Windows.Forms.HorizontalAlignment.Right;
            xComboBoxUnit.UnitIsEnable = false; // 禁用单位编辑
            xComboBoxUnit.MinInputNumber = 0.001;
            xComboBoxUnit.NullFlag = false;
        }
        protected override void editorWillAppear(object rowDataSource, XBaseUserRender ctrl)
        {
            EmsOrDrug drug = rowDataSource as EmsOrDrug;
            if (null != drug)
            {
                XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
                xComboBoxUnit.ValueText = (drug.Quan_med == null ? "0" : drug.Quan_med.ToString());
                xComboBoxUnit.ValueUnit = (drug.Name_unit_med == null ? "" : drug.Name_unit_med);
                if (xComboBoxUnit.ValueUnit.Length > 0)
                {
                    Dictionary<object,string> items = new Dictionary<object,string>();
                    items.Add(drug.Id_unit_med,drug.Name_unit_med);
                    
                    xComboBoxUnit.DataSource = items;
                }
            }
        }
        protected override void editorWillDisappear(object rowDataSource, XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            EmsOrDrug drug = rowDataSource as EmsOrDrug;
            if (null != drug)
            {
                double quan_med = ((xComboBoxUnit.ValueText == null || xComboBoxUnit.ValueText.Length == 0) ? 0 : Double.Parse(xComboBoxUnit.ValueText));
                drug.Quan_med = quan_med;//== null ? 0 : quan_med;
                drug.Name_unit_med = xComboBoxUnit.ValueUnit;
            }
        }

        protected override void cellWillAppear(object rowDataSource, XCellRender cell)
        {

            EmsOrDrug drug = rowDataSource as EmsOrDrug;
            if (null != drug && drug.Id_srv != null && drug.Id_srv.Length != 0)
            {
                if (drug.Quan_med == 0)
                {
                    cell.SetValue(drug.Name_unit_med);

                }
                else
                {
                    cell.SetValue(drug.Quan_med.ToString() + drug.Name_unit_med);

                }
                // 自定义控件需要传递编辑完成后该列的错误信息
                cell.HasError = GetEditControl().HasError;
                cell.ErrorText = GetEditControl().ErrorText;
                //if (!cell.HasError && !string.IsNullOrEmpty(cell.ErrorText))
                //{
                //    cell.HasError = true;
                //}
            }
        }
        protected override void onUnitSelectChanged(object sender, object ds)
        {
           
        }
        protected override void onTextValueChanged(object sender, object ds)
        {
            
        }
    }
}
