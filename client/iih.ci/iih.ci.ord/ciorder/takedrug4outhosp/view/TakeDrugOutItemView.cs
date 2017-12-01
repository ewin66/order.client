using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.ci.ord.ciorder.cards;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.opemergency.view.printmanage;
using iih.en.pv.dto.d;
using iih.en.pv.pativisit.d;
using iih.hp.cp.docinfodto.d;
using xap.cli.sdk.controls.calendar;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.controls.navbar;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.cli.sdk.render.DoctorOrderCard;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.mw.core.data;
using xap.rui.appfw;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.workstation;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.cli.sdk.controls;
using xap.cli.sdk.common;
using xap.cli.sdk.controls.DataView.Extension;
using iih.ci.ord.cilab.view;
using xap.rui.bizcontrol.ClinicalTimeline.reportTypeInfo;
using iih.ci.ord.ciorder.orreport;
using xap.cli.sdk.controls.DataView.Extension.XOrderResult;
using xap.sys.xbd.udi.d;
using iih.ci.ord.ciobs.view;
using iih.ci.ord.diagtreatview.viewmodel.bp;
using xap.rui.bizcontrol.ClinicalTimeline.enums;
using iih.ci.ord.pathgyreportform.view;
using xap.cli.sdk.controls.DataView.Renders;
using iih.ci.ord.ems.d;
using iih.ci.ord.common.utils;
using iih.bd.srv.ems.d;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.ortpl.d;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.opemergency.viewmodel;
using iih.ci.ord.takedrug4outhosp.viewmodel;
using iih.ci.ord.opemergency.spltpres;
using xap.rui.bizcontrol.BillFormTmplConst;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 出院带药医嘱列表


*********************************************************************************/

namespace iih.ci.ord.ciorder.takedrug4outhosp.view
{

    /// <summary>
    /// 医嘱的主列表视图
    /// zhou_zhijian 7.2做阅读注释
    /// zhou_zhijian lizheng 7.6结队重构代码结构
    /// </summary>
    public partial class TakeDrugOutItemView : CiorderBaseControl, IWorkStationRegist
    {

        #region 变量定义区域
        /// <summary>
        /// 医嘱助手的 model
        /// </summary>
        public AssButtonViewModel assModel;

        /// <summary>
        /// 患者信息DTO
        /// </summary>
        public Ent4BannerDTO ent4BannerDto;
        /// <summary>
        /// 过滤数据,用于填充表格的数据结构,过滤条件的变化直接改变的就是本数据结构对象
        /// </summary>
        private XapDataList<CiOrderDO> fillModelDataList;
        /// <summary>
        /// 医嘱的搜索的条件集合，用这个条件过滤医嘱列表
        /// </summary>
        private readonly Dictionary<string, object> searchParamMap = new Dictionary<string, object>();
        /// <summary>
        /// 开始时间的字符串
        /// </summary>
        private string startTime;
        /// <summary>
        /// 结束时间的字符串
        /// </summary>
        private string endTime;
        /// <summary>
        /// 活动医嘱是否选中的一个控制变量
        /// </summary>
        private bool isChang;
        /// <summary>
        /// 医嘱集合
        /// </summary>
        private List<CiOrderDO> curOrdList;

        /// <summary>
        /// 编辑状态
        /// </summary>
        private bool viewEditState;
        /// <summary>
        /// 医嘱表格控件
        /// </summary>
        private XapFormGridControl gv;
        /// <summary>
        /// 停止时间对话框中显示的“时间控件”
        /// </summary>
        private CalendarDateConverter convert;

        /// <summary>
        /// 右边收起控件
        /// </summary>
        private TabNavigatorControl control;
        /// <summary>
        /// form 控件
        /// </summary>
        private ContextMenuForm calendarForm;
        /// <summary>
        /// 医嘱处方面板容器，包括“确认”、“取消”按钮
        /// </summary>
        private TakeDrugOutCardView orderCardView;
        /// <summary>
        /// 医嘱分方面板视图，在住院医嘱中已经没有了？
        /// </summary>
        private XapBaseControl orderPresView;
        /// <summary>
        /// 医嘱单多页Page
        /// </summary>
        private XTabPage tabPage1;

        /// <summary>
        /// 本视图对应的模型
        /// </summary>
        private TakeDrugOutItemViewModel viewModel;
        /// <summary>
        /// 查询住院患者余额
        /// </summary>
        private IpOverViewModel IpModel;
        /// <summary>
        /// 表单模板输入文件
        /// </summary>
        private FormFile file = new FormFile();

        #endregion

        #region 构造函数区域

        public TakeDrugOutItemView()
        {
            InitializeComponent();

            //事件注册
            this.Load += OrderItemView_Load;
            //this.xapFormControl1.Dock = DockStyle.Fill;
            xapFormControl1.FormCreated += xapFormControl1_FormCreated;
            xapFormControl1.ModelFilled += xapFormControl1_ModelFilled;
            //xapFormControl1.OnDataChanged += xapFormControl1_DataChanged;

            this.FormCreated += OrderItemView_FormCreated;

            //弹出的医疗单控件
            //control = new TabNavigatorControl {Size = new Size(32, 200)};
            //control = (TabNavigatorControl)Context.Config.GetInstance("NavControl");
            //control.BodyText = "医疗单";
            //control.NavFormWith = 700;
            //AddRender(control);

            Dock = DockStyle.Fill;
            OrdParam.GetOrdParam.isHos = true;
            ordSelectedContainer = new OrdSelectedContainer();
        }

        /// <summary>
        /// 获取OrderCardView控件对象
        /// </summary>
        /// <returns></returns>
        private Control GetCardControl()
        {
            orderCardView = (TakeDrugOutCardView)Context.Config.GetInstance("takeDrugOutCardView");
            orderCardView.viewEditState = viewEditState;
            return orderCardView;
        }

        ///// <summary>
        ///// 创建处方业务视图对象
        ///// </summary>
        ///// <returns></returns>
        //protected XapBaseControl createOrderPresControl()
        //{
        //    var spview = (SpltPrescriptionView)this.Context.Config.GetInstance("SpltPrescriptionView");
        //    spview.Dock = DockStyle.Fill;
        //    return spview;

        //}
        /// <summary>
        /// 获取OrderPresView控件对象
        /// </summary>
        /// <returns></returns>
        private XapBaseControl createOrderPresControl()
        {
            orderPresView = (TakeDrugOutPresView)Context.Config.GetInstance("takeDrugOutPresView");
            orderPresView.Dock = DockStyle.Fill;
            return orderPresView;
        }
        #endregion

