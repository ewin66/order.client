using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.bd.srv.ems.d;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.engine;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.doctorhelper.commonorder.viewmodel;
using xap.cli.sdk.render;
using iih.ci.ord.ciorder.cards.extend;
using xap.cli.sdk.controls;
using iih.ci.ord.ciorder.render;
using iih.ci.ord.dto.medicalroutinetreedto.d;
using iih.ci.ord.dto.newordertemplatedto.d;
using iih.ci.ord.ems.d;
using iih.en.pv.dto.d;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.form;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.extentions;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 常规模板


*********************************************************************************/
namespace iih.ci.ord.doctorhelper.commonorder.view
{
    public partial class commonOrderListView : XapListControl, IViewSave
    {
        //常规医嘱
      //常规医嘱
        #region 变量定义区域

        /// <summary>
        /// 事件交互类，与配置文件内的类进行交互
        /// </summary>
        public XapBaseControl xapBaseControl;

        public XForm AssiViewFrame { get; set; }
        public Ent4BannerDTO BannerDTO;
        /// 保存模板
        /// </summary>
        //public AssButtonViewModel Buttonmodel;

        //private XapFormControl xapFormControl;
        private commonOrderListViewModel model;
        private string Id_regularorca;
        private SizeF Textsize;//文本长度
        // private Dictionary<string, OrTplNItmDO> medSrvDodic = new Dictionary<string, OrTplNItmDO>();


        private OrScArgs Args;
        protected XAPScrollBarPanel ContainerControl;
        private new XBaseControl Container;




        //private SizeF textsize;
        //最大开始位置，用来定位每一个render的location
        private int MaxStartX;
        //数据为空时的提示
        private string Tiptext;
        //所有对象
        private List<OrderRender> OrderRenderList = new List<OrderRender>();
        //选中的render字典
        public Dictionary<string, OrderRender> SelectOrderDic = new Dictionary<string, OrderRender>();
        //接收到的数据对象
        private Dictionary<string, OrTplNItmDO> OrTplDodic = new Dictionary<string, OrTplNItmDO>();
        //判断是否为空的标志
        private bool Nulldata = false;

        //是否是草药类型
        private bool isHerb;
        private XBaseControl topControl;
        private XLabelBaseUserRender usageRender;     //用法
        private XLabelBaseUserRender frequencyRender; //频次
        private XLabelBaseUserRender decoctionRender; //煎法
        private XCheckBox checkAllRender; //全选

        #endregion

        #region 构造函数区域

        public commonOrderListView()
        {
            InitializeComponent();
            this.Load += new EventHandler(commonOrderListView_Load);

            this.ContainerControl = new XAPScrollBarPanel();
            this.ContainerControl.Size = new Size(this.Size.Width, 365);
            this.ContainerControl.Dock = DockStyle.Fill;
            this.AddRender(ContainerControl);

            this.Container = new XBaseControl();
            this.Container.Size = new Size(ContainerControl.Size.Width, ContainerControl.Size.Height);
            this.Container.Location = new Point(0, 0);
            this.Container.Paint += new PaintEventHandler(Container_Paint);
            ContainerControl.AddRender(Container);


            this.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.Tiptext = "未检索到相关数据";
            this.Textsize = TextRenderer.MeasureText(Tiptext, this.Font);
            this.SizeChanged += new EventHandler(commonOrderListView_SizeChanged);
        }

        void commonOrderListView_SizeChanged(object sender, EventArgs e)
        {
            Size size = (sender as commonOrderListView).Size;
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
            // 通过e.Object is Medicalroutinetreedto 判断错误，常规医嘱和协定处方使用的类都是Medicalroutinetreedto 导致错误
            Dictionary<string,object> selectedNodeDic = e.Object as Dictionary<string, object>;            
            if (selectedNodeDic != null && selectedNodeDic.ContainsKey("conmonOrderTreeView")) // e.Object is Medicalroutinetreedto
            {
                if ((selectedNodeDic["conmonOrderTreeView"] as Medicalroutinetreedto) != null)
                {
                    this.Id_regularorca = (selectedNodeDic["conmonOrderTreeView"] as Medicalroutinetreedto).Id_ortmplca;
                    LoadData();
                }
              
            }
            ////base.OnSelected(sender, e);

            //Control control = this.Parent;
            //// 判断该页签是否是选中
            //while (control != null)
            //{
            //    if (control is XTabPage)
            //    {
            //        if ((control as XTabPage).IsSelected)
            //        {
            //            if (e.Object is RegularOrCaDO)
            //            {
            //                this.Id_regularorca = (e.Object as RegularOrCaDO).Id_regularorca;
            //                LoadData();
            //            }
            //        }
            //        break;
            //    }
            //    else
            //    {
            //        control = control.Parent;
            //    }
            //}
        }
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (Id_regularorca == null) return;
            model = new commonOrderListViewModel(Id_regularorca);
           // this.Buttonmodel = new AssButtonViewModel();
        }



