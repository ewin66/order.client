using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.render;
using xap.cli.sdk.controls.SuspendForm;
using xap.cli.sdk.render.Items;
using xap.cli.context.token;
using xap.sys.xbd.udi.d;
using xap.sys.xbd.udi.i;
using xap.mw.serviceframework;
using xap.mw.coreitf.d;
using xap.cli.sdk.controls;
using iih.ci.ord.ciorder.render;


namespace iih.ci.ord.ciorder.cards
{
    public partial class Doctoradvices : ContextMenuForm
    {
        public XButton btnOk;
        public XButton btnCancel;
        public List<OrderInputRender> RenderList = new List<OrderInputRender>();
        public List<OrderRender> OrderRenderlist = new List<OrderRender>();
        public bool Twoflag { get; set; }
        private OrderInputRender selectRender;
        public OrderInputRender SelectRender
        {
            get { return selectRender; }
            set
            {
                if (selectRender != value)
                {
                    if (selectRender != null)
                    {
                        selectRender.IsSelect = false;
                    }
                    selectRender = value;
                    selectRender.IsSelect = true;
                    //向模型发起切换请求
                    // nodeChanged();
                }
            }
        }
        public Doctoradvices()
        {

            this.Size = new Size(401, 451);
            this.Location = new Point(100, 10);
            this.DarkEdgeBrush = new SolidBrush(Color.FromArgb(0, 153, 229));
            Twoflag = false;
            btnOk = new XButton();

            btnOk.Text = "确认";
            btnOk.Location = new Point(this.Width - btnOk.Size.Width * 2 - 50, this.Size.Height - btnOk.Size.Height - 6);
            btnCancel = new XButton();
            btnCancel.Text = "取消";
            btnCancel.Location = new Point(btnOk.Location.X + btnOk.Size.Width + 25, btnOk.Location.Y);
            this.AddRender(btnOk);
            this.AddRender(btnCancel);
            this.MouseClick += new MouseEventHandler(Doctoradvices_MouseClick);

            this.SizeChanged += new EventHandler(Doctoradvices_SizeChanged);

        }

        void Doctoradvices_SizeChanged(object sender, EventArgs e)
        {
            Size ss = (sender as Doctoradvices).Size;
          //  btnOk.Location = new Point(this.Width - btnOk.Size.Width * 2 - 50, this.Size.Height - btnOk.Size.Height - 6);
           // btnCancel.Location = new Point(btnOk.Location.X + btnOk.Size.Width + 25, btnOk.Location.Y);
        }

        void Doctoradvices_MouseClick(object sender, MouseEventArgs e)
        {
            foreach (OrderInputRender render in this.RenderList)
            {
                if (render.Bound.Contains(e.Location) && render.Visible)
                {
                    SelectRender = render;
                    int StartY = 10;
                    int Begin = 75;
                    if (Twoflag)
                    {
                        Begin = 75 + 85;
                    }
                    foreach (OrderRender Ur in this.OrderRenderlist)
                    {
                        this.RemoveRender(Ur);
                    }
                    this.OrderRenderlist.Clear();
                    int StartX=Begin;
                    foreach (OrderRender item in render.Items)
                    {
                        item.Size = new System.Drawing.Size(170, item.Size.Height);
                        if (item.Size.Width + StartX + 5 > this.Size.Width - 1)
                        {
                            StartX = Begin;
                            StartY += item.Size.Height;
                        }
                        item.Location = new Point(StartX, StartY);
                        StartX += item.Size.Width + 10;
                        this.AddRender(item);
                    }
                }
            }
            Invalidate();
        }
        public override void AddRender(object obj)
        {
            if (obj is OrderInputRender)
            {
                Twoflag = true;
                this.RenderList.Add((obj as OrderInputRender));
            }
            if (obj is OrderRender)
            {
                this.OrderRenderlist.Add((obj as OrderRender));
            }
            base.AddRender(obj);
        }
        void Doctoradvice_MouseClick(object sender, MouseEventArgs e)
        {

        }
        protected override void OnPaint(PaintEventArgs e)
        {
            int width = 0;
            e.Graphics.FillRectangle(new SolidBrush(Color.FromArgb(212, 246, 255)), new Rectangle(0, 0, 76, this.Height - 35));
            if (Twoflag)
            {
                e.Graphics.FillRectangle(new SolidBrush(Color.FromArgb(228, 249, 255)), new Rectangle(75, 0, 85, this.Height - 35));
                width = 85;
            }
            e.Graphics.FillRectangle(new SolidBrush(Color.FromArgb(255, 255, 255)), new Rectangle(75 + width, 0, this.Size.Width - 76 - width, this.Height - 35));
            base.OnPaint(e);
        }

    }
}
