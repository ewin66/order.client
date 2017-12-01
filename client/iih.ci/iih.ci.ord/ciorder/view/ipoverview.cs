using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.dto.vitalsignsdto.d;
using iih.ci.ord_stub.dto.d;
using iih.en.pv.dto.d;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.render;
using xap.cli.sdk.render.choicecard;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using xap.rui.engine.registers;
using xap.cli.sdk.render.DoctorOrderCard;
using xap.mw.core.data;
using xap.rui.appfw;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.extentions;
using xap.rui.bizcontrol.OverViewCard;
using xap.sys.ui.layoutManager;
using xap.mw.coreitf.d;
using xap.cli.sdk.common;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 住院总览


*********************************************************************************/
namespace iih.ci.ord.ciorder.view
{
    public partial class ipoverview : XapListControl, IWorkStationRegist
    {
   

    

        #region 变量定义区域
        private XapFormControl xapFormControl1;
        private IpOverViewModel model;
        public Ent4BannerDTO ent4BannerDto;
        private DashboardWidghts managecontrol;
        LayoutMColmns FirstCols;
        LayoutMColmns SecCols ;
        LayoutMColmns ThirdCols;
        private OverViewTableCard overViewTableCard;
        private ExpenseCard expenseCard;
        private VitalSignsCard vitalSignsCard;
        //private MedicalRecordCard medicaRecordCard;
        private OverViewTableCard cidiagcard;
        private OverViewTableCard ordercard;
        private PathWayCard pathWayCard;
        private ProgressNoteCard firstProgressNoteCard;
        private ProgressNoteCard endProgressNoteCard;//末次病程卡片
        private Dictionary<string,string> dict = new Dictionary<string, string>(); 
        /// <summary>
        /// 第一列宽度
        /// </summary>
        private int firstColumnWidth = 404;
        /// <summary>
        /// 第二列宽度
        /// </summary>
        private int secondColumnWidth = 612;
        /// <summary>
        /// 第三列宽度
        /// </summary>
        private int thirdColumnWidth = 612;
        #endregion

        #region 构造函数区域
        public ipoverview()
        {
            InitializeComponent();
            this.model = new IpOverViewModel();
            this.xapFormControl1 = new XapFormControl();
            this.xapFormControl1.Dock = DockStyle.Fill;
            this.xapFormControl1.Size = this.Size;
            this.Load +=new EventHandler(ipoverview_Load);
       
            managecontrol = new DashboardWidghts();
            managecontrol.Dock = DockStyle.Fill;
            managecontrol.Size = this.xapFormControl1.Size;
            managecontrol.Location = new Point(0,0);

             FirstCols = new LayoutMColmns();
             SecCols = new LayoutMColmns();
             ThirdCols = new LayoutMColmns();
            //大屏情况下列宽度的重置
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                SecCols.ColWidth = secondColumnWidth;
                FirstCols.ColWidth = firstColumnWidth;
                ThirdCols.ColWidth = thirdColumnWidth;
            }
            

             managecontrol.DiagInfoList.Add(this.FirstCols);
             managecontrol.DiagInfoList.Add(this.SecCols);
             managecontrol.DiagInfoList.Add(this.ThirdCols);

            this.xapFormControl1.AddRender(managecontrol);
            //this.Controls.Add(this.xapFormControl1);
            this.AddRender(this.xapFormControl1);
            
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

      
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            this.model = new IpOverViewModel();
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
           

            getOverViewTableCard();//过敏史
            getExpenseCard(); //费用
            getVitalSignsCard(); //生命体征
            PathWayCard();//临床路径
            getFirstEmrData();// 首次病历
            getDIList();//诊断

            //getObsList();// 检查
            //大屏情况下显示末次病程
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                getEndEmrData();//末次病程
            }
            
            getOrderList();//医嘱 处置
            //getLabList(); //检验

