using System;
using System.Collections.Generic;

using System.Drawing;

using System.Windows.Forms;
using iih.ci.ord.ciorder.action;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.basecontrol;
using iih.ci.ord.ciorder.render;
using xap.cli.sdk.render;
using XRoundRender = iih.ci.ord.ciorder.render.XRoundRender;


namespace iih.ci.ord.ciorder.cards {
    /// <summary>
    /// 在医疗单上的序号索引区域（1，2，3，4）还有最下面的按钮区域（确认与取消）
    /// author:常树伟
    /// zhouzhijian 2016.07.01整理及添加注释
    /// </summary>
    public partial class EmsIndexAndButtonArea : XapBaseControl {

        #region 成员变量
        /// <summary>
        /// 多医疗单下面的索引数字控件
        /// </summary>
        private XRoundRender render;
        /// <summary>
        /// 多医疗单下面的关闭按钮（就是带叉的那个圆圈）
        /// </summary>
        private XOrderCancelButton cancel;
        /// <summary>
        /// 删除按钮（带叉的小圆圈）是否可见性
        /// </summary>
        private bool renderVisable;
        /// <summary>
        /// 删除按钮（带叉的小圆圈）是否可用
        /// </summary>
        private bool renderEnabled = true;
        /// <summary>
        /// 确认按钮
        /// </summary>
        public XButton btnOk;
        /// <summary>
        /// 取消按钮
        /// </summary>
        public XButton btnCancel;
        /// <summary>
        /// [索引序号，[医疗单控件，医疗单数据]]
        /// </summary>
        private Dictionary<string, Dictionary<CiorderBaseControl, Object>> dataSource
            = new Dictionary<string, Dictionary<CiorderBaseControl, Object>>();

        /// <summary>
        /// [索引序号,医疗单名字]
        /// </summary>
        private Dictionary<string, string> nameDict = new Dictionary<string, string>();

        /// <summary>
        /// 多医疗单下面的索引数字控件的点击事件
        /// </summary>
        public event MouseEventHandler RounderClick;
        /// <summary>
        /// 多医疗单下面的索引数字控件的集合
        /// </summary>
        public List<XRoundRender> IndexRenderList = new List<XRoundRender>();
        /// <summary>
        /// 删除按钮事件发送
        /// </summary>
        public event EventHandler DeleteEvent;
        /// <summary>
        /// 保存按钮事件发送
        /// </summary>
        public event EventHandler SaveClickEvent;
        /// <summary>
        /// 取消按钮事件发送
        /// </summary>
        public event EventHandler CancelClickEvent;

        #endregion

        #region 构造及初始化

        public EmsIndexAndButtonArea() {
            InitializeComponent();
            Init();
        }

        protected void Init() {
            // this.xapScrollBarPanel1.BackColor = Color.Pink;
           
            btnOk = new XButton();
            btnOk.Text = "确认";
            btnOk.MouseClick += new MouseEventHandler(btn_MouseClick);
            btnOk.Size = new System.Drawing.Size(90, 24);
            btnOk.Location = new Point(this.Location.X + (this.Size.Width - btnOk.Size.Width * 2 - 20) / 2, (this.Size.Height - btnOk.Size.Height) / 2);
            this.xapScrollBarPanel1.AddRender(btnOk);

            btnCancel = new XButton();
            btnCancel.Text = "取消";
            btnCancel.Size = new System.Drawing.Size(90, 24);
            btnCancel.MouseClick += new MouseEventHandler(btnCancel_MouseClick);
            btnCancel.Location = new Point(btnOk.Location.X + btnOk.Size.Width + 20, btnOk.Location.Y);
            this.xapScrollBarPanel1.AddRender(btnCancel);
            this.xapScrollBarPanel1.AddRender(cancel);

            cancel = new XOrderCancelButton();
            cancel.MouseClick += new MouseEventHandler(cancel_MouseClick);

            this.xapScrollBarPanel1.RemoveRender(cancel);
            this.xapScrollBarPanel1.AddRender(cancel);


            this.xapScrollBarPanel1.SizeChanged += new EventHandler(xapScrollBarPanel1_SizeChanged);
            this.xapScrollBarPanel1.Paint += new PaintEventHandler(xapScrollBarPanel1_Paint);

        }

        #endregion

        #region 属性

        /// <summary>
        /// 设置多医疗单关闭按钮的可见性
        /// </summary>
        public bool RenderVisable {
            get { return renderVisable; }
            set {
                this.renderVisable = value;
                if (!value) {
                    this.xapScrollBarPanel1.RemoveRender(cancel);
                }
                else {
                    this.xapScrollBarPanel1.AddRender(cancel);
                }
                this.xapScrollBarPanel1.Invalidate();
            }
        }

        /// <summary>
        /// 设置多医疗单按钮的Enable属性
        /// </summary>
        public bool RenderEnabled {
            get {
                return this.renderEnabled;
            }
            set {
                if (this.renderEnabled != value) {
                    this.renderEnabled = value;
                    btnOk.Enabled = value;
                    //btnCancel.Enabled = value;
                    this.xapScrollBarPanel1.Invalidate();
                }
            }
        }

