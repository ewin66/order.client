using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.dto.consdto.d;
using xap.cli.sdk.render;
using xap.rui.appfw;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciordcons.dialog
{
    public partial class ConsReviewDialog : XBaseDialog
    {
     
        private XapFormGridControl gv;
        public OrdConsDTO dto;

        public ConsReviewDialog(OrdConsDTO consDto)
        {
            InitializeComponent();
            SetXapFormControl();
            AddButtons(true);
            xapFormControl.Load += xapFormControl_Load;
            this.dto = consDto;
            this.xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            this.Closed += new EventHandler(ConsReviewDialog_Closed);
        }

        void ConsReviewDialog_Closed(object sender, EventArgs e)
        {
            this.xapFormControl.ClearFormData();
        }


        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            gv = this.xapFormControl.GetGridView("setitem");
            
        }

  
        private void SetXapFormControl()
        {
            //窗体中控件布局
            xapFormControl = new XapFormControl
            {
                Location = Panel.Location,
                Width = Panel.Width,
                Height = Panel.Height
            };
            xapFormControl.SetEditPolicy(true);
            Panel = xapFormControl;
        }
        
        /// <summary>
        /// 添加按钮，设置窗口名称
        /// </summary>
        /// <param name="add">false为编辑，ture为新增</param>
        private void AddButtons(bool add)
        {
            saveButton = new XButton { Size = new Size(75, 25), Text = "确定" };
            cancelButton = new XButton { Size = new Size(75, 25), Text = "取消" };
            saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);
            cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);
            Text = @"会诊审批";
            AddRender_Btn(saveButton, cancelButton);

        }
        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            Close();
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            if (this.xapFormControl.HasErrors) {
                this.ShowInfo(this.xapFormControl.ErrorAlertText);
                return;
            }
            DialogResult = DialogResult.OK;
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConsReviewDialog;// "20160614043328753D6M";
            file.FormStyle = FormStyle.Card;
            if (this.dto != null)
                file.ViewModel = this.dto;
            xapFormControl.ViewFile = file;
        }

        private void xapFormControl_Load(object sender, EventArgs e)
        {
            OnFillData();
        }
    }
}
