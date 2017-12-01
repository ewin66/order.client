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
    /// 字母render
    /// </summary>
    public class AlphabetRender : XBaseButton
    { 
        #region  属性
        public bool IsSelected;
        private Font font;
        private Brush moveBackBrush;
        private Brush selectBackBrush;

        private Brush foreNormalBrush;
        private Brush foreSelectBrush;
        private Brush foreDisableBrush;
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

        private bool enabled = true;
        public override bool Enabled
        {
            set
            {
                if (value == this.enabled)
                {
                    return;
                }
                else
                {
                    if (true == value)
                    {
                        ButtonState = ButtonRenderState.Normal;
                    }
                    else
                    {
                        ButtonState = ButtonRenderState.Disable;
                    }
                    base.Enabled = value;
                    this.enabled = value;
                    this.Invalidate();
                }
            }
            get
            {
                return enabled;
            }
        }

        #endregion

        #region  方法

        public AlphabetRender()
       {
           this.Size = new Size(24,24);
           this.font = new Font("微软雅黑", 12F, GraphicsUnit.Pixel);
           this.moveBackBrush = SkinFactory.Instance().CurrentSkin.ToolButton_Back_Brush;
           this.selectBackBrush = SkinFactory.Instance().CurrentSkin.TabControl_Back_Brush;
           this.foreNormalBrush = SkinFactory.Instance().CurrentSkin.TabControl_Back_Brush;
           this.foreSelectBrush = new SolidBrush(Color.FromArgb(255,255,255));
           this.foreDisableBrush = new SolidBrush(Color.FromArgb(178,178,178)); 
           sf = new StringFormat();
           sf.Alignment = StringAlignment.Center;
           sf.LineAlignment = StringAlignment.Center;
           SkinFactory.Instance().SkinChanged += new SkinFactory.SkinChangedEventHandler(AlphabetRender_SkinChanged);
       }

        void AlphabetRender_SkinChanged()
        {
            this.moveBackBrush = SkinFactory.Instance().CurrentSkin.ToolButton_Back_Brush;
            this.selectBackBrush = SkinFactory.Instance().CurrentSkin.TabControl_Back_Brush;
            this.foreNormalBrush = SkinFactory.Instance().CurrentSkin.TabControl_Back_Brush;
            this.Invalidate();
        }

        public override void Render(Graphics g)
        {
            base.Render(g);
            //先画各个状态下的背景颜色
            if (IsSelected)
            {
                g.FillRectangle(this.selectBackBrush, this.mouseBound);
                if (this.text == "OTHER")
                {
                    g.DrawString("其他", this.font, this.foreSelectBrush, this.mouseBound, sf);
                }
                else
                {
                    g.DrawString(this.text, this.font, this.foreSelectBrush, this.mouseBound, sf);
                }
            }
            else
            {
                Brush fillBrush = null;
                Brush foreBrush = null;
                switch (ButtonState)
                {
                    case ButtonRenderState.Normal:
                        foreBrush = this.foreNormalBrush;
                        break;
                    case ButtonRenderState.Down:
                        foreBrush = this.foreSelectBrush;
                        fillBrush = this.selectBackBrush;
                        g.FillRectangle(fillBrush, this.mouseBound);
                        break;
                    case ButtonRenderState.Disable:
                        foreBrush = this.foreDisableBrush;
                        break;
                    default:
                        fillBrush = this.moveBackBrush;
                        foreBrush = this.foreNormalBrush;
                        g.FillRectangle(fillBrush, this.mouseBound);
                        break;
                }
                if (this.text == "OTHER")
                {
                    g.DrawString("其他", this.font, foreBrush, this.mouseBound, sf);
                }
                else
                {
                    g.DrawString(this.text, this.font, foreBrush, this.mouseBound, sf);
                }
            }
        }

        protected override void OnMouseDown(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            ButtonState = ButtonRenderState.Down;
            this.Invalidate();
            base.OnMouseDown(sender, e);
        }

        protected override void OnMouseMove(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (this.ButtonState == ButtonRenderState.Down)
            {
                return;
            }
            base.OnMouseMove(sender, e);
        }

        protected override void OnMouseLeave(object sender, EventArgs e)
        {
            if (this.ButtonState == ButtonRenderState.Down)
            {
                return;
            }
            base.OnMouseLeave(sender, e);
        }

        protected override void DisposeManaged()
        {
            SkinFactory.Instance().SkinChanged -= new SkinFactory.SkinChangedEventHandler(AlphabetRender_SkinChanged);
            base.DisposeManaged();
        }
        #endregion
    }
}
