using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.ciordems.d;
using xap.rui.control.forms.control;
using iih.ci.ord.ciorder.utils;
using xap.cli.sdk.render;
using xap.rui.control.forms.model;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.ciorder.cards.extend;
using xap.cli.sdk.controls.herbalPrescription;
using xap.mw.core.data;
using xap.rui.control.refcontrol.data;
using xap.rui.control.refcontrol.events;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.Validate;
using xap.rui.appfw;
using xap.cli.sdk.render.Items;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.ems.d;
using iih.mm.itf.material.d;
using xap.cli.sdk.controls.DataView;
using iih.ci.iih.ci.ord.i;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.mw.coreitf.d;

/********************************************************************************

** 作者： 张万青

** 创始时间：

** 修改人：张万青

** 修改时间：2016-6-30

** 描述： 草药医疗单功能页面


*********************************************************************************/
namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// 草药医疗单
    /// </summary>
    /// Author:admin
    /// Date:2015-10-10
    public partial class OrderHerbsView : CiorderBaseControl
    {
        #region 变量定义区域

        public XapFormControl xapFormControl1;

        HerBalMedicineCtr her;

        XapFormGridControl gv;//, gv_change;// 药品商品表，变动用药
        Dictionary<string, UserRender> dic = new Dictionary<string, UserRender>();//界面控件集合
        EmsOrDrug selectDrugDo = new EmsOrDrug();
        OrderDrugDesView desView = new OrderDrugDesView() { Dock = DockStyle.Fill };
        //用户是否编辑了医嘱备注
        private bool userEditFlag;
        //医嘱备注获得焦点时的值
        private string focusText;

        private string uday = "";
        #endregion

        #region 构造函数区域
        public OrderHerbsView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderHerbsView_Load);

            this.xapFormControl1 = new XapFormControl() { Dock = DockStyle.Fill };
            this.xapFormControl1.Padding = new Padding(0, 4, 0, 0);
            this.AddRender(this.xapFormControl1);

            this.xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            this.xapFormControl1.RefResult += this.OnRefResult;
            this.xapFormControl1.RefFilter += new EventHandler<RefActivatingEventArgs>(xapFormControl1_RefFilter);
            this.xapFormControl1.RefCanSelect += new EventHandler<RefCanSelectEventArgs>(xapFormControl1_RefCanSelect);
            this.xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            this.xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);

            her = new HerBalMedicineCtr() { MedicineName = "Name_mm", DosageName = "Quan_med", UsgeName = "Name_boildes", UnitName = "Name_unit_med", HerbalWidth = 99, HerbalHeight = 35 };
            her.SelectedClick += new EventHandler(her_SelectedClick);
            Dictionary<string, Control> controls = new Dictionary<string, Control>();
            controls.Add("herCtl", her);
            this.xapFormControl1.RegisterControl(controls);
            SheetName = "草药医疗单";
        }

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
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderHerbsView;// "20150929114420456GAD";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.EmsHeadDO.Emsdrugs;
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);

        }//频次

        public override void SaveBefore()
        {
            if (this.EmsHeadDO.Emsdrugs.Orders_boil != null)
            {
                this.EmsHeadDO.Emsdrugs.Fg_bl = true;
            }
            if (this.EmsHeadDO.Emsdrugs.Name_dep == null)
            {
                this.EmsHeadDO.Emsdrugs.Name_dep = "";//todo 
            }

            //cof.GetDrugUseTotalCount(this.EmsHeadDO);

            xapFormControl1.SaveForm();

        }

        protected override void OnRefResult(object sender, RefResultEventArgs e)
        {
            RefDataCollection data = e.RefResultSet;
            if (data.Count == 0) return;
            if (e.BindingFieldName == "Name_freq")
            {
                if (e.RefResultSet.IsEmpty) { return; }
                string id_freq = data.FirstData["Id_freq"] as string;//获取字段值
                this.EmsHeadDO.Emsdrugs.Sd_frequnitct = data.FirstData["Sd_frequnitct"] as string;
                this.EmsHeadDO.Emsdrugs.Freqct = null;
                if (data.FirstData["Freqct"].ToString() != "")
                    this.EmsHeadDO.Emsdrugs.Freqct = int.Parse(data.FirstData["Freqct"].ToString());
                this.EmsHeadDO.Emsdrugs.Fg_long = data.FirstData["Fg_long"].ToString() == "Y" ? true : false;
            }
            string code_freq = data.FirstData["Code"] as string;//获取字段值
            if (code_freq == "once")
            {
                this.EmsHeadDO.Emsdrugs.Fg_long = false;//长临标识 变临时
                //getControlByName("drugsUse", "fg_long").Enabled = false;// 

                this.EmsHeadDO.Emsdrugs.Dt_end_ui = this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
            }
            
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                //新增时候 参照写会
                EmsOrDrug drugNew = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
                string strSrv = data.FirstData["Name"].ToString();
                if (this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count(p => p.Name_srv == strSrv) > 1)
                {
                    this.ShowInfo("存在相同的服务！");
                    drugNew.Name_srv = null;
                    drugNew.Id_srv = null;
                    return;
                }
                drugNew.Quan_med = data.FirstData["Quan_med"]==null?null:new FDouble(data.FirstData["Quan_med"].ToString());
                XapDataList<EmsOrDrug> drugs = cof.GetSrvMm(this.EmsHeadDO, drugNew.Id_srv,this.EmsHeadDO.PatInfo.Code_entp);
                if (drugs.Count > 0)
                {
                    EmsOrDrug drugRef = drugs.FirstOrDefault();
                    cof.CopyTo(drugRef, drugNew, "Id_srv", "Name_srv");
                    cof.concateExtNote(new XapDataList<EmsOrDrug>() { drugNew},this.EmsHeadDO.PatInfo,this.EmsHeadDO);
                }
                else {
                    this.ShowInfo("服务未绑定物品，请与信息科联系！", "提示");
                    drugNew.Id_srv = "";
                    drugNew.Name_srv = "";
                    drugNew.Name_mm = "";
                    drugNew.Id_mm = "";
                    drugNew.Spec_mm = "";
                    drugNew.Quan_med = null;
                    drugNew.Name_unit_med = "";
                    drugNew.Quan_cur = null;
                    drugNew.Name_unit_sale = "";
                    return;
                }
            }
        }

        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            this.EmsHeadDO = headDo;
            //if (headDo.IsNEW)
            //{
            //    this.EmsHeadDO.Emsdrugs.EmsOrDrugList = this.EmsHeadDO.Emsdrugs.EmsOrDrug;
            //}
            EmsHeadDO = headDo;
            CiEmsDTO = e as CiEmsDTO;
            if (this.Created)
            {
                ((XNumbericUpDown)((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "orders_boil")).UserRender).MaxValue = 999;
               
                this.LoadData();
            }
        }

        public override Validate.IValidate GetOrdValidate()
        {
            return new OrderHerbsValidate();
        }

        public override XapFormControl GetXapFormControl()
        {
            return this.xapFormControl1;
        }
        #endregion

        #region 内部事件区域

        void OrderHerbsView_Load(object sender, EventArgs e)
        {
            OnInit();
        }
        
        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            XTabControl tabControl = new XTabControl();
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            dic = tabs[0].Pages[0].DicUserRenders;

            XTabControl tab = tabs[0].tabContrl;

            gv = xapFormControl1.GetGridView("drug");//药品列表
            gv.MouseClick += new MouseEventHandler(gv_MouseClick);

            UserRender btnDelete = xapFormControl1.GetUserRender("drugsUse", "btndelete");//删除
            btnDelete.MouseClick += new MouseEventHandler(btnDelete_MouseClick);

            UserRender btnAdd = this.xapFormControl1.GetUserRender("drugsUse", "btnAdd");//新增按钮
            btnAdd.MouseClick += new MouseEventHandler(btnAdd_MouseClick);

            UserRender ur_begin = xapFormControl1.GetUserRender("drugsUse", "dt_begin_ui");
            XCalendarTimerComboBox dt_begin = ur_begin.Renders[0] as XCalendarTimerComboBox;
            dt_begin.MouseClick += new MouseEventHandler(dt_begin_MouseClick);

            UserRender ur_end = xapFormControl1.GetUserRender("drugsUse", "dt_end_ui");
            XCalendarTimerComboBox dt_end = ur_end.Renders[0] as XCalendarTimerComboBox;
            dt_end.MouseClick += new MouseEventHandler(dt_end_MouseClick);

            SetGridPolicy(true);
            gv.DataTable.ReadOnly = false;
            gv.DataTable.Columns["Spec_mm"].ReadOnly = true;
            //gv.DataTable.Columns["Quan_med"].ReadOnly = true;

            //----------药品说明----------------------
            XTabControl tabControl1 = tabs[0].tabContrl;
            XTabPage xtab = tabControl1.XTabPages[1];
            tabControl1.SelectedIndexChanged += new XTabControl.selectedIndexChanged(tabControl1_SelectedIndexChanged);
            xtab.RemoveRenderAll();
            xtab.AddRender(desView);
            //待歼付数
            ((XNumbericUpDown)((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "orders_boil")).UserRender).MinValue = 0;
            ((XNumbericUpDown)((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "orders")).UserRender).MinValue = 1;
            //为医嘱备注绑定事件
            ((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "note_or")).GotFocus += new EventHandler(OrderHerbsView_GotFocus);
            ((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "note_or")).LostFocus += new EventHandler(OrderHerbsView_LostFocus);
            xapFormControl1.GotFocus += new EventHandler(xapFormControl1_GotFocus);
            xapFormControl1.LostFocus += new EventHandler(xapFormControl1_LostFocus);
            // 注册最后一次的回车换行的操作逻辑
            this.RegEnterKeyOverEvent(row =>
            {
                // 新增一行
                btnAdd_MouseClick(this, null);
                return true;
            },
            null);
        }

        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            //xapFormControl1.SetTabPageEnabled("drugsUse", !IsReadOnly);
            //xapFormControl1.SetEditable(!IsReadOnly);
            SetGridPolicy(!IsReadOnly);
            
            her.DataSource = this.EmsHeadDO.Emsdrugs.EmsOrDrugList;
            
            her.Enabled = true;
            gv.DataTable.DataSource = null;
            if (gv.DataTable.Rows.Count == 0 && this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count > 0)
            {
                gv.DataTable.DataSource = new BindingList<EmsOrDrug>() { this.EmsHeadDO.Emsdrugs.EmsOrDrugList.LastOrDefault() };
            }
            //--------------------------------
            ((XNumbericUpDown)((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "orders_boil")).UserRender).MaxValue = this.EmsHeadDO.Emsdrugs.Orders == null ? 0 : (double)this.EmsHeadDO.Emsdrugs.Orders;

            //限制开始时间的时间范围，入院日期，最大提前日期
            TimerComboBoxMaxAndMin.GetInstance().setMaxMinTime(xapFormControl1, this.Context, "drugsUse", "dt_begin_ui", EmsHeadDO.PatInfo.Id_ent);
            try
            {
                //限制结束日期为可拆分的最大天数
                int maxDays = this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS);
                TimerComboBoxMaxAndMin.GetInstance().setMaxTime(xapFormControl1, this.Context, "drugsUse", "dt_end_ui", ((DateTime)this.EmsHeadDO.Emsdrugs.Dt_begin_ui).AddDays(maxDays));
                TimerComboBoxMaxAndMin.GetInstance().setMinTime(xapFormControl1, this.Context, "drugsUse", "dt_end_ui", (DateTime)this.EmsHeadDO.Emsdrugs.Dt_begin_ui);
            }
            catch //(Exception ex)
            { }
            //UserRender us = xapFormControl1.GetUserRender("drugsUse", "dt_begin_ui");
            //xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
            //DateTime? dataA = new GetInHosTime().GetPatInHosTime(this.EmsHeadDO.PatInfo.Id_ent);
            //dt_begin.MinDate = dataA;
            //dt_begin.MaxDate = cof.GetServerDataTime().AddDays(OrdParam.GetOrdParam.orBeforStartDays);
            //重新填充数据时,设置为false
            UserRender orders = xapFormControl1.GetUserRender("drugsUse", "orders");
            orders.Focus();
            userEditFlag = !this.EmsHeadDO.IsNEW;
            if (this.EmsHeadDO.IsNEW)
                cof.SetNoteOr(this.EmsHeadDO);
            BindingList<EmsOrDrug> bds = gv.DataTable.DataSource as BindingList<EmsOrDrug>;
            her.FocusIndex = this.EmsHeadDO.Emsdrugs.EmsOrDrugList.IndexOf(bds.FirstOrDefault());
        }

        void xapFormControl1_RefCanSelect(object sender, RefCanSelectEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                RefData data = e.SelectingData;
                string strSrv = data["Name"] as string;

                //新增时候 参照写会
                EmsOrDrug drugNew = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
                // string strSrv = data.FirstData["Name"].ToString();
                if (this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count > 1)
                {
                    foreach (EmsOrDrug drug in this.EmsHeadDO.Emsdrugs.EmsOrDrugList)
                    {
                        if (strSrv == drug.Name_srv)
                        {
                            e.Cancel = true;
                            e.Message = strSrv + "： 已经添加";
                        }
                    }
                    //this.ShowInfo("存在相同的服务！");
                    //drugNew.Name_srv = null;
                    //drugNew.Id_srv = null;
                    //return;
                }
            }
        }

        void xapFormControl1_RefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                e.WherePart = string.Format(" Sd_srvtp like '0103%'");

            }
            else if (e.BindingFieldName.Equals("Name_mm"))
            {
                EmsOrDrug drugDo = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
                if (drugDo.Id_srv == null || drugDo.Id_srv == "")
                {
                    e.Cancel = true;
                    return;
                }
                e.WherePart = string.Format("BD_MM.id_mm in ({0})", cof.GetSrvMmStr(this.EmsHeadDO, drugDo.Id_srv));
            }
            else if (e.BindingFieldName.Equals("Name_route"))
            {
                e.WherePart = string.Format("id_route in ({0})", new GetSrvVsRouteImp().GetHerbRounte());
            }
            else if (e.BindingFieldName.Equals("Name_freq"))
            {//排除 临时 备用
                e.WherePart = string.Format("id_freq not in ({0}) and FG_ACTIVE='Y'", "'0001AA1000000006BR2U','0001AA10000000079NW4'");
            }
            else if (e.BindingFieldName.Equals("Name_boildes"))
            {
                //if (this.EmsHeadDO.Emsdrugs.Id_boil != null)
                //{
                //    e.WherePart = string.Format("id_boil ='{0}' and ds=0", this.EmsHeadDO.Emsdrugs.Id_boil);
                //}
            }
            else if (e.BindingFieldName.Equals("Name_routedes"))
            {
                e.WherePart = string.Format("BD_ROUTE_DES.FG_ENTP_IP='Y'");
            }

        }
        void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {
            this.xapFormControl1.DataChanged -= xapFormControl1_DataChanged;
            switch (e.PropName)//计算结束日期
            {
                case "Dt_begin_ui":
                    EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    string info = cof.CompareWithAdmission(this.EmsHeadDO.PatInfo.Id_ent, this.EmsHeadDO.Emsdrugs.Dt_begin_ui);
                    if (info != "")
                    {
                        this.ShowInfo(info);
                        EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                        this.xapFormControl1.DataChanged -= xapFormControl1_DataChanged;
                        return;
                    }
                    DateTime dtb = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    try
                    {
                        //限制结束日期为可拆分的最大天数
                        int maxDays = this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS);
                        TimerComboBoxMaxAndMin.GetInstance().setMaxTime(xapFormControl1, this.Context, "drugsUse", "dt_end_ui", ((DateTime)this.EmsHeadDO.Emsdrugs.Dt_begin_ui).AddDays(maxDays));
                        TimerComboBoxMaxAndMin.GetInstance().setMinTime(xapFormControl1, this.Context, "drugsUse", "dt_end_ui", (DateTime)this.EmsHeadDO.Emsdrugs.Dt_begin_ui);
                    }
                    catch //(Exception ex)
                    { }
                    if (this.EmsHeadDO.Emsdrugs.Dt_end_ui == null) return;
                    DateTime dte = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_end_ui;
                    if (dtb.CompareTo(dte) > 0)
                    {

                        // e.Cancel = true;
                        this.EmsHeadDO.Emsdrugs.Dt_end_ui = dtb;
                        this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                        this.xapFormControl1.DataChanged -= xapFormControl1_DataChanged;
                        return;
                    }

                    int? useDay = cof.GetUseDays(dtb, this.EmsHeadDO.Emsdrugs.Dt_end_ui);
                    if (this.EmsHeadDO.Emsdrugs.Use_days != useDay)
                    {
                        this.EmsHeadDO.Emsdrugs.Use_days = useDay;
                    }
                    EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    break;
                case "Use_days"://医嘱天数
                    if (uday == "-1")
                    {
                        uday = "";
                        this.xapFormControl1.DataChanged -= xapFormControl1_DataChanged;
                        return;
                    }
                    if (this.EmsHeadDO.Emsdrugs.Use_days == null)
                    {
                        this.EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                        this.xapFormControl1.DataChanged -= xapFormControl1_DataChanged;
                        return;
                    }


                    if (this.EmsHeadDO.Emsdrugs.Use_days == 0)
                    {
                        this.EmsHeadDO.Emsdrugs.Dt_end_ui = this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
                        this.xapFormControl1.DataChanged -= xapFormControl1_DataChanged;
                        return;
                    }
                    else if (this.EmsHeadDO.Emsdrugs.Use_days == -1 && this.EmsHeadDO.Emsdrugs.Dt_end_ui == null)
                    {
                        XLabelBaseUserRender tmpUserRender2 = sender as XLabelBaseUserRender;
                        if (tmpUserRender2 != null)
                        {
                            uday = "-1";
                            tmpUserRender2.ValueText = "";
                        }
                        this.xapFormControl1.DataChanged -= xapFormControl1_DataChanged;
                        //this.EmsHeadDO.Emsdrugs.Use_days = null;
                        return;
                    }
                    //else if (this.EmsHeadDO.Emsdrugs.Use_days == -1)
                    //{
                    //    this.EmsHeadDO.Emsdrugs.Use_days = null;
                    //    this.EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                    //    return;
                    //}
                    else if (this.EmsHeadDO.Emsdrugs.Use_days > 0)
                    {
                        this.EmsHeadDO.Emsdrugs.Dt_end_ui = cof.GetEndTime(this.EmsHeadDO.Emsdrugs.Dt_begin_ui, this.EmsHeadDO.Emsdrugs.Use_days.Value);

                    }


                    //取模
                    int? m = this.EmsHeadDO.Emsdrugs.Use_days % 7;
                    //判断周期类型错误
                    //if (this.EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
                    if ((this.EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 || this.EmsHeadDO.Emsdrugs.Name_freq.IndexOf("星期") > 0) && m % 7 != 0)
                    {
                        if (m == 0 || m == 6)
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
                    //cof.GetDrugUseTotalCount(this.EmsHeadDO);
                    uday = "";
                    EmsHeadDO.Days_or = EmsHeadDO.Emsdrugs.Use_days;

                    //this.EmsHeadDO.Emsdrugs.Dt_end_ui = cof.GetEndTime(this.EmsHeadDO.Emsdrugs.Dt_begin_ui, this.EmsHeadDO.Emsdrugs.Use_days.Value);
                    break;
                case "Dt_end_ui"://计算医嘱天数
                    this.EmsHeadDO.Emsdrugs.Use_days = cof.GetUseDays(this.EmsHeadDO.Emsdrugs.Dt_begin_ui, this.EmsHeadDO.Emsdrugs.Dt_end_ui);
                    EmsOrDrug drug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
                    //drug.Quan_cur = cof.GetDrugUseTotalCount(this.EmsHeadDO);
                    EmsHeadDO.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_end_ui;
                    break;
                case "Id_freq"://计算执行时刻1

                    //  先于 OnRefResult(object sender, RefResultEventArgs e)执行，会出现  这个地方获取的id 是上次的 而不是最新的
                    break;
                case "Fg_long":
                    //if (e.Input != null)
                    //{
                    //    if (e.Input.ToString() == "false")
                    //    {
                    //        getControlByName("drugsUse", "Use_days").Enabled = false;//临时 医嘱天数 不可输入
                    //    }
                    //    else
                    //    {
                    //        getControlByName("drugsUse", "Use_days").Enabled = true;
                    //    }    
                    //}

                    break;
                case "Fg_self":
                    this.EmsHeadDO.Emsdrugs.Fg_outp = !this.EmsHeadDO.Emsdrugs.Fg_self;
                    break;
                case "Fg_outp":
                    if (this.EmsHeadDO.Emsdrugs.Fg_outp == true)
                    {
                        this.EmsHeadDO.Emsdrugs.Fg_self = !this.EmsHeadDO.Emsdrugs.Fg_outp;
                        //ctlTotal.Enabled = true;
                        //gv.DataTable.Columns["Quan_cur"].ReadOnly = false;
                    }
                    else
                    {
                        //gv.DataTable.Columns["Quan_cur"].ReadOnly = true;
                        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Quan_cur = null;
                        //ctlTotal.Enabled = false;
                    }
                    break;
                case "Fg_treat":
                    this.EmsHeadDO.Emsdrugs.Fg_propc = !this.EmsHeadDO.Emsdrugs.Fg_treat;
                    break;
                case "Fg_propc":
                    this.EmsHeadDO.Emsdrugs.Fg_treat = !this.EmsHeadDO.Emsdrugs.Fg_propc;
                    break;
                case "Orders":
                    if (this.EmsHeadDO.Emsdrugs.Orders != null)
                    {
                        ((XNumbericUpDown)((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "orders_boil")).UserRender).MaxValue = (double)this.EmsHeadDO.Emsdrugs.Orders;
                        this.EmsHeadDO.Emsdrugs.Orders_boil = this.EmsHeadDO.Emsdrugs.Orders;
                    }
                    calQuanCur(this.EmsHeadDO.Emsdrugs.EmsOrDrugList);
                    break;
                case "Name_freq":
                    if (e.Input != null && (e.Input.ToString().Contains("周") || e.Input.ToString().Contains("星期")))
                    {
                        //取模
                        m = this.EmsHeadDO.Emsdrugs.Use_days % 7;
                        if (m == 0 || m == 6)
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
                    break;
                case "Quan_med":
                    calQuanCur(this.EmsHeadDO.Emsdrugs.EmsOrDrugList);
                    break;
                default:
                    break;
            }
            if (!userEditFlag && !e.PropName.Equals("Note_or"))
            {
                cof.SetNoteOr(this.EmsHeadDO);
            }
            this.xapFormControl1.DataChanged += xapFormControl1_DataChanged;
        }

        void xapFormControl1_GotFocus(object sender, EventArgs e)
        {
            
        }

        void xapFormControl1_LostFocus(object sender, EventArgs e)
        {
            //throw new NotImplementedException();
        }

        void her_SelectedClick(object sender, EventArgs e)
        {
            selectDrugDo = her.GetFouceDo<EmsOrDrug>();
            gv.DataTable.DataSource = new BindingList<EmsOrDrug>() { selectDrugDo };
        }
        
        void dt_end_MouseClick(object sender, MouseEventArgs e)
        {
            if (this.EmsHeadDO.Emsdrugs.Dt_end_ui == null)
            {
                UserRender ur_end = xapFormControl1.GetUserRender("drugsUse", "dt_end_ui");
                XCalendarTimerComboBox dt_end = ur_end.Renders[0] as XCalendarTimerComboBox;
                dt_end.TodayDateTime = this.NowTime();
            }
        }

        void dt_begin_MouseClick(object sender, MouseEventArgs e)
        {
            if (this.EmsHeadDO.Emsdrugs.Dt_begin_ui == null)
            {
                UserRender ur_begin = xapFormControl1.GetUserRender("drugsUse", "dt_begin_ui");
                XCalendarTimerComboBox dt_begin = ur_begin.Renders[0] as XCalendarTimerComboBox;
                dt_begin.TodayDateTime = this.NowTime();
            }
        }       

        void OrderHerbsView_LostFocus(object sender, EventArgs e)
        {
            if (focusText != ((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "note_or")).ValueText)
            {
                this.userEditFlag = true;
            }
        }

        void OrderHerbsView_GotFocus(object sender, EventArgs e)
        { 
            focusText = ((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "note_or")).ValueText;
        }
        
        void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            desView.ShowDrugDes(this.EmsHeadDO.Emsdrugs.EmsOrDrugList);
        }

        void btnAdd_MouseClick(object sender, MouseEventArgs e)
        {
            EmsOrDrug drug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList.FirstOrDefault<EmsOrDrug>(p => string.IsNullOrEmpty(p.Id_srv) && string.IsNullOrEmpty(p.Sd_srvtp));
            if (drug == null)
            {
                drug = new EmsOrDrug();
                this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Add(drug);
            }
            her.FocusIndex = this.EmsHeadDO.Emsdrugs.EmsOrDrugList.IndexOf(drug);
            gv.DataTable.DataSource = new BindingList<EmsOrDrug>() { drug };
            xap.cli.sdk.controls.DataView.XDataRow row = gv.DataTable.Rows.DataSourceRow[drug];
            xap.cli.sdk.controls.DataView.XCellRender cell = row.ColumnCellDict["Name_srv"];
            gv.ShowEditor(cell); 
        }
        //草药删除
        void btnDelete_MouseClick(object sender, MouseEventArgs e)
        {
            XDataRow row = gv.DataTable.GetFirstRow();
            if (row != null) {
                EmsOrDrug delDo = row.DataSource as EmsOrDrug;
                //删除前应该提示一下吧？
                if (delDo != null)
                {
                    cof.DeleteOrDrug(this.EmsHeadDO, delDo);
                    gv.DataTable.DataSource = null;
                } 
            }
            else
            {
                this.ShowInfo("请选择要删除的草药");
            }
        }

        void gv_MouseClick(object sender, MouseEventArgs e)
        {

            // 待修改
            //if (gv.GetFocusedRow().ClickCell.FieldName == "Name_mm")
            //{
                //string id_srv = (gv.GetFocusedRow().RowDataSource as EmsOrDrug).Id_srv;//拿到 点击的药品对应服务的id_srv
                //根据服务id 取到 服务关联的药品 ，



                //if (this.EmsHeadDO.Emsdrugs.EmsOrDrug.Count > 1)//如果只有一条
                //{
                //    MmForm mmref = new MmForm(this.EmsHeadDO.Emsdrugs.EmsOrDrug);
                //    Point formPoint = Control.MousePosition;
                //    mmref.Local = formPoint;
                //    mmref.ShowDialog();
                //    if (mmref.DialogResult == DialogResult.OK)
                //    {
                //        //这样做是有缺陷的 原数据有 主键 sv  替换后的 数据是没有主键 sv 的 就不对了
                //        //this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Clear();
                //        //this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Add(mmref.drugmm);
                //        string id_mm = mmref.drugmm.Id_mm;
                //        string id_dep_phy = this.EmsHeadDO.Emsdrugs.Id_dep;
                //        GetStockReqDTO reqDto = new GetStockReqDTO();
                //        reqDto.Id_dep = id_dep_phy;
                //        reqDto.Id_mm = id_mm;
                //        reqDto.Req_unit_id = mmref.drugmm.Id_unit_med;
                //        GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
                //        reqDtoArr[0] = reqDto;
                //        MaterialStockDTO[] materialArr = cof.getMaterialStocksCount(reqDtoArr);
                //        if (materialArr != null && materialArr.Length > 0)
                //        {
                //            MaterialStockDTO material = materialArr[0];
                //            if (material != null && material.Quan_stock > 0)
                //            {
                //                //正确的做法  只对 关键值进行替换
                //                EmsOrDrug orDrug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[gv.FocusedRowHandle];
                //                orDrug.Name_mm = mmref.drugmm.Name_mm;//药品名称
                //                orDrug.Spec_mm = mmref.drugmm.Spec_mm;//规格
                //                orDrug.Name_heath = mmref.drugmm.Name_heath;//医保类型
                //                orDrug.Limit = mmref.drugmm.Limit;//限制报销条件
                //                orDrug.Price = mmref.drugmm.Price;//参考价格
                //            }
                //            else
                //            {
                //                this.ShowInfo("该药品在" + this.EmsHeadDO.Emsdrugs.Name_dep + "库存为零，请重新选择药品或更改执行科室！");
                //                return;
                //            }
                //        }
                //    }
                //}


            //}
        }
        #endregion

        #region 辅助处理函数

        private void GetMpTimes(string id_freq)
        {
            GetDoseDrugData(id_freq);
            cof.GetWorkTime(id_freq);
            //string woketime, firstwoketime;
            //woketime = firstwoketime = "";
            //int firstday = 0;
            //cof.GetWorkTime(this.EmsHeadDO.Emsdrugs.EmsOrDoseDrug, out woketime, out firstday, out firstwoketime);
            //this.EmsHeadDO.Emsdrugs.Work_time = woketime;//首次执行时刻  
            //this.EmsHeadDO.Emsdrugs.Quan_firday_mp = firstday;//首次执行次数
            //this.EmsHeadDO.Emsdrugs.First_time = firstwoketime;//执行时刻
        }

        private void xQOnRefFilter(object sender, RefActivatingEventArgs e)
        {

            if (e.BindingFieldName.Equals("Name_srv"))
            {
                e.WherePart = string.Format(" Sd_srvtp like '0103%'");

            }

            if (e.BindingFieldName.Equals("Name_mm"))
            {
                EmsOrDrug drugDo = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
                if (drugDo.Id_srv == null) drugDo.Id_srv = "xxxx";
                e.WherePart = string.Format("id_mm in ({0})", cof.GetSrvMmStr(this.EmsHeadDO, drugDo.Id_srv));
            }

            if (e.BindingFieldName.Equals("Name_dep"))
            {
                if (this.EmsHeadDO.Emsdrugs.Str_mp_dep_ids != null && this.EmsHeadDO.Emsdrugs.Str_mp_dep_ids != "")
                    e.WherePart = string.Format(" id_dep in({0})", this.EmsHeadDO.Emsdrugs.Str_mp_dep_ids);
                //e.RefParams.AddParam("Dep", this.EmsHeadDO.Emsdrugs.Str_mp_dep_ids);
            }

            //if (e.BindingFieldName.Equals("Total_count_unit"))//计量单位
            //{
            //    if (drug.Str_unit_pkg_ids != null && drug.Str_unit_pkg_ids != "")
            //        e.WherePart = string.Format("id_measdoc in ({0})", drug.Str_unit_pkg_ids);
            //    //e.RefParams.AddParam("Dis", drug.Str_unit_pkg_ids);
            //}
        }

        /// <summary>
        /// Drugs 表单药品剂量数据写到药品do
        /// </summary>
        /// Author:admin
        /// Date:2015-10-21
        private void DrugWriteData()
        {
            //if (this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count == 0) return;
            //EmsOrDrug orDrug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
            //orDrug.Name_mm = this.EmsHeadDO.Emsdrugs.Name_mm;//药品名称
            //orDrug.Spec_mm = this.EmsHeadDO.Emsdrugs.Spec_mm;//规格
            //orDrug.Name_heath = this.EmsHeadDO.Emsdrugs.Name_heath;//医保类型
            //orDrug.Limit = this.EmsHeadDO.Emsdrugs.Limit;//限制报销条件
            //orDrug.Price = this.EmsHeadDO.Emsdrugs.Price;//参考价格
            //if (this.EmsHeadDO.Emsdrugs.Total_count != null)
            //    orDrug.Quan_cur = (int)this.EmsHeadDO.Emsdrugs.Total_count;//总量
            //orDrug.Id_unit_base = this.EmsHeadDO.Emsdrugs.Id_unit_base;
            //orDrug.Name_unit_base = this.EmsHeadDO.Emsdrugs.Name_unit_base;
            //orDrug.Id_unit_med = this.EmsHeadDO.Emsdrugs.Id_unit_med;
            //orDrug.Name_unit_med = this.EmsHeadDO.Emsdrugs.Name_unit_med;
            //orDrug.Id_pgku_cur = this.EmsHeadDO.Emsdrugs.Id_total_count_unit;//基本包装单位，如：片
            //orDrug.Name_pgku_cur = this.EmsHeadDO.Emsdrugs.Total_count_unit;
            //if (this.EmsHeadDO.Emsdrugs.Id_total_count_unit == null)
            //{
            //    //orDrug.Id_pgku_cur =  this.EmsHeadDO.Emsdrugs.Id_unit_med ;
            //    //orDrug.Name_pgku_cur = this.EmsHeadDO.Emsdrugs.Name_unit_base;
            //}

            //orDrug.Quan_base = this.EmsHeadDO.Emsdrugs.Quan_base;
            //orDrug.Quan_med = this.EmsHeadDO.Emsdrugs.Quan_med;

            foreach (EmsOrDrug p in this.EmsHeadDO.Emsdrugs.EmsOrDrugList)
            {
                if (p.Quan_med != null && this.EmsHeadDO.Emsdrugs.Orders != null)
                {
                    p.Quan_cur = (int)(p.Quan_med.ToDouble()) * this.EmsHeadDO.Emsdrugs.Orders.Value;

                }
            }

            //this.EmsHeadDO.Emsdrugs.EmsOrDrugList.ToList().ForEach(p =>
            //{
            //    if (p.Quan_med != null && this.EmsHeadDO.Emsdrugs.Orders != null)
            //    {
            //        p.Quan_cur = (int)(p.Quan_med.Value) * this.EmsHeadDO.Emsdrugs.Orders.Value;
            //    }
            //});

        }
        
        /// <summary>
        /// 根据频次获取变动用药的 日期集合
        /// </summary>
        /// <param name="id_freq">The id_freq.</param>
        /// Author:admin
        /// Date:2015-10-08
        private void GetDoseDrugData(string id_freq)
        {
            this.EmsHeadDO.Emsdrugs.EmsOrDoseDrug = cof.GetFreqVsTimes(id_freq, this.EmsHeadDO.Emsdrugs.Id_orsrv, this.EmsHeadDO.Emsdrugs.Id_or);

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
            if (dic.Count == 0) return null;
            if (dic.Keys.Contains(tableKey + '_' + name))
            {
                return dic[tableKey + '_' + name] as XLabelBaseUserRender;
            }
            return null;
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
        }
        /// <summary>
        /// 计算草药总量
        /// </summary>
        /// <param name="drugList"></param>
        private void calQuanCur(XapDataList<EmsOrDrug> drugList)
        {
            if (drugList == null) return;
            foreach(EmsOrDrug drug in drugList){
                drug.Quan_cur = CalQuantumUtil.GetInstance().getMMQuantum(drug.Sd_mupkgutp, drug.Quan_med, drug.Factor_mb, drug.Factor_cb, this.EmsHeadDO.Emsdrugs.Orders);
            }
        }
        #endregion
    }
}

