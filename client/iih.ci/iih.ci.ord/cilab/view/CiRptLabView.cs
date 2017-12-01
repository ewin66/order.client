using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.cilab.viewmodel;
using iih.ci.ord.cirptlab.d;
using iih.ci.ord.dto.orobsandlab.d;
using iih.en.pv.dto.d;
using iih.en.pv.pativisit.d;
using xap.cli.sdk.chart;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.dp.rptview.viewer;
using xap.mw.coreitf.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.ClinicalTimeline.reportTypeInfo;
using xap.rui.control.basecontrol;
using xap.rui.control.engine.attributes;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.cilab.view
{
    public partial class CiRptLabView : XapListControl, IWorkStationRegist
    {
        #region 变量定义区域

        private readonly XapFormControl xapFormControl1;
        private XLabel appno;
        public Ent4BannerDTO ent4BannerDto;
        private OrObsAandLabDTO labdto = null;
        private CiRptlabViewModel model;
        //private OrObsAandLabDTO obsDTO = null;
        public PatiVisitDO patDo = new PatiVisitDO();
        //private XLabelBaseUserRender pictru = null;
        private XLabel repdate;
        private CliTestView TestView;
        //趋势图
        //private ReportViewer rpt_viewer = null;
        //private string serv_rptfile = @"iih_report/46106045_CiRptLab.xml";
        private XLabel status;
        private XLabel title;

        #endregion

        #region 构造函数区域

        public CiRptLabView()
        {
            InitializeComponent();
            xapFormControl1 = new XapFormControl();
            xapFormControl1.Dock = DockStyle.Fill;
            xapFormControl1.FormCreated += xapFormControl1_FormCreated;
            xapFormControl1.ModelFilled += xapFormControl1_ModelFilled;
            model = new CiRptlabViewModel();
            Controls.Add(xapFormControl1);
            Load += CiRptLabView_Load;
        }

        #endregion


        #region 公开函数区域

        public void setlabdto(string id_or, string type, CliTestView testView)
        {
            this.TestView = testView;
            labdto=this.model.GetObsAandLabDto(id_or, type);
        }

        #endregion


        #region 命令区域

        [XapCommand(Name = "CiTrend")]
        public void OnTrend()
        {
        }

        [XapCommand(Name = "Refresh")]
        public void OnRefresh()
        {

        }
        #endregion


        #region 父类继承区域

        /// <summary>
        ///     获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            
        }

        /// <summary>
        ///     CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            var file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_CiRptLabView;// "20151112020237400FY2";

            file.FormStyle = FormStyle.Card;
            if (labdto != null)
            {
                model.getCiRptlabDO(labdto.Id);
                file.ViewModel = model.AggDo;
            }

            xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);
        }


        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (sender == this) //del
                return;
            //obsDTO = e.Object as OrObsAandLabDTO;
            labdto = e.Object as OrObsAandLabDTO;
            if (labdto != null)
            {
                if (Created)
                {
                    LoadData();
                }
            }
        }

        public override void OnStatus()
        {
            SetEnable("CiTrend", true);
            SetEnable("Refresh", true);
         
        }

        #endregion

        #region 内部事件区域

        private void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            if (labdto != null)
            {
                title.ValueText = labdto.Name;
                appno.ValueText = model.cirptlabAggDO.getParentDO().No_applyform;
                repdate.ValueText = model.cirptlabAggDO.getParentDO().Dt_rptlab.ToString();
                status.ValueText = model.cirptlabAggDO.getParentDO().Name_rpttp;
            }
        }

        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            //   this.xapFormControl1.SetTopPanelHeight(60);
            appno = xapFormControl1.GetUserRender("title", "appnoval") as XLabel;
            repdate = xapFormControl1.GetUserRender("title", "repdateval") as XLabel;
            status = xapFormControl1.GetUserRender("title", "statusval") as XLabel;
            title = xapFormControl1.GetUserRender("title", "title") as XLabel;

            // 注册 DataDisplay事件，处理检验值
            xapFormControl1.DataDisplay += XapFormControl1_DataDisplay;

            XapFormGridControl gv_or = xapFormControl1.GetGridView("reportitem");
            gv_or.DataTable.SelectedAllChanged += test;
            gv_or.DataTable.SelectedRowChanged += test2;
        }

        private void test(Object sender, EventArgs eventArgs)
        {
            CiRptLabItmDO[] items = xapFormControl1.GetSelected<CiRptLabItmDO>("reportitem");
            if (items.Count() > 0 && TestView != null)
            {
            this.TestView.ShowReportButton.Enabled = true;
            }else if (items.Count() == 0 && TestView != null)
            {
                this.TestView.ShowReportButton.Enabled = false;
            }
        }
        private void test2(Object sender, EventArgs eventArgs)
        {
            CiRptLabItmDO[] items = xapFormControl1.GetSelected<CiRptLabItmDO>("reportitem");
            if (items.Count() > 0 && TestView != null)
            {
                this.TestView.ShowReportButton.Enabled = true;
            }
            else if (items.Count() == 0 && TestView != null)
            {
                this.TestView.ShowReportButton.Enabled = false;
            }
        }

        private void XapFormControl1_DataDisplay(object sender, xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs e)
        {
            
        }

        private void CiRptLabView_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        #endregion

        #region 辅助处理函数

        public List<Reportlab> getlisRptList(string idpat,string dts)
        {
            FDateTime tmp = new FDateTime(dts);
            DateTime dt = (tmp.ToTarget).AddDays(100);
            var dt2 = new DateTime(dt.Year, dt.Month, dt.Day);
            var list = new List<Reportlab>();
            CiRptLabItmDO[] items = xapFormControl1.GetSelected<CiRptLabItmDO>("reportitem");
            if (idpat != null)
            {
                list = model.getLabRpts4TreatView(idpat,dt2,  items);
            }

            return list;
        }

        public string[] getHeader()
        {
            string[] ss = {title.ValueText, appno.ValueText, repdate.ValueText, status.ValueText};
            return ss;
        }

        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            var newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.REFRESH:
                    LoadData();
                    break;
                case "CiTrend":
                    CiRptLabItmDO[] items = xapFormControl1.GetSelected<CiRptLabItmDO>("reportitem");
                    if (ent4BannerDto != null && ent4BannerDto.Id_pat != null)
                    {
                        var img = new Rptimg();
                        img.listReList = model.getCiRptlabAggDO(ent4BannerDto.Id_pat, 15, items);
                        if (img.listReList != null && img.listReList.Count != 0)
                        {
                            img.drawImg();
                            img.ShowDialog();
                        }
                    }

                    break;
                case UIEvent.LOAD:

                    var dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        object obj;
                        if (dic.TryGetValue("PatientData", out obj))
                        {
                            ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                        }
                        else if (dic.TryGetValue("ent4DTO", out obj))
                        {
                            ent4BannerDto = obj as Ent4BannerDTO;
                            if (Created)
                            {
                                LoadData();
                            }
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

        #region 注册与反注册到工作站

        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
            if (Created)
                OnLoadData();
        }

        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {
            model.AggDo = null;
            labdto = null;
            title.ValueText = "";
            appno.ValueText = "";
            repdate.ValueText = "";
            status.ValueText = "";
            if (Created)
                LoadData();
        }

        #endregion
    }
}