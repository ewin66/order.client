using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.render.Items;
using xap.mw.coreitf.d;
using System.Drawing;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.opemergency.tool;

namespace iih.ci.ord.opemergency.controls
{
    /// <summary>
    /// 计量单位
    /// </summary>
    public class QuanMedTableCell : BaseValueUnitTableCell
    {
        protected override void initCellControlFormat(XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            //xComboBoxUnit.ComboboxWidthPercent = 0.38;
            xComboBoxUnit.TextAlignment = System.Windows.Forms.HorizontalAlignment.Right;
            
            //xComboBoxUnit.MinInputNumber = 0.001;
            xComboBoxUnit.MaxInputNumber = 99999999.9999;
            xComboBoxUnit.NullFlag = false;
            xComboBoxUnit.HasError = false;
        }

        protected override void editorWillAppear(object rowDataSource, XBaseUserRender ctrl)
        {
            EmsOrDrug drug = rowDataSource as EmsOrDrug;
            if (null != drug)
            {
                XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
                string sd_mmbind_op = drug.Sd_mmbind_op;
                //开立绑定可以编辑
                xComboBoxUnit.UnitIsEnable = (!string.IsNullOrEmpty(sd_mmbind_op) && sd_mmbind_op.Equals("0")) ? true : false;
                //if (xComboBoxUnit.ValueUnit.Length > 0)
                //{
                    Dictionary<object,string> items = new Dictionary<object,string>();
                    items.Add(drug.Id_unit_med+","+"1",drug.Name_unit_med);
                    if (drug.Id_unit_base != null && !drug.Id_unit_base.Equals(drug.Id_unit_med))
                    {
                        items.Add(drug.Id_unit_base+","+drug.Factor_mb, drug.Name_unit_base);
                    }
                    
                    xComboBoxUnit.DataSource = items;
                //}
                xComboBoxUnit.ValueText = (drug.Quan_medu_virtual == null ? null : drug.Quan_medu_virtual.ToString());
                xComboBoxUnit.ValueUnit = (drug.Name_unit_medu_virtual == null ? "" : drug.Name_unit_medu_virtual);
                // 自定义控件需要传递编辑完成后该列的错误信息
                setColumnForeColor(drug, ctrl);
            }
        }

        protected override void editorWillDisappear(object rowDataSource, XBaseUserRender ctrl)
        {
            XComboBoxUnit xComboBoxUnit = ctrl as XComboBoxUnit;
            EmsOrDrug drug = rowDataSource as EmsOrDrug;
            if (null != drug)
            {
                double? quan_med=null;
                if (xComboBoxUnit.ValueText != null && xComboBoxUnit.ValueText != "")
                {
                    quan_med = Double.Parse(xComboBoxUnit.ValueText);
                }
                drug.Quan_medu_virtual =  quan_med;//quan_med == null ? 0:
                drug.Name_unit_medu_virtual = xComboBoxUnit.ValueUnit;
                if (String.IsNullOrEmpty(xComboBoxUnit.ValueUnit))
                {
                    drug.Name_unit_med = xComboBoxUnit.ValueUnit;
                }
                setQuanMedu(xComboBoxUnit, drug);
            }
        }

