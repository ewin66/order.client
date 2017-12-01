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

namespace iih.ci.ord.oporder.cards.extend
{
    public partial class MmForm : XDialog
    {
        public Point Local { get; set; }
        public EmsOrDrug drugmm { get; set; }
         public MmForm()
        {
            this.Text = "";
            this.Size = new Size(800,300);
            //mm
            MmRefView mm = new MmRefView();
            //mm.Location = new Point(2, 2);
            mm.DoubleClickEvent += new EventHandler(mm_DoubleClickEvent);
            mm.Size = new Size(this.Width / 2 - 100, this.Height - 2);
            this.Panel = mm;
            this.Load += new EventHandler(MmForm_Load);
             
        }

         void mm_DoubleClickEvent(object sender, EventArgs e)
         {
             this.drugmm = sender as EmsOrDrug;
             this.DialogResult= DialogResult.OK;
         }

         void MmForm_Load(object sender, EventArgs e)
         {
             this.Location = Local;
         }

    }
}
