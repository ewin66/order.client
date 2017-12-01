using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.diagtreatview.adapter;
using iih.ci.ord.diagtreatview.viewmodel;
using iih.ci.ord.diagtreatview.viewmodel.bp;
using iih.ci.ord.diagtreatview.viewmodel.cache;
using iih.ci.ord.dto.blexorder.d;
using iih.en.pv.dto.d;
using xap.cli.sdk.form;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.ClinicalTimeline;
using xap.rui.bizcontrol.ClinicalTimeline.enums;
using xap.rui.bizcontrol.ClinicalTimeline.interfaces;
using xap.rui.bizcontrol.ClinicalTimeline.reportTypeInfo;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;

namespace iih.ci.ord.diagtreatview.view
{
    public partial class DiagtreatCardView : XapListControl, IWorkStationRegist, ICliViewLightStatus
    {
        private readonly DiagtreatCardViewModel viewmodel;
        protected CliTestView TestView;
        private ClinicalTimelineView _clinicalTimelineView;
        private Ent4BannerDTO ent4BannerDto;

        //private List<ClickMarkModel> routeMarkList;

        public DiagtreatCardView()
        {
            viewmodel = new DiagtreatCardViewModel();
            InitializeComponent();
            Load += DiagtreatCardView_Load;
        }


        public bool IsLightsOut
        {
            get
            {
                if (_clinicalTimelineView != null)
                {
                    return _clinicalTimelineView.IsLightsOut;
                }
                return false;
            }
        }

        private void DiagtreatCardView_Load(object sender, EventArgs e)
        {
            if ((Context["PatientData"] as BannerData) != null)
            {
                ent4BannerDto = (Context["PatientData"] as BannerData).Ent4BannerDTO; //Ent4BannerDTO
            }
            if (ent4BannerDto == null || ent4BannerDto.Id_ent == null)
                return;
            //ipdto = viewmodel.GetIpBasicInfo(ent4BannerDto.Id_ent);
            //var date1 = new DateTime();
            //DateTime.TryParse(ipdto.Dt_acpt.ToString(), out date1);
            //var data2 = new DateTime(date1.Year, date1.Month, date1.Day);
            //DateTime dt2 = DateTime.Now;
            //TimeSpan ts1 = dt2 - data2;
            //你想转的格式
            //int days = ts1.Days + 1;
            _clinicalTimelineView = new ClinicalTimelineView();
            _clinicalTimelineView.Dock = DockStyle.Fill;
            _clinicalTimelineView.IsScreenAdapt = false;
            _clinicalTimelineView.ScrollPageDays = 20;
            //if (days < 20 && days >= 10)
            //    _clinicalTimelineView.ScrollPageDays = days;
            //if (days >= 20)
            //    _clinicalTimelineView.ScrollPageDays = 20;
            //if (days < 10)
            //    _clinicalTimelineView.ScrollPageDays = 10;
            AddRender(_clinicalTimelineView);

            Text = "诊疗时间轴视图";

            //用药点击事件
            _clinicalTimelineView.ExecuteMouseClick += ExecutePointMouseClick;
            //      _clinicalTimelineView.ex

            _clinicalTimelineView.TimeExecuteMouseClick += TimeExcuteClick;

            //检查检验点击事件
            _clinicalTimelineView.ExeLabelMouseClick += ExeLablesMouseClickTest;

            //查看报告
            _clinicalTimelineView.CheckReportEvent += showreport;

            //查看趋势图
            _clinicalTimelineView.TrendChartEvent += TrendChartClick;

            //翻页
            _clinicalTimelineView.PageChanged += _clinicalTimelineView_PageChanged;

            //刷新事件
            _clinicalTimelineView.PageRefresh += _clinicalTimelineView_PageRefresh;

            //跳转
            _clinicalTimelineView.JumpPage += _clinicalTimelineView_JumpPage;

            //切换时间轴模式
            _clinicalTimelineView.SelectedValchanged += _clinicalTimelineView_SelectedValchanged;

            LoadData();
        }

