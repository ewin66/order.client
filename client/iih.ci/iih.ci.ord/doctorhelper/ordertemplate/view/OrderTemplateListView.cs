using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.doctorhelper.ordertemplate.viewmodel;
using iih.ci.ord.dto.ordertpltree.d;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.appfw;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.ciorder.render;
using xap.cli.sdk.render;
using xap.cli.sdk.controls;
using xap.cli.sdk.layouts;
using xap.cli.sdk.controls.tabControl;
using iih.ci.ord.ciorder.cards.extend;

namespace iih.ci.ord.doctorhelper.ordertemplate.view
{
    /// <summary>
    /// <para>描    述 :  医嘱模板列表</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.doctorhelper.ordertemplate.view</para>
    /// <para>类 名 称 :  Form1</para>
    /// <para>版 本 号 :  v1.0.0.0</para>
    /// <para>作    者 :  </para>
    /// <para>修 改 人 :  </para>
    /// <para>创建时间 :  2017/3/28 11:26:37</para>
    /// <para>更新时间 :  2017/3/28 11:26:37</para>
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public partial class OrderTemplateListView : HelperListView
    {
   
        //医嘱模板
        #region 变量定义区域
        private SizeF Textsize;//文本长度
        private int MaxStartX;
        private string Tiptext;
        private OrderTemplateListViewModel model;
        public Dictionary<string, OrderRender> SelectOrder = new Dictionary<string, OrderRender>();
        private Dictionary<string, SrvortplitemAggDO> OrTplDodic = new Dictionary<string, SrvortplitemAggDO>();
        private string id ;
        protected bool Nulldata = false;
        protected XAPScrollBarPanel ContainerControl;
        private new XBaseControl Container;
        private OrScArgs Args;

        //private List<string> Srvlist = new List<string>();
        #endregion

        #region 构造函数区域
        public OrderTemplateListView()
        {
            InitializeComponent();

            this.ContainerControl = new XAPScrollBarPanel();
            this.ContainerControl.Size = new Size(this.Size.Width, 365);
            this.ContainerControl.Dock = DockStyle.Fill;
            this.AddRender(ContainerControl);

            this.Container = new XBaseControl();
            this.Container.Size = new Size(ContainerControl.Size.Width, ContainerControl.Size.Height);
            this.Container.Location = new Point(0,0);
            this.Container.Paint += new PaintEventHandler(Container_Paint);
            ContainerControl.AddRender(Container);

            this.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.Tiptext = "未检索到相关数据";
            this.Textsize = TextRenderer.MeasureText(Tiptext, this.Font);
            this.SizeChanged += new EventHandler(OrderTemplateListView_SizeChanged);
        }

        void OrderTemplateListView_SizeChanged(object sender, EventArgs e)
        {
            Size size = (sender as OrderTemplateListView).Size;
            this.ContainerControl.Size = size;
            if (this.Container.Width <= this.ContainerControl.Width)
            {
                this.Container.Size = new Size(this.ContainerControl.Width, this.ContainerControl.Height);
            }
            this.ContainerControl.Invalidate();
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        //[XapCommand(Name = "Open", Caption = "打开")]
        //public void OnOpen(object sender, EventArgs e)
        //{

        //}

        #endregion

        #region 事件发送区域

        //[XapEventSent(Name = "Say")]
        //public event EventHandler<XapEventArgs> Say;

        #endregion

        #region 事件接收区域

        //[XapEventRecv(Name = "Recv")]
        //public void OnRecv(object sender, XapEventArgs e)
        //{

        //}
        public override void OnSelected(object sender, TargetEventArgs e)
        {

            //if (e.Object is OrderTplTreeDto)
            //{
            //    this.id = (e.Object as OrderTplTreeDto).Id;
            //    LoadData();
            //}
            //base.OnSelected(sender, e);
            Control control = this.Parent;
            // 判断该页签是否是选中
            while (control != null)
            {
                if (control is XTabPage)
                {
                    if ((control as XTabPage).IsSelected)
                    {
                        if (e.Object is OrderTplTreeDto)
                        {
                            this.id = (e.Object as OrderTplTreeDto).Id;
                            LoadData();
                        }
                    }
                    break;
                }
                else
                {
                    control = control.Parent;
                }
            }
        }
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if(this.id!=null)
            this.model = new OrderTemplateListViewModel(this.id);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            XapDataList<SrvortplitemAggDO> data = this.model.SrvortplitemAggDOList;
            int startX = 0;
            int startY = 10;

            this.Container.RemoveRenderAll();
            this.Nulldata = true;
            this.OrTplDodic.Clear();
            OrderRender TMP = new OrderRender(this);
            foreach (SrvortplitemAggDO tpl in data)
            {
               //if(tpl.ParentDO) 
                this.MaxStartX = 0;
                this.Nulldata = false;
                if (tpl.getParentDO().Ui_flag == "2" || tpl.getParentDO().Ui_flag == "1")
                {
                    if (!OrTplDodic.ContainsKey(tpl.getParentDO().Id_srv))
                    {
                       OrTplDodic.Add(tpl.getParentDO().Id_srv, tpl);
                    }
                    OrderRender ThreadRender = new OrderRender(this);
                    ThreadRender.IsParent = true;
                    ThreadRender.ListDo = tpl.getOrTplItmDtDO();
                    ThreadRender.ObjDo = tpl;
                    ThreadRender.Id = tpl.getParentDO().Id_srv;
                    ThreadRender.Size = new Size(280, 24);
                    ThreadRender.Checkchanged += new OrderRender.CheckValuechanged(ThreadRender_Checkchanged);
                    if (startY + ThreadRender.Size.Height > this.Container.Size.Height)
                    {
                        startX = TMP.Bound.Right;
                        startY = 10;// TMP.Bound.Bottom;
                    }
                    ThreadRender.Location = new Point(startX, startY);
                    startY += ThreadRender.Size.Height + 6;
                    if (this.MaxStartX <= startX)
                    {
                        this.MaxStartX = startX;
                    }
                    this.Container.AddRender(ThreadRender);
                    if (ThreadRender.OrderRenderList != null && ThreadRender.OrderRenderList.Count > 0)
                    {
                        foreach (OrderRender render in ThreadRender.OrderRenderList)
                        {
                            render.Checkchanged += new OrderRender.CheckValuechanged(OrderTemplateListView_Checkchanged);
                        }
                    }
                    TMP = ThreadRender;

                }
                if (tpl.getParentDO().Ui_flag == "3")
                {
                    //OrderRender ThreadRender = new OrderRender();
                    //ThreadRender.IsParent = true;
                    //ThreadRender.ListDo = tpl.ChildrenList;
                    //ThreadRender.Size = new Size(223, 24);
                    //if (startX + ThreadRender.Size.Width > this.Size.Width)
                    //{
                    //    startX = 0;
                    //    // startY = ThreadRender.LastBottm;
                    //}
                    //ThreadRender.Location = new Point(startX, startY);
                    //startX += ThreadRender.Size.Width;
                    //if (this.MaxStartX <= startX)
                    //{
                    //    this.MaxStartX = startX;
                    //}
                    //this.Container.AddRender(ThreadRender);
                    //TMP = ThreadRender;

                    if (!OrTplDodic.ContainsKey(tpl.getParentDO().Id_srv))
                    {
                        OrTplDodic.Add(tpl.getParentDO().Id_srv, tpl);
                    }
                    OrderRender ThreadRender = new OrderRender(this);
                    ThreadRender.IsParent = true;
                    ThreadRender.ListDo = tpl.getOrTplItmDtDO();
                    ThreadRender.ObjDo = tpl;
                    ThreadRender.Id = tpl.getParentDO().Id_srv;
                    ThreadRender.Size = new Size(280, 24);
                    ThreadRender.Checkchanged += new OrderRender.CheckValuechanged(ThreadRender_Checkchanged);
                    if (startY + ThreadRender.Size.Height > this.Container.Size.Height)
                    {
                        startX = TMP.Bound.Right;
                        startY = 10;// TMP.Bound.Bottom;
                    }
                    ThreadRender.Location = new Point(startX, startY);
                    startY += ThreadRender.Size.Height + 6;
                    if (this.MaxStartX <= startX)
                    {
                        this.MaxStartX = startX;
                    }
                    this.Container.AddRender(ThreadRender);
                    if (ThreadRender.OrderRenderList != null && ThreadRender.OrderRenderList.Count > 0)
                    {
                        foreach (OrderRender render in ThreadRender.OrderRenderList)
                        {
                            render.Checkchanged += new OrderRender.CheckValuechanged(OrderTemplateListView_Checkchanged);
                        }
                    }
                    TMP = ThreadRender;
                }
                if (tpl.getParentDO().Ui_flag == "4")
                {
                    if (!OrTplDodic.ContainsKey(tpl.getParentDO().Id_srv))
                    {
                        OrTplDodic.Add(tpl.getParentDO().Id_srv, tpl);
                    }
                    OrderRender ThreadRender = new OrderRender(this);
                    ThreadRender.ObjDo = tpl;
                    ThreadRender.Id = tpl.getParentDO().Id_srv;
                    ThreadRender.Size = new Size(280,24);
                    ThreadRender.Checkchanged +=new OrderRender.CheckValuechanged(ThreadRender_Checkchanged);
                    if (startY + ThreadRender.Size.Height > this.Container.Size.Height)
                    {
                        startX = TMP.Bound.Right;
                        startY = 10;// TMP.Bound.Bottom;
                    }
                    ThreadRender.Location = new Point(startX, startY);
                    startY += ThreadRender.Size.Height + 6;
                    if (this.MaxStartX <= startX)
                    {
                        this.MaxStartX = startX;
                    }
                    this.Container.AddRender(ThreadRender);
                    TMP = ThreadRender;
                }
            }
            if (this.Container.Size.Width <= TMP.Bound.Right)
            {
                this.Container.Size = new Size(TMP.Bound.Right, ContainerControl.Size.Height);
            }
            this.Container.Invalidate();
            this.ContainerControl.getScrollBarRect();        
        }

        void OrderTemplateListView_Checkchanged(OrderRender render, bool flag)
        {
            if (render.Check)
            {
                if (!render.IsParent && render.ParentOrderRender != null && !render.ParentOrderRender.Check)
                {
                    if (!SelectOrder.ContainsKey(render.ParentOrderRender.Id))
                    {
                        this.SelectOrder.Add(render.ParentOrderRender.Id, render.ParentOrderRender);
                    }
                }
            }
            else
            {
                if (!render.IsParent && render.ParentOrderRender != null)
                {
                    if (SelectOrder.ContainsKey(render.ParentOrderRender.Id))
                    {
                        SelectOrder.Remove(render.ParentOrderRender.Id);
                    }
                    foreach (OrderRender irender in render.ParentOrderRender.OrderRenderList)
                    {
                        if (irender.Check)
                        {
                            if (!SelectOrder.ContainsKey(render.ParentOrderRender.Id))
                            {
                                SelectOrder.Add(render.ParentOrderRender.Id, render.ParentOrderRender);
                                break;
                            }
                        }
                    }
                }
            }
        }

        void ThreadRender_Checkchanged(OrderRender render, bool flag)
        {
            if(render.IsParent)
            {
               if (render.Check && !SelectOrder.ContainsKey(render.Id))
                {
                    this.SelectOrder.Add(render.Id, render);
                }
               else if (!render.Check && SelectOrder.ContainsKey(render.Id))
                {
                    this.SelectOrder.Remove(render.Id);
                }
            }
        }


        public override void SaveData()
        {
            Args = new OrScArgs();
            Args.listObj = new List<object>();
            Control control = this.Parent;
            // 向上寻找父窗体，并把数据主动的跑出去。
            while (control != null)
            {
                if (control.Text == "智能助手")
                {
                    break;
                }
                else if (control is XTabPage)
                {
                    Args.listObj.Add((control as XTabPage).Name);
                    control = control.Parent;
                }
                else
                {
                    control = control.Parent;
                }
            }
            if (this.SelectOrder.Count > 0)
            {
                foreach (string str in this.SelectOrder.Keys)
                {
                    Args.listObj.Add(OrTplDodic[str]);
                }
            }
            (control as helperForm).Args = Args;
            (control as helperForm).DialogResult = DialogResult.OK;
        }
        #endregion

        #region 内部事件区域
        void OrderTemplateListView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }
        void Container_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(0, 0), new Point(0,this.Container.Size.Height -1));
            if (!this.Nulldata)
            {
                int first = 0;
                while (first < this.MaxStartX)
                {
                    first += 280;
                    e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(first, 6), new Point(first, this.Container.Size.Height - 6));
                }
            }
            else
            {
                e.Graphics.DrawString(Tiptext, this.Font, new SolidBrush(Color.Black), new Point((this.Size.Width - (int)this.Textsize.Width) / 2, (this.Size.Height - (int)this.Textsize.Height) / 2));
            }
        }

        #endregion

        #region 辅助处理函数

        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {

        }

        #endregion
    }
}
