using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.dto.orderpandectemrdto.d;
using iih.ci.ord_stub.dto;
using iih.ci.ord_stub.dto.d;
using iih.en.pv.dto.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.DoctorAdvice;
using xap.cli.sdk.render.choicecard;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.render;
using xap.cli.sdk.render.DoctorOrderCard;
using xap.mw.serviceframework.extentions;
using xap.rui.appfw;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.bizcontrol.OverViewCard;
using xap.sys.ui.layoutManager;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 门诊总览


*********************************************************************************/
namespace iih.ci.ord.ciorder.view
{
    public partial class opoverview : XapListControl, IWorkStationRegist
    {
     
        #region 变量定义区域
        private XapFormControl xapFormControl1;
        private IpOverViewModel model;
        private Ent4BannerDTO ent4BannerDto;
        //private BorderControl border_di = null;
        //private BorderControl border_or = null;
        private DashboardWidghts managecontrol;
        LayoutMColmns FirstCols;
        LayoutMColmns SecCols;
        LayoutMColmns ThirdCols;

        private MedicalRecordCard medicaRecordCard;
        private OverViewTableCard cidiagcard;
        private OverViewTableCard ordercard;
        #endregion

        #region 构造函数区域
        public opoverview()
        {
         
            InitializeComponent();
            this.model = new IpOverViewModel();
            this.xapFormControl1 = new XapFormControl();
            this.xapFormControl1.Dock = DockStyle.Fill;
            this.Load += new EventHandler(opoverview_Load);
            this.Controls.Add(this.xapFormControl1);

            managecontrol = new DashboardWidghts();
            managecontrol.Dock = DockStyle.Fill;
            managecontrol.Size = this.xapFormControl1.Size;
            managecontrol.Location = new Point(0, 0);
            FirstCols = new LayoutMColmns();
            SecCols = new LayoutMColmns();
            ThirdCols = new LayoutMColmns();

            managecontrol.DiagInfoList.Add(this.FirstCols);
            managecontrol.DiagInfoList.Add(this.SecCols);
            managecontrol.DiagInfoList.Add(this.ThirdCols);

            this.xapFormControl1.AddRender(managecontrol);

        }

     
        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域
        [EventPublication("navi")]
        public event EventHandler<DictionaryEventArgs> SwitchFuncPage;

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
            if (ent4BannerDto == null) return;
            this.model = new IpOverViewModel(ent4BannerDto.Id_ent);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
           // managecontrol.FirstCols.ListItems.Clear();
            //managecontrol.SecCols.ListItems.Clear();
            //managecontrol.ThirdColumn.ListItems.Clear();

            getEmrList();
            getDIList();
            getOrderList();
            getObsList();
            getLabList();
   
            managecontrol.LoadXmlDataConfig();
        }

        #endregion

        #region 内部事件区域
        private void getEmrList()
        {
            if (medicaRecordCard == null)
            {
                medicaRecordCard = new MedicalRecordCard();
                FirstCols.AddRender(medicaRecordCard);
            }
          
            medicaRecordCard.Text = "病历";
           // medicaRecordCard.Location = new Point(570, 10);
            medicaRecordCard.Size = new Size(medicaRecordCard.Size.Width, 300);
            // todo 
            List<string> listmr = new List<string>();
            listmr.Add("Mainsuit_name");
            listmr.Add("Mainsuit_name");
            listmr.Add("Newillnes_name");
            //listmr.Add("Physical_name");
            //listmr.Add("Commonly_name");
            //BindingList<object> valueList = new BindingList<object>();
            if (ent4BannerDto != null)
            {
                // OrderPandectEmrDTO[] emrdtos = this.model.getOrderPandectEmrDTO("00", ent4BannerDto.Id_ent).ToArray();
                //if (emrdtos != null)
                //{
                //    foreach (OrderPandectEmrDTO emr in emrdtos)
                //    {
                //        valueList.Add(emr);
                //    }
                //}
                medicaRecordCard.Data = this.model.getOrderPandectEmrDTO("00", ent4BannerDto.Id_ent);
            }
            //medicaRecordCard.SetData(listmr, valueList);
       
            medicaRecordCard.MouseDoubleClick += new MouseEventHandler(ContentControl_MouseDoubleClick);

        }

