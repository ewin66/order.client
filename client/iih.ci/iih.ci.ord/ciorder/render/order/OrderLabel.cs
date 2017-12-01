/*****************************************************************************
* Author      : 王玉龙(wang.yulong@founder.com.cn)
* CLR版本     : 4.0.30319.36388
* CreatedTime : 2017/5/10 15:49:02
* Filename    : OrderExtAssist
* Project     : iih.ci.ord.ciorder.render.order
* Username    : f
* Description : 医嘱模板--专用Label控件
*****************************************************************************/
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.sdk.chart;
using xap.cli.sdk.render;
using xap.mw.log.Appender;
using xap.rui.engine.xactions;

namespace iih.ci.ord.ciorder.render.order
{
    /// <summary>
    /// 
    /// </summary>
    public class OrderLabel:UserRender
    {
        #region 属性


        private String _valueText;

        /// <summary>
        /// 文字值
        /// </summary>
        public String ValueText { 
            get { return _valueText; }
            set
            {
                _valueText = value;
                if (IsSuitScreenRelative)
                {
                    this.Font = Shared.DefaultFont;
                }
                if (TextCellRender.MeasureText(_valueText, this.Font).Width > this.Size.Width)
                {
                    this.IsShowTip = true;
                }
                else
                {
                    this.IsShowTip = false;
                }
            }
        }

        public override Size Size
        {
            get { return base.Size; }
            set
            {
                base.Size = value;
                if (TextCellRender.MeasureText(_valueText, this.Font).Width > this.Size.Width)
                {
                    this.IsShowTip = true;
                }
                else
                {
                    this.IsShowTip = false;
                }
            }
        }

        /// <summary>
        /// 字体
        /// </summary>
        public Font Font { get; set; }

        /// <summary>
        /// 渲染格式
        /// </summary>
        public StringFormat Format { get; set; }

        /// <summary>
        /// 是否显示ToolTip
        /// </summary>
        public bool IsShowTip { get; set; }

        /// <summary>
        /// 是否适应屏幕分辨率
        /// </summary>
        public bool IsSuitScreenRelative { get; set; }

        #endregion

        #region 构造

        public OrderLabel()
        {
            this.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.Format = new StringFormat()
            {
                LineAlignment = StringAlignment.Center,
                Alignment = StringAlignment.Near,
            };
            this.Format.FormatFlags = StringFormatFlags.NoWrap;
            this.Format.Trimming = StringTrimming.EllipsisCharacter;



        }

        #endregion

        #region 渲染

        public override void Render(Graphics g)
        {
            base.Render(g);

           // g.FillRectangle(new SolidBrush(Color.Blue),this.Bound );
            if (IsSuitScreenRelative)
            {
                using (SolidBrush brush = new SolidBrush(Color.FromArgb(76, 76, 76)))
                {
                    g.DrawString(this.ValueText, Shared.DefaultFont, brush, this.Bound, Format);
                }
            }
            else
            {
                using (SolidBrush brush = new SolidBrush(Color.FromArgb(76, 76, 76)))
                {
                    g.DrawString(this.ValueText, this.Font, brush, this.Bound, Format);
                }
            }


           
        }

        #endregion

        #region 重写

        protected override void OnMouseMove(object sender, MouseEventArgs e)
        {
            if (this.IsShowTip)
            {
                if (this.Bound.Contains(e.Location))
                    TooltipManager.Instance.ShowCurrentTooltip(this.ValueText);
            }
            base.OnMouseMove(sender, e);
        }

        protected override void OnMouseLeave(object sender, EventArgs e)
        {
            TooltipManager.Instance.HideTooltip();
            base.OnMouseLeave(sender, e);
        }

        #endregion

        #region 内部类 控制Tooltip显示

        /// <summary>
        /// 共享同一个鼠标提示。带有显示延迟，当鼠标进入按钮时，不立刻显示。
        /// </summary>
        private sealed class TooltipManager
        {
            [ThreadStatic]
            private static TooltipManager _instance;

            /// <summary>
            /// 单例实例
            /// </summary>
            public static TooltipManager Instance
            {
                get
                {
                    if (_instance == null)
                        _instance = new TooltipManager();
                    return _instance;
                }
            }

            public bool IsShowingToolTip
            {
                get { return _toolTip.IsShowing; }
            }

            private XToolTipRender _toolTip;
            private Timer _reshowDelayTimer;

            private const int DefaultReShowDelay = 300;

            private String _text = "";

            /// <summary>
            /// 初始化 <see cref="T:System.Object"/> 类的新实例。
            /// </summary>
            private TooltipManager()
            {
                _toolTip = new XToolTipRender();
            }


            /// <summary>
            /// 隐藏当前的鼠标提示
            /// </summary>
            public void HideTooltip()
            {
                _toolTip.Hide();
            }

            /// <summary>
            /// 如果传入的值和当前ToolTip显示的值不相等的话，初始化_text的值
            /// </summary>
            /// <param name="text"></param>
            public void ResetText(String text)
            {
                if (!this._text.Equals(text))
                {
                    _toolTip.Hide();
                    _text = "";
                }
            }

            /// <summary>
            /// 显示当前XImageButton的鼠标提示
            /// </summary>
            public void ShowCurrentTooltip(String text)
            {
                if (!_toolTip.IsShowing)
                    _toolTip.Show(text, Control.MousePosition);

                this._text = text;
            }

        }

        #endregion
       
    }


   

}