        private void _clinicalTimelineView_SelectedValchanged(object sender, EventArgs e)
        {
            //var startDate = new DateTime(2016, 1, 1);
            //DateTime endDate = DateTime.Today;
            //if (ipdto != null && ipdto.Dt_acpt != null)
            //{
            //    if (DateTime.TryParse(ipdto.Dt_acpt.ToString(), out startDate)) ;
            //}
            //else
            //{  
            //    ipdto = viewmodel.GetIpBasicInfo(ent4BannerDto.Id_ent);
            //    if (DateTime.TryParse(ipdto.Dt_acpt.ToString(), out startDate)) ;
            //}
            //ClinicalTimelineViewModel model =  new ClinicalTimelineViewModel(startDate, endDate);
            //    _clinicalTimelineView.Model = model;

            var s = (CliTimeEvent) sender;
            if (s == CliTimeEvent.All)
            {
                _clinicalTimelineView.InitPagingInfo();
                InitTimeline();
            }
            else if (s == CliTimeEvent.KeyTime)
            {
                //日期截止到今天

                //          this.viewmodel.refreshData(ent4BannerDto.Id_ent, startDate, endDate, startDate);
                //this.viewmodel.setKeyPointData(ent4BannerDto.Id_ent, DiagTreatInit.dtacept,
                //DiagTreatInit.enddate, DiagTreatInit.dtacept);
                viewmodel.setKeyPointData(ent4BannerDto.Id_ent, viewmodel.dtacept,
                    viewmodel.enddate, viewmodel.dtacept);
                _clinicalTimelineView.InitPagingInfo(viewmodel.getKeyPoints());
                    //.KeyPointDateTimes = this.viewmodel.getKeyPoints();
                InitTimeline();
            }
        }

        private void _clinicalTimelineView_PageChanged(object sender, PageChangedEventArgs args)
        {
            //  OnFillData();
            InitTimeline();
        }

        /// <summary>
        ///     弹报告单 CliTestView
        /// </summary>
        /// <param name="xForm"></param>
        private void showreport(XForm xForm, ClinicalExeEventStatus ReportType, String Id)
        {
            if (TestView != null)
                TestView.Close();
            TestView = (CliTestView) xForm;
            //加载报告界面
            DiagtreatUtils.showreport(TestView, ReportType, Id);
            TestView.cliTestControl.AddRender(TestView.DataView);
        }

        /// <summary>
        ///     绘制趋势图
        /// </summary>
        /// <param name="xForm"></param>
        private void TrendChartClick(XForm xForm)
        {
            if ((xForm as CliTestView).ReportStatus == ClinicalExeEventStatus.LIS)
            {
                DiagtreatUtils.showTrendView((xForm as CliTestView), ent4BannerDto);
            }
        }

        public Object ExecutePointMouseClick(ExeRouteHitInfo routeHitInfo, MouseButtons mouseButton)
        {
            viewmodel.GetExecuteSteps(routeHitInfo.RouteMark);
            return null;
        }

        public object TimeExcuteClick(TimeViewHitInfo timeHitInfo, MouseButtons mouseButton)
        {
            viewmodel.GetExecuteSteps(timeHitInfo.ClickMark.Mark);
            return null;
        }

        public void ExeLablesMouseClickTest(ExeEventHitInfo routeHitInfo, MouseButtons mouseButton)
        {
            viewmodel.getlisLoopStep(routeHitInfo.EventLabel);
        }

        /// <summary>
        ///     刷新事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args"></param>
        /// <param name="IsRefresh"></param>
        private void _clinicalTimelineView_PageRefresh(object sender, PageChangedEventArgs args, ref bool IsRefresh)
        {
            //var startDate = new DateTime(2016, 1, 1);
            //if (ipdto != null && ipdto.Dt_acpt != null)
            //{
            //    if (DateTime.TryParse(ipdto.Dt_acpt.ToString(), out startDate)) ;
            //} else
            //{
            //    ipdto = viewmodel.GetIpBasicInfo(ent4BannerDto.Id_ent);
            //    if (DateTime.TryParse(ipdto.Dt_acpt.ToString(), out startDate)) ;
            //}
            DateTime dtmp = DateTime.Today;
            var endDate = new DateTime(dtmp.Year, dtmp.Month, dtmp.Day, 23, 59, 59);
            IsRefresh = true;
            var param = new OrSrvSplitParamDTO();
            param.Id_ens = ent4BannerDto.Id_ent;
            //param.Dt_split_start = DiagTreatInit.dtacept;
            param.Dt_split_start = viewmodel.dtacept;
            param.Dt_split_end = endDate;
            viewmodel.refreshData(param);
            //this.viewmodel.setKeyPointData(ent4BannerDto.Id_ent, DiagTreatInit.dtacept,
            //   endDate, DiagTreatInit.dtacept);
            viewmodel.setKeyPointData(ent4BannerDto.Id_ent, viewmodel.dtacept,
                endDate, viewmodel.dtacept);
            InitTimeline();
        }

