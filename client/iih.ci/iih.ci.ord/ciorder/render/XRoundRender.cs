using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Windows.Forms;
using xap.cli.sdk.render;
using xap.rui.engine.registers;
using xap.rui.control.basecontrol;
using xap.rui.engine;

namespace iih.ci.ord.ciorder.render {
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
    /// 就是多医疗单下面的那个索引数字
    /// zhou_zhijian 7.3做阅读注释
    /// todo：IXEventPublication, IRegister, IXapBaseControl这三个接口的目的是啥？
    /// </summary>
    public class XRoundRender : UserRender, IXEventPublication, IRegister, IXapBaseControl {

        #region 成员变量
        /// <summary>
        /// 
        /// </summary>
        private XToolTipRender toolTip;
        /// <summary>
        /// 
        /// </summary>
        protected Color fontcolor;
        /// <summary>
        /// 
        /// </summary>
        protected bool editflag;
        /// <summary>
        /// 
        /// </summary>
        protected Color boundcolor;
        /// <summary>
        /// 
        /// </summary>
        protected bool crossflag;
        /// <summary>
        /// 
        /// </summary>
        private bool isHandleCreate = false;
        /// <summary>
        /// 
        /// </summary>
        protected string str = null;

        #endregion
 
        #region 构造
        public XRoundRender() {
            this.Size = new Size(20, 20);
            this.Location = new Point(50, 100);
            this.Crossflag = false;
            this.Editflag = false;
            this.fontcolor = Color.FromArgb(137, 137, 137);
            this.boundcolor = Color.FromArgb(137, 137, 137);
            //  this.MouseClick += new MouseEventHandler(XRoundRender_MouseClick);
            // this.MouseDoubleClick += new System.Windows.Forms.MouseEventHandler(XRoundRender_MouseDoubleClick);
            toolTip = new XToolTipRender();
            //this.toolTip.InitialDelay = 200;
        } 
        #endregion

        #region 覆写父类函数
        /// <summary>
        /// 
        /// </summary>
        /// <param name="g"></param>
        public override void Render(System.Drawing.Graphics g) {
            SizeF textsize = g.MeasureString(this.Index, new Font("微软雅黑", 12));
            if (!this.Crossflag) {
                 g.SmoothingMode = SmoothingMode.HighQuality;
                //g.DrawRectangle(new Pen(Color.Red), this.Bound);
                 g.DrawEllipse(new Pen(this.boundcolor), this.Bound);
                g.SmoothingMode = SmoothingMode.Default;
                if (this.Editflag)
                {
                    g.FillEllipse(new SolidBrush(Color.FromArgb(0,153,229)), this.Bound);
                    //g.DrawLine(new Pen(this.fontcolor), new Point(this.Location.X + 2, this.Location.Y + (int)textsize.Height), new Point(this.Location.X + 2 + (int)textsize.Width, this.Location.Y + (int)textsize.Height));
                }
                g.DrawString(this.Index, new Font("微软雅黑", 12), new SolidBrush(this.fontcolor), new Point(this.Location.X + 4, this.Location.Y + 1));
            }
           
            base.Render(g);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnMouseLeave(object sender, EventArgs e) {
            this.IsMoveOn = false;
            this.parent.Cursor = Cursors.Default;
            if (isHandleCreate) {
                if (toolTip.IsHandleCreate) {
                    toolTip.CanShow = false;
                    toolTip.Hide();
                    isHandleCreate = false;
                }
            }
            this.Invalidate();
            base.OnMouseLeave(sender, e);

        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnMouseMove(object sender, System.Windows.Forms.MouseEventArgs e) {
            if (mouseBound.Contains(e.Location)) {
                this.IsMoveOn = true;
                this.parent.Cursor = Cursors.Hand;
            }
            else {
                this.IsMoveOn = false;
            }
            if (this.Contains(e.Location)) {
                if (!isHandleCreate) {
                    isHandleCreate = true;
                    Control control = new Control();
                    toolTip.CanShow = true;
                    toolTip.Show(this.Text, this.parent.PointToScreen(new Point(this.Location.X, this.Size.Height+9)));
                }
            }
            else {
                if (isHandleCreate) {

                    toolTip.CanShow = false;
                    isHandleCreate = false;
                    toolTip.Hide();
                }
            }
            this.Invalidate();
            base.OnMouseMove(sender, e);
        } 
        #endregion

        #region 属性
        /// <summary>
        /// 
        /// </summary>
        public string Text {
            get { return this.str; }
            set {
                this.str = value;
            }
        }

        /// <summary>
        /// 
        /// </summary>
        public CiorderBaseControl Ci {
            get; set;
        }

        /// <summary>
        /// 索引序号字符串
        /// </summary>
        public string Index {
            get; set;
        }

        /// <summary>
        /// 
        /// </summary>
        public bool IsMoveOn {
            get; set;
        }

        /// <summary>
        /// 
        /// </summary>
        public override bool Enabled {
            get {
                return base.Enabled;
            }
            set {
                this.fontcolor = Color.FromArgb(238, 238, 238);
                base.Enabled = value;
                this.Invalidate();
            }
        }

        /// <summary>
        /// 
        /// </summary>
        public Color FontColor {
            get {
                return this.fontcolor;
            }
            set {
                this.fontcolor = value;
            }
        }

        /// <summary>
        /// 
        /// </summary>
        public bool Crossflag {
            get {
                return this.crossflag;
            }
            set {
                this.crossflag = value;
                if (value)
                {
                    this.boundcolor = Color.FromArgb(1, 103, 177);
                    this.fontcolor = Color.FromArgb(1, 103, 177);
                }
            }
        }

        /// <summary>
        /// 
        /// </summary>
        public bool Editflag {
            get {
                return this.editflag;
            }
            set {
                this.editflag = value;
                if (value)
                {
                    this.fontcolor = Color.FromArgb(255, 255, 255);
                    this.boundcolor = Color.FromArgb(0, 153, 229);
                }
                else
                {
                     this.fontcolor = Color.FromArgb(1, 103, 177);
                     this.boundcolor= Color.FromArgb(1, 103, 177);
                }
                this.Invalidate(new Rectangle(this.Bound.Location, new Size(this.Bound.Size.Width + 1, this.Bound.Size.Height + 1)));
            }
        }

        /// <summary>
        /// 
        /// </summary>
        public string ID {
            get; set;
        }

        #endregion

        #region IRegister接口实现函数
        public object GetRegister() {
            return this;
        } 
        #endregion

        #region IXEventPublication接口实现
        public event EventHandler<DictionaryEventArgs> EventSent;
        private void FireEventSent()
        {
            if (EventSent != null)
            {
                EventSent(this, null);
            }
        }
        #endregion

        #region IXapBaseControl实现函数
        public void OnInit() {

        }

        public void LoadData() {

        } 
        #endregion

        #region 无用的
        //void XRoundRender_MouseClick(object sender, MouseEventArgs e)
        //{
        //    XRoundRender render = sender as XRoundRender;

        //    DictionaryEventArgs de = new DictionaryEventArgs();
        //    de.Data.Add(UIConst.UI_EVENT, "ListSelected");
        //    de.Data.Add(UIConst.DATA, render.ID);

        //   // this.EventSent(render, de);
        //} 
        #endregion
    }
}
