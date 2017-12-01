using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ciorder.viewmodel;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.data;
using xap.rui.control.refcontrol.events;
using xap.rui.control.forms.control;
using xap.mw.core.data;
using xap.rui.control.extentions;
using xap.rui.engine.registers;
using xap.rui.engine.eventbroker;
using xap.rui.engine;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.iih.ci.ord.i;
using System.IO;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// 胰岛素注射液医疗单
    /// </summary>
    /// Author:admin
    /// Date:2016-5-10
    public partial class OrderINSView : CiorderBaseControl
    {
        #region 变量定义区域
        XapFormGridControl gv, gv_change;
        private XLabelBaseUserRender drugChange;
        //private XGroupBox group;
        private XTabPage sugarLine;
        Dictionary<string, UserRender> dic = new Dictionary<string, UserRender>();
        //记录单位名称
        Dictionary<string, string> mapUnit = new Dictionary<string, string>();
        EmsOrDrug drug = new EmsOrDrug();
        OrderDrugDesView desView = new OrderDrugDesView() { Dock = DockStyle.Fill };
        private string[] exctimes;//首日执行时间
        private string[] adjustHeightIds = new string[] { ""};//{ "dt_begin_ui", "Use_days", "dt_end_ui", "quan_firday_mp", "work_time", "name_dep", "fg_self", "fg_outp", "fg_propc", "fg_treat", "note_or", "ci", "day" };
        private string[] allHeightIds = new string[] { "bak_des", "dt_fail"};
        private int gv_change_height=0;
        private int h = 0;//失效日期和备用条件引起变动高度
        private Point initPoint = new Point(0,0);
        private bool isMove = true;//计算控件动态位置，初始化计算一次，以后不再计算

        private XTabPage informationPageControl;//相关信息页签
        private Dictionary<string, string> inforDict;//相关pdf文件对应的字典
        private List<XLinkButton> linkList;
        #endregion

        #region 构造函数区域
        public OrderINSView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderDrugsView_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            this.xapFormControl1.RefResult += this.OnRefResult;
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            xapFormControl1.DataChanging += new EventHandler<DataChangingEventArgs>(xapFormControl1_DataChanging);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
            SheetName = "胰岛素医疗单";
        }








        #endregion

        #region 公开属性区域

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
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderINSView;// "201605060316075137HX";
            file.FormStyle = FormStyle.Card;
            EmsHeadDO.Emsdrugs.Fg_dose_anoma = true;
            file.ViewModel = EmsHeadDO.Emsdrugs;
            this.xapFormControl1.ViewFile = file;
            //xapFormControl1.SetEditPolicy(true);

        }

        //频次
        protected override void OnRefResult(object sender, RefResultEventArgs e)
        {

            //长临标志：根据选择的频次，默认读取BD_FREQ. fg_long显示长临标志。
            if (e.BindingFieldName == "Name_freq")
            {
                RefDataCollection data = e.RefResultSet;
                string id_freq = data.FirstData["Id_freq"] as string;//获取字段值
                EmsHeadDO.Emsdrugs.Sd_frequnitct = data.FirstData["Sd_frequnitct"] as string;
                EmsHeadDO.Emsdrugs.Freqct = null;
                if (data.FirstData["Freqct"].ToString() != "")
                    EmsHeadDO.Emsdrugs.Freqct = int.Parse(data.FirstData["Freqct"].ToString());
                EmsHeadDO.Emsdrugs.Fg_long = data.FirstData["Fg_long"].ToString() == "Y" ? true : false;
                GetMpTimes(id_freq);

                //可将下面放到算法里
                if (data.FirstData["Fg_prnor"].ToString() == "Y")// 备用医嘱 true 并且 长临为 临时
                {
                    XLabelBaseUserRender tmpRender = getControlByName("drugsUse", "fg_long");
                    h = 0;//高度变动值
                    if (tmpRender.ValueCode == "False")
                    {
                        //if (getControlByName("drugsUse", "dt_fail").Visible == false)
                        //{
                        //    h += 29;
                        //}
                        //getControlByName("drugsUse", "dt_fail").Visible = true;//临时医嘱失效日期  
                        h += 29;
                        EmsHeadDO.Emsdrugs.Dt_fail = cof.GetSpareEndTime(EmsHeadDO.Emsdrugs.Dt_begin_ui.Value);
                        //getControlByName("drugsUse", "bak_des").ValueText = "";
                    }
                    else
                    {
                        //if (getControlByName("drugsUse", "dt_fail").Visible == true)
                        //{
                        //    h += -29;
                        //}
                        //getControlByName("drugsUse", "dt_fail").Visible = false;//长期医嘱失效日期禁用

                        EmsHeadDO.Emsdrugs.Dt_fail = null;
                        EmsHeadDO.Emsdrugs.Use_days = null;
                        //getControlByName("drugsUse", "bak_des").ValueText = "执行最小间隔时间：6小时。";
                    }
                    //if (getControlByName("drugsUse", "bak_des").Visible == false)
                    //{
                    //    h += 29;
                    //}
                    //getControlByName("drugsUse", "bak_des").Visible = true;
                    h += 29;
                    if ( drugChange.Checked )
                    {
                        h += this.gv_change_height;
                    }
                    calCardMoveHeight();
                    //cof.adjustHeight(this.xapFormControl1, "drugsUse", this.allHeightIds, -h-50);
                    //this.xapFormControl1.Invalidate();
                    this.xapFormControl1.Refresh();
                }
                else
                {
                    h = 0;
                    //if (getControlByName("drugsUse", "dt_fail").Visible == true)
                    //{
                    //    h += -29;
                    //}
                    //getControlByName("drugsUse", "dt_fail").Visible = false;//临时医嘱失效日期
                    //if (getControlByName("drugsUse", "bak_des").Visible == true)
                    //{
                    //    h += -29;
                    //}
                    //getControlByName("drugsUse", "bak_des").Visible = false;

                    //cof.adjustHeight(this.xapFormControl1,"drugsUse", adjustHeightIds, 20, "up");
                    //getControlByName("drugsUse", "bak_des").ValueText = "";
                    EmsHeadDO.Emsdrugs.Dt_fail = null;
                    if (drugChange.Checked)
                    {
                        h += this.gv_change_height;
                    }
                    calCardMoveHeight();
                    //cof.adjustHeight(this.xapFormControl1, "drugsUse", this.allHeightIds, -h + 30);
                    this.xapFormControl1.Refresh();
                }
                //首日执行 只针对频次周期类型为‘天’的医嘱才可录入和显示首日执行次数，其他情况该控件隐藏。

                string name_freq = data.FirstData["Name"] as string;//获取字段值
                if (name_freq.Contains("日"))
                {
                    //getControlByName("drugsUse", "quan_firday_mp").Enabled = true;//首日执行次数
                    //getControlByName("drugsUse", "work_time").Enabled = false;//首日执行时间
                }
                else
                {
                    //getControlByName("drugsUse", "quan_firday_mp").Enabled = false;//首日执行次数
                    //getControlByName("drugsUse", "work_time").Enabled = false;//首日执行时间

                }
                string code_freq = data.FirstData["Code"] as string;//获取字段值
                if (code_freq == "once")
                {
                    EmsHeadDO.Emsdrugs.Fg_long = false;//长临标识 变临时
                    getControlByName("drugsUse", "fg_long").Enabled = false;// 

                    EmsHeadDO.Emsdrugs.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                }
                else
                {
                    // getControlByName("drugsUse", "fg_long").Enabled = true;// 
                }
                //长临标识可更改
                if (data.FirstData["Fg_long_edit"].ToString() == "Y")
                {
                    getControlByName("drugsUse", "fg_long").Enabled = true;
                }
                else
                {
                    getControlByName("drugsUse", "fg_long").Enabled = false;
                }

                if (EmsHeadDO.Emsdrugs.Fg_long == false)
                { //如果是临时的 使用天数和结束日期置灰
                    getControlByName("drugsUse", "Use_days").Enabled = false;
                    getControlByName("drugsUse", "dt_end_ui").Enabled = false;
                }
                else
                {
                    getControlByName("drugsUse", "Use_days").Enabled = true;
                    getControlByName("drugsUse", "dt_end_ui").Enabled = true;
                }

            }
            else if (e.BindingFieldName.Equals("Name_unit_sale"))
            {
                cof.GetDrugTotal(EmsHeadDO);
            }
        }

        private void GetMpTimes(string id_freq)
        {
            GetDoseDrugData(id_freq);
            string exctime = cof.GetWorkTime(id_freq);
            if (exctime != null && exctime != "")
            {
                exctimes = exctime.Split(';');
                Array.Sort(exctimes);
                Array.Reverse(exctimes);

            }
            else
            {
                return;
            }
            DateTime? dt = EmsHeadDO.Emsdrugs.Dt_begin_ui;
            //XLabelBaseUserRender tmpUserRender = this.xapFormControl1.GetUserRender("drugsUse", "quan_firday_mp") as XLabelBaseUserRender;
            //XNumbericUpDown numRender = tmpUserRender.UserRender as XNumbericUpDown;
            if (dt != null)
            {
                DateTime nowdt = (DateTime)dt;
                string nowtime = nowdt.ToShortTimeString().ToString();
                string worktime = "";
                int numf = 0;
                for (int i = 0; i < exctimes.Length; i++)
                {
                    DateTime dt1 = Convert.ToDateTime(exctimes[i]);
                    DateTime dt2 = Convert.ToDateTime(nowtime);
                    if (dt1.CompareTo(dt2) >= 0)//大于等于
                    {
                        numf++;
                        if (worktime != "")
                        {
                            worktime = ";" + worktime;
                        }
                        worktime = exctimes[i] + worktime;
                    }
                }
                EmsHeadDO.Emsdrugs.Work_time = worktime;
                //不用重新计算
                //numRender.ValueText = numf.ToString();
            }

            //首日最大执行次数
            int? freqct = EmsHeadDO.Emsdrugs.Freqct;
            int numgreqct = 0;
            if (freqct != null)
            {
                numgreqct = (int)freqct;
            }

            //numRender.MaxValue = (double)numgreqct;
            //numRender.MinValue = 0;


            drugChange_ValueChanged(null, null);
        }
        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName == "Name_route")
            {
                e.WherePart = string.Format("id_route in ({0})", new GetSrvVsRouteImp().GetDosageVsRounte("'" + string.Join("','", EmsHeadDO.Emsdrugs.EmsOrDrugList.Select(p => p.Id_srv).ToList()) + "'"));
            }
            //不需要添加
            if (e.BindingFieldName.Equals("Name_dep"))
            {
                if (EmsHeadDO.Emsdrugs.Str_mp_dep_ids != null && EmsHeadDO.Emsdrugs.Str_mp_dep_ids != "")
                    e.WherePart = string.Format(" id_dep in({0})", EmsHeadDO.Emsdrugs.Str_mp_dep_ids);
            }

            if (e.BindingFieldName.Equals("Name_unit_sale"))//计量单位
            {

                if (drug.Str_unit_pkg_ids != null && drug.Str_unit_pkg_ids != "")
                    e.WherePart = string.Format("id_measdoc in ({0})", drug.Str_unit_pkg_ids);
            }
            if (e.BindingFieldName.Equals("Name_freq"))
            {
                e.WherePart = string.Format("bd_freq.FG_ACTIVE='Y'", drug.Str_unit_pkg_ids);
            }
            if (e.BindingFieldName.Equals("Name_routedes"))
            {
                e.WherePart = string.Format("BD_ROUTE_DES.FG_ENTP_IP='Y'");
            }
        }



        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            if (headDo != null)
            {
                EmsHeadDO = headDo;

                if (headDo.IsNEW)
                {
                    if (headDo.Emsdrugs.EmsOrDrug.FirstOrDefault() != null)
                    {
                        EmsOrDrug or = new EmsOrDrug();
                        //or = cof.DoCopy<EmsOrDrug>(headDo.Emsdrugs.EmsOrDrug.FirstOrDefault());
                        //headDo.Emsdrugs.EmsOrDrugList.Add(or);
                        drug = headDo.Emsdrugs.EmsOrDrugList[0];
                    }

                }

            }

            if (this.Created)
            {
                this.LoadData();
            }

        }

        #endregion

        #region 内部事件区域
        void OrderDrugsView_Load(object sender, System.EventArgs e)
        {
            OnInit();
        }
        void xapFormControl1_DataChanging(object sender, DataChangingEventArgs e)
        {

            switch (e.PropName)//计算结束日期
            {
                case "Dt_begin_ui":
                    //DateTime adm = CommonExtentions.NowTime(this);//TODO: 入院时间
                    string info = cof.CompareWithAdmission(EmsHeadDO.PatInfo.Id_ent, EmsHeadDO.Emsdrugs.Dt_begin_ui);
                    if (info != "")
                    {
                        this.ShowInfo(info);
                        e.Cancel = true;
                    }
                    break;
                case "Dt_end_ui":
                    //string ipt = (string)e.Input;
                    //DateTime dtb = (DateTime)EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    //if (EmsHeadDO.Emsdrugs.Dt_end_ui == null) return;
                    //DateTime dte = DateTime.Parse(ipt); 
                    //if (dtb.CompareTo(dte) > 0)
                    //{

                    //    e.Cancel = true;
                    //    EmsHeadDO.Emsdrugs.Dt_end_ui = dtb;
                    //    this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                    //}
                    break;
                case "Quan_med"://验证剂量必须大于0

                    double? quantmp = EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Quan_med;
                    if (quantmp <= 0)
                    {
                        this.ShowInfo("剂量必须大于0！");
                        e.Cancel = true;
                        //EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Quan_med = 1;

                    }

                    break;
                default: break;
            }


        }
        private string uday = "";
        void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {

            switch (e.PropName)//计算结束日期
            {
                case "Use_days"://医嘱天数


                    if (uday == "-1")
                    {
                        uday = "";
                        return;
                    }
                    if (EmsHeadDO.Emsdrugs.Use_days == null)
                    {
                        EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                        return;
                    }


                    if (EmsHeadDO.Emsdrugs.Use_days == 0)
                    {
                        if (EmsHeadDO.Emsdrugs.Dt_end_ui != EmsHeadDO.Emsdrugs.Dt_begin_ui)
                        {
                            EmsHeadDO.Emsdrugs.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                        }
                        return;
                    }
                    else if (EmsHeadDO.Emsdrugs.Use_days == -1 && EmsHeadDO.Emsdrugs.Dt_end_ui == null)
                    {
                        XLabelBaseUserRender tmpUserRender2 = sender as XLabelBaseUserRender;
                        uday = "-1";
                        tmpUserRender2.ValueText = "";

                        //EmsHeadDO.Emsdrugs.Use_days = null;
                        return;
                    }
                    else if (EmsHeadDO.Emsdrugs.Use_days == -1)
                    {
                        EmsHeadDO.Emsdrugs.Use_days = null;
                        EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                        return;
                    }
                    else if (EmsHeadDO.Emsdrugs.Use_days > 0)
                    {
                        DateTime? endDateTime = cof.GetEndTime(EmsHeadDO.Emsdrugs.Dt_begin_ui, EmsHeadDO.Emsdrugs.Use_days.Value);
                        if (EmsHeadDO.Emsdrugs.Dt_end_ui != endDateTime)
                        {
                            EmsHeadDO.Emsdrugs.Dt_end_ui = endDateTime;
                        }


                    }

                    //取模
                    int? m = EmsHeadDO.Emsdrugs.Use_days % 7;
                    //判断周期类型错误
                    //if (EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
                    if (EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
                    {
                        if (m == 6)
                        {//减的 
                            int? uu = EmsHeadDO.Emsdrugs.Use_days / 7;


                            EmsHeadDO.Emsdrugs.Use_days = uu * 7;
                        }
                        else
                        {
                            int? uu = EmsHeadDO.Emsdrugs.Use_days / 7;
                            EmsHeadDO.Emsdrugs.Use_days = (uu + 1) * 7;
                        }

                    }

                    uday = "";
                    break;
                case "Dt_end_ui"://计算医嘱天数


                    DateTime dtb = (DateTime)EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    if (EmsHeadDO.Emsdrugs.Dt_end_ui == null) return;
                    DateTime dte = (DateTime)EmsHeadDO.Emsdrugs.Dt_end_ui;
                    if (dtb.CompareTo(dte) > 0)
                    {

                        // e.Cancel = true;
                        EmsHeadDO.Emsdrugs.Dt_end_ui = dtb;
                        this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                        return;
                    }

                    int? useDay = cof.GetUseDays(dtb, EmsHeadDO.Emsdrugs.Dt_end_ui);
                    if (EmsHeadDO.Emsdrugs.Use_days != useDay)
                    {
                        EmsHeadDO.Emsdrugs.Use_days = useDay;
                    }
                    EmsOrDrug drug = EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
                   // if (getControlByName("drugsUse", "fg_outp").ValueText == "true")
                    //{
                       // drug.Quan_cur = cof.GetDrugUseTotalCount(EmsHeadDO);
                        //cof.GetDrugTotal(EmsHeadDO);
                   // }


                    break;
                case "Name_freq"://计算执行时刻1
                    if (e.Input != null && e.Input.ToString().Contains("日"))
                    {
                       // getControlByName("drugsUse", "quan_firday_mp").Enabled = true;
                        //getControlByName("drugsUse", "work_time").Enabled = false;
                        GetMpTimes(EmsHeadDO.Emsdrugs.Id_freq);
                    }
                    else if (e.Input != null && (e.Input.ToString().Contains("周") || e.Input.ToString().Contains("星期")))
                    {
                        //取模
                        m = EmsHeadDO.Emsdrugs.Use_days % 7;
                        if (m == 6)
                        {//减的 
                            int? uu = EmsHeadDO.Emsdrugs.Use_days / 7;


                            EmsHeadDO.Emsdrugs.Use_days = uu * 7;
                        }
                        else
                        {
                            int? uu = EmsHeadDO.Emsdrugs.Use_days / 7;
                            EmsHeadDO.Emsdrugs.Use_days = (uu + 1) * 7;
                        }

                    }
                    else
                    {
                       // getControlByName("drugsUse", "quan_firday_mp").Enabled = false;
                        //getControlByName("drugsUse", "work_time").Enabled = false;
                    }

                    //  先于 OnRefResult(object sender, RefResultEventArgs e)执行，会出现  这个地方获取的id 是上次的 而不是最新的
                    break;
                case "Fg_long":
                    if (e.Input.ToString() == "False")
                    {

                        getControlByName("drugsUse", "Use_days").Enabled = false;//临时 医嘱天数 不可输入
                        EmsHeadDO.Emsdrugs.Use_days = 1;


                    }
                    else
                    {
                        if (getControlByName("drugsUse", "Use_days") != null)
                        {
                            getControlByName("drugsUse", "Use_days").Enabled = true;
                        }

                    }

                    break;
                case "Fg_self":
                    if (EmsHeadDO.Emsdrugs.Fg_self == true)
                        EmsHeadDO.Emsdrugs.Fg_outp = !EmsHeadDO.Emsdrugs.Fg_self;

                    break;
                case "Fg_outp":
                    if (EmsHeadDO.Emsdrugs.Fg_outp == true)
                    {
                        //drug = EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
                        cof.GetDrugTotal(EmsHeadDO);
                        EmsHeadDO.Emsdrugs.Fg_self = !EmsHeadDO.Emsdrugs.Fg_outp;
                        //ctlTotal.Enabled = true;
                        //gv.DataTable.Columns["Quan_cur"].ReadOnly = false;
                        //gv.DataTable.Columns["Name_unit_sale"].ReadOnly = false;
                        manageUnitName("out");
                    }
                    else
                    {
                       // gv.DataTable.Columns["Quan_cur"].ReadOnly = true;
                        gv.DataTable.Columns["Name_unit_sale"].ReadOnly = true;
                        EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Quan_cur = null;
                        manageUnitName("");
                        //ctlTotal.Enabled = false;
                    }


                    break;
                case "Fg_treat":
                    EmsHeadDO.Emsdrugs.Fg_propc = !EmsHeadDO.Emsdrugs.Fg_treat;
                    break;
                case "Fg_propc":
                    EmsHeadDO.Emsdrugs.Fg_treat = !EmsHeadDO.Emsdrugs.Fg_propc;
                    break;
                case "Quan_firday_mp":

                    getWorkTime();

                    break;
                case "Dt_begin_ui"://开始时间变化备用时间也发生变化
                    dtb = (DateTime)EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    if (EmsHeadDO.Emsdrugs.Dt_end_ui == null) return;
                    dte = (DateTime)EmsHeadDO.Emsdrugs.Dt_end_ui;
                    if (dtb.CompareTo(dte) > 0)
                    {

                        // e.Cancel = true;
                        EmsHeadDO.Emsdrugs.Dt_begin_ui = dte;
                        this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                        return;
                    }

                    useDay = cof.GetUseDays(dtb, EmsHeadDO.Emsdrugs.Dt_end_ui);
                    if (EmsHeadDO.Emsdrugs.Use_days != useDay)
                    {
                        EmsHeadDO.Emsdrugs.Use_days = useDay;
                    }
                    drug = EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
                    if (getControlByName("drugsUse", "fg_outp").ValueText == "true")
                    {
                        drug.Quan_cur = cof.GetDrugUseTotalCount(EmsHeadDO);
                        cof.GetDrugTotal(EmsHeadDO);
                    }
                    if (EmsHeadDO.Emsdrugs.Dt_fail != null)
                    {
                        EmsHeadDO.Emsdrugs.Dt_fail = cof.GetSpareEndTime(EmsHeadDO.Emsdrugs.Dt_begin_ui.Value);
                        //备用药结束时间
                        //UserRender usfail = xapFormControl1.GetUserRender("drugsUse", "dt_fail");
                        //xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_fail = usfail.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;

                        //dt_fail.MinDate = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                        //dt_fail.MaxDate = EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddHours(this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime));
                    }
                    break;
                default:
                    break;
            }





        }
        //显示单位名称
        private void manageUnitName(string type)
        {
            int count = EmsHeadDO.Emsdrugs.EmsOrDrugList.Count;

            if (type == "out")
            {
                for (int i = 0; i < count; i++)
                {
                    EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale = mapUnit[EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv];
                }
            }
            else
            {
                for (int i = 0; i < count; i++)
                {
                    string Id_srv = EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv;
                    if (mapUnit.ContainsKey(Id_srv))
                    {
                        mapUnit[EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv] = EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale;

                    }
                    else
                    {
                        mapUnit.Add(EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv, EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale);
                    }
                    EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale = "";
                }


            }




        }

        //计算首次执行时间
        private void getWorkTime()
        {
            //次数变更 具体时间也跟着变更
            XLabelBaseUserRender tmpUserRender = getControlByName("drugsUse", "quan_firday_mp");
            XNumbericUpDown numRender = tmpUserRender.UserRender as XNumbericUpDown;
            string firday_mp = numRender.ValueText;
            if (firday_mp == "")
            {
                firday_mp = "0";
            }
            int num_firday_mp = int.Parse(firday_mp);

            if (exctimes == null) return;
            if (num_firday_mp > exctimes.Length)
            {
                this.ShowInfo("首日执行次数与事件不符！");
                return;
            }
            string worktime = "";
            Array.Sort(exctimes);
            Array.Reverse(exctimes);
            for (int i = 0; i < num_firday_mp; i++)
            {
                if (worktime != "")
                {
                    worktime = ";" + worktime;
                }
                worktime = exctimes[i] + worktime;
            }

            XLabelBaseUserRender worktimeLable = this.xapFormControl1.GetUserRender("drugsUse", "work_time") as XLabelBaseUserRender;
            if (worktimeLable != null)
            {
                worktimeLable.ValueText = worktime;
            }

        }

        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            getControlByName("drugsUse", "fg_long").Enabled = false;
            //getControlByName("drugsUse", "bak_des").Visible = false;
            //getControlByName("drugsUse", "dt_fail").Visible = false;

            EmsHeadDO.Emsdrugs.Fg_treat = true;//默认为治疗用药

            //cof.adjustHeight(this.xapFormControl1, "drugsUse", adjustHeightIds, -58);
            XTabControl tabControl = new XTabControl();
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            
            dic = tabs[0].Pages[0].DicUserRenders;
            gv = xapFormControl1.GetGridView("drug");//药品列表
            drugChange = this.xapFormControl1.GetUserRender("drugsUse", "fg_dose_anoma") as XLabelBaseUserRender;

            gv.MouseClick += new MouseEventHandler(gv_MouseClick);

            gv_change = this.xapFormControl1.GetGridView("change");//变动用药
            //this.drugChange = this.getControlByName("drugsUse", "fg_dose_anoma");
            //gv_change.Visible = false;

            //SetGridPolicy(true);
            xapFormControl1.SetTabPageEnabled("drugsUse", !IsReadOnly);

            SetGridPolicy(!IsReadOnly);
            getControlByName("drugsUse", "fg_long").Enabled = false;
            if (getControlByName("drugsUse", "fg_long").ValueCode == "True")
            {
                EmsHeadDO.Emsdrugs.Use_days = null;
            }

            //getControlByName("drugsUse", "fg_long").Visible = false;
            gv.ReadOnly = false;
            gv.DataTable.Columns[0].ReadOnly = true;
            gv.DataTable.Columns[1].ReadOnly = true;
            //gv.DataTable.Columns[4].ReadOnly = true;
            //gv.DataTable.Columns["Quan_cur"].ReadOnly = true;
            //gv.DataTable.Columns["Name_unit_sale"].ReadOnly = true;
            XTabControl tabControl1 = tabs[0].tabContrl;
            XTabPage xtab = tabControl1.XTabPages[1];
            tabControl1.SelectedIndexChanged += new XTabControl.selectedIndexChanged(tabControl1_SelectedIndexChanged);
            xtab.Controls.Clear();
            xtab.AddRender(desView);

            //getControlByName("drugsUse", "work_time").LostFocus += new EventHandler(Work_time_LostFocus);
            //getControlByName("drugsUse", "dt_fail").LostFocus += new EventHandler(Dt_fail_LostFocus);

            this.sugarLine = this.xapFormControl1.GetTabPageByTabCode("wq007");
            this.sugarLine.AddRender(new INSLineChartView());
            initPoint = getControlByName("drugsUse", "fg_dose_anoma").Location;
            //if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_anti == null)
            //{

            //}
            //相关信息页签
            LoadInforPDF();
            informationPageControl = xapFormControl1.GetTabPageByTabCode("wq006");
            linkList = new List<XLinkButton>();
            if (inforDict != null && inforDict.Count >0 )
            {
                foreach(string InforName in inforDict.Keys)
                {
                    XLinkButton linkLabel = new XLinkButton();
                    linkLabel.Font = new Font("微软雅黑", 10F);
                    linkLabel.Text = InforName;
                    linkLabel.Size = new Size(400,24);
                    linkLabel.MouseClick += new MouseEventHandler(linkLabel_MouseClick);
                    informationPageControl.AddRender(linkLabel);
                    linkList.Add(linkLabel);
                }
            }
            InforReLocate();
        }

        private void LoadInforPDF()
        {
            string path = Application.StartupPath + "\\modules\\iihdata";
            inforDict = new Dictionary<string, string>();
            if (Directory.Exists(path))
            {
                DirectoryInfo iconDir = new DirectoryInfo(path);
                if (iconDir != null && iconDir.GetFiles() != null)
                {
                    foreach (FileInfo f in iconDir.GetFiles())
                    {
                        #region 取文件
                        if (f.Name.EndsWith(".pdf"))
                        {
                            if (!inforDict.ContainsKey(f.Name))
                            {
                                inforDict.Add(f.Name, f.FullName);
                            }
                        }
                        #endregion
                    }
                }
            }
        }

        private void linkLabel_MouseClick(object sender, MouseEventArgs e)
        {
            XLinkButton linkLabel = sender as XLinkButton;
            if (inforDict != null && inforDict.ContainsKey(linkLabel.Text))
            {
                System.Diagnostics.Process.Start(inforDict[linkLabel.Text]);
            }
        }
        //设置位置
        private void InforReLocate() 
        {
            XLinkButton pre = null;
            if (linkList!=null && linkList.Count > 0)
            {
                int x = 10;
                int y = 6 ;
                foreach (XLinkButton render in linkList)
                {
                    if (pre == null)
                    {
                        render.Location = new Point(x, y);
                    }
                    else
                    {
                        y = y + pre.Size.Height + 6;
                        render.Location = new Point(x, y);
                    }
                    pre = render;
                }
            }
            informationPageControl.Invalidate();
        }

        void Dt_fail_LostFocus(object sender, EventArgs e)
        {
            //XLabelBaseUserRender usfail = sender as XLabelBaseUserRender;
            //xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_fail = usfail.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
            //DateTime? dtfMax = dt_fail.MaxDate;

            //DateTime? dtf = Convert.ToDateTime(usfail.ValueText);

            //if (dtf > dtfMax)
            //{
            //    //usfail.ValueText = dt_fail.MaxDate.ToString();
            //    this.ShowInfo("失效时间不能大于开始时间 " + cof.getSpareTime() + "小时！");
            //}
        }

        void Work_time_LostFocus(object sender, EventArgs e)
        {
            if (EmsHeadDO.Emsdrugs.Work_time != null && EmsHeadDO.Emsdrugs.Work_time != "")
            {
                try
                {
                    string[] worktimes = EmsHeadDO.Emsdrugs.Work_time.Split(new string[] { ";" }, StringSplitOptions.RemoveEmptyEntries);
                    for (int i = 0; i < worktimes.Length; i++)
                    {
                        DateTime istime = Convert.ToDateTime(worktimes[i]);
                    }


                }
                catch //(Exception ex)
                {
                    EmsHeadDO.Emsdrugs.Work_time = "";
                    getWorkTime();
                    this.ShowInfo("首次执行时间格式错误!");
                }

            }
        }
        void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            desView.ShowDrugDes(EmsHeadDO.Emsdrugs.EmsOrDrugList);
        }
        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {

            //xapFormControl1.SetEditable(!IsReadOnly);
            xapFormControl1.SetTabPageEnabled("drugsUse", !IsReadOnly);
            //getControlByName("drugsUse", "work_time").Enabled = false;//首日执行时间
            //SetGridPolicy(!IsReadOnly);
            //group = this.xapFormControl1.GetUserRender("drugsUse", "group") as XGroupBox;
            EmsHeadDO.Emsdrugs.EmsOrDrug = cof.MmSortList(EmsHeadDO.Emsdrugs.EmsOrDrug);
            if (gv != null)
            {
                gv.DataTable.DataSource = EmsHeadDO.Emsdrugs.EmsOrDrugList;
                EmsHeadDO.Emsdrugs.Id_dep = EmsHeadDO.Emsdrugs.EmsOrDrugList.FirstOrDefault().Id_mp_dep;
                EmsHeadDO.Emsdrugs.Name_dep = EmsHeadDO.Emsdrugs.EmsOrDrugList.FirstOrDefault().Name_mp_dep;
            }
            GetMpTimes(EmsHeadDO.Emsdrugs.Id_freq);


            //	治疗用药、预防用药：只有抗生素类型的药品（BD_SRV_DRUG.fg_anti抗菌药物标志），才显示这两个控件。这两个选项框互斥。
            //if (cof.IsAntDrug(EmsHeadDO.Emsdrugs.Id_srv))
            //{
            //    getControlByName("drugsUse", "fg_treat").Visible = true;//治疗用药
            //    getControlByName("drugsUse", "fg_propc").Visible = true;//预防用药
            //    EmsHeadDO.Emsdrugs.Fg_treat = true;//默认治疗用药
            //}
            //else
            //{
            //    getControlByName("drugsUse", "fg_treat").Visible = false;//治疗用药
            //    getControlByName("drugsUse", "fg_propc").Visible = false;//预防用药

            //}
            //限制开始时间的时间范围，入院日期，最大提前日期
            UserRender us = xapFormControl1.GetUserRender("drugsUse", "dt_begin_ui");
            xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
            DateTime? dataA = new GetInHosTime().GetPatInHosTime(EmsHeadDO.PatInfo.Id_ent);
            dt_begin.MinDate = dataA;
            dt_begin.MaxDate = cof.GetServerDataTime().AddDays(OrdParam.GetOrdParam.orBeforStartDays);

            //限制结束时间的时间范围，入院日期，最大提前日期
            UserRender usend = xapFormControl1.GetUserRender("drugsUse", "dt_end_ui");
            xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_end = usend.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;

            dt_end.MinDate = EmsHeadDO.Emsdrugs.Dt_begin_ui;
            //dt_end.MaxDate = cof.GetServerDataTime().AddDays(OrdParam.GetOrdParam.orBeforStartDays);

            //备用药结束时间
            //UserRender usfail = xapFormControl1.GetUserRender("drugsUse", "dt_fail");
            //xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_fail = usfail.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;

            UserRender name_route = xapFormControl1.GetUserRender("drugsUse", "name_route");
            name_route.Focus();

            //dt_fail.MinDate = EmsHeadDO.Emsdrugs.Dt_begin_ui;
            //dt_fail.MaxDate = cof.GetServerDataTime().AddHours(this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime));
            mapUnit = new Dictionary<string, string>();
            //记录单位名称
            mapUnit.Add(EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_srv, EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Name_unit_sale);
            EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Name_unit_sale = "";
            //--------变动用药-------------
            //drugChange = this.xapFormControl1.GetUserRender("drugsUse", "fg_dose_anoma") as XLabelBaseUserRender;
            //gv_change.Visible = drugChange.Checked;
            //gv_change.Parent.Parent.Parent.Visible = drugChange.Checked;
            drugChange.ValueTextChanged += new EventHandler(drugChange_ValueChanged);

            if (!drugChange.Checked)
            {
                if (isMove)
                {
                    //cof.adjustHeight(this.xapFormControl1, "drugsUse", this.adjustHeightIds, -110);
                    isMove = false;
                }
                else
                {

                }
                //group.Location = new Point(group.Location.X, group.Location.Y - 108);
               
            }


            GetMpTimes(EmsHeadDO.Emsdrugs.Id_freq);
            initPoint = getControlByName("drugsUse", "fg_dose_anoma").Location;
        }
        void gv_MouseClick(object sender, MouseEventArgs e)
        {
            drug = xapFormControl1.GetFocused<EmsOrDrug>("drug");
            if (gv.GetFocusedRow().ClickCell.FieldName == "Name_mm")
            {
                string id_srv = (gv.GetFocusedRow().RowDataSource as EmsOrDrug).Id_srv;//拿到 点击的药品对应服务的id_srv
                //根据服务id 取到 服务关联的药品 ，
                if (EmsHeadDO.Emsdrugs.EmsOrDrug.Count > 1)//如果只有一条
                {
                    MmForm mmref = new MmForm(EmsHeadDO.Emsdrugs.EmsOrDrug, EmsHeadDO.Emsdrugs);
                    Point formPoint = Control.MousePosition;
                    mmref.Local = formPoint;

                    mmref.TopMost = true;
                    if (mmref.ShowDialog() == DialogResult.OK)
                    {
                        EmsOrDrug orDrug = EmsHeadDO.Emsdrugs.EmsOrDrugList[gv.FocusedRowHandle];
                        cof.CopyTo(mmref.drugmm, orDrug, "Id_srv", "Name_srv");
                    }
                }


            }
        }





        /// <summary>
        /// Gets the name of the control by.
        /// </summary>
        /// <param name="table">The table.</param>
        /// <param name="name">The name.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-08-29
        private XLabelBaseUserRender getControlByName(string tableKey, string name)
        {
            //if (dic.Count == 0) return new XLabelBaseUserRender(new XBaseUserRender());
            //if (dic.Keys.Contains(tableKey + '_' + name))
            //{
            //    return dic[tableKey + '_' + name] as XLabelBaseUserRender;
            //}
            //return new XLabelBaseUserRender(new XBaseUserRender());
            XLabelBaseUserRender tmpUserRender = this.xapFormControl1.GetUserRender(tableKey, name) as XLabelBaseUserRender;
            return tmpUserRender;
        }
        /// <summary>
        /// Gets the CheckBox.
        /// </summary>
        /// <param name="tabId">The tab identifier.</param>
        /// <param name="name">The name.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-08-29
        private XCheckBox GetCheckBox(string tabId, string name)
        {
            return getControlByName(tabId, name).UserRender as XCheckBox;
        }

        OrderSrvDoseViewModel drugChangeModel = new OrderSrvDoseViewModel();


        void drugChange_ValueChanged(object sender, EventArgs e)
        {


            if (gv_change != null && drugChange != null)
            {
                //gv_change.Visible = drugChange.Checked;
                //gv_change.Parent.Parent.Parent.Visible = drugChange.Checked;
            }
            if (drugChange.Checked)
            {
                if (EmsHeadDO.Emsdrugs.EmsOrDoseDrug.Count == 0)
                    GetDoseDrugData(EmsHeadDO.Emsdrugs.Id_freq);
                gv_change.DataTable.DataSource = EmsHeadDO.Emsdrugs.EmsOrDoseDrug;
                EmsHeadDO.Emsdrugs.EmsOrDoseDrug.ToList().ForEach(p =>
                {
                    p.Quan_med = EmsHeadDO.Emsdrugs.Quan_med;//剂量
                    p.Name_unit_med = EmsHeadDO.Emsdrugs.Name_unit_med;
                    // p.Quan_base = EmsHeadDO.Emsdrugs.Quan_base;//单次剂量
                    p.Id_unit_med = EmsHeadDO.Emsdrugs.Id_unit_med;
                });
                //gv_change.Visible = true;
                if (gv_change.Parent != null)
                {
                    //gv_change.Parent.Parent.Parent.Visible = true;
                }
                //group.Location = new Point(group.Location.X, drugChange.Location.Y + 140);
                this.gv_change_height = gv_change.Height;
                this.h += gv_change_height;
                calCardMoveHeight();
                this.xapFormControl1.Refresh();
                

            }
            else
            {
                this.h -= gv_change_height;
                this.gv_change_height = gv_change.Height;
                //gv_change.Visible = false;
                if (gv_change.Parent != null)
                {
                    //gv_change.Parent.Parent.Parent.Visible = false;
                    //gv_change.Parent.Visible = false;
                }
                //gv_change.Parent.BackColor = Color.Green;

                EmsHeadDO.Emsdrugs.EmsOrDoseDrug.Clear();
                //group.Location = new Point(group.Location.X, drugChange.Location.Y + 32);
                calCardMoveHeight();
                this.xapFormControl1.Refresh();
            }

        }
        /// <summary>
        /// Drugs 表单药品剂量数据写到药品do
        /// </summary>
        /// Author:admin
        /// Date:2015-10-21
        private void DrugWriteData()
        {
            if (EmsHeadDO.Emsdrugs.EmsOrDrugList.Count == 0) return;
            if (drug != null)
                drug = EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
            drug.Id_pgku_cur = drug.Id_unit_sale;
            return;
            /*
            //orDrug.Name_mm = EmsHeadDO.Emsdrugs.Name_mm;//药品名称
            //orDrug.Spec_mm = EmsHeadDO.Emsdrugs.Spec_mm;//规格
            //orDrug.Name_heath = EmsHeadDO.Emsdrugs.Name_heath;//医保类型
            //orDrug.Limit = EmsHeadDO.Emsdrugs.Limit;//限制报销条件
            //orDrug.Price = EmsHeadDO.Emsdrugs.Price;//参考价格
            if (EmsHeadDO.Emsdrugs.Total_count != null)
                drug.Quan_cur = (int)EmsHeadDO.Emsdrugs.Total_count;//总量
            drug.Id_unit_base = EmsHeadDO.Emsdrugs.Id_unit_base;
            drug.Name_unit_base = EmsHeadDO.Emsdrugs.Name_unit_base;
            drug.Id_unit_med = EmsHeadDO.Emsdrugs.Id_unit_med;
            drug.Name_unit_med = EmsHeadDO.Emsdrugs.Name_unit_med;
            drug.Id_pgku_cur = EmsHeadDO.Emsdrugs.Id_total_count_unit;//基本包装单位，如：片
            drug.Name_pgku_cur = EmsHeadDO.Emsdrugs.Total_count_unit;


            if (EmsHeadDO.Emsdrugs.Id_total_count_unit == null)
            {
                //orDrug.Id_pgku_cur =  EmsHeadDO.Emsdrugs.Id_unit_med ;
                //orDrug.Name_pgku_cur = EmsHeadDO.Emsdrugs.Name_unit_base;
            }

            //orDrug.Quan_base = EmsHeadDO.Emsdrugs.Quan_base;
            //drug.Quan_med = EmsHeadDO.Emsdrugs.Quan_med;
            */
        }

        /// <summary>
        /// 编辑时候药品剂量数据写到表单
        /// </summary>
        /// Author:admin
        /// Date:2015-10-21

        public override Validate.IValidate GetOrdValidate()
        {
            return new Validate.OrderDrugsValidate();
        }
        public override void SaveBefore()
        {
            xapFormControl1.SaveForm();
            DrugWriteData();
        }

        #endregion

        #region 辅助处理函数
        /// <summary>
        /// 根据频次获取变动用药的 日期集合
        /// </summary>
        /// <param name="id_freq">The id_freq.</param>
        /// Author:admin
        /// Date:2015-10-08
        private void GetDoseDrugData(string id_freq)
        {
            EmsHeadDO.Emsdrugs.EmsOrDoseDrug = cof.GetFreqVsTimes(id_freq, EmsHeadDO.Emsdrugs.Id_orsrv, EmsHeadDO.Emsdrugs.Id_or);
        }

        private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy();
            policy.ClassName = "iih.ci.ord.ciordems.d.EmsOrDrug";
            //policy.AllowNew = flag;
            policy.AllowEdit = flag;
            //policy.AllowRemove = flag;
            //policy.AllowSave = false;
            policy.FullEdit = flag;
            //policy.HideOther = true;
            //policy.MultiSelect = true;

            xapFormControl1.SetEditPolicy(flag, new DataPolicy[1] { policy });

            //gv_change.ReadOnly = false;
            //gv.ReadOnly = true;
            //gv.DataTable.ReadOnly = true;
        }

        private void setWeekUseDay()
        {
            //取模
            int? m = EmsHeadDO.Emsdrugs.Use_days % 7;
            //判断周期类型错误
            //if (EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
            if (EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
            {
                if (m == 6)
                {//减的 
                    int? uu = EmsHeadDO.Emsdrugs.Use_days / 7;


                    EmsHeadDO.Emsdrugs.Use_days = uu * 7;
                }
                else
                {
                    int? uu = EmsHeadDO.Emsdrugs.Use_days / 7;
                    EmsHeadDO.Emsdrugs.Use_days = (uu + 1) * 7;
                }

            }
        }
        private void calCardMoveHeight() {
            //XGroupBox tmp = this.xapFormControl1.GetUserRender("drugsUse", "groupBox") as XGroupBox;
            //tmp.Location = new Point(this.initPoint.X, this.initPoint.Y + h+29);

            //for (int i = 0; i < ah.Length; i++)
            //{
            //    object tmpobj = control.GetUserRender(tableKey, ah[i]);
            //    if (tmpobj == null) continue;

            //    if (tmpobj is XLabelBaseUserRender)
            //    {
            //        XLabelBaseUserRender tmp = control.GetUserRender(tableKey, ah[i]) as XLabelBaseUserRender;
            //        tmp.Location = new Point(tmp.Location.X, tmp.Location.Y + height);

            //    }
            //    else if (tmpobj is XGroupBox)
            //    {
            //        XGroupBox tmp = control.GetUserRender(tableKey, ah[i]) as XGroupBox;
            //        tmp.Location = new Point(tmp.Location.X, tmp.Location.Y + height);
            //    }
            //    else
            //    {
            //        XLabel lable = control.GetUserRender(tableKey, ah[i]) as XLabel;
            //        lable.Location = new Point(lable.Location.X, lable.Location.Y + height);

            //    }
            //}

            XLabelBaseUserRender dtBegin = this.xapFormControl1.GetUserRender("drugsUse", "dt_begin_ui") as XLabelBaseUserRender;
            Point dtBegionP = dtBegin.Location;
            //if (getControlByName("drugsUse", "dt_fail").Visible == true)
            //{
            //    getControlByName("drugsUse", "dt_fail").Location = new Point(dtBegionP.X, dtBegionP.Y - 29);
            //}
            //if (getControlByName("drugsUse", "dt_fail").Visible == true && getControlByName("drugsUse", "bak_des").Visible == true)
            //{
            //    getControlByName("drugsUse", "bak_des").Location = new Point(dtBegionP.X, dtBegionP.Y - 58);
            //}
            //else if (getControlByName("drugsUse", "bak_des").Visible == true)
            //{
            //    getControlByName("drugsUse", "dt_fail").Location = new Point(dtBegionP.X, dtBegionP.Y - 29);
            //}
            
        }
        #endregion


    }
}