        private void _clinicalTimelineView_JumpPage(object sender, PageChangedEventArgs args, ref bool IsRefresh)
        {
            InitTimeline();
        }

        /// <summary>
        ///     初始化界面
        /// </summary>
        private void InitTimeline()
        {
            //日期截止到今天
            //var startDate = new DateTime(2016, 1, 1);
            //if (ipdto != null && ipdto.Dt_acpt != null)
            //{
            //    if (DateTime.TryParse(ipdto.Dt_acpt.ToString(), out startDate)) ;
            //}
            ClinicalTimelineViewModel model = _clinicalTimelineView.Model;
            if (model == null)
            {
                //    DateTime endDate = DateTime.Today;
                //model = new ClinicalTimelineViewModel(DiagTreatInit.dtacept, DiagTreatInit.enddate);
                model = new ClinicalTimelineViewModel(viewmodel.dtacept, viewmodel.enddate);
                _clinicalTimelineView.Model = model;
            }
            else
            {
                model.Groups.Clear();
            }
            this.viewmodel.disposeuimodel();//释放model.Groups资源
            //设置缓存区域
            //viewmodel.setCachePeriod(ent4BannerDto.Id_ent, model.PageBeginDate,
            //    model.PageEndDate, startDate);

            //查询数据 model.PageBeginDate.AddDays(model.PageSize + 1)
            //TransSrvSplitOrderDTO[] basedtos = viewmodel.getDrugList(model.PageBeginDate,
            //    model.PageEndDate, startDate);
            //OrSplitOrderDTO[] labbasedtos = viewmodel.getLabAndObsSplitList(model.PageBeginDate,
            //    model.PageEndDate, "lab", startDate);
            //OrSplitOrderDTO[] obsbasedtos = viewmodel.getLabAndObsSplitList(model.PageBeginDate,
            //    model.PageEndDate, "obs", startDate);
            //List<ItemInfo> Vidata = viewmodel.getViList(model.PageBeginDate,
            //    model.PageEndDate, startDate);
            KeyPointViewData viewdata = null;
            if (model.PagingInfo.NowCliTime == CliTimeEvent.KeyTime)
            {
                viewdata = viewmodel.queryKeyPViewData(model.PageBeginDate,
                    model.PageEndDate);
            }
            else if (model.PagingInfo.NowCliTime == CliTimeEvent.All)
            {
                viewdata = viewmodel.queryViewData(model.PageBeginDate,
                    model.PageEndDate);
            }
            this.viewmodel.groupmodel.Clear(); 
            //体征单组件模型
            var vitalSignGroup = new VitalSignGroupModel();
            vitalSignGroup.Items.AddRange(viewdata.CacheTempList);

            //体征单表格模型

            var vitalSignGridItem = new VitalSignGridItemConfig("呼吸", "呼吸", "次/分", "呼吸渲染器", 6);
            vitalSignGroup.GridItemConfigs.Add(vitalSignGridItem);
            vitalSignGridItem = new VitalSignGridItemConfig("大便", "大便次数", "次/天", "表格渲染器1", 1);
            vitalSignGroup.GridItemConfigs.Add(vitalSignGridItem);
            vitalSignGridItem = new VitalSignGridItemConfig("入量", "入量", "毫升/天", "表格渲染器1", 1);
            vitalSignGroup.GridItemConfigs.Add(vitalSignGridItem);
            vitalSignGridItem = new VitalSignGridItemConfig("出量", "出量", "毫升/天", "表格渲染器1", 1);
            vitalSignGroup.GridItemConfigs.Add(vitalSignGridItem);
            vitalSignGridItem = new VitalSignGridItemConfig("体重", "体重", "KG", "表格渲染器1", 1);
            vitalSignGroup.GridItemConfigs.Add(vitalSignGridItem);
            model.Groups.Add(vitalSignGroup);
            this.viewmodel.groupmodel.Add(vitalSignGroup);
            //   用药
            if (viewdata.CacheDrugList != null && viewdata.CacheDrugList.Count() > 0)
            {
                ExeRouteGroupModel routeGroupModel = new DrugAdapter().GetGroupModelN("用  药",
                    (new SplitSrv8OrdBP()).execN(viewdata.CacheDrugList),
                    model.PageBeginDate);
                model.Groups.Add(routeGroupModel);
                this.viewmodel.groupmodel.Add(routeGroupModel);
            }
            var eventLabelGroupModel = new ExeEventGroupModel();

            Dictionary<ClinicalExeEventStatus, List<OrSplitOrderDTO>> risdic =
                DiagtreatUtils.mergeRisDTO(viewdata.CacheObsList);
            var routeGroupModel1 = new ExeEventGroupModel();
            routeGroupModel1.Name = "检查";
            if (risdic.ContainsKey(ClinicalExeEventStatus.RIS))
                new DrugAdapter().getEventGroup(routeGroupModel1, risdic[ClinicalExeEventStatus.RIS],
                    ClinicalExeEventStatus.RIS);
            if (risdic.ContainsKey(ClinicalExeEventStatus.Pathol))
                new DrugAdapter().getEventGroup(routeGroupModel1, risdic[ClinicalExeEventStatus.Pathol],
                    ClinicalExeEventStatus.Pathol);
            model.Groups.Add(routeGroupModel1);
            this.viewmodel.groupmodel.Add(routeGroupModel1);

            var lisrouteGroupModel = new ExeEventGroupModel();
            lisrouteGroupModel.Name = "检验";
            new DrugAdapter().getEventGroup(lisrouteGroupModel, viewdata.CacheLabList.ToList(),
                ClinicalExeEventStatus.LIS);
            model.Groups.Add(lisrouteGroupModel);
            this.viewmodel.groupmodel.Add(lisrouteGroupModel);

            eventLabelGroupModel = this.viewmodel.getMrList(viewdata.MrcasList, viewdata.CimrsList);
            model.Groups.Add(eventLabelGroupModel);
            this.viewmodel.groupmodel.Add(eventLabelGroupModel);

            eventLabelGroupModel = new ExeEventGroupModel();
            eventLabelGroupModel.Name = "临床事件";
            model.Groups.Add(eventLabelGroupModel);
            this.viewmodel.groupmodel.Add(eventLabelGroupModel);

            eventLabelGroupModel = new ExeEventGroupModel();
            eventLabelGroupModel.Name = "护理文书";
            model.Groups.Add(eventLabelGroupModel);
            this.viewmodel.groupmodel.Add(eventLabelGroupModel);

            _clinicalTimelineView.Model = model;
            _clinicalTimelineView.RefreshData();
        }

