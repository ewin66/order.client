
using iih.bd.bc.udi;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.orderlist.model;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.view;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Xml.Serialization;
using xap.cli.sdk.render.DoctorOrderCard;
using xap.rui.control.extentions;
using xap.rui.control.forms.model;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using iih.en.pv.dto.d;
using xap.rui.control.basecontrol;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.cli.sdk.controls.tabControl;
using xap.rui.control.forms.control;
using xap.cli.sdk.controls.DataView.Model;
using xap.sys.xbd.udi.d;
using iih.ci.ord.ciorder.utils;
using xap.cli.sdk.common;
using xap.cli.sdk.controls.DataView;
using System.Drawing;
using iih.bd.srv.ems.d;
using xap.cli.sdk.render;
using xap.rui.bizcontrol.bannercontrol;
using xap.cli.sdk.controls.DataView.Extension;
using xap.rui.bizcontrol.ClinicalTimeline.reportTypeInfo;
using iih.ci.ord.opippathgy.view;
using xap.rui.bizcontrol.ClinicalTimeline.enums;
using iih.ci.ord.ciobs.view;
using iih.ci.ord.cilab.view;
using iih.ci.ord.ciorder.orreport;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.moreemsdto.d;
using xap.mw.core.data;
using xap.cli.sdk.controls.DataView.Renders;
using xap.cli.sdk.form;
using iih.ci.ord.diagtreatview.viewmodel.bp;
using iih.ci.ord.opemergency.assi.rationaldrug.view;
using iih.ci.ord.opemergency.view.ordfeebill;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.opemergency.spltpres;
using iih.ci.ord.opemergency.controls;
using iih.ci.ord.opemergency.dialog;
using iih.ci.ord.opemergency.operateaction.baseoperate;
using iih.ci.ord.dto.ordpres.d;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;
using iih.ci.ord.opemergency.action.costant;
using iih.ci.ord.common.utils;
using iih.bl.common.hporshareinfoqry2;
using iih.ci.ord.dto.d;
using iih.ci.ord.ems.d;
using iih.ci.ord.medicaresharing;
using iih.ci.ord.medicaresharing.mdeicalrule;
using xap.mw.coreitf.d;
using xap.rui.devices;
using xap.rui.control.exceptions;
using xap.rui.appfw.async;
using xap.rui.appfw.extentions;
using xap.mw.log;
using iih.ci.ord.opemergency.view.basic;

namespace iih.ci.ord.opemergency.orderlist.view
{
    /// <summary>
    /// <para>描    述 : 门诊医嘱列表            			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.orderlist    </para>    
    /// <para>类 名 称 :  OrdGridView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  wangqzh         				</para> 
    /// <para>修 改 人 :  wangqzh         				</para> 
    /// <para>创建时间 :  12/21/2016 3:03:21 PM             </para>
    /// <para>更新时间 :  12/21/2016 3:03:21 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrdGridView : BaseFormBizView
    {
        public delegate int DelegateOrdAction(CiOrderDO[] ord, String evtCode, Object objData);
        public DelegateOrdAction OnDelegateOrdAction;

       

        #region 常量定义区域
        /// <summary>
        /// 事件常量
        /// </summary>
        public const String ACTION_FEEBILL_NEW = "ACTION_FEEBILL_NEW";//费用清单新增
        public const String ACTION_FEEBILL_DEL = "ACTION_FEEBILL_DEL";//费用清单删除
        public const String ACTION_FEEBILL_SAVE = "ACTION_FEEBILL_SAVE";//费用清单保存
        public const String ACTION_ORDERLIST_REFRESH = "ACTION_ORDERLIST_REFRESH";//医嘱列表刷新
        public const String ACTION_ORDERLIST_UPDATEEMR = "ACTION_ORDERLIST_UPDATEEMR";// 已签署处置同步到病历

        /// <summary>
        /// 初始化页面控件显示模式
        /// </summary>
        public const long PCM_OrderMode = 0x0004;//医嘱模式
        public const long PCM_PresMode = 0x0002;//处方模式
        public const long PCM_FeeMode = 0x0001;//费用清单模式
        #endregion

        #region 私有变量区域
        /// <summary>
        /// 数据操作模型
        /// </summary>
        private OrdGridViewModel viewModel;
        /// <summary>
        /// 医嘱组件
        /// </summary>
        private DoctorOrderConfig doctorOrderConfig;
        /// <summary>
        /// 就诊信息
        /// </summary>
        private Ent4BannerDTO ent4BannerDTO;
        /// <summary>
        /// 医嘱列表Grid
        /// </summary>
        private XapFormGridControl orderGridControl;
        /// <summary>
        /// 当前选择了哪些医嘱的容器数据结构对象
        /// </summary>
        private OrdSelectedContainer ordSelectedContainer;

        private EmsFeesControl emsFeesControl;

        protected XapBaseControl orderPresView;

        private int nSysParamFeeListOprMode = 0;
        // 处置同步到病历模式，0自动同步，1手动同步
        private int opOrSysncro2MrHandleMode = 0;

        private readonly Dictionary<String, XapBaseControl> toolbarMap = new Dictionary<string, XapBaseControl>();

        private bool needValidateOrdList;

        private bool isSignSuccess;//是否签署成功

        private String strParam = "";//系统参数，已签署医嘱操作模式
        #endregion

        #region 属性控制区域

        public long PageControlMode { get; set; }

        #endregion

        #region 构造函数区域
        public OrdGridView()
        {
            
        }
        public OrdGridView(BaseBizView o):base(o)
        {
            
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();
            this.viewModel = new OrdGridViewModel();

            this.ordSelectedContainer = new OrdSelectedContainer();

            this.RegisteFormEventImpl();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_OrdListView);//20170508071434669000

            // 初始化页面控件显示模式 -- 医嘱模式
            this.PageControlMode = PCM_OrderMode;

            this.Name = "医嘱列表";
        }
        #endregion

        #region 消息发送区域
        /// <summary>
        /// 处置同步到病历
        /// </summary>
        /// <param name="arg">处置同步到病历</param>
        private const string CI_ORDER_FLUSH_EVENT = "CiOrderFlush2MrEvent";
        [EventPublication(CI_ORDER_FLUSH_EVENT)]
        public event EventHandler<DataEventArgs<CiOrderDO[]>> FireCiOrderFlush2mrEvent;
        protected void fireCiOrderFlush2mrEvent(CiOrderDO[] arg)
        {
            if (arg != null)
            {
                var de = new DataEventArgs<CiOrderDO[]>(arg);
                if (FireCiOrderFlush2mrEvent != null)
                    FireCiOrderFlush2mrEvent(this, de);
            }

        }
        #endregion

        #region 父类继承区域
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (e.Object == null || !(e.Object is xap.rui.bizcontrol.bannercontrol.BannerData) ||
                (e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO == null)
            {
                this.ent4BannerDTO = null;
                this.viewModel.ClearTableDataSource();
                return;
            }

            this.ent4BannerDTO = (e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO;
            if (CiEnContextUtil.IsHpPat(ent4BannerDTO))
            {
                handleMedicalShared();
            }

            var t1 = new AssCostTimeTool("切换患者时候，医嘱列表加载耗时：", false);
            //this.OnLoadData();
            //this.OnFillData();
            this.LoadData();
            this.switchToolbar(this.getOrderListControl().GetType().FullName);
            t1.SaveTimeLog();
        }

        protected override void OnLoadData()
        {
            // 门诊费用清单相关参数
            nSysParamFeeListOprMode = this.Context.GetDeptParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpDocBillListOperationMode);
            // 处置同步到病历模式，0自动同步，1手动同步
            opOrSysncro2MrHandleMode = this.Context.GetParam<int>(this.Context.Dept.Id_dep, ICiOrdNSysParamConst.SYS_PARAM_OpOrSysncro2MrHandleMode);

            //object lockThis = new object();
            //lock (lockThis)
            {
                if (this.ent4BannerDTO != null)
                {
                    if (this.viewModel == null)
                    {
                        this.viewModel = new OrdGridViewModel();
                    }
                    this.viewModel.SetContext(this.Context);
                    this.viewModel.Id_ent = this.ent4BannerDTO.Id_ent;
                    this.viewModel.Code_entp = this.ent4BannerDTO.Code_entp;
                    this.viewModel.Reload();
                    this.SetFormDataSource(this.viewModel.GetTableDataSource());
                }
            }
        }

