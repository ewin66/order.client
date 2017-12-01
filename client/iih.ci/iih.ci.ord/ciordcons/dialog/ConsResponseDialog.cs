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
using xap.cli.context;
using xap.cli.sdk.render;
using xap.rui.appfw;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.events;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciordcons.dialog
{
    public partial class ConsResponseDialog : XBaseDialog
    {
     
        private XapFormGridControl gv;
        public OrdConsDTO dto;

        public ConsResponseDialog(OrdConsDTO consDto)
        {
            InitializeComponent();
            SetXapFormControl();
            AddButtons(true);
            xapFormControl.Load += xapFormControl_Load;
            this.dto = consDto;
            this.xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            this.xapFormControl.RefFilter += new EventHandler<RefActivatingEventArgs>(xapFormControl_RefFilter);
            
            //MouseClick += Add_MouseClick;//添加鼠标点击事件
            this.Closed += new EventHandler(ConsReviewDialog_Closed);
        }

        void ConsReviewDialog_Closed(object sender, EventArgs e)
        {
            this.xapFormControl.ClearFormData();
        }

        void xapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Emp_name"))
            {
                string str = string.Format("bd_psndoc.id_dep='{0}'", UserManager.getInstance().CurrentDept.Id_dep);
               
                if (this.dto.Fg_emptitlelimit == true && !string.IsNullOrEmpty(this.dto.Id_emptitle))
                {
                    string id_emptitles = "";
                    string[] ids = this.dto.Id_emptitle.Split(',');
                    foreach (string id in ids)
                    {
                        id_emptitles += "'" + id + "',";
                    }
                    str += " and bd_psndoc.id_emptitle in (" + id_emptitles.Substring(0, id_emptitles.Length - 1) + ")";
                }
                if (str == "") return;
                e.WherePart = str;
            }
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
            Text = @"同意会诊";
            AddRender_Btn(saveButton, cancelButton);

        }

        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            Close();
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            if (this.xapFormControl.HasErrors)
            {
                this.ShowInfo(this.xapFormControl.ErrorAlertText);
                return;
            }

            DialogResult = DialogResult.OK;
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConsResponseDialog;// "20160614031217785N2P";
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