        protected override void OnLoadData()
        {
        }

        protected override void OnFillData()
        {
            DateTime ttest = DateTime.Now;
            //var startDate = new DateTime(2016, 1, 1);
            //var dtmp = DateTime.Today;
            //DateTime endDate = new DateTime(dtmp.Year, dtmp.Month, dtmp.Day,23,59,59);
            //if (ipdto != null && ipdto.Dt_acpt != null)
            //{
            //    if (DateTime.TryParse(ipdto.Dt_acpt.ToString(), out startDate)) ;
            //}
            //         startDate = new DateTime(2017, 1, 25);
            var param = new OrSrvSplitParamDTO();
            param.Id_ens = ent4BannerDto.Id_ent;
            param.Dt_split_start = null;
            param.Dt_split_end = null;
            viewmodel.refreshData(param);
            InitTimeline();
        }

        public override void OnActiveForm()
        {
            if (ent4BannerDto != null && ent4BannerDto.Id_ent != null)
            {
                //      LoadData();
            }
        }

        #region 状态处理区域

        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
            if (Created)
                OnLoadData();
        }

        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
            if (Created)
                OnLoadData();
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {
            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                if (Created)
                    LoadData();
            }
        }

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            switch (uiEvent)
            {
                case UIEvent.REFRESH:
                    LoadData();
                    break;

                case UIEvent.LOAD:

                    var dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        if (dic["PatientData"] != null)
                        {
                            ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        }
                    }
                    if (ent4BannerDto == null)
                    {
                        this.ShowMessage("没有患者信息！");
                    }

                    break;
              
            }
        }

        #endregion
    }
}