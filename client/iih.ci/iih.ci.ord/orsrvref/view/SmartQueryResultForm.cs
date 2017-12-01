using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.form;
using iih.ci.ord.ciorder.cards.extend;
using xap.rui.appfw;
using iih.ci.ord.srvref.d;

namespace iih.ci.ord.orsrvref.view
{
    public partial class SmartQueryResultForm : XDialog
    {
        public SmartQueryResultForm()
        {
            InitializeComponent();
            this.Size = new Size(600, 400);
            this.Text = "";
            or = new SmartQueryResult();
            this.TitleHeight = 0;
            or.DbClickEvent += new SmartQueryResult.DbClickHandle(or_DbClickEvent);
        }

        public Point Local = new Point(1000, 250);
        public SmartQueryResult or;
        public delegate void DbClickHandle(OrScArgs obj);
        public event DbClickHandle DbClickEvent;

        public SmartQueryResultForm(object list)
            : this()
        {
            or = new SmartQueryResult(list);
            or.DbClickEvent += new SmartQueryResult.DbClickHandle(or_DbClickEvent);
        }

        void or_DbClickEvent(OrScArgs obj)
        {
            if (DbClickEvent != null)
            {
                DbClickEvent(obj);
            }
            this.Close();
        }

        public void Shoutdown(bool Disposing)
        {
            this.Dispose(Disposing);
        }

        private void SmartQueryResultForm_Load(object sender, EventArgs e)
        {

            or.Size = new Size(this.Width - 100, this.Height - 2);

            this.Panel = or;
            //this.Location = new Point(Local.X - this.Width, Local.Y);
            this.Location = Local;
        }

        public void setSrvRefData(XapDataList<CiSrvRefResultDTO> resultDtos)
        {
            or.setSrvRefData(resultDtos);
        }

        public void SCTextChanged(object obj)
        {
           
            or.ScTextChanged(obj);
        }

        protected override void DisposeManaged()
        {
            or.DbClickEvent -= new SmartQueryResult.DbClickHandle(or_DbClickEvent);
            base.DisposeManaged();
        }
    }
}
