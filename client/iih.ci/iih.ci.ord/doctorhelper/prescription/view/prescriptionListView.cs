using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.cli.sdk.controls;
using iih.ci.ord.ciorder.cards.extend;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.ciorder.render;
using iih.ci.ord.doctorhelper.newtemplate.viewmodel;
using iih.ci.ord.dto.medicalroutinetreedto.d;
using iih.ci.ord.dto.newordertemplatedto.d;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using iih.en.pv.dto.d;
using xap.cli.sdk.render.Items;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 协定处方


*********************************************************************************/
namespace iih.ci.ord.doctorhelper.prescription.view
{
    //协定处方
    public partial class prescriptionListView : XapListControl, IViewSave
    {
        #region 变量定义区域

        /// <summary>
        /// 模板明细
        /// </summary>
        private String id_ortmpl = "";
        /// <summary>
        /// 协定处方明细
        /// </summary>
        private NewOrderTemplateListViewModel model;
        /// <summary>
        /// 草药判断
        /// </summary>
        private bool isHerb = false;
        // 文本长度
        private SizeF textsize;
        private XBaseControl topControl;
        private XLabelBaseUserRender usageRender;     //用法
        private XLabelBaseUserRender frequencyRender; //频次
        private XLabelBaseUserRender decoctionRender; //煎法
        private XCheckBox checkAllRender; //全选
        //所有对象
        private List<OrderRender> OrderRenderList = new List<OrderRender>();
        //选中的render字典
        public Dictionary<string, OrderRender> SelectOrderDic = new Dictionary<string, OrderRender>();
        //=========================================================
        //所在的helpForm
        //private helperForm parentForm;
        //患者信息
       // private Ent4BannerDTO patDo = new Ent4BannerDTO();
        //private string id_ent = null;
        //private XapFormControl xapFormControl;
        protected XAPScrollBarPanel ContainerControl;
        private new XBaseControl Container;
        private string Tiptext;
        //private SizeF Textsize;//文本长度
        private int MaxStartX;
        protected bool Nulldata = false;
        private OrScArgs Args;
        private Dictionary<string, OrTplNItmDO> OrTplDodic = new Dictionary<string, OrTplNItmDO>();
        public Dictionary<string, OrderRender> SelectOrder = new Dictionary<string, OrderRender>();
        //private List<OrTplItmDtDO> savedatalist;
        #endregion

        #region 构造函数区域
        public prescriptionListView()
        {
            InitializeComponent();

            this.isHerb = false;

            this.ContainerControl = new XAPScrollBarPanel();
            this.ContainerControl.Size = new Size(this.Size.Width, this.Size.Height);
            this.ContainerControl.Location = new Point(1, 0);
            this.AddRender(ContainerControl);

            this.Container = new XBaseControl();
            this.Container.Size = new Size(ContainerControl.Size.Width, ContainerControl.Size.Height);
            this.Container.Location = new Point(0, 0);
            this.Container.Paint += new PaintEventHandler(Container_Paint);
            ContainerControl.AddRender(Container);

            this.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.Tiptext = "未检索到相关数据";
            this.textsize = TextRenderer.MeasureText(Tiptext, this.Font);
            this.SizeChanged += new EventHandler(NewOrderTemplateListView_SizeChanged);

            this.Load += new EventHandler(prescriptionListView_Load);
            this.Paint += new PaintEventHandler(OpOrderTemplateListView_Paint);
        }

