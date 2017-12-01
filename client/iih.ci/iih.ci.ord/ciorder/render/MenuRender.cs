using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render;
using System.Drawing;
using xap.cli.sdk.controls;
using System.Reflection;
using xap.cli.sdk.common;
using xap.rui.bizcontrol.workstation.config;
using iih.ci.ord.ciorder.view;

namespace iih.ci.ord.ciorder.render
{
    public class MenuRender : XSelectButton
    {
        Rectangle menuRect;
        Image unfoldIcon;
        Image foldIcon;
        Image foldIconWhite;
        Rectangle iconRect;
        SolidBrush groupBrush = new SolidBrush(Color.FromArgb(210,245,255));
        SolidBrush ChildBrush = new SolidBrush(Color.FromArgb(228, 249, 255));
        SolidBrush MoveBrush = new SolidBrush(Color.FromArgb(120,210,235));
        //Brush TempBrush = null;
        public override Point Location
        {
            get
            {
                return base.Location;
            }
            set
            {
                if (value.X < -1200 || value.Y < -1200)
                    return;
                base.Location = value;
                this.iconRect.Location = new Point(value.X + 10, value.Y + 10);
                this.Invalidate();
            }
        }
        public Rectangle IconRect
        {
            get { return iconRect; }
            set { iconRect = value; }
        }
        bool isUnfold;//是否为展开，true：展开；false：折叠

        public bool IsUnfold
        {
            get { return isUnfold; }
            set { isUnfold = value; }
        }
        bool isParent;//是否为父节点。true:父节点；false:子节点

        public bool IsParent
        {
            get { return isParent; }
            set { isParent = value; }
        }
        Dictionary <string,MenuRender> subMenuList;

        public Dictionary<string, MenuRender> SubMenuList
        {
            get { return subMenuList; }
            set { subMenuList = value; }
        }
        public MenuRender()
        {
            this.Size = new Size(126, 38);
            Font = new Font("微软雅黑", 13, GraphicsUnit.Pixel);
            this.iconRect = new Rectangle(this.Bound.X + 10, this.Bound.Y + 10, 16, 16);
            FontBrush = new SolidBrush(Color.Black);
            menuRect = new Rectangle(this.Location, this.Size);
            Init();
            isUnfold = false;
            subMenuList = new Dictionary<string, MenuRender>();
           
        }
        protected void Init()
        {
            unfoldIcon = Bitmap.FromStream(Assembly.GetCallingAssembly().GetManifestResourceStream("iih.ci.ord.Resources.展开.png"));
            foldIcon = Bitmap.FromStream(Assembly.GetCallingAssembly().GetManifestResourceStream("iih.ci.ord.Resources.折叠2.png"));
            foldIconWhite = Bitmap.FromStream(Assembly.GetCallingAssembly().GetManifestResourceStream("iih.ci.ord.Resources.折叠.png"));
        }
       
        public override void Render(System.Drawing.Graphics g)
        {
            if (this.SubMenuList.Count > 0)
            {
                if (IsUnfold)
                {
                    g.FillRectangle(groupBrush, this.Bound);
                    ForeImage = unfoldIcon;
                }
                else
                {
                    //if (ButtonState == xap.cli.sdk.common.ButtonRenderState.Move)
                    //    //ForeImage = foldIconWhite;
                    //else
                    //{
                        ForeImage = foldIcon;
                   // }
                }
            }
            if (!this.IsParent)
            {
                g.FillRectangle(groupBrush, this.Bound);
            }
            if (IsSelect)
            {
                g.FillRectangle(DownButtonBrush, this.Bound);
            }
            else if (ButtonState == xap.cli.sdk.common.ButtonRenderState.Move)
            {
                if (IsParent)
                    g.FillRectangle(MoveButtonBrush, this.Bound);
                else
                {
                    g.FillRectangle(MoveBrush, this.Bound);
                }
            }
            if (ForeImage != null)
                g.DrawImage(ForeImage, new Point(this.Bound.Left+ 3, this.Bound.Top + (this.Bound.Height - ForeImage.Size.Height) / 2));
            SizeF textSize = g.MeasureString(Text, Font);
            g.DrawString(Text, Font, FontBrush, new PointF(this.Bound.Left +16, this.Bound.Top + (this.Bound.Height - textSize.Height) / 2));
           // g.DrawRectangle(new Pen(Color.Red),this.Bound);
        }
        protected override void OnMouseLeave(object sender, EventArgs e)
        {
            base.OnMouseLeave(sender, e);
            ButtonState = xap.cli.sdk.common.ButtonRenderState.Normal;
        }
        protected override void OnMouseMove(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            base.OnMouseMove(sender, e);
            if (this.Bound.Contains(e.Location))
            {
                ButtonState = xap.cli.sdk.common.ButtonRenderState.Move;
            }
        }
    }
}
