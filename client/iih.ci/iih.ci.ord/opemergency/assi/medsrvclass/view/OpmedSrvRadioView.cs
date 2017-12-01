using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.ortpl.d;
using iih.bd.srv.srvcate.d;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.ciorder.render;
using iih.ci.ord.doctorhelper;
using iih.ci.ord.doctorhelper.classification.viewmodel;
using iih.ci.ord.opemergency.assi.OrderTemplate;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.viewmodel;
using xap.cli.sdk.controls;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.form;
using xap.rui.appfw;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.engine;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.common.utils.msg;
using xap.mw.core.data;
using System.Collections;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 服务分类


*********************************************************************************/
namespace iih.ci.ord.opemergency.assi.medsrvclass.view
{
    public partial class OpmedSrvRadioView : HelperListView
    {

        #region 变量定义区域

        /// <summary>
        /// 事件交互类，与配置文件内的类进行交互
        /// </summary>
        public XapBaseControl xapBaseControl;

        public XForm AssiViewFrame { get; set; }
        //public Ent4BannerDTO BannerDTO;
        /// <summary>
        /// 保存模板
        /// </summary>
        public AssButtonViewModel Buttonmodel;
        public AssButtonViewModel medsrvSetmodel;
        private SizeF Textsize;//文本长度
        private int MaxStartX;
        private string Tiptext;
        protected bool Nulldata = false;
        public medSrvRadioViewModel model;
        private OrScArgs Args;
        private AlphabetRenderGroup naviIndexView;
        protected XAPScrollBarPanel scrollBarPanel;
        protected string Id_srvca;
        protected string Id_srv;
        public Dictionary<string, OrderRender> SelectOrder = new Dictionary<string, OrderRender>();
        //所有数据的集合（key是Id_srv，value是对应Do）
        private Dictionary<string, MedSrvDO> medSrvDodic = new Dictionary<string, MedSrvDO>();
        //界面上所有的OrderRender的列表集合（key是Id_srv）
        public Dictionary<string, OrderRender> OrderRenderlist = new Dictionary<string, OrderRender>();
        //所有数据的集合（key是字母，value对应该字母下边的数据列表）
        private Dictionary<string, List<MedSrvDO>> alphabetDict = new Dictionary<string, List<MedSrvDO>>();

        private AlphabetRender selectedAlphabetRender;
        #endregion

        #region 构造函数区域

        public OpmedSrvRadioView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OnMedSrvRadioView_Load);

            this.naviIndexView = new AlphabetRenderGroup();
            this.naviIndexView.Size = new Size(this.Size.Width, 28);
            this.naviIndexView.Location = new Point(0, 0);
            this.naviIndexView.RenderMouseClick += new MouseEventHandler(topAlphabetRenderGroup_RenderMouseClick);
            this.AddRender(this.naviIndexView);

            this.scrollBarPanel = new XAPScrollBarPanel();
            this.scrollBarPanel.Size = new Size(naviIndexView.Size.Width, this.Height- this.naviIndexView.Size.Height);
            this.scrollBarPanel.Location = new Point(0, this.naviIndexView.Size.Height);
            this.scrollBarPanel.Paint += new PaintEventHandler(OnContainer_Paint);
            this.scrollBarPanel.HPreferStep = 216;
            this.AddRender(scrollBarPanel);

