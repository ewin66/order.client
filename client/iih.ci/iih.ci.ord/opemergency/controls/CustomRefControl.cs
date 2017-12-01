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

namespace iih.ci.ord.opemergency.controls
{
    class CustomRefControl : XSearchBox
    {
        private XapFormGridControl gridControl;
       
        private XRepositoryRefEdit refEdit;

        private XCellRender FocusedCell
        {
            get { return gridControl.FocusedCell; }
        }

        private string FieldName
        {
            get { return FocusedCell.FieldName; }
        }

        private XapDataList<EmsItemInCons> DataObj
        {
            get { return (gridControl.DataTable.DataSource as XapDataList<EmsConsItemDO>).FirstOrDefault().EmsConsAssistItem; }
        }

        public CustomRefControl(XapFormGridControl gc, XRepositoryRefEdit edit)
            : base()
        {
            
            gridControl = gc;
            refEdit = edit;

            AutoShowClearButton = false;

            ValueTextChanged += MySearchBox_ValueTextChanged;
            this.KeyPress += new KeyPressEventHandler(CustomRefControl_KeyPress);
        }

        void CustomRefControl_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (FocusedCell == null)
                return;

            ConsInvitedDeptsDialog panel = new ConsInvitedDeptsDialog(DataObj);
            panel.ShowDialog();
            // 保存
            if (panel.DialogResult == DialogResult.OK)
            {
                FocusedCell.SetValue(ConstructInvitedDeptInfo(this.DataObj));
                //gridControl.DataTableShared.CloseEditor(null);
                gridControl.CloseEditor();
            }
        }

        private void MySearchBox_ValueTextChanged(object sender, EventArgs e)
        {
            if (FocusedCell == null || DataObj == null || !refEdit.Visible)
                return;
            FocusedCell.SetValue(ConstructInvitedDeptInfo(this.DataObj));
        }
        
        protected override void OnButtonClick(object sender, MouseEventArgs e)
        {
            if (FocusedCell == null)
                return;

            ConsInvitedDeptsDialog panel = new ConsInvitedDeptsDialog(DataObj);
            panel.ShowDialog();
            // 保存
            if (panel.DialogResult == DialogResult.OK)
            {
                FocusedCell.SetValue(ConstructInvitedDeptInfo(this.DataObj));
                //gridControl.DataTableShared.CloseEditor(null);
                gridControl.CloseEditor();
            }

        }

        /// <summary>
        /// 拼接受邀科室、受邀医生
        /// </summary>
        /// <param name="itemList"></param>
        /// <returns></returns>
        public static string ConstructInvitedDeptInfo(XapDataList<EmsItemInCons> itemList)
        {
            string info = "";

            if (itemList != null)
            {
                foreach (EmsItemInCons item in itemList)
                {
                    // 受邀科室为空时，受邀医生肯定为空（受邀方选择框中，新增空行是受邀科室会为空值）
                    if (string.IsNullOrEmpty(item.Name_dep_emp))
                    {
                        continue;
                    }
                    
                    info += "、" + item.Name_dep_emp;
                    if (!string.IsNullOrEmpty(item.Name_emp_doctor))
                    {
                        info += String.Format("({0}医生)", item.Name_emp_doctor);
                    }                    
                }
            }
            if (!string.IsNullOrEmpty(info))
            {
                return info.Substring(1);
            }
            return "";
        }
    }
}
