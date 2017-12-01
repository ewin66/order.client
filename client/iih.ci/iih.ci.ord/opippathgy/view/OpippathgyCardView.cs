using System;
using System.Collections.Generic;
using System.Windows.Forms;
using iih.ci.ord.dto.orobsandlab.d;
using iih.ci.ord.opippathgy.viewmodel;
using iih.en.pv.dto.d;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.dp.rptview.viewer;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.opippathgy.view
{
    public partial class OpippathgyCardView : XapListControl, IWorkStationRegist
    {
        #region 变量定义区域

        private readonly XapFormControl xapFormControl1;
        private XLabel appno;
        public Ent4BannerDTO ent4BannerDto;
        public OrObsAandLabDTO pathgydto = null;
        private OpippathgyCardModel model;
        //private XLabelBaseUserRender pictru = null;
        private XLabel repdate;
        //趋势图
        //private ReportViewer rpt_viewer = null;
        //private string serv_rptfile = @"iih_report/46106045_CiRptLab.xml";
        private XLabel status;
        private XLabel title;

        #endregion

        #region 构造函数区域

        public OpippathgyCardView()
        {
            InitializeComponent();
            xapFormControl1 = new XapFormControl();
            xapFormControl1.Dock = DockStyle.Fill;
            xapFormControl1.FormCreated += xapFormControl1_FormCreated;
            xapFormControl1.ModelFilled += xapFormControl1_ModelFilled;
            Controls.Add(xapFormControl1);
            Load += CiRptPathgyView_Load;
            model = new OpippathgyCardModel();
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
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OpippathgyCardView;// "20160811042546838D7Z";

            file.FormStyle = FormStyle.Card;
            if (pathgydto != null)
            {
                model.getCiRptlabDO(pathgydto.Id);
                file.ViewModel = model.CiRptPathgyDo;
            }
            xapFormControl1.ViewFile = file;
        //    xapFormControl1.SetEditPolicy(true);
        }


        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (sender == this) //del
                return;
            //obsDTO = e.Object as OrObsAandLabDTO;
            pathgydto = e.Object as OrObsAandLabDTO;
            if (pathgydto != null)
            {
                if (Created)
                {
                    LoadData();
                }
            }
        }

        #endregion

        #region 公开函数区域

        public void setPatholdto(string id_or, string type)
        {
            this.pathgydto = this.model.GetObsAandLabDto(id_or, type);
        }

        #endregion

        #region 内部事件区域

        private void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            if (pathgydto != null)
            {
                title.ValueText = pathgydto.Name;
                appno.ValueText = model.CiRptPathgyDo.No_applyform;
                repdate.ValueText = model.CiRptPathgyDo.Dt_rptpathgy.ToString();
                status.ValueText = model.CiRptPathgyDo.Su_name;
            }
        }

        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            //   this.xapFormControl1.SetTopPanelHeight(60);
            appno = xapFormControl1.GetUserRender("rptpathgy", "appnoval") as XLabel;
            repdate = xapFormControl1.GetUserRender("rptpathgy", "repdateval") as XLabel;
            status = xapFormControl1.GetUserRender("rptpathgy", "statusval") as XLabel;
            title = xapFormControl1.GetUserRender("rptpathgy", "title") as XLabel;
            this.xapFormControl1.SetEditPolicy(false);
        }

        private void CiRptPathgyView_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        #endregion

        #region 辅助处理函数

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
//                 case "CiVideo":
//                     var img = new VideoImage();
//                     img.StartPosition = FormStartPosition.CenterScreen;
//                     img.Size = new Size(800, 500);
//                     img.ShowDialog();
// 
//                     break;
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
            model.CiRptPathgyDo = null;
            pathgydto = null;
            pathgydto = null;
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