        void borderControl_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            if (SwitchFuncPage != null)
            {
                DictionaryEventArgs args = new DictionaryEventArgs();
                args.Data["FuncCode"] = "46105520";
                args.Data["index"] = "";
                SwitchFuncPage(this, args);
            }
        }

        void ContentControl_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            
            // 门诊病历
            if (SwitchFuncPage != null)
            {
                DictionaryEventArgs args = new DictionaryEventArgs();
                args.Data["FuncCode"] = "46105520";
                args.Data["index"] = "";
                SwitchFuncPage(this, args);
            }
        }

        private void getDIList()
        {
            if (cidiagcard == null)
            {
              cidiagcard = new OverViewTableCard();
              SecCols.AddRender(cidiagcard);
              cidiagcard.Text = "诊断";
             
            }
            cidiagcard.Size = new Size(355, 300);
            List<string> fieldNameList = new List<string>();
            fieldNameList.Add("name");
          
            BindingList<object> valueList = new BindingList<object>();
            if (ent4BannerDto != null && ent4BannerDto.Id_ent != null)
            {
                XapDataList<IpViewDiagDTO> listCiDi = this.model.GetDiagDataList(ent4BannerDto.Id_ent);
                if (listCiDi != null && listCiDi.Count > 0)
                {
                }
                foreach (IpViewDiagDTO item in listCiDi)
                {
                    valueList.Add(item);
                }

            }
            cidiagcard.SetData(fieldNameList, valueList,null);
        

        }
        void tableViewDi_MouseDoubleClick(object sender, MouseEventArgs e)
        { //诊断
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data["FuncCode"] = "46105515";
            args.Data["index"] = "";
            SwitchFuncPage(this, args);
        }



        private void getOrderList()
        {
            if (ordercard == null)
            {
                ordercard = new OverViewTableCard();
                ordercard.DataDisplay += new EventHandler<XDataDisplayEventArgs>(tabControl_DataDisplay);
                ThirdCols.AddRender(ordercard);
            }
          
            ordercard.Size = new Size(355, 400);
            ordercard.Text = "医嘱";
            List<XCellRender> columnEditList = new List<XCellRender>();
            DoctorOrderCard card = new DoctorOrderCard();
            columnEditList.Add(card);
            ordercard.Size = new Size(450, 400);
            List<string> fieldNameList = new List<string>();
            fieldNameList.Add("Content_or");
           
            BindingList<object> valueList = new BindingList<object>();
            if (ent4BannerDto != null && ent4BannerDto.Id_ent != null)
            {
                XapDataList<CiOrderDO> listorder = this.model.GetCiOrderDataList(ent4BannerDto.Id_ent);

                if (listorder != null && listorder.Count > 0)
                {
                }
                foreach (CiOrderDO item in listorder)
                {
                    valueList.Add(item);
                }

            }
            //ordercard.DataView.DataTable.DataDisplay+= new EventHandler<XDataDisplayEventArgs>(tabControl_DataDisplay);
            
            ordercard.SetData(fieldNameList, valueList, columnEditList.ToArray());
            
           
            
            
            
            //if (border_or == null)
            //{
            //    border_or = new BorderControl();
            //}
            
            //border_or.TitleText = "处置";
            //border_or.Location = new Point(570, 10);
            //border_or.Size = new Size(650, 350);
            //XDataView tableView_order =  new XDataView();

            //tableView_order.ShowRowNumbers = true;
            //tableView_order.HeadVisible = true;
            //tableView_order.DataTable.Columns.Visible = false;
            //XDataColumn conent_or = new XDataColumn();
            //conent_or.Caption = "处置";
            //conent_or.FieldName = "Content_or";
            //conent_or.ColumnEdit = new DoctorOrderCard();
            //conent_or.DefalutWidth = 603;
            //tableView_order.DataTable.Columns.Add(conent_or);
            //tableView_order.DataTable.DataDisplay += new EventHandler<XDataDisplayEventArgs>(tabControl_DataDisplay);
            //tableView_order.Size = new Size(650, 350);
            //tableView_order.Location = new Point(570, 10);
            //tableView_order.DataTable.Columns.ResumeLayout();
            //if (patDo != null)
            //{
            //    tableView_order.DataTable.DataSource = this.model.GetCiOrderDataList(patDo.Id_ent);
            //}
            //tableView_order.DataTable.MouseDoubleClick += new MouseEventHandler(tableView_MouseDoubleClick);
            //border_or.ContentControl = tableView_order;
            
            //this.xapFormControl1.Controls.Remove(border_or);
            //this.xapFormControl1.AddRender(border_or);


        }
        void tabControl_DataDisplay(Object sender, XDataDisplayEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            if (row != null)
            {
                foreach (UserRender render in row.UserRenderList)
                {
                    if (render is DoctorOrderCard)
                    {
                        DoctorOrderCard card = render as DoctorOrderCard;

                        card.ConfigPath = "\\modules\\iihci\\ui\\commoncontent\\OrderContent.xml";
                    }
                }

            }

        }

        void tableView_MouseDoubleClick(object sender, MouseEventArgs e)
        { //处置
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data["FuncCode"] = "46105510";
            args.Data["index"] = "";
            SwitchFuncPage(this, args);
        }

        private void getObsList()
        {
            //XImageCardPannel obs = new XImageCardPannel();
            //List<string> typeList = new List<string>();
            //typeList.Add("Des_advice");//第一个为图片的名称
            //typeList.Add("Image_url");//第二个为图片本身，注意顺序不能乱。因为反射的时候有固定的规则
            //obs.TypeList = typeList;//创建为外部人员提供接口的集合--typeList中为用户所需要反射的属性名称的集合
            ////obs.XL_title.ValueText = "检查";//这个大型容器的名称
            //if (ent4BannerDto != null)
            //{
            //    obs.DataSource = this.model.GetCiRptObsList(ent4BannerDto.Id_ent);//将用户提供的数据进行绑定
            //}

            //obs.DoubleClick += new EventHandler(obs_DoubleClick);//对外部提供的双击事件的接口
            //obs.Location = new Point(10, 370);
            //obs.Size = new Size(550, 200);
            //this.xapFormControl1.AddRender(obs);


        }

        void obs_DoubleClick(object sender, EventArgs e)
        {//检查
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data["FuncCode"] = "46105530";
            args.Data["index"] = "";
            SwitchFuncPage(this, args);
        }

        private void getLabList()
        {
            XTextCardPannel lab = new XTextCardPannel();
            List<string> list = new List<string>();
            list.Add("Name_srv");
            list.Add("Val_rstrptlab");
            list.Add("Id_srv_rptlab");
            list.Add("Unit_name");
            list.Add("Name_deviate");
            list.Add("Val_max");
            lab.TypeList = list;//将用户所需要的反射的属性集合提进去
            if (ent4BannerDto != null)
            {
                IBindingList LIST = this.model.getCiRptItemList(ent4BannerDto.Id_ent);
                lab.DataSource = LIST;//将用户所提供的数据放进去
            }

            lab.XL_title.Text = "检验";//容器的名字。

            lab.Size = new Size(650, 200);
            lab.Location = new Point(570, 370);
            lab.MouseDoubleClick += new MouseEventHandler(xx_MouseDoubleClick);
            this.xapFormControl1.AddRender(lab);


        }

        void xx_MouseDoubleClick(object sender, MouseEventArgs e)
        {//检验
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data["FuncCode"] = "46105525";
            args.Data["index"] = "";
            SwitchFuncPage(this, args);
        }

        #endregion

        #region 辅助处理函数

        public override void OnActiveForm()
        {
            if (this.ent4BannerDto != null && this.ent4BannerDto.Id_ent != null)
            {
                getEmrList();
                getDIList();
                getOrderList();
                getObsList();
                getLabList();

                managecontrol.LoadXmlDataConfig();
            }
        }

        void opoverview_Load(object sender, EventArgs e)
        {
            this.OnInit();
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
                case UIEvent.LOAD:
                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null && dic.ContainsKey("PatientData") && dic["PatientData"] != null)
                    {
                        this.ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                       
                    }

                    break;
                default:
                    break;
            }
        }

        #endregion

        #region 注册与反注册到工作站
        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
            if (Created)
                this.LoadData();
        }
        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
            if (Created)
                this.OnLoadData();
        }

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {
            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                if (Created)
                    this.LoadData();

            }
        }


        #endregion
    }
}
