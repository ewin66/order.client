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
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class SkinTestForm : XDialog
    {
        private SkinTestDialog mm;
        public SkinTestForm(EmsOrDrug drug,FDateTime dt_act)
        {
            this.Text = "强制使用说明";
            this.Size = new Size(470,180);
            mm = new SkinTestDialog(drug,dt_act);
            mm.btnClickEvent += new EventHandler(mm_btnClickEvent);
            mm.cancelClickEvent += new EventHandler(mm_cancelClickEvent);
            this.Panel = mm;

        }

        void mm_cancelClickEvent(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
        }

        void mm_btnClickEvent(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.OK;
            Invalidate();
        }
        private void MmForm_Load(object sender, EventArgs e)
        {
            //this.Location = Local;
        }
       
    }
}