        protected override void OnFillData()
        {
            base.OnFillData();

            this.GetXapFormControl().SetEditPolicy(false, new DataPolicy[] { new DataPolicy { MultiSelect = true } });

            // 发送事件给第三方系统，进行医嘱药品校验
            if (needValidateOrdList)
            {
                AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDLIST_DATAVALIDATE, "CiOrderDOList",
                    new List<CiOrderDO>((this.viewModel.GetTableDataSource() as XapDataList<CiOrderDO>).ToArray()));

                needValidateOrdList = false;
            }
        }
        #endregion

        #region 内部事件区域
        /// <summary>
        /// 加载
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            base.OnXapFormControl_Load(sender, e);

            this.GetXapFormControl().Resize += new EventHandler(OnXapFormControl_Resize);

            this.OnInit();
        }

        /// <summary>
        /// 创建窗体
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);

            //初始化处置内容列控件
            initCustomeControlXml();

            initGridControl();

            initXTabControl();
        }

        /// <summary>
        /// 初始化处置内容组件
        /// </summary>
        private void initCustomeControlXml()
        {
            string path = Application.StartupPath + "\\modules\\iihci\\ui\\commoncontent\\OrderContent.xml";
            using (FileStream fs = new FileStream(path, FileMode.Open, FileAccess.Read))
            {
                XmlSerializer xml = new XmlSerializer(typeof(DoctorOrderConfig));
                doctorOrderConfig = (DoctorOrderConfig)xml.Deserialize(fs);
            }
        }

        /// <summary>
        /// 初始化医嘱列表控件
        /// </summary>
        private void initGridControl()
        {
            orderGridControl = this.GetXapFormControl().GetGridView("order");
            orderGridControl.DataTable.DataDisplay += orderGridControl_DataDisplay;
            orderGridControl.DataTable.CustomerCellMouseClick += orderGridControl_CellClick;
            orderGridControl.DataTable.MultiCheckChanged += orderGridControl_MultiCheckChanged;
            orderGridControl.DataTable.SelectedAllChanged += orderGridControl_SelectedAllChanged;
            orderGridControl.MouseClick += orderGridControl_MouseClick;
            orderGridControl.MouseDoubleClick += orderGridControl_MouseDoubleClick;
            orderGridControl.MouseDown += new MouseEventHandler(orderGridControl_MouseDown);

            orderGridControl.ReadOnly = true;
            orderGridControl.DataTable.CrossBackColor = true;
            orderGridControl.DataTable.Rows.DefaultHeight = 30;

            UdidocDO[] udidocs = OrReportPictureButton.GetInstance().getMap()[EnDictCodeConst.SD_ENTP_OUTPATIENT];
            if (udidocs == null)
            {
                udidocs = new UdidocDO[0];
            }
            int columnWidth = 6 + (2 + RelativeUIParam.RELATIVECELLSIZE.Height) * udidocs.Length;
            columnWidth = columnWidth <= 90 ? 90 : columnWidth;
            orderGridControl.DataTable.Columns["customercolumn_check_result"].Width = columnWidth;
            orderGridControl.DataTable.Columns["customercolumn_check_result"].DefalutWidth = columnWidth;
            orderGridControl.DataTable.Columns["customercolumn_name_srvtp"].AllowSort = true;
            foreach (XDataColumn item in orderGridControl.DataTable.Columns)
            {
                item.AlignCell = StringAlignment.Center;
            }
            adjustTableColumns("Content_or");
        }

        /// <summary>
        /// 调整列属性
        /// </summary>
        /// <param name="autofitField"></param>
        private void adjustTableColumns(string autofitField)
        {
            XDataColumn srvNameColumn = null;
            int nWidth = 0;

            foreach (XDataColumn column in orderGridControl.DataTable.Columns)
            {
                if (column.FieldName.Equals("Eu_verify_pharm") || column.FieldName.Equals("Des_verify_pharm"))
                    column.Visible = false;

                if (!column.Visible)
                    continue;

                // 记录自动伸缩列（默认服务名称）
                if (column.FieldName == autofitField)
                {
                    srvNameColumn = column;
                }
                else
                {
                    nWidth += column.Width;
                }
            }

            //计算自动伸缩列宽
            if (srvNameColumn != null && nWidth > 0)
            {
                srvNameColumn.Width = Size.Width - nWidth - 15;
            }
        }

        /// <summary>
        /// 初始化页签
        /// </summary>
        private void initXTabControl()
        {
            XTabControl tabControl = this.GetXapFormControl().FormModel.Tabs[0].tabContrl;
            tabControl.SelectedChanging += TabControl_SelectedChanging;
            tabControl.SelectedIndexChanged += tabControl_SelectedIndexChanged;

            //医嘱页签
            XTabPage xtabOrd = tabControl.XTabPages[0];

            //分方页签
            XTabPage xtabPres = tabControl.XTabPages[1];
            xtabPres.PageControl = this.createOrderPresControl();

            //费用清单页签
            XTabPage xtabFee = tabControl.XTabPages[2];
            xtabFee.PageControl = this.createOrderFeebillControl();

            int locationX = 20;
            if ((PageControlMode & PCM_OrderMode) == 0)
            {
                // 隐藏 医嘱列表
                xtabOrd.Visible = false;
            }
            else
            {
                locationX += xtabOrd.xTab.Bound.Width;
            }
            if ((PageControlMode & PCM_PresMode) == 0)
            {
                // 隐藏 处方列表
                xtabPres.Visible = false;
            }
            else
            {
                locationX += xtabPres.xTab.Bound.Width;
            }
            if (this.nSysParamFeeListOprMode == 0)
            {
                // 隐藏 费用列表
                xtabFee.Visible = false;
            }
            else
            {
                locationX += xtabFee.xTab.Bound.Width;
            }

            if (this.nSysParamFeeListOprMode <= 1)
            {
                (xtabFee.PageControl as OrdFeeBillView).SetReadOnly(true);
            }

            createOrdListViewToolbar();
            createFeebillViewToolbar();

            emsFeesControl = Context.Config.GetInstance("emsFeesControl") as EmsFeesControl;
            if (null != emsFeesControl)
            {
                emsFeesControl.ownerView = this;
            }
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                emsFeesControl.Location = new Point(locationX, 0);
                tabControl.AddRender(emsFeesControl);
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            var ord = e.Object as CiOrderDO;

            updateCustomerControlInfo(row, ord);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            ordSelectedContainer.setSelected(orderGridControl, "Id_or");
            var eventDic = new DictionaryEventArgs();
            eventDic.Data[UIConst.UI_EVENT] = "EmsFeesControl";
            FireEventSent(this, eventDic);

            this.GetXapFormControl().Refresh();
            if (isSignSuccess && opOrSysncro2MrHandleMode == 0)
            {
                //异步执行的委托
                AsyncExecuteDelegate workDelegate = workArgs =>
                {
                    //参数是Argument，这是自己传入的，自行转化类型
                    var argList = workArgs.Argument as List<object>;
                    CiOrderDO[] signOrders = argList[0] as CiOrderDO[];
                    // 异步调用，远程服务等。返回结果保存在参数的Result中。
                    workArgs.Result = signOrders;
                };
                xap.rui.appfw.async.AsyncDoneDelegate doneDelegate = doneArgs =>
                {
                    //如果已经取消了，则返回
                    if (doneArgs.Cancelled)
                        return;
                    //如果异步执行时发生了异常，可以在这里处理
                    //if (doneArgs.Error != null)
                    //{
                    //    Exception ex = doneArgs.Error;
                    //    //记录日志
                    //    LogManager.GetLogger().ErrorEx(ex.Message, ex);
                    //    //发布异常到UI
                    //    ex.Publish();
                    //    //标记为已处理异常，如果不标记，框架会抛出异常
                    //    doneArgs.ErrorHandled = true;
                    //    return;
                    //}

                    //签署的医嘱同步到病历
                    this.fireCiOrderFlush2mrEvent((CiOrderDO[])doneArgs.Result);

                };

                List<object> argsList = new List<object>();
                argsList.Add(this.viewModel.GetSignedOrders());
                workDelegate.AsyncExecute(argsList, doneDelegate);

                isSignSuccess = false;
            }
        }

        private void OnXapFormControl_Resize(object sender, EventArgs e)
        {
            this.OnResize(e);
        }

        protected override void OnResize(EventArgs e)
        {
            base.OnResize(e);
            toolbarMap.Values.ToList().ForEach(p =>
            {
                p.Location = new Point(Size.Width - p.Size.Width - 1, 1);
                p.BringToFront();
            });

            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                if (emsFeesControl != null)
                {
                    List<ControlTab> tabs = this.GetXapFormControl().FormModel.Tabs;
                    XTabPage xTab = tabs[0].tabContrl.XTabPages.Cast<XTabPage>().ToList().LastOrDefault(p => p.Visible = true);
                    emsFeesControl.Location = new Point(xTab.xTab.Bound.Right + 20, 0);
                }
            }
        }

        #region Grid事件
        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void orderGridControl_DataDisplay(Object sender, XDataDisplayEventArgs e)
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
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void orderGridControl_CellClick(object sender, EventArgs e)
        {
            var ciOrderDO = (sender as XOrderResultCell).DataSource as CiOrderDO;
            if (string.IsNullOrEmpty(((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Value) || ((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Value.Equals("0"))
            {
                return;
            }
            var type = Convert.ToInt32(((sender as XOrderResultCell).ActiveObject as XOrderResultRender).Type);
            if ((ciOrderDO.Sd_srvtp.Substring(0, 2).Equals(BdSrvDictCodeConst.SD_SRVTP_RIS) || ciOrderDO.Sd_srvtp.Substring(0, 2).Equals(BdSrvDictCodeConst.SD_SRVTP_LIS)) && 3 == type)
            {
                string dia = "";
                string title = "";
                CliTestView testView = new CliTestView();
                testView.TrendChartEvent += new CliTestView.TrendChartButtonClick(testView_TrendChartEvent);
                if (ciOrderDO.Sd_srvtp.Substring(0, 2).Equals(BdSrvDictCodeConst.SD_SRVTP_RIS))
                {
                    if (ciOrderDO.Sd_srvtp.Substring(0, 4).Equals(BdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI))
                    {
                        var pathol = new OpippathgyCardView();
                        pathol.setPatholdto(ciOrderDO.Id_or, ClinicalExeEventStatus.Pathol.ToString());
                        testView.DataView = pathol;
                        testView.Size = new Size(850, 740);
                        testView.ReportStatus = ClinicalExeEventStatus.Pathol;
                        testView.ShowReportButton.Text = "影像";
                        testView.Text = "病理报告";
                        testView.cliTestControl.AddRender(testView.DataView);
                        testView.ShowDialog();
                    }
                    else
                    {
                        dia = "ris";
                        title = "检查报告";
                        var lab = new CIRptObsView();
                        lab.setlabdto(ciOrderDO.Id_or, dia);
                        testView.Size = new Size(850, 740);
                        testView.ShowReportButton.Text = "影像";
                        testView.DataView = lab;
                        testView.Text = title;
                        testView.cliTestControl.AddRender(testView.DataView);
                        testView.ShowDialog();
                    }
                }
                else if (ciOrderDO.Sd_srvtp.Substring(0, 2).Equals(BdSrvDictCodeConst.SD_SRVTP_LIS))
                {
                    dia = "lis";
                    title = "检验报告";
                    var lab = new CiRptLabView();
                    lab.setlabdto(ciOrderDO.Id_or, dia, testView);
                    testView.DataView = lab;
                    testView.Size = new Size(940, 750);
                    testView.ShowReportButton.Text = "趋势图";
                    testView.ShowReportButton.Enabled = false;
                    testView.Text = title;
                    testView.cliTestControl.AddRender(testView.DataView);
                    testView.ShowDialog();
                }
            }
            else
            {
                var orReport = new OrReport(sender as XOrderResultCell, ciOrderDO, type);
                DialogResult result = orReport.ShowDialog();
                if (result == DialogResult.OK)
                {
                    //freshFeeBillDataSource();
                }
                RefreshViews();
            }
        }
        
        /// <summary>
        /// 
        /// </summary>
        /// <param name="xForm"></param>
        private void testView_TrendChartEvent(XForm xForm)
        {
            if ((xForm is CliTestView) && ((xForm as CliTestView).DataView is CiRptLabView) && (xForm as CliTestView).ReportStatus == ClinicalExeEventStatus.LIS)
            {
                DiagtreatUtils.showTrendView((xForm as CliTestView), ent4BannerDTO);
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void orderGridControl_MultiCheckChanged(object sender, MutilCheckedEventArgs e)
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

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void orderGridControl_SelectedAllChanged(object sender, EventArgs e)
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
        private void orderGridControl_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            orderGridControl.DataTable.SelectedRows.ToList().ForEach(p => { p.Selected = false; });
            ordSelectedContainer.clear();
            if (null != sender && sender is XDataRow)
            {
                (sender as XDataRow).Selected = true;
                ordSelectedContainer.add(((sender as XDataRow).RowDataSource as CiOrderDO).Id_or);
            }
            IEnumerable<OrderEditParameter> orderIterator =
                from rowItem in orderGridControl.DataTable.SelectedRows
                select new OrderEditParameter { OrderItem = rowItem.RowDataSource as CiOrderDO };

            var orderList = new OrderEditParamList(orderIterator);
            if (orderList.Count > 0)
            {
                AssToolEx.SentMessage(this, EventCodeType.EVENT_EMS_ORDER_EDIT, OrderEditParamList.TAGKEY, orderList);
            }
        }
        
        /// <summary>
        /// 医嘱表格控件的鼠标单击事件处理函数
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void orderGridControl_MouseClick(object sender, MouseEventArgs e)
        {
            
        }

        /// <summary>
        /// 表格点击事件处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void orderGridControl_MouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                var dicParam = new Dictionary<string, bool>();
                if (getRigntButtonEnableParam(dicParam))
                {
                    var args = new DictionaryEventArgs();
                    var dic = new Dictionary<string, object>();
                    dic.Add(OpActionConstant.OP_CANCEL_REVERT_ENABLE_ACTION, dicParam);
                    args.Data.Add(UIConst.UI_EVENT, OpActionConstant.OP_CANCEL_REVERT_ENABLE_ACTION);
                    args.Data.Add(UIConst.DATA, dic);
                    FireEventSent(this, args);
                }
            }
        }
        #endregion

        #region 页签事件
        protected void TabControl_SelectedChanging(object sender, TabChangeEventArgs e)
        {
            e.Cancel = (this.ent4BannerDTO == null);
            if (e.PrevPage.PageControl is OrdFeeBillView)
            {
                if ((this.ent4BannerDTO != null) && (e.PrevPage.PageControl as OrdFeeBillView).IsDirty())
                {
                    if (BizAssMessageBoxUtil.ShowConfirmMsg("操作提示", "费用清单有数据修改，是否保存？"))
                    {
                        (e.PrevPage.PageControl as OrdFeeBillView).OnSave();
                        e.Cancel = (e.PrevPage.PageControl as OrdFeeBillView).IsError();
                    }
                    else
                    {
                        (e.PrevPage.PageControl as OrdFeeBillView).OnCancel();
                    }
                }
            }
        }

        protected void tabControl_SelectedIndexChanged(object sender, EventArgs e)
        {
            var xtab = sender as XTabPage;
            if (xtab.PageControl is SpltPrescriptionView)
            {
                AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDLIST_SWITCH2PRESS);
                switchToolbar(xtab.PageControl.GetType().FullName);
            }
            else if (xtab.PageControl is OrdFeeBillView)
            {
                AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDLIST_SWITCH2FEEBILL);
                switchToolbar(xtab.PageControl.GetType().FullName, false);
                (xtab.PageControl as OrdFeeBillView).ClearSelectedState();
            }
            else
            {
                AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDLIST_SWITCH2ORDLIST);
                switchToolbar(getOrderListControl().GetType().FullName);
            }
        }
        #endregion

        #region 工具栏
        /// <summary>
        /// 创建医嘱列表视图工具栏
        /// </summary>
        private void createOrdListViewToolbar()
        {
            var basecontrol = new XapBaseControl { Visible = false };
            basecontrol.Size = new Size(50, 25);
            basecontrol.Location = new Point(Size.Width - basecontrol.Size.Width - 1, 1);

            var btnRefresh = new CiIconToolButton
            {
                Tag = ACTION_ORDERLIST_REFRESH,
                Location = new Point(26, 0),
                Size = new Size(24, 24),
                TipText = "刷新",
                ImageName = "刷新"
            };
            btnRefresh.MouseClick += btn_MouseClick;
            SkinFactory.Instance().SkinChanged += btnRefresh.OnSystemSkinChanged;
            basecontrol.AddRender(btnRefresh);

            string refreshMode = this.Context.GetParam<string>(this.Context.Dept.Id_dep, ICiOrdNSysParamConst.SYS_PARAM_OpOrSysncro2MrHandleMode);
            if (refreshMode == "1")
            {
                var btnFlush2Emr = new CiIconToolButton
                {
                    Tag = ACTION_ORDERLIST_UPDATEEMR,
                    Location = new Point(0, 0),
                    Size = new Size(24, 24),
                    TipText = "处置回写到病历",
                    ImageName = "处置回写病历"
                };
                btnFlush2Emr.MouseClick += btn_MouseClick;
                SkinFactory.Instance().SkinChanged += btnFlush2Emr.OnSystemSkinChanged;
                basecontrol.AddRender(btnFlush2Emr);
            }

            this.GetXapFormControl().AddRender(basecontrol);
            toolbarMap.Add(getOrderListControl().GetType().FullName, basecontrol);
        }
        /// <summary>
        /// 创建费用列表视图工具栏
        /// </summary>
        private void createFeebillViewToolbar()
        {
            var basecontrol = new XapBaseControl { Visible = false };
            basecontrol.Size = new Size(75, 25);
            basecontrol.Location = new Point(Size.Width - basecontrol.Size.Width - 1, 1);
            if (this.nSysParamFeeListOprMode > 1)
            {
                var addButton = new CiIconToolButton
                {
                    Tag = ACTION_FEEBILL_NEW,
                    Location = new Point(1, 0),
                    Size = new Size(24, 24),
                    TipText = "新增",
                    ImageName = "增加"
                };
                addButton.MouseClick += btn_MouseClick;
                SkinFactory.Instance().SkinChanged += addButton.OnSystemSkinChanged;
                basecontrol.AddRender(addButton);

                var delButton = new CiIconToolButton
                {
                    Tag = ACTION_FEEBILL_DEL,
                    Location = new Point(addButton.Location.X + addButton.Size.Width + 1, 0),
                    Size = new Size(24, 24),
                    TipText = "删除费用",
                    ImageName = "tab-删除"
                };
                delButton.MouseClick += btn_MouseClick;
                SkinFactory.Instance().SkinChanged += delButton.OnSystemSkinChanged;
                basecontrol.AddRender(delButton);

                var saveButton = new CiIconToolButton
                {
                    Tag = ACTION_FEEBILL_SAVE,
                    Location = new Point(delButton.Location.X + delButton.Size.Width + 1, 0),
                    Size = new Size(24, 24),
                    TipText = "保存费用",
                    ImageName = "保存"
                };
                saveButton.MouseClick += btn_MouseClick;
                SkinFactory.Instance().SkinChanged += saveButton.OnSystemSkinChanged;
                basecontrol.AddRender(saveButton);

                basecontrol.EnabledChanged += (sender, e) =>
                {
                    saveButton.Enabled = basecontrol.Enabled;
                    addButton.Enabled = basecontrol.Enabled;
                    delButton.Enabled = basecontrol.Enabled;
                };
            }

            this.GetXapFormControl().AddRender(basecontrol);
            toolbarMap.Add(getOrderFeeBillControl().GetType().FullName, basecontrol);
        }
        /// <summary>
        /// 更换工具栏
        /// </summary>
        /// <param name="className"></param>
        /// <param name="enable"></param>
        private void switchToolbar(String className, bool enable = true)
        {
            toolbarMap.Values.ToList().ForEach(p => { p.Visible = false; });
            if (toolbarMap.ContainsKey(className))
            {
                toolbarMap[className].Visible = true;
                toolbarMap[className].BringToFront();
                toolbarMap[className].Enabled = enable;
            }
        }
        /// <summary>
        /// 获取工具栏
        /// </summary>
        /// <param name="className"></param>
        /// <returns></returns>
        private XapBaseControl GetToolbarControl(String className)
        {
            if (toolbarMap.ContainsKey(className))
            {
                return toolbarMap[className];
            }
            return null;
        }

        /// <summary>
        /// 工具按钮事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void btn_MouseClick(object sender, MouseEventArgs e)
        {
            var btn = sender as XIconToolButton;
            switch (btn.Tag.ToString())
            {
                case ACTION_ORDERLIST_REFRESH:
                    RefreshViews();
                    break;
                case ACTION_ORDERLIST_UPDATEEMR:
                    flushOrders2Mr();
                    break;
                case ACTION_FEEBILL_NEW:
                    getOrderFeeBillControl().OnAdd();
                    break;
                case ACTION_FEEBILL_DEL:
                    getOrderFeeBillControl().OnDelete();
                    break;
                case ACTION_FEEBILL_SAVE:
                    getOrderFeeBillControl().OnSave();
                    break;
            }
        }
        #endregion
        #endregion

        #region 辅助处理区域
        /// <summary>
        /// 更新医嘱类型列
        /// </summary>
        /// <param name="dataRow"></param>
        /// <param name="ciOrderDO"></param>
        private void updateCustomerControlInfo(XDataRow dataRow, CiOrderDO ciOrderDO)
        {
            if (ciOrderDO == null) return;
            if (dataRow != null && dataRow.ColumnCellDict.ContainsKey("customercolumn_name_srvtp"))
            {
                string sdSrvtp = ciOrderDO.Sd_srvtp;
                string strName_srvtp = "";
                // 药品、血液制品截取sd_srvtp 的前 4位，其余的截取两位
                sdSrvtp = sdSrvtp.Substring(0, (sdSrvtp.StartsWith(BdSrvTpDictCodeConst.SD_SRVTP_DRUG) || sdSrvtp.StartsWith(BdSrvTpDictCodeConst.SD_SRVTP_BLOODPROD)) ? 4 : 2);
                // 获取显示的类型名称
                strName_srvtp = viewModel.DicSrvtp.ContainsKey(sdSrvtp) ? viewModel.DicSrvtp[sdSrvtp] : "未知";

                dataRow.ColumnCellDict["customercolumn_name_srvtp"].SetValue(strName_srvtp);
            }
        }

        /// <summary>
        /// 刷新数据
        /// </summary>
        private void RefreshViews()
        {
            this.LoadData();
            if (getOrderFeeBillControl() != null)
            {
                getOrderFeeBillControl().LoadData();
            }
            if (getOrderPresControl() != null)
            {
                getOrderPresControl().LoadData();
            }
        }

        /// <summary>
        /// 获取右键菜单按钮可用性参数
        /// </summary>
        /// <param name="dicParam"></param>
        private bool getRigntButtonEnableParam(Dictionary<string, bool> dicParam)
        {
            bool bRst = true;
            //当前按钮可用性
            CiOrderDO order = this.getCurrCiOrderDO();
            if (order != null)
            {
                dicParam.Add(OpActionConstant.OpCurrOrderSignAction, order.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && order.Fg_sign == false && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(order));

                bool enableDelCurr = order.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && order.Fg_sign == false && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(order);
                if (!enableDelCurr)
                {
                    //高端商报患者
                    if (CiEnContextUtil.IsHeComInsurAllowedAccountPat(this.ent4BannerDTO))
                    {
                        enableDelCurr = (order.Fg_sign == true && order.Fg_feertnable == true) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(order);
                    }
                    else
                    {
                        if (this.strParam.EndsWith("1"))//合并操作
                        {
                            if (this.strParam.StartsWith("0"))//删除撤回
                            {
                                enableDelCurr = order.Fg_sign == true && order.Fg_canc == false && order.Fg_uncancelable == false && order.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(order);
                            }
                            else//删除作废
                            {
                                enableDelCurr = order.Fg_sign == true && order.Fg_canc == false && order.Fg_uncancelable == false && (order.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE || order.Sd_su_bl == CiDictCodeConst.SD_SU_BL_REFOUND) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(order);
                            }
                        }
                    }
                }
                dicParam.Add(OpActionConstant.OpCurrOrderDeleteAction, enableDelCurr);

                bool enableCancelCopyCurr = true;
                if (this.strParam.StartsWith("1"))
                {
                    enableCancelCopyCurr = order.Sd_su_or != CiDictCodeConst.SD_SU_OPEN && (order.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE || order.Sd_su_bl == CiDictCodeConst.SD_SU_BL_REFOUND) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(order);
                }
                dicParam.Add(OpActionConstant.OpCurrOrderCancelCopyAction, enableCancelCopyCurr);
                dicParam.Add(OpActionConstant.OpCurrOrderCancelAction, enableCancelCopyCurr);

                bool enableRevertCurr = true;
                if (this.strParam.StartsWith("0"))
                {
                    enableRevertCurr = order.Sd_su_or != CiDictCodeConst.SD_SU_OPEN && order.Sd_su_mp == CiDictCodeConst.SD_SU_MP_NONE && order.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(order);
                }
                dicParam.Add(OpActionConstant.OpCurrOrderRevertAction, enableRevertCurr);
            }
            else
            {
                bRst = false;
            }

            //全部按钮可用性
            CiOrderDO[] orders = this.getAllCiOrderDO();
            if (orders != null && orders.Length > 0)
            {
                bool enableSignAll = false;
                bool enableDeleteAll = false;
                bool enableCancelAll = false;
                bool enableRevertAll = false;
                foreach (var item in orders)
                {
                    if (!enableSignAll)
                    {
                        enableSignAll = item.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && item.Fg_sign == false && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(item);
                    }

                    if (!enableDeleteAll)
                    {
                        enableDeleteAll = item.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && item.Fg_sign == false && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(item);
                        if (!enableDeleteAll)
                        {
                            //高端商报患者
                            if (CiEnContextUtil.IsHeComInsurAllowedAccountPat(this.ent4BannerDTO))
                            {
                                enableDeleteAll = (order.Fg_sign == true && order.Fg_feertnable == true) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(order);
                            }
                            else
                            {
                                if (this.strParam.EndsWith("1"))
                                {
                                    if (this.strParam.StartsWith("0"))
                                    {
                                        enableDeleteAll = item.Fg_sign == true && item.Fg_canc == false && item.Fg_uncancelable == false && item.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(item);
                                    }
                                    else
                                    {
                                        enableDeleteAll = item.Fg_sign == true && item.Fg_canc == false && item.Fg_uncancelable == false && (item.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE || item.Sd_su_bl == CiDictCodeConst.SD_SU_BL_REFOUND) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(item);
                                    }
                                }
                            }
                        }
                    }

                    if (!enableCancelAll)
                    {
                        if (this.strParam.StartsWith("1"))
                        {
                            enableCancelAll = item.Sd_su_or != CiDictCodeConst.SD_SU_OPEN && (item.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE || item.Sd_su_bl == CiDictCodeConst.SD_SU_BL_REFOUND) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(item);
                        }
                    }

                    if (!enableRevertAll)
                    {
                        if (this.strParam.StartsWith("0"))
                        {
                            enableRevertAll = item.Sd_su_or != CiDictCodeConst.SD_SU_OPEN && item.Sd_su_mp == CiDictCodeConst.SD_SU_MP_NONE && item.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(item);
                        }
                    }
                }

                dicParam.Add(OpActionConstant.OpAllOrderSignAction, enableSignAll);
                dicParam.Add(OpActionConstant.OpAllOrderDeleteAction, enableDeleteAll);
                dicParam.Add(OpActionConstant.OpAllOrderCancelCopyAction, enableCancelAll);
                dicParam.Add(OpActionConstant.OpAllOrderCancelAction, enableCancelAll);
                dicParam.Add(OpActionConstant.OpAllOrderRevertAction, enableRevertAll);
            }
            else
            {
                bRst = false;
            }
            return bRst;
        }

        #region 页签视图
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

        /// <summary>
        /// 创建费用清单视图对象
        /// </summary>
        /// <returns></returns>
        protected XapBaseControl createOrderFeebillControl()
        {
            var spview = (OrdFeeBillView)Context.Config.GetInstance("OrdFeeBillView");

            spview.Dock = DockStyle.Fill;
            return spview;
        }

        /// <summary>
        /// 获取医嘱列表业务视图对象
        /// </summary>
        /// <returns>医嘱列表业务视图对象</returns>
        protected OrdGridView getOrderListControl()
        {
            return this;
        }

        /// <summary>
        /// 获取处方业务视图对象
        /// </summary>
        /// <returns>处方业务视图对象</returns>
        protected SpltPrescriptionView getOrderPresControl()
        {
            List<ControlTab> tabs = this.GetXapFormControl().FormModel.Tabs;
            if (null == tabs || tabs.Count == 0 || null == tabs[0].tabContrl || tabs[0].tabContrl.XTabPages.Count < 2)
            {
                return null;
            }
            XTabPage xtab = tabs[0].tabContrl.XTabPages[1];
            return xtab.PageControl as SpltPrescriptionView;
        }

        /// <summary>
        /// 获取费用清单视图对象
        /// </summary>
        /// <returns>费用清单视图对象</returns>
        protected OrdFeeBillView getOrderFeeBillControl()
        {
            List<ControlTab> tabs = this.GetXapFormControl().FormModel.Tabs;
            if (null == tabs || tabs.Count == 0 || null == tabs[0].tabContrl || tabs[0].tabContrl.XTabPages.Count < 3)
            {
                return null;
            }
            XTabPage xtab = tabs[0].tabContrl.XTabPages[2];
            return xtab.PageControl as OrdFeeBillView;
        }

        protected void setVisiblePageControl(int index)
        {
            List<ControlTab> tabs = this.GetXapFormControl().FormModel.Tabs;

            if (index >= 0 && index < tabs[0].tabContrl.XTabPages.Count)
                tabs[0].tabContrl.SelectedIndex = index;
        }
        #endregion

        #region 医嘱操作
        /// <summary>
        /// 获取选中医嘱
        /// </summary>
        /// <param name="mode"></param>
        /// <returns></returns>
        private CiOrderDO[] getOrdersSelect(OrderExecMode mode)
        {
            CiOrderDO[] orders = this.GetXapFormControl().GetSelected<CiOrderDO>();
            if (orders == null || orders.Length == 0)
            {
                string str = "";
                switch (mode)
                {
                    case OrderExecMode.Delete:
                        str = "删除";
                        break;
                    case OrderExecMode.Copy:
                        str = "复制";
                        break;
                    case OrderExecMode.Sign:
                        str = "签署";
                        break;
                    case OrderExecMode.Revert:
                        str = "撤回";
                        break;
                    case OrderExecMode.Cancel:
                        str = "作废";
                        break;
                    case OrderExecMode.ToMr:
                        str = "同步到病历";
                        break;
                    case OrderExecMode.SaveAs:
                        str = "另存";
                        break;
                    default:
                        str = "操作";
                        break;
                }
                BizAssMessageBoxUtil.ShowInforMsg("请选择需要" + str + "的处置!");
                return null;
            }
            return orders;
        }

        /// <summary>
        /// 获取当前点选医嘱
        /// </summary>
        /// <returns></returns>
        private CiOrderDO getCurrCiOrderDO()
        {
            CiOrderDO order = this.GetXapFormControl().GetGridView("order").GetFocusedRow<CiOrderDO>();

            return order;
        }

        /// <summary>
        /// 获取界面所有医嘱
        /// </summary>
        /// <returns></returns>
        private CiOrderDO[] getAllCiOrderDO()
        {
            return (this.viewModel.GetTableDataSource() as XapDataList<CiOrderDO>).ToArray();
        }

        #region 删除
        /// <summary>
        /// 执行医嘱删除
        /// </summary>
        private void delete()
        {
            CiOrderDO[] orders = getOrdersSelect(OrderExecMode.Delete);
            if (orders == null)
            {
                return;
            }

            this.toDeleteOrders(orders);
        }
        /// <summary>
        /// 删除当前医嘱
        /// </summary>
        private void deleteCurrOrder()
        {
            CiOrderDO order = getCurrCiOrderDO();
            if (order == null)
            {
                return;
            }

            this.toDeleteOrders(new CiOrderDO[] { order });
        }
        /// <summary>
        /// 删除全部医嘱
        /// </summary>
        private void deleteAllOrders()
        {
            CiOrderDO[] orders = getAllCiOrderDO();
            if (orders == null)
            {
                return;
            }

            this.toDeleteOrders(orders);
        }
        /// <summary>
        /// 根据操作模式执行删除：删除、删除撤回、删除作废
        /// </summary>
        /// <param name="orders"></param>
        private void toDeleteOrders(CiOrderDO[] orders)
        {
            if (CiEnContextUtil.IsHeComInsurAllowedAccountPat(this.ent4BannerDTO))
            {
                // 商保记账患者：开立医嘱-删除；已记账医嘱-销账
                this.deleteHighBusinessInsurance(orders);
            }
            else
            {
                if ("01".Equals(strParam))
                {
                    this.deleteRevertOrders(orders);
                }
                else if ("11".Equals(strParam))
                {
                    this.deleteCancelOrders(orders);
                }
                else
                {
                    this.deleteOrders(orders);
                }
            }
        }

        /// <summary>
        /// 删除医嘱
        /// </summary>
        /// <param name="orders"></param>
        private void deleteOrders(CiOrderDO[] orders)
        {
            toExecDeleteOrders(orders);
        }
        /// <summary>
        /// 删除撤回医嘱
        /// </summary>
        /// <param name="orders"></param>
        private void deleteRevertOrders(CiOrderDO[] orders)
        {
            // 调用医疗单代理，是否存在已经打开的医嘱
            if (OnDelegateOrdAction != null)
            {
                int nState = OnDelegateOrdAction(orders, EventCodeType.EVENT_ORDLIST_DELETEORDER, null);

                // 代理没有判断提示
                if (nState == 2)
                {
                    if (!BizAssMessageBoxUtil.ShowConfirmMsg("提示", "是否确定【删除】医嘱？"))
                    {
                        return;
                    }
                }
                // 代理判断了，不能删除
                else if (nState == 0)
                {
                    return; // 代理执行结果不允许删除医嘱
                }
            }

            // 获取开立未签署的医嘱列表（当前医生开立）
            var orderlistdelete = orders.Where(ord => (ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();
            var orderlistRevert = orders.Where(ord => ord.Sd_su_or == CiDictCodeConst.SD_SU_SIGN && ord.Sd_su_mp == CiDictCodeConst.SD_SU_MP_NONE && ord.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE
                && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();

            if (orderlistdelete.Count > 0 || orderlistRevert.Count > 0)
            {
                if (this.viewModel.DeleteRevertOrders(orderlistdelete.ToArray(), orderlistRevert.ToArray()))
                {
                    if (opOrSysncro2MrHandleMode == 0)
                    {
                        this.fireCiOrderFlush2mrEvent(new CiOrderDO[0]);
                    }

                    this.RefreshViews();
                    this.SetStatusMsg("医嘱删除成功！");
                }
            }
            else
            {
                BizAssMessageBoxUtil.ShowInforMsg("没有符合操作的数据，请刷新列表！");
            }
        }
        /// <summary>
        /// 删除作废医嘱
        /// </summary>
        /// <param name="orders"></param>
        private void deleteCancelOrders(CiOrderDO[] orders)
        {
            // 调用医疗单代理，是否存在已经打开的医嘱
            if (OnDelegateOrdAction != null)
            {
                int nState = OnDelegateOrdAction(orders, EventCodeType.EVENT_ORDLIST_DELETEORDER, null);

                // 代理没有判断提示
                if (nState == 2)
                {
                    if (!BizAssMessageBoxUtil.ShowConfirmMsg("提示", "是否确定【删除】医嘱？"))
                    {
                        return;
                    }
                }
                // 代理判断了，不能删除
                else if (nState == 0)
                {
                    return; // 代理执行结果不允许删除医嘱
                }
            }

            // 获取开立未签署的医嘱列表（当前医生开立）
            var orderlistdelete = orders.Where(ord => (ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();
            var orderlistCancel = orders.Where(ord => ord.Fg_sign == true && ord.Fg_canc == false && ord.Fg_uncancelable == false
                && (ord.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE || ord.Sd_su_bl == CiDictCodeConst.SD_SU_BL_REFOUND) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();

            if (orderlistdelete.Count > 0 || orderlistCancel.Count > 0)
            {
                if (this.viewModel.DeleteCancelOrders(orderlistdelete.ToArray(), orderlistCancel.ToArray()))
                {
                    if (opOrSysncro2MrHandleMode == 0)
                    {
                        this.fireCiOrderFlush2mrEvent(new CiOrderDO[0]);
                    }

                    this.RefreshViews();
                    this.SetStatusMsg("医嘱删除成功！");
                }
            }
            else
            {
                BizAssMessageBoxUtil.ShowInforMsg("没有符合操作的数据，请刷新列表！");
            }
        }

        /// <summary>
        /// 高端商保删除
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        private void deleteHighBusinessInsurance(CiOrderDO[] orders)
        {
            // 当前医生开立医嘱集合（删除逻辑）
            List<CiOrderDO> orderlistdelete =
                orders.Where(ord => ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();
            // 当前医生已签署、可退费医嘱集合（销账逻辑）
            List<CiOrderDO> orderlistfee =
               orders.Where(ord => ord.Fg_sign == true && ord.Fg_feertnable == true && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();

            if (orderlistdelete.Count > 0 || orderlistfee.Count > 0)
            {
                if (!BizAssMessageBoxUtil.ShowConfirmMsg("提示", "是否确定【删除】医嘱？"))
                {
                    return;
                }

                // 记账状态处置进行销账，销账后医嘱列表不显示
                if (orderlistfee.Count > 0)
                {
                    List<String> lstIds = new List<string>();
                    orderlistfee.ForEach(order => { lstIds.Add(order.Id_or); });
                    string msg = this.viewModel.SetOrderRefundBillCancelReserve(lstIds.ToArray(), this.Context.PsnInfo.Id_psndoc, this.ent4BannerDTO);
                    this.RefreshViews();
                    this.SetStatusMsg(msg);
                    // 自动同步撤回，进行同步病历，手动时病历保持不变
                    if (opOrSysncro2MrHandleMode == 0)
                    {
                        fireCiOrderFlush2mrEvent(orders);
                    }
                }

                // 开立状态处置进行删除
                if (orderlistdelete.Count > 0)
                {
                    toDelete(orderlistdelete.ToArray());
                }
            }
            else 
            {
                BizAssMessageBoxUtil.ShowInforMsg("没有符合操作的数据，请刷新列表！");
            }
        }
        /// <summary>
        /// 删除给定 id_or 的医嘱
        /// </summary>
        /// <param name="id_or"></param>
        private void deleteOrdersById(String id_or)
        {
            if (String.IsNullOrEmpty(id_or))
            {
                if (BizAssMessageBoxUtil.ShowConfirmMsg("提示", "没有符合操作的数据！是否刷新列表?"))
                {
                    RefreshViews();
                }
                return;
            }

            CiOrderDO order = (this.viewModel.GetTableDataSource() as XapDataList<CiOrderDO>).FirstOrDefault(p => p.Id_or.Equals(id_or));
            if (null == order)
            {
                return;
            }

            toExecDeleteOrders(new CiOrderDO[] { order });
            this.ordSelectedContainer.remove(id_or);
        }
        /// <summary>
        /// 执行删除
        /// </summary>
        /// <param name="orders"></param>
        private void toExecDeleteOrders(CiOrderDO[] orders)
        {
            // 获取开立未签署的医嘱列表（当前医生开立）
            var orderlist = orders.Where(ord => (ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();
            if (orderlist.Count > 0)
            {
                // 调用医疗单代理，是否存在已经打开的医嘱
                if (OnDelegateOrdAction != null)
                {
                    int nState = OnDelegateOrdAction(orderlist.ToArray(), EventCodeType.EVENT_ORDLIST_DELETEORDER, null);

                    // 代理没有判断提示
                    if (nState == 2 && orders.Count() != orderlist.Count())
                    {
                        if (!BizAssMessageBoxUtil.ShowConfirmMsg("提示", "是否确定【删除】医嘱？"))
                        {
                            return;
                        }
                    }
                    // 代理判断了，不能删除
                    else if (nState == 0)
                    {
                        return; // 代理执行结果不允许删除医嘱
                    }
                }

                this.toDelete(orderlist.ToArray());
            }
            else
            {
                BizAssMessageBoxUtil.ShowInforMsg("只能删除当前登录医生开立且未签署的处置！");
            }
        }
        /// <summary>
        /// 删除
        /// </summary>
        /// <param name="szOrders"></param>
        private void toDelete(CiOrderDO[] orders)
        {
            bool isDelSucc = this.viewModel.DeleteOrders(orders);
            if (isDelSucc)
            {
                this.SetStatusMsg("医嘱删除成功！");
                this.RefreshViews();
            }
            else
            {
                this.SetStatusMsg("处置删除失败，请刷新医嘱列表后重试！");
            }
        }
        #endregion

        #region 签署
        /// <summary>
        /// 执行医嘱签署
        /// </summary>
        private bool sign()
        {
            CiOrderDO[] orders = getOrdersSelect(OrderExecMode.Sign);
            if (orders == null)
            {
                return false;
            }

            return signOrders(orders);
        }
        /// <summary>
        /// 签署当前医嘱
        /// </summary>
        /// <returns></returns>
        private bool signCurrOrder()
        {
            CiOrderDO order = getCurrCiOrderDO();
            if (order == null)
            {
                return false;
            }

            return signOrders(new CiOrderDO[] { order });
        }
        /// <summary>
        /// 签署所有医嘱
        /// </summary>
        /// <returns></returns>
        private bool signAllOrders()
        {
            CiOrderDO[] orders = getAllCiOrderDO();
            if (orders == null)
            {
                return false;
            }

            return signOrders(orders);
        }
        /// <summary>
        /// 签署医嘱
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        private bool signOrders(CiOrderDO[] orders)
        {
            // 合理用药处方校验（之校验药品的医嘱）
            RationalDrugView rationalDrugView = RationalDrugViewFactory.GetInstance();
            // 返回false 为存在问题，不继续执行
            bool result = rationalDrugView.AnalysisPresResult(orders);
            if (!result)
            {
                return false;
            }

            // 获取开立未签署的医嘱列表（当前医生开立）

            var orderlist = orders.Where(ord => ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();
            if (orderlist.Count > 0)
            {
                if (orderlist.Count == orders.Length)
                {
                    isSignSuccess = toSign(orderlist.ToArray());
                }
                else
                {
                    // 强制签署，是否需要更严谨的判断
                    if (BizAssMessageBoxUtil.ShowConfirmMsg("提示", "未签署的医嘱才可【签署】！是否继续操作？"))
                    {
                        isSignSuccess = toSign(orderlist.ToArray());
                    }
                }
            }
            else
            {
                BizAssMessageBoxUtil.ShowInforMsg("请选择当前登录医生开立且【未签署】的医嘱项目！");
                return false;
            }
            return isSignSuccess;
        }
        /// <summary>
        /// 调用签署
        /// </summary>
        /// <param name="orders"></param>
        private bool toSign(CiOrderDO[] orders)
        {
            if (OnDelegateOrdAction != null && OnDelegateOrdAction(orders, EventCodeType.EVENT_ACTION_ORDERSUBMIT, null) == 0)
            {
                return false;
            }
            FMap2 map = new FMap2();
            //医保共享验证
            CiEnContextDTO ciEnContextDto = CiEnContextUtil.GetCiEnContext(this.ent4BannerDTO, EmsAppModeEnum.SVEMSAPPMODE, this.Context);//诊断是否保外的
            if (this.ent4BannerDTO != null && ciEnContextDto != null && ciEnContextDto.Eu_hpbeyond == HpBeyondEnum.HPDIAG &&
                !EnDictCodeConst.SD_ENTP_EMERGENCY.Equals(this.ent4BannerDTO.Code_entp) && this.ent4BannerDTO.No_hp != null &&
                this.ent4BannerDTO.Sd_hptp != null && this.ent4BannerDTO.Sd_hptp.StartsWith("1"))
            {
                List<MedicalSharingDTO> list = valiadMedicalSharingInfo(orders);
                if (list != null && list.Count > 0)
                {
                    using (MedicalSharingInfoForm from = new MedicalSharingInfoForm(list))
                    {
                        if (from.ShowDialog() == DialogResult.OK)
                        {
                            String id_orsrv = "";
                            foreach (MedicalSharingDTO medicaldto in list)
                            {
                                id_orsrv += "" + medicaldto.Id_orsrv + ",";
                            }

                            map.Add("MedicalSharingDTO", id_orsrv);
                        }
                        else
                        {
                            return false;
                        }
                    }
                }
            }



            if (this.viewModel.SignOrders(orders, this.ent4BannerDTO,map))
            {
                this.RefreshViews();
                this.SetStatusMsg("医嘱签署成功！");
                return true;
            }
            else
            {
                this.SetStatusMsg("医嘱签署失败！");
            }
            return false;
        }


        private List<MedicalSharingDTO> valiadMedicalSharingInfo(CiOrderDO[] orders)
        {
            MedicalSharingDTO[] medical = viewModel.getOPenOrdder(orders, this.ent4BannerDTO);
            if (medical != null && medical.Count() > 0)
            {
                return MedicalSharingDateRule.MedicalSharingValidate(this.Context, medical, this.ent4BannerDTO);
            }
            else
            {
                return null;
            }

        }
        #endregion

        #region 撤回
        /// <summary>
        /// 执行医嘱撤回
        /// </summary>
        private void revert()
        {
            CiOrderDO[] orders = getOrdersSelect(OrderExecMode.Revert);
            if (orders == null)
            {
                return;
            }

            revertOrders(orders);
        }
        /// <summary>
        /// 撤回当前医嘱
        /// </summary>
        private void revertCurrOrder()
        {
            CiOrderDO order = getCurrCiOrderDO();
            if (order == null)
            {
                return;
            }

            revertOrders(new CiOrderDO[] { order });
        }
        /// <summary>
        /// 撤回全部医嘱
        /// </summary>
        private void revertAllOrders()
        {
            CiOrderDO[] orders = getAllCiOrderDO();
            if (orders == null)
            {
                return;
            }

            revertOrders(orders);
        }
        /// <summary>
        /// 撤回医嘱
        /// </summary>
        /// <param name="orders"></param>
        private void revertOrders(CiOrderDO[] orders)
        {
            var orderlist = orders.Where(ord => ord.Sd_su_or != CiDictCodeConst.SD_SU_OPEN && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();
            if (orderlist.Count > 0)
            {
                string msg = "";
                foreach (CiOrderDO ord in orderlist)
                {
                    if (ord.Id_emp_sign != this.Context.PsnInfo.Id_psndoc)
                    {
                        msg += ord.Name_or + "\n";
                    }
                }
                if (msg.Length > 0)
                {
                    BizAssMessageBoxUtil.ShowInforMsg(msg + " 不是本人签署，不可撤回！");
                    return;
                }
            }
            else
            {
                BizAssMessageBoxUtil.ShowInforMsg("请选择当前登录医生开立且【已签署】的医嘱项目！");
                return;
            }

            if (OnDelegateOrdAction != null && OnDelegateOrdAction(orderlist.ToArray(), EventCodeType.EVENT_ACTION_REVETSUBMIT, null) == 0)
            {
                return;
            }

            if (this.viewModel.RevertOrders(orderlist.ToArray()))
            {
                // 手动同步模式，处置撤回不重新同步病历
                if (opOrSysncro2MrHandleMode == 0)
                {
                    this.fireCiOrderFlush2mrEvent(new CiOrderDO[0]);
                }

                this.RefreshViews();
                this.SetStatusMsg("医嘱撤销成功！");
            }
        }
        #endregion

        #region 作废
        /// <summary>
        /// 执行医嘱作废
        /// </summary>
        private void cancel()
        {
            CiOrderDO[] orders = getOrdersSelect(OrderExecMode.Cancel);
            if (orders == null)
            {
                return;
            }

            cancelOrders(orders);
        }
        /// <summary>
        /// 当前医嘱作废
        /// </summary>
        private void cancelCurrOrder()
        {
            CiOrderDO order = getCurrCiOrderDO();
            if (order == null)
            {
                return;
            }

            cancelOrders(new CiOrderDO[] { order });
        }
        /// <summary>
        /// 全部医嘱作废
        /// </summary>
        private void cancelAllOrders()
        {
            CiOrderDO[] orders = getAllCiOrderDO();
            if (orders == null)
            {
                return;
            }

            cancelOrders(orders);
        }
        /// <summary>
        /// 医嘱作废
        /// </summary>
        /// <param name="orders"></param>
        private void cancelOrders(CiOrderDO[] orders)
        {
            var orderlist = orders.Where(ord => ord.Sd_su_or != CiDictCodeConst.SD_SU_OPEN && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();
            if (orderlist.Count > 0)
            {
                string msg = "";
                foreach (CiOrderDO ord in orderlist)
                {
                    if (ord.Id_emp_sign != this.Context.PsnInfo.Id_psndoc)
                    {
                        msg += ord.Name_or + "\n";
                    }
                }
                if (msg.Length > 0)
                {
                    BizAssMessageBoxUtil.ShowInforMsg(msg + " 不是本人签署，不可作废！");
                    return;
                }
            }
            else
            {
                BizAssMessageBoxUtil.ShowInforMsg("请选择当前登录医生开立且【已签署】的医嘱项目！");
                return;
            }

            if (OnDelegateOrdAction != null && OnDelegateOrdAction(orderlist.ToArray(), OpActionConstant.OP_ORDER_CANCEL_ACTION, null) == 0)
            {
                return;
            }

            if (this.viewModel.CancelOrders(orderlist.ToArray()))
            {
                if (opOrSysncro2MrHandleMode == 0)
                {
                    this.fireCiOrderFlush2mrEvent(new CiOrderDO[0]);
                }

                this.RefreshViews();
                this.SetStatusMsg("医嘱作废成功！");
            }
        }
        #endregion

        #region 作废复制
        /// <summary>
        /// 执行医嘱作废复制
        /// </summary>
        private void cancelCopy()
        {
            CiOrderDO[] orders = getOrdersSelect(OrderExecMode.Cancel);
            if (orders == null)
            {
                return;
            }

            cancelCopyOrders(orders);
        }
        /// <summary>
        /// 当前医嘱作废复制
        /// </summary>
        private void cancelCopyCurrOrder()
        {
            CiOrderDO order = getCurrCiOrderDO();
            if (order == null)
            {
                return;
            }

            cancelCopyOrders(new CiOrderDO[] { order });
        }
        /// <summary>
        /// 全部医嘱作废复制
        /// </summary>
        private void cancelCopyAllOrders()
        {
            CiOrderDO[] orders = getAllCiOrderDO();
            if (orders == null)
            {
                return ;
            }

            cancelCopyOrders(orders);
        }
        /// <summary>
        /// 医嘱作废复制
        /// </summary>
        /// <param name="orders"></param>
        private void cancelCopyOrders(CiOrderDO[] orders)
        {
            var orderlist = orders.Where(ord => ord.Sd_su_or != CiDictCodeConst.SD_SU_OPEN && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();
            if (orderlist.Count > 0)
            {
                string msg = "";
                foreach (CiOrderDO ord in orderlist)
                {
                    if (ord.Id_emp_sign != this.Context.PsnInfo.Id_psndoc)
                    {
                        msg += ord.Name_or + "\n";
                    }
                }
                if (msg.Length > 0)
                {
                    BizAssMessageBoxUtil.ShowInforMsg(msg + " 不是本人签署，不可作废！");
                    return;
                }
            }
            else
            {
                BizAssMessageBoxUtil.ShowInforMsg("请选择当前登录医生开立且【已签署】的医嘱项目！");
                return;
            }

            if (OnDelegateOrdAction != null && OnDelegateOrdAction(orderlist.ToArray(), EventCodeType.EVENT_ACTION_REVETSUBMIT, null) == 0)
            {
                return;
            }

            if (this.viewModel.CancelCopyOrders(orderlist.ToArray()))
            {
                if (opOrSysncro2MrHandleMode == 0)
                {
                    this.fireCiOrderFlush2mrEvent(new CiOrderDO[0]);
                }

                this.RefreshViews();
                this.SetStatusMsg("医嘱撤回成功！");
            }
        }
        #endregion

        #region 重新分方
        /// <summary>
        /// 重新分方调用签署
        /// </summary>
        private void signforPres()
        {
            if (this.ent4BannerDTO != null && this.ent4BannerDTO.Id_ent != null)
            {
                CiOrderDO[] orders = this.viewModel.GetCiOrderDOsDrug(this.ent4BannerDTO);
                if (orders != null && orders.Length > 0)
                {
                    FMap2 map = new FMap2();
                    this.viewModel.SignOrders(orders, this.ent4BannerDTO,map);

                    if (this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpOrSysncro2MrHandleMode) == 0)
                    {
                        this.fireCiOrderFlush2mrEvent(this.viewModel.ordersSign);
                    }
                }
            }
        }
        /// <summary>
        /// 重新分方
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="id_dep_sign"></param>
        /// <param name="sd_entp"></param>
        /// <returns></returns>
        private bool repeatPres(string id_ent, string id_dep_sign, string sd_entp)
        {
            try
            {
                this.viewModel.RepeatPres(id_ent, id_dep_sign, sd_entp, this.ent4BannerDTO);
                return true;
            }
            catch (XapBizException e)
            {
                BizAssMessageBoxUtil.ShowInforMsg(e.Message);
            }
            return false;
        }
        #endregion

        #region 另存为
        /// <summary>
        /// 医嘱另存为模板
        /// </summary>
        private void saveAs()
        {
            CiOrderDO[] orders = getOrdersSelect(OrderExecMode.SaveAs);
            if (orders == null)
            {
                return;
            }

            saveAsOrders(orders);
        }
        /// <summary>
        /// 全部医嘱另存为模板
        /// </summary>
        private void saveAsAllOrders()
        {
            CiOrderDO[] orders = getAllCiOrderDO();
            if (orders == null)
            {
                return;
            }

            saveAsOrders(orders);
        }
        /// <summary>
        /// 医嘱另存为模板
        /// </summary>
        /// <param name="orders"></param>
        private void saveAsOrders(CiOrderDO[] orders)
        {
            var lstIDs = new List<string>();
            orders.ToList().ForEach(p => { lstIDs.Add(p.Id_or); });
            var args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, "SaveAsOrdEvent");
            FireEventSent(lstIDs.ToArray(), args);
        }
        #endregion

        #region 打印
        /// <summary>
        /// 执行打印操作
        /// </summary>
        private void toPrint(bool isComplete, bool isPres)
        {
            if (this.ent4BannerDTO == null || String.IsNullOrEmpty(this.ent4BannerDTO.Id_ent)) return;

            //选中页签
            //int selectedIndex = isComplete ? 0 : (isPres ? 1 : this.GetXapFormControl().FormModel.Tabs[0].tabContrl.SelectedIndex);
            int selectedIndex = isComplete ? 0 : (isPres ? 1 : 0);
            List<String> lstIdors = new List<string>();
            List<String> lstIdpres = new List<string>();
            switch (selectedIndex)
            {
                case 0:
                    this.GetXapFormControl().GetSelected<CiOrderDO>("order").ToList<CiOrderDO>().ForEach(order =>
                    {
                        if (!order.Sd_su_or.Equals(CiDictCodeConst.SD_SU_OPEN))
                        {
                            lstIdors.Add(order.Id_or);
                        }
                    });
                    break;
                case 1:
                    if (this.getOrderPresControl() != null && this.getOrderPresControl().GetAllOrdPresDTOs() != null)
                    {
                        this.getOrderPresControl().GetAllOrdPresDTOs().ToList<OrdPresDTO>().ForEach(dto =>
                        {
                            lstIdpres.Add(dto.Id_pres);
                        });
                    }
                    break;
                case 2:
                    CiOrdFeeSrvDTO[] allbilldtos = (getOrderFeeBillControl().GetModel().GetTableDataSource() as XapDataList<CiOrdFeeSrvDTO>).ToArray();
                    foreach (CiOrdFeeSrvDTO billdo in allbilldtos)
                    {
                        if (!lstIdors.Contains(billdo.Id_or))
                            lstIdors.Add(billdo.Id_or);
                    }
                    break;
            }
            if (selectedIndex == 0)
            {
                if(lstIdors.Count <= 0)
                {
                    BizAssMessageBoxUtil.ShowInforMsg("未选择需要打印的已签署处置！");
                    return;
                }
                else if(this.viewModel.IsAllOrsBlRefound(lstIdors.ToArray()))
                {
                    BizAssMessageBoxUtil.ShowInforMsg("已退费的医嘱不可打印！");
                    return;
                }
            }

            if (isPres && lstIdpres.Count <= 0)
            {
                BizAssMessageBoxUtil.ShowInforMsg("没有需要打印的处方信息！");
                return;
            }

            // 打印管理对话框
            using (var dialog = new PrintManageDialog(selectedIndex, lstIdors, lstIdpres, this, this.ent4BannerDTO.Id_hp, this.ent4BannerDTO.Sd_hptp, true))
            {
                dialog.Dock = DockStyle.Fill;
                dialog.Formsize = FormSize.Custom;
                dialog.Size = new Size(842, 1200);
                dialog.Closed += PrintManageDialog_Closed;
                dialog.ShowDialog();
            }
        }
        /// <summary>
        /// 打印管理界面关闭发送事件（更新打印数据打印次数）
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void PrintManageDialog_Closed(object sender, EventArgs e)
        {
            var args = new DictionaryEventArgs();
            var dic = new Dictionary<string, object>();
            dic.Add(OpOperateActionEvent.PRINT_COMPLETE, null);
            args.Data.Add(UIConst.UI_EVENT, OpOperateActionEvent.PRINT_COMPLETE);
            args.Data.Add(UIConst.DATA, dic);
            FireEventSent(this, args);
        }
        #endregion

        /// <summary>
        /// 手动将已处置未同步到病历的处置 同步到病历中
        /// </summary>
        private void flushOrders2Mr()
        {
            CiOrderDO[] orders = getOrdersSelect(OrderExecMode.ToMr);
            if (orders == null)
            {
                return;
            }
            var flushlist = new List<CiOrderDO>();
            Boolean isOther = false;
            string signName = "[";
            foreach (CiOrderDO ciord in orders)
            {
                if (ciord.Id_emp_sign != null & ciord.Id_emp_sign != this.Context.PsnInfo.Id_psndoc)
                {
                    isOther = true;
                    if (!signName.Contains(ciord.Emp_sign_name)) signName += ciord.Emp_sign_name + ",";
                }
                if ((bool)ciord.Fg_sign) flushlist.Add(ciord);
            }
            if (signName.Length > 1) signName = signName.Substring(0, signName.Length - 1) + "]";
            if (flushlist.Count == 0)
            {
                BizAssMessageBoxUtil.ShowInforMsg("没有符合操作的数据");
            }
            else 
            {
                if (flushlist.Count != orders.Length)
                {
                    if (BizAssMessageBoxUtil.ShowConfirmMsg("提示", "只有符合操作的处置才可被刷新到病历，是否继续操作？"))
                    {
                        if (isOther)
                        {
                            if (BizAssMessageBoxUtil.ShowConfirmMsg("提示", "当前同步操作包含" + signName + "医生签署的处置,是否继续同步？"))
                            {
                                fireCiOrderFlush2mrEvent(orders);
                            }
                        }
                        else
                        {
                            fireCiOrderFlush2mrEvent(orders);
                        }
                    }
                }
                else
                {
                    if (isOther)
                    {
                        if (BizAssMessageBoxUtil.ShowConfirmMsg("提示", "当前同步操作包含" + signName + "医生签署的处置,是否继续同步？"))
                        {
                            fireCiOrderFlush2mrEvent(orders);
                        }
                    }
                    else
                    {
                        fireCiOrderFlush2mrEvent(orders);
                    }
                }
            }
        }

        private void sendAction(String strCommand, object sender)
        {
            Dictionary<string, object> dataDic = new Dictionary<string, object>();
            dataDic.Add(strCommand, null);

            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, strCommand);
            args.Data.Add(UIConst.DATA, dataDic);
            this.FireEventSent(sender, args);
        }
        #endregion

        /// <summary>
        /// 医保共享数据,社保时调用
        /// </summary>
        private void handleMedicalShared()
        {
            if (this.viewModel == null)
            {
                this.viewModel = new OrdGridViewModel();
                this.viewModel.SetContext(this.Context);
            }
             //科室是否启用医保
            FBoolean isDept = this.viewModel.GetIsDeptOrDatumshared(Context.Org.Id_org, Context.Dept.Id_dep);
            if (isDept)
            {
                String errMsg = "";
                GetMedicalsharingData.Instance.getMedicalsharingData(this.ent4BannerDTO, Context, out errMsg, "");
                this.viewModel.GetDictbdHpUnlimitDrug(this.ent4BannerDTO.Id_hp);
                this.viewModel.getcodeHpkind(this.ent4BannerDTO.Id_ent);
            }

            //本院的数据
             this.viewModel.getMedicalSharingDTO(this.ent4BannerDTO);

        }

        /// <summary>
        /// 预付费（预交金记账）
        /// </summary>
        private void openPreCalcFeeView()
        {
            if (xap.cli.context.events.XapEvents.OpenFuncEvent != null)
            {
                var device = DevicePoller.Instance;
                var dentCard = device.ReadIdentCard();

                if (dentCard == null)
                {
                    return;
                }

                if (!this.ent4BannerDTO.Sd_idtp.Equals("01") || string.IsNullOrEmpty(this.ent4BannerDTO.Id_code))
                {

                    BizAssMessageBoxUtil.ShowWarningMsg("患者未使用身份证进行注册！");
                    return;
                }

                if (!this.ent4BannerDTO.Id_code.Equals(dentCard.Identity))
                {
                    BizAssMessageBoxUtil.ShowWarningMsg("当前身份证号与患者注册的身份证号不匹配！");
                    return;
                }

                string id_psndoc = this.Context.PsnInfo.Id_psndoc;
                string msg = this.viewModel.OrderKeepAccounts(this.ent4BannerDTO.Id_ent, this.ent4BannerDTO.Code_entp, "1", id_psndoc);
                this.SetStatusMsg(msg);
                AssToolEx.SentMessage(this, AssToolEx.DictionaryEventArgsWith(ACTION_ORDERLIST_REFRESH));
            }
        }

        /// <summary>
        /// 取消记账
        /// </summary>
        private void openPreCancelFeeView()
        {
            if (xap.cli.context.events.XapEvents.OpenFuncEvent != null)
            {
                if (BizAssMessageBoxUtil.ShowConfirmMsg("确认进行取消预付费操作？") == FBoolean.True)
                {
                    string id_psndoc = this.Context.PsnInfo.Id_psndoc;

                    string msg = this.viewModel.CancelOrderAccounting(this.ent4BannerDTO.Id_ent, this.ent4BannerDTO.Code_entp, id_psndoc);
                    this.SetStatusMsg(msg);
                    // 手动同步模式，处置撤回不重新同步病历
                    if (opOrSysncro2MrHandleMode == 0)
                    {
                        fireCiOrderFlush2mrEvent(new CiOrderDO[0]);
                    }
                }
            }
        }

        /// <summary>
        /// 判断是否存在医嘱
        /// </summary>
        /// <returns></returns>
        public bool IsOrdersEmpty()
        {
            return orderGridControl.DataTable.Rows.Count <= 0;
        }
        #endregion

        #region 状态处理区域
        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            OnEventHandle(sender, eventArgs);
        }
        private int strSignAction = 0;//签署操作类型
        public override bool OnEventHandle(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = AssToolEx.EventCodeOfEventArgs(eventArgs);

            switch (uiEvent)
            {
                #region 初始加载
                case UIEvent.LOAD:
                    if (this.Context != null)
                    {
                        //读取系统参数（已签署医嘱操作模式），控制按钮可见性
                        //strParam = this.Context.GetOrgParam<string>(ICiOrdNSysParamConst.SYS_PARAM_OpSignedOrExecMode);
                        strParam = SysParamUtils.getSysParam().SYS_PARAM_OpSignedOrExecMode.OrgParam;
                        //strParam = "11";
                        var args = new DictionaryEventArgs();
                        var dic = new Dictionary<string, object>();
                        dic.Add(OpActionConstant.OP_CANCEL_REVERT_VISIBLE_ACTION, strParam);
                        args.Data.Add(UIConst.UI_EVENT, OpActionConstant.OP_CANCEL_REVERT_VISIBLE_ACTION);
                        args.Data.Add(UIConst.DATA, dic);
                        FireEventSent(this, args);
                    }
                    break;
                #endregion
                #region 医嘱模板
                case EventCodeType.EVENT_EMS_TMPL_EDIT:
                case EventCodeType.EVENT_EMS_MEDTECH_EDIT:
                case EventCodeType.EVENT_OPSTATION_REFRESH:
                case EventCodeType.EVENT_EMS_SAVESUCCESS:
                case EventCodeType.EVENT_HOTKEY_ORLIST_REFRESH:
                    // 医嘱保存相关逻辑
                    if (OpActionConstant.OP_REFRESH_ALL_ACTION.Equals(uiEvent))// 门诊刷新
                    {
                        ordSelectedContainer.clear();
                        //AssToolEx.ObjectOfEventArgs(eventArgs, EventCodeType.ARGKEY_EMS_TMPL_EDIT);
                    }
                    // 医嘱模板和医技常规保存的医嘱，在列表中选中
                    if (uiEvent.Equals(EventCodeType.EVENT_EMS_TMPL_EDIT) ||
                        uiEvent.Equals(EventCodeType.EVENT_EMS_MEDTECH_EDIT))
                    {                        
                        var obj = AssToolEx.ObjectOfEventArgs(eventArgs, EventCodeType.ARGKEY_EMS_TMPL_EDIT) as MoreEmsParamDTO;
                        if (obj != null && obj.Ordermap2 != null && obj.Ordermap2.Keys.Count > 0)
                        {
                            var orders = obj.Ordermap2["orders"] as FArrayList2;
                            if (orders != null && orders.Count > 0)
                            {
                                // 将即将被选中的医嘱id放入待选中集合中
                                orders.Cast<CiOrderDO>().ToList().ForEach(p => { ordSelectedContainer.add(p.Id_or); });
                            }
                        }
                    }

                    RefreshViews();
                    break;
                #endregion
                #region 医嘱保存成功
                case UIEvent.SAVE_SUCCESS:
                    object id_or_save = AssToolEx.ObjectOfEventArgs(eventArgs, "ID_OR");
                    if (id_or_save != null)
                    {
                        ordSelectedContainer.add(id_or_save.ToString());
                    }
                    if (Created)
                    {
                        this.LoadData();
                    }
                    this.SetStatusMsg("医嘱保存成功！");
                    break;
                #endregion
                #region 签署
                case EventCodeType.EVENT_ACTION_ORDERSUBMIT:
                    // 调用签署逻辑
                    strSignAction = 0;
                    sendAction(OpActionConstant.OP_DI_CHECK_OR_SIGN_ACTION, null);//签署医嘱校验诊断是否为空
                    break;
                case OpActionConstant.OpCurrOrderSignAction:
                    // 调用当前签署逻辑
                    strSignAction = 1;
                    sendAction(OpActionConstant.OP_DI_CHECK_OR_SIGN_ACTION, null);//签署医嘱校验诊断是否为空
                    break;
                case OpActionConstant.OpAllOrderSignAction:
                    // 调用全部签署逻辑
                    strSignAction = 2;
                    sendAction(OpActionConstant.OP_DI_CHECK_OR_SIGN_ACTION, null);//签署医嘱校验诊断是否为空
                    break;
                case OpActionConstant.OP_DI_RESPONSE_SEND_OR_SIGN_ACTION:
                    // 诊断不为空，继续签署医嘱
                    if (strSignAction == 0)
                    {
                        this.sign();
                    }
                    else if (strSignAction == 1)
                    {
                        this.signCurrOrder();
                    }
                    else if (strSignAction == 2)
                    {
                        this.signAllOrders();
                    }
                    break;
                #endregion
                #region 撤回
                case EventCodeType.EVENT_ACTION_REVETSUBMIT:
                    // 调用撤回逻辑
                    this.revert();
                    break;
                case OpActionConstant.OpCurrOrderRevertAction:
                    // 调用当前撤回逻辑
                    this.revertCurrOrder();
                    break;
                case OpActionConstant.OpAllOrderRevertAction:
                    // 调用全部撤回逻辑
                    this.revertAllOrders();
                    break;
                #endregion
                #region 作废
                case OpActionConstant.OP_ORDER_CANCEL_ACTION:
                    // 调用作废逻辑
                    this.cancel();
                    break;
                case OpActionConstant.OpCurrOrderCancelAction:
                    // 调用作废逻辑
                    this.cancelCurrOrder();
                    break;
                case OpActionConstant.OpAllOrderCancelAction:
                    // 调用作废逻辑
                    this.cancelAllOrders();
                    break;
                #endregion
                #region 作废复制
                case OpActionConstant.OP_ORDER_CANCELCOPY_ACTION:
                    // 调用作废复制（撤回）逻辑
                    this.cancelCopy();
                    break;
                case OpActionConstant.OpCurrOrderCancelCopyAction:
                    // 调用作废复制（撤回）逻辑
                    this.cancelCopyCurrOrder();
                    break;
                case OpActionConstant.OpAllOrderCancelCopyAction:
                    // 调用作废复制（撤回）逻辑
                    this.cancelCopyAllOrders();
                    break;
                #endregion
                #region 删除
                case UIEvent.DELETE:
                    // 调用删除医嘱逻辑
                    this.delete();
                    break;
                case OpActionConstant.OpCurrOrderDeleteAction:
                    // 调用删除当前医嘱逻辑
                    this.deleteCurrOrder();
                    break;
                case OpActionConstant.OpAllOrderDeleteAction:
                    // 调用删除全部医嘱逻辑
                    this.deleteAllOrders();
                    break;
                case EventCodeType.EVENT_ORDLIST_DELETEORDER:
                    // 开立状态时，通过医疗单打开并在医疗单中删除时触发
                    var id_or_delete = AssToolEx.ObjectOfEventArgs(eventArgs, EventCodeType.ARGKEY_DELETEORDER) as String;
                    this.deleteOrdersById(id_or_delete);
                    break;
                #endregion
                #region 另存为
                case EventCodeType.EVENT_ACTION_ORDERSAVEAS:
                    // 调用另存为逻辑
                    this.saveAs();
                    break;
                case OpActionConstant.OpAllOrderSaveasAction:
                    this.saveAsAllOrders();
                    break;
                #endregion
                #region 重新分方
                case EventCodeType.EVENT_EMS_AGAIN_PRES:
                    this.signforPres();
                    if (this.repeatPres(this.ent4BannerDTO.Id_ent, Context.PsnInfo.Id_psndoc, this.ent4BannerDTO.Code_entp))
                    {
                        if (getOrderFeeBillControl() != null)
                        {
                            getOrderFeeBillControl().LoadData();
                        }
                        if (getOrderPresControl() != null)
                        {
                            getOrderPresControl().LoadData();
                            setVisiblePageControl(1);
                        }

                        this.SetStatusMsg("重新分方成功！");
                    }
                    break;
                #endregion
                #region 刷新
                case UIEvent.REFRESH:
                case EventCodeType.EVENT_ORDLIST_SWITCH2ORDLIST:
                    //刷新医嘱列表（刷新、重新分方）
                    this.LoadData();
                    break;
                case EventCodeType.EVENT_EMS_REFRESH:
                    RefreshViews();
                    break;
                case EventCodeType.EVENT_ORDLIST_NEEDVALIDATE:
                    // 设置刷新完毕列表后，需要校验医嘱内容= hums 
                    needValidateOrdList = true;
                    break;
                #endregion
                #region 打印
                case OpActionConstant.OP_PRINT_ACTION:
                    this.toPrint(false, false);
                    break;
                case OpActionConstant.ORD_PRES_PRINT_ACTION:
                    this.toPrint(false, true);
                    break;
                case OpActionConstant.OP_COMPLETE_PRINT_ACTION:
                    this.toPrint(true, false);
                    break;
                #endregion
                #region 医保共享
                case EventCodeType.History_medicalsharing:
                    // 医保共享
                    if (this.ent4BannerDTO != null && this.ent4BannerDTO.Sd_hptp != null && this.ent4BannerDTO.Sd_hptp.StartsWith("1"))
                    {
                        Context["banner"] = this.ent4BannerDTO;
                        using (var form = new HpOrShareFrm(MedicalSharingCache.getMedicalData(this.ent4BannerDTO.No_hp)))
                        {
                            form.Location = new Point(50, 100);
                            form.ShowDialog();
                            this.SetStatusMsg("医保共享数据！");
                        }
                    }
                    break;
                #endregion
                #region 社保时校验获取医保共享数据
                case "BannerSiteClickEvent":
                case "BannerSwitchingUser":
                    if (this.ent4BannerDTO != null)
                    {
                        Context["banner"] = ent4BannerDTO;
                        if (CiEnContextUtil.IsHpPat(ent4BannerDTO))// 社保时校验获取医保共享数据
                        {
                            handleMedicalShared();
                        }
                    }
                    break;
                #endregion
                #region 记账
                case OpActionConstant.OP_PRECALC_FEE_ACTION:
                    //记账
                    this.openPreCalcFeeView();
                    RefreshViews();
                    break;
                #endregion
                #region 取消记账
                case OpActionConstant.OP_PRESCANCEL_FEE_ACTION:
                    //取消记账
                    this.openPreCancelFeeView();
                    // 直接关闭医疗单
                    AssToolEx.SentMessage(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_CLOSE));
                    RefreshViews();
                    break;
                #endregion
                #region 禁用和启用费用清单工具条 -- 后期优化掉
                case EventCodeType.EVENT_FEEBILL_FORBIDEDIT:
                case EventCodeType.EVENT_FEEBILL_ALLOWEDIT:
                    // 处理禁用费用清单工具条
                    XapBaseControl toolBar = GetToolbarControl(getOrderFeeBillControl().GetType().FullName);
                    if (null != toolBar)
                    {
                        toolBar.Enabled = EventCodeType.EVENT_FEEBILL_ALLOWEDIT.Equals(uiEvent);
                    }
                    break;
                #endregion
                #region 诊毕事件
                case OpActionConstant.OP_COMPLETE_OR_SEND_ACTION:
                    if (this.viewModel.IsExistOpenOrders(this.ent4BannerDTO.Id_ent))
                    {
                        if (BizAssMessageBoxUtil.ShowConfirmMsg("提示", "存在医嘱未签署，是否继续？"))
                        {
                            sendAction(OpActionConstant.OP_COMPLETE_OR_RECEIVE_ACTION, sender);
                        }
                    }
                    else
                    {
                        sendAction(OpActionConstant.OP_COMPLETE_OR_RECEIVE_ACTION, sender);
                    }
                    break;
                #endregion
                #region 存在有效医嘱，不能取消接诊
                case OpActionConstant.OP_CI_ORD_SEND_ACTION:
                    //取消接诊，校验医嘱
                    if (this.viewModel.IsExistValidOrders(this.ent4BannerDTO.Id_ent))
                    {
                        BizAssMessageBoxUtil.ShowInforMsg("存在有效医嘱，不能取消接诊！");
                    }
                    else
                    {
                        sendAction(OpActionConstant.OP_CI_ORD_RECEIVE_ACTION, sender);
                    }
                    break;
                #endregion
                #region 基类默认处理
                default:
                    base.HandleState(sender, eventArgs);
                    break;
                #endregion
            }
            return true;
        }
        #endregion

    }

    public enum OrderExecMode
    {
        Load = 1,
        Delete,
        Copy,
        Sign,
        Revert,
        Cancel,
        ToMr,
        SaveAs
    }
}