            //dict.Add("Id_pat", ent4BannerDto.Id_pat);
            //dict.Add("Id_ent", ent4BannerDto.Id_ent);
            //dict.Add("Code_entp", ent4BannerDto.Code_entp);
            //dict.Add("Id_entp", ent4BannerDto.Id_entp);
            managecontrol.LoadXmlDataConfig();
           // managecontrol.LoadXmlDataConfig(this.model.getportXml(""), dict);
        }

        #endregion

        #region 内部事件区域


        private void getOverViewTableCard()
        {


            if (overViewTableCard == null)
            {
                overViewTableCard = new OverViewTableCard();
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    overViewTableCard.Size = new Size(overViewTableCard.Size.Width, 104);
                }
                FirstCols.AddRender(overViewTableCard);
            }
          
            overViewTableCard.Location = new Point(10,10);
            overViewTableCard.Text = "过敏史";
            List<String> fieldNameList = new List<string>();
            fieldNameList.Add("Name_alcla");
            if (ent4BannerDto != null)
            {
                BindingList<Object> list = this.model.getAllergyDto(ent4BannerDto.Id_pat);
                if (list != null)
                {
                    overViewTableCard.SetData(fieldNameList, list,null);
                }
                
              
             
                //managecontrol.FirstCols.ListItems.Add(overViewTableCard);
               
                //this.xapFormControl1.Controls.Add(FirstCols);
                // this.xapFormControl1.AddRender(overViewTableCard);
            }
            else
            {
                this.SetStatusMsg("患者信息为空");
            }
        }

        //费用
        private void getExpenseCard()
        {
            if (expenseCard == null)
            {
                expenseCard = new ExpenseCard();
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    expenseCard.Size = new Size(expenseCard.Size.Width, 104);
                }
                FirstCols.AddRender(expenseCard);
               
            }
         
             expenseCard.Location = new Point(10,120);
            if (ent4BannerDto != null)
            {
                string[] amt = this.model.getBlcgAmtVsDrugRation(ent4BannerDto.Id_pat, ent4BannerDto.Id_ent, "01");
                if (amt != null && amt.Length > 0)
                {
                    expenseCard.BalanceValue(amt[0], false);
                    expenseCard.ExpendAmountValue(amt[1]);
                    expenseCard.DrugProportionValue(amt[2]);
                }
                else
                {
                    expenseCard.BalanceValue("0", false);
                    expenseCard.ExpendAmountValue("0");
                    expenseCard.DrugProportionValue("0%");
                }
            }
           
        }

        //生命体征
        private void getVitalSignsCard()
        {
            if (vitalSignsCard == null)
            {
                vitalSignsCard = new VitalSignsCard();
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    vitalSignsCard.Size = new Size(vitalSignsCard.Size.Width, 104);
                }
                FirstCols.AddRender(vitalSignsCard);
            }
          
             vitalSignsCard.Location = new Point(10,250);
            if (ent4BannerDto != null)
            {
            
                VitalSignsDto allergy = this.model.getCiorderPreviewDTOS(ent4BannerDto.Id_ent,ent4BannerDto.Dt_birth);
                FMap2 map = allergy.Infomap;
                if (allergy != null && map != null && map.Values.Count >0)
                {
                    //map["Temperature"];
                    vitalSignsCard.TemperatureValue(allergy.Temperature, (Boolean)map["Temperature"], (Boolean)map["Temperature1"]);
                    vitalSignsCard.BreathValue(allergy.Breath, (Boolean)map["Breath"], (Boolean)map["Breath1"]);
                    vitalSignsCard.PulseValue(allergy.Pulse, (Boolean)map["Pulse"], (Boolean)map["Pulse1"]);
                    vitalSignsCard.BPMinValue(allergy.Bpmin, (Boolean)map["Bpmin"], (Boolean)map["Bpmin1"]);
                    vitalSignsCard.BPMaxValue(allergy.Bpmax, (Boolean)map["Bpmax"], (Boolean)map["Bpmax1"]);
                }
            }

          
        }


        //private void getEmrList()
        //{
        //    if (medicaRecordCard == null)
        //    {
        //        medicaRecordCard = new MedicalRecordCard();
        //        medicaRecordCard.Text = "首次病程";
        //        SecCols.AddRender(medicaRecordCard); 
        //    }
           

        //   // medicaRecordCard.Location = new Point(570, 10);
        //    //大屏情况下列宽度的重置
        //    if (RelativeUIParam.ScreenSize == ScreenSize.Large)
        //    {
        //        medicaRecordCard.Size = new Size(medicaRecordCard.Size.Width, 488);
        //    }
        //    else {
        //        medicaRecordCard.Size = new Size(medicaRecordCard.Size.Width, 300);
        //    }
            
        //    // todo 
        //    List<Object> listmr = new List<object>();
        //    listmr.Add("Mainsuit_name");
        //    listmr.Add("Newillnes_name");
        //    listmr.Add("Physical_name");
        //    listmr.Add("Commonly_name");
        //    if (ent4BannerDto != null)
        //     {
        //        medicaRecordCard.Data = this.model.getOrderPandectEmrDTO("10", ent4BannerDto.Id_ent);
        //     }
        //    //medicaRecordCard.DataSource = listmr;

        //    //   medicaRecordCard.MouseDoubleClick += new MouseEventHandler(ContentControl_MouseDoubleClick);
        //}
        /// <summary>
        /// 创建末次病程卡片
        /// </summary>
        private void getFirstEmrData()
        {
            if (firstProgressNoteCard == null)
            {
                firstProgressNoteCard = new ProgressNoteCard();
                firstProgressNoteCard.Text = "首次病程";
                SecCols.AddRender(firstProgressNoteCard);
            }
            //大屏情况下列宽度的重置
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                    firstProgressNoteCard.Size = new Size(firstProgressNoteCard.Size.Width, 488);
            }
            else {
                    firstProgressNoteCard.Size = new Size(firstProgressNoteCard.Size.Width, 300);
            }
            if (ent4BannerDto != null)
             {
                FMap2 dataMap = this.model.getEndEmrData(ent4BannerDto.Id_ent, FBoolean.True);
                string dateStr = "", typeStr = "", endEmrDataStr = "";
                if (dataMap.Keys.Contains("dt_rd"))
                {
                    dateStr = (dataMap["dt_rd"] as FDateTime).ToString();
                }
                if (dataMap.Keys.Contains("mrtp_name"))
                {
                    typeStr = dataMap["mrtp_name"] as string;
                }
                if (dataMap.Keys.Contains("strArea"))
                {
                    endEmrDataStr = dataMap["strArea"] as string;
                }
                firstProgressNoteCard.SetData(dateStr, typeStr, endEmrDataStr);
             }
        }
        /// <summary>
        /// 创建末次病程卡片
        /// </summary>
        private void getEndEmrData()
        {
            if (endProgressNoteCard == null) {
                endProgressNoteCard = new ProgressNoteCard();
                endProgressNoteCard.Text = "最近病程";
                SecCols.AddRender(endProgressNoteCard);
            }
            endProgressNoteCard.Size = new Size(endProgressNoteCard.Size.Width, 364);
            if (ent4BannerDto != null)
            {
                FMap2 dataMap = this.model.getEndEmrData(ent4BannerDto.Id_ent,FBoolean.False);
                string dateStr ="",typeStr="",endEmrDataStr="";
                if(dataMap.Keys.Contains("dt_rd")){
                    dateStr = (dataMap["dt_rd"] as FDateTime).ToString();
                }
                if(dataMap.Keys.Contains("mrtp_name")){
                    typeStr = dataMap["mrtp_name"] as string;
                }
                if(dataMap.Keys.Contains("strArea")){
                    endEmrDataStr = dataMap["strArea"] as string;
                }
                endProgressNoteCard.SetData(dateStr, typeStr, endEmrDataStr);
            }
        }
    
        // 病历事件
        void ContentControl_MouseDoubleClick(object sender, MouseEventArgs e)
        {
           // this.ShowInfo("view");
            // 46106025
            if (SwitchFuncPage != null)
            {
                DictionaryEventArgs args = new DictionaryEventArgs();
                args.Data["FuncCode"] = "46106025";
                args.Data["index"] = "";
                SwitchFuncPage(this, args);
            }
        }

        private void getDIList()
        {
            if (cidiagcard == null)
            {
                cidiagcard = new OverViewTableCard();
                //大屏下诊断放到第一列
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    this.FirstCols.AddRender(cidiagcard);
                    cidiagcard.Size = new Size(cidiagcard.Size.Width, 364);
                }
                else {
                    //小屏下诊断放到第二列
                SecCols.AddRender(cidiagcard);
                    cidiagcard.Size = new Size(cidiagcard.Size.Width, 300);
                }
            }
           
            cidiagcard.Text = "诊断";
           
            List<string> fieldNameList = new List<string>();
            fieldNameList.Add("name");
            BindingList<object> valueList = new BindingList<object>();
            if (ent4BannerDto != null && ent4BannerDto.Id_ent != null)
            {
                
                XapDataList<IpViewDiagDTO> listCiDi = this.model.GetDiagDataList(ent4BannerDto.Id_ent);
                if (listCiDi != null && listCiDi.Count > 0)
                {
                    var tmpDiList = listCiDi.OrderBy(u => (u as IpViewDiagDTO).Sortno);
                    foreach (IpViewDiagDTO item in tmpDiList)
                {
                    valueList.Add(item);
                }
                }
               

            }
            cidiagcard.SetData(fieldNameList, valueList,null);

            cidiagcard.MouseDoubleClick += new MouseEventHandler(cidiagcard_MouseDoubleClick);
        }

        
        //诊断
        void cidiagcard_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data["FuncCode"] = "46106020";
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
      
            //managecontrol.SecCols.ListItems.Add(ordercard); 
            ordercard.Text = "医嘱";
            //大屏下的医嘱列表
            if (RelativeUIParam.ScreenSize == ScreenSize.Large)
            {
                ordercard.Size = new Size(ordercard.Size.Width, 859);
            }
            else {
            ordercard.Size = new Size(ordercard.Size.Width, 430);
            }

            List<string> fieldNameList = new List<string>();
            fieldNameList.Add("Content_or");
            List<XCellRender> columnEditList=new List<XCellRender>();
            DoctorOrderCard card=new DoctorOrderCard ();
            columnEditList.Add(card);
            BindingList<object> valueList = new BindingList<object>();
            if (ent4BannerDto != null && ent4BannerDto.Id_ent != null)
            {
                XapDataList<CiOrderDO> listorder = this.model.GetCiOrderDataList(ent4BannerDto.Id_ent);
                
              
                foreach (CiOrderDO item in listorder)
                {
                    valueList.Add(item);
                }
               
            }
            //ordercard.DataView.DataTable.DataDisplay += new EventHandler<XDataDisplayEventArgs>(tabControl_DataDisplay);

            ordercard.SetData(fieldNameList, valueList, columnEditList.ToArray());
            ordercard.MouseDoubleClick += new MouseEventHandler(tableView_MouseDoubleClick);
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

         //医嘱
        void tableView_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data["FuncCode"] = "46106015";
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
           // this.xapFormControl1.AddRender(obs);
           // managecontrol.ThirdColumn.ListItems.Add(obs);
           
        }

        void obs_DoubleClick(object sender, EventArgs e)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data["FuncCode"] = "46106040";
            args.Data["index"] = "";
            SwitchFuncPage(this, args);
        }
      
        private void getLabList()
        {
            XTextCardPannel lab = new XTextCardPannel();
         
            List<string> list = new List<string>();
            list.Add("Name_srv");
            list.Add("Val_rstrptlab");
            //list.Add("Id_srv_rptlab");
            list.Add("Unit_name");
            //list.Add("Name_deviate");
            //list.Add("Val_max");
            lab.TypeList = list;//将用户所需要的反射的属性集合提进去
            if (ent4BannerDto != null)
            {
                IBindingList LIST = this.model.getCiRptItemList(ent4BannerDto.Id_ent);
                lab.DataSource = LIST;//将用户所提供的数据放进去
            }
            
            lab.XL_title.Text = "检验";//容器的名字。
            lab.Size = new Size(650, 100);
            lab.Location = new Point(570, 460);
            lab.MouseDoubleClick += new MouseEventHandler(xx_MouseDoubleClick);
            this.xapFormControl1.AddRender(lab);
        }
        /// <summary>
        /// 创建临床路径卡片
        /// </summary>
        private void PathWayCard()
        {
            if ( pathWayCard == null)
            {
                pathWayCard = new PathWayCard();
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    pathWayCard.Size = new Size(pathWayCard.Size.Width, 157);
                }
                FirstCols.AddRender(pathWayCard);
            }
            pathWayCard.Text = "临床路径";
            if (this.ent4BannerDto != null)
            {
              
                //int standarddays = 0;
                pathWayCard.PathName(this.ent4BannerDto.Name_cp);
                pathWayCard.InPathDate(this.ent4BannerDto.Cp_dt_enter);
                //if (this.ent4BannerDto.Cp_standarddays == "" || string.IsNullOrEmpty(this.ent4BannerDto.Cp_standarddays))
                //{
                //    standarddays =0;
                //}
                //else
                //{
                //    string[] str = this.ent4BannerDto.Cp_standarddays.Split('~');
                //    if (str != null && str.Length > 1)
                //    {
                //        string Cp_standarddays = str[1];
                //        standarddays = int.Parse(Cp_standarddays.Substring(0, Cp_standarddays.Length - 1));
                //    }
                //}
                //if (this.ent4BannerDto.Cp_in_days == null) this.ent4BannerDto.Cp_in_days = 0;
                if (this.ent4BannerDto.Def1 == null) this.ent4BannerDto.Def1 = "0";// 0 不在路径患者，1 在经患者
                pathWayCard.OnWayDays(this.ent4BannerDto.Cp_in_days + "", this.ent4BannerDto.Cp_standarddays, Int32.Parse(this.ent4BannerDto.Def1));
                pathWayCard.AverageCost(this.ent4BannerDto.Cp_avgcost);
                pathWayCard.ExpendValue(this.ent4BannerDto.Cp_cost_now);

                //if (string.IsNullOrEmpty(this.ent4BannerDto.Cp_standarddays))
                //{
                //    this.ent4BannerDto.Cp_standarddays = "0";
                //}
                //else
                //{
                //    string[] str = this.ent4BannerDto.Cp_standarddays.Split('~');
                //    if (str != null && str.Length > 1)
                //    {
                //        string Cp_standarddays = str[1];
                //        this.ent4BannerDto.Cp_standarddays = Cp_standarddays.Substring(0, Cp_standarddays.Length - 1);
                //    }

                //}
            }
        }
        /// <summary>
        /// 刷新临床路径信息
        /// </summary>
        private void PathWayCard1()
        {
            if (pathWayCard == null)
            {
                pathWayCard = new PathWayCard();
                FirstCols.AddRender(pathWayCard);
            }
            pathWayCard.Text = "临床路径";
            if (this.ent4BannerDto != null)
            {
                String[] hpcpinfo = this.model.getHpcpBannerInfo(this.ent4BannerDto.Id_ent);
                if (hpcpinfo != null && hpcpinfo.Length > 0)
                {
                    // hpcpinfo[0] = info.getCp_standarddays();//目标天数
                    // hpcpinfo[1] = info.getCp_in_days() + "";//当前在径天数
                    // hpcpinfo[2] = info.getCp_cost_now() + "";//当前费用
                    // hpcpinfo[3] = info.getCp_avgcost() + "";//平均费用
                    //hpcpinfo[4] = info.getCp_name();//路径名称
                    // hpcpinfo[5] = info.getCp_dt_enter() + "";//入经时间
                    pathWayCard.PathName(hpcpinfo[4]);
                    if (hpcpinfo[5] != null &&  hpcpinfo[5] != "")
                    {
                        pathWayCard.InPathDate(DateTime.Parse(hpcpinfo[5]));
                    }
                    else
                    {
                        pathWayCard.InPathDate(null);
                    }
                    pathWayCard.OnWayDays(hpcpinfo[1], hpcpinfo[0], 1);
                    if (hpcpinfo[3] != null && hpcpinfo[3] != "")
                    {
                        pathWayCard.AverageCost(double.Parse(hpcpinfo[3]));
                    }
                    else
                    {
                        pathWayCard.AverageCost(null);
                    }
                    if (hpcpinfo[2] != null && hpcpinfo[2] != "")
                    {
                        pathWayCard.ExpendValue(double.Parse(hpcpinfo[2]));
                    }
                    else
                    {
                        pathWayCard.ExpendValue(null);
                    }

                }
        }
        }
        void xx_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data["FuncCode"] = "46106045";
            args.Data["index"] = "";
            SwitchFuncPage(this, args);
        }


        #endregion

        #region 辅助处理函数

        public override void OnActiveForm()
        {
            

            if (this.ent4BannerDto != null && this.ent4BannerDto.Id_ent != null)
            {
                getFirstEmrData();//首次病程
                getDIList();
              
                PathWayCard1();//临床路径
                getOrderList();
                getObsList();
                getLabList();
                //大屏情况下显示末次病程
                if (RelativeUIParam.ScreenSize == ScreenSize.Large)
                {
                    getEndEmrData();//末次病程
                }
                managecontrol.LoadXmlDataConfig();
            }
        }

        private void ipoverview_Load(object sender, EventArgs e)
        {
            this.OnInit();
            this.xapFormControl1.Context = this.Context;
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
                     if(Created)
                    this.LoadData();
                    break;
                case UIEvent.RELOAD:
                    this.reload(eventArgs);
                    break;
                case UIEvent.LOAD:
                    Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        this.ent4BannerDto = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                        //if (dic.Keys.Contains("PatientData"))
                        //{
                        //    ent4BannerDto = dic["PatientData"] as PatiVisitDO;
                        //}
                        //if (dic.Keys.Contains("IsInHospitalStation"))
                        //{
                        //    ent4BannerDto.Id_ent = dic["EncounterID"].ToString();
                        //}
                        // this.OnLoadData();
                    }

                    break;
                default :
                    break;
            }
        }

        private void reload(DictionaryEventArgs eventArgs)
        {
            Dictionary<string, object> dic2 = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
            if (dic2 != null)
            {
                this.ent4BannerDto = (dic2["PatientData"] as BannerData).Ent4BannerDTO;
               
            }

        }

        #endregion
        #region 注册与反注册到工作站
        public void Regist(EventBroker eventBroker)
        {
            eventBroker.Register(this);
            if (Created) this.LoadData();
                
        }
        public void UnRegist(EventBroker eventBroker)
        {
            eventBroker.Unregister(this);
            //if (Created)
            //    this.OnLoadData();
        }

   

        public void UpdatePatientInfo(object sender, DictionaryEventArgs eventArgs)
        {
            if (eventArgs.Data.Keys.Contains("PatientData"))
            {
                object obj = eventArgs.Data["PatientData"];
                //patDo = obj as PatiVisitDO;
                this.ent4BannerDto = (obj as BannerData).Ent4BannerDTO;
                if (Created)
                    this.LoadData();

            }
        }

        #endregion


     
    }
}
