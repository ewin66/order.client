using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.opemergency.ems.common;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.opemergency.controls
{
    /// <summary>
    /// 自定义剂量控件
    /// </summary>
    public class CustomQuanMedControl : QuanMedTableCell
    {
        private BaseEmsView emsView;

        public CustomQuanMedControl(BaseEmsView emsView)
            : base()
        {
            this.emsView = emsView;
        }

        /// <summary>
        /// 剂量控件单位切换时，自动改变剂量值
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="ds"></param>
        protected override void onUnitSelectChanged(object sender, object ds)
        {
            XComboBoxUnit xComboBoxUnit = sender as XComboBoxUnit;
            EmsOrDrug drug = ds as EmsOrDrug;
            int selectIndex = xComboBoxUnit.SelectIndex;
            // 选择没有变化
            if (String.IsNullOrEmpty(drug.Name_unit_medu_virtual) || String.IsNullOrEmpty(xComboBoxUnit.ValueUnit) || xComboBoxUnit.ValueUnit.Equals(drug.Name_unit_medu_virtual))
            {
                return;
            }
            drug.Name_unit_medu_virtual = xComboBoxUnit.ValueUnit;
            if (selectIndex == 0)
            {
                if (drug.Quan_medu_virtual != null)
                {
                    drug.Quan_medu_virtual = drug.Quan_medu_virtual.DoubleValue() * drug.Factor_mb.DoubleValue();
                }
                else
                {
                    drug.Quan_medu_virtual = null;
                    drug.Quan_med = null;
                }

            }
            else if (selectIndex == 1)
            {
                if (drug.Quan_medu_virtual != null)
                {
                    //判断能否整除，如果能整除直接取整除的值，不能整除设置为空，让医生重新录入
                    if (LogicEx.GetInstance().divided(drug.Quan_medu_virtual, drug.Factor_mb))
                    {
                        drug.Quan_medu_virtual = drug.Quan_medu_virtual.DoubleValue() / drug.Factor_mb.DoubleValue();                        
                    }
                    else
                    {
                        drug.Quan_medu_virtual = null;
                        drug.Quan_med = null;
                    }

                }
            }
            xComboBoxUnit.ValueText = drug.Quan_medu_virtual == null ? "" : drug.Quan_medu_virtual + "";
        }

        /// <summary>
        /// 剂量改变时触发
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="ds"></param>
        protected override void onTextValueChanged(object sender, object ds)
        {

            XComboBoxUnit xComboBoxUnit = sender as XComboBoxUnit;
            EmsOrDrug drug = ds as EmsOrDrug;
            //if (String.IsNullOrEmpty(drug.Quan_medu_virtual==null?"": drug.Quan_medu_virtual.ToString()) == String.IsNullOrEmpty(xComboBoxUnit.ValueText) || xComboBoxUnit.ValueText.Equals(drug.Quan_medu_virtual.ToString()))
            //{
            //    return;
            //}
            if (drug != null && xComboBoxUnit != null)
            {
                double? quan_med = null;
                if (xComboBoxUnit.ValueText != null && xComboBoxUnit.ValueText != "")
                {
                    quan_med = Double.Parse(xComboBoxUnit.ValueText);
                }
                drug.Quan_medu_virtual = quan_med;
                setQuanMedu(xComboBoxUnit, drug);
                this.emsView.GetViewModel().OnDataChanged(drug, "customercolumn_med_unit", drug.Quan_cur.ToString());
            }
        }
       

    }
}
