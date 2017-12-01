using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.bl.common.hporshareinfoqry2;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.common.log;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.medicaresharing.mdeicalrule;
using iih.ci.ord.moreemsdto.d;
using iih.ci.ord.opemergency.action.costant;
using iih.ci.ord.opemergency.controls;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.dialog;
using iih.ci.ord.opemergency.operateaction.baseoperate;
using iih.ci.ord.opemergency.spltpres;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.view.ordfeebill;
using iih.ci.ord.oporder.view;
using xap.cli.sdk.common;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.controls.navbar;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.form;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.appfw;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.control.basecontrol;
using xap.rui.control.exceptions;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.mw.log;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.dto.ordpres.d;
using xap.rui.devices;
using xap.sys.securityfw.switchdept;
using iih.ci.ord.opemergency.assi.rationaldrug.view;
using iih.ci.ord.common.utils;

namespace iih.ci.ord.opemergency.view
{
    /// <summary>
    ///     <para>描    述 : 门急诊医生工作站-【医嘱列表】视图 </para>
    ///     <para>项目名称 : iih.ci.ord.opemergency.view       </para>
    ///     <para>类 名 称 : OrderListView                       </para>
    ///     <para>版 本 号 : v1.0.0.0                          </para>
    ///     <para>作    者 : qzwang                            </para>
    ///     <para>创建时间 : 2016/6/30 13:50:05                </para>
    ///     <para>修 改 人 :                                   </para>
    ///     <para>更新时间 : 2016/6/30 13:50:05                </para>
    ///     <para>说    明 :                                   </para>
    ///     <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para>
    /// </summary>
    [Obsolete("已过时，请更换到iih.ci.ord.opemergency.orderlist.view.OrdGridView")]
    public class OrdListView : OpOrderItemView
    {
        public delegate int DelegateOrdAction(CiOrderDO[] ord, String evtCode, Object objData);
        public DelegateOrdAction OnDelegateOrdAction;

        #region 常量定义
        /// <summary>
        /// 处置同步到病历事件
        /// </summary>
        private const string CI_ORDER_FLUSH_EVENT = "CiOrderFlush2MrEvent";

        public const String ACTION_FEEBILL_NEW = "ACTION_FEEBILL_NEW";
        public const String ACTION_FEEBILL_DEL = "ACTION_FEEBILL_DEL";
        public const String ACTION_FEEBILL_SAVE = "ACTION_FEEBILL_SAVE";
        public const String ACTION_ORDERLIST_REFRESH = "ACTION_ORDERLIST_REFRESH";

        /// <summary>
        /// 已签署处置同步到病历
        /// </summary>
        public const String ACTION_ORDERLIST_UPDATEEMR = "ACTION_ORDERLIST_UPDATEEMR";

        public const long PCM_OrderMode = 0x0004;
        public const long PCM_PresMode = 0x0002;
        public const long PCM_FeeMode = 0x0001;

        #endregion

        #region 变量定义区域
        private EmsFeesControl emsFeesControl;

        private readonly Dictionary<String, XapBaseControl> toolbarMap = new Dictionary<string, XapBaseControl>();

        private int nSysParamFeeListOprMode = 0;

        private bool needValidateOrdList;
        
        #endregion

        #region 属性控制

        public long PageControlMode { get; set; }

        #endregion

        #region 构造函数区域
        public OrdListView()
        {
            patDo = null;

            // 初始化页面控件显示模式 -- 医嘱模式
            PageControlMode = PCM_OrderMode;
        }

        #endregion

        #region 事件发送区域

        /// <summary>
        ///     处置同步到病历
        /// </summary>
        /// <param name="arg">处置同步到病历</param>
        [EventPublication(CI_ORDER_FLUSH_EVENT)]
        public event EventHandler<DataEventArgs<CiOrderDO[]>> FireCiOrderFlush2mrEvent;
        protected override void fireCiOrderFlush2mrEvent(CiOrderDO[] arg)
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

        protected override void OnLoadData()
        {
            // 读取系统参数
            ReadSysParamFromRemote();

            if (patDo != null)
            {
                if (viewModel == null)
                {
                    viewModel = new OrderItemViewModel(patDo, Context);
                }
                viewModel.Reload(patDo.Id_ent, patDo.Code_entp);
            }
            else
            {
                CiLog4OpStation.WriteLog("开始查询医嘱列表数据时候，发生错误，就诊信息丢失=>OnLoadData");
            }
        }

        protected override void OnFillData()
        {
            var file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_OP_OrdListView; // "20170508071434669000"
            file.FormStyle = FormStyle.Card;
            if (viewModel != null && viewModel.xapList != null)
            {
                file.ViewModel = viewModel.xapList;
            }
            xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(false, new[] { new DataPolicy { MultiSelect = true } });

            // 发送事件给第三方系统，进行医嘱药品校验
            if (needValidateOrdList)
            {
                AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDLIST_DATAVALIDATE, "CiOrderDOList",
                    new List<CiOrderDO>(viewModel.xapList.ToArray()));

                needValidateOrdList = false;
            }
            // 如果没有医嘱，禁用费用清单按钮
            //fillFees();
            //if (medicalInfoCache.getMedicalInfo("Id") != null)
            //{
            //    this.ShowInfo(medicalInfoCache.getMedicalInfo("Id"));
            //    medicalInfoCache.Remove("Id");
            //}
        }

        /// <summary>
        /// 接收消息
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (sender is OrdListView)
                return;