        /// <summary>
        /// [索引控件的ID，【对应的的医疗单控件，该医疗单控件的名字字符串】]
        /// </summary>
        public Dictionary<string, Dictionary<CiorderBaseControl, Object>> DataSource {
            get {
                return this.dataSource;
            }
            set {
                foreach (XRoundRender round in this.IndexRenderList) {
                    this.xapScrollBarPanel1.RemoveRender(round);
                }
                IndexRenderList.Clear();

                dataSource = value;
                int starX = 8;
                //int starY =this.xapFormControl1
                int i = 1;

                foreach (var key in value.Keys) {
                    render = new XRoundRender();
                    render.ID = key;
                    render.Size = new System.Drawing.Size(23,23);
                    render.Index = i++.ToString();
                    foreach (var Secondkey in value[key].Keys) {
                        //render.Text = Secondkey.SheetName;
                        render.Ci = Secondkey;
                    }
                    render.MouseClick += new MouseEventHandler(render_MouseClick);
                    render.Location = new Point(starX, 4);
                    this.xapScrollBarPanel1.AddRender(render);
                    IndexRenderList.Add(render);
                    starX += render.Size.Width + 14;
                }
                btnOk.Location = new Point(this.Location.X + (this.Size.Width - btnOk.Size.Width * 2 - 20) / 2, render.Bound.Bottom + 13);
                btnCancel.Location = new Point(btnOk.Location.X + btnOk.Size.Width + 20, btnOk.Location.Y);
                this.RenderVisable = true;
                this.Invalidate();
            }
        }

        /// <summary>
        /// 医疗单对应名字的字典
        /// </summary>
        public Dictionary<string, string> NameDict 
        {
            get 
            {
                return this.nameDict;
            }
            set 
            {
                this.nameDict = value;
                if (IndexRenderList != null && IndexRenderList.Count == value.Count)
                {
                    foreach (XRoundRender roundRender in this.IndexRenderList)
                    {
                        roundRender.Text = value[roundRender.ID];
                    }
                    this.Invalidate();
                }
            }
        } 

        #endregion

        #region 事件处理函数

        /// <summary>
        /// 点击（编辑）当前药品
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void render_MouseClick(object sender, MouseEventArgs e) {
            if (this.RounderClick != null) {
                this.RounderClick(sender, e);
            }
        }

        /// <summary>
        /// 点击 删除当前编辑的药品
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void cancel_MouseClick(object sender, MouseEventArgs e) {
            if (DeleteEvent != null)
                DeleteEvent(this, null);
        }

        /// <summary>
        /// 点击保存按钮
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btn_MouseClick(object sender, MouseEventArgs e) {
            if (SaveClickEvent != null)
                SaveClickEvent(this, null);
        }
        /// <summary>
        /// 底部索引区与按钮区的绘制
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapScrollBarPanel1_Paint(object sender, PaintEventArgs e) {
            e.Graphics.DrawLine(new Pen(Color.FromArgb(138, 138, 138)), new Point(this.xapScrollBarPanel1.Bounds.Left, this.xapScrollBarPanel1.Bounds.Top + 1), new Point(this.xapScrollBarPanel1.Bounds.Right, this.xapScrollBarPanel1.Bounds.Top + 1));
            if (this.RenderVisable) {
                e.Graphics.DrawLine(new Pen(Color.FromArgb(138, 138, 138)), new Point(this.xapScrollBarPanel1.Bounds.Left, this.render.Bound.Bottom + 4), new Point(this.xapScrollBarPanel1.Bounds.Right, this.render.Bound.Bottom + 4));
            }
        }
        /// <summary>
        /// 底部多医疗单的尺寸改变处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapScrollBarPanel1_SizeChanged(object sender, EventArgs e) {
            if (!this.RenderVisable) {
                btnOk.Location = new Point(this.Location.X + (this.Size.Width - btnOk.Size.Width * 2 - 20) / 2, (this.Size.Height - btnOk.Size.Height) / 2);
                btnCancel.Location = new Point(btnOk.Location.X + btnOk.Size.Width + 20, btnOk.Location.Y);
            }
            else {

                btnOk.Location = new Point(this.Location.X + (this.Size.Width - btnOk.Size.Width * 2 - 20) / 2, this.render.Bound.Bottom + 12);
                btnCancel.Location = new Point(btnOk.Location.X + btnOk.Size.Width + 20, btnOk.Location.Y);
                cancel.Location = new Point(this.Size.Width - cancel.Size.Width - 15, 6);
            }
            this.xapScrollBarPanel1.Invalidate();
        }
        /// <summary>
        /// 点击取消按钮
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnCancel_MouseClick(object sender, MouseEventArgs e) {
            if (CancelClickEvent != null)
                CancelClickEvent(this, null);
        }

        #endregion

    }
}
