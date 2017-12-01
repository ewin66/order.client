using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciorder.viewmodel;
using xap.rui.appfw;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using iih.bd.bc.udi;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.ciorder.d;
using xap.rui.control.extentions;
using xap.rui.control.forms.model;
using iih.en.pv.inpatient.dto.d;
using xap.cli.sdk.render.Items;
using xap.rui.control.forms.control;
using iih.ci.ord.ciorder;
using iih.ci.ord.ciorder.cards.extend;
using xap.cli.sdk.controls.navbar;
using xap.cli.sdk.controls.tabControl;
using xap.rui.control.basecontrol;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using iih.en.pv.dto.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.render;
using xap.rui.bizcontrol.bannercontrol;
using xap.cli.sdk.render.DoctorOrderCard;
using iih.ci.ord.ciorder.utils;
using xap.rui.bizcontrol.workstation;
using xap.cli.sdk.controls.DataView.Extension;
using iih.ci.ord.ciorder.orreport;
using iih.ci.ord.cilab.view;
using xap.rui.bizcontrol.ClinicalTimeline.reportTypeInfo;
using System.IO;
using System.Xml.Serialization;
using xap.sys.xbd.udi.d;
using iih.ci.ord.ciobs.view;
using xap.cli.sdk.form;
using iih.ci.ord.diagtreatview.viewmodel.bp;
using xap.rui.bizcontrol.ClinicalTimeline.enums;
using iih.ci.ord.pathgyreportform.view;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.spltpres;
using xap.cli.sdk.controls.DataView.Renders;
using iih.ci.ord.opippathgy.view;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.cli.sdk.common;

namespace iih.ci.ord.oporder.view
{
    /// <summary>
    /// <para>描    述 : 门诊医生工作站-【医嘱列表】视图   </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view       </para>    
    /// <para>类 名 称 : OpOrderItemView                   </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 :                                   </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class OpOrderItemView : CiorderBaseControl, IWorkStationRegist
    {
        #region 变量定义区域
        [EventPublication(WEventTopics.NAVI)]
        public event EventHandler<DictionaryEventArgs> SwitchFuncPage;

        protected OrderItemViewModel viewModel;
        protected XapFormGridControl gv;
        private XTabPage tabPage1 = null;

        protected Ent4BannerDTO patDo = new Ent4BannerDTO();
        private TabNavigatorControl control;//右边收起控件
        private OpOrderCardView orderCardView;//编辑
        protected XapBaseControl orderPresView;
        /// <summary>
        /// 医嘱组件
        /// </summary>
        private DoctorOrderConfig doctorOrderConfig;

        #endregion

        #region 构造函数区域
        public OpOrderItemView()
        {
            InitializeComponent();

            this.xapFormControl1.Load += XapFormControl_OnLoad;
            this.xapFormControl1.DataDbClick += OnXapFormControl_DataDbClick;
            this.xapFormControl1.FormCreated += XapFormControl_FormCreated;
            this.xapFormControl1.ModelFilled += xapFormControl1_ModelFilled;
            this.xapFormControl1.AfterFocused += xapFormControl1_AfterFocused;
            this.xapFormControl1.Resize += xapFormControl1_Resize;

            OrdParam.GetOrdParam.isHos = false;
            control = createTabNavigatorControl();
            ordSelectedContainer = new OrdSelectedContainer();
            if (null != control)
                this.Controls.Add(control);
        }
        #endregion

        #region 公开属性区域

        public XapBaseControl getOpOrderPresView()
        {
            return orderPresView;
        }

        #endregion

        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (this.Context["PatientData"] == null)
            {
                return;
            }

            patDo = (this.Context["PatientData"] as BannerData).Ent4BannerDTO;
            if (patDo != null)
            {
                if (this.viewModel == null)
                    this.viewModel = new OrderItemViewModel(patDo, this.Context,true);
                this.viewModel.Reload(patDo.Id_ent, patDo.Code_entp);
            }
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            var file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OpOrderItemView;// "20151022075428682WGO";
            file.FormStyle = FormStyle.Card;
            if (this.viewModel != null && this.viewModel.xapList != null)
            {
                file.ViewModel = this.viewModel.xapList;
            }
            this.xapFormControl1.ViewFile = file;
            var dp = new DataPolicy();
            dp.MultiSelect = true;
            this.xapFormControl1.SetEditPolicy(false, new DataPolicy[] { dp });

        }

