using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using xap.cli.sdk.controls.SuspendForm;
using System.Windows.Forms;
using xap.cli.sdk.render;

namespace iih.ci.ord.ciorder.render
{
    /*

* ==============================================================================
*
* Filename: 树伟
* Description: 
*
* Version: 1.0
* Created: 2015/11/3 19:49:51
* Compiler: Visual Studio 2010
*
* Author: 常树伟
* Company: 北大医信
*
* ==============================================================================
*/
    /// <summary>
    /// 悬浮导航项
    /// </summary> 
    public delegate void SendMsgHandler(DoctorRender sender, List<UserRender> renderlist);
    public delegate void RemoveMsgHandler(DoctorRender sender, List<UserRender> renderlist);
    public class DoctorRender : UserRender
    {
        #region 属性、字段
        public readonly SolidBrush brushMouseOverBrush = new SolidBrush(Color.FromArgb(0, 153, 229));
        public event MouseEventHandler Click;
        //private bool IsDropDown = false;
        private bool isRightSpread = false;

        public event SendMsgHandler SendMsg;
        public event RemoveMsgHandler RemoveMsg;
        private void FireRemoveMsg()
        {
            if (RemoveMsg != null)
            {
                RemoveMsg(this, null);
            }
        }
        private List<UserRender> items = new List<UserRender>();
        public List<UserRender> Items
        {
            get { return items; }
            set { items = value; }
        }

        private StringFormat drawFormat;
        //水平对齐方式
        public StringAlignment Alignment
        {
            set { drawFormat.Alignment = value; }
        }
        //垂直对齐方式
        public StringAlignment LineAlignment
        {
            set { drawFormat.LineAlignment = value; }
        }

        private Color normalBrushColor;
        /// <summary>
        /// 对象正常色
        /// </summary>
        public Color NormalBrushColor
        {
            get { return normalBrushColor; }
            set { normalBrushColor = value; }
        }

        private Color downBrushColor;
        /// <summary>
        /// 对象按下色
        /// </summary>
        public Color DownBrushColor
        {
            get { return downBrushColor; }
            set { downBrushColor = value; }
        }

        private Color txtBrushColor;
        /// <summary>
        /// 文本色
        /// </summary>
        public Color TxtBrushColor
        {
            get { return txtBrushColor; }
            set { txtBrushColor = value; }
        }

        private Color rectFillBrushColor;
        /// <summary>
        /// 填充色
        /// </summary>
        public Color RectFillBrushColor
        {
            get { return rectFillBrushColor; }
            set { rectFillBrushColor = value; }
        }

        public int id;
        /// <summary>
        /// 列表存储对象ID
        /// </summary>
        public int Id
        {
            get { return id; }
            set { id = value; }
        }
        public xap.cli.sdk.render.RenderState ItemState { get; set; }

        private string text;
        /// <summary>
        /// 文本值
        /// </summary>
        public string Text
        {
            get
            {
                return text;
            }

            set { text = value; }
        }
        public Font drawFont { get; set; }

        private int roundSize = 1;
        /// <summary>
        /// 边框宽度,默认为1
        /// </summary>
        public int RoundSize
        {
            get { return roundSize; }
            set { roundSize = value; }
        }

        private Color roundColor = Color.Black;
        /// <summary>
        /// 边框颜色，默认为黑色
        /// </summary>
        public Color RoundColor
        {
            get { return roundColor; }
            set { roundColor = value; }
        }
        private int itemWidth;
        /// <summary>
        /// 对象宽度
        /// </summary>
        public int ItemWidth
        {
            get { return itemWidth; }
            set { itemWidth = value; }
        }

        private int itemHeight = 28;
        /// <summary>
        /// 高度
        /// </summary>
        public int ItemHeight
        {
            get { return itemHeight; }
            set { itemHeight = value; }
        }

        private bool selected;
        /// <summary>
        /// 选中标识
        /// </summary>
        public bool Selected
        {
            get { return selected; }
            set { selected = value; }
        }
        #endregion

