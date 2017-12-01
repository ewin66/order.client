using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.cli.sdk.controls;
using xap.rui.control.forms.view;
using xap.cli.sdk.render;
using xap.rui.control.forms.control;
using xap.rui.control.formcontrol.model;
using xap.rui.appfw;
using iih.ci.ord.ciordems.d;
using xap.cli.context;
using iih.ci.ord.common.utils.msg;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opemergency.dialog
{
    public partial class ConsInvitedDeptsDialog : XBaseDialog
    {
        private XLayoutPanel rootPanel;
        private XapFormControl xapFormControl;
        private XapFormGridControl gridControl;
        private XButton addButton;
        private XButton deleteButton;
        private XButton saveButton;
        private XButton cancelButton;
        private XapDataList<EmsItemInCons> datasource;
        public ConsInvitedDeptsDialog(object ds)
        {
            datasource = ds as XapDataList<EmsItemInCons>;
            InitializeComponent();
            rootPanel = new XLayoutPanel();
            this.Size = new Size(380, 300);
            this.Name = "受邀科室选择";
            this.Panel = rootPanel;
            this.Panel.Size = this.Size;
            xapFormControl = new XapFormControl();
            this.xapFormControl.AutoSize = true;

            rootPanel.Dock = DockStyle.None;

            this.xapFormControl.Context = null;
            //this.xapFormControl1.Dock = DockStyle.Fill;
            this.xapFormControl.File = null;
            this.xapFormControl.Location = new System.Drawing.Point(0, 0);
            this.xapFormControl.Name = "xapFormControl1";
            this.xapFormControl.Size = new System.Drawing.Size(380, 300);
            this.xapFormControl.TabIndex = 0;
            this.xapFormControl.ViewFile = null;
            rootPanel.AddControl(this.xapFormControl, ControlPosition.Center);

            // 按钮
            this.loadBottomButtons();

            // 初始化事件
            this.xapFormControl.Load += new EventHandler(ConsInvitedDeptsDialog_Load);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            this.xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            this.xapFormControl.RefFilter += new EventHandler<xap.rui.control.refcontrol.events.RefActivatingEventArgs>(xapFormControl_RefFilter);
        }

        void xapFormControl_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_emp_doctor") && e.DataObject is EmsItemInCons)
            {
                e.WherePart = " bd_psndoc.id_dep = '" + (e.DataObject as EmsItemInCons).Id_dep_emp + "'";
            }
        }

        void ConsInvitedDeptsDialog_Load(object sender, EventArgs e)
        {
            this.LoadData();
        }

        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (this.datasource != null)
            {
                this.gridControl.DataTable.DataSource = this.datasource;
            }
        }

        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            gridControl = this.xapFormControl.GetGridView("table");
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_OP_ConsInvitedDeptsDialog;// "20160628084542396JPZ";

            file.FormStyle = FormStyle.List;

            if (this.datasource != null)
            {
                file.ViewModel = this.datasource;
            }

            xapFormControl.ViewFile = file;

            this.xapFormControl.SetEditable(true);

        }

        private void loadBottomButtons()
        {
            // 新增
            addButton = new XButton();
            addButton.Size = new Size(80, 24);
            addButton.Text = "新增";
            addButton.MouseClick += new MouseEventHandler(addButton_MouseClick);
            // 删除
            deleteButton = new XButton();
            deleteButton.Size = new Size(80, 24);
            deleteButton.Text = "删除";
            deleteButton.MouseClick += new MouseEventHandler(deleteButton_MouseClick);

            // 保存
            saveButton = new XButton();
            saveButton.Size = new Size(80, 24);
            saveButton.Text = "保存";
            saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);

            cancelButton = new XButton();
            cancelButton.Size = new Size(80, 24);
            cancelButton.Text = "取消";
            cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);

            this.AddRender_Btn(addButton, deleteButton, saveButton, cancelButton);



        }

        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            this.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.Close();
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            if (this.xapFormControl.HasErrors)
            {
                BizAssMessageBoxUtil.ShowWarningMsg("请选择受邀科室！");
                return;
            }
            this.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.Close();
        }

        void deleteButton_MouseClick(object sender, MouseEventArgs e)
        {
            EmsItemInCons removedItem = gridControl.GetFocusedRow<EmsItemInCons>();
            if (removedItem != null)
                this.datasource.Remove(removedItem);
        }

        void addButton_MouseClick(object sender, MouseEventArgs e)
        {
            EmsItemInCons itemDO = this.datasource.AddNew();

            itemDO.Id_org = UserManager.getInstance().CurrentOrg.Id_org;
            itemDO.Name_org = UserManager.getInstance().CurrentOrg.Name;
        }
    }
}
