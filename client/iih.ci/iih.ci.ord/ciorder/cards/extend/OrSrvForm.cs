using System;
using System.Drawing;
using xap.cli.sdk.form;
using System.Windows.Forms;

namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class OrSrvForm : XDialog
    {
        public Point Local = new Point(1000, 250);
        public OrderScEx or;
        public delegate void DbClickHandle(OrScArgs obj);
        public event DbClickHandle DbClickEvent;

        public OrSrvForm()
        {
            InitializeComponent();
            this.Size = new Size(600, 400);
            this.Text = "";
            or = new OrderScEx();
            this.TitleHeight = 0;
            or.DbClickEvent += new OrderScEx.DbClickHandle(or_DbClickEvent);
        }

        public OrSrvForm(object list)
            : this()
        {
            or = new OrderScEx(list);
            or.DbClickEvent += new OrderScEx.DbClickHandle(or_DbClickEvent);
        }

        void or_DbClickEvent(OrScArgs obj)
        {
            if (DbClickEvent != null)
            {
                DbClickEvent(obj);
            }
            this.Close();
        }

        //protected override bool ProcessDialogKey(Keys keyData)
        //{
        //    if (keyData == Keys.Enter)
        //    {
        //        if (this.or.gv.DataTable != null)
        //            this.or.gv_DoubleClick(null, null);
        //        this.Close();
        //        return true;
        //    }
        //    return base.ProcessDialogKey(keyData);

        //}

        public void Shoutdown(bool Disposing)
        {
            this.Dispose(Disposing);
        }
        
        private void OrSrvForm_Load(object sender, EventArgs e)
        {
            or.Size = new Size(this.Width - 100, this.Height - 2);

            this.Panel = or;
            //this.Location = new Point(Local.X - this.Width, Local.Y);
            this.Location = Local;
        }

        public void SCTextChanged(object obj)
        {
            or.ScTextChanged(obj);
        }

        protected override void DisposeManaged()
        {
            or.DbClickEvent -= new OrderScEx.DbClickHandle(or_DbClickEvent);
            base.DisposeManaged();
        }

        protected override bool ProcessDialogKey(Keys keyData)
        {
            if (keyData == Keys.Enter)
            {
                if (or.gv.DataTable != null)
                   or.gv_DoubleClick(null, null);
            }
            return base.ProcessDialogKey(keyData);
        }
    }
}
