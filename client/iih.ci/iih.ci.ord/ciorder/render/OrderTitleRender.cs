using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render;
using System.Drawing;
using xap.cli.sdk.common;

namespace iih.ci.ord.ciorder.render
{
    /// <summary>
    /// 医嘱标题render
    /// </summary>
    public class OrderTitleRender : UserRender
    {
        #region  属性
        public bool IsSelected;

        private Font font;
        private Brush normalBackBrush;
        private Brush selectBackBrush;
        private Brush foreNormalBrush;
        private Brush foreSelectBrush;

        private StringFormat sf;

        private string text;
        public string Text
        {
            get
            {
                return this.text;
            }
            set
            {
                this.text = value;
            }
        }

       
        #endregion

        #region  方法

        public OrderTitleRender()
       {
           this.Size = new Size(24,24);
           this.Enabled = false;
           this.font = new Font("微软雅黑", 12F, GraphicsUnit.Pixel);
           this.normalBackBrush = SkinFactory.Instance().CurrentSkin.ToolButton_Back_Brush;
           this.selectBackBrush = SkinFactory.Instance().CurrentSkin.TabControl_Back_Brush;
           this.foreNormalBrush = SkinFactory.Instance().CurrentSkin.TabControl_Back_Brush;
           this.foreSelectBrush = new SolidBrush(Color.FromArgb(255,255,255));

           sf = new StringFormat();
           sf.Alignment = StringAlignment.Near;
           sf.LineAlignment = StringAlignment.Center;
           SkinFactory.Instance().SkinChanged += new SkinFactory.SkinChangedEventHandler(OrderTitleRender_SkinChanged);
       }

        void OrderTitleRender_SkinChanged()
        {
            this.normalBackBrush = SkinFactory.Instance().CurrentSkin.ToolButton_Back_Brush;
            this.selectBackBrush = SkinFactory.Instance().CurrentSkin.TabControl_Back_Brush;
            this.foreNormalBrush = SkinFactory.Instance().CurrentSkin.TabControl_Back_Brush;
            this.Invalidate();
        }

        public override void Render(Graphics g)
        {
            base.Render(g);
            Rectangle rect = new Rectangle(new Point(this.Bound.X + 4,this.Bound.Y),new Size(this.Bound.Width - 4,this.Bound.Height));
            //先画各个状态下的背景颜色
            if (IsSelected)
            {
                g.FillRectangle(this.selectBackBrush, this.mouseBound);
                g.DrawString(this.text, this.font, this.foreSelectBrush, rect , sf);
            }
            else
            {
                g.FillRectangle(this.normalBackBrush, this.mouseBound);
                g.DrawString(this.text, this.font, this.foreNormalBrush, rect , sf);
            }
        }

        protected override void DisposeManaged()
        {
            SkinFactory.Instance().SkinChanged -= new SkinFactory.SkinChangedEventHandler(OrderTitleRender_SkinChanged);
            base.DisposeManaged();
        }

        #endregion

    }
}
