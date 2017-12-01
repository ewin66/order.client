using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.controls.DataView.Repository;
using System.Drawing;
using xap.cli.sdk.controls.DataView;
using System.Windows.Forms;
using xap.cli.sdk.render.Items;
using iih.ci.ord.ciordems.d;
using xap.rui.engine;
using System.Text.RegularExpressions;

namespace iih.ci.ord.opemergency.controls
{
    /// <summary>
    /// 剂量 自定义控件
    /// </summary>
    public class BaseValueUnitTableCell : BaseTableCell
    {
        /// <summary>
        /// 是否允许计量单位为空
        /// </summary>
        public bool AllowUnitNull{get;set;}
        #region 构造方法
        
        protected override XBaseUserRender createCustomCtrl()
        {
            // 计量单位控件
            XComboBoxUnit ctrl = new XComboBoxUnit();
            // 单位下拉事件
            ctrl.OnClickedDropDownForm += new EventHandler(OnClickedDropDown);
            // 单位选择事件
            ctrl.SelectValueChanged += new EventHandler(ctrl_SelectValueChanged);
            // 计量值改变事件
            ctrl.ValueTextChanged += new EventHandler(ctrl_ValueTextChanged);
            ctrl.ValueTextChanging += new ChangingEventHandler(ctrl_ValueTextChanging);
           // ctrl.MaxInputNumber = 100000000;
           // ctrl.MaxLength = 4;
           // 剂量与单位水平位置占比
            ctrl.ComboboxWidthPercent = 0.5;
            // 是否允许单位为空
            AllowUnitNull = false;
            return ctrl;
        }

        /// <summary>
        /// 剂量控件数据修改前判断数据合法性
        /// 验证剂量控件输入或复制到控件的数据是否合法，如果不合法不改变剂量值
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void ctrl_ValueTextChanging(object sender, ChangingEventArgs e) {            
            
            XComboBoxUnit comboBoxUnit = sender as XComboBoxUnit;
            if (comboBoxUnit == null) {
                return;
            }

            // 验证剂量只能是数字，保留4为小数
            string regextext = @"^(\d+)(\.)?(\d{1,4})?$";
            Regex regex = new Regex(regextext, RegexOptions.None);
            if (e.NewValue == null || string.IsNullOrEmpty(e.NewValue.ToString())) {
                return;
            }
                
            bool isMatch = regex.IsMatch(e.NewValue.ToString());
            if (!isMatch) {
                e.Cancel = true;
            }
            
        }
        void ctrl_ValueTextChanged(object sender, EventArgs e)
        {
            this.onTextValueChanged(sender,this.Row.RowDataSource);
        }

        void ctrl_SelectValueChanged(object sender, EventArgs e)
        {
            this.onUnitSelectChanged(sender,this.Row.RowDataSource);
        }

        private void OnClickedDropDown(object sender, EventArgs e)
        {
            if (this.OnShowDialog != null)
            {
                this.OnShowDialog(sender, e);
            }
        }

        protected virtual void onTextValueChanged(object sender, object ds)
        {

        }

        protected virtual void onUnitSelectChanged(object sender, object ds)
        {

        }
  
        #endregion

    }
}
