using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.cards.extend;
using iih.ci.ord.ciorder.utils;
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
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.mm.itf.material.d;
using iih.bd.srv.srvortpl.srvortpl.view;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using iih.mm.itf.material.i;
using iih.ci.ord.ciorder.cards.drugext.dialogform;
using iih.ci.ord.ciord.d;
using iih.bd.bc.udi;
using iih.ci.ord.ciorder.cards.thread.dp;
using iih.ci.ord.cards.thread.dp;
using xap.cli.sdk.controls;
using iih.ci.iih.ci.ord.i;
using xap.cli.sdk.controls.navbar;
using xap.cli.sdk.form;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.BillFormTmplConst;

/********************************************************************************

** 作者： 张万青

** 创始时间：

** 修改人：张万青

** 修改时间：2016-6-30

** 描述：通用药品医疗单功能页面


*********************************************************************************/
namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// 通用药品医疗单
    /// </summary>
    /// Author:张万青
    /// Date:2016-05-21
    public partial class ExtOrderDrugsView : CiorderBaseControl
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
        private bool bEdit_Note_or;
        private string txt_Note_or = "";
        private string[] adjustHeightIds = new string[] { "dt_begin_ui", "use_days", "dt_end_ui", "quan_firday_mp", "work_time", "name_dep", "fg_self", "fg_propc", "note_or", "ci", "day" };
        #endregion

        #region 构造函数区域
        public ExtOrderDrugsView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderDrugsView_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            this.xapFormControl1.RefResult += this.OnRefResult;
            this.NowTime();
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            xapFormControl1.DataChanging += new EventHandler<DataChangingEventArgs>(xapFormControl1_DataChanging);
            xapFormControl1.DataDisplay += new EventHandler<XDataDisplayEventArgs>(ComSrvTableView_DataDisplay);
            xapFormControl1.AllowEditing += XapFormControl_AllowEditing;
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
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ExtOrderDrugsView;// "201605211029498192B5";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = EmsHeadDO.Emsdrugs;
            this.xapFormControl1.ViewFile = file;
            //xapFormControl1.SetEditPolicy(true);

        }

        //频次
        protected override void OnRefResult(object sender, RefResultEventArgs e)
        {
            RefDataCollection data = e.RefResultSet;
            if (data.Count == 0) return;
            //长临标志：根据选择的频次，默认读取BD_FREQ. fg_long显示长临标志。
            if (e.BindingFieldName == "Name_freq")
            {
                if (e.RefResultSet.IsEmpty) { return; }
                string id_freq = data.FirstData["Id_freq"] as string;//获取字段值
                //上一次的频次值
                string preSdFreq = EmsHeadDO.Emsdrugs.Sd_frequnitct;
                EmsHeadDO.Emsdrugs.Sd_frequnitct = data.FirstData["Sd_frequnitct"] as string;
                EmsHeadDO.Emsdrugs.Freqct = null;
                if (data.FirstData["Freqct"].ToString() != "")
                    EmsHeadDO.Emsdrugs.Freqct = int.Parse(data.FirstData["Freqct"].ToString());
                EmsHeadDO.Emsdrugs.Fg_long = data.FirstData["Fg_long"].ToString() == "Y" ? true : false;
                int labelHeight = cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").Size.Height + 5;
                //可将下面放到算法里
                if (data.FirstData["Fg_prnor"].ToString() == "Y")// 备用医嘱 true 并且 长临为 临时
                {
                    EmsHeadDO.Emsdrugs.Fg_pmor = true;
                    XLabelBaseUserRender tmpRender = cof.getControlByName(xapFormControl1, "drugsUse", "fg_long");
                    int h = 0;//高度变动值
                    if (tmpRender.ValueCode == "False")
                    {
                        if (cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible == false)
                        {
                            h += labelHeight;
                        }
                        cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible = true;//临时医嘱失效日期  

                        EmsHeadDO.Emsdrugs.Dt_fail = cof.GetSpareEndTime(EmsHeadDO.Emsdrugs.Dt_begin_ui.Value);
                        dt_fail.MinDate = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                        dt_fail.MaxDate = EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddHours(this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime)); ;
                        cof.getControlByName(xapFormControl1, "drugsUse", "bak_des").ValueText = "";
                    }
                    else
                    {
                        if (cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible == true)
                        {
                            h += -labelHeight;
                        }
                        cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible = false;//长期医嘱失效日期禁用

                        EmsHeadDO.Emsdrugs.Dt_fail = null;
                        EmsHeadDO.Emsdrugs.Use_days = null;
                        cof.getControlByName(xapFormControl1, "drugsUse", "bak_des").ValueText = "执行最小间隔时间：6小时。";
                    }
                    if (cof.getControlByName(xapFormControl1, "drugsUse", "bak_des").Visible == false)
                    {
                        h += labelHeight;
                    }
                    cof.setFreqctMaxMin(EmsHeadDO, xapFormControl1);
                    cof.getControlByName(xapFormControl1, "drugsUse", "bak_des").Visible = true;
                    //cof.adjustHeight(this.xapFormControl1, "drugsUse", adjustHeightIds, h);
                    //this.xapFormControl1.Invalidate();
                    //this.xapFormControl1.Refresh();
                }
                else
                {
                    EmsHeadDO.Emsdrugs.Fg_pmor = false;
                    int h = 0;
                    if (cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible == true)
                    {
                        h += -labelHeight;
                    }
                    cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible = false;//临时医嘱失效日期
                    if (cof.getControlByName(xapFormControl1, "drugsUse", "bak_des").Visible == true)
                    {
                        h += -labelHeight;
                    }
                    cof.getControlByName(xapFormControl1, "drugsUse", "bak_des").Visible = false;

                    //cof.adjustHeight(this.xapFormControl1,"drugsUse", adjustHeightIds, 20, "up");
                    cof.getControlByName(xapFormControl1, "drugsUse", "bak_des").ValueText = "";
                    EmsHeadDO.Emsdrugs.Dt_fail = null;
                    //cof.adjustHeight(this.xapFormControl1, "drugsUse", adjustHeightIds, h);
                    //this.xapFormControl1.Refresh();
                }
                //首日执行 只针对频次周期类型为‘天’的医嘱才可录入和显示首日执行次数，其他情况该控件隐藏。

                string name_freq = data.FirstData["Name"] as string;//获取字段值
                if (EmsHeadDO.Emsdrugs.Sd_frequnitct.Equals("2"))
                {
                    cof.getControlByName(xapFormControl1, "drugsUse", "quan_firday_mp").Enabled = true;//首日执行次数
                    cof.getControlByName(xapFormControl1, "drugsUse", "work_time").Enabled = false;//首日执行时间
                    GetMpTimes(id_freq);
                }
                else
                {
                    cof.getControlByName(xapFormControl1, "drugsUse", "quan_firday_mp").Enabled = false;//首日执行次数
                    cof.getControlByName(xapFormControl1, "drugsUse", "work_time").Enabled = false;//首日执行时间
                    cof.getControlByName(xapFormControl1, "drugsUse", "quan_firday_mp").UserRender.ValueText = "";
                    cof.getControlByName(xapFormControl1, "drugsUse", "work_time").ValueText = "";

                }
                if (EmsHeadDO.Emsdrugs.Sd_frequnitct.Equals(BdSrvDictCodeConst.SD_FREQUNIT_ONCE))//频次类型为一次
                {
                    EmsHeadDO.Emsdrugs.Fg_long = false;//长临标识 变临时
                    cof.getControlByName(xapFormControl1, "drugsUse", "fg_long").Enabled = false;// 

                    EmsHeadDO.Emsdrugs.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                }
                else
                {
                    if (preSdFreq == "0")
                    {
                        EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                    }
                }
                //长临标识可更改
                if (data.FirstData["Fg_long_edit"].ToString() == "Y")
                {
                    cof.getControlByName(xapFormControl1, "drugsUse", "fg_long").Enabled = true;
                }
                else
                {
                    cof.getControlByName(xapFormControl1, "drugsUse", "fg_long").Enabled = false;
                }

                if (EmsHeadDO.Emsdrugs.Fg_long == false)
                { //如果是临时的 使用天数和结束日期置灰
                    cof.getControlByName(xapFormControl1, "drugsUse", "dt_end_ui").Enabled = false;
                    cof.getControlByName(xapFormControl1, "drugsUse", "use_days").Enabled = false;
                }
                else
                {
                    cof.getControlByName(xapFormControl1, "drugsUse", "dt_end_ui").Enabled = true;
                    cof.getControlByName(xapFormControl1, "drugsUse", "use_days").Enabled = true;
                }
                cof.setDrugConStateAfterFilled(this.EmsHeadDO.Emsdrugs.Id_freq, this.adjustHeightIds, this.xapFormControl1);
            }
            else if (e.BindingFieldName.Equals("Name_unit_sale"))
            {
                if (e.RefResultSet.IsEmpty) { return; }
                cof.GetDrugTotal(EmsHeadDO);
            }
        }



        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName == "Name_route")
            {
                e.WherePart = string.Format("id_route in ({0})", new GetSrvVsRouteImp().GetDosageVsRounte("'" + string.Join("','", EmsHeadDO.Emsdrugs.EmsOrDrugList.Select(p => p.Id_srv).ToList()) + "'"));
            }
            else if (e.BindingFieldName.Equals("Name_dep"))
            {
                if (EmsHeadDO.Emsdrugs.Str_mp_dep_ids != null && EmsHeadDO.Emsdrugs.Str_mp_dep_ids != "")
                    e.WherePart = string.Format(" id_dep in({0})", EmsHeadDO.Emsdrugs.Str_mp_dep_ids);
            }
            else if (e.BindingFieldName.Equals("Name_unit_sale"))//计量单位
            {

                if (drug.Str_unit_pkg_ids != null && drug.Str_unit_pkg_ids != "")
                    e.WherePart = string.Format("id_measdoc in ({0})", drug.Str_unit_pkg_ids);
            }
            //else if (e.BindingFieldName.Equals("Name_freq"))//频次过滤条件暂时无法确定，暂时去掉过滤 zwq2016-08-03
            //{
            //    string freqSql = cof.getBdFreqType(EmsHeadDO.PatInfo.Code_entp);
            //    if (freqSql != "")
            //    {
            //        e.WherePart = freqSql;
            //    }

            //}
            else if (e.BindingFieldName.Equals("Name_routedes"))
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
        void ComSrvTableView_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            EmsOrDrug drug = e.Object as EmsOrDrug;
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_menu"))
            {
                if (drug.Quan_med == null)
                    drug.Quan_med = 0;
                if (drug.Name_unit_med == null)
                    drug.Name_unit_med = "";
                string strMed_unit = drug.Quan_med.ToString() + drug.Name_unit_med;
                row.ColumnCellDict["customercolumn_menu"].SetValue(strMed_unit);
            }
        }
        void xapFormControl1_DataChanging(object sender, DataChangingEventArgs e)
        {

            switch (e.PropName)//计算结束日期
            {
                case "Dt_begin_ui":
                    //DateTime adm = CommonExtentions.NowTime(this);//TODO: 入院时间
                    //if (e.Input == null || e.Input == "")
                    //{
                    //    EmsHeadDO.Emsdrugs.Dt_begin_ui = null;
                    //    string info = cof.CompareWithAdmission(EmsHeadDO.PatInfo.Id_ent, EmsHeadDO.Emsdrugs.Dt_begin_ui);
                    //    if (info != "")
                    //    {
                    //        this.ShowInfo(info);
                    //        e.Cancel = false;
                    //    }
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
            this.xapFormControl1.DataChanged -= new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            switch (e.PropName)//计算结束日期
            {
                case "Use_days"://医嘱天数
                    //if (EmsHeadDO.Emsdrugs.Dt_begin_ui == null)
                    //{
                    //    this.ShowInfo("请先录入开始时间！");
                    //    EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                    //    EmsHeadDO.Emsdrugs.Use_days = null;
                    //    this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                    //    EmsHeadDO.Days_or = EmsHeadDO.Emsdrugs.Use_days;
                    //    return;
                    //}
                    //if (uday == "-1")
                    //{
                    //    uday = "";
                    //    return;
                    //}
                    //if (EmsHeadDO.Emsdrugs.Use_days == null)
                    //{
                    //    EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                    //    this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                    //    EmsHeadDO.Days_or = EmsHeadDO.Emsdrugs.Use_days;
                    //    return;
                    //}


                    //if (EmsHeadDO.Emsdrugs.Use_days == 0)
                    //{
                    //    EmsHeadDO.Emsdrugs.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    //    this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                    //    EmsHeadDO.Days_or = EmsHeadDO.Emsdrugs.Use_days;
                    //    return;
                    //}
                    //else if (EmsHeadDO.Emsdrugs.Use_days == -1 && EmsHeadDO.Emsdrugs.Dt_end_ui == null)
                    //{
                    //    XLabelBaseUserRender tmpUserRender2 = sender as XLabelBaseUserRender;
                    //    uday = "-1";
                    //    tmpUserRender2.ValueText = "";
                    //    this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);

                    //    //CiHeadDo.Emsdrugs.Use_days = null;
                    //    return;
                    //}
                    ////else if (CiHeadDo.Emsdrugs.Use_days == -1)
                    ////{
                    ////    CiHeadDo.Emsdrugs.Use_days = null;
                    ////    CiHeadDo.Emsdrugs.Dt_end_ui = null;
                    ////    return;
                    ////}


                    ////取模
                    //int? m = EmsHeadDO.Emsdrugs.Use_days % 7;
                    ////判断周期类型错误
                    ////if (CiHeadDo.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
                    //if (string.IsNullOrEmpty(EmsHeadDO.Emsdrugs.Sd_frequnitct))
                    //{
                    //    LogicEx.GetInstance().setDrugFreqInfo(EmsHeadDO.Emsdrugs);
                    //}
                    //if (BdSrvDictCodeConst.SD_FREQUNIT_WEEK.Equals(EmsHeadDO.Emsdrugs.Sd_frequnitct))
                    //{
                    //    if (m != 0)
                    //    {//减的 
                    //        int? uu = EmsHeadDO.Emsdrugs.Use_days / 7;
                    //        EmsHeadDO.Emsdrugs.Use_days = (uu+1) * 7;
                    //    }
                    //}
                    //uday = "";
                    //EmsHeadDO.Days_or = EmsHeadDO.Emsdrugs.Use_days;
                    //if (EmsHeadDO.Emsdrugs.Use_days > 0)
                    //{
                    //    EmsHeadDO.Emsdrugs.Dt_end_ui = cof.GetEndTime(EmsHeadDO.Emsdrugs.Dt_begin_ui, EmsHeadDO.Emsdrugs.Use_days.Value);

                    //}
                    //CiHeadDo.Emsdrugs.Dt_end_ui = cof.GetEndTime(CiHeadDo.Emsdrugs.Dt_begin_ui, CiHeadDo.Emsdrugs.Use_days.Value);
                    break;
                case "Dt_end_ui"://计算医嘱天数
                    if (EmsHeadDO.Emsdrugs.Dt_begin_ui == null)
                    {
                        this.ShowInfo("请先录入开始时间！");
                        EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                        EmsHeadDO.Emsdrugs.Use_days = null;
                        this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                        EmsHeadDO.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_end_ui;
                        return;
                    }
                    if (EmsHeadDO.Emsdrugs.Dt_end_ui == null)
                    {
                        EmsHeadDO.Emsdrugs.Use_days = null;
                        this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                        EmsHeadDO.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_end_ui;
                        return;
                    }
                    DateTime dtb = (DateTime)EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    DateTime dte = (DateTime)EmsHeadDO.Emsdrugs.Dt_end_ui;
                    if (dtb.CompareTo(dte) > 0)
                    {

                        // e.Cancel = true;
                        EmsHeadDO.Emsdrugs.Dt_end_ui = dtb;
                        EmsHeadDO.Emsdrugs.Use_days = null;
                        this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                        this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                        EmsHeadDO.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_end_ui;
                        return;
                    }

                    EmsOrDrug drug = EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
                    EmsHeadDO.Emsdrugs.Use_days = cof.GetUseDays(EmsHeadDO.Emsdrugs.Dt_begin_ui, EmsHeadDO.Emsdrugs.Dt_end_ui);
                    judgeUseDayUserRenderMax(EmsHeadDO.Emsdrugs.Use_days);
                    EmsHeadDO.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_end_ui;
                    break;
                case "Id_freq":
                case "Name_freq"://计算执行时刻1
                    if (e.Input != null && ("2").Equals(EmsHeadDO.Emsdrugs.Sd_frequnitct))
                    {
                        cof.getControlByName(xapFormControl1, "drugsUse", "quan_firday_mp").Enabled = true;
                        cof.getControlByName(xapFormControl1, "drugsUse", "work_time").Enabled = false;
                        GetMpTimes(EmsHeadDO.Emsdrugs.Id_freq);
                    }
                    else
                    {
                        cof.getControlByName(xapFormControl1, "drugsUse", "quan_firday_mp").Enabled = false;
                        cof.getControlByName(xapFormControl1, "drugsUse", "work_time").Enabled = false;
                    }

                    //  先于 OnRefResult(object sender, RefResultEventArgs e)执行，会出现  这个地方获取的id 是上次的 而不是最新的
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
                    //设置结束时间的最小值
                    TimerComboBoxMaxAndMin.GetInstance().setMinTime(this.xapFormControl1, this.Context, "drugsUse", "dt_end_ui", EmsHeadDO.Emsdrugs.Dt_begin_ui);
                    if (EmsHeadDO.Emsdrugs.Dt_begin_ui == null)
                    {
                        EmsHeadDO.Emsdrugs.Use_days = null;//使用天数置为空
                        this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                        EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                        return;
                    }
                    GetMpTimes(EmsHeadDO.Emsdrugs.Id_freq);//设置首日执行时间
                    dtb = (DateTime)EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    if (EmsHeadDO.Emsdrugs.Dt_end_ui != null)
                    {
                        dtb = (DateTime)EmsHeadDO.Emsdrugs.Dt_begin_ui;
                        dte = (DateTime)EmsHeadDO.Emsdrugs.Dt_end_ui;
                        if (BdSrvDictCodeConst.SD_FREQUNIT_ONCE.Equals(EmsHeadDO.Emsdrugs.Sd_frequnitct))
                        {
                            //频次为once时
                            EmsHeadDO.Emsdrugs.Dt_end_ui = dtb;
                        }
                        else if (dte != null && dtb.CompareTo(dte) > 0)
                        {
                            EmsHeadDO.Emsdrugs.Dt_begin_ui = dte;
                            //设置结束时间的最小值
                            TimerComboBoxMaxAndMin.GetInstance().setMinTime(this.xapFormControl1, this.Context, "drugsUse", "dt_end_ui", EmsHeadDO.Emsdrugs.Dt_begin_ui);
                            EmsHeadDO.Emsdrugs.Use_days = 0;
                            this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                            this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                            EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                            return;
                        }
                        EmsHeadDO.Emsdrugs.Use_days = cof.GetUseDays(EmsHeadDO.Emsdrugs.Dt_begin_ui, EmsHeadDO.Emsdrugs.Dt_end_ui);
                    }
                    else
                    {
                        EmsHeadDO.Emsdrugs.Use_days = null;//使用天数置为空
                    }
                    judgeUseDayUserRenderMax(EmsHeadDO.Emsdrugs.Use_days);
                    if (EmsHeadDO.Emsdrugs.Dt_fail != null)
                    {
                        //备用药结束时间
                        EmsHeadDO.Emsdrugs.Dt_fail = cof.GetSpareEndTime(EmsHeadDO.Emsdrugs.Dt_begin_ui.Value);
                        dt_fail.MinDate = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                        dt_fail.MaxDate = EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddHours(this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime));
                    }
                    EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    break;
                case "Quan_cur":
                    GetStockReqDTO reqDto = new GetStockReqDTO();
                    string id_mm = EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_mm;
                    string id_dep_phy = EmsHeadDO.Emsdrugs.Id_dep;
                    reqDto.Id_dep = id_dep_phy;
                    reqDto.Id_mm = id_mm;
                    reqDto.Req_unit_id = EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_unit_sale;
                    GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
                    reqDtoArr[0] = reqDto;
                    MaterialStockDTO[] materialArr = cof.getMaterialStocksCount(reqDtoArr);
                    if (materialArr != null && materialArr.Length > 0)
                    {
                        MaterialStockDTO material = materialArr[0];
                        if (material == null || material.Quan_stock == 0)
                        {
                            this.ShowInfo(EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Name_mm + "数量已超过库存量，无法开立！");
                            this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                            return;
                        }
                    }
                    break;
                case "Name_routedes":
                    if (!bEdit_Note_or)
                    {
                        cof.SetNoteOr(this.EmsHeadDO);
                    }
                    break;
                default:
                    break;
            }
            this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);


        }
        /// <summary>
        /// 计算出的使用天数大于最大值时的处理，使用天数等于最大值
        /// </summary>
        /// <param name="Use_days"></param>
        private void judgeUseDayUserRenderMax(int? Use_days) {
            if (Use_days == null) return;
            XLabelBaseUserRender tmpUserRender = xapFormControl1.GetUserRender("drugsUse", "use_days") as XLabelBaseUserRender;
            XNumbericUpDown up = tmpUserRender.UserRender as XNumbericUpDown;
            double maxValue = up.MaxValue;
            if (maxValue >0 && maxValue < Convert.ToDouble(Use_days))
            {
                this.ShowInfo("使用天数在0-" + Convert.ToInt32(maxValue) + "之间！");
                EmsHeadDO.Emsdrugs.Use_days = Convert.ToInt32(maxValue);
                EmsHeadDO.Emsdrugs.Dt_end_ui = cof.GetEndTime(EmsHeadDO.Emsdrugs.Dt_begin_ui, EmsHeadDO.Emsdrugs.Use_days.Value);
            }
        }
        /// <summary>
        /// 设置首日执行次数的最大、最小值
        /// </summary>
        /// <param name="id_freq"></param>
        protected void setFirdyMpMaxValue(string id_freq)
        {
            string Work_time = cof.GetWorkTime(id_freq);
            DateTime? dt = EmsHeadDO.Emsdrugs.Dt_begin_ui;
            XLabelBaseUserRender tmpUserRender = xapFormControl1.GetUserRender("drugsUse", "quan_firday_mp") as XLabelBaseUserRender;
            XNumbericUpDown numRender = tmpUserRender.UserRender as XNumbericUpDown;
            string exctime = Work_time;
            if (exctime != null && exctime != "")
            {
                exctimes = exctime.Split(';');
                Array.Sort(exctimes);
                Array.Reverse(exctimes);

            }
            else
            {
                numRender.MaxValue = 0;
                numRender.MinValue = 0;
                return;
            }
            //作为计算的时间
            if (dt != null)
            {
                DateTime dtBegion = (DateTime)dt;
                string nowtime = dtBegion.ToShortTimeString().ToString();
                int numf = 0;
                for (int i = 0; i < exctimes.Length; i++)
                {
                    DateTime dt1 = Convert.ToDateTime(exctimes[i]);
                    DateTime dt2 = Convert.ToDateTime(nowtime);
                    if (dt1.CompareTo(dt2) >= 0)//大于等于
                    {
                        numf++;
                    }
                }
                numRender.MaxValue = numf;
            }
            else
            {
                numRender.MaxValue = 0;
            }
            numRender.MinValue = 0;
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
            XLabelBaseUserRender tmpUserRender = cof.getControlByName(xapFormControl1, "drugsUse", "quan_firday_mp");
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
            cof.getControlByName(xapFormControl1, "drugsUse", "fg_long").Enabled = false;
            cof.getControlByName(xapFormControl1, "drugsUse", "bak_des").Visible = false;
            cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible = false;

            EmsHeadDO.Emsdrugs.Fg_treat = true;//默认为治疗用药

            cof.adjustHeight(this.xapFormControl1, "drugsUse", adjustHeightIds, -((cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").Size.Height + 4) * 2));
            XTabControl tabControl = new XTabControl();
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            dic = tabs[0].Pages[0].DicUserRenders;
            gv = xapFormControl1.GetGridView("drug");//药品列表
            gv.MouseClick += new MouseEventHandler(gv_MouseClick);
            //gv.DataTable.CellValueChanged += new CellValueChangedEventHandler(CellValueChangedEventHandler);

            gv_change = this.xapFormControl1.GetGridView("change");//变动用药
            gv_change.Visible = false;

            //SetGridPolicy(true);
            xapFormControl1.SetTabPageEnabled("drugsUse", !IsReadOnly);

            SetGridPolicy(!IsReadOnly);
            cof.getControlByName(xapFormControl1, "drugsUse", "fg_long").Enabled = false;

            XTabControl tabControl1 = tabs[0].tabContrl;
            XTabPage xtab = tabControl1.XTabPages[1];
            tabControl1.SelectedIndexChanged += new XTabControl.selectedIndexChanged(tabControl1_SelectedIndexChanged);
            xtab.Controls.Clear();

            xtab.AddRender(desView);

            desView.Focus();
            //失效日期控件
            UserRender usfail = xapFormControl1.GetUserRender("drugsUse", "dt_fail");
            dt_fail = usfail.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;

            cof.getControlByName(xapFormControl1, "drugsUse", "work_time").LostFocus += new EventHandler(Work_time_LostFocus);
            cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").LostFocus += new EventHandler(Dt_fail_LostFocus);
            cof.getControlByName(xapFormControl1, "drugsUse", "note_or").GotFocus += new EventHandler(Note_or_GotFocus);
            cof.getControlByName(xapFormControl1, "drugsUse", "note_or").LostFocus += new EventHandler(Note_or_LostFocus);
            cof.getControlByName(xapFormControl1, "drugsUse", "use_days").LostFocus += new EventHandler(ExtOrderDrugsView_LostFocus);
        }

        void ExtOrderDrugsView_LostFocus(object sender, EventArgs e)
        {
            if (EmsHeadDO.Emsdrugs.Dt_begin_ui == null)
            {
                this.ShowInfo("请先录入开始时间！");
                EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                EmsHeadDO.Emsdrugs.Use_days = null;
                this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                EmsHeadDO.Days_or = EmsHeadDO.Emsdrugs.Use_days;
                return;
            }
            if (uday == "-1")
            {
                uday = "";
                return;
            }
            if (EmsHeadDO.Emsdrugs.Use_days == null)
            {
                EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                EmsHeadDO.Days_or = EmsHeadDO.Emsdrugs.Use_days;
                return;
            }


            if (EmsHeadDO.Emsdrugs.Use_days == 0)
            {
                EmsHeadDO.Emsdrugs.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
                EmsHeadDO.Days_or = EmsHeadDO.Emsdrugs.Use_days;
                return;
            }
            else if (EmsHeadDO.Emsdrugs.Use_days == -1 && EmsHeadDO.Emsdrugs.Dt_end_ui == null)
            {
                XLabelBaseUserRender tmpUserRender2 = sender as XLabelBaseUserRender;
                uday = "-1";
                tmpUserRender2.ValueText = "";
                this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);

                //CiHeadDo.Emsdrugs.Use_days = null;
                return;
            }
            //else if (CiHeadDo.Emsdrugs.Use_days == -1)
            //{
            //    CiHeadDo.Emsdrugs.Use_days = null;
            //    CiHeadDo.Emsdrugs.Dt_end_ui = null;
            //    return;
            //}


            //取模
            int? m = EmsHeadDO.Emsdrugs.Use_days % 7;
            //判断周期类型错误
            //if (CiHeadDo.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
            if (string.IsNullOrEmpty(EmsHeadDO.Emsdrugs.Sd_frequnitct))
            {
                LogicEx.GetInstance().setDrugFreqInfo(EmsHeadDO.Emsdrugs);
            }
            if (BdSrvDictCodeConst.SD_FREQUNIT_WEEK.Equals(EmsHeadDO.Emsdrugs.Sd_frequnitct))
            {
                if (m != 0)
                {//减的 
                    int? uu = EmsHeadDO.Emsdrugs.Use_days / 7;
                    EmsHeadDO.Emsdrugs.Use_days = (uu + 1) * 7;
                }
            }
            uday = "";
            EmsHeadDO.Days_or = EmsHeadDO.Emsdrugs.Use_days;
            if (EmsHeadDO.Emsdrugs.Use_days > 0)
            {
                EmsHeadDO.Emsdrugs.Dt_end_ui = cof.GetEndTime(EmsHeadDO.Emsdrugs.Dt_begin_ui, EmsHeadDO.Emsdrugs.Use_days.Value);

            }
        }

        void Note_or_GotFocus(object sender, EventArgs e)
        {
            txt_Note_or = cof.getControlByName(xapFormControl1, "drugsUse", "note_or").ValueText;
        }

        void Note_or_LostFocus(object sender, EventArgs e)
        {
            this.bEdit_Note_or = !txt_Note_or.Equals(cof.getControlByName(xapFormControl1, "drugsUse", "note_or").ValueText);
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
        void CellValueChangedEventHandler(object sender, XCellValueChangedEventArgs e)
        {
            if (e.Data is EmsOrDrug && "customercolumn_menu".Equals(e.Column.FieldName))
            {
                EmsOrDrug drug = (EmsOrDrug)e.Data;
                if (drug.Quan_med == null || drug.Quan_med == 0)
                {
                    (sender as XCellRender).BackColor = Color.Red;
                    //Color.FromArgb(255, 225, 225);
                }
                else
                {
                    (sender as XCellRender).BackColor = Color.FromArgb(203, 242, 252);
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
            cof.getControlByName(xapFormControl1, "drugsUse", "dt_begin_virtual").Visible = false;
            cof.getControlByName(xapFormControl1, "drugsUse", "work_time").Enabled = false;//首日执行时间
            SetGridPolicy(!IsReadOnly);
            group = this.xapFormControl1.GetUserRender("drugsUse", "group") as XGroupBox;
            EmsHeadDO.Emsdrugs.EmsOrDrug = cof.MmSortList(EmsHeadDO.Emsdrugs.EmsOrDrug);
            if (gv != null)
            {
                gv.DataTable.DataSource = EmsHeadDO.Emsdrugs.EmsOrDrugList;
                //加载时为自定义服务药品列表绑定事件，并缓存自定义服务的剂量单位 zwq 2016-07-18
                drugBindPropertyEventAndCacheUnimed(EmsHeadDO.Emsdrugs.EmsOrDrugList);
                cof.threadSetMaterialInfoOfDrug(EmsHeadDO.Emsdrugs.EmsOrDrug, middle);

            }
            mapUnit = new Dictionary<string, string>();
            //记录单位名称
            if (EmsHeadDO.Emsdrugs.EmsOrDrugList.Count() > 0 && EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_srv != null)
            {
                mapUnit.Add(EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_srv, EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Name_unit_sale);
            }
            if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0] != null && (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_ctm == null || EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_ctm == false))
            {
                gv.DataTable.Columns[0].ReadOnly = true;
            }
            else
            {
                gv.DataTable.Columns[0].ReadOnly = false;
            }
            bEdit_Note_or = !this.EmsHeadDO.IsNEW;
            if (EmsHeadDO.IsNEW)
            {
                cof.SetNoteOr(this.EmsHeadDO);
                GetMpTimes(EmsHeadDO.Emsdrugs.Id_freq);
                //设置执行次数的最大值和最小值
                //cof.setFreqctMaxMin(EmsHeadDO,xapFormControl1);
                EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Name_unit_sale = "";
            }
            else
            {
                string exctime = cof.GetWorkTime(EmsHeadDO.Emsdrugs.Id_freq);
                if (exctime != null && exctime != "")
                {
                    exctimes = exctime.Split(';');
                    Array.Sort(exctimes);
                    Array.Reverse(exctimes);

                }
                cof.setMpWorkTimesOnEdit(EmsHeadDO, exctimes);
                setFirdyMpMaxValue(EmsHeadDO.Emsdrugs.Id_freq);
            }
            gv.ReadOnly = false;
            gv.DataTable.Columns[1].ReadOnly = false;
            gv.DataTable.Columns[3].ReadOnly = false;
            //限制开始时间的时间范围，入院日期，最大提前日期
            TimerComboBoxMaxAndMin.GetInstance().setMaxMinTime(xapFormControl1, this.Context, "drugsUse", "dt_begin_ui", EmsHeadDO.PatInfo.Id_ent);   
           
            //UserRender us = xapFormControl1.GetUserRender("drugsUse", "dt_begin_ui");
            //xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
            //DateTime? dataA = new GetInHosTime().GetPatInHosTime(EmsHeadDO.PatInfo.Id_ent);
            //dt_begin.MinDate = dataA;
            //dt_begin.MaxDate = cof.GetServerDataTime().AddDays(OrdParam.GetOrdParam.orBeforStartDays);

            //限制结束时间的时间范围，入院日期，最大提前日期
            UserRender usend = xapFormControl1.GetUserRender("drugsUse", "dt_end_ui");
            xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_end = usend.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;

            UserRender name_route = xapFormControl1.GetUserRender("drugsUse", "name_route");
            name_route.Focus();

            dt_end.MinDate = EmsHeadDO.Emsdrugs.Dt_begin_ui;
            cof.setDrugConStateAfterFilled(this.EmsHeadDO.Emsdrugs.Id_freq, this.adjustHeightIds, this.xapFormControl1);
            //  IsReadOnly = false;
            if (EmsHeadDO.IsNEW)
            {
                if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_mm != null)
                {
                    ////库存量的判断
                    //GetStockReqDTO reqDto = new GetStockReqDTO();
                    //reqDto.Id_dep = EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_mp_dep;
                    //reqDto.Id_mm = EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_mm;
                    //reqDto.Req_unit_id = EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_unit_sale;
                    //GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
                    //reqDtoArr[0] = reqDto;
                    //MaterialStockDTO[] materialArr = cof.getMaterialStocksCount(reqDtoArr);
                    //if (materialArr != null && materialArr.Length > 0)
                    //{
                    //    MaterialStockDTO material = materialArr[0];
                    //    if (material != null && material.Quan_stock > 0)
                    //    {
                    //    }
                    //    else
                    //    {
                    //        this.ShowInfo("该药品在" + EmsHeadDO.Emsdrugs.Name_dep + "库存为零，请重新选择药品或更改执行科室！");
                    //        return;
                    //    }
                    //}
                }
                if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_ctm == true) return;
                //数据填充完成后，进行皮试判断
                //数据回写后，进行皮试判断
                if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_skintest != null && EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_skintest == true)
                {
                    SkinTestLogic skinLogic = new SkinTestLogic(EmsHeadDO.PatInfo);
                    skinLogic.skinTestLogic(EmsHeadDO.Emsdrugs.EmsOrDrugList[0], this);
                }
                //毒麻药品核对患者信息
                //if (cof.verifyPois(EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_pois.Value, EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Sd_pois))
                //{
                //    OrSrvAgentInfoDO agentInfo = cof.newOrSrvAgentInfoDOFromBanner(EmsHeadDO.PatInfo);
                //    EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Agentinfolist.Add(agentInfo);
                //    CheckPatAgentInfoDialog dialog = new CheckPatAgentInfoDialog(agentInfo);
                //    dialog.ShowDialog();
                //}
            }
        }


        /// <summary>
        /// 弹出物品选择器
        /// </summary>
        /// <param name="ds"></param>
        /// <param name="def"></param>
        /// <param name="atPoint"></param>
        private void ShowMmSelector(XDataRow row, List<EmsOrDrug> ds, EmsOrDrug def, Point atPoint, bool canEdit = true)
        {
            var query = from items in ds orderby items.Fact_count descending select items;

            var mmContainer = new XBaseControl() { Size = new Size(473, 160) }; 
            var mm = new ExtMmRefView(LogicEx.GetInstance().ConvertDataSouse<EmsOrDrug>(query.ToList()), def) { Dock = DockStyle.Fill, Enabled = canEdit };
            mmContainer.AddRender(mm);
            
            
            var popWindow = new XContextForm(mmContainer);
            mm.Event_SelectChanged += (sender, e) => {
                EmsOrDrug orDrug = EmsHeadDO.Emsdrugs.EmsOrDrugList[gv.FocusedRowHandle];
                var mmDrug = e.Data as EmsOrDrug;

               

                if (mmDrug == null)
                {
                    if (orDrug.Fg_self == true)
                    {
                        orDrug.Name_mm = orDrug.Name_srv;
                        orDrug.Id_mm = null;
                    }
                    popWindow.Close();
                    return;
                }

                #region 皮试逻辑的判断
                if (mmDrug.Fg_skintest != null && mmDrug.Fg_skintest == true)
                {
                    SkinTestLogic logic = new SkinTestLogic(EmsHeadDO.PatInfo);
                    orDrug.Name_mm = mmDrug.Name_mm;
                    orDrug.Id_mm = mmDrug.Id_mm;
                    orDrug.Id_srvskin = mmDrug.Id_srvskin;
                    if (logic.skinTestLogic(orDrug).Equals("0"))
                    {
                        
                        return;
                    }

                }
                #endregion
                cof.CopyTo(mmDrug, orDrug, "Id_srv", "Name_srv");
                cof.concateMMSpecAndName(orDrug);
                orDrug.Fg_mm = true;
                popWindow.Close();
            };
            popWindow.Show(atPoint);
        }


        

        private void ShowNoteExSelector(Ent4BannerDTO patInfo, EmsOrDrug drug, Point atPoint, bool canEdit = true)
        {
            var mmContainer = new XBaseControl() { Size = new Size(355, 115), SingleBorderStyle = true };
            var mm = new ExtOrderDrugDialog(patInfo, drug) { Dock = DockStyle.Fill, Enabled = canEdit };
            mmContainer.AddRender(mm);
            var popWindow = new XContextForm(mmContainer);


            popWindow.Closing += (sender, e) => {
                e.Cancel = false;
            };
            popWindow.Closed += (sender, e) => {
                string extInfo = this.concatExtInfo(mm, drug);
                drug.Note_ext = extInfo;
            };

            popWindow.Show(atPoint);

        }

        void gv_MouseClick(object sender, MouseEventArgs e)
        {
            drug = xapFormControl1.GetFocused<EmsOrDrug>("drug");
            XDataRow drow = sender as XDataRow;
            if (gv.GetFocusedRow().ClickCell.FieldName == "Name_mm" && !IsReadOnly)
            {
                //判断自定义服务不为null 并且 自定义服务为true时 return;
                if ((((gv.GetFocusedRow().RowDataSource as EmsOrDrug).Fg_ctm)!= null) && ((bool)(gv.GetFocusedRow().RowDataSource as EmsOrDrug).Fg_ctm)) return;
                string id_srv = (gv.GetFocusedRow().RowDataSource as EmsOrDrug).Id_srv;//拿到 点击的药品对应服务的id_srv
                //根据服务id 取到 服务关联的药品 ，
                if (EmsHeadDO.Emsdrugs.EmsOrDrug.Count > 0)
                {
                    EmsOrDrug emsordrug = gv.GetFocusedRow<EmsOrDrug>();
                    if (middle.getEmsOrDrugList() == null) return;
                    List<EmsOrDrug> list = middle.getEmsOrDrugList().ToList().Where<EmsOrDrug>(p => p.Id_srv == id_srv).ToList();
                    // 替换下边注释的逻辑
                    this.ShowMmSelector(drow, list, emsordrug, gv.PointToScreen(new Point(drow.ClickCell.Location.X, drow.Location.Y + drow.Size.Height + 1)), !IsReadOnly);
                    /*
                    ExtMmForm mmref = new ExtMmForm(cof.ConvertDataSouse<EmsOrDrug>(list), EmsHeadDO.Emsdrugs, emsordrug);
                    mmref.StartPosition = FormStartPosition.Manual;
                    mmref.Location = gv.PointToScreen(new Point(drow.ClickCell.Location.X, drow.Location.Y + drow.Size.Height + 1));
                    mmref.setEdit(!IsReadOnly);
                    mmref.TopMost = true;
                    if (mmref.ShowDialog() == DialogResult.OK)
                    {
                        EmsOrDrug orDrug = EmsHeadDO.Emsdrugs.EmsOrDrugList[gv.FocusedRowHandle];
                        if (mmref.drugmm == null)
                        {
                            if (orDrug.Fg_self == true)
                            {
                                orDrug.Name_mm = orDrug.Name_srv;
                                orDrug.Fg_mm = false;
                                orDrug.Id_mm = null;
                            }
                            return;
                        }
                        //数据回写后，进行皮试判断
                        if (mmref.drugmm.Fg_skintest != null && mmref.drugmm.Fg_skintest == true)
                        {
                            SkinTestLogic logic = new SkinTestLogic(EmsHeadDO.PatInfo);
                            orDrug.Name_mm = mmref.drugmm.Name_mm;
                            orDrug.Id_mm = mmref.drugmm.Id_mm;
                            orDrug.Id_srvskin = mmref.drugmm.Id_srvskin;
                            if (logic.skinTestLogic(orDrug).Equals("0"))
                            {
                                return;
                            }
                        }
                        cof.CopyTo(mmref.drugmm, orDrug, "Id_srv", "Name_srv");
                        orDrug.Fg_mm = true;
                        cof.concateMMSpecAndName(orDrug);
                        

                    }
                    //*/
                }
            }
            else if (gv.GetFocusedRow().ClickCell.FieldName == "Note_ext")
            {
                EmsOrDrug emsordrug = gv.GetFocusedRow<EmsOrDrug>();
                var atPoint = gv.PointToScreen(new Point(drow.ClickCell.Location.X, drow.Location.Y + drow.Size.Height + 1));

                //ShowNoteExSelector(EmsHeadDO.PatInfo, emsordrug, atPoint, !IsReadOnly);
                
                
                ExtDrugForm mmref = new ExtDrugForm(EmsHeadDO, emsordrug);
                mmref.StartPosition = FormStartPosition.Manual;
                mmref.Location = gv.PointToScreen(new Point(drow.ClickCell.Location.X - (mmref.splitContainer1.Width - gv.DataTable.Columns["Note_ext"].Width), drow.Location.Y + drow.Size.Height + 1));
                mmref.TopMost = true;
                mmref.setEdit(!IsReadOnly);
                if (mmref.ShowDialog() == DialogResult.OK)
                {
                    string extInfo = this.concatExtInfo(mmref.mm, emsordrug);
                    emsordrug.Note_ext = extInfo;
                    //ConvertToEmsOrDrug(mmref.mm.Emsdrugs, emsordrug);
                }
                else {
                    //string s = "";
                }//*/
            }
        }
        private void ConvertToEmsOrDrug(EmsDrugItemDO emsDrugItem, EmsOrDrug emsDrug)
        {
            emsDrug.Fg_propc = emsDrugItem.Fg_propc;
            emsDrug.Fg_treat = emsDrugItem.Fg_treat;
            emsDrug.Id_mp_dep = emsDrugItem.Id_dep;
            emsDrug.Name_mp_dep = emsDrugItem.Name_dep;
            emsDrug.Note_or = emsDrugItem.Note_or;
        }
        /// <summary>
        /// 拼接扩展说明
        /// </summary>
        /// <param name="mmref"></param>
        private string concatExtInfo(ExtOrderDrugDialog mmref, EmsOrDrug emsOrDrug)
        {
            string exeInfo = "";
            string propcStr = "";
            //存在抗生素
            if (mmref.flag == "0" || mmref.flag == "1")
            {
                if (emsOrDrug.Fg_propc != null)
                {
                    propcStr = emsOrDrug.Fg_propc == true ? "抗生素预防使用" : "抗生素治疗使用";
                    exeInfo += propcStr;
                }

            }
            string treatStr = "";
            //存在医保
            if (!string.IsNullOrEmpty(this.EmsHeadDO.PatInfo.Id_hp) && (mmref.flag == "0" || mmref.flag == "2"))
            {
                if (emsOrDrug.Fg_treat != null)
                {
                    treatStr = emsOrDrug.Fg_treat == true ? "适应医保限制" : "非适应医保限制";
                    if (exeInfo.Length > 0)
                    {
                        exeInfo += "," + treatStr;
                    }
                    else
                    {
                        exeInfo += treatStr;
                    }
                }
            }
            if (exeInfo.Length > 0)
            {
                exeInfo += "," + emsOrDrug.Name_mp_dep;
            }
            else
            {
                exeInfo += emsOrDrug.Name_mp_dep;
            }
            if (!string.IsNullOrEmpty(emsOrDrug.Note_or))
            {
                if (exeInfo.Length > 0)
                {
                    exeInfo += "," + emsOrDrug.Note_or;
                }
                else
                {
                    exeInfo += emsOrDrug.Note_or;
                }
            }
            return exeInfo;
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
                if (EmsHeadDO.Emsdrugs.EmsOrDoseDrug.Count == 0)
                    cof.GetDoseDrugData(EmsHeadDO.Emsdrugs.Id_freq, EmsHeadDO);
                gv_change.DataTable.DataSource = EmsHeadDO.Emsdrugs.EmsOrDoseDrug;
                EmsHeadDO.Emsdrugs.EmsOrDoseDrug.ToList().ForEach(p =>
                {
                    p.Quan_med = EmsHeadDO.Emsdrugs.Quan_med;//剂量
                    p.Name_unit_med = EmsHeadDO.Emsdrugs.Name_unit_med;
                    // p.Quan_base = EmsHeadDO.Emsdrugs.Quan_base;//单次剂量
                    p.Id_unit_med = EmsHeadDO.Emsdrugs.Id_unit_med;
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

                EmsHeadDO.Emsdrugs.EmsOrDoseDrug.Clear();
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
            //if (xapFormControl1.HasErrors)
            //{
            //    this.ShowAlert(xapFormControl1.ErrorAlertText);
            //    return;
            //}
            DrugWriteData();
        }

        #endregion

        #region 辅助处理函数
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


        #endregion

        //设置执行次数和执行时间:这个是在开立的时候做的，二次查看的时候要根据使用次数算执行时间
        public void GetMpTimes(string id_freq, EmsUIDTO EmsHeadDO, string[] exctimes, XapFormControl xapFormControl1)
        {
            cof.GetDoseDrugData(id_freq, EmsHeadDO);
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
                EmsHeadDO.Emsdrugs.Work_time = worktime;
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
            //cof.GetDoseDrugData(id_freq, EmsHeadDO);
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
                EmsHeadDO.Emsdrugs.Work_time = worktime;
                numRender.ValueText = numf.ToString();
                numRender.MaxValue = numf;
                EmsHeadDO.Emsdrugs.Quan_firday_mp = numf;
            }
            else
            {
                numRender.ValueText = null;
                numRender.MaxValue = 0;
            }
        }
        private void XapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            EmsOrDrug item = e.Object as EmsOrDrug;
            if (item == null)
                return;

            string[] readonlyNames = new[] { "Note_ext", "Name_mm" };

            //if (readonlyNames.Contains(e.PropName))
                //e.Cancel = true;
        }
    }
}
