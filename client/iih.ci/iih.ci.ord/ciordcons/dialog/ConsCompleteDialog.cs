using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.dto.consdto.d;
using xap.cli.sdk.render;
using xap.rui.appfw;
using xap.rui.appfw.collections;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciordcons.dialog
{
    public partial class ConsCompleteDialog : XBaseDialog
    {
     
        private XapFormGridControl gv;
        public XapAggDO<CiorappconsultAggDO> aggdo;

        public ConsCompleteDialog(XapAggDO<CiorappconsultAggDO> consDto)
        {
            InitializeComponent();
            SetXapFormControl();
            AddButtons(true);
            xapFormControl.Load += xapFormControl_Load;
            this.aggdo = consDto;
            this.xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            this.Closed += new EventHandler(ConsReviewDialog_Closed);
        }

        void ConsReviewDialog_Closed(object sender, EventArgs e)
        {
            this.xapFormControl.ClearFormData();
        }

        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            DataPolicy ploicy = new DataPolicy();
            ploicy.FullEdit = true;
            ploicy.AllowEdit = true;
            ploicy.ClassName = "iih.ci.ord.cior.d.CiordInviteConsDO";
            this.xapFormControl.SetEditPolicy(true, new DataPolicy[] { ploicy });
            gv = this.xapFormControl.GetGridView("grid");
            gv.DataTable.Columns["Name_dep"].ReadOnly = true;
        }


        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            

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
            Text = @"完成会诊";
            AddRender_Btn(saveButton, cancelButton);

        }
        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            Close();
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            bool flag = false;
            foreach (CiordInviteConsDO inviteCons in aggdo.AggDO.getCiordInviteConsDO())
            {
                if (inviteCons.Fg_join_cons == true)
                    flag = true;
            }
            if (flag)
            {
                DialogResult = DialogResult.OK;

            }
            else
            {
                this.ShowInfo("该会诊无科室参加，请走作废医嘱流程！", "提示");
            }

        }


        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConsCompleteDialog;// "201606210203196530BV";
            file.FormStyle = FormStyle.List;
            if (this.aggdo != null)
                file.ViewModel = this.aggdo;
            xapFormControl.ViewFile = file;
        }

        private void xapFormControl_Load(object sender, EventArgs e)
        {
            OnFillData();
        }
    }
}