        #region 构造函数
        public DoctorRender()
        {
            this.Bound = new Rectangle(this.Bound.X, this.Bound.Y, this.Bound.Width, this.itemHeight);
            //默认字体
            this.drawFont = new Font("微软雅黑", 12F, GraphicsUnit.Pixel);
            this.Size = new Size(itemWidth - 10, itemHeight);

            this.TxtBrushColor = Color.Black;
            this.downBrushColor = Color.FromArgb(0, 154, 229);
            this.NormalBrushColor = Color.FromArgb(212, 246, 253);

            this.drawFormat = new StringFormat();
            this.Alignment = StringAlignment.Center;
            this.LineAlignment = StringAlignment.Center;
            drawFormat.FormatFlags = StringFormatFlags.NoWrap;

            this.Id = this.GetHashCode();
        }

        public DoctorRender(string item)
        {
            this.drawFont = new Font("Arial", 9);
            this.Size = new Size(itemWidth, 25);

            this.text = item;
            this.TxtBrushColor = Color.Black;

            this.drawFormat = new StringFormat();
            this.Alignment = StringAlignment.Near;
            this.LineAlignment = StringAlignment.Center;

            this.Id = this.GetHashCode();
        }
        #endregion

        #region 对象绘制
        public override void Render(Graphics g)
        {

            switch (ItemState)
            {
                case xap.cli.sdk.render.RenderState.Down:
                    this.TxtBrushColor = Color.White;
                    drawItemShape(g, this.downBrushColor);
                    break;
                case xap.cli.sdk.render.RenderState.Move:
                    this.txtBrushColor = Color.White;
                    drawItemShape(g, Color.FromArgb(0, 154, 229));
                    break;
                default:
                    this.TxtBrushColor = Color.Black;
                    drawItemShape(g, this.normalBrushColor);
                    break;
            }
        }

        private void drawItemShape(Graphics g, Color rectColor)
        {
            //文本色刷 
            Brush drawBrush = new SolidBrush(TxtBrushColor);
            Brush rectBrush = new SolidBrush(rectColor);
            //填充
            g.FillRectangle(rectBrush, this.Bound);

            g.DrawString(this.Text, drawFont, drawBrush, this.Bound, drawFormat);
            Pen pen = new Pen(brushMouseOverBrush);
            g.DrawLine(pen, mouseBound.Left, mouseBound.Bottom - 1, mouseBound.Right - 1, mouseBound.Bottom - 1);
            g.DrawLine(pen, mouseBound.Left, mouseBound.Top, mouseBound.Left, mouseBound.Bottom - 1);
            //  g.DrawLine(pen, mouseBound.Right - 1, mouseBound.Top, mouseBound.Right - 1, mouseBound.Bottom - 1);
        }
        #endregion

        #region 事件

        /// <summary>
        /// 鼠标移动事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnMouseMove(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (new Rectangle(this.Bound.X, this.Bound.Y, this.Bound.Width + 2, this.Bound.Height).Contains(e.Location))
            {
                this.ItemState = xap.cli.sdk.render.RenderState.Move;
                if (this.SendMsg != null)
                {
                    SendMsg(this, items);
                }
                this.Invalidate();
            }

        }

        /// <summary>
        /// 鼠标离开事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnMouseLeave(object sender, EventArgs e)
        {
            //不保持伸展开，恢复正常
            if (!this.isRightSpread)
            {
                if (ItemState != xap.cli.sdk.render.RenderState.Normal)
                {
                    ItemState = xap.cli.sdk.render.RenderState.Normal;
                    this.Invalidate();
                }
            }
        }

        /// <summary>
        /// 鼠标按下事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnMouseDown(object sender, MouseEventArgs e)
        {
            if (Contains(e.Location))
            {
                ItemState = xap.cli.sdk.render.RenderState.Down;
            }
            else
            {
                ItemState = xap.cli.sdk.render.RenderState.Normal;
            }
            base.OnMouseDown(sender, e);
        }

        /// <summary>
        /// 鼠标单击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnMouseClick(object sender, MouseEventArgs e)
        {
            if (Click != null)
            {
                Click(sender, e);
            }
            base.OnMouseClick(sender, e);
        }
        #endregion

        #region 方法
        public void Add(UserRender render)
        {
            this.Items.Add(render);
            //this.IsDropDown = true;
        }
        #endregion
    }
}
