using System.Drawing;
using System.Drawing.Drawing2D;
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
* Created: 2015/11/17 15:44:59
* Compiler: Visual Studio 2010
*
* Author: 常树伟
* Company: 北大医信
*
* ==============================================================================
*/

    /// <summary>
    /// 医疗单索引区域右侧的删除按钮（带叉的小圆圈）
    /// </summary>
    public class XOrderCancelButton : UserRender {
        #region 成员变量
        private static Pen LineCommPen = new Pen(Color.FromArgb(138, 138, 138));
        private static Pen LineMovePen = new Pen(Color.FromArgb(0, 153, 229));

        /// <summary>
        /// 
        /// </summary>
        private string str = null;
        /// <summary>
        /// 
        /// </summary>
        private Pen rowpen; 
        #endregion

        #region 构造
        public XOrderCancelButton() {
            this.Size = new Size(21, 21);
            this.Location = new Point(50, 100);
            this.Crossflag = false;
            this.rowpen = LineCommPen;
            //this.MouseClick += new System.Windows.Forms.MouseEventHandler(XOrdercancel_MouseClick);
        } 
        #endregion

        #region 父类覆写函数
        public override void Render(System.Drawing.Graphics g) {
            g.SmoothingMode = SmoothingMode.HighQuality;
            g.DrawEllipse(this.rowpen, this.Bound);
            g.DrawLine(this.rowpen, new Point(this.Location.X + 6, this.Location.Y + 6), new Point(this.Bound.Right - 6, this.Bound.Bottom - 6));
            g.DrawLine(this.rowpen, new Point(this.Bound.Right - 6, this.Location.Y + 6), new Point(this.Location.X + 6, this.Bound.Bottom - 6));
            g.SmoothingMode = SmoothingMode.Default;
            base.Render(g);
        }

        protected override void OnMouseMove(object sender, MouseEventArgs e) {
            this.rowpen = LineMovePen;
            this.Invalidate(new Rectangle(this.Bound.Location, new Size(this.Bound.Size.Width + 1, this.Size.Height + 1)));
            base.OnMouseMove(sender, e);
        }
        protected override void OnMouseLeave(object sender, System.EventArgs e) {
            this.rowpen = LineCommPen;
            this.Invalidate(new Rectangle(this.Bound.Location,new Size(this.Bound.Size.Width+1,this.Size.Height+1)));
            base.OnMouseLeave(sender, e);
        } 
        #endregion

        #region 属性
        /// <summary>
        /// 
        /// </summary>
        public string Text {
            set {
                this.str = value;
            }
        }

        /// <summary>
        /// 
        /// </summary>
        public bool Crossflag { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public string ID { get; set; }
        #endregion
    }
}
