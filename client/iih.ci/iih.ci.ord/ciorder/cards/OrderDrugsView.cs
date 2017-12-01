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
using iih.mm.itf.material.d;
using iih.ci.iih.ci.ord.i;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// 通用药品医疗单
    /// </summary>
    /// Author:admin
    /// Date:2015-10-10
    public partial class OrderDrugsView : CiorderBaseControl
    {



        #region 变量定义区域
        XapFormGridControl gv, gv_change;
        //private XLabelBaseUserRender drugChange;
        private XGroupBox group;
        Dictionary<string, UserRender> dic = new Dictionary<string, UserRender>();
        //记录单位名称
        Dictionary<string, string> mapUnit = new Dictionary<string, string>();
        EmsOrDrug drug = new EmsOrDrug();
        OrderDrugDesView desView = new OrderDrugDesView() { Dock = DockStyle.Fill };
        xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_fail;
        private string[] exctimes;//首日执行时间
        private string[] adjustHeightIds = new string[] { "dt_begin_ui", "Use_days", "dt_end_ui", "quan_firday_mp", "work_time", "name_dep", "fg_self", "fg_propc", "fg_treat", "note_or", "ci", "day" };
        #endregion

        #region 构造函数区域
        public OrderDrugsView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderDrugsView_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            this.xapFormControl1.RefResult += this.OnRefResult;
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            xapFormControl1.DataChanging += new EventHandler<DataChangingEventArgs>(xapFormControl1_DataChanging);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
            SheetName = "普药医疗单";
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
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderDrugsView;// "20150918053353209GYB";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.EmsHeadDO.Emsdrugs;
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
                this.EmsHeadDO.Emsdrugs.Sd_frequnitct = data.FirstData["Sd_frequnitct"] as string;
                this.EmsHeadDO.Emsdrugs.Freqct = null;
                if (data.FirstData["Freqct"].ToString() != "")
                    this.EmsHeadDO.Emsdrugs.Freqct = int.Parse(data.FirstData["Freqct"].ToString());
                this.EmsHeadDO.Emsdrugs.Fg_long = data.FirstData["Fg_long"].ToString() == "Y" ? true : false;
                
                //可将下面放到算法里
                if (data.FirstData["Fg_prnor"].ToString() == "Y")// 备用医嘱 true 并且 长临为 临时
                {
                    XLabelBaseUserRender tmpRender = cof.getControlByName(xapFormControl1,"drugsUse", "fg_long");
                    int h = 0;//高度变动值
                    if (tmpRender.ValueCode == "False")
                    {
                        if (cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Visible == false) {
                            h += 29;
                        }
                        cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Visible = true;//临时医嘱失效日期  
                        
                        this.EmsHeadDO.Emsdrugs.Dt_fail = cof.GetSpareEndTime(this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value);
                        dt_fail.MinDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddDays(-1);
                        dt_fail.MaxDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddHours(this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime)); ;
                        cof.getControlByName(xapFormControl1,"drugsUse", "bak_des").ValueText = "";
                    }
                    else
                    {
                        if (cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Visible == true)
                        {
                            h += -29;
                        }
                        cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Visible = false;//长期医嘱失效日期禁用
                        
                        this.EmsHeadDO.Emsdrugs.Dt_fail = null;
                        this.EmsHeadDO.Emsdrugs.Use_days = null;
                        cof.getControlByName(xapFormControl1,"drugsUse", "bak_des").ValueText = "执行最小间隔时间：6小时。";
                    }
                    if (cof.getControlByName(xapFormControl1,"drugsUse", "bak_des").Visible == false)
                    {
                        h += 29;
                    }
                    cof.setFreqctMaxMin(this.EmsHeadDO,xapFormControl1);
                    cof.getControlByName(xapFormControl1,"drugsUse", "bak_des").Visible = true;                   
                    cof.adjustHeight(this.xapFormControl1, "drugsUse", adjustHeightIds, h);
                    //this.xapFormControl1.Invalidate();
                    this.xapFormControl1.Refresh();
                }
                else
                {
                    int h = 0;
                    if (cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Visible == true) {
                        h += -29;
                    }
                    cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Visible = false;//临时医嘱失效日期
                    if (cof.getControlByName(xapFormControl1,"drugsUse", "bak_des").Visible == true)
                    {
                        h += -29;
                    }
                    cof.getControlByName(xapFormControl1,"drugsUse", "bak_des").Visible = false;
                    
                    //cof.adjustHeight(this.xapFormControl1,"drugsUse", adjustHeightIds, 20, "up");
                    cof.getControlByName(xapFormControl1,"drugsUse", "bak_des").ValueText = "";
                    this.EmsHeadDO.Emsdrugs.Dt_fail = null;
                    cof.adjustHeight(this.xapFormControl1, "drugsUse", adjustHeightIds, h);
                    this.xapFormControl1.Refresh();
                }
                //首日执行 只针对频次周期类型为‘天’的医嘱才可录入和显示首日执行次数，其他情况该控件隐藏。

                string name_freq = data.FirstData["Name"] as string;//获取字段值
                if (name_freq.Contains("日"))
                {
                    cof.getControlByName(xapFormControl1,"drugsUse", "quan_firday_mp").Enabled = true;//首日执行次数
                    cof.getControlByName(xapFormControl1,"drugsUse", "work_time").Enabled = false;//首日执行时间
                    GetMpTimes(id_freq);
                }
                else
                {
                    cof.getControlByName(xapFormControl1,"drugsUse", "quan_firday_mp").Enabled = false;//首日执行次数
                    cof.getControlByName(xapFormControl1,"drugsUse", "work_time").Enabled = false;//首日执行时间

                }
                string code_freq = data.FirstData["Code"] as string;//获取字段值
                if (code_freq == "once")
                {
                    this.EmsHeadDO.Emsdrugs.Fg_long = false;//长临标识 变临时
                    cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").Enabled = false;// 

                    this.EmsHeadDO.Emsdrugs.Dt_end_ui = this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
                }
                else
                {
                    // cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").Enabled = true;// 
                }
                //长临标识可更改
                if (data.FirstData["Fg_long_edit"].ToString() == "Y")
                {
                    cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").Enabled = true;
                }
                else
                {
                    cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").Enabled = false;
                }



                if (this.EmsHeadDO.Emsdrugs.Fg_long == false) { //如果是临时的 使用天数和结束日期置灰
                    cof.getControlByName(xapFormControl1,"drugsUse", "Use_days").Enabled = false;
                    cof.getControlByName(xapFormControl1,"drugsUse", "dt_end_ui").Enabled = false;
                }else{
                    cof.getControlByName(xapFormControl1,"drugsUse", "Use_days").Enabled = true;
                    cof.getControlByName(xapFormControl1,"drugsUse", "dt_end_ui").Enabled = true;
                }

            }
            else if (e.BindingFieldName.Equals("Name_unit_sale"))
            {
                cof.GetDrugTotal(this.EmsHeadDO);
            }
        }
        

       
        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName == "Name_route")
            {
                e.WherePart = string.Format("id_route in ({0})", new GetSrvVsRouteImp().GetDosageVsRounte("'" + string.Join("','", this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Select(p => p.Id_srv).ToList()) + "'"));
            }
            //不需要添加
            if (e.BindingFieldName.Equals("Name_dep"))
            {
                if (this.EmsHeadDO.Emsdrugs.Str_mp_dep_ids != null && this.EmsHeadDO.Emsdrugs.Str_mp_dep_ids != "")
                    e.WherePart = string.Format("  activestate ='2'  and  id_dep in({0})", this.EmsHeadDO.Emsdrugs.Str_mp_dep_ids);
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
            if(e.BindingFieldName.Equals("Name_routedes"))
            {
                e.WherePart = string.Format("BD_ROUTE_DES.FG_ENTP_IP='Y'");
            }
        }



        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            if (headDo != null)
            {
                this.EmsHeadDO = headDo;

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
                    string info = cof.CompareWithAdmission(this.EmsHeadDO.PatInfo.Id_ent, this.EmsHeadDO.Emsdrugs.Dt_begin_ui);
                    if (info != "")
                    {
                        this.ShowInfo(info);
                        e.Cancel = true;
                    }
                    break;
                case "Dt_end_ui":
                    //string ipt = (string)e.Input;
                    //DateTime dtb = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    //if (this.EmsHeadDO.Emsdrugs.Dt_end_ui == null) return;
                    //DateTime dte = DateTime.Parse(ipt); 
                    //if (dtb.CompareTo(dte) > 0)
                    //{

                    //    e.Cancel = true;
                    //    this.EmsHeadDO.Emsdrugs.Dt_end_ui = dtb;
                    //    this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                    //}
                    break;
                case "Quan_med"://验证剂量必须大于0

                    double? quantmp = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Quan_med;
                    if (quantmp <= 0)
                    {
                        this.ShowInfo("剂量必须大于0！");
                        e.Cancel = true;
                        //this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Quan_med = 1;
                        
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
                        this.EmsHeadDO.Emsdrugs.Use_days = null;
                        return;
                    }
                    if (this.EmsHeadDO.Emsdrugs.Use_days == null)
                    {
                        this.EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                        return;
                    }


                    if (this.EmsHeadDO.Emsdrugs.Use_days == 0)
                    {
                        if (this.EmsHeadDO.Emsdrugs.Dt_end_ui != this.EmsHeadDO.Emsdrugs.Dt_begin_ui)
                        {
                            this.EmsHeadDO.Emsdrugs.Dt_end_ui = this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
                        }
                        return;
                    }
                    else if (this.EmsHeadDO.Emsdrugs.Use_days == -1 && this.EmsHeadDO.Emsdrugs.Dt_end_ui == null)
                    {
                        XLabelBaseUserRender tmpUserRender2 = sender as XLabelBaseUserRender;
                        uday = "-1";
                        tmpUserRender2.ValueText = "";

                        //this.EmsHeadDO.Emsdrugs.Use_days = null;
                        return;
                    }
                    else if (this.EmsHeadDO.Emsdrugs.Use_days == -1)
                    {
                        this.EmsHeadDO.Emsdrugs.Use_days = null;
                        this.EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                        return;
                    }
                    else if (this.EmsHeadDO.Emsdrugs.Use_days > 0)
                    {
                        DateTime? endDateTime = cof.GetEndTime(this.EmsHeadDO.Emsdrugs.Dt_begin_ui, this.EmsHeadDO.Emsdrugs.Use_days.Value);
                        if (this.EmsHeadDO.Emsdrugs.Dt_end_ui != endDateTime)
                        {
                            this.EmsHeadDO.Emsdrugs.Dt_end_ui = endDateTime;
                        }


                    }

                    //取模
                    int? m = this.EmsHeadDO.Emsdrugs.Use_days % 7;
                    //判断周期类型错误
                    //if (this.EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
                    if ((this.EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 || this.EmsHeadDO.Emsdrugs.Name_freq.IndexOf("星期")>0) && m % 7 != 0)
                    {
                        if (m == 6||m==0)
                        {//减的 
                            int? uu = this.EmsHeadDO.Emsdrugs.Use_days / 7;

                           
                            this.EmsHeadDO.Emsdrugs.Use_days = uu * 7;
                        }
                        else {
                            int? uu = this.EmsHeadDO.Emsdrugs.Use_days / 7;
                            this.EmsHeadDO.Emsdrugs.Use_days = (uu + 1) * 7;
                        }
                        
                    }
                    
                    uday = "";
                    break;
                case "Dt_end_ui"://计算医嘱天数


                    DateTime dtb = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    if (this.EmsHeadDO.Emsdrugs.Dt_end_ui == null) return;
                    DateTime dte = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_end_ui;
                    if (dtb.CompareTo(dte) > 0)
                    {

                        // e.Cancel = true;
                        this.EmsHeadDO.Emsdrugs.Dt_end_ui = dtb;
                        this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                        return;
                    }

                    int? useDay = cof.GetUseDays(dtb, this.EmsHeadDO.Emsdrugs.Dt_end_ui);
                    if (this.EmsHeadDO.Emsdrugs.Use_days != useDay)
                    {
                        this.EmsHeadDO.Emsdrugs.Use_days = useDay;
                    }
                    EmsOrDrug drug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0];

                    break;
                case "Name_freq"://计算执行时刻1
                    if (e.Input != null && e.Input.ToString().Contains("日"))
                    {
                        cof.getControlByName(xapFormControl1,"drugsUse", "quan_firday_mp").Enabled = true;
                        cof.getControlByName(xapFormControl1,"drugsUse", "work_time").Enabled = false;
                        GetMpTimes(this.EmsHeadDO.Emsdrugs.Id_freq);
                    }
                    else if (e.Input != null && (e.Input.ToString().Contains("周") || e.Input.ToString().Contains("星期")))
                    {
                        //取模
                         m = this.EmsHeadDO.Emsdrugs.Use_days % 7;
                        if (m == 0||m==6)
                        {//减的 
                            int? uu = this.EmsHeadDO.Emsdrugs.Use_days / 7;

                           
                            this.EmsHeadDO.Emsdrugs.Use_days = uu * 7;
                        }
                        else {
                            int? uu = this.EmsHeadDO.Emsdrugs.Use_days / 7;
                            this.EmsHeadDO.Emsdrugs.Use_days = (uu + 1) * 7;
                        }
                        
                    }
                    else
                    {
                        cof.getControlByName(xapFormControl1,"drugsUse", "quan_firday_mp").Enabled = false;
                        cof.getControlByName(xapFormControl1,"drugsUse", "work_time").Enabled = false;
                    }
                    
                    //  先于 OnRefResult(object sender, RefResultEventArgs e)执行，会出现  这个地方获取的id 是上次的 而不是最新的
                    break;
                case "Fg_long":
                    if (e.Input.ToString() == "False")
                    {
                       
                            cof.getControlByName(xapFormControl1,"drugsUse", "Use_days").Enabled = false;//临时 医嘱天数 不可输入
                            this.EmsHeadDO.Emsdrugs.Use_days = 1;
                       

                    }
                    else
                    {
                        if (cof.getControlByName(xapFormControl1,"drugsUse", "Use_days") != null)
                        {
                            cof.getControlByName(xapFormControl1,"drugsUse", "Use_days").Enabled = true;
                        }

                    }

                    break;
                case "Fg_self":
                    break;
                //case "Fg_outp":
                //    if (this.EmsHeadDO.Emsdrugs.Fg_outp == true)
                //    {
                //        //drug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
                //        cof.GetDrugTotal(this.EmsHeadDO,true);
                //        this.EmsHeadDO.Emsdrugs.Fg_self = !this.EmsHeadDO.Emsdrugs.Fg_outp;
                //        //ctlTotal.Enabled = true;
                //        gv.DataTable.Columns["Quan_cur"].ReadOnly = false;
                //        gv.DataTable.Columns["Name_unit_sale"].ReadOnly = false;
                //        manageUnitName("out");
                //    }
                //    else
                //    {
                //        gv.DataTable.Columns["Quan_cur"].ReadOnly = true;
                //        gv.DataTable.Columns["Name_unit_sale"].ReadOnly = true;
                //        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Quan_cur = null;
                //        manageUnitName("");
                //        //ctlTotal.Enabled = false;
                //    }


                    //break;
                case "Fg_treat":
                    this.EmsHeadDO.Emsdrugs.Fg_propc = !this.EmsHeadDO.Emsdrugs.Fg_treat;
                    break;
                case "Fg_propc":
                    this.EmsHeadDO.Emsdrugs.Fg_treat = !this.EmsHeadDO.Emsdrugs.Fg_propc;
                    break;
                case "Quan_firday_mp":
                    getWorkTime();
                    //if (cof.getControlByName(xapFormControl1,"drugsUse", "fg_outp").ValueText == "true")
                    //{
                    //    cof.GetDrugTotal(this.EmsHeadDO, true);
                    //}
                    break;
                case "Dt_begin_ui"://开始时间变化备用时间也发生变化
                    dtb = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    if (this.EmsHeadDO.Emsdrugs.Dt_end_ui!=null)
                    {
                        dte = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_end_ui;
                        if (dte != null && dtb.CompareTo(dte) > 0)
                        {

                            // e.Cancel = true;
                            this.EmsHeadDO.Emsdrugs.Dt_begin_ui = dte;
                            this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                            return;
                        }
                    }
                    useDay = cof.GetUseDays(dtb, this.EmsHeadDO.Emsdrugs.Dt_end_ui);
                    if (this.EmsHeadDO.Emsdrugs.Use_days != useDay)
                    {
                        this.EmsHeadDO.Emsdrugs.Use_days = useDay;
                    }
                    drug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
                    //if (cof.getControlByName(xapFormControl1,"drugsUse", "fg_outp").ValueText == "true")
                    //{
                    //  drug.Quan_cur = cof.GetDrugUseTotalCount(this.EmsHeadDO);
                    //  cof.GetDrugTotal(this.EmsHeadDO,true);
                    //}
                    if (this.EmsHeadDO.Emsdrugs.Dt_fail != null) {
                        
                        //备用药结束时间
                        this.EmsHeadDO.Emsdrugs.Dt_fail = cof.GetSpareEndTime(this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value);
                        dt_fail.MinDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddDays(-1);
                        dt_fail.MaxDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddHours(this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime));
                    }
                    break;
                case "Quan_cur":
                    GetStockReqDTO reqDto = new GetStockReqDTO();
                    string id_mm = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_mm;
                    string id_dep_phy = this.EmsHeadDO.Emsdrugs.Id_dep;
                    reqDto.Id_dep = id_dep_phy;
                    reqDto.Id_mm = id_mm;
                    reqDto.Req_unit_id = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_unit_sale;
                    GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
                    reqDtoArr[0] = reqDto;
                    try
                    {
                        MaterialStockDTO[] materialArr = cof.getMaterialStocksCount(reqDtoArr);
                        if (materialArr != null && materialArr.Length > 0)
                        {
                            MaterialStockDTO material = materialArr[0];
                            if (material == null || material.Quan_stock < this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Quan_cur)
                            {
                                this.ShowInfo(this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Name_mm + "数量已超过库存量，无法开立！");
                                return;
                            }
                        }
                    }
                    catch //(Exception ex)
                    { }
                   
                    break;
                case "Quan_med":
                    //if (cof.getControlByName(xapFormControl1, "drugsUse", "fg_outp").ValueText == "true")
                    //{
                    //    cof.GetDrugTotal(this.EmsHeadDO, true);
                    //}
                    break;
                default:
                    break;
            }


        }
        //显示单位名称
        private void manageUnitName(string type) {
            int count = this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count;

            if (type == "out")
            {
                for (int i = 0; i < count; i++)
                {
                    this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale = mapUnit[this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv];
                }
            }
            else {
                for (int i = 0; i < count; i++)
                {
                    string Id_srv = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv;
                    if (mapUnit.ContainsKey(Id_srv))
                    {
                        mapUnit[this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv] = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale;
                        
                    }
                    else {
                        mapUnit.Add(this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv, this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale);
                    }
                    this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale = "";
                }
                
            
            }
            


        
        }

        //计算首次执行时间
        private void getWorkTime()
        {
            //次数变更 具体时间也跟着变更
            XLabelBaseUserRender tmpUserRender = cof.getControlByName(xapFormControl1,"drugsUse", "quan_firday_mp");
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
            cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").Enabled = false;
            cof.getControlByName(xapFormControl1,"drugsUse", "bak_des").Visible = false;
            cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Visible = false;
            
            this.EmsHeadDO.Emsdrugs.Fg_treat = true;//默认为治疗用药
            
            cof.adjustHeight(this.xapFormControl1,"drugsUse", adjustHeightIds, -58 );
            XTabControl tabControl = new XTabControl();
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            dic = tabs[0].Pages[0].DicUserRenders;
            gv = xapFormControl1.GetGridView("drug");//药品列表
            gv.MouseClick += new MouseEventHandler(gv_MouseClick);

            gv_change = this.xapFormControl1.GetGridView("change");//变动用药
            gv_change.Visible = false;

            //SetGridPolicy(true);
            xapFormControl1.SetTabPageEnabled("drugsUse", !IsReadOnly);

            SetGridPolicy(!IsReadOnly);
            cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").Enabled = false;
            if (cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").ValueCode == "True"&&this.EmsHeadDO.IsNEW)
            {
                this.EmsHeadDO.Emsdrugs.Use_days = null;
            }

            //cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").Visible = false;
            gv.ReadOnly = false;
            gv.DataTable.Columns[0].ReadOnly = true;
            gv.DataTable.Columns[1].ReadOnly = true;
            gv.DataTable.Columns[4].ReadOnly = true;
            gv.DataTable.Columns["Quan_cur"].ReadOnly = true;
            gv.DataTable.Columns["Name_unit_sale"].ReadOnly = true;
            XTabControl tabControl1 = tabs[0].tabContrl;
            XTabPage xtab = tabControl1.XTabPages[1];
            tabControl1.SelectedIndexChanged += new XTabControl.selectedIndexChanged(tabControl1_SelectedIndexChanged);
            xtab.Controls.Clear();
            xtab.Controls.Add(desView);
            //失效日期控件
            UserRender usfail = xapFormControl1.GetUserRender("drugsUse", "dt_fail");
            dt_fail = usfail.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;

            cof.getControlByName(xapFormControl1,"drugsUse", "work_time").LostFocus += new EventHandler(Work_time_LostFocus);
            cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").LostFocus += new EventHandler(Dt_fail_LostFocus);
            
            if (this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_anti == null) { 
            
            }

        }


        void Dt_fail_LostFocus(object sender, EventArgs e)
        {
            XLabelBaseUserRender usfail = sender as XLabelBaseUserRender;
            DateTime? dtfMax = dt_fail.MaxDate;

            DateTime? dtf = Convert.ToDateTime(usfail.ValueText);

            if (dtf > dtfMax)
            {
                usfail.ValueText = dt_fail.MaxDate.ToString();
                this.ShowInfo("失效时间不能大于开始时间 " + cof.getSpareTime() + "小时！");
            }
            XLabelBaseUserRender dbt = cof.getControlByName(this.xapFormControl1,"drugsUse", "dt_begin_ui") as XLabelBaseUserRender;
            DateTime? dtb = Convert.ToDateTime(dbt.ValueText);
            if (dtf <= dtb)
            {
                usfail.ValueText = dbt.ValueText;
                this.ShowInfo("失效时间应该大于开始时间！");
            }

        }

        void Work_time_LostFocus(object sender, EventArgs e)
        {
            if (this.EmsHeadDO.Emsdrugs.Work_time != null && this.EmsHeadDO.Emsdrugs.Work_time != "")
            {
                try
                {
                    string[] worktimes = this.EmsHeadDO.Emsdrugs.Work_time.Split(new string[] { ";" }, StringSplitOptions.RemoveEmptyEntries);
                    for (int i = 0; i < worktimes.Length; i++)
                    {
                        DateTime istime = Convert.ToDateTime(worktimes[i]);
                    }


                }
                catch//(Exception ex)
                {
                    this.EmsHeadDO.Emsdrugs.Work_time = "";
                    getWorkTime();
                    this.ShowInfo("首次执行时间格式错误!");
                }

            }
        }
        void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            desView.ShowDrugDes(this.EmsHeadDO.Emsdrugs.EmsOrDrugList);
        }
        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {

            //xapFormControl1.SetEditable(!IsReadOnly);
           // xapFormControl1.SetTabPageEnabled("drugsUse", !IsReadOnly);
            cof.getControlByName(xapFormControl1,"drugsUse", "work_time").Enabled = false;//首日执行时间
            //SetGridPolicy(!IsReadOnly);
            group = this.xapFormControl1.GetUserRender("drugsUse", "group") as XGroupBox;
            this.EmsHeadDO.Emsdrugs.EmsOrDrug = cof.MmSortList(this.EmsHeadDO.Emsdrugs.EmsOrDrug);
            if (gv != null)
            {
                gv.DataTable.DataSource = this.EmsHeadDO.Emsdrugs.EmsOrDrugList;

            }
            mapUnit = new Dictionary<string, string>();
            //记录单位名称
            mapUnit.Add(this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_srv, this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Name_unit_sale);
            if (this.EmsHeadDO.IsNEW)
            {
                GetMpTimes(this.EmsHeadDO.Emsdrugs.Id_freq);
                //设置执行次数的最大值和最小值
                cof.setFreqctMaxMin(this.EmsHeadDO,xapFormControl1);
                this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Name_unit_sale = "";
            }
            else {
                string exctime = cof.GetWorkTime(this.EmsHeadDO.Emsdrugs.Id_freq);
                
                if (exctime != null && exctime != "")
                {
                    exctimes = exctime.Split(';');
                    Array.Sort(exctimes);
                    Array.Reverse(exctimes);

                }
                cof.setMpWorkTimesOnEdit(this.EmsHeadDO,exctimes);
                 XLabelBaseUserRender tmpUserRender = this.xapFormControl1.GetUserRender("drugsUse", "quan_firday_mp") as XLabelBaseUserRender;
                XNumbericUpDown numRender = tmpUserRender.UserRender as XNumbericUpDown;
                numRender.MaxValue = (double)this.EmsHeadDO.Emsdrugs.Quan_firday_mp;
                numRender.MinValue = 0;
            }
           
            //	治疗用药、预防用药：只有抗生素类型的药品（BD_SRV_DRUG.fg_anti抗菌药物标志），才显示这两个控件。这两个选项框互斥。
            if (cof.IsAntDrug(this.EmsHeadDO.Emsdrugs.Id_srv))
            {
                cof.getControlByName(xapFormControl1,"drugsUse", "fg_treat").Visible = true;//治疗用药
                cof.getControlByName(xapFormControl1,"drugsUse", "fg_propc").Visible = true;//预防用药
                this.EmsHeadDO.Emsdrugs.Fg_treat = true;//默认治疗用药
            }
            else
            {
                cof.getControlByName(xapFormControl1,"drugsUse", "fg_treat").Visible = false;//治疗用药
                cof.getControlByName(xapFormControl1,"drugsUse", "fg_propc").Visible = false;//预防用药

            }
            //限制开始时间的时间范围，入院日期，最大提前日期
            UserRender us = xapFormControl1.GetUserRender("drugsUse", "dt_begin_ui");
            xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
            DateTime? dataA = new GetInHosTime().GetPatInHosTime(this.EmsHeadDO.PatInfo.Id_ent);
            dt_begin.MinDate = dataA;
            dt_begin.MaxDate = cof.GetServerDataTime().AddDays(OrdParam.GetOrdParam.orBeforStartDays);

            //限制结束时间的时间范围，入院日期，最大提前日期
            UserRender usend = xapFormControl1.GetUserRender("drugsUse", "dt_end_ui");
            xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_end = usend.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;

            UserRender name_route = xapFormControl1.GetUserRender("drugsUse", "name_route");
            name_route.Focus();

            dt_end.MinDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
            //dt_end.MaxDate = cof.GetServerDataTime().AddDays(OrdParam.GetOrdParam.orBeforStartDays);

            //备用药失效时间

            dt_fail.MinDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddDays(-1);
            dt_fail.MaxDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddHours(this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime));
            //cof.GetServerDataTime().AddHours(OrdParam.GetOrdParam.backOrActiveTime);

            cof.setDrugConStateAfterFilled(this.EmsHeadDO.Emsdrugs.Id_freq,this.adjustHeightIds,this.xapFormControl1);
            cof.setGridColumnEdit(gv, this.EmsHeadDO);
        }
        void gv_MouseClick(object sender, MouseEventArgs e)
        {
            drug = xapFormControl1.GetFocused<EmsOrDrug>("drug");
            if (gv.GetFocusedRow().ClickCell.FieldName == "Name_mm")
            {
                string id_srv = (gv.GetFocusedRow().RowDataSource as EmsOrDrug).Id_srv;//拿到 点击的药品对应服务的id_srv
                //根据服务id 取到 服务关联的药品 ，
                if (this.EmsHeadDO.Emsdrugs.EmsOrDrug.Count > 1)//如果只有一条
                {
                    MmForm mmref = new MmForm(this.EmsHeadDO.Emsdrugs.EmsOrDrug, this.EmsHeadDO.Emsdrugs);
                    Point formPoint = Control.MousePosition;
                    mmref.StartPosition = FormStartPosition.Manual;
                    mmref.Location = gv.PointToScreen(new Point(gv.Location.X, gv.Location.Y + gv.Size.Height + 1));
                    mmref.TopMost = true;
                    if (mmref.ShowDialog() == DialogResult.OK)
                    {
                        EmsOrDrug orDrug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[gv.FocusedRowHandle];
                        string id_mm = mmref.drugmm.Id_mm;
                        string id_dep_phy = this.EmsHeadDO.Emsdrugs.Id_dep;
                        GetStockReqDTO reqDto = new GetStockReqDTO();
                        reqDto.Id_dep = id_dep_phy;
                        reqDto.Id_mm = id_mm;
                        reqDto.Req_unit_id = mmref.drugmm.Id_unit_med;
                        GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
                        reqDtoArr[0] = reqDto;
                        try
                        {
                            MaterialStockDTO[] materialArr = cof.getMaterialStocksCount(reqDtoArr);
                            if (materialArr != null && materialArr.Length > 0)
                            {
                                MaterialStockDTO material = materialArr[0];
                                if (material != null && material.Quan_stock > 0)
                                {
                                    cof.CopyTo(mmref.drugmm, orDrug, "Id_srv", "Name_srv");
                                }
                                else
                                {
                                    this.ShowInfo("该药品在" + this.EmsHeadDO.Emsdrugs.Name_dep + "库存为零，请重新选择药品或更改执行科室！");
                                    return;
                                }
                            }
                        }
                        catch //(Exception ex)
                        { }
                       
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

        //OrderSrvDoseViewModel drugChangeModel = new OrderSrvDoseViewModel();


        void drugChange_ValueChanged(object sender, EventArgs e)
        {

            /*
            if (gv_change != null && drugChange != null)
            {
                gv_change.Visible = drugChange.Checked;
                gv_change.Parent.Parent.Parent.Visible = drugChange.Checked;
            }
            if (drugChange.Checked)
            {
                if (this.EmsHeadDO.Emsdrugs.EmsOrDoseDrug.Count == 0)
                    cof.GetDoseDrugData(this.EmsHeadDO.Emsdrugs.Id_freq, this.EmsHeadDO);
                gv_change.DataTable.DataSource = this.EmsHeadDO.Emsdrugs.EmsOrDoseDrug;
                this.EmsHeadDO.Emsdrugs.EmsOrDoseDrug.ToList().ForEach(p =>
                {
                    p.Quan_med = this.EmsHeadDO.Emsdrugs.Quan_med;//剂量
                    p.Name_unit_med = this.EmsHeadDO.Emsdrugs.Name_unit_med;
                    // p.Quan_base = this.EmsHeadDO.Emsdrugs.Quan_base;//单次剂量
                    p.Id_unit_med = this.EmsHeadDO.Emsdrugs.Id_unit_med;
                });
                gv_change.Visible = true;
                if (gv_change.Parent != null)
                {
                    gv_change.Parent.Parent.Parent.Visible = true;
                }
                group.Location = new Point(group.Location.X, drugChange.Location.Y + 140);

            }
            else
            {
                gv_change.Visible = false;
                if (gv_change.Parent != null)
                {
                    gv_change.Parent.Parent.Parent.Visible = false;
                    //gv_change.Parent.Visible = false;
                }
                //gv_change.Parent.BackColor = Color.Green;

                this.EmsHeadDO.Emsdrugs.EmsOrDoseDrug.Clear();
                group.Location = new Point(group.Location.X, drugChange.Location.Y + 32);
            }
            */
        }
        /// <summary>
        /// Drugs 表单药品剂量数据写到药品do
        /// </summary>
        /// Author:admin
        /// Date:2015-10-21
        private void DrugWriteData()
        {
            if (this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count == 0) return;
            if (drug != null)
                drug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
            drug.Id_pgku_cur = drug.Id_unit_sale;
            return;
            /*
            //orDrug.Name_mm = this.EmsHeadDO.Emsdrugs.Name_mm;//药品名称
            //orDrug.Spec_mm = this.EmsHeadDO.Emsdrugs.Spec_mm;//规格
            //orDrug.Name_heath = this.EmsHeadDO.Emsdrugs.Name_heath;//医保类型
            //orDrug.Limit = this.EmsHeadDO.Emsdrugs.Limit;//限制报销条件
            //orDrug.Price = this.EmsHeadDO.Emsdrugs.Price;//参考价格
            if (this.EmsHeadDO.Emsdrugs.Total_count != null)
                drug.Quan_cur = (int)this.EmsHeadDO.Emsdrugs.Total_count;//总量
            drug.Id_unit_base = this.EmsHeadDO.Emsdrugs.Id_unit_base;
            drug.Name_unit_base = this.EmsHeadDO.Emsdrugs.Name_unit_base;
            drug.Id_unit_med = this.EmsHeadDO.Emsdrugs.Id_unit_med;
            drug.Name_unit_med = this.EmsHeadDO.Emsdrugs.Name_unit_med;
            drug.Id_pgku_cur = this.EmsHeadDO.Emsdrugs.Id_total_count_unit;//基本包装单位，如：片
            drug.Name_pgku_cur = this.EmsHeadDO.Emsdrugs.Total_count_unit;


            if (this.EmsHeadDO.Emsdrugs.Id_total_count_unit == null)
            {
                //orDrug.Id_pgku_cur =  this.EmsHeadDO.Emsdrugs.Id_unit_med ;
                //orDrug.Name_pgku_cur = this.EmsHeadDO.Emsdrugs.Name_unit_base;
            }

            //orDrug.Quan_base = this.EmsHeadDO.Emsdrugs.Quan_base;
            //drug.Quan_med = this.EmsHeadDO.Emsdrugs.Quan_med;
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
        private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy();
            policy.ClassName = "iih.ci.ord.ciordems.d.EmsOrDrug";
            //policy.AllowNew = flag;
            //policy.AllowEdit = flag;
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
            int? m = this.EmsHeadDO.Emsdrugs.Use_days % 7;
            //判断周期类型错误
            //if (this.EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
            if (this.EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
            {
                if (m == 6)
                {//减的 
                    int? uu = this.EmsHeadDO.Emsdrugs.Use_days / 7;


                    this.EmsHeadDO.Emsdrugs.Use_days = uu * 7;
                }
                else
                {
                    int? uu = this.EmsHeadDO.Emsdrugs.Use_days / 7;
                    this.EmsHeadDO.Emsdrugs.Use_days = (uu + 1) * 7;
                }

            }
        }

        #endregion

        //设置执行次数和执行时间:这个是在开立的时候做的，二次查看的时候要根据使用次数算执行时间
        public void GetMpTimes(string id_freq, EmsUIDTO EmsHeadDO, string[] exctimes, XapFormControl xapFormControl1)
        {
            cof.GetDoseDrugData(id_freq, this.EmsHeadDO);
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
            DateTime? dt = this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
            XLabelBaseUserRender tmpUserRender = xapFormControl1.GetUserRender("drugsUse", "quan_firday_mp") as XLabelBaseUserRender;
            XNumbericUpDown numRender = tmpUserRender.UserRender as XNumbericUpDown;
            //作为计算的时间
            DateTime date = DateTime.Now;
            //bool flag = false;
            if (dt != null)
            {
                DateTime dtNow = DateTime.Now;
                DateTime dtBegion = (DateTime)dt;
                string nowtime = dtBegion.ToShortTimeString().ToString();
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
                this.EmsHeadDO.Emsdrugs.Work_time = worktime;
                numRender.ValueText = numf.ToString();
                numRender.MaxValue = numf;
            }
            else
            {
                numRender.ValueText = null;
                numRender.MaxValue = 0;
            }
        }
        //设置执行次数和执行时间:这个是在开立的时候做的，二次查看的时候要根据使用次数算执行时间
        public void GetMpTimes(string id_freq)
        {
          //  cof.GetDoseDrugData(id_freq, this.EmsHeadDO);
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
            DateTime? dt = this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
            XLabelBaseUserRender tmpUserRender = xapFormControl1.GetUserRender("drugsUse", "quan_firday_mp") as XLabelBaseUserRender;
            XNumbericUpDown numRender = tmpUserRender.UserRender as XNumbericUpDown;
            //作为计算的时间
            DateTime date = DateTime.Now;
            //bool flag = false;
            if (dt != null)
            {
                DateTime dtNow = DateTime.Now;
                DateTime dtBegion = (DateTime)dt;
                string nowtime = dtBegion.ToShortTimeString().ToString();
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
                this.EmsHeadDO.Emsdrugs.Work_time = worktime;
                numRender.ValueText = numf.ToString();
                //暂时关掉,改为频次的次数
                //numRender.MinValue = numf;
                numRender.MaxValue = numf;
                this.EmsHeadDO.Emsdrugs.Quan_firday_mp = numf;
            }
            else
            {
                numRender.ValueText = null;
                numRender.MaxValue = 0;
            }
        }
    }
}
