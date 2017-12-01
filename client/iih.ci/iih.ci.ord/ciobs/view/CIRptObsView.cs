using System;
using System.Drawing;
using System.Windows.Forms;
using iih.ci.ord.ciobs.viewmodel;
using iih.ci.ord.dto.orobsandlab.d;
using xap.cli.sdk.render.Items;
using xap.rui.control.basecontrol;
using xap.rui.control.engine.attributes;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciobs.view
{
    public partial class CIRptObsView : XapListControl, IWorkStationRegist
    {
      

        #region 变量定义区域
        private XapFormControl xapFormControl1;
        private CiRptObsViewModel model;
        private XLabel title, status, repdate, appno;//,obsdoc
        private OrObsAandLabDTO labdto = null;
        //private string id;
        //趋势图
        //private ReportViewer rpt_viewer = null;
        //private string serv_rptfile = "iih_report/CiRptlab.xml";

        #endregion

        #region 构造函数区域

        public CIRptObsView()
        {
            InitializeComponent();
            this.xapFormControl1 = new XapFormControl();
            this.xapFormControl1.Dock = DockStyle.Fill;
            Button bu = new Button();
           // this.Controls.Add(bu);
            this.xapFormControl1.Controls.Add(bu);
            this.Controls.Add(this.xapFormControl1);
            this.Load += new EventHandler(CIRptObsView_Load);

            this.xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);

            this.xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);

            this.model = new CiRptObsViewModel();


        }

        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            if (labdto != null)
            {
              
                this.title.ValueText = labdto.Name;
                this.repdate.ValueText = this.model.CiRptObsDo.Dt_rptobs.ToString();
                this.appno.ValueText = this.model.CiRptObsDo.No_applyform;
                this.status.ValueText = this.model.CiRptObsDo.Su_name;
                

            }

        }

        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
      //      UserRender btnOK_view = xapFormControl1.GetUserRender("des_advice", "view");
            appno = xapFormControl1.GetUserRender("des_advice", "appnoval") as XLabel;
    //        obsdoc = xapFormControl1.GetUserRender("des_advice", "obsdocval") as XLabel;
            repdate = xapFormControl1.GetUserRender("des_advice", "repdateval") as XLabel;
            status = xapFormControl1.GetUserRender("des_advice", "statusval") as XLabel;
            title = xapFormControl1.GetUserRender("des_advice", "title") as XLabel;
 //           btnOK_view.MouseClick += new MouseEventHandler(btnOK_MouseClick);
            this.xapFormControl1.SetTabPageReadOnly("des_advice", true);
        }


        void btnOK_MouseClick(object sender, MouseEventArgs e)
        {
            //MessageBox.Show("view");

            CiRptObsChart form = new CiRptObsChart();
            form.Show();

            // 填充报表查询参数
            //Dictionary<string, string> qry_params = new Dictionary<string, string>();
            //qry_params.Add("id_rptlab", "201511110800");

            //// 生成报表并刷新到界面上
            //bool res = this.rpt_viewer.ShowRptFile(serv_rptfile, qry_params);
            //if (!res)
            //{
            //    // 打印提示信息 this.rpt_viewer.GetLastMsg()
            //    return;
            //}


        }


        void CIRptObsView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

     

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令区域

        [XapCommand(Name = "CiVideo")]
        public void OnVideo()
        {
        }

        [XapCommand(Name = "Refresh")]
        public void OnRefresh()
        {

        }
        #endregion

        #region 公开函数区域

        public void setlabdto(string id_or, string type)
        {
            labdto = this.model.GetObsAandLabDto(id_or, type);
        }

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
           
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_CIRptObsView;// "20151111052932647LHK";
         
            file.FormStyle = FormStyle.List;
            if (labdto != null)
            {
                this.model.getCiRptObsDO(labdto.Id);
              ;
                file.ViewModel = this.model.CiRptObsDo;

            }
           
            this.xapFormControl1.ViewFile = file;
            this.xapFormControl1.SetEditPolicy(true);
        }


        public override void OnStatus()
        {

            SetEnable("CiVideo", true);
            SetEnable("Refresh", true);

        }

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (sender == this) //del
                return;
            labdto = e.Object as OrObsAandLabDTO;

            if (labdto != null)
            {
                if(Created)
                this.LoadData();
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
                case UIEvent.REFRESH:
                    this.LoadData();
                    break;
                case "CiVideo":
                    VideoImage img=new VideoImage();
                    img.StartPosition = FormStartPosition.CenterScreen;
                    img.Size=new Size(800,500);
                    img.ShowDialog();
                    break;
            }
        }

        #endregion

        #region 注册与反注册到工作站
        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
            if (Created)
                this.OnLoadData();
        }
        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {

            this.model.CiRptObsDo = null;
            this.labdto = null;
            this.title.ValueText = "";
            this.appno.ValueText = "";
            this.repdate.ValueText = "";
            this.status.ValueText = "";
            if (Created)
                this.LoadData();

        }

        #endregion
    }
}
