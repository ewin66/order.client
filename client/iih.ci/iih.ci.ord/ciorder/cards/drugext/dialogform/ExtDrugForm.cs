using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.form;
using xap.mw.serviceframework;
using xap.rui.control.basecontrol;
using xap.rui.appfw;
using iih.mm.itf.material.i;
using iih.mm.itf.material.d;
using xap.cli.sdk.render;
using xap.cli.sdk.controls;
using iih.bd.srv.srvortpl.srvortpl.view;
using iih.ci.ord.ciorder.utils;
using xap.rui.control.extentions;
/********************************************************************************

** 作者： 张万青

** 创始时间：

** 修改人：张万青

** 修改时间：2016-6-30

** 描述： 药品服务拓展内容弹出框


*********************************************************************************/
namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class ExtDrugForm : ContextMenuForm
    {
        public Point Local { get; set; }
        public EmsOrDrug drugmm { get; set; }
        public EmsOrDrug sourcemm{get;set;}
        public ExtOrderDrugDialog mm{get; set;}

        public ExtDrugForm()
        {
        }
        public ExtDrugForm(EmsUIDTO CiHeadDo, EmsOrDrug drug): this()
        {
            InitializeComponent();
            drugmm = new EmsOrDrug();
            sourcemm = drug;
            LogicEx.GetInstance().CopyTo(drug,drugmm);
            mm = new ExtOrderDrugDialog(CiHeadDo, drug);
            splitContainer1.AddControl(this.orCom, xap.cli.sdk.controls.ControlPosition.Bottom, 30);
            splitContainer1.AddControl(mm, xap.cli.sdk.controls.ControlPosition.Center);
            this.saveButton.MouseClick += new MouseEventHandler(saveButton_MouseClick);
            this.cancelButton.MouseClick += new MouseEventHandler(cancelButton_MouseClick);
            this.Controls.Add(splitContainer1);
        }

        void cancelButton_MouseClick(object sender, MouseEventArgs e)
        {
            LogicEx.GetInstance().CopyTo(drugmm, sourcemm,true);
            Close();
        }

        void saveButton_MouseClick(object sender, MouseEventArgs e)
        {
            var msg = mm.HasErroMsgs();
            if (!String.IsNullOrEmpty(msg))
            {
                this.SetStatusMsg(msg);
                return;
            }
            this.DialogResult = DialogResult.OK;
            Invalidate();
        }
        

        private void mm_DoubleClickEvent(object sender, EventArgs e)
        {
            this.drugmm = sender as EmsOrDrug;
            this.DialogResult = DialogResult.OK;
        }
        public void setEdit(bool flag) {
            this.mm.Enabled = flag;
            this.saveButton.Enabled = flag;
            this.cancelButton.Enabled = true;
        }
    }
}
