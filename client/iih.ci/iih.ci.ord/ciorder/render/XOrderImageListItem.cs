using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render;
using System.Drawing;
using System.Windows.Forms;
using xap.cli.sdk.common;

namespace iih.ci.ord.ciorder.render
{
    public class XOrderImageListItem : XListItem
    {
        public Image FlagIcon { get; set; }
        private Size fontSize;
        private Color foreColor;
        private int itemHeight;
        public int ItemHeight
        {
            get
            {
                return this.itemHeight;
            }
            set
            {
                if (this.itemHeight != value)
                {
                    this.itemHeight = value;
                    this.Size = new Size(this.Size.Width, value);
                }

            }
        }

        #region 构造函数

        public XOrderImageListItem()
        {
            this.Init();
        }

        public XOrderImageListItem(string item)
        {
            this.Text = item;
            this.Init();
        }

        private void Init()
        {
            this.DrawFont = new Font("微软雅黑", 12F, GraphicsUnit.Pixel);
            this.itemHeight = 24;
            this.Size = new Size(248, 24);
            this.fontSize = TextRenderer.MeasureText("全", this.DrawFont);
            this.foreColor = Color.FromArgb(47, 47, 47);
            this.Id = this.GetHashCode().ToString();
        }

        #endregion

        #region 内部方法

        public override void Render(Graphics g)
        {
            //文本色刷 
            Brush drawBrush = new SolidBrush(foreColor);
            Brush fillBrush = null;
            Pen borderPen = null;
            switch (ItemState)
            {
                case RenderState.Normal:
                    break;
                case RenderState.Down:
                    borderPen = SkinFactory.Instance().CurrentSkin.SelectedBorderPen;
                    fillBrush = SkinFactory.Instance().CurrentSkin.ToolButton_Back_Brush;
                    g.FillRectangle(fillBrush, this.mouseBound);
                    g.DrawRectangle(borderPen, new Rectangle(this.Location.X + 1, this.Location.Y + 1, this.Size.Width - 2, this.Size.Height - 2));
                    break;
                case RenderState.Disable:
                    break;
                default:
                    borderPen = SkinFactory.Instance().CurrentSkin.SelectedBorderPen;
                    g.DrawRectangle(borderPen, new Rectangle(this.Location.X + 1, this.Location.Y + 1, this.Size.Width - 2, this.Size.Height - 2));
                    break;
            }
            Rectangle drawStringRect;
            if (FlagIcon != null)
            {
                g.DrawImage(FlagIcon, new Point(this.Bound.X + 10, this.Bound.Y + (this.Bound.Height - FlagIcon.Height) / 2));
                drawStringRect = new Rectangle(new Point(this.Bound.X + 10 + 8 + FlagIcon.Width, this.Bound.Y + (this.Bound.Height - this.fontSize.Height) / 2), new Size(this.Bound.Width - 10 - 8 - FlagIcon.Width, this.fontSize.Height));
            }
            else
            {
                drawStringRect = new Rectangle(new Point(this.Bound.X + 10 + 8 + 16, this.Bound.Y + (this.Bound.Height - this.fontSize.Height) / 2), new Size(this.Bound.Width - 10 - 8 - 16, this.fontSize.Height));
            }
            g.DrawString(this.Text, DrawFont, drawBrush, drawStringRect, _drawFormat);
        }

        protected override void OnMouseDown(object sender, MouseEventArgs e)
        {
            if (Contains(e.Location))
            {
                ItemState = RenderState.Down;
                this.Invalidate();
            }
            base.OnMouseDown(sender, e);
        }

        protected override void OnMouseMove(object sender, MouseEventArgs e)
        {
            if (ItemState == RenderState.Down)
            {
                return;
            }
            if (this.Contains(e.Location))
            {
                if (ItemState != RenderState.Move)
                {
                    ItemState = RenderState.Move;
                    this.Invalidate();
                }
            }
            else
            {
                if (ItemState != RenderState.Normal)
                {
                    ItemState = RenderState.Normal;
                    this.Invalidate();
                }
            }
            base.OnMouseMove(sender, e);
        }

        protected override void OnMouseLeave(object sender, EventArgs e)
        {
            if (ItemState == RenderState.Down)
            {
                return;
            }
            if (ItemState != RenderState.Normal)
            {
                ItemState = RenderState.Normal;
                this.Invalidate();
            }
            base.OnMouseLeave(sender, e);
        }

        protected override void DisposeManaged()
        {
            this.FlagIcon = null;
            base.DisposeManaged();
        }

        #endregion
    }
}