        void OpOrderTemplateListView_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(0, 0), new Point(0, this.Size.Height - 1));
        }
        void Container_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(0, 1), new Point(this.Container.Size.Width - 1, 1));
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
                e.Graphics.DrawString(Tiptext, this.Font, new SolidBrush(Color.Black), new Point((this.Size.Width - (int)this.textsize.Width) / 2, (this.Size.Height - (int)this.textsize.Height) / 2));
            }
        }


        void NewOrderTemplateListView_SizeChanged(object sender, EventArgs e)
        {
            Size size = (sender as prescriptionListView).Size;
    
            if (this.isHerb && this.topControl != null && this.RenderControls.Contains(this.topControl))
            {
                this.topControl.Size = new Size(size.Width, 36);
                this.ContainerControl.Size = new Size(size.Width, size.Height - 36);
                if (this.Container.Width <= this.ContainerControl.Width)
                {
                    this.Container.Size = new Size(this.ContainerControl.Width, this.ContainerControl.Height);
                }
                else
                {
                    this.Container.Size = new Size(this.Container.Width, this.ContainerControl.Height);
                }
            }
            else
            {
                this.ContainerControl.Size = size;
                if (this.Container.Width <= this.ContainerControl.Width)
                {
                    this.Container.Size = new Size(this.ContainerControl.Width, this.ContainerControl.Height);
                }
                else
                {
                    this.Container.Size = new Size(this.Container.Width, this.ContainerControl.Height);
                }
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
            Dictionary<string, object> selectedNodeDic = e.Object as  Dictionary<string, object>;            
            if(selectedNodeDic != null && selectedNodeDic.ContainsKey("prescriptionTreeView"))
            //if (e.Object is Medicalroutinetreedto)
            {
                this.id_ortmpl =  (selectedNodeDic["prescriptionTreeView"] as Medicalroutinetreedto).Id_ortmplca;
                //this.id_ortmpl = (e.Object as Medicalroutinetreedto).Id_ortmplca;
                LoadData();
            }
        }
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {

            if (!string.IsNullOrEmpty(this.id_ortmpl))
            {
                this.model = new NewOrderTemplateListViewModel(id_ortmpl);
            }
            else
            {
                this.model = new NewOrderTemplateListViewModel("");
            }
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            NewOrderTemplateDTO[] data = this.model.newOrderTemplate;
            int startX = 0;
            int startY = 10;

            this.Container.RemoveRenderAll();
            this.Nulldata = true;
            // {{不跨页选择项目
            this.OrderRenderList.Clear();
            this.OrTplDodic.Clear();
            this.SelectOrderDic.Clear();
            // }}
            OrderRender TMP = new OrderRender(this);
            if (data != null)
            {
                if (data.Length > 0)
                {
                    //首先先要判断进来的数据类型是否是草药类型，然后根据类型创建当前view的显示方式
                    this.isHerb = data[0].Templatetype.Value;
                    ResetControl(this.isHerb, data[0]);
                }
                else
                {
                    this.isHerb = false;
                    ResetControl(this.isHerb, null);
                }
                foreach (NewOrderTemplateDTO tpl in data)
                {
                    this.MaxStartX = 0;
                    this.Nulldata = false;
                    if (tpl.Ui_flag == "2" || tpl.Ui_flag == "1" || tpl.Ui_flag == "5")
                    {
                        OrderRender ThreadRender = new OrderRender(this.Container);
                        ThreadRender.Size = new Size(280, 24);
                        ThreadRender.IsParent = true;
                        ThreadRender.ListDo = tpl.Itemlist.ToArray();
                        this.SetOrTplDodic(tpl);
                        ThreadRender.ObjDo = tpl;
                        ThreadRender.Id = tpl.Id;
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
                        this.OrderRenderList.Add(ThreadRender);
                        if (ThreadRender.OrderRenderList != null && ThreadRender.OrderRenderList.Count > 0)
                        {
                            foreach (OrderRender render in ThreadRender.OrderRenderList)
                            {
                                render.Checkchanged += new OrderRender.CheckValuechanged(OrderTemplateListView_Checkchanged);
                            }
                        }
                        TMP = ThreadRender;

                    }
                    if (tpl.Ui_flag == "3")
                    {                      
                        OrderRender ThreadRender = new OrderRender(this.Container);
                        ThreadRender.Size = new Size(280, 24);
                        ThreadRender.IsParent = true;
                        ThreadRender.ListDo = tpl.Itemlist.ToArray();
                        this.SetOrTplDodic(tpl);
                        ThreadRender.ObjDo = tpl;
                        //ThreadRender.Id = tpl.Id;
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
                        this.OrderRenderList.Add(ThreadRender);
                        if (ThreadRender.OrderRenderList != null && ThreadRender.OrderRenderList.Count > 0)
                        {
                            foreach (OrderRender render in ThreadRender.OrderRenderList)
                            {
                                render.Checkchanged += new OrderRender.CheckValuechanged(OrderTemplateListView_Checkchanged);
                            }
                        }
                        TMP = ThreadRender;
                    }
                    if (tpl.Ui_flag == "4")
                    {
                        //if (!OrTplDodic.ContainsKey(tpl.Id))
                        //{
                        //    OrTplDodic.Add(tpl.Id, tpl);
                        //}
                        OrderRender ThreadRender = new OrderRender(this.Container);
                        ThreadRender.Size = new Size(280, 24);
                        ThreadRender.ListDo = tpl.Itemlist.ToArray();
                        ThreadRender.ObjDo = tpl;
                        this.SetOrTplDodic(tpl);
                        //ThreadRender.Id = tpl.Id;
                        ThreadRender.Note = tpl.Str;
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
                        this.OrderRenderList.Add(ThreadRender);
                        TMP = ThreadRender;
                    }
                }
            }
            else
            {
                this.isHerb = false;
                ResetControl(this.isHerb, null);
            }
            if (this.Container.Size.Width <= TMP.Bound.Right)
            {
                this.Container.Size = new Size(TMP.Bound.Right, ContainerControl.Size.Height);
            }
            this.Container.Invalidate();
            this.ContainerControl.getScrollBarRect();
        }

        /// <summary>
        /// 保存协定处方
        /// </summary>
                 
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
            if (this.SelectOrderDic.Count > 0)
            {
                foreach (string str in this.SelectOrderDic.Keys)
                {
                    Args.listObj.Add(OrTplDodic[str]);
                }
            }
             Args.Id_item = "ortmplate";
            (control as helperForm).Args = Args;
            (control as helperForm).DialogResult = DialogResult.OK;
        }

        #endregion

        #region 内部事件区域
        void prescriptionListView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }
        #endregion

        #region 辅助处理函数
        private void OrderTemplateListView_Checkchanged(OrderRender render, bool flag)
        {
            if (!render.IsParent)
            {
                if (render.Check && !SelectOrderDic.ContainsKey(render.Id))
                {
                    this.SelectOrderDic.Add(render.Id, render);
                }
                else if (!render.Check && SelectOrderDic.ContainsKey(render.Id))
                {
                    this.SelectOrderDic.Remove(render.Id);
                }
            }
        }
        void ThreadRender_Checkchanged(OrderRender render, bool flag)
        {
            if (!render.IsParent)
            {
                if (render.Check && !SelectOrderDic.ContainsKey(render.Id))
                {
                    this.SelectOrderDic.Add(render.Id, render);
                }
                else if (!render.Check && SelectOrderDic.ContainsKey(render.Id))
                {
                    this.SelectOrderDic.Remove(render.Id);
                }
            }
        }       

        /// <summary>
        /// 缓存协定处方显示的模板明细
        /// </summary>
        /// <param name="orderTemplate">模板对象</param>
        private void SetOrTplDodic(NewOrderTemplateDTO orderTemplate)
        {
            foreach(Object obj in orderTemplate.Itemlist) {

                if (obj is OrTplNItmDO)
                {
                    OrTplNItmDO orTplNItm = obj as OrTplNItmDO;

                    if (!OrTplDodic.ContainsKey(orTplNItm.Id_ortmplitm))
                    {
                        // 如果模板明细中的煎法、用法、频次为空，使用NewOrderTemplateDTO对象中的对应属性，当模板初始加载，不选择煎法时，明细中煎法为空

                        orTplNItm.Id_boil = orderTemplate.Id_boil;
                        orTplNItm.Id_route = orderTemplate.Id_route;
                        orTplNItm.Id_freq = orderTemplate.Id_freq;

                        OrTplDodic.Add(orTplNItm.Id_ortmplitm, orTplNItm);
                    }
                }
            }           
        }


        private void ResetControl(bool isHerb, NewOrderTemplateDTO tnmpDto)
        {
            if (isHerb)
            {
                if (topControl != null && this.RenderControls.Contains(topControl))
                {
                    return;
                }

                topControl = new XBaseControl();
                topControl.Size = new Size(this.Size.Width, 36);
                topControl.Location = new Point(1, 0);
                this.AddRender(topControl);

                usageRender = XLabelControlFactory.GetLabelComboBox(topControl, tnmpDto.getrouteList());
                usageRender.ValueText = tnmpDto.Name_route;
                usageRender.Size = new System.Drawing.Size(236, 24);
                usageRender.TitleText = "用法：";                
                usageRender.ValueText = tnmpDto.Id_route;
                usageRender.Location = new Point(0, 6);
                usageRender.ValueTextChanged += new EventHandler(usageRender_ValueTextChanged);
                topControl.AddRender(usageRender);

                frequencyRender = XLabelControlFactory.GetLabelComboBox(topControl, tnmpDto.getFreqdefdo());
                frequencyRender.TitleText = "频次：";                
                frequencyRender.ValueText = tnmpDto.Id_freq;
                frequencyRender.Size = new System.Drawing.Size(236, 24);
                frequencyRender.Location = new Point(usageRender.Bound.Right, 6);
                frequencyRender.ValueTextChanged += new EventHandler(frequencyRender_ValueTextChanged);
                topControl.AddRender(frequencyRender);

                decoctionRender = XLabelControlFactory.GetLabelComboBox(topControl, tnmpDto.getBoilList());
                decoctionRender.TitleText = "煎法：";                
                decoctionRender.ValueText = tnmpDto.Id_boil;
                decoctionRender.Size = new System.Drawing.Size(236, 24);
                decoctionRender.Location = new Point(frequencyRender.Bound.Right, 6);
                decoctionRender.ValueTextChanged += new EventHandler(decoctionRender_ValueTextChanged);
                topControl.AddRender(decoctionRender);

                checkAllRender = new XCheckBox();
                checkAllRender.Text = "全选";
                checkAllRender.Location = new Point(decoctionRender.Bound.Right + 20, (36 - checkAllRender.Bound.Height) / 2);
                checkAllRender.ValueTextChanged += new EventHandler(checkAllRender_ValueTextChanged);
                topControl.AddRender(checkAllRender);

                this.ContainerControl.Size = new Size(this.Size.Width, this.Size.Height - 37);
                this.ContainerControl.Location = new Point(1, 37);
                this.Container.Size = new Size(this.Container.Width, this.ContainerControl.Height);
                if (this.Container.Width <= this.ContainerControl.Width)
                {
                    this.Container.Size = new Size(this.ContainerControl.Width, this.ContainerControl.Height);
                }
                else
                {
                    this.Container.Size = new Size(this.Container.Width, this.ContainerControl.Height);
                }
            }
            else
            {
                if (topControl != null && this.RenderControls.Contains(topControl))
                {
                    this.RemoveRender(topControl);
                    this.ContainerControl.Size = new Size(this.Size.Width, this.Size.Height);
                    this.ContainerControl.Location = new Point(1, 0);
                    this.Container.Size = new Size(this.Container.Width, this.ContainerControl.Height);
                    if (this.Container.Width <= this.ContainerControl.Width)
                    {
                        this.Container.Size = new Size(this.ContainerControl.Width, this.ContainerControl.Height);
                    }
                    else
                    {
                        this.Container.Size = new Size(this.Container.Width, this.ContainerControl.Height);
                    }
                }
            }
        }

        private void checkAllRender_ValueTextChanged(object sender, EventArgs e)
        {
            XCheckBox checkBox = sender as XCheckBox;
            if (checkBox.Checked)
            {
                foreach (OrderRender orrender in this.OrderRenderList)
                {
                    orrender.Check = true;
                    orrender.SetRenderCheck(orrender.Check);
                }
            }
            else
            {
                foreach (OrderRender orrender in this.OrderRenderList)
                {
                    orrender.Check = false;
                    orrender.SetRenderCheck(orrender.Check);
                }
            }
            this.Invalidate();
        }

        /// <summary>
        /// 用法下拉框切换选项，重新给模板明细对象中用法赋值
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void usageRender_ValueTextChanged(object sender, EventArgs e)
        {
            XLabelBaseUserRender render = sender as XLabelBaseUserRender;
            XComboBox combo = render.UserRender as XComboBox;
            foreach (OrTplNItmDO ortDo in this.OrTplDodic.Values)
            {
                ortDo.Id_route = combo.ValueText;
            }
            this.Invalidate();
        }

        /// <summary>
        /// 频次下拉框切换选项，重新给模板明细对象中频次赋值
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void frequencyRender_ValueTextChanged(object sender, EventArgs e)
        {
            XLabelBaseUserRender render = sender as XLabelBaseUserRender;
            XComboBox combo = render.UserRender as XComboBox;
            foreach (OrTplNItmDO ortDo in this.OrTplDodic.Values)
            {
                ortDo.Id_freq = combo.ValueText;
            }
            this.Invalidate();
        }

        /// <summary>
        /// 煎法下拉框切换选项，重新给模板明细对象中煎法赋值
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void decoctionRender_ValueTextChanged(object sender, EventArgs e)
        {
            XLabelBaseUserRender render = sender as XLabelBaseUserRender;
            XComboBox combo = render.UserRender as XComboBox;
            foreach (OrTplNItmDO ortDo in this.OrTplDodic.Values)
            {
                ortDo.Id_boil = combo.ValueText;
            }
            this.Invalidate();
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    Dictionary<string, Object> data = eventArgs.Data[UIConst.DATA] as Dictionary<string, Object>;
                    this.OnLoadData();
                    break;
                case UIEvent.SAVE_SUCCESS:
                    this.LoadData();
                    break;
                default:
                    break;
            }
        }

        #endregion
    }
}