        #region 公共方法
        /// <summary>
        /// 设置医疗单的Tab页的名字，如草药医疗单
        /// </summary>
        /// <param name="strSheetName"></param>
        public void SetTabText(string strSheetName)
        {
            tabPage1.Text = strSheetName;
        }
        #endregion

        #region 私有函数
        /// <summary>
        /// 多医疗单的处理
        /// </summary>
        /// <param name="objs">数据集合，type 是类型 1 服务，2 模板，3 cp ，4 其它</param>
        /// <param name="type"></param>
        private void ManyRecordSrv(List<Object> objs, String type)
        {
            if (tabPage1 == null)
            {
                tabPage1 = new XTabPage { Text = "医疗单", PageControl = GetCardControl() };
                if (control == null)
                {
                    createNavControl();
                }
                control.NavTabControl.XTabPages.Add(tabPage1); //右缩面板多页添加
            }

            if (objs != null && objs.Count > 7)
            {
                this.ShowInfo("选中的医嘱最大于6个，暂时不支持");
                objs.Clear();
                return;
            }
            //control.TabNavigationForm.Capture = true;
            orderCardView.SetOrderItemView(this);
            //将智能Form的数据由helperView传到悬浮窗
            if (orderCardView.ManyRecordSheet(objs, ent4BannerDto, control))
            {
                if (this.Created)
                {
                    control.CanShowForm = true;
                }
            }
            else
            {
                orderCardView.orCom_deleteevent(null, null);
            }
        }

        private void OrderItemView_SizeChanged()
        {
            gv.Dock = DockStyle.None;
            gv.Parent.BackColor = Color.Red;
            gv.Parent.Parent.BackColor = Color.Pink;
            gv.Parent.Size = new Size(Size.Width, 800);
        }
        #endregion

        #region 父类覆写区域

        /// <summary>
        ///  取数线程中执行，获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {

            if (ent4BannerDto == null)
            {
                if (this.Context["PatientData"] == null)
                {
                    return;
                }
                else
                {
                    ent4BannerDto = (this.Context["PatientData"] as BannerData).Ent4BannerDTO;
                }
            }

            if (viewModel == null)
            {
                viewModel = new TakeDrugOutItemViewModel(ent4BannerDto.Id_ent, ent4BannerDto, this.Context);
            }
            JudgePatientBalance();
            viewModel.Reload(ent4BannerDto.Id_ent, ent4BannerDto.Code_entp);
            //根据现有的查询条件进行过滤
            fillModelDataList = new XapDataList<CiOrderDO>();
            cof.filterOrderItemBySearch(viewModel.xapList, fillModelDataList, searchParamMap);

            this.assModel = new AssButtonViewModel();
        }

        /// <summary>
        /// UI线程中执行，OnLoadData执行完毕后，填充界面
        /// </summary>
        protected override void OnFillData()
        {
            //填充数据
            if (viewModel != null)
            {
                file.ViewModel = fillModelDataList;
            }
            xapFormControl1.ViewFile = file;

            //LoadHandler();
        }

