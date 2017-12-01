using System;
using System.Drawing;
using System.Windows.Forms;
using System.Collections.Generic;
using iih.ci.ord.doctorhelper.newtemplate.viewmodel;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using iih.ci.ord.ciorder.render;
using iih.bd.srv.ortpl.d;
using iih.bd.srv.ortpl.dto;
using xap.cli.sdk.controls;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.dto.newordertemplatedto.d;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.extentions;

namespace iih.ci.ord.doctorhelper.newtemplate.view
{
    /// <summary>
    /// 医嘱模板
    /// </summary>
    public partial class NewOrderTemplateListView : HelperListView
    {
        #region 变量定义区域
        /// <summary>
        /// model 模板明细
        /// </summary>
        private NewOrderTemplateListViewModel model;
        /// <summary>
        /// 模板明细
        /// </summary>
        private String id_ortmpl = "";
        // 文本长度
        private SizeF textsize;
        //最大开始位置，用来定位每一个render的location
        //数据为空时的提示
        private string Tiptext;
        //最大开始位置，用来定位每一个render的location
        private int MaxStartX;
        //所有对象
        private List<OrderRender> OrderRenderList = new List<OrderRender>();
        //选中的render字典
        public Dictionary<string, OrderRender> SelectOrderDic = new Dictionary<string, OrderRender>();
        //接收到的数据对象
        private Dictionary<string, OrTplNItmDO> OrTplDodic = new Dictionary<string, OrTplNItmDO>();
        private XBaseControl topControl;
        //是否是草药类型
        private bool isHerb;
        //判断是否为空的标志
        private bool Nulldata = false;
        private XAPScrollBarPanel ContainerControl;
        private new XBaseControl Container;
        private XLabelBaseUserRender usageRender;     //用法
        private XLabelBaseUserRender frequencyRender; //频次
        private XLabelBaseUserRender decoctionRender; //煎法
        private XCheckBox checkAllRender; //全选
        private OrScArgs Args;
        #endregion

        #region 构造函数区域
        public NewOrderTemplateListView()
        {
            InitializeComponent();

            this.ContainerControl = new XAPScrollBarPanel();
            this.ContainerControl.Size = new Size(this.Size.Width, 365);
            this.ContainerControl.Dock = DockStyle.Fill;
            this.AddRender(ContainerControl);

            this.Container = new XBaseControl();
            this.Container.Size = new Size(ContainerControl.Size.Width, ContainerControl.Size.Height);
            this.Container.Location = new Point(0, 0);
            this.Container.Paint += new PaintEventHandler(Container_Paint);
            this.ContainerControl.AddRender(Container);

            this.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.Tiptext = "未检索到相关数据";
            this.textsize = TextRenderer.MeasureText(Tiptext, this.Font);
            this.SizeChanged += new EventHandler(NewOrderTemplateListView_SizeChanged);

            this.Load += new EventHandler(NewOrderTemplateListView_Load);
        }
        #endregion

        #region 内部事件区域

        private void NewOrderTemplateListView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        private void NewOrderTemplateListView_SizeChanged(object sender, EventArgs e)
        {
            Size size = (sender as NewOrderTemplateListView).Size;
            this.ContainerControl.Size = size;
            if (this.Container.Width <= this.ContainerControl.Width)
            {
                this.Container.Size = new Size(this.ContainerControl.Width, this.ContainerControl.Height);
            }
            this.ContainerControl.Invalidate();
        }

        private void Container_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(0, 0), new Point(0, this.Size.Height - 1));
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
        #endregion

        #region 事件发送区域

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            OrTmplDTO orTmpl = e.Object as OrTmplDTO;
            if (orTmpl != null)
            {
                this.id_ortmpl = orTmpl.Id_ortmpl;
            }
            else
            {
                this.id_ortmpl = "";
            }
     
            this.LoadData();
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
                    if (tpl.Ui_flag == "4"||tpl.Ui_flag=="6")
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

        private void ThreadRender_Checkchanged(OrderRender render, bool flag)
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
            //else
            //{
            //    if (render.OrderRenderList != null && render.OrderRenderList.Count > 0)
            //    {
            //        if (render.Check)
            //        {
            //            foreach (OrderRender irender in render.OrderRenderList)
            //            {
            //                if (!SelectOrderDic.ContainsKey(irender.Id))
            //                {
            //                    SelectOrderDic.Add(irender.Id, irender);
            //                }
            //            }
            //        }
            //        else
            //        {
            //            foreach (OrderRender irender in render.OrderRenderList)
            //            {
            //                if (SelectOrderDic.ContainsKey(irender.Id))
            //                {
            //                    SelectOrderDic.Remove(irender.Id);
            //                    break;
            //                }
            //            }
            //        }
            //    }
            //}
        }
        #endregion

        #region 辅助处理函数
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
                    if (OrTplDodic[str].Quan_med == null || OrTplDodic[str].Quan_med.ToString().Length >4)
                    {
                        this.ShowInfo(OrTplDodic[str].Ortplnitm_srv_name+" 剂量异常");
                        return;
                    }

                    Args.listObj.Add(OrTplDodic[str]);
                }
            }

            
            int t = this.OrderRenderList.Count;
            //(control as helperForm).Args = Args;
            Args.Id_item = "ortmplate";
            if (((control as helperForm)).view2 != null)
            {
                (control as helperForm).view2.Args = Args;
                (control as helperForm).DialogResult = DialogResult.OK;
            }
            if (((control as helperForm)).View != null)
            {
                (control as helperForm).Args = Args;
                (control as helperForm).DialogResult = DialogResult.OK;
            }

        }
        #endregion
    }
}
