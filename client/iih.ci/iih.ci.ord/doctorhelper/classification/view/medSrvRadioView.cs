using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.bd.bc.udi;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using iih.ci.ord.doctorhelper.classification.viewmodel;
using iih.bd.srv.srvcate.d;
using xap.rui.appfw;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciorder.render;
using xap.cli.sdk.controls;
using xap.cli.sdk.render;
using xap.cli.sdk.layouts;
using iih.ci.ord.ciorder.cards.extend;
using xap.cli.sdk.controls.tabControl;
using xap.mw.core.data;
using System.Collections;
/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 服务分类


*********************************************************************************/
namespace iih.ci.ord.doctorhelper.classification.view
{
    /// <summary>
    /// <para>描    述 : 服务录入-分类选取-视图            </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view       </para>    
    /// <para>类 名 称 : medSrvRadioView                   </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 : qzwang                            </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class medSrvRadioView : HelperListView
    {

        #region 变量定义区域
        
        private SizeF Textsize;//文本长度
        private int MaxStartX;
        private string Tiptext;
        protected bool Nulldata = false;
        public medSrvRadioViewModel model;
        private OrScArgs Args;
        private AlphabetRenderGroup topAlphabetRenderGroup;
        protected XAPScrollBarPanel ContainerControl;
        protected string Id_srvca;
        protected string Id_srv;
        public Dictionary<string, OrderRender> SelectOrder = new Dictionary<string, OrderRender>();
        //所有数据的集合（key是Id_srv，value是对应Do）
        private Dictionary<string, MedSrvDO> medSrvDodic = new Dictionary<string, MedSrvDO>();
        //界面上所有的OrderRender的列表集合（key是Id_srv）
        public Dictionary<string, OrderRender> OrderRenderlist = new Dictionary<string, OrderRender>();
        //所有数据的集合（key是字母，value对应该字母下边的数据列表）
        private Dictionary<string, List<MedSrvDO>> alphabetDict = new Dictionary<string, List<MedSrvDO>>();
        #endregion
        
        #region 构造函数区域

        public  medSrvRadioView()
        {
            InitializeComponent();
            this.Load += new EventHandler(medSrvRadioView_Load);

            this.topAlphabetRenderGroup = new AlphabetRenderGroup();
            this.topAlphabetRenderGroup.Size = new Size(this.Size.Width, 28);
            this.topAlphabetRenderGroup.Location = new Point(0, 0);
            this.topAlphabetRenderGroup.RenderMouseClick += new MouseEventHandler(topAlphabetRenderGroup_RenderMouseClick);
            this.AddRender(this.topAlphabetRenderGroup);

            this.ContainerControl = new XAPScrollBarPanel();
            this.ContainerControl.Size = new Size(this.Size.Width, this.Height - 30);
            this.ContainerControl.Location = new Point(0, 29);
            this.ContainerControl.Paint += new PaintEventHandler(Container_Paint);
            this.AddRender(ContainerControl);

            this.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.Tiptext = "未检索到相关数据";
            this.Textsize = TextRenderer.MeasureText(Tiptext, this.Font);
            this.SizeChanged += new EventHandler(medSrvRadioView_SizeChanged);
            this.ContainerControl.HPreferStep = 216;
        }

        private void topAlphabetRenderGroup_RenderMouseClick(object sender, MouseEventArgs e)
        {
            if (sender is AlphabetRender)
            {
                AlphabetRender render = sender as AlphabetRender;
                FillData(render);
            }
        }

        private void medSrvRadioView_SizeChanged(object sender, EventArgs e)
        {
            Size size = (sender as medSrvRadioView).Size;
            this.topAlphabetRenderGroup.Size = new Size(size.Width, 28);
            this.topAlphabetRenderGroup.Location = new Point(0, 0);
            this.ContainerControl.Size = new Size(this.Width, this.Height - this.topAlphabetRenderGroup.Size.Height-2);
            this.ContainerControl.Location = new Point(0, this.topAlphabetRenderGroup.Size.Height);
        }

        private void Container_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(0, 0), new Point(this.ContainerControl.Width - 1, 0));
            e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(0, 0), new Point(0, this.ContainerControl.Size.Height - 1));
            if (!this.Nulldata)
            {
                int first=0;
                while (first < this.MaxStartX)
                {
                    first += 216;
                    e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(first, 6), new Point(first, this.ContainerControl.Size.Height - 16));
                }
                
            }
            else
            {
                e.Graphics.DrawString(Tiptext, this.Font, new SolidBrush(Color.Black), new Point((this.Size.Width - (int)this.Textsize.Width) / 2, (this.Size.Height - (int)this.Textsize.Height) / 2));
            }
        }
      
        private void medSrvRadioView_Load(object sender, EventArgs e)
        {
            this.OnInit();
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
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (Id_srvca == null) return;            
            model = new medSrvRadioViewModel(this.Ent4BannerDTO.Code_entp,this.FgUse, Id_srvca);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            this.MaxStartX = 0;
            this.ContainerControl.hScroll.Value = 0;
            this.ContainerControl.RemoveRenderAll();
            this.ContainerControl.getScrollBarRect();
            this.ContainerControl.Invalidate();
            if (this.model!= null)
            {
                this.Nulldata = true;
                FMap2 data = this.model.medSrvDOMap;
                this.medSrvDodic.Clear();
                this.alphabetDict.Clear();
                List<string> alphabetList = new List<string>(data.Keys);
                if (alphabetList.Count >0)
                {
                   // 将fmap2转成对应字典并将所有数据放在一个字典中
                    foreach (string alphaText in alphabetList)
                    {
                        //过滤数据保证只有最多27项可以填入字典
                        if (this.topAlphabetRenderGroup != null && this.topAlphabetRenderGroup.RenderDict != null && !this.topAlphabetRenderGroup.RenderDict.ContainsKey(alphaText)) 
                            continue;
                        if (!this.alphabetDict.ContainsKey(alphaText) && data[alphaText] != null)
                        {
                            List<MedSrvDO> dataList = new List<MedSrvDO>();
                            foreach (object item in (IEnumerable)(data[alphaText]))
                            {
                                if (item is MedSrvDO)
                                {
                                    dataList.Add(item as MedSrvDO);
                                }
                            }
                            this.alphabetDict.Add(alphaText, dataList);
                            if (dataList!=null)
                            {
                                foreach (MedSrvDO medDo in dataList)
                                {
                                    if (!medSrvDodic.ContainsKey(medDo.Id_srv))
                                    {
                                        medSrvDodic.Add(medDo.Id_srv, medDo);
                                    }
                                }
                            }
                        }
                    }
                    if (medSrvDodic.Count >0)
                    {
                        this.Nulldata = false;
                    }
                }
                //设置字母区域的显示
                this.topAlphabetRenderGroup.SetEnabled(this.alphabetDict);
                this.topAlphabetRenderGroup.SelectedIndex = 0;
            }
        }

        private void FillData(AlphabetRender render)
        {
            string alphaText = render.Text ;
            this.MaxStartX = 0;
            this.ContainerControl.hScroll.Value = 0;
            this.ContainerControl.RemoveRenderAll();
            this.ContainerControl.getScrollBarRect();
            this.ContainerControl.Invalidate();
            this.OrderRenderlist.Clear();
            if (this.alphabetDict != null && this.alphabetDict.ContainsKey(alphaText))
            {
                List<MedSrvDO> data = this.alphabetDict[alphaText];
                int startX = 1;
                int startY = 10;
                OrderRender TMP = null;
                if (data.Count > 0)
                {
                    this.MaxStartX = 0;
                    //添加标题栏
                    OrderTitleRender orderTitleRender = new OrderTitleRender();
                    if (alphaText == "OTHER")
                    {
                        orderTitleRender.Text = "其他";
                    }
                    else
                    {
                        orderTitleRender.Text = alphaText;
                    }
                    orderTitleRender.Size = new Size(216, 24);
                    orderTitleRender.Location = new Point(startX , startY);
                    startY += orderTitleRender.Size.Height;
                    if (this.MaxStartX <= startX)
                    {
                        this.MaxStartX = startX;
                    }
                    this.ContainerControl.AddRender(orderTitleRender);
                    for (int i = 0; i < data.Count; i++)
                    {    
                        OrderRender ThreadRender = createOrderRender();
                        ThreadRender.Checkchanged += new OrderRender.CheckValuechanged(ThreadRender_Checkchanged);
                        ThreadRender.CancelChecked += new OrderRender.CheckValuechanged(ThreadRender_CancelChecked);
                        ThreadRender.ObjDo = data[i];
                        ThreadRender.Size = new Size(216, 24);
                        if (TMP != null && startY + ThreadRender.Size.Height > this.ContainerControl.Size.Height - 5)
                        {
                            startX = TMP.Bound.Right;
                            startY = 10;
                        }
                        ThreadRender.Location = new Point(startX, startY);
                        startY += ThreadRender.Size.Height;
                        if (this.MaxStartX <= startX)
                        {
                            this.MaxStartX = startX;
                        }
                        this.OrderRenderlist.Add(data[i].Id_srv, ThreadRender);
                        this.ContainerControl.AddRender(ThreadRender);
                        TMP = ThreadRender;
                        // 判断是否包含不可用的服务，如果存在，禁用服务
                        if (this.model.SrvStatusMap.Keys.Contains(data[i].Id_srv))
                        {

                            ThreadRender.Enabled = false;
                            ThreadRender.ForeColor = Color.Red;
                            ThreadRender.TooltipText = this.model.SrvStatusMap[data[i].Id_srv] as string;

                        }
                    }
                }
                this.ContainerControl.getScrollBarRect();
                this.ContainerControl.Invalidate();
            }
        }

        protected virtual OrderRender createOrderRender()
        {
            OrderRender ThreadRender = new OrderRender(this, true);
            return ThreadRender;
        }

        public override void SaveData()
        {
            Args = new OrScArgs();
            Args.listObj = new List<object>();
            Control control = this.Parent;
            // 向上寻找父窗体，并把数据主动的送出去。
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
            if (!string.IsNullOrEmpty(this.Id_srv))
            {
                Args.listObj.Add(medSrvDodic[this.Id_srv]);
            }
             Args.Id_item = "medsrv";
            (control as helperForm).Args = Args;
            (control as helperForm).DialogResult = DialogResult.OK;
        }

        #endregion

        #region 内部事件区域

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            // 接受选中树的数据
            if (e.Object is SrvCateDO)
            {
                Id_srvca = (e.Object as SrvCateDO).Id_srvca;
                LoadData();
            }

            //Control control = this.Parent;
            //// 判断该页签是否是选中
            //while (control != null)
            //{
            //    if (control is XTabPage)
            //    {
            //        if ((control as XTabPage).IsSelected)
            //        {
            //            if (e.Object is SrvCateDO)
            //            {
            //                Id_srvca = (e.Object as SrvCateDO).Id_srvca;
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

        protected void ThreadRender_CancelChecked(OrderRender render, bool flag)
        {
            this.Id_srv = string.Empty;
        }

        protected virtual void ThreadRender_Checkchanged(OrderRender render, bool flag)
        {
            foreach (string Id_srv in this.OrderRenderlist.Keys)
            {
                if (OrderRenderlist[Id_srv] == render)
                {
                    OrderRenderlist[Id_srv].Check = true;
                    //按钮做相应处理时，字母选中和title选中也作相应改变
                    if (OrderRenderlist[Id_srv].ObjDo is MedSrvDO)
                    {
                        string text = (OrderRenderlist[Id_srv].ObjDo as MedSrvDO).Pycode.Substring(0, 1);
                        if (this.topAlphabetRenderGroup.AlphabetRenderDict!=null)
                        {
                            foreach (string alphabetText in this.topAlphabetRenderGroup.AlphabetRenderDict.Keys)
                            {
                                if (alphabetText == text)
                                {
                                    this.topAlphabetRenderGroup.AlphabetRenderDict[alphabetText].IsSelected = true;
                                }
                                else
                                {
                                    this.topAlphabetRenderGroup.AlphabetRenderDict[alphabetText].IsSelected = false;
                                }
                            }
                            this.topAlphabetRenderGroup.Invalidate();
                        }
                        this.ContainerControl.Invalidate();
                    }
                    this.Id_srv = Id_srv;
                }
                else
                {
                    OrderRenderlist[Id_srv].CancelChecked -= new OrderRender.CheckValuechanged(ThreadRender_CancelChecked);
                    OrderRenderlist[Id_srv].Checkchanged -= new OrderRender.CheckValuechanged(ThreadRender_Checkchanged);
                    OrderRenderlist[Id_srv].Check = false;
                    OrderRenderlist[Id_srv].CancelChecked += new OrderRender.CheckValuechanged(ThreadRender_CancelChecked);
                    OrderRenderlist[Id_srv].Checkchanged += new OrderRender.CheckValuechanged(ThreadRender_Checkchanged);
                }
            }
        }

        public new event EventHandler<DictionaryEventArgs> EventSent;

        private void FireEventSent()
        {
            if(EventSent!=null)
            {
                EventSent(this, null);
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