        private void OrderItemView_FormCreated(object sender, EventArgs e)
        {
            LoadHandler();
        }
        void tabControl_SelectedIndexChanged(object sender, EventArgs e)
        {
            //throw new NotImplementedException();
            XTabPage xtab = sender as XTabPage;
            if (xtab.Text.Equals("分方")) {
                //(orderPresView as SpltPrescriptionView).SetEntID(this.ent4BannerDto.Id_ent);
                orderPresView.LoadData();
            } 
        }
        /// <summary>
        /// 应该是患者导航选择后的处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (e.Object is PatiVisitDO)
            {
                var VisitDO = ((PatiVisitDO)e.Object);
                ent4BannerDto.Id_ent = VisitDO.Id_ent;
                ent4BannerDto.Id_pat = VisitDO.Id_pat;
            }
            else if (e.Object is PatiVisitDO)
            {
                ent4BannerDto = ((Ent4BannerDTO)e.Object);
            }
        }

        /// <summary>
        /// 上下文环境中的科室发生了改变后的处理
        /// </summary>
        public override void OnDeptChanged()
        {
            ent4BannerDto.Id_ent = "";
            LoadData();
        }

        #endregion

        #region 内部事件区域

        //住院有无诊断 暂时不考虑
        public override void OnActiveForm()
        {
            return;
            /*
            if (viewModel == null)
            {
                viewModel = new TakeDrugOutItemViewModel(ent4BannerDto.Id_ent, ent4BannerDto, this.Context);
            }
            if (viewModel != null && viewModel.getEntDiDOS(this.ent4BannerDto.Id_ent))
            {
                this.ShowInfo("患者没有签署的诊断，请先下诊断");
                if (SwitchFuncPage != null)
                {
                    DictionaryEventArgs args = new DictionaryEventArgs();
                    args.Data["FuncCode"] = "46106020";
                    args.Data["index"] = "";
                    SwitchFuncPage(this, args);
                }
                return;
            }
            */
        }

        [EventPublication(WEventTopics.NAVI)]
        public event EventHandler<DictionaryEventArgs> SwitchFuncPage;
        private void FireSwitchFuncPage()
        {
            if (SwitchFuncPage != null)
            {
                SwitchFuncPage(this, null);
            }
        }

        private void OrderItemView_Load(object sender, EventArgs e)
        {
            this.file.FormId = CiOrdBillFormTmplConst.CIORD_IP_TakeDrugOutItemView;// "20151022075428682WGO";
            this.file.FormStyle = FormStyle.Card;

            //真正UI开始
            OnInit();

            this.xapFormControl1.Context = this.Context;
            this.xapFormControl1.LstUserRenders = this.LstUserRenders;
        }

        /// <summary>
        /// 表单模板的FormCreated事件处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            //弹出的医疗单控件
            if (control == null)
            {
                createNavControl();
            }

            gv = xapFormControl1.GetGridView("order");
            foreach (XDataColumn item in gv.DataTable.Columns)
            {
                item.AlignCell = StringAlignment.Center;
            }
            gv.ReadOnly = true;
            gv.MouseDoubleClick += gv_MouseDoubleClick;
            gv.MouseClick += gv_MouseClick;
            gv.DataTable.CustomerCellMouseClick += new EventHandler(OnXapFromGrid_CellClick);
            gv.DataTable.DataDisplay += tabControl_DataDisplay;
            gv.DataTable.MultiCheckChanged += new EventHandler<MutilCheckedEventArgs>(mutilCheckedEventArgs);
            gv.DataTable.SelectedAllChanged += new EventHandler(SelectedAllChanged);
            gv.DataTable.Rows.DefaultHeight = 30;
            gv.DataTable.CrossBackColor = true;

            //gv.DataTable.MultiCheckChanged += new EventHandler<MutilCheckedEventArgs>(tableGrid_CheckedEvent);
            xapFormControl1.SetTopPanelHeight(50);
            xapFormControl1.SetTabPageEnabled("button", true); //作用让页签内可用


            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;

            XTabControl tabControl = tabs[0].tabContrl;
            XTabPage xtab = tabControl.XTabPages[1];
            this.orderPresView = this.createOrderPresControl();
            xtab.Controls.Add(orderPresView);
            tabControl.SelectedIndexChanged += new XTabControl.selectedIndexChanged(tabControl_SelectedIndexChanged);
            xapFormControl1.ShowTabPage("feelist", false); //隐藏

            //control.CanShowForm = true;
            if (gv.DataTable.Columns["customercolumn_check_result"] != null)
            {
                UdidocDO[] udidocs = OrReportPictureButton.GetInstance().getMap()[EnDictCodeConst.SD_ENTP_INPATIENT];
                if (udidocs == null)
                {
                    udidocs = new UdidocDO[0];
                }
                int ccWidth = (udidocs.Length * 30 <= 120 ? 120 : udidocs.Length * 30);
                gv.DataTable.Columns["customercolumn_check_result"].Width = ccWidth;
                gv.DataTable.Columns["customercolumn_check_result"].DefalutWidth = ccWidth;
            }
        }
        /// <summary>
        /// 创建右侧滑动区域的控件
        /// </summary>
        void createNavControl()
        {
            control = Context.Config.GetInstance("NavControl") as TabNavigatorControl;
            control.BodyText = "医疗单";
            control.Size = new Size(32, 200);
            control.NavFormWith = xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 700 : 650;
            AddRender(control);
        }
        void mutilCheckedEventArgs(object sender, MutilCheckedEventArgs e)
        {
            XMultiSelectCheckBox checkbox = sender as XMultiSelectCheckBox;
            if (checkbox == null || checkbox.Row == null) return;
            CiOrderDO datasource = checkbox.Row.DataSource as CiOrderDO;
            if (e.Checked)
            {
                ordSelectedContainer.add(datasource.Id_or);
            }
            else
            {
                ordSelectedContainer.remove(datasource.Id_or);
            }
        }
        void SelectedAllChanged(object sender, EventArgs e)
        {
            if (sender is XDataTable && (sender as XDataTable).Rows.Count > 0)
            {
                foreach (XDataRow row in (sender as XDataTable).Rows)
                {
                    CiOrderDO datasource = row.DataSource as CiOrderDO;
                    if (row.Selected)
                    {
                        ordSelectedContainer.add(datasource.Id_or);
                    }
                    else
                    {
                        ordSelectedContainer.remove(datasource.Id_or);
                    }
                }
            }
        }
        private void Parent_SizeChanged(object sender, EventArgs e)
        {
            gv.Parent.Parent.Parent.Parent.Size = Size;
        }

        /// <summary>
        /// 医嘱表格控件的鼠标单击事件处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void gv_MouseClick(object sender, MouseEventArgs e)
        {
            var row = sender as XDataRow;
            if (row != null)
            {
                row.Selected = !row.Selected;
                CiOrderDO ciOrderDO = row.DataSource as CiOrderDO;
                if (row.Selected)
                {
                    this.ordSelectedContainer.add(ciOrderDO.Id_or);
                }
                else
                {
                    this.ordSelectedContainer.remove(ciOrderDO.Id_or);
                }
            }
        }

        /// <summary>
        /// 医嘱表格模型填充后的事件处理，进一步界面状态
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            if (ent4BannerDto == null)
            {
                return;
            }

            //根据人员的状态，来处理页面的编辑状态
            viewEditState = cof.viewEditState8EntSd(ent4BannerDto.Entpattp);
            if (!viewEditState)
            {
                //设置助手按钮的编辑状态
                var OrderSevricebutton = (XImageTextButton)Context.Config.GetInstance("Button");
                OrderSevricebutton.Enabled = false;
                //设置声音按钮的编辑状态
                //var voiceButton = (XImageTextButton)Context.Config.GetInstance("VoiceButton");
                //voiceButton.Enabled = false;

                ////设置打印按钮的编辑状态
                //var printButton = (XImageTextButton)Context.Config.GetInstance("PrintButton");
                //voiceButton.Enabled = false;



                //设置查询框的编辑状态
                var scv = Context.Config.GetInstance("SearchText") as TakeDrugOurtSearchControlView;
                scv.Enabled = false;
                //发送事件控制列表上图片按钮的状态
                var dict = new Dictionary<string, string>();
                dict.Add("viewState", "IsReadOnly");
                var de = new DictionaryEventArgs();
                de.Data.Add(UIConst.UI_EVENT, "IsReadOnly");
                de.Data.Add(UIConst.DATA, dict);
                FireEventSent(this, de);
            }
            else
            {
                int count = gv.DataTable.Rows.Count;
                if (count == 0)
                {
                    var de = new DictionaryEventArgs();
                    de.Data.Add(UIConst.UI_EVENT, "NoData");
                    FireEventSent(this, de);
                }
            }

            //设置当前有哪些医嘱处于选中状态
            ordSelectedContainer.setSelected(gv, keyName);


            string orderstring = viewModel.getOrderSequenceModel();
            if (orderstring != null && orderstring.Equals("ASC"))
            {
                //设定医嘱的列表滚动到最后一行
                gv.VScroll.Value = gv.VScroll.MaxValue;
            }
        }

        /// <summary>
        /// 结束时间值改变之后的事件处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void endDateTiem_ValueTextChanged(object sender, EventArgs e)
        {
            var time = sender as XCalendarComboBox;
            if (string.IsNullOrEmpty(time.ValueText))
            {
                endTime = null;
            }
            else
            {
                endTime = time.ValueText + " 00:00";
            }

            ordSelectedContainer.getSelectedRow(gv, keyName, false);

            List<CiOrderDO> ordList = viewModel.xapList.ToList();


            var med = new BindingList<CiOrderDO>();
            try
            {
                ordList.ForEach(p =>
                {
                    if (!string.IsNullOrEmpty(endTime))
                    {
                        if (!string.IsNullOrEmpty(startTime))
                        {
                            if (DateTime.Parse(startTime) <= p.Dt_effe && p.Dt_effe <= DateTime.Parse(endTime))
                            {
                                med.Add(p);
                            }
                        }
                        else
                        {
                            if (p.Dt_effe <= DateTime.Parse(endTime))
                            {
                                med.Add(p);
                            }
                        }

                    }
                    else
                    {
                        if (string.IsNullOrEmpty(startTime))
                        {
                            med.Add(p);
                        }
                        else
                        {
                            if (p.Dt_effe >= DateTime.Parse(startTime))
                            {
                                med.Add(p);
                            }
                        }
                    }
                });
            }
            catch //(Exception ex)
            {
                this.ShowInfo("日期格式不正确", "提示");
            }

            gv.DataTable.DataSource = med; //重新设置数据源
            ordSelectedContainer.setSelected(gv, keyName); //重新设置哪些医嘱被选中了

        }

        /// <summary>
        /// 开始时间值改变之后的事件处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void startDateTiem_ValueTextChanged(object sender, EventArgs e)
        {
            var time = sender as XCalendarComboBox;
            if (string.IsNullOrEmpty(time.ValueText))
            {
                startTime = null;
            }
            else
            {
                startTime = time.ValueText + " 00:00";
            }


            ordSelectedContainer.getSelectedRow(gv, keyName, false);

            List<CiOrderDO> ordList = viewModel.xapList.ToList();


            var med = new BindingList<CiOrderDO>();
            try
            {
                ordList.ForEach(p =>
                {
                    if (!string.IsNullOrEmpty(endTime))
                    {
                        if (!string.IsNullOrEmpty(startTime))
                        {
                            if (DateTime.Parse(startTime) <= p.Dt_effe && p.Dt_effe <= DateTime.Parse(endTime))
                            {
                                med.Add(p);
                            }
                        }
                        else
                        {
                            if (p.Dt_effe <= DateTime.Parse(endTime))
                            {
                                med.Add(p);
                            }
                        }

                    }
                    else
                    {
                        if (string.IsNullOrEmpty(startTime))
                        {
                            med.Add(p);
                        }
                        else
                        {
                            if (p.Dt_effe >= DateTime.Parse(startTime))
                            {
                                med.Add(p);
                            }
                        }
                    }
                });
            }
            catch //(Exception ex)
            {
                this.ShowInfo("日期格式不正确 \n 正确的日期格式  yyyy-MM-dd", "提示");
            }

            gv.DataTable.DataSource = med;
            ordSelectedContainer.setSelected(gv, keyName);

        }

        /// <summary>
        /// 表格的选择复选框改变的事件处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tableGrid_CheckedEvent(object sender, MutilCheckedEventArgs e)
        {
            int index = e.RowIndex;
            var id_or = gv.DataTable.Rows[index].RowDataSource.GetPropValue(keyName) as string;
            if (e.Checked)
            {
                ordSelectedContainer.add(id_or);
            }
            else
            {
                ordSelectedContainer.remove(id_or);
            }
        }

        /// <summary>
        /// 医嘱表格数据显示时的处理事件，这里主要用于处理医嘱显示内容
        /// todo:zzj建议，实现的有问题，所有的医嘱控件对配置文件只要解析一次就可以，没必要每个都去解析
        /// 应该采用享元模式来提高性能！
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tabControl_DataDisplay(Object sender, XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            if (row != null)
            {
                foreach (UserRender render in row.UserRenderList)
                {
                    if (render is DoctorOrderCard)
                    {
                        var card = render as DoctorOrderCard;
                        card.ConfigPath = "\\modules\\iihci\\ui\\commoncontent\\OrderContent.xml";
                    }
                }
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_check_result"))
            {
                CiOrderDO ciorderdo = row.RowDataSource as CiOrderDO;
                List<XOrderResultData> resultList = OrReportPictureButton.GetInstance().buildOrderResultData(ciorderdo);
                (row.ColumnCellDict["customercolumn_check_result"] as XCellRender).Value = resultList;
            }
        }
        /// <summary>
        /// 单元格点击事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnXapFromGrid_CellClick(object sender, EventArgs e)
        {
            CiOrderDO ciOrderDO = (sender as XOrderResultCell).DataSource as CiOrderDO;
            if (string.IsNullOrEmpty(((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Value) || ((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Value.Equals("0"))
            {
                return;
            }
            int type = Convert.ToInt32(((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Type);
            if ((ciOrderDO.Sd_srvtp.Substring(0, 2).Equals("02") || ciOrderDO.Sd_srvtp.Substring(0, 2).Equals("03")) && 3 == type)
            {
                string dia = "";
                string title = "";
                CliTestView TestView = new CliTestView();
                TestView.TrendChartEvent += new CliTestView.TrendChartButtonClick(test);
                if (ciOrderDO.Sd_srvtp.Substring(0, 2).Equals("02"))
                {
                    if (ciOrderDO.Sd_srvtp.Substring(2, 2).Equals("07"))
                    {
                        OpRptpathgyView rptpahyview = new OpRptpathgyView(ciOrderDO.Id_or);
                        rptpahyview.ShowDialog();
                    }
                    else
                    {
                        dia = "ris";
                        title = "检查报告";
                        var lab = new CIRptObsView();
                        lab.setlabdto(ciOrderDO.Id_or, dia);
                        TestView.Size = new Size(850, 740);
                        TestView.ShowReportButton.Text = "影像";
                        TestView.DataView = lab;
                        TestView.Text = title;
                        TestView.cliTestControl.AddRender(TestView.DataView);
                        TestView.ShowDialog();
                    }
                }
                else if (ciOrderDO.Sd_srvtp.Substring(0, 2).Equals("03"))
                {
                    dia = "lis";
                    title = "检验报告";
                    var lab = new CiRptLabView();
                    lab.setlabdto(ciOrderDO.Id_or, dia, TestView);
                    TestView.DataView = lab;
                    TestView.Size = new Size(940, 750);
                    TestView.ShowReportButton.Text = "趋势图";
                    TestView.Text = title;
                    TestView.cliTestControl.AddRender(TestView.DataView);
                    TestView.ShowDialog();
                }
            }
            else
            {
                OrReport orReport = new OrReport(sender as XOrderResultCell, ciOrderDO, type);
                orReport.ShowDialog();
            }
        }
        void test(XForm xForm)
        {
            if ((xForm is CliTestView) && ((xForm as CliTestView).DataView is CiRptLabView) && (xForm as CliTestView).ReportStatus == ClinicalExeEventStatus.LIS)
            {
                DiagtreatUtils.showTrendView((xForm as CliTestView), ent4BannerDto);
            }
        }
        /// <summary>
        /// “活动医嘱，长期临时”控件的值改变时的事件处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OrderItemView_ValueChanged(object sender, EventArgs e)
        {
            if (sender == null)
            {
                return;
            }

            if (isChang)
            {
                isChang = false;
                return;
            }

            ordSelectedContainer.getSelectedRow(gv, keyName, false);
            List<CiOrderDO> obj = viewModel.xapList.ToList();
            //startDateTiem.ValueText = "";
            //endDateTiem.ValueText = "";

            var med = new BindingList<CiOrderDO>();
            try
            {
                obj.ForEach(p =>
                {
                    if (!string.IsNullOrEmpty(endTime))
                    {
                        if (!string.IsNullOrEmpty(startTime))
                        {
                            if (DateTime.Parse(startTime) <= p.Dt_effe && p.Dt_effe <= DateTime.Parse(endTime))
                            {
                                med.Add(p);
                            }
                        }
                        else
                        {
                            if (p.Dt_effe <= DateTime.Parse(endTime))
                            {
                                med.Add(p);
                            }
                        }

                    }
                    else
                    {
                        if (string.IsNullOrEmpty(startTime))
                        {
                            med.Add(p);
                        }
                        else
                        {
                            if (p.Dt_effe >= DateTime.Parse(startTime))
                            {
                                med.Add(p);
                            }
                        }
                    }
                });
            }
            catch// (Exception ex)
            {
                this.ShowInfo("日期格式不正确 \n 正确的日期格式  yyyy-MM-dd", "提示");
            }
            gv.DataTable.DataSource = med;
            ordSelectedContainer.setSelected(gv, keyName);
        }

        /// <summary>
        /// 表格双击事件处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void gv_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            var row = sender as XDataRow;
            if (row != null && !row.Selected)
            {
                row.Selected = true;
            }

            var ci = xapFormControl1.GetFocused<CiOrderDO>("order");
            FireSelected(ci);
        }

        #endregion

        #region 医嘱操作及校验
        //todo:针对loadData,要考虑后台刷新的性能损失和用户实际需要之间的平衡

        /// <summary>
        /// 签署医嘱
        /// </summary>
        private void SignOrd()
        {
            CiOrderDO[] orders = xapFormControl1.GetSelected<CiOrderDO>();
            var orderlist = new List<CiOrderDO>();
            foreach (CiOrderDO ord in orders)
            {
                if (ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false)
                    orderlist.Add(ord);
            }
            if (orderlist.Count > 0)
            {
                if (orderlist.Count == orders.Length)
                {
                    viewModel.SignCiOrder(orderlist.ToArray(), ent4BannerDto);
                    HandlerAfterCancel();
                    LoadData();
                    this.SetStatusMsg("医嘱签署成功！");
                }
                else
                {
                    if (this.IsContinue("提示", "未签署的医嘱才可【签署】！\r\n是否继续操作？"))
                    {
                        viewModel.SignCiOrder(orderlist.ToArray(), ent4BannerDto);
                        HandlerAfterCancel();
                        LoadData();
                        this.SetStatusMsg("医嘱签署成功！");
                    }
                }
            }
            else
            {
                if (this.IsContinue("提示", "没有符合操作的数据！是否刷新列表?"))
                {
                    LoadData();
                }
            }
        }

        /// <summary>
        /// 作废医嘱
        /// </summary>
        private void CancelOrd()
        {
            CiOrderDO[] orders = xapFormControl1.GetSelected<CiOrderDO>();
            var orderlist = new List<CiOrderDO>();
            foreach (CiOrderDO ord in orders)
            {
                if (IsOrdCancel(ord))
                {
                    orderlist.Add(ord);
                }
            }

            if (orderlist.Count > 0)
            {
                if (orderlist.Count == orders.Length)
                {
                    if (this.IsContinue("提示", "确实要作废该医嘱吗?"))
                    {
                        viewModel.OnUpdateSu(orderlist.ToArray(), CiDictCodeConst.SD_SU_DOCTORCANCEL,
                          CiDictCodeConst.SD_SU_ID_DOCTORCANCEL);
                        HandlerAfterCancel();
                        LoadData();
                    }
                }
                else
                {
                    if (this.IsContinue("提示", "护士已核对且未执行的有效医嘱才可【作废】！是否继续操作？"))
                    {
                        viewModel.OnUpdateSu(orderlist.ToArray(), CiDictCodeConst.SD_SU_DOCTORCANCEL,
                            CiDictCodeConst.SD_SU_ID_DOCTORCANCEL);
                        HandlerAfterCancel();
                        LoadData();
                    }
                }
            }
            else
            {
                if (this.IsContinue("提示", "没有符合操作的数据！是否刷新列表?"))
                {
                    LoadData();
                }
            }
        }

        /// <summary>
        /// 判断指定的医嘱是否是作废状态
        /// </summary>
        /// <param name="ord">医嘱对象</param>
        /// <returns></returns>
        private bool IsOrdCancel(CiOrderDO ord)
        {
            //if (ord.Sd_su_or == CiDictCodeConst.SD_SU_CHECKTHROUGH && ord.Fg_chk == true
            //    && ord.Fg_stop == false && ord.Fg_canc == false && ord.Sd_su_mp=="0")
            //    orderlist.Add(ord);

            bool r = /*ord.Sd_su_or == CiDictCodeConst.SD_SU_CHECKTHROUGH &&*/ ord.Fg_chk == true
                   && ord.Fg_canc == false && ord.Fg_uncancelable == false;

            return r;
        }

        /// <summary>
        /// 撤销医嘱
        /// 
        /// 业务场景描述：
        /// 从数据库中取出最新的医嘱值，进行校验是否能撤回；因为两个客户端，A签署医嘱，B护士确认医嘱，
        //  A点击“撤回”，异常：仍可撤回
        /// </summary>
        private void BackOrd()
        {
            //1.取出所有UI选中的医嘱的ID值集合
            CiOrderDO[] orders = xapFormControl1.GetSelected<CiOrderDO>();
            var ids = new string[orders.Length];
            for (int i = 0; i < orders.Length; i++)
            {
                ids[i] = orders[i].Id_or;
            }

            //2.找到可以撤销的医嘱集合
            var backOrdList = new List<CiOrderDO>();
            //当前选中的医嘱对应的后台最新的医嘱数据集合
            CiOrderDO[] canBackOrd = viewModel.getCiOrderDOArray(ids);
            foreach (CiOrderDO ord in orders)
            {
                CiOrderDO ciOrderBack = canBackOrd.FirstOrDefault(ciorder => ciorder.Id_or == ord.Id_or);
                if (ciOrderBack.Sd_su_or == CiDictCodeConst.SD_SU_SIGN && ciOrderBack.Fg_sign == true &&
                    ciOrderBack.Fg_chk == false && ciOrderBack.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE)
                    backOrdList.Add(ord);
            }

            //3.如果没有可撤销的
            if (backOrdList.Count == 0)
            {
                if (this.IsContinue("提示", "没有符合操作的数据！是否刷新列表?"))
                {
                    LoadData();
                }
                return;
            }

            //4.护士已经有确认过的，需要提示一下用户是否继续撤销那些还没有确认过的医嘱
            if (backOrdList.Count != orders.Length)
            {
                if (!this.IsContinue("提示", "已签署，同时护士未核对的医嘱才可【撤回】！是否继续操作？"))
                {
                    return;
                }
            }

            //5.开始撤销
            viewModel.OnUpdateSu(backOrdList.ToArray(), CiDictCodeConst.SD_SU_OPEN, CiDictCodeConst.SD_SU_ID_OPEN);
            HandlerAfterCancel();
            LoadData();
            this.SetStatusMsg("撤回成功！");
        }

        /// <summary>
        /// 删除医嘱
        /// </summary>
        private void DelOrd()
        {
            CiOrderDO[] orders = xapFormControl1.GetSelected<CiOrderDO>(); //获取选中医嘱
            var delOrdList = new List<CiOrderDO>();
            foreach (CiOrderDO ord in orders)
            {
                if (ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false)
                {
                    delOrdList.Add(ord);
                }
            }

            if (delOrdList.Count <= 0)
            {
                if (this.IsContinue("提示", "没有符合操作的数据！是否刷新列表?"))
                {
                    LoadData();
                }
                return;
            }

            if (delOrdList.Count != orders.Length)
            {
                if (!this.IsContinue("提示", "未签署的医嘱才可【删除】！是否继续操作？"))
                {
                    return;
                }
            }

            //提示是否删除
            if (!this.IsDelete())
            {
                return;
            }

            //删除操作
            viewModel.DelOrd(xapFormControl1.GetSelected<CiOrderDO>());
            HandlerAfterCancel();
            LoadData();
            this.SetStatusMsg("删除成功！");
            this.HandlerAfterCancel();
        }

        /// <summary>
        /// 停止医嘱
        /// </summary>
        private void StopOrd()
        {
            //获取可以停止的医嘱对象集合
            CiOrderDO[] orders = xapFormControl1.GetSelected<CiOrderDO>();
            var stopOrdList = new List<CiOrderDO>();
            foreach (CiOrderDO ord in orders)
            {
                if (IsStopOrd(ord))
                {
                    stopOrdList.Add(ord);
                }
            }

            if (stopOrdList.Count <= 0)
            {
                if (this.IsContinue("提示", "没有符合操作的数据！是否刷新列表?"))
                {
                    LoadData();
                }
                return;
            }

            if (stopOrdList.Count != orders.Length)
            {
                if (!this.IsContinue("提示", "护士已核对的有效长期医嘱才可【停止】！是否继续操作？"))
                {
                    return;
                }
            }

            curOrdList = stopOrdList;
            StopTimeDiag();
        }

        /// <summary>
        /// 医嘱另存为模板
        /// </summary>
        private void SaveAsOrd()
        {
            CiOrderDO[] orders = xapFormControl1.GetSelected<CiOrderDO>();
            if (orders != null && orders.Length > 0)
            {
                List<string> lstIDs = new List<string>();
                orders.ToList<CiOrderDO>().ForEach(p => { lstIDs.Add(p.Id_or); });
                DictionaryEventArgs args = new DictionaryEventArgs();
                args.Data.Add(UIConst.UI_EVENT, "SaveAsOrdEvent");
                this.FireEventSent(lstIDs.ToArray(), args);
            }
            else
            {
                this.ShowInfo("请先选择您所要操作的医嘱！");
            }
        }

        private void copyAdd()
        {
            CiOrderDO[] orders = xapFormControl1.GetSelected<CiOrderDO>();

            if (orders == null || orders.Length == 0) return;
            string[] id_ors = orders.Select(p => p.Id_or).ToArray();
            CiEnContextDTO ciEnContext = CiEnContextUtil.GetCiEnContext(this.ent4BannerDto, EmsAppModeEnum.IVEMSAPPMODE, OrSourceFromEnum.IIHPATIPASTHELPER, this.Context);
            MoreEmsParamDTO emsParam = viewModel.copyAdd(id_ors, ciEnContext);
            if (emsParam.Errormap2.Values.Count == 0)
            {
                this.LoadData();
            }
            MoreEmsParamDTOToEmsCard(emsParam);
        }
        /// <summary>
        /// 医嘱组手返回的DTO，调用医疗单
        /// </summary>
        /// <param name="emsParam"></param>
        private void MoreEmsParamDTOToEmsCard(MoreEmsParamDTO emsParam)
        {
            List<object> orList = emsParam.Errormap2.Values.ToList();
            List<object> emsList = new List<object>() { "" };
            emsList.AddRange(orList);
            //List<object> emsObj = new List<object>();
            //emsList.ForEach(p=>emsObj.Add(emsObj));
            ManyRecordSrv(emsList, "");
        }
        /// <summary>
        /// 是否对指定的医嘱可以停止
        /// </summary>
        /// <param name="ord">医嘱对象</param>
        /// <returns></returns>
        private static bool IsStopOrd(CiOrderDO ord)
        {
            //if (ord.Sd_su_or == CiDictCodeConst.SD_SU_CHECKTHROUGH && ord.Fg_long == true && ord.Fg_chk == true && ord.Fg_canc == false)
            //    orderlist.Add(ord);
            //未停止核对的有效医嘱，可反复修改停止时间；  王琪需求

            return ord.Sd_su_or != CiDictCodeConst.SD_SU_CHECKSTOP && ord.Fg_long == true && ord.Fg_canc == false
                && ord.Sd_su_or != CiDictCodeConst.SD_SU_FINISH && ord.Sd_su_or != CiDictCodeConst.SD_SU_DOCTORCANCEL && ord.Sd_su_or != CiDictCodeConst.SD_SU_CHECKCANCEL;
        }

        /// <summary>
        /// 显示“停止时间对话框”
        /// </summary>
        private void StopTimeDiag()
        {
            this.convert = new CalendarDateConverter();
            CalendarTimerControl calendarControl = new CalendarTimerControl(this.convert);
            calendarControl.BackColor = Color.White;
            calendarControl.Submit += calendarControl_Submit;
            calendarControl.Cancel += calendarControl_Cancel;
            calendarControl.Font = Font;
            //var p = new Point(SystemInformation.VirtualScreen.Width/2-100,
            //    0);双屏时 不对，所以换成下面的
            var p = new Point(this.FindXBaseForm().Width / 2, 0);
            calendarForm = new ContextMenuForm();
            //calendarForm.TopMost = true;
            calendarForm.KeyPreview = true;
            calendarForm.FormBorderWidth = 0;
            calendarForm.ShowDirection = ShowDirection.Bottom;
            calendarForm.AddControl(calendarControl);
            calendarForm.ShowContext(new Rectangle(p, new Size(300, 300)));

        }

        /// <summary>
        /// 关闭停止时间对话框
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void calendarControl_Cancel(object sender, EventArgs e)
        {
            calendarForm.Close();
        }

        /// <summary>
        /// 停止时间对话框上的确定按钮的处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void calendarControl_Submit(object sender, EventArgs e)
        {
            CiOrderDO[] orders = curOrdList.ToArray();
            string messag = viewModel.getCiOrderAggDoArray(orders, convert.PivotDate);
            if (messag != "")
            {
                calendarForm.Close();
                this.ShowInfo(messag);
                return;
            }

            viewModel.stoptime = convert.PivotDate;
            viewModel.OnUpdateSu(orders, CiDictCodeConst.SD_SU_DOCTORSTOP, CiDictCodeConst.SD_SU_ID_DOCTORSTOP);
            HandlerAfterCancel();
            calendarForm.Close();
            LoadData();
            gv.VScroll.Value = 200; //暂时处理
        }

        #endregion

        #region 状态处理区域

        /// <summary>
        /// 状态改变时触发
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="eventArgs"></param>
        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            var newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            var dict = eventArgs.Data[UIConst.DATA] as Dictionary<string, Object>;

            switch (uiEvent)
            {
                case "confirm"://card 确认
                    this.orderCardView.Save();
                    break;
                case UIEvent.CANCEL://card 取消
                    HandlerAfterCancel();
                    break;
                case UIEvent.SAVE_SUCCESS:
                    HandlerAfterSaveSuccess(dict);
                    break;
                case UIEvent.LOAD:
                    //LoadHandler(eventArgs);
                    break;
                case UIEvent.RELOAD:
                    LoadHandler(eventArgs);
                    break;
                case "CiBack": //作废
                    CancelOrd();
                    break;
                case "CancelSubmit": //取消签署（撤回）
                    BackOrd();
                    break;
                case "CopyAdd": //复制
                    copyAdd();
                    break;
                case "CiStop": //停止
                    StopOrd();
                    break;
                case "CiSubmit": //签署
                    SignOrd();
                    break;
                case UIEvent.DELETE: //删除
                    DelOrd();
                    break;
                case "ListSelected":
                    EntranceForEms(dict);
                    break;
                case UIEvent.REFRESH:
                    RefreshOrdList();
                    break;
                case "OpBack":
                    BackOrd();
                    break;
                case "CiSaveas":
                    SaveAsOrd();
                    break;
                default:
                    break;
            }
        }

        /// <summary>
        /// 从医嘱列表的UI中，将各种参数信息收集到变量（ordSelectedContainer，searchParamMap）中
        /// </summary>
        private void UpdateParamsFromUI()
        {
            ordSelectedContainer.getSelectedRow(gv, keyName);

        }

        /// <summary>
        /// 刷新医嘱列表
        /// </summary>
        private void RefreshOrdList()
        {
            searchParamMap.Clear();
            LoadData();
        }

        /// <summary>
        /// 进入医疗单的统一入口
        /// 场景：
        /// （1）服务列表选择
        /// （2）双击医嘱列表
        /// （3）医嘱助手选中
        /// （4）侧边栏打开按钮
        /// </summary>
        /// <param name="dict"></param>
        private void EntranceForEms(Dictionary<string, object> dict)
        {
            CiOrderDO[] obj = xapFormControl1.GetSelected<CiOrderDO>();
            var list = new List<object>();
            if (dict != null)
            {
                var orsc = dict["newListSelected"] as OrScArgs;
                if (orsc != null)
                {
                    if (orsc.Obj != null)
                    {
                        //服务选择

                        list.Add("bd_srv");
                        list.Add(orsc.Obj);
                        ManyRecordSrv(list, "");
                    }
                    else if (orsc.listObj != null && orsc.listObj.Count > 0)
                    {
                        //医嘱助手
                        //直接进入医疗单
                        // ManyRecordSrv(orsc.listObj, "");
                        //后台做映射在进入医疗单 或者直接保存
                        MultiEmsHandleModel(orsc, "");
                    }
                }
            }
            else
            {
                //双击医嘱列表
                if (obj != null && obj.Length > 0)
                {
                    list.Add("order");
                    foreach (CiOrderDO order in obj)
                    {
                        list.Add(order);
                    }

                    ManyRecordSrv(list, null);
                }
            }
        }
        /// <summary>
        /// 助手多医疗单
        /// </summary>
        public void MultiEmsHandleModel(OrScArgs Args, String type)
        {
            var list = new List<OrTplNItmDO>();
            if (Args != null)
            {
                if (Args.Id_item == "technolog" || Args.Id_item == "ortmplate")
                {
                    foreach (var item in Args.listObj)
                    {
                        if ((item as OrTplNItmDO) != null)
                        {
                            list.Add(item as OrTplNItmDO);
                        }
                    }
                }
                else if (Args.Id_item == "medsrv")
                {
                    foreach (Object item in Args.listObj)
                    {
                        if ((item as MedSrvDO) != null)
                        {
                            MedSrvDO tempmedsrv = item as MedSrvDO;
                            if (tempmedsrv.Fg_set.Value)
                            {
                                MedSrvConvertSetItem(list, tempmedsrv);
                            }
                            else
                            {
                                OrTplNItmDO rtplItem = convertOrTplNItmDO(item as MedSrvDO);
                                list.Add(rtplItem);
                            }

                            // list.Add(new ems.common.EmsCreatedParameter(item as MedSrvDO, null));
                        }
                    }
                }

            }

            //保存数据库
            var envinfo = setCiEnContextDTO();

            var moreEmsDto = assModel.getMoreEmsParamDTO(envinfo, list.ToArray());
            MoreEmsParamDTOToEmsCard(moreEmsDto);
            RefreshOrdList();
        }

        /// <summary>
        /// 上下文信息
        /// </summary>
        /// <returns></returns>
        private CiEnContextDTO setCiEnContextDTO()
        {
            CiEnContextDTO envinfo = new CiEnContextDTO();
            envinfo.Code_entp = ent4BannerDto.Code_entp; envinfo.Id_dep_or = this.Context.Dept.Id_dep;
            envinfo.Id_en = this.ent4BannerDto.Id_ent;
            envinfo.Id_emp_or = this.Context.PsnInfo.Id_psndoc;
            envinfo.Id_entp = this.ent4BannerDto.Id_entp;
            envinfo.Id_grp = this.Context.Group.Id_grp;
            envinfo.Id_hp = this.ent4BannerDto.Id_hp;
            envinfo.Id_org = this.Context.Org.Id_org;
            envinfo.Id_pat = this.ent4BannerDto.Id_pat;
            envinfo.Fg_bb = this.ent4BannerDto.Fg_newborn;
            envinfo.Id_dep_en = this.ent4BannerDto.Id_dep_phy;
            envinfo.Emsappmode = (int)EmsAppModeEnum.IVEMSAPPMODE;
            return envinfo;

        }
        private void MedSrvConvertSetItem(List<OrTplNItmDO> list, MedSrvDO medsrvDO)
        {
            MedSrvSetItemDO[] medsrvSetItem = this.assModel.getMedSrvSetItemDO(medsrvDO.Id_srv);
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

        /// <summary>
        /// 在医疗单上点击取消按钮之后的处理器
        /// </summary>
        private void HandlerAfterCancel()
        {
            if (orderCardView != null)
            {
                orderCardView.splitContainer1.RemoveRender(orderCardView.EmsIndexAndButtonArea); //清除“确认”、“取消”按钮
                control.CanShowForm = false;
                orderCardView.ClearEmsList(); //清空数据
                if (control.TabNavigationForm!=null)
                control.TabNavigationForm.Close(); //关闭右缩面板
            }

        }

        /// <summary>
        /// 医嘱保存成功之后的后续处理函数
        /// </summary>
        /// <param name="dict"></param>
        private void HandlerAfterSaveSuccess(Dictionary<string, object> dict)
        {
            var id_or = dict["ID_OR"] as string; //原来被保存的医嘱
            ordSelectedContainer.add(id_or);

            LoadData(); //todo,zzj,有性能问题，所以一点击医疗单的确认，半天才反应在界面上的原因

            this.SetStatusMsg("保存成功！");

            //清除医疗单底部按钮区，并关闭医疗单
            if (orderCardView.IsEmsListEmpty())
            {
                orderCardView.splitContainer1.RemoveRender(orderCardView.EmsIndexAndButtonArea);
                control.TabNavigationForm.Close();
            }
        }

        /// <summary>
        /// 加载事件的处理器
        /// 调用场景：
        /// （1）banner数据的加载
        /// （2）临床路径的触发
        /// </summary>
        /// <param name="eventArgs"></param>
        private void LoadHandler(DictionaryEventArgs eventArgs)
        {
            var dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
            if (dic != null)
            {
                if (dic.ContainsKey("PatientData") && dic["PatientData"] != null)
                {

                    if (this.Created && (this.Context["PatientData"] as BannerData
                        ).Ent4BannerDTO.Id_ent != ent4BannerDto.Id_ent)
                    {
                        this.Context["PatientData"] = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        LoadData();
                    }
                }

                if (dic != null && dic.ContainsKey("Data") && dic["Data"] != null)
                {
                    var dict2 = dic["Data"] as Dictionary<string, object>;
                    if (!dict2.ContainsKey("RecordsInfoDTO")) return;
                    var docinfoDtos = dict2["RecordsInfoDTO"] as DocinfoDTO[];
                    if (docinfoDtos == null) return;
                    var srvList = new List<object>();
                    srvList.Add("cp");
                    foreach (DocinfoDTO docinfoDto in docinfoDtos)
                    {
                        FArrayList list1 = docinfoDto.Refeleitems;
                        foreach (object data in list1)
                        {
                            var docSrvinfoDto = data as DocSrvinfoDTO;
                            if (docSrvinfoDto == null) return;
                            srvList.Add(docSrvinfoDto.Refeleitems[0]);
                        }
                    }
                    dict2["RecordsInfoDTO"] = null;
                    ManyRecordSrv(srvList, "");
                }
            }

            if (ent4BannerDto == null)
            {
                this.ShowMessage("没有患者信息！");
            }
        }

        /// <summary>
        /// 加载事件的处理器
        /// 调用场景：
        /// （1）banner数据的加载
        /// （2）临床路径的触发
        /// </summary>
        /// <param name="eventArgs"></param>
        private void LoadHandler()
        {
            //if (dic != null)
            //{
            //if (this.Context["PatientData"] != null )
            //{

            //    if (this.Created && (this.Context["PatientData"] as BannerData
            //        ).Ent4BannerDTO.Id_ent != ent4BannerDto.Id_ent)
            //    {
            //        this.Context["PatientData"] = (dic["PatientData"] as BannerData).Ent4BannerDTO;
            //        LoadData();
            //    }
            //}
            if (Context["Data"] != null)
            {
                var dict2 = Context["Data"] as Dictionary<string, object>;
                if (!dict2.ContainsKey("RecordsInfoDTO")) return;
                var docinfoDtos = dict2["RecordsInfoDTO"] as DocinfoDTO[];
                if (docinfoDtos == null) return;
                var srvList = new List<object>();
                srvList.Add("cp");
                foreach (DocinfoDTO docinfoDto in docinfoDtos)
                {
                    FArrayList list1 = docinfoDto.Refeleitems;
                    foreach (object data in list1)
                    {
                        var docSrvinfoDto = data as DocSrvinfoDTO;
                        if (docSrvinfoDto == null) return;
                        srvList.Add(docSrvinfoDto.Refeleitems[0]);
                    }
                }
                dict2["RecordsInfoDTO"] = null;
                ManyRecordSrv(srvList, "");
                // Context["Data"] = null;
            }
            //}

            if (ent4BannerDto == null)
            {
                this.ShowMessage("没有患者信息！");
            }
        }

        #endregion

        #region IWorkStationRegist接口实现函数

        /// <summary>
        /// 注册
        /// </summary>
        /// <param name="eventBroker"></param>
        public virtual void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
        }


        private void JudgePatientBalance()
        {
            if (IpModel == null)
            {
                this.IpModel = new IpOverViewModel();
            }
            if (ent4BannerDto != null)
            {
                string[] amt = this.IpModel.getBlcgAmtVsDrugRation(ent4BannerDto.Id_pat, ent4BannerDto.Id_ent, "01");
                if (amt != null && amt.Length > 0)
                {
                    if (amt[0] != null && Double.Parse(amt[0]) <= Double.Parse("0"))
                    {
                        this.ShowInfo("本患者的余额小于 0 ！", "提示");
                    }
                }
            }
        }

        /// <summary>
        /// 反注册
        /// </summary>
        /// <param name="eventBroker"></param>
        public virtual void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
        }

        /// <summary>
        /// 更新患者信息
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="eventArgs"></param>
        public virtual void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {
            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                if (Created)
                    LoadData();
            }
        }

        #endregion

    }
}