            patDo = null;
            if (e.Object == null || !(e.Object is BannerData) || (e.Object as BannerData).Ent4BannerDTO == null)
            {
                if (null != viewModel)
                {
                    viewModel.Reload(null, null);
                }
                // 切换到初始状态
                xapFormControl1.FormModel.Tabs[0].tabContrl.SelectedIndex = 0;

                // 隐藏所有工具条
                SwitchToolbar("");
                return;
            }

            patDo = (e.Object as BannerData).Ent4BannerDTO;
            if (CiEnContextUtil.IsHpPat(patDo)) {
                handleMedicalShared();
            }
            LoadData();

            SwitchToolbar(GetOrderListControl().GetType().FullName);
        }

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = AssToolEx.EventCodeOfEventArgs(eventArgs);
            if (uiEvent.Equals(UIEvent.LOAD) || uiEvent.Equals("ListSelected"))
                return;
            //刷新医嘱列表 TODO 重新分方时
            if (uiEvent.Equals(EventCodeType.EVENT_ORDLIST_SWITCH2ORDLIST))
            {
                LoadData();
            }
            // 处理打印相关逻辑
            if (uiEvent.Equals(OpActionConstant.OP_PRINT_ACTION))
            {
                this.toPrint(false, false);
            }
            else if (uiEvent.Equals(OpActionConstant.ORD_PRES_PRINT_ACTION))
            {
                this.toPrint(false, true);
            }
            else if (uiEvent.Equals(OpActionConstant.OP_COMPLETE_PRINT_ACTION))
            {
                this.toPrint(true, false);
            }
            else if (uiEvent.Equals(EventCodeType.EVENT_ORDLIST_NEEDVALIDATE))
            {
                // 设置刷新完毕列表后，需要校验医嘱内容= hums 
                needValidateOrdList = true;
            }
            // 医嘱保存相关逻辑
            else if (EventCodeType.EVENT_EMS_TMPL_EDIT.Equals(uiEvent) ||
                     EventCodeType.EVENT_EMS_MEDTECH_EDIT.Equals(uiEvent) ||
                     EventCodeType.EVENT_OPSTATION_REFRESH.Equals(uiEvent) ||
                     EventCodeType.EVENT_EMS_SAVESUCCESS.Equals(uiEvent) ||
                     EventCodeType.EVENT_HOTKEY_ORLIST_REFRESH.Equals(uiEvent))
            {
                if (OpActionConstant.OP_REFRESH_ALL_ACTION.Equals(uiEvent))// 门诊刷新
                {
                    ordSelectedContainer.clear();
                    //AssToolEx.ObjectOfEventArgs(eventArgs, EventCodeType.ARGKEY_EMS_TMPL_EDIT);
                }
                // 医嘱模板和医技常规保存的医嘱，在列表中选中
                if (uiEvent.Equals(EventCodeType.EVENT_EMS_TMPL_EDIT) ||
                    uiEvent.Equals(EventCodeType.EVENT_EMS_MEDTECH_EDIT))
                {
                    ordSelectedContainer.clear();
                    var obj =
                        AssToolEx.ObjectOfEventArgs(eventArgs, EventCodeType.ARGKEY_EMS_TMPL_EDIT) as MoreEmsParamDTO;
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

            }
            // 处理签署撤回逻辑
            else if (uiEvent.Equals(EventCodeType.EVENT_ACTION_REVETSUBMIT))
            {
                // 调用撤回逻辑
                BackOrd();

                // 签署撤回后，需要刷新处方列表以及费用清单列表
                RefreshViews();
            }
            // 处理禁用费用清单工具条
            else if (uiEvent.Equals(EventCodeType.EVENT_FEEBILL_FORBIDEDIT))
            {
                XapBaseControl toolBar = GetToolbarControl(GetOrderFeeBillControl().GetType().FullName);
                if (null != toolBar)
                {
                    toolBar.Enabled = false;
                }
            }
            // 处理允许费用清单工具条逻辑
            else if (uiEvent.Equals(EventCodeType.EVENT_FEEBILL_ALLOWEDIT))
            {
                XapBaseControl toolBar = GetToolbarControl(GetOrderFeeBillControl().GetType().FullName);
                if (null != toolBar)
                {
                    toolBar.Enabled = true;
                }
            }
            // 删除医嘱
            else if (uiEvent.Equals(EventCodeType.EVENT_ORDLIST_DELETEORDER) || uiEvent.Equals(UIEvent.DELETE))
            {
                DelOrd();
            }
            else if (uiEvent.Equals(EventCodeType.EVENT_ORDLIST_DELETEORDER)) // 开立状态时，通过医疗单打开并在医疗单中删除时触发
            {
                var id_or = AssToolEx.ObjectOfEventArgs(eventArgs, EventCodeType.ARGKEY_DELETEORDER) as String;
                DelOrdByIdOr(id_or);
            }
            else if (uiEvent.Equals(EventCodeType.EVENT_EMS_REFRESH))
            {
                RefreshViews();
            }
            else if (uiEvent.Equals(EventCodeType.EVENT_EMS_AGAIN_PRES))
            {
                SignOrSplie();
                if (CiOPAgainPres(patDo.Id_ent, Context.PsnInfo.Id_psndoc, patDo.Code_entp))
                {

                    if (GetOrderFeeBillControl() != null)
                    {
                        GetOrderFeeBillControl().LoadData();
                    }
                    if (GetOrderPresControl() != null)
                    {
                        GetOrderPresControl().LoadData();
                        SetVisiblePageControl(1);
                    }

                    this.SetStatusMsg("重新分方成功！");
                }
            }
            else if (uiEvent.Equals(EventCodeType.History_medicalsharing))// 医保共享
            {
                if (patDo != null && patDo.Sd_hptp != null && patDo.Sd_hptp.StartsWith("1"))
                {
                    Context["banner"] = patDo;
                    // this.patDo.No_hp = "000005397006";//  测试
                    using (var form = new HpOrShareFrm(MedicalSharingCache.getMedicalData(patDo.No_hp)))
                    {
                        form.Location = new Point(50, 100);
                        form.ShowDialog();
                        this.SetStatusMsg("医保共享数据！");
                    }
                }
            }
            else if (uiEvent.Equals("BannerSiteClickEvent") || uiEvent.Equals("BannerSwitchingUser"))
            {
                if (patDo != null)
                {
                    Context["banner"] = patDo;
                    if (CiEnContextUtil.IsHpPat(patDo))// 社保时校验获取医保共享数据
                    {
                        handleMedicalShared();
                    }
                }
            }
            else if (uiEvent.Equals(EventCodeType.EVENT_ACTION_ORDERSAVEAS))
            {
                SaveAsOrd();
            }
            else if (uiEvent.Equals(OpActionConstant.OP_PRECALC_FEE_ACTION))
            {   //记账
                this.OpenPreCalcFeeView();
                RefreshViews();
            }
            else if (uiEvent.Equals(OpActionConstant.OP_PRESCANCEL_FEE_ACTION))
            {   //取消记账

                this.OpenPreCancelFeeView();
                // 直接关闭医疗单
                AssToolEx.SentMessage(this, AssToolEx.DictionaryEventArgsWith(EventCodeType.EVENT_EMS_CLOSE));
                RefreshViews();
            }
            else
            {
                base.HandleState(sender, eventArgs);
            }
        }
        #endregion

        #region 内部事件区域
        protected override void XapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.XapFormControl_FormCreated(sender, e);
            
            xapFormControl1.DataDisplay += XapFormControl1_DataDisplay;

            if (gv != null)
            {
                XDataColumn col = gv.DataTable.Columns["customercolumn_name_srvtp"];
                if (null != col)
                {
                    col.AllowSort = true;
                }
            }
            //创建费用清单
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            XTabPage xtab = tabs[0].tabContrl.XTabPages[2];
            xtab.PageControl = createOrderFeebillControl();

            int locationX = 20;
            if ((PageControlMode & PCM_OrderMode) == 0)
            {
                // 隐藏 医嘱列表
                tabs[0].tabContrl.XTabPages[0].Visible = false;
            }
            else
            {
                locationX += tabs[0].tabContrl.XTabPages[0].xTab.Bound.Width;
            }
            if ((PageControlMode & PCM_PresMode) == 0)
            {
                // 隐藏 处方列表
                tabs[0].tabContrl.XTabPages[1].Visible = false;
            }
            else
            {
                locationX += tabs[0].tabContrl.XTabPages[1].xTab.Bound.Width;
            }
            if (this.nSysParamFeeListOprMode == 0)
            {
                // 隐藏 费用列表
                tabs[0].tabContrl.XTabPages[2].Visible = false;
            }
            else
            {
                locationX += tabs[0].tabContrl.XTabPages[2].xTab.Bound.Width;
            }

            if (this.nSysParamFeeListOprMode <= 1)
            {
                this.GetOrderFeeBillControl().SetReadOnly(true);
            }

            adjustTableColumns("Content_or");

            CreateOrdListViewToolbar();
            CreateFeebillViewToolbar();
            emsFeesControl = Context.Config.GetInstance("emsFeesControl") as EmsFeesControl;
            if (null != emsFeesControl)
            {
                emsFeesControl.ownerView = this;
            }
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                ////createFeeCensusLayout();
                //emsFeesControl = Context.Config.GetInstance("emsFeesControl") as EmsFeesControl;
                //if (null != emsFeesControl)
                //{
                //    emsFeesControl.ownerView = this;
                //}

                emsFeesControl.Location = new Point(locationX, 0);

                tabs[0].tabContrl.AddRender(emsFeesControl);
            }
        }

        private void XapFormControl1_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            var ord = e.Object as CiOrderDO;

            updateCustomerControlInfo(row, ord);
        }

        protected override void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            base.xapFormControl1_ModelFilled(sender, e);
            var eventDic = new DictionaryEventArgs();
            eventDic.Data[UIConst.UI_EVENT] = "EmsFeesControl";
            FireEventSent(this, eventDic);
        }

        protected override void OnXapFormControl_DataDbClick(object sender, DataFocusedEventArgs e)
        {
        }

        protected override void OnXapFromGrid_MouseClick(object sender, MouseEventArgs e)
        {
        }

        protected override void OnXapFromGrid_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            gv.DataTable.SelectedRows.ToList().ForEach(p => { p.Selected = false; });
            ordSelectedContainer.clear();
            if (null != sender && sender is XDataRow)
            {
                (sender as XDataRow).Selected = true;
                ordSelectedContainer.add(((sender as XDataRow).RowDataSource as CiOrderDO).Id_or);
            }
            IEnumerable<OrderEditParameter> orderIterator =
                from rowItem in gv.DataTable.SelectedRows
                select new OrderEditParameter { OrderItem = rowItem.RowDataSource as CiOrderDO };

            var orderList = new OrderEditParamList(orderIterator);
            if (orderList.Count > 0)
            {
                AssToolEx.SentMessage(this, EventCodeType.EVENT_EMS_ORDER_EDIT, OrderEditParamList.TAGKEY, orderList);
            }
        }

        protected override void TabControl_SelectedChanging(object sender, TabChangeEventArgs e)
        {
            e.Cancel = (patDo == null);
            if (e.PrevPage.PageControl is OrdFeeBillView)
            {
                if ((patDo != null) && (e.PrevPage.PageControl as OrdFeeBillView).IsDirty())
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

        protected override void tabControl_SelectedIndexChanged(object sender, EventArgs e)
        {
            var xtab = sender as XTabPage;
            if (xtab.PageControl is SpltPrescriptionView)
            {
                AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDLIST_SWITCH2PRESS);
                SwitchToolbar(xtab.PageControl.GetType().FullName);
            }
            else if (xtab.PageControl is OrdFeeBillView)
            {
                AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDLIST_SWITCH2FEEBILL);
                SwitchToolbar(xtab.PageControl.GetType().FullName, false);
                (xtab.PageControl as OrdFeeBillView).ClearSelectedState();
            }
            else
            {
                AssToolEx.SentMessage(this, EventCodeType.EVENT_ORDLIST_SWITCH2ORDLIST);
                SwitchToolbar(GetOrderListControl().GetType().FullName);
            }
        }
        #endregion

        #region 辅助处理函数
        /// <summary>
        /// 更新医嘱类型列显示
        /// </summary>
        /// <param name="row"></param>
        /// <param name="ord"></param>
        private void updateCustomerControlInfo(XDataRow row, CiOrderDO ord)
        {
            if (ord == null)
            {
                return;
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_name_srvtp"))
            {
                string sdSrvtp = ord.Sd_srvtp;
                string strName_srvtp = "";
                // 药品、血液制品截取sd_srvtp 的前 4位，其余的截取两位
                if (sdSrvtp.StartsWith(BdSrvTpDictCodeConst.SD_SRVTP_DRUG) || sdSrvtp.StartsWith(BdSrvTpDictCodeConst.SD_SRVTP_BLOODPROD)) // 西成药
                {
                    sdSrvtp = sdSrvtp.Substring(0, 4);
                }
                else
                {
                    sdSrvtp = sdSrvtp.Substring(0, 2);
                }

                // 获取显示的类型名称
                if (viewModel.sdSrvtpDic.ContainsKey(sdSrvtp))
                {
                    strName_srvtp = viewModel.sdSrvtpDic[sdSrvtp];
                }
                else
                {
                    strName_srvtp = "未知";
                }

                row.ColumnCellDict["customercolumn_name_srvtp"].SetValue(strName_srvtp);
            }
        }

        /// <summary>
        /// 调整列属性
        /// </summary>
        private void adjustTableColumns(string autofitField)
        {
            XDataColumn srvNameColumn = null;
            int nWidth = 0;

            // 处理过程
            foreach (XDataColumn column in gv.DataTable.Columns)
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
                    List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
                    XTabPage xTab = tabs[0].tabContrl.XTabPages.Cast<XTabPage>().ToList().LastOrDefault(p => p.Visible = true);
                    emsFeesControl.Location = new Point(xTab.xTab.Bound.Right + 20, 0);
                }
            }
        }

        #region 工具栏
        /// <summary>
        /// 创建医嘱列表视图工具栏
        /// </summary>
        private void CreateOrdListViewToolbar()
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
            btnRefresh.MouseClick += OnXapFormControl_Toolbar_MouseClick;
            SkinFactory.Instance().SkinChanged += btnRefresh.OnSystemSkinChanged;
            basecontrol.AddRender(btnRefresh);

            string idDep = this.Context.Dept.Id_dep;
            string refreshMode = this.Context.GetParam<string>(idDep, ICiOrdNSysParamConst.SYS_PARAM_OpOrSysncro2MrHandleMode);
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
                btnFlush2Emr.MouseClick += OnXapFormControl_Toolbar_MouseClick;

                SkinFactory.Instance().SkinChanged += btnFlush2Emr.OnSystemSkinChanged;
                basecontrol.AddRender(btnFlush2Emr);
            }

            xapFormControl1.AddRender(basecontrol);
            toolbarMap.Add(GetOrderListControl().GetType().FullName, basecontrol);
        }
        /// <summary>
        /// 创建费用列表视图工具栏
        /// </summary>
        private void CreateFeebillViewToolbar()
        {
            var basecontrol = new XapBaseControl { Visible = false };
            basecontrol.Size = new Size(75, 25);
            basecontrol.Location = new Point(Size.Width - basecontrol.Size.Width - 1, 1);
            if(this.nSysParamFeeListOprMode > 1)
            {
                var addButton = new CiIconToolButton
                {
                    Tag = ACTION_FEEBILL_NEW,
                    Location = new Point(1, 0),
                    Size = new Size(24, 24),
                    TipText = "新增",
                    ImageName = "增加"
                };
                addButton.MouseClick += OnXapFormControl_Toolbar_MouseClick;
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
                delButton.MouseClick += OnXapFormControl_Toolbar_MouseClick;
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
                saveButton.MouseClick += OnXapFormControl_Toolbar_MouseClick;
                SkinFactory.Instance().SkinChanged += saveButton.OnSystemSkinChanged;
                basecontrol.AddRender(saveButton);

                basecontrol.EnabledChanged += (sender, e) =>
                {
                    saveButton.Enabled = basecontrol.Enabled;
                    addButton.Enabled = basecontrol.Enabled;
                    delButton.Enabled = basecontrol.Enabled;
                };
            }

            xapFormControl1.AddRender(basecontrol);
            toolbarMap.Add(GetOrderFeeBillControl().GetType().FullName, basecontrol);
        }
        /// <summary>
        /// 更换工具栏
        /// </summary>
        /// <param name="className"></param>
        /// <param name="enable"></param>
        protected void SwitchToolbar(String className, bool enable = true)
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
        protected XapBaseControl GetToolbarControl(String className)
        {
            if (toolbarMap.ContainsKey(className))
            {
                return toolbarMap[className];
            }
            return null;
        }

        protected void OnXapFormControl_Toolbar_MouseClick(object sender, MouseEventArgs e)
        {
            var btn = sender as XIconToolButton;
            switch (btn.Tag.ToString())
            {
                case ACTION_ORDERLIST_REFRESH:
                    RefreshViews();
                    break;
                case ACTION_ORDERLIST_UPDATEEMR:
                    flush2mr_MouseClick();
                    break;
                case ACTION_FEEBILL_NEW:
                    GetOrderFeeBillControl().OnAdd();
                    break;
                case ACTION_FEEBILL_DEL:
                    GetOrderFeeBillControl().OnDelete();
                    break;
                case ACTION_FEEBILL_SAVE:
                    GetOrderFeeBillControl().OnSave();
                    break;
            }
        }
        #endregion

        #region 页签视图
        protected override TabNavigatorControl createTabNavigatorControl()
        {
            return null;
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
        public OrdListView GetOrderListControl()
        {
            return this;
        }

        /// <summary>
        /// 获取处方业务视图对象
        /// </summary>
        /// <returns>处方业务视图对象</returns>
        public SpltPrescriptionView GetOrderPresControl()
        {
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
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
        public OrdFeeBillView GetOrderFeeBillControl()
        {
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            if (null == tabs || tabs.Count == 0 || null == tabs[0].tabContrl || tabs[0].tabContrl.XTabPages.Count < 3)
            {
                return null;
            }

            XTabPage xtab = tabs[0].tabContrl.XTabPages[2];
            return xtab.PageControl as OrdFeeBillView;
        }

        /// <summary>
        /// 获取当前选中的业务视图对象
        /// </summary>
        /// <returns>当前显示的业务视图对象</returns>
        public XapBaseControl GetVisiblePageControl()
        {
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            int index = tabs[0].tabContrl.SelectedIndex;
            switch (index)
            {
                case 0:
                    return this;
                case 1:
                    return tabs[0].tabContrl.XTabPages[1].PageControl as XapBaseControl;
                case 2:
                    return tabs[0].tabContrl.XTabPages[2].PageControl as XapBaseControl;
            }
            return null;
        }

        public void SetVisiblePageControl(int index)
        {
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;

            if (index >= 0 && index < tabs[0].tabContrl.XTabPages.Count)
                tabs[0].tabContrl.SelectedIndex = index;
        }

        public override void OnActiveForm()
        {
        }
        #endregion

        #region 执行打印
        /// <summary>
        /// 执行打印操作
        /// </summary>
        private void toPrint(bool isComplete, bool isPres)
        {
            if (this.patDo == null || String.IsNullOrEmpty(this.patDo.Id_ent)) return;

            //选中页签
            int selectedIndex = isComplete ? 0 : (isPres ? 1 : 0);
            List<String> lstIdor = new List<string>();
            List<String> lstIdpres = new List<string>();
            switch (selectedIndex)
            {
                case 0:
                    this.xapFormControl1.GetSelected<CiOrderDO>("order").ToList<CiOrderDO>().ForEach(order =>
                    {
                        if (!order.Sd_su_or.Equals(CiDictCodeConst.SD_SU_OPEN))
                            lstIdor.Add(order.Id_or);
                    });
                    break;
                case 1:
                    if (this.GetOrderPresControl() != null && this.GetOrderPresControl().GetAllOrdPresDTOs() != null)
                    {
                        this.GetOrderPresControl().GetAllOrdPresDTOs().ToList<OrdPresDTO>().ForEach(dto =>
                        {
                            lstIdpres.Add(dto.Id_pres);
                        });
                    }
                    break;
                case 2:
                    CiOrdFeeSrvDTO[] allbilldtos = (GetOrderFeeBillControl().GetModel().GetTableDataSource() as XapDataList<CiOrdFeeSrvDTO>).ToArray();
                    foreach (CiOrdFeeSrvDTO billdo in allbilldtos)
                    {
                        if (!lstIdor.Contains(billdo.Id_or))
                            lstIdor.Add(billdo.Id_or);
                    }
                    break;
            }
            if (selectedIndex == 0 && lstIdor.Count <= 0)
            {
                if (!this.IsContinue("提示", "未选择需要打印的已签署处置！是否继续？"))
                    return;
            }

            // 打印管理对话框
            using (var dialog = new PrintManageDialog(selectedIndex, lstIdor, lstIdpres, this, this.patDo.Id_hp, this.patDo.Sd_hptp, true))
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

        #region 医嘱操作
        protected override bool SignOrd()
        {
            CiOrderDO[] orders = xapFormControl1.GetSelected<CiOrderDO>();

            // 合理用药处方校验（之校验药品的医嘱）
            RationalDrugView rationalDrugView = RationalDrugViewFactory.GetInstance();
            // 返回false 为存在问题，不继续执行
            bool result = rationalDrugView.AnalysisPresResult(orders);
            if (!result)
            {
                return false;
            }

            if (base.SignOrd())
            {
                // 签署后，需要刷新费用清单中医嘱状态
                RefreshViews();
                //判断手动/自动  1/0
                string idDep = this.Context.Dept.Id_dep;
                string refreshMode = this.Context.GetParam<string>(idDep, ICiOrdNSysParamConst.SYS_PARAM_OpOrSysncro2MrHandleMode);
                if (refreshMode == "0")
                {
                    //li_cheng  签署后刷新病历
                    flush2mr_MouseClick();
                }
                return true;
            }
            return false;
           

        }

        protected override bool DoSignOrder(CiOrderDO[] szOrders)
        {
            if (OnDelegateOrdAction != null && OnDelegateOrdAction(szOrders, "CiSubmit", null) == 0)
            {
                return false; // 代理执行结果不允许删除医嘱
            }

            if (viewModel.SignCiOrder(szOrders, patDo))
            {
                this.SetStatusMsg("签署成功！");
                return true;
            }
            else
            {
                this.SetStatusMsg("签署失败！");
            }

            return false;
        }

        /// <summary>
        /// 重新分方调用签署
        /// </summary>
        private void SignOrSplie()
        {
            if (patDo != null && patDo.Id_ent != null)
            {
                CiOrderDO[] orders = viewModel.getCiOrders(patDo);
                if (orders != null && orders.Length > 0)
                {
                    this.viewModel.SignCiOrder(orders, this.patDo);

                    if (this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpOrSysncro2MrHandleMode) == 0)
                    {
                        this.fireCiOrderFlush2mrEvent(this.viewModel.opsignords);
                    }
                }

            }

        }

        private bool CiOPAgainPres(string id_ent, string id_dep_sign, string sd_entp)
        {
            try
            {
                string[] ids = viewModel.CiOPAgainPres(id_ent, id_dep_sign, sd_entp, this.patDo, this.Context);
                return true;
            }
            catch (XapBizException e)
            {
                this.ShowInfo(e.Message);
            }

            return false;
        }

        //  A点击“撤回”，异常：仍可撤回
        /// <summary>
        ///     撤销医嘱
        ///     业务场景描述：
        ///     从数据库中取出最新的医嘱值，进行校验是否能撤回；因为两个客户端，A签署医嘱，B护士确认医嘱，
        /// </summary>
        private void BackOrd()
        {
            {
                CiOrderDO[] selorders = xapFormControl1.GetSelected<CiOrderDO>();
                IEnumerable<CiOrderDO> orders = selorders.Where(ord => ord.Sd_su_or != CiDictCodeConst.SD_SU_OPEN && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord));
                string msg = "";
                if (orders != null)
                {
                    foreach (CiOrderDO ord in orders)
                    {
                        if (ord.Id_emp_sign != Context.PsnInfo.Id_psndoc)
                        {
                            msg += ord.Name_or + "\n";
                        }
                    }
                    if (msg != "")
                    {
                        this.ShowInfo(msg + " 不是本人签署的,不能撤回,请不要选中");
                        return;
                    }
                }
                orders = orders.Where(ord => ord.Id_emp_sign == Context.PsnInfo.Id_psndoc);

                string[] szSelectionOrderIDs =
                    orders.Where(ord => ord.Sd_su_or != CiDictCodeConst.SD_SU_OPEN).Select(p => p.Id_or).ToArray();
                if (szSelectionOrderIDs == null || szSelectionOrderIDs.Length == 0)
                {
                    this.ShowInfo("请选择当前医生开立且【已签署】处置");
                    return;
                }
                CiOrderDO[] szCanBackOrd = viewModel.getCiOrderDOArray(szSelectionOrderIDs);
                //3.如果没有可撤销的                
                if (szCanBackOrd == null || szCanBackOrd.Length == 0)
                {
                    if (this.IsContinue("提示", "没有符合操作的数据！是否刷新列表?"))
                    {
                        RefreshViews();
                    }
                    return;
                }

                // 判断医嘱状态是否发生改变
                foreach (CiOrderDO selOrder in orders)
                {
                    foreach (CiOrderDO backOrd in szCanBackOrd)
                    {
                        if (selOrder.Id_or.Equals(backOrd.Id_or) && !selOrder.Sd_su_or.Equals(backOrd.Sd_su_or))
                        {
                            this.ShowInfo("选择的处置状态发生改变，请刷新医嘱列表后重新操作");
                            return;
                        }
                    }
                }

                IEnumerable<string> canRevokeOrdIds = szCanBackOrd.Select(p => p.Id_or);
                IEnumerable<CiOrderDO> backOrdList = szCanBackOrd.ToList().Where(ciOrderBack =>
                    ciOrderBack.Sd_su_or == CiDictCodeConst.SD_SU_SIGN && ciOrderBack.Fg_sign == true 
                    && ciOrderBack.Sd_su_mp == CiDictCodeConst.SD_SU_MP_NONE 
                    && (ciOrderBack.Sd_su_bl == CiDictCodeConst.SD_SU_BL_NONE || ciOrderBack.Sd_su_bl == CiDictCodeConst.SD_SU_BL_REFOUND));
                if (backOrdList.Count() == 0)
                {
                    this.ShowInfo("选择的处置已经执行，或者已经收费，不能撤销");
                    return;
                }

                // 
                if (OnDelegateOrdAction != null && OnDelegateOrdAction(backOrdList.ToArray(), EventCodeType.EVENT_ACTION_REVETSUBMIT, null) == 0)
                {
                    return; // 代理执行结果不允许删除医嘱
                }

                //5.开始撤销
                CiOrderDO[] backorders = viewModel.OPOnUpdateSu(backOrdList.ToArray(), CiDictCodeConst.SD_SU_OPEN,
                    CiDictCodeConst.SD_SU_OP_YSQ);
                if (backorders == null || backorders.Length == 0) return;
                fireCiOrderFlush2mrEvent(new CiOrderDO[0]);
                RefreshViews();
                this.SetStatusMsg("撤销成功！");
            }
        }

        /// <summary>
        /// 医嘱另存为模板
        /// </summary>
        private void SaveAsOrd()
        {
            CiOrderDO[] orders = xapFormControl1.GetSelected<CiOrderDO>();
            if (orders != null && orders.Length > 0)
            {
                var lstIDs = new List<string>();
                orders.ToList().ForEach(p => { lstIDs.Add(p.Id_or); });
                var args = new DictionaryEventArgs();
                args.Data.Add(UIConst.UI_EVENT, "SaveAsOrdEvent");
                FireEventSent(lstIDs.ToArray(), args);
            }
            else
                this.ShowInfo("请先选择您所要操作的处置!");
        }

        /// <summary>
        /// 删除选择的医嘱内容
        /// </summary>
        protected override void DelOrd()
        {
            CiOrderDO[] orders = xapFormControl1.GetSelected<CiOrderDO>();
            if (orders.Length == 0)
            {
                this.ShowInfo("请先选择您所要操作的处置!");
                return;
            }

            // 如果患者是商保记账患者
            if (CiEnContextUtil.IsHeComInsurAllowedAccountPat(this.patDo))
            {
                DeleteHighBusinessInsurance(orders);                
            }
            else
            {
                DelOrds(orders);
            }
        }

        /// <summary>
        /// 删除选中的医嘱
        /// </summary>
        /// <param name="orders"></param>
        protected void DelOrds(CiOrderDO[] orders)
        {           

            // 获取符合条件的医嘱列表
            List<CiOrderDO> orderlist =
                orders.Where(ord => (ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();

            if (orderlist.Count == 0)
            {                
                BizAssMessageBoxUtil.ShowInforMsg("只能删除当前登录医生开立且未签署的处置！");
                return;
            }            

            // 调用医疗单代理，是否在在已经打开的医嘱
            if (OnDelegateOrdAction != null)
            {
                int nState = OnDelegateOrdAction(orderlist.ToArray(), EventCodeType.EVENT_ORDLIST_DELETEORDER, null);

                // 代理判断不执行删除操作
                if (nState == 0)
                {
                    return; // 代理执行结果不允许删除医嘱
                }
                // 代理没有判断提示
                else if (nState == 2 && orders.Count() != orderlist.Count())
                {
                    if (!BizAssMessageBoxUtil.ShowConfirmMsg("仅删除当前登录医生开立且未签署的处置，确定删除吗？"))
                    {
                        return;
                    }
                }
            }

            DoDeleteOrder(orderlist.ToArray());
        }

        /// <summary>
        /// 删除给定 id_or 的医嘱
        /// </summary>
        /// <param name="id_or"></param>
        protected void DelOrdByIdOr(String id_or)
        {
            if (String.IsNullOrEmpty(id_or))
            {
                if (this.IsContinue("提示", "没有符合操作的数据！是否刷新列表?"))
                {
                    RefreshViews();
                }
                return;
            }

            CiOrderDO ord = viewModel.xapList.FirstOrDefault(p => p.Id_or.Equals(id_or));
            if (null == ord)
            {
                return;
            }

            CiOrderDO[] orders = new[] { ord };
            DelOrds(orders);
            ordSelectedContainer.remove(id_or);
        }

        /// <summary>
        /// 删除处置
        /// </summary>
        /// <param name="szOrders"></param>
        protected override void DoDeleteOrder(CiOrderDO[] orders)
        {
            bool isDelSucc = viewModel.DelOrd(orders);
            if (isDelSucc)
            {                
                this.SetStatusMsg("删除成功！");
                RefreshViews();
            }
            else
            {
                this.SetStatusMsg("处置删除失败，请刷新医嘱列表后重试！");
            }
        }

        /// <summary>
        /// 高端商保删除
        /// </summary>
        /// <param name="orders"></param>
        /// <returns></returns>
        private void DeleteHighBusinessInsurance(CiOrderDO[] orders)
        {
            if (orders == null || orders.Length == 0)
            {
                return;
            }


            // 获取当前医生开立的处置集合
            List<CiOrderDO> orderlistOPen =
                orders.Where(ord => (ord.Sd_su_or == CiDictCodeConst.SD_SU_OPEN && ord.Fg_sign == false) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();

            // 获取当前医生记账的处置集合
            List<CiOrderDO> orderlistsign =
                orders.Where(ord => (ord.Sd_su_or == CiDictCodeConst.SD_SU_SIGN && ord.Fg_sign == true) && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord)).ToList();

            int selOrdCnt = orderlistOPen.Count + orderlistsign.Count;

            if (selOrdCnt == 0) {

                BizAssMessageBoxUtil.ShowInforMsg("只能删除当前登录医生开立且未签署执行的处置！");
                return;
            }

            if (orders.Length != selOrdCnt ) {
                if (!BizAssMessageBoxUtil.ShowConfirmMsg("仅删除当前登录医生开立且未执行的处置，确定删除吗？"))
                {
                    return;
                }
            }

            // 记账状态处置进行销账，销账后医嘱列表不显示
            if (orderlistsign.Count > 0)
            {
                String[] idOrs = getIdors(orderlistsign);
                string msg = this.viewModel.setOrderRefundBillCancelReserve(idOrs, this.Context.PsnInfo.Id_psndoc, this.patDo);
                this.SetStatusMsg(msg);
                fireCiOrderFlush2mrEvent(orders);
            }

            // 开立状态处置进行删除
            if (orderlistOPen.Count > 0)
            {
                DoDeleteOrder(orderlistOPen.ToArray());
            }
            else
            {
                // 删除方法中有刷新，销账方法没有刷新
                RefreshViews();
            }
        }

        private String[] getIdors(List<CiOrderDO> orderlist)
        {
            if (orderlist != null && orderlist.Count > 0)
            {
                String[] idors = new string[orderlist.Count];
                int i = 0;
                foreach (CiOrderDO ciOrderDo in orderlist)
                {
                    idors[i] = ciOrderDo.Id_or;
                    i++;
                }
                return idors;
            }
            return null;

        }

        /// <summary>
        ///     医保共享数据,社保时调用
        /// </summary>
        private void handleMedicalShared()
        {
            if (viewModel == null)
            {
                viewModel = new OrderItemViewModel(patDo, Context);
            }
            FBoolean isDept = viewModel.getIsDeptOrDatumshared(Context.Org.Id_org, Context.Dept.Id_dep);
            if (isDept)
            {
                String errMsg = "";
                GetMedicalsharingData.Instance.getMedicalsharingData(patDo, Context, out errMsg, "");
                viewModel.getDictbdHpUnlimitDrug(patDo.Id_hp);
            }
        }

        /// <summary>
        /// 预付费（预交金记账）
        /// </summary>
        private void OpenPreCalcFeeView()
        {
            if (xap.cli.context.events.XapEvents.OpenFuncEvent != null)
            {
                var device = DevicePoller.Instance;
                var dentCard = device.ReadIdentCard();

                if (dentCard == null)
                {
                    return;
                }

                if (!this.patDo.Sd_idtp.Equals("01") || string.IsNullOrEmpty(this.patDo.Id_code))
                {

                    BizAssMessageBoxUtil.ShowWarningMsg("患者未使用身份证进行注册！");
                    return;
                }

                if (!this.patDo.Id_code.Equals(dentCard.Identity))
                {
                    BizAssMessageBoxUtil.ShowWarningMsg("当前身份证号与患者注册的身份证号不匹配！");
                    return;
                }

                string id_psndoc = this.Context.PsnInfo.Id_psndoc;
                string msg = this.viewModel.OrderKeepAccounts(this.patDo.Id_ent, this.patDo.Code_entp, "1", id_psndoc);
                this.SetStatusMsg(msg);
                AssToolEx.SentMessage(this, AssToolEx.DictionaryEventArgsWith(ACTION_ORDERLIST_REFRESH));
            }
        }

        /// <summary>
        /// 取消记账
        /// </summary>
        private void OpenPreCancelFeeView()
        {
            if (xap.cli.context.events.XapEvents.OpenFuncEvent != null)
            {
                if (BizAssMessageBoxUtil.ShowConfirmMsg("确认进行取消预付费操作？") == FBoolean.True)
                {
                    string id_psndoc = this.Context.PsnInfo.Id_psndoc;

                    string msg = this.viewModel.CancelOrderAccounting(this.patDo.Id_ent, this.patDo.Code_entp, id_psndoc);
                    this.SetStatusMsg(msg);
                    fireCiOrderFlush2mrEvent(new CiOrderDO[0]);
                }
            }
        }

        /// <summary>
        /// 手动将已处置未同步到病历的处置 同步到病历中
        /// </summary>
        protected void flush2mr_MouseClick()
        {
            CiOrderDO[] selectlist = xapFormControl1.GetSelected<CiOrderDO>();
            if (selectlist == null || selectlist.Length == 0)
            {
                this.ShowInfo("请选择需要同步到病历的处置！");
                return;
            }
            var flushlist = new List<CiOrderDO>();
            Boolean isSelf = false;
            string signName = "[";
            int index = 0;
            foreach (CiOrderDO ciord in selectlist)
            {

                if (ciord.Id_emp_sign != null & ciord.Id_emp_sign != this.Context.PsnInfo.Id_psndoc)
                {
                    isSelf = true;
                    signName += ciord.Emp_sign_name + (index == selectlist.Length - 1 ? "]" : ",");
                }
                else if((bool)ciord.Fg_sign)
                {
                    flushlist.Add(ciord);
                }
                index++;
            }
            if (flushlist.Count == 0)
            {
                this.ShowInfo("没有符合操作的数据");
            }
            else
            {

                if (flushlist.Count != selectlist.Length)
                {
                    if (this.IsContinue("提示", "只有符合操作的处置才可被刷新到病历，是否继续操作？"))
                    {
                        if (isSelf)
                        {

                            if (this.IsContinue("提示", "当前同步操作包含" + signName + "医生签署的处置,是否继续同步？"))
                            {
                                fireCiOrderFlush2mrEvent(selectlist);
                            }
                        }
                        else
                        {
                            fireCiOrderFlush2mrEvent(selectlist);
                        }

                    }
                }
                else
                {
                    if (isSelf)
                    {
                        if (this.IsContinue("提示", "当前同步操作包含" + signName + "医生签署的处置,是否继续同步？"))
                        {
                            fireCiOrderFlush2mrEvent(selectlist);
                        }
                    }
                    else
                    {
                        fireCiOrderFlush2mrEvent(selectlist);
                    }
                }

            }
            
        }

        #endregion

        private void RefreshViews()
        {
            LoadData();
            if (GetOrderFeeBillControl() != null)
            {
                GetOrderFeeBillControl().LoadData();
            }
            if (GetOrderPresControl() != null)
            {
                GetOrderPresControl().LoadData();
            }
        }

        protected override void freshFeeBillDataSource()
        {
            base.freshFeeBillDataSource();
            //刷新费用列表
            if (GetOrderFeeBillControl() != null)
            {
                GetOrderFeeBillControl().LoadData();
            }
        }

        /// <summary>
        /// 远程读取系统参数
        /// </summary>
        private void ReadSysParamFromRemote()
        {
            // 门诊费用清单相关参数
            nSysParamFeeListOprMode = this.Context.GetDeptParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpDocBillListOperationMode);
          //  nSysParamFeeListOprMode = this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpDocBillListOperationMode);
        }
        #endregion
    }
}