        protected override void cellWillAppear(object rowDataSource, XCellRender cell)
        {
           
            EmsOrDrug drug = rowDataSource as EmsOrDrug;
            if (null != drug && drug.Id_srv != null && drug.Id_srv.Length != 0)
            {
                if (drug.Quan_medu_virtual == null||drug.Quan_medu_virtual == 0)
                {
                    cell.ValueText = (drug.Name_unit_medu_virtual);
                    
                }
                else {
                    cell.ValueText=(drug.Quan_medu_virtual.ToString() + drug.Name_unit_medu_virtual);
                    
                }
                // 自定义控件需要传递编辑完成后该列的错误信息
                cell.HasError = HasError;
                cell.ErrorText = ErrorText;

                setColumnForeColor(drug, cell);
            }
        }
        protected override void onUnitSelectChanged(object sender, object ds)
        {
            XComboBoxUnit xComboBoxUnit = sender as XComboBoxUnit;
            EmsOrDrug drug = ds as EmsOrDrug;
            int selectIndex = xComboBoxUnit.SelectIndex;
            // 选择没有变化
            if (String.IsNullOrEmpty(drug.Name_unit_medu_virtual)==String.IsNullOrEmpty(xComboBoxUnit.ValueUnit)|| xComboBoxUnit.ValueUnit.Equals(drug.Name_unit_medu_virtual))
            {
                return;

            }
            if (selectIndex == 0)
            {
                if (drug.Quan_medu_virtual != null)
                {
                    drug.Quan_medu_virtual = drug.Quan_medu_virtual.DoubleValue() * drug.Factor_mb.DoubleValue();
                    drug.Name_unit_medu_virtual = xComboBoxUnit.ValueUnit;
                }
                else {
                    drug.Quan_medu_virtual = null;
                    drug.Quan_med = null;
                }
                
            }
            else if(selectIndex==1) {
                if (drug.Quan_medu_virtual != null) { 
                    //判断能否整除，如果能整除直接取整除的值，不能整除设置为空，让医生重新录入
                    if(LogicEx.GetInstance().divided(drug.Quan_medu_virtual,drug.Factor_mb)){
                        drug.Quan_medu_virtual = drug.Quan_medu_virtual.DoubleValue()/drug.Factor_mb.DoubleValue();
                        drug.Name_unit_medu_virtual = xComboBoxUnit.ValueUnit;
                    }
                    else{
                        drug.Quan_medu_virtual = null;
                        drug.Quan_med = null;
                    }
                    
                }
            }
            xComboBoxUnit.ValueText = drug.Quan_medu_virtual == null ? "" : drug.Quan_medu_virtual+"";
        }
        protected override void onTextValueChanged(object sender, object ds)
        {
            
            XComboBoxUnit xComboBoxUnit = sender as XComboBoxUnit;
            EmsOrDrug drug = ds as EmsOrDrug;
            //if (String.IsNullOrEmpty(drug.Quan_medu_virtual==null?"": drug.Quan_medu_virtual.ToString()) == String.IsNullOrEmpty(xComboBoxUnit.ValueText) || xComboBoxUnit.ValueText.Equals(drug.Quan_medu_virtual.ToString()))
            //{
            //    return;
            //}
            if (drug != null && xComboBoxUnit!=null)
            {
                double? quan_med = null;
                if (xComboBoxUnit.ValueText != null && xComboBoxUnit.ValueText!="")
                {
                    quan_med = Double.Parse(xComboBoxUnit.ValueText);
                }
                drug.Quan_medu_virtual = quan_med;
                setQuanMedu(xComboBoxUnit, drug);
               
            }
        }
        /// <summary>
        /// 剂量单位和数值发生变化时重新设置quan_medu的值
        /// </summary>
        /// <param name="xComboBoxUnit"></param>
        /// <param name="drug"></param>
        protected void setQuanMedu(XComboBoxUnit xComboBoxUnit,EmsOrDrug drug) {
            int selectIndex = xComboBoxUnit.SelectIndex;
            /* if (selectIndex==0)//*/
            //控件的 xComboBoxUnit.SelectIndex的值有问题 改为xComboBoxUnit.ValueUnit来判断
            if (xComboBoxUnit.ValueUnit == drug.Name_unit_med)
            {
                if (drug.Quan_medu_virtual != null)
                {
                    drug.Quan_med = drug.Quan_medu_virtual;
                }
                else
                {
                    drug.Quan_med = null;
                }

            }
            else/* if (selectIndex == 1)//*/ //if (xComboBoxUnit.ValueUnit == drug.Name_unit_med)
            {
                if (drug.Quan_medu_virtual != null && drug.Factor_mb != null)
                {
                    drug.Quan_med = drug.Quan_medu_virtual * drug.Factor_mb;
                }
                else
                {
                    drug.Quan_med = null;
                }
            }
        }
        /// <summary>
        /// 单元格必填项为空时，设置前景色
        /// </summary>
        /// <param name="drug"></param>
        /// <param name="ctrl"></param>
        private void setColumnForeColor(EmsOrDrug drug, XBaseUserRender ctrl)
        {
           
            // 自定义控件需要传递编辑完成后该列的错误信息
            if (drug.Quan_med == null || drug.Quan_med == 0)
            {
                ctrl.HasError = true;
                //cell.ErrorText = "剂量不允许为空";
            }
            else if (drug.Name_unit_med == null&&!AllowUnitNull)
            {
                ctrl.HasError = true;
                //cell.ErrorText = "剂量单位为空";
            }
            else
            {
                ctrl.HasError = false;
                ctrl.ErrorText = null;
            }
        }


        public override bool HasError
        {
            get
            {
                return (this.GetEditControl() as XComboBoxUnit).HasError || String.IsNullOrEmpty((this.GetEditControl() as XComboBoxUnit).ValueText) || (String.IsNullOrEmpty((this.GetEditControl() as XComboBoxUnit).ValueUnit) && !AllowUnitNull);
              
            }

            set
            {
                base.HasError = value;
            }
        }

        public override string ErrorText
        {
            get
            {
                return this.GetEditControl().ErrorText;
            }

            set
            {
                base.ErrorText = value;
            }
        }

    }
}
