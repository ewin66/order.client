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
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.cli.sdk.render.labelcontrol;
using xap.mw.coreitf.d;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class SkinTestDialog : XapBaseControl
    {
        XLabelBaseUserRender reason;
        private EmsOrDrug drug;
        private FDateTime dt_act;
        public SkinTestDialog(EmsOrDrug drug,FDateTime dt_act)
        {
            InitializeComponent();
            this.drug = drug;
            this.dt_act = dt_act;
            xapFormControl.Load += xapFormControl_Load;
            xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
        }
        public event EventHandler btnClickEvent;
        public event EventHandler cancelClickEvent;
        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            object o = xapFormControl.GetUserRender("skinwarn", "skininfo");
            XLabel label = xapFormControl.GetUserRender("skinwarn", "skininfo") as XLabel;
            label.IsMoreLine = true;
            label.ValueText = "患者于" + this.dt_act == null ? "" : this.dt_act.ToTarget.ToString("yyyy-MM-dd") + "发现对" + drug.Name_mm + "过敏！";
            reason = xapFormControl.GetUserRender("skinwarn", "skinreson") as XLabelBaseUserRender;
            reason.NullFlag = false;
            XButton saveBtn = xapFormControl.GetUserRender("skinwarn", "savebtn") as XButton;
            saveBtn.MouseClick += new MouseEventHandler(saveBtn_MouseClick);
            XButton cancelBtn = xapFormControl.GetUserRender("skinwarn", "cancelbtn") as XButton;
            cancelBtn.MouseClick += new MouseEventHandler(cancelBtn_MouseClick);
        }

        void saveBtn_MouseClick(object sender, MouseEventArgs e)
        {
            if (btnClickEvent != null)
            {
                if (xapFormControl.HasErrors)
                {
                    return;
                }
                drug.Id_skintest_skip_reason = reason.ValueText;
                btnClickEvent(this, e);
            }
        }
        void cancelBtn_MouseClick(object sender, MouseEventArgs e)
        {
            if (cancelClickEvent != null)
            {
                cancelClickEvent(this, e);
            }
        }
        protected override void OnFillData()
        {
            FormFile file = new FormFile
            {
                FormId = "20160614080908245M8G",
                FormStyle = FormStyle.Card
            };
            xapFormControl.ViewFile = file;
            xapFormControl.SetEditPolicy(true);
        }
        private void xapFormControl_Load(object sender, EventArgs e)
        {
            OnFillData();
        }
    }
}