        public override void OnSelected(object sender, xap.rui.control.basecontrol.TargetEventArgs e)
        {
            if (e.Object is PatientsDTO)//患者切换  患者切换以后，应该把新患者 对应的 索引为0的数据传出去，card 联动变化
            {
                patDo = e.Object as Ent4BannerDTO;
                this.LoadData();
            }
        }

        #endregion

        #region 内部事件区域
        protected virtual void XapFormControl_OnLoad(object sender, EventArgs e)
        {
            OnInit();
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected virtual void XapFormControl_FormCreated(object sender, EventArgs e)
        {
            // 初始化医嘱组件
            string path = Application.StartupPath + "\\modules\\iihci\\ui\\commoncontent\\OrderContent.xml";
            doctorOrderConfig = this.Deserialize(path);

            gv = this.xapFormControl1.GetGridView("order");
            gv.DataTable.DataDisplay += tabControl_DataDisplay;
            gv.DataTable.CustomerCellMouseClick += OnXapFromGrid_CellClick;
            gv.DataTable.MultiCheckChanged += new EventHandler<MutilCheckedEventArgs>(mutilCheckedEventArgs);
            gv.DataTable.SelectedAllChanged += new EventHandler(SelectedAllChanged);
            gv.MouseClick += OnXapFromGrid_MouseClick;
            gv.MouseDoubleClick += OnXapFromGrid_MouseDoubleClick;
            gv.ReadOnly = true;
            gv.DataTable.CrossBackColor = true;
            gv.DataTable.Rows.DefaultHeight = 30;

            UdidocDO[] udidocs = OrReportPictureButton.GetInstance().getMap()[EnDictCodeConst.SD_ENTP_OUTPATIENT];
            if (udidocs == null) {
                udidocs = new UdidocDO[0];
            }
            int columnWidth = 6 + (2 + RelativeUIParam.RELATIVECELLSIZE.Height) * udidocs.Length;
            columnWidth = columnWidth <= 90 ? 90 : columnWidth;
            gv.DataTable.Columns["customercolumn_check_result"].Width = columnWidth;
            gv.DataTable.Columns["customercolumn_check_result"].DefalutWidth = columnWidth;

            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            XTabControl tabControl = tabs[0].tabContrl;
            tabControl.SelectedChanging += TabControl_SelectedChanging;
            tabControl.SelectedIndexChanged += tabControl_SelectedIndexChanged;
            XTabPage xtab = tabControl.XTabPages[1];
            this.orderPresView = this.createOrderPresControl();
            xtab.PageControl = this.orderPresView;
            foreach (XDataColumn item in gv.DataTable.Columns)
            {
                item.AlignCell = StringAlignment.Center;
            }
        }

        #region 表格控件事件
        protected void tabControl_DataDisplay(Object sender, XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            if (row != null)
            {
                foreach (UserRender render in row.UserRenderList)
                {
                    if (render is DoctorOrderCard)
                    {
                        var card = render as DoctorOrderCard;
                        card.DoctorOrderConfig = this.doctorOrderConfig;
                    }
                }
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_check_result"))
            {
                var ciorderdo = row.RowDataSource as CiOrderDO;
                var resultList = OrReportPictureButton.GetInstance().buildOrderResultData(ciorderdo);
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
            var ciOrderDO = (sender as XOrderResultCell).DataSource as CiOrderDO;
            if (string.IsNullOrEmpty(((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Value) || ((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Value.Equals("0"))
            {
                return;
            }
            var type = Convert.ToInt32(((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Type);
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
                        var pathol = new OpippathgyCardView();
                        pathol.setPatholdto(ciOrderDO.Id_or, ClinicalExeEventStatus.Pathol.ToString());
                        TestView.DataView = pathol;
                        TestView.Size = new Size(850, 740);
                        TestView.ReportStatus = ClinicalExeEventStatus.Pathol;
                        TestView.ShowReportButton.Text = "影像";
                        TestView.Text = "病理报告";
                        TestView.cliTestControl.AddRender(TestView.DataView);
                        TestView.ShowDialog();
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
                    TestView.ShowReportButton.Enabled = false;
                    TestView.Text = title;
                    TestView.cliTestControl.AddRender(TestView.DataView);
                    TestView.ShowDialog();
                }
            }
            else
            {
                var orReport = new OrReport(sender as XOrderResultCell, ciOrderDO, type);
                DialogResult result = orReport.ShowDialog();
                if (result == DialogResult.OK)
                {
                    freshFeeBillDataSource();
                }
            }
        }

        private void test(XForm xForm)
        {
            if ((xForm is CliTestView) && ((xForm as CliTestView).DataView is CiRptLabView) && (xForm as CliTestView).ReportStatus == ClinicalExeEventStatus.LIS)
            {
                DiagtreatUtils.showTrendView((xForm as CliTestView), patDo);
            }
        }

        private void mutilCheckedEventArgs(object sender, MutilCheckedEventArgs e)
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

        private void SelectedAllChanged(object sender, EventArgs e)
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

        /// <summary>
        /// 表格双击事件处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected virtual void OnXapFromGrid_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            var row = sender as XDataRow;
            if (row != null && !row.Selected)
            {
                row.Selected = true;
            }

            var ci = xapFormControl1.GetFocused<CiOrderDO>("order");
            FireSelected(ci);
        }
        /// <summary>
        /// 医嘱表格控件的鼠标单击事件处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected virtual void OnXapFromGrid_MouseClick(object sender, MouseEventArgs e)
        {
            var row = sender as XDataRow;
            if (row != null)
            {
                row.Selected = !row.Selected;
            }
        }
        #endregion

        #region 页签事件
        protected virtual void TabControl_SelectedChanging(object sender, TabChangeEventArgs e)
        {

        }

        protected virtual void tabControl_SelectedIndexChanged(object sender, EventArgs e)
        {
            //throw new NotImplementedException();
            var xtab = sender as XTabPage;
            if (xtab.Text.Equals("分方")) orderPresView.LoadData();
        }
        #endregion

        protected virtual void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            ordSelectedContainer.setSelected(gv, keyName);
        }

        private void xapFormControl1_Resize(object sender, EventArgs e)
        {
            this.OnResize(e);
        }

        private void xapFormControl1_AfterFocused(object sender, DataFocusedEventArgs e)
        {
            if (e.Data is CiOrderDO)
            {
                var ordDO = e.Data as CiOrderDO;
                switch (ordDO.Sd_su_or)
                {
                    //开立
                    case CiDictCodeConst.SD_SU_OPEN:
                        this.SenMgs(CiDictCodeConst.SD_SU_OPEN);
                        break;
                    //已签署
                    case CiDictCodeConst.SD_SU_SIGN:
                        this.SenMgs(CiDictCodeConst.SD_SU_SIGN);
                        break;
                }
            }
        }

        protected virtual void OnXapFormControl_DataDbClick(object sender, DataFocusedEventArgs e)
        {
            this.FireSelected(gv.GetFocusedRow().RowDataSource);
        }
        #endregion

        #region 辅助处理函数
        /// <summary>
        /// 签署结束后处理内容(增加fg_flush2mr)
        /// <para>签署结束后触发病例保存处置使用</para>
        /// <para>注意：子类需要实现该方法</para>
        /// Add by lxy 20161101
        /// </summary>
        protected virtual void fireCiOrderFlush2mrEvent(CiOrderDO[] args)
        {

        }

        #region 医嘱操作
        //签署
        protected virtual bool SignOrd()
        {
			bool isSignSucc = false;
            var orders = this.xapFormControl1.GetSelected<CiOrderDO>();
            // 从选中的列表项目中，过滤出未签署的医嘱项目
            var orderlist = orders.Where(ord => ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();
            if (orderlist.Count > 0)
            {
                if (orderlist.Count == orders.Length)
                {
                    isSignSucc = DoSignOrder(orderlist.ToArray());
                    //this.viewModel.SignCiOrder(orderlist.ToArray(), this.patDo);
                    this.LoadData();

                }
                else
                {
                    // 强制签署，是否需要更严谨的判断
                    if (this.IsContinue("提示", "未签署的医嘱才可【签署】！是否继续操作？"))
                    {
                        isSignSucc = DoSignOrder(orderlist.ToArray());
                        //this.viewModel.SignCiOrder(orderlist.ToArray(), this.patDo);
                        this.LoadData();
                    }

                }
              //OrdListView中签署已经调用这里不再调用
              // if (this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpOrSysncro2MrHandleMode) == 0)
              //  {
              //      this.fireCiOrderFlush2mrEvent(this.viewModel.opsignords);
              //  }
            }
            else
            {
                //this.ShowInfo("请选择【未签署】的医嘱项目！");
                this.ShowInfo("请选择当前登录医生开立且【未签署】的医嘱项目！");
                
            }
            return isSignSucc;
        }
        
        protected virtual bool DoSignOrder(CiOrderDO[] szOrders)
        {
            return this.viewModel.SignCiOrder(szOrders, this.patDo);
        }
        //删除
        protected virtual void DelOrd()
        {
            var orders = this.xapFormControl1.GetSelected<CiOrderDO>();
            var orderlist = orders.Where(ord => ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false).ToList();

            if (orderlist.Count > 0)
            {
                if (this.IsContinue("提示:", "确定要删除？"))
                {
                    if (orderlist.Count == orders.Length)
                    {
                        ordSelectedContainer.clear();
                        //this.viewModel.DelOrd(xapFormControl1.GetSelected<CiOrderDO>());
                        DoDeleteOrder(xapFormControl1.GetSelected<CiOrderDO>());
                        this.LoadData();
                        this.SetStatusMsg("删除成功！");
                    }
                    else
                    {
                        if (this.IsContinue("提示", "未签署的医嘱才可【删除】！是否继续操作？"))
                        {
                            DoDeleteOrder(xapFormControl1.GetSelected<CiOrderDO>());
                            //this.viewModel.DelOrd(xapFormControl1.GetSelected<CiOrderDO>());
                            this.LoadData();
                            this.SetStatusMsg("删除成功！");
                        }
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

        protected virtual void DoDeleteOrder(CiOrderDO[] szOrders)
        {
            this.viewModel.DelOrd(szOrders);
        }

        //撤回
        protected void updateSu(string code, string id, string code_entp)
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
            viewModel.OnUpdateSu(backOrdList.ToArray(), CiDictCodeConst.SD_SU_OPEN, CiDictCodeConst.SD_SU_ID_OPEN);
            this.LoadData();
        }
        #endregion

        public override void OnActiveForm()
        {
            if (patDo != null && patDo.Id_ent != null)// 为什么没有在 OnFillData 中增加该判断 ？
            {
                if (viewModel == null) // 与 OnLoadData 重复
                {
                    viewModel = new OrderItemViewModel(patDo, this.Context);
                }
                viewModel.Reload();

                if (viewModel.getEntDiDOS(this.patDo.Id_ent))
                {
                    this.ShowInfo("请先下达诊断");
                    if (SwitchFuncPage != null)
                    {
                        var args = new DictionaryEventArgs();
                        args.Data["FuncCode"] = "46105515";
                        args.Data["index"] = "";
                        SwitchFuncPage(this, args);
                    }
                }
            }
            else
            {
                this.ShowInfo("患者信息不存在");
            }

        }

        protected virtual void freshFeeBillDataSource()
        {
        }

        /// <summary>
        /// 创建处方业务视图对象
        /// </summary>
        /// <returns></returns>
        protected XapBaseControl createOrderPresControl()
        {
            var spview = (SpltPrescriptionView)this.Context.Config.GetInstance("SpltPrescriptionView");

            spview.Dock = DockStyle.Fill;
            return spview;

        }

        protected virtual TabNavigatorControl createTabNavigatorControl()
        {
            //弹出控件
            var ctrl = new TabNavigatorControl { Size = new Size(32, 200) };
            ctrl.BodyText = "医疗单";
            ctrl.NavFormWith = 605;

            return ctrl;
        }
        
        public void SetTabText(string strSheetName)
        {
            this.tabPage1.Text = strSheetName;
        }

        #region 医疗单
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
            var obj = xapFormControl1.GetSelected<CiOrderDO>();
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
                        ManyRecordSrv(orsc.listObj, "");
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
        /// 多医疗单的处理
        /// </summary>
        /// <param name="objs">数据集合，type 是类型 1 服务，2 模板，3 cp ，4 其它</param>
        /// <param name="type"></param>
        private void ManyRecordSrv(List<Object> objs, String type)
        {
            if (tabPage1 == null)
            {
                tabPage1 = new XTabPage { Text = "医疗单", PageControl = GetCardControl() };
                control.NavTabControl.XTabPages.Add(tabPage1); //右缩面板多页添加
            }

            if (objs != null && objs.Count > 6)
            {
                this.ShowInfo("选中的医嘱大于6个，暂时不支持");
                objs.Clear();
                return;
            }

            control.CanShowForm |= this.Created;
            //control.TabNavigationForm.Capture = true;
            orderCardView.SetOrderItemView(this);
            //将智能Form的数据由helperView传到悬浮窗
            orderCardView.ManyRecordSheet(objs, patDo, control);
        }
        /// <summary>
        /// 获取OrderCardView控件对象
        /// </summary>
        /// <returns></returns>
        private Control GetCardControl()
        {
            orderCardView = (OpOrderCardView)Context.Config.GetInstance("OpOrderCardView");
            return orderCardView;
        }
        #endregion

        /// <summary>
        /// 解析医嘱控件的xml配置
        /// </summary>
        /// <param name="path">医嘱控件对应的配置文件路径</param>
        /// <returns></returns>
        private DoctorOrderConfig Deserialize(string path)
        {
            DoctorOrderConfig doctorCfg = null;
            using (FileStream fs = new FileStream(path, FileMode.Open, FileAccess.Read))
            {
                XmlSerializer xml = new XmlSerializer(typeof(DoctorOrderConfig));
                doctorCfg = (DoctorOrderConfig)xml.Deserialize(fs);
            }
            return doctorCfg;
        }

        private void SenMgs(String uievent)
        {
            var dic = new DictionaryEventArgs();
            dic.Data[UIConst.UI_EVENT] = uievent;
            this.FireEventSent(this, dic);

        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            var newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            var dict = eventArgs.Data[UIConst.DATA] as Dictionary<string, Object>;
            switch (uiEvent)
            {
                case "CiSubmit"://签署
                    this.SignOrd();
                    break;
                case UIEvent.DELETE://删除
                    this.DelOrd();
                    break;
                case UIEvent.SAVE_SUCCESS:
                     object id_or = AssToolEx.ObjectOfEventArgs(eventArgs, "ID_OR");
                    if (id_or != null) {
                        ordSelectedContainer.add(id_or.ToString());
                    }
                    if (Created)
                    {
                        this.LoadData();
                    }
                        
                    this.SetStatusMsg("保存成功！");
                    if (control != null)
                        control.TabNavigationForm.Close();
                    break;
                case "ListSelected":
                    EntranceForEms(dict);
                    break;
                case UIEvent.REFRESH:
                    this.LoadData();
                    break;
                case UIEvent.LOAD:
                    var dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        if (this.Created && (this.Context["PatientData"] as BannerData
                            ).Ent4BannerDTO.Id_ent != patDo.Id_ent)
                        {
                            this.Context["PatientData"] = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                            LoadData();
                        }
                    }
                    break;
                case "Cipres":
                    break;
                case "OpBack"://撤回
                    updateSu(CiDictCodeConst.SD_SU_OPEN, CiDictCodeConst.SD_SU_ID_OPEN, this.patDo.Code_entp);
                    break;
                case "EnOver"://诊毕
                    break;
                case "EnStay"://急诊留观
                    break;
            }
        }
        #endregion

        #region 注册与反注册到工作站
        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
        }
        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {

            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                // patDo = obj as PatiVisitDO;
                this.patDo = (obj as BannerData).Ent4BannerDTO;
                if (Created)
                    this.LoadData();
            }
        }
        #endregion
        
    }
}