            this.Font = new Font("微软雅黑", 12, GraphicsUnit.Pixel);
            this.Tiptext = "未检索到相关数据";
            this.Textsize = TextRenderer.MeasureText(Tiptext, this.Font);
            this.SizeChanged += new EventHandler(medSrvRadioView_SizeChanged);
        }

        void topAlphabetRenderGroup_RenderMouseClick(object sender, MouseEventArgs e)
        {
            if (sender is AlphabetRender)
            {
                selectedAlphabetRender = sender as AlphabetRender;
                FillData(selectedAlphabetRender);
            }
        }

        void medSrvRadioView_SizeChanged(object sender, EventArgs e)
        {
            Size size = (sender as OpmedSrvRadioView).Size;
            this.naviIndexView.Size = new Size(size.Width, 28);
            this.naviIndexView.Location = new Point(0, 0);
            this.scrollBarPanel.Size = new Size(this.Width, this.Height - this.naviIndexView.Size.Height - 2);
            this.scrollBarPanel.Location = new Point(0, this.naviIndexView.Size.Height);
        }

        void OnContainer_Paint(object sender, PaintEventArgs e)
        {
            e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(0, 0), new Point(this.scrollBarPanel.Width - 1, 0));
            e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(0, 0), new Point(0, this.scrollBarPanel.Size.Height - 1));
            if (!this.Nulldata)
            {
                int first = 0;
                while (first < this.MaxStartX)
                {
                    first += 216;
                    e.Graphics.DrawLine(new Pen(Color.FromArgb(232, 232, 232)), new Point(first, 6), new Point(first, this.scrollBarPanel.Size.Height - 16));
                }

            }
            else
            {
                e.Graphics.DrawString(Tiptext, this.Font, new SolidBrush(Color.Black), new Point((this.Size.Width - (int)this.Textsize.Width) / 2, (this.Size.Height - (int)this.Textsize.Height) / 2));
            }
        }

        void OnMedSrvRadioView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (Id_srvca == null) return;

            model = new medSrvRadioViewModel(this.Ent4BannerDTO.Code_entp,this.FgUse, Id_srvca);
            this.Buttonmodel = new AssButtonViewModel();
            this.medsrvSetmodel = new AssButtonViewModel();
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            this.MaxStartX = 0;
            this.scrollBarPanel.hScroll.Value = 0;
            this.scrollBarPanel.RemoveRenderAll();
            this.scrollBarPanel.getScrollBarRect();
            this.scrollBarPanel.Invalidate();
            if (this.model != null)
            {
                this.Nulldata = true;
                FMap2 data = this.model.medSrvDOMap;
                this.medSrvDodic.Clear();
                this.alphabetDict.Clear();
                List<string> alphabetList = new List<string>(data.Keys);
                if (alphabetList.Count > 0)
                {
                    // 将fmap2转成对应字典并将所有数据放在一个字典中
                    foreach (string alphaText in alphabetList)
                    {
                        //过滤数据保证只有最多27项可以填入字典
                        if (this.naviIndexView != null && this.naviIndexView.RenderDict != null && !this.naviIndexView.RenderDict.ContainsKey(alphaText))
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
                            if (dataList != null)
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
                    if (medSrvDodic.Count > 0)
                    {
                        this.Nulldata = false;
                    }
                }
                //设置字母区域的显示
                this.naviIndexView.SetEnabled(this.alphabetDict);
                this.naviIndexView.SelectedIndex = 0;
            }
        }

        private void FillData(AlphabetRender render)
        {
            render.IsSelected = true;
            render.Invalidate();
            string alphaText = render.Text;
            this.MaxStartX = 0;
            this.scrollBarPanel.hScroll.Value = 0;
            this.scrollBarPanel.RemoveRenderAll();
            this.scrollBarPanel.getScrollBarRect();
            this.scrollBarPanel.Invalidate();
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
                    orderTitleRender.Location = new Point(startX, startY);
                    startY += orderTitleRender.Size.Height;
                    if (this.MaxStartX <= startX)
                    {
                        this.MaxStartX = startX;
                    }
                    this.scrollBarPanel.AddRender(orderTitleRender);
                    for (int i = 0; i < data.Count; i++)
                    {
                        OrderRender ThreadRender = createOrderRender();
                        ThreadRender.Checkchanged += new OrderRender.CheckValuechanged(ThreadRender_Checkchanged);
                        ThreadRender.CancelChecked += new OrderRender.CheckValuechanged(ThreadRender_CancelChecked);
                        ThreadRender.ObjDo = data[i];
                        ThreadRender.Size = new Size(216, 24);
                        if (TMP != null && startY + ThreadRender.Size.Height > this.scrollBarPanel.Size.Height - 5)
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
                        this.scrollBarPanel.AddRender(ThreadRender);
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
                this.scrollBarPanel.getScrollBarRect();
                this.scrollBarPanel.Invalidate();
            }
        }

        protected virtual OrderRender createOrderRender()
        {
            OrderRender ThreadRender = new OrderRender(this, true);

            return ThreadRender;
        }


        public void close()
        {
            this.AssiViewFrame.Close();
        }

        public void Save()
        {
            string msg = "请选择服务后再点击确定按钮！";

            if (string.IsNullOrEmpty(this.Id_srv) || this.medSrvDodic == null || this.medSrvDodic.Count == 0)
            {
                BizAssMessageBoxUtil.ShowInforMsg(msg);
                return;
            }

            var list = new List<OrTplNItmDO>();
            if (this.medSrvDodic.ContainsKey(this.Id_srv))
            {
                MedSrvDO tempmedsrv = medSrvDodic[this.Id_srv];
                if (tempmedsrv.Fg_set.Value)
                {
                    MedSrvConvertSetItem(list, tempmedsrv);
                }
                else
                {
                    OrTplNItmDO rtplItem = convertOrTplNItmDO(tempmedsrv);
                    list.Add(rtplItem);
                }
            }
            else
            {
                BizAssMessageBoxUtil.ShowInforMsg(msg);
                return;
            }

            //OnFillData();
            //重新加载当前页的数据
            FillData(selectedAlphabetRender);
            //清空选中的数据
            this.Id_srv = string.Empty;

            // 设置医嘱来源属性，用于保存到ci_order中
            this.ciEnContext.Eu_orsrcmdtp = OrSourceFromEnum.IIHSRVCAHELPER;
            this.ciEnContext.Assistant_type = "medsrv";//医疗服务
            if (Buttonmodel != null)
            {
                var moreEmsDto = Buttonmodel.getMoreEmsParamDTO(this.ciEnContext, list.ToArray());
                if (null != moreEmsDto)
                    xapBaseControl.FireEventSent(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_TMPL_EDIT, EventCodeType.ARGKEY_EMS_TMPL_EDIT,
                         moreEmsDto));
            }           

        }

        private void MedSrvConvertSetItem(List<OrTplNItmDO> list, MedSrvDO medsrvDO)
        {
            MedSrvSetItemDO[] medsrvSetItem = this.medsrvSetmodel.getMedSrvSetItemDO(medsrvDO.Id_srv);
            if (medsrvSetItem != null)
            {
                foreach (MedSrvSetItemDO setItem in medsrvSetItem)
                {
                    OrTplNItmDO item = new OrTplNItmDO();
                    item.Id_srv = setItem.Id_srv_itm;
                    item.Ortplnitm_srv_name = setItem.Srv_name;
                    item.Id_ortmpl = setItem.Id_srv;
                    item.Id_boil = setItem.Id_boil;
                    item.Id_boildes = setItem.Id_boildes;
                    item.Quan_med = setItem.Quan_medu;
                    item.Id_freq = setItem.Id_freq;
                    //item.setId_mm(medSrv.getId_mm);
                    item.Id_ortmplitm = setItem.Id_srv_itm + setItem.Id_srv;
                    item.Id_route = setItem.Id_route;
                    item.Id_routedes = setItem.Id_routedes;
                    item.Id_srvtp = medsrvDO.Id_srvtp;
                    item.Sd_srvtp = medsrvDO.Sd_srvtp;
                    item.Id_unit_med = medsrvDO.Id_unit_med;
                    item.Ortplnitm_boildes_name = setItem.Boil_name;
                    item.Ortplnitm_freq_name = setItem.Freq_name;
                    item.Ortplnitm_route_name = setItem.Route_name;
                    item.Ortplnitm_routedes_name = setItem.Routedes_name;
                    item.Ortplnitm_unit_name = setItem.Medu_name;
                    item.Identical_ortmpl = setItem.Id_srv;
                    item.Fg_edit = setItem.Fg_edit;
                    item.Identical_ortmpl = medsrvDO.Id_srv;
                    if (medsrvDO.Fg_set.Value)
                    {
                        item.Id_srv_set = setItem.Id_srv;
                    }
                    list.Add(item);
                }
            }
        }

        /// <summary>
        /// MedSrvDO  convert to  OrTplNItmDO 
        /// </summary>
        /// <param name="medsrvDO"></param>
        /// <returns></returns>
        private OrTplNItmDO convertOrTplNItmDO(MedSrvDO medsrvDO)
        {
            OrTplNItmDO item = new OrTplNItmDO();
            item.Id_srv = medsrvDO.Id_srv;
            item.Ortplnitm_srv_name = medsrvDO.Name;
            item.Id_ortmpl = medsrvDO.Id_srv;
            item.Id_boil = medsrvDO.Id_boil;
            item.Id_boildes = medsrvDO.Id_boildes;
            item.Quan_med = medsrvDO.Quan_med;
            item.Id_freq = medsrvDO.Id_freq;
            //item.setId_mm(medSrv.getId_mm);
            item.Id_ortmplitm = medsrvDO.Id_srv;
            item.Id_route = medsrvDO.Id_route;
            item.Id_routedes = medsrvDO.Id_routedes;
            item.Id_srvtp = medsrvDO.Id_srvtp;
            item.Sd_srvtp = medsrvDO.Sd_srvtp;
            item.Id_unit_med = medsrvDO.Id_unit_med;
            item.Ortplnitm_boildes_name = medsrvDO.Boil_name;
            item.Ortplnitm_freq_name = medsrvDO.Freq_name;
            item.Ortplnitm_route_name = medsrvDO.Route_name;
            item.Ortplnitm_routedes_name = medsrvDO.Routedes_name;
            item.Ortplnitm_unit_name = medsrvDO.Med_name;
            item.Fg_edit = false;
            item.Identical_ortmpl = medsrvDO.Id_srv;
            if (medsrvDO.Fg_set.Value)
            {
                item.Id_srv_set = medsrvDO.Id_srv;
            }

            return item;
        }

        public override void SaveData()
        {
            Args = new OrScArgs();
            Args.listObj = new List<object>();
            Control control = this.Parent;
            // 向上寻找父窗体，并把数据主动的送出去。
            while (control != null)
            {
                if (control.Text == "分类选取")
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
            //(control as helperForm).Args = Args;
            if (((control.TopLevelControl as OpOrderTemplateForm)).view != null)
            {
                Args.Id_item = "medsrv";
                (control.TopLevelControl as OpOrderTemplateForm).view.Args = Args;
                // (control.TopLevelControl as OpOrderTemplateForm).DialogResult = DialogResult.OK;

                //(control.TopLevelControl as MedsrvClassForm).view.Args = Args;
                // (control.TopLevelControl as MedsrvClassForm).DialogResult = DialogResult.OK;
            }
            // (control as MedsrvClassForm).view.Args = Args;
            // (control as MedsrvClassForm).DialogResult = DialogResult.OK;
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

        protected virtual void ThreadRender_Checkchanged(OrderRender render, bool flag)
        {
            foreach (string Id_srv in this.OrderRenderlist.Keys)
            {
                if (OrderRenderlist[Id_srv] == render)
                {
                    OrderRenderlist[Id_srv].Check = flag;
                    //按钮做相应处理时，字母选中和title选中也作相应改变
                    if (OrderRenderlist[Id_srv].ObjDo is MedSrvDO)
                    {
                        string text = (OrderRenderlist[Id_srv].ObjDo as MedSrvDO).Pycode.Substring(0, 1);
                        if (this.naviIndexView.AlphabetRenderDict != null)
                        {
                            foreach (string alphabetText in this.naviIndexView.AlphabetRenderDict.Keys)
                            {
                                if (alphabetText == text)
                                {
                                    this.naviIndexView.AlphabetRenderDict[alphabetText].IsSelected = true;
                                }
                                else
                                {
                                    this.naviIndexView.AlphabetRenderDict[alphabetText].IsSelected = false;
                                }
                            }
                            this.naviIndexView.Invalidate();
                        }
                        this.scrollBarPanel.Invalidate();
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

        /// <summary>
        /// 单选按钮取消选中事件
        /// </summary>
        /// <param name="render"></param>
        /// <param name="flag"></param>
        protected void ThreadRender_CancelChecked(OrderRender render, bool flag)
        {
            this.Id_srv = string.Empty;
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
                case UIEvent.TAB_SELECTED:
                    this.OnFillData();
                    break;
                default:
                    break;
            }
        }

        #endregion

    }
}