        protected override void OnFillData()
        {
            if (this.model == null) return;
            NewOrderTemplateDTO[] data = this.model.newOrderTemplate;
            if (data == null) return;

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
                    //Ui_flag  1 :套 ,  2:(多药品)药品, 3:(单一药品),  4 :其它
                    if (tpl.Ui_flag == "2" || tpl.Ui_flag == "1")
                    {
                        OrderRender ThreadRender = new OrderRender(this.Container);
                        ThreadRender.Size = new Size(280, 24);
                        ThreadRender.IsParent = true;
                        ThreadRender.ListDo = tpl.Itemlist.ToArray();
                        this.SetOrTplDodic(tpl.Itemlist.ToArray());
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
                        //if (!OrTplDodic.ContainsKey(tpl.Id))
                        //{
                        //    OrTplDodic.Add(tpl.Id, tpl);
                        //}
                        OrderRender ThreadRender = new OrderRender(this.Container);
                        ThreadRender.Size = new Size(280, 24);
                        ThreadRender.IsParent = true;
                        ThreadRender.ListDo = tpl.Itemlist.ToArray();
                        this.SetOrTplDodic(tpl.Itemlist.ToArray());
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
                        this.SetOrTplDodic(tpl.Itemlist.ToArray());
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
        private void SetOrTplDodic(object[] ListDo)
        {
            if (ListDo != null && ListDo.Length > 0)
            {
                for (int i = 0; i < ListDo.Length; i++)
                {
                    if (ListDo[i] is OrTplNItmDO)
                    {
                        OrTplNItmDO orpdo = ListDo[i] as OrTplNItmDO;
                        if (!OrTplDodic.ContainsKey(orpdo.Id_ortmplitm))
                        {
                            OrTplDodic.Add(orpdo.Id_ortmplitm, orpdo);
                        }
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
                usageRender.Location = new Point(0, 6);
                usageRender.ValueTextChanged += new EventHandler(usageRender_ValueTextChanged);
                topControl.AddRender(usageRender);

                frequencyRender = XLabelControlFactory.GetLabelComboBox(topControl, tnmpDto.getFreqdefdo());
                frequencyRender.TitleText = "频次：";
                frequencyRender.ValueText = tnmpDto.Name_freq;
                frequencyRender.Size = new System.Drawing.Size(236, 24);
                frequencyRender.Location = new Point(usageRender.Bound.Right, 6);
                frequencyRender.ValueTextChanged += new EventHandler(frequencyRender_ValueTextChanged);
                topControl.AddRender(frequencyRender);

                decoctionRender = XLabelControlFactory.GetLabelComboBox(topControl, tnmpDto.getBoilList());
                decoctionRender.TitleText = "煎法：";
                decoctionRender.ValueText = tnmpDto.Name_boil;
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
                }
            }
            else
            {
                foreach (OrderRender orrender in this.OrderRenderList)
                {
                    orrender.Check = false;
                }
            }
            this.Invalidate();
        }
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
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        // protected override void OnFillData()
        // {
        //     if (model != null)
        //     {
        //         XapDataList<OrTplNItmDO> data = this.model.regularOrRelSrvDO;
        //         int startX = 0;
        //         int startY = 10;
        //         foreach (OrderRender Ur in this.OrderRenderlist.Values)
        //         {
        //             this.Container.RemoveRender(Ur);
        //         }
        //         this.OrderRenderlist.Clear();
        //         this.medSrvDodic.Clear();
        //         this.Nulldata = true;
        //         OrderRender TMP = new OrderRender(this);
        //         if (data.Count > 0)
        //         {
        //             this.MaxStartX = 0;
        //             this.Nulldata = false;
        //             for (int i = 0; i < data.Count; i++)
        //             {
        //                 medSrvDodic.Add(data[i].Id_ortmplitm, data[i]);
        //                // dic.Add(data[i].Id_regularorrel, data[i].Name_srv);
        //                 OrderRender ThreadRender = new OrderRender(this);
        //                 ThreadRender.Checkchanged += new OrderRender.CheckValuechanged(ThreadRender_Checkchanged);
        //                 ThreadRender.ObjDo = data[i];
        //                 ThreadRender.Id = data[i].Id_ortmplitm;
        //                // ThreadRender.Note = data[i].Ortplnitm_srv_name;
        //                 ThreadRender.Size = new Size(216, 24);
        //                 if (startY + ThreadRender.Size.Height > this.Container.Size.Height)
        //                 {
        //                     startX = TMP.Bound.Right;
        //                     startY = 10; // TMP.Bound.Bottom;
        //                 }
        //                 ThreadRender.Location = new Point(startX, startY);
        //                 startY += ThreadRender.Size.Height;
        //                 if (this.MaxStartX <= startX)
        //                 {
        //                     this.MaxStartX = startX;
        //                 }
        //                 this.OrderRenderlist.Add(data[i].Id_ortmplitm, ThreadRender);
        //                 this.Container.AddRender(ThreadRender);
        //                 TMP = ThreadRender;
        //             }
        //             if (this.Container.Size.Width <= TMP.Bound.Right)
        //             {
        //                 this.Container.Size = new Size(TMP.Bound.Right, ContainerControl.Size.Height);
        //             }
        //         }
        //         this.Container.Invalidate();
        //         this.ContainerControl.getScrollBarRect();
        //    }
        //}

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
            else
            {
                if (render.OrderRenderList != null && render.OrderRenderList.Count > 0)
                {
                    if (render.Check)
                    {
                        foreach (OrderRender irender in render.OrderRenderList)
                        {
                            if (!SelectOrderDic.ContainsKey(irender.Id))
                            {
                                SelectOrderDic.Add(irender.Id, irender);
                            }
                        }
                    }
                    else
                    {
                        foreach (OrderRender irender in render.OrderRenderList)
                        {
                            if (SelectOrderDic.ContainsKey(irender.Id))
                            {
                                SelectOrderDic.Remove(irender.Id);
                                break;
                            }
                        }
                    }
                }
            }
        }


        public void close()
        {
            this.AssiViewFrame.Close();
        }

        public void Save()
        {
            var list = new List<OrTplNItmDO>();
            if (this.SelectOrderDic == null || this.SelectOrderDic.Count == 0)
            {
                this.ShowInfo("请选择一条数据");
                return;
            }
            if (this.SelectOrderDic.Count > 0)
            {
                foreach (string str in this.SelectOrderDic.Keys)
                {
                    //Args.listObj.Add(OrTplDodic[str]);
                    list.Add(OrTplDodic[str]);
                }
            }

            OnFillData();//清空选中的数据

            var envinfo = setCiEnContextDTO();
            //if (Buttonmodel != null && list.Count > 0)
            //{
            //    var moreEmsDto = Buttonmodel.getMoreEmsParamDTO(envinfo, list.ToArray());
            //    if (moreEmsDto != null)
            //    xapBaseControl.FireEventSent(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_TMPL_EDIT, EventCodeType.ARGKEY_EMS_TMPL_EDIT,
            //         moreEmsDto));
            //}
            
        }
        private CiEnContextDTO setCiEnContextDTO()
        {
            CiEnContextDTO envinfo = new CiEnContextDTO();
            envinfo.Code_entp = BannerDTO.Code_entp;
            envinfo.Id_dep_or = this.Context.Dept.Id_dep;
            envinfo.Id_en = this.BannerDTO.Id_ent;
            envinfo.Id_emp_or = this.Context.PsnInfo.Id_psndoc;
            envinfo.Id_entp = this.BannerDTO.Id_entp;
            envinfo.Id_grp = this.Context.Group.Id_grp;
            envinfo.Id_hp = this.BannerDTO.Id_hp;
            envinfo.Id_org = this.Context.Org.Id_org;
            envinfo.Id_pat = this.BannerDTO.Id_pat;
            envinfo.Fg_bb = this.BannerDTO.Fg_newborn;
            envinfo.Id_dep_en = this.BannerDTO.Id_dep_phy;
            envinfo.Emsappmode = (int)EmsAppModeEnum.SVEMSAPPMODE;
            return envinfo;

        }

        public new void SaveData()
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
                Args.Id_item = "technolog";
                foreach (string str in this.SelectOrderDic.Keys)
                {
                    Args.listObj.Add(OrTplDodic[str]);
                }
            }
            (control as helperForm).Args = Args;
            (control as helperForm).DialogResult = DialogResult.OK;
           // (control.TopLevelControl as helperForm).view.Args = Args;
            // (control.TopLevelControl as OpMedicalTechnologyForm).view.Args = Args;
            // (control.TopLevelControl as OpMedicalTechnologyForm).DialogResult = DialogResult.OK;
        }
        #endregion

        #region 内部事件区域
        void commonOrderListView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        void Container_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(0, 0), new Point(0, this.Container.Size.Height - 1));
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
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.REFRESH:
                    this.LoadData();
                    break;
                case UIEvent.TAB_SELECTED:
                    //    this.OnFillData(); TAB_SELECTED 事件每次点击助手tab页签都会触发数据加载，不需要重复加载
                    break;
                case UIEvent.LOAD:

                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                    }
                    break;
                default:
                    break;
            }
        }

        #endregion
    }
}
