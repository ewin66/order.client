using System;
using System.Linq;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.render;
using xap.rui.engine;
using xap.cli.sdk.controls.tabControl;
using xap.rui.control.forms.model;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.ciorder.viewmodel;
using xap.rui.control.forms.control;
using iih.ci.ord.ciorder.utils;
using xap.rui.control.refcontrol.data;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.ciorder.cards.extend;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.Validate;
using xap.rui.appfw;
using xap.cli.sdk.render.Items;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.bd.mm.meterial.d;
using iih.bd.mm.meterial.i;
using xap.mw.serviceframework;
using iih.bd.srv.routedosage.d;
using iih.mm.itf.material.d;
using xap.mw.core.data;
using iih.ci.iih.ci.ord.i;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// iv药品 医疗单
    /// </summary>
    /// Author:admin
    /// Date:2015-10-10
    public partial class OrderInfusionView : CiorderBaseControl
    {
        public OrderInfusionView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderInfusionView_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            this.xapFormControl1.RefResult += this.OnRefResult;
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
            SheetName = "注射医疗单";
        }




        #region 变量定义区域
        XapFormGridControl gv, gv_change;// 药品商品表，变动用药
        Dictionary<string, UserRender> dic = new Dictionary<string, UserRender>();//界面控件集合
        private EmsOrDrug emsOrDrug = new EmsOrDrug();
        OrderDrugDesView desView = new OrderDrugDesView() { Dock = DockStyle.Fill };
        EmsOrDrug drug = new EmsOrDrug();
        private string[] exctimes;//首日执行时间
        private string[] adjustHeightIds = new string[] { "dt_begin_ui", "Use_days", "dt_end_ui", "quan_firday_mp", "work_time", "name_dep", "fg_self", "fg_outp", "fg_propc", "fg_treat", "note_or", "ci", "day" };
        //记录单位名称
        Dictionary<string, string> mapUnit = new Dictionary<string, string>();
        xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_fail;
        //UserRender ctlTotal;    
        //OrderSaveViewModel model = new viewmodel.OrderSaveViewModel();
        #endregion

        #region 构造函数区域

        #endregion

        #region 公开属性区域

        #endregion
        #region 事件发送区

        #endregion
        //public void ActiveRef()
        //{
        //    XapRefConfig config = new XapRefConfig("bd_usg");

        //    XapRefActiveParam param = new XapRefActiveParam();
        //    param.BindingFieldName = "_adminarea";

        //    //点击按钮时激活参照
        //    this.XapRefManager.ActivateRefControl(config, param);

        //}

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
            //foreach (EmsDrugItemDO item in this.EmsHeadDO.Emsdrugitems)
            //{
            //    listDrug.Add(item);
            //}

            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderInfusionView;// "20150928105747331RTL";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.EmsHeadDO.Emsdrugs;
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);
        }


        public override void OnRefreshData(ciordems.d.EmsUIDTO headDo, object e)
        {

            if (headDo != null)
            {
                this.EmsHeadDO = headDo;
            }

            if (this.Created)
            {
                this.LoadData();
            }
            DrugReadData();
            
        }
        public override Validate.IValidate GetOrdValidate()
        {
            return new OrderInfusionValidate();
        }


        #endregion

        #region 内部事件区域
        void OrderInfusionView_Load(object sender, System.EventArgs e)
        {
            OnInit();
        }

        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            //备用条件和失效日期隐藏
            cof.getControlByName(xapFormControl1, "drugsUse", "bak_des").Visible = false;
            cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").Visible = false; 
            cof.adjustHeight(this.xapFormControl1, "drugsUse", adjustHeightIds, -58);
            //首日最大执行次数
            int? freqct = this.EmsHeadDO.Emsdrugs.Freqct;
            int numgreqct = 0;
            if (freqct != null)
            {
                numgreqct = (int)freqct;
            }
            XLabelBaseUserRender tmpUserRender = this.xapFormControl1.GetUserRender("drugsUse", "quan_firday_mp") as XLabelBaseUserRender;

            XNumbericUpDown numRender = tmpUserRender.UserRender as XNumbericUpDown;
            numRender.MaxValue = (double)numgreqct;
            numRender.MinValue = 0;


            XTabControl tabControl = new XTabControl();
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            dic = tabs[0].Pages[0].DicUserRenders;

            gv = xapFormControl1.GetGridView("drug");//药品属性表
            gv.MouseClick += new MouseEventHandler(gv_MouseClick);
            gv.ReadOnly = true;
            UserRender btnDel = this.xapFormControl1.GetUserRender("drugsUse", "del");//删除按钮
            btnDel.MouseClick += new MouseEventHandler(btnDel_MouseClick);

            UserRender btnAdd = this.xapFormControl1.GetUserRender("drugsUse", "btnAdd");//新增按钮
            btnAdd.MouseClick += new MouseEventHandler(btnAdd_MouseClick);
            //UserRender btnOK = xapFormControl1.GetUserRender("drugsUse", "btnSave");//保存
            //btnOK.MouseClick += new MouseEventHandler(btnOK_MouseClick);
            gv_change = xapFormControl1.GetGridView("change");//变动用药

            SetGridPolicy(true);
            gv.ReadOnly = false;
            gv.DataTable.ReadOnly = false;
            //gv.DataTable.Columns["Name_srv"].ReadOnly = true;
            //gv.DataTable.Columns["Name_mm"].ReadOnly = true;
            gv.DataTable.Columns["Quan_cur"].ReadOnly = true;
            gv.DataTable.Columns["Name_unit_sale"].ReadOnly = true;
            //长期医嘱使用天数为空
            if (cof.getControlByName(xapFormControl1, "drugsUse", "fg_long").ValueCode == "True" && this.EmsHeadDO.IsNEW)
            {
                this.EmsHeadDO.Emsdrugs.Use_days = null;
            }
            //cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").Enabled = false;

            //----------药品说明----------------------
            XTabControl tabControl1 = tabs[0].tabContrl;
            XTabPage xtab = tabControl1.XTabPages[1];
            tabControl1.SelectedIndexChanged += new XTabControl.selectedIndexChanged(tabControl1_SelectedIndexChanged);
            xtab.Controls.Clear();
            xtab.Controls.Add(desView);

            cof.getControlByName(xapFormControl1, "drugsUse", "work_time").LostFocus += new EventHandler(Work_time_LostFocus);
            cof.getControlByName(xapFormControl1, "drugsUse", "dt_fail").LostFocus += new EventHandler(Dt_fail_LostFocus);
            
            //失效日期控件
            UserRender usfail = xapFormControl1.GetUserRender("drugsUse", "dt_fail");
            dt_fail = usfail.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
        }


        void Dt_fail_LostFocus(object sender, EventArgs e)
        {
            XLabelBaseUserRender usfail = sender as XLabelBaseUserRender;
            DateTime? dtfMax =  dt_fail.MaxDate;

            DateTime? dtf = Convert.ToDateTime(usfail.ValueText);

            if (dtf > dtfMax) {
                usfail.ValueText = dt_fail.MaxDate.ToString();
                this.ShowInfo("失效时间不能大于开始时间 " + cof.getSpareTime() + "小时！");
            }
            XLabelBaseUserRender dbt = cof.getControlByName(this.xapFormControl1, "drugsUse", "dt_begin_ui") as XLabelBaseUserRender;
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
                catch //(Exception ex)
                {
                    this.EmsHeadDO.Emsdrugs.Work_time = "";
                    cof.getWorkTime(this.xapFormControl1,exctimes);
                    this.ShowInfo("首次执行时间格式错误!");
                }

            }
        }



        void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            desView.ShowDrugDes(this.EmsHeadDO.Emsdrugs.EmsOrDrugList);
        }



        void btnAdd_MouseClick(object sender, MouseEventArgs e)
        {
            this.EmsHeadDO.Emsdrugs.EmsOrDrugList.AddNew();
        }


        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName == "Name_route")
            {
                e.WherePart = string.Format("id_route in ({0})", new GetSrvVsRouteImp().GetDosageVsRounte("'" + string.Join("','", this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Select(p => p.Id_srv).ToList()) + "'"));
            }
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                e.WherePart = string.Format(" Sd_srvtp in ('010104','010204','010203','010103')");

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

            if (e.BindingFieldName.Equals("Total_count_unit"))//计量单位
            {
                if (emsOrDrug.Str_unit_pkg_ids != null && emsOrDrug.Str_unit_pkg_ids != "")
                    e.WherePart = string.Format("id_measdoc in ({0})", emsOrDrug.Str_unit_pkg_ids);
                //e.RefParams.AddParam("Dis", drug.Str_unit_pkg_ids);
            }
            if (e.BindingFieldName.Equals("Name_unit_sale"))//计量单位
            {
                int focusOrDrug = gv.GetFocusedRow().Index;
                drug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[focusOrDrug];
                if (drug.Str_unit_pkg_ids != null && drug.Str_unit_pkg_ids != "")
                {
                    e.WherePart = string.Format("id_measdoc in ({0})", drug.Str_unit_pkg_ids);
                }
                else
                {
                    e.WherePart = string.Format("id_measdoc in ({0})",drug.Id_unit_sale);
                }
                    
            }
        }

        void btnDel_MouseClick(object sender, MouseEventArgs e)
        {
            EmsOrDrug delDo = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
            if (delDo != null)
            {
                cof.DeleteOrDrug(this.EmsHeadDO, delDo);
            }
        }
        void gv_MouseClick(object sender, MouseEventArgs e)
        {
            //if (gv.FocusedRowHandle < 0) return;

            emsOrDrug = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
           
            // 待修改
            if (gv.GetFocusedRow().ClickCell.FieldName == "Name_mm")
            {
                string id_srv = emsOrDrug.Id_srv;//拿到 点击的药品对应服务的id_srv
                if (this.EmsHeadDO.Emsdrugs.EmsOrDrug.Count > 1)//如果只有一条
                {
                    List<EmsOrDrug> list = this.EmsHeadDO.Emsdrugs.EmsOrDrug.ToList().Where<EmsOrDrug>(p => p.Id_srv == id_srv).ToList();
                    MmForm mmref = new MmForm(cof.ConvertDataSouse<EmsOrDrug>(list), this.EmsHeadDO.Emsdrugs);
                    Point formPoint = Control.MousePosition;
                    mmref.Local = formPoint;
                    mmref.TopMost = true;
                    mmref.ShowDialog();
                    if (mmref.DialogResult == DialogResult.OK)
                    {
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
                                    //下面是正确的做法  只对 关键值进行替换
                                    EmsOrDrug orDrug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[gv.FocusedRowHandle];
                                    orDrug.Name_mm = mmref.drugmm.Name_mm;//药品名称
                                    orDrug.Spec_mm = mmref.drugmm.Spec_mm;//规格
                                    orDrug.Name_hp = mmref.drugmm.Name_hp;//医保类型
                                    orDrug.Limit = mmref.drugmm.Limit;//限制报销条件
                                    orDrug.Price = mmref.drugmm.Price;//参考价格
                                }
                                else
                                {
                                    this.ShowInfo("该药品在" + this.EmsHeadDO.Emsdrugs.Name_dep + "库存为零，请重新选择药品或更改执行科室！");
                                    return;
                                }
                            }
                        }
                        catch //(Exception ex)
                        { 
                            
                        }
                    }
                }
            }


            //}
        }


        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            xapFormControl1.SetTabPageEnabled("drugsUse", !IsReadOnly);
            gv.DataTable.DataSource = this.EmsHeadDO.Emsdrugs.EmsOrDrugList;
            mapUnit = new Dictionary<string, string>();
            //记录单位名称
            mapUnit.Add(this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_srv, this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Name_unit_sale);
            if (this.EmsHeadDO.IsNEW)
            {
                //获取执行时刻，和首次执行次数
                GetMpTimes(this.EmsHeadDO.Emsdrugs.Id_freq);
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
                if (exctimes == null) exctimes = new string[] { };
                cof.setMpWorkTimesOnEdit(this.EmsHeadDO, exctimes);
                XLabelBaseUserRender tmpUserRender = this.xapFormControl1.GetUserRender("drugsUse", "quan_firday_mp") as XLabelBaseUserRender;
                XNumbericUpDown numRender = tmpUserRender.UserRender as XNumbericUpDown;
                if (this.EmsHeadDO.Emsdrugs.Quan_firday_mp != null)
                {
                    numRender.MaxValue = (double)this.EmsHeadDO.Emsdrugs.Quan_firday_mp;
                }
                numRender.MinValue = 0;
            }
            //	治疗用药、预防用药：只有抗生素类型的药品（BD_SRV_DRUG.fg_anti抗菌药物标志），才显示这两个控件。这两个选项框互斥。
            if (!cof.IsAntDrug(this.EmsHeadDO.Emsdrugs.Id_srv))
            {
                //cof.getControlByName(xapFormControl1,"drugsUse", "fg_treat").Visible = false;//治疗用药
                cof.getControlByName(xapFormControl1,"drugsUse", "fg_propc").Visible = false;//预防用药
            }
            if(this.EmsHeadDO.Emsdrugs.Id_route==null){

                RouteDosageRefDO[] routeRefs = new GetSrvVsRouteImp().GetDosageVsRountes("'" + string.Join("','", this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Select(p => p.Id_srv).ToList()) + "'");
                this.EmsHeadDO.Emsdrugs.Id_route = routeRefs[0].Id_route;
                this.EmsHeadDO.Emsdrugs.Name_route = routeRefs[0].Route_name;
            }else if(this.EmsHeadDO.Emsdrugs.Name_route==null){
                String name="";
                RouteDosageRefDO[] routeRefs = new GetSrvVsRouteImp().GetDosageVsRountes("'" + string.Join("','", this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Select(p => p.Id_srv).ToList()) + "'");
                
                for(int i=0;i<routeRefs.Length;i++){
                    if (this.EmsHeadDO.Emsdrugs.Id_route == routeRefs[i].Id_route) {
                        name = routeRefs[i].Route_name;
                    }
                }
                if (name == "" && routeRefs.Length > 0) {
                    name = routeRefs[0].Route_name;
                }
                this.EmsHeadDO.Emsdrugs.Name_route = name;
            }


            //备用药结束时间
           
            dt_fail.MinDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddDays(-1);
            dt_fail.MaxDate = cof.GetServerDataTime().AddHours(this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime));
            this.EmsHeadDO.Emsdrugs.EmsOrDeleteDrugList = new XapDataList<EmsOrDrug>() { };
            cof.setDrugConStateAfterFilled(this.EmsHeadDO.Emsdrugs.Id_freq, this.adjustHeightIds, this.xapFormControl1);
            cof.setGridColumnEdit(gv, this.EmsHeadDO);

            UserRender name_route = xapFormControl1.GetUserRender("drugsUse", "name_route");
            name_route.Focus();
        }
        OrderSrvDoseViewModel drugChangeModel = new OrderSrvDoseViewModel();




        //频次
        protected override void OnRefResult(object sender, RefResultEventArgs e)
        {
            RefDataCollection data = e.RefResultSet;
            if (e.BindingFieldName.Equals("Name_srv"))
            {

                string id_srv = data.FirstData["Id_srv"] as string;
                int drugListCount = this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count;
                for (int i = 0; i < drugListCount-1; i++) {
                    EmsOrDrug tmpEmsOrDrug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i];
                    if (tmpEmsOrDrug.Id_srv == id_srv) {
                        this.ShowInfo("服务重复！");
                        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count-1].Id_srv = "";
                        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count - 1].Name_srv = "";
                        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count - 1].Spec_mm = "";
                        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count - 1].Quan_med = null;
                        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count - 1].Name_unit_med = "";
                        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count - 1].Quan_cur = null;
                        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count - 1].Name_unit_sale = "";
                        //btnDel_MouseClick(null,null);
                        //this.EmsHeadDO.Emsdrugs.EmsOrDrugList.AddNew();
                        return;
                    }
                }
                    //.EmsOrDrugList[focusOrDrug];

                XapDataList<EmsOrDrug> drugs = cof.GetSrvMm(this.EmsHeadDO, id_srv,this.EmsHeadDO.PatInfo.Code_entp);
                if (drugs.Count > 0)
                {
                    EmsOrDrug drugRef = drugs.FirstOrDefault();
                    EmsOrDrug drugNew = xapFormControl1.GetFocused<EmsOrDrug>("drug");
                    cof.CopyTo(drugRef, drugNew, "Id_srv", "Name_srv");
                }
                if (this.EmsHeadDO.Emsdrugs.Fg_outp == true)
                {
                    this.manageUnitName("out");
                }
                else {
                    this.manageUnitName("in");                
                }
                cof.GetDrugTotal(this.EmsHeadDO);
            }
            else if (e.BindingFieldName.Equals("Name_unit_sale"))
            {
                cof.GetDrugTotal(this.EmsHeadDO);
            }
            if (e.BindingFieldName == "Name_freq")
            {
                //RefDataCollection data = e.RefResultSet;
                string id_freq = data.FirstData["Id_freq"] as string;//获取字段值
                this.EmsHeadDO.Emsdrugs.Sd_frequnitct = data.FirstData["Sd_frequnitct"] as string;
                this.EmsHeadDO.Emsdrugs.Freqct = null;
                if (data.FirstData["Freqct"].ToString() != "")
                    this.EmsHeadDO.Emsdrugs.Freqct = int.Parse(data.FirstData["Freqct"].ToString());
                this.EmsHeadDO.Emsdrugs.Fg_long = data.FirstData["Fg_long"].ToString() == "Y" ? true : false;
                GetMpTimes(this.EmsHeadDO.Emsdrugs.Id_freq);
                if (cof.getControlByName(xapFormControl1,"drugsUse", "fg_outp").ValueText == "true")
                {
                    cof.GetDrugTotal(this.EmsHeadDO);
                }
                if (data.FirstData["Fg_prnor"].ToString() == "Y")// 备用医嘱 true 并且 长临为 临时
                {
                    XLabelBaseUserRender tmpRender = cof.getControlByName(xapFormControl1,"drugsUse", "fg_long");
                    int h = 0;//高度变动值
                    if (tmpRender.ValueCode == "False")
                    {
                        if (cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Visible == false)
                        {
                            h += 29;
                        }
                        cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Visible = true;//临时医嘱失效日期  

                        this.EmsHeadDO.Emsdrugs.Dt_fail = cof.GetSpareEndTime(this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value);
                        dt_fail.MinDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddDays(-1);
                        dt_fail.MaxDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddHours(this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime));
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
                    cof.getControlByName(xapFormControl1,"drugsUse", "bak_des").Visible = true;
                    cof.adjustHeight(this.xapFormControl1, "drugsUse", adjustHeightIds, h);
                    this.xapFormControl1.Refresh();

                }
                else
                {
                    int h = 0;
                    if (cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Visible == true)
                    {
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

                //可将下面放到算法里
                if (this.EmsHeadDO.Emsdrugs.Fg_pmor.Value && !this.EmsHeadDO.Emsdrugs.Fg_long.Value)// 临时医嘱 true 并且 长临为 临时
                {
                    cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Enabled = true;//临时医嘱失效日期
                    this.EmsHeadDO.Emsdrugs.Dt_fail = cof.GetSpareEndTime(this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value);

                }
                else
                {
                    cof.getControlByName(xapFormControl1,"drugsUse", "dt_fail").Enabled = false;//临时医嘱失效日期
                    this.EmsHeadDO.Emsdrugs.Dt_fail = null;
                }
                //获取总量  

                if (data.FirstData["Fg_long_edit"].ToString() == "Y")
                {
                    cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").Enabled = true;
                }
                else
                {
                    cof.getControlByName(xapFormControl1,"drugsUse", "fg_long").Enabled = false;
                }

                if (this.EmsHeadDO.Emsdrugs.Fg_long == false)
                { //如果是临时的 使用天数和结束日期置灰
                    cof.getControlByName(xapFormControl1,"drugsUse", "Use_days").Enabled = false;
                    cof.getControlByName(xapFormControl1,"drugsUse", "dt_end_ui").Enabled = false;
                }
                else {
                    cof.getControlByName(xapFormControl1,"drugsUse", "Use_days").Enabled = true;
                    cof.getControlByName(xapFormControl1,"drugsUse", "dt_end_ui").Enabled = true;
                }

            }
        }
        void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {
            switch (e.PropName)//计算结束日期
            {
                case "Dt_begin_ui":
                    DateTime adm = CommonExtentions.NowTime(this);//TODO: 入院时间
                    string info = cof.CompareWithAdmission(this.EmsHeadDO.PatInfo.Id_ent, this.EmsHeadDO.Emsdrugs.Dt_begin_ui);
                    if (info != "")
                    {
                        this.ShowInfo(info);
                        return;
                    }
                    DateTime dtb = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    

                    int? useDay = cof.GetUseDays(dtb, this.EmsHeadDO.Emsdrugs.Dt_end_ui);
                    if (this.EmsHeadDO.Emsdrugs.Use_days != useDay)
                    {
                        this.EmsHeadDO.Emsdrugs.Use_days = useDay;
                    }
                    if (this.EmsHeadDO.Emsdrugs.Dt_fail != null)
                    {

                        //失效时间
                        this.EmsHeadDO.Emsdrugs.Dt_fail = cof.GetSpareEndTime(this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value);
                        dt_fail.MinDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddDays(-1);
                        dt_fail.MaxDate = this.EmsHeadDO.Emsdrugs.Dt_begin_ui.Value.AddHours(this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime));
                    }

                    if (this.EmsHeadDO.Emsdrugs.Dt_end_ui == null) return;
                    DateTime dte = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_end_ui;
                    if (dtb.CompareTo(dte) > 0)
                    {

                        // e.Cancel = true;
                        this.EmsHeadDO.Emsdrugs.Dt_begin_ui = dte;
                        this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                        return;
                    }
                    break;
                case "Use_days"://医嘱天数
                    if (this.EmsHeadDO.Emsdrugs.Use_days == -1)
                    {
                        this.EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                        this.EmsHeadDO.Emsdrugs.Use_days = null;
                    }
                    else if (this.EmsHeadDO.Emsdrugs.Use_days == 0)
                    {
                        if (this.EmsHeadDO.Emsdrugs.Dt_end_ui != this.EmsHeadDO.Emsdrugs.Dt_begin_ui) {
                            this.EmsHeadDO.Emsdrugs.Dt_end_ui = this.EmsHeadDO.Emsdrugs.Dt_begin_ui;                        
                        }
                        
                        
                    }
                    else if (this.EmsHeadDO.Emsdrugs.Use_days != null)
                    {
                        DateTime? temDateTime = cof.GetEndTime(this.EmsHeadDO.Emsdrugs.Dt_begin_ui, this.EmsHeadDO.Emsdrugs.Use_days.Value);
                        if(this.EmsHeadDO.Emsdrugs.Dt_end_ui != temDateTime){
                            this.EmsHeadDO.Emsdrugs.Dt_end_ui = temDateTime;
                        }
                        
                        
                    }
                    if (cof.getControlByName(xapFormControl1,"drugsUse", "fg_outp").ValueText == "true")
                    {
                        cof.GetDrugTotal(this.EmsHeadDO);
                    }
                    //取模
                    int? m = this.EmsHeadDO.Emsdrugs.Use_days % 7;
                    if ((this.EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 || this.EmsHeadDO.Emsdrugs.Name_freq.IndexOf("星期") > 0) && m % 7 != 0)
                    {
                        if (m == 0||m==6)
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
                case "Dt_end_ui"://计算医嘱天数
                    dtb = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_begin_ui;
                    if (this.EmsHeadDO.Emsdrugs.Dt_end_ui == null) return;
                    dte = (DateTime)this.EmsHeadDO.Emsdrugs.Dt_end_ui; 
                    if (dtb.CompareTo(dte) > 0)
                    {                       
                        this.EmsHeadDO.Emsdrugs.Dt_end_ui = dtb;
                        this.ShowInfo(OrdParam.MESSAGE_TIEMCHECK);
                        return;
                    }

                    useDay = cof.GetUseDays(dtb, this.EmsHeadDO.Emsdrugs.Dt_end_ui);
                    if (this.EmsHeadDO.Emsdrugs.Use_days != useDay) {
                        this.EmsHeadDO.Emsdrugs.Use_days = useDay;
                    }
                    if (cof.getControlByName(xapFormControl1,"drugsUse", "fg_outp").ValueText == "true")
                    {
                        drug.Quan_cur = cof.GetDrugUseTotalCount(this.EmsHeadDO);
                        cof.GetDrugTotal(this.EmsHeadDO);
                    }
                    break;
                case "Name_freq"://计算执行时刻1
                    if (e.Input != null && e.Input.ToString().Contains("日"))
                    {
                        cof.getControlByName(xapFormControl1,"drugsUse", "quan_firday_mp").Enabled = true;
                        cof.getControlByName(xapFormControl1,"drugsUse", "work_time").Enabled = false;
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
                        else
                        {
                            int? uu = this.EmsHeadDO.Emsdrugs.Use_days / 7;
                            this.EmsHeadDO.Emsdrugs.Use_days = (uu + 1) * 7;
                        }

                    }
                    else
                    {
                        cof.getControlByName(xapFormControl1,"drugsUse", "quan_firday_mp").Enabled = false;
                        cof.getControlByName(xapFormControl1,"drugsUse", "work_time").Enabled = false;
                    }
                    GetMpTimes(this.EmsHeadDO.Emsdrugs.Id_freq);
                    cof.setFreqctMaxMin(this.EmsHeadDO,xapFormControl1);
                    //  先于 OnRefResult(object sender, RefResultEventArgs e)执行，会出现  这个地方获取的id 是上次的 而不是最新的
                    break;
                case "Id_freq"://计算执行时刻1

                    //  先于 OnRefResult(object sender, RefResultEventArgs e)执行，会出现  这个地方获取的id 是上次的 而不是最新的
                    break;
                case "Fg_long":
                    if (e.Input.ToString() == "false")
                    {
                        cof.getControlByName(xapFormControl1,"drugsUse", "Use_days").Enabled = false;//临时 医嘱天数 不可输入
                    }
                    else
                    {
                        cof.getControlByName(xapFormControl1,"drugsUse", "Use_days").Enabled = true;
                    }

                    break;

                case "Fg_self":
                    if (this.EmsHeadDO.Emsdrugs.Fg_self == true)
                        this.EmsHeadDO.Emsdrugs.Fg_outp = !this.EmsHeadDO.Emsdrugs.Fg_self;
                    break;
                case "Fg_outp":
                    if (this.EmsHeadDO.Emsdrugs.Fg_outp == true)
                    {
                        this.EmsHeadDO.Emsdrugs.Fg_self = !this.EmsHeadDO.Emsdrugs.Fg_outp;
                        //ctlTotal.Enabled = true;
                        gv.DataTable.Columns["Quan_cur"].ReadOnly = false;
                        if (cof.getControlByName(xapFormControl1,"drugsUse", "fg_outp").ValueText == "true")
                        {
                            cof.GetDrugTotal(this.EmsHeadDO);
                        }
                        gv.DataTable.Columns["Quan_cur"].ReadOnly = false;
                        gv.DataTable.Columns["Name_unit_sale"].ReadOnly = false;
                        manageUnitName("out");
                    }
                    else
                    {
                        gv.DataTable.Columns["Quan_cur"].ReadOnly = true;
                        foreach (EmsOrDrug itemDrug in this.EmsHeadDO.Emsdrugs.EmsOrDrugList)
                        {
                            itemDrug.Quan_cur = null;
                        }
                        gv.DataTable.Columns["Quan_cur"].ReadOnly = true;
                        gv.DataTable.Columns["Name_unit_sale"].ReadOnly = true;
                        manageUnitName("in");
                        //ctlTotal.Enabled = false;
                    }
                    break;
                case "Fg_treat":
                    this.EmsHeadDO.Emsdrugs.Fg_propc = !this.EmsHeadDO.Emsdrugs.Fg_treat;
                    break;
                case "Fg_propc":
                    this.EmsHeadDO.Emsdrugs.Fg_treat = !this.EmsHeadDO.Emsdrugs.Fg_propc;
                    break;
                case "Quan_med":
                    if (cof.getControlByName(xapFormControl1, "drugsUse", "fg_outp").ValueText == "true")
                    {
                        cof.GetDrugTotal(this.EmsHeadDO);
                    }
                    break;
                case "Quan_firday_mp":
                    cof.getWorkTime(this.xapFormControl1, exctimes);
                    if (cof.getControlByName(xapFormControl1,"drugsUse", "fg_outp").ValueText == "true")
                    {
                        cof.GetDrugTotal(this.EmsHeadDO);
                    }
                    break;

                case "Name_unit_sale":
                    this.manageUnitName("");//保存所有单位名称到缓存

                    break;
                case "Quan_cur":
                    GetStockReqDTO reqDto = new GetStockReqDTO();
                    if (gv.GetFocusedRow<EmsOrDrug>() != null)
                    {
                        string id_mm = gv.GetFocusedRow<EmsOrDrug>().Id_mm;
                        string id_dep_phy = this.EmsHeadDO.Emsdrugs.Id_dep;
                        reqDto.Id_dep = id_dep_phy;
                        reqDto.Id_mm = id_mm;
                        reqDto.Req_unit_id = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_unit_sale;
                        GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
                        reqDtoArr[0] = reqDto;
                        try {
                            MaterialStockDTO[] materialArr = cof.getMaterialStocksCount(reqDtoArr);
                            if (materialArr != null && materialArr.Length > 0)
                            {
                                MaterialStockDTO material = materialArr[0];
                                if (material == null || material.Quan_stock < gv.GetFocusedRow<EmsOrDrug>().Quan_cur)
                                {
                                    this.ShowInfo(this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Name_mm + "数量已超过库存量，无法开立！");
                                    return;
                                }
                            }
                        }
                        catch //(Exception ex)
                        {
                            
                        }
                        
                    }
                    break;
                default:
                    break;
            }





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



        }


        /// <summary>
        /// Drugs 表单药品剂量数据写到药品do
        /// </summary>
        /// Author:admin
        /// Date:2015-10-21
        private void DrugWriteData()
        {


            return;
            /*
            if (this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count == 0) return;
            EmsOrDrug orDrug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
            //orDrug.Name_mm = this.EmsHeadDO.Emsdrugs.Name_mm;//药品名称
            //orDrug.Spec_mm = this.EmsHeadDO.Emsdrugs.Spec_mm;//规格
            //orDrug.Name_heath = this.EmsHeadDO.Emsdrugs.Name_heath;//医保类型
            //orDrug.Limit = this.EmsHeadDO.Emsdrugs.Limit;//限制报销条件
            //orDrug.Price = this.EmsHeadDO.Emsdrugs.Price;//参考价格
            if (this.EmsHeadDO.Emsdrugs.Total_count != null)
                orDrug.Quan_cur = (int)this.EmsHeadDO.Emsdrugs.Total_count;//总量
            orDrug.Id_unit_base = this.EmsHeadDO.Emsdrugs.Id_unit_base;
            orDrug.Name_unit_base = this.EmsHeadDO.Emsdrugs.Name_unit_base;
            orDrug.Id_unit_med = this.EmsHeadDO.Emsdrugs.Id_unit_med;
            orDrug.Name_unit_med = this.EmsHeadDO.Emsdrugs.Name_unit_med;
            orDrug.Id_pgku_cur = this.EmsHeadDO.Emsdrugs.Id_total_count_unit;//基本包装单位，如：片
            orDrug.Name_pgku_cur = this.EmsHeadDO.Emsdrugs.Total_count_unit;
            if (this.EmsHeadDO.Emsdrugs.Id_total_count_unit == null)
            {
                //orDrug.Id_pgku_cur =  this.EmsHeadDO.Emsdrugs.Id_unit_med ;
                //orDrug.Name_pgku_cur = this.EmsHeadDO.Emsdrugs.Name_unit_base;
            }
            //if (this.EmsHeadDO.Emsdrugs.Quan_base != null)
            // orDrug.Quan_base = this.EmsHeadDO.Emsdrugs.Quan_base;
            orDrug.Quan_med = this.EmsHeadDO.Emsdrugs.Quan_med;
            */
        }

        /// <summary>
        /// 编辑时候药品剂量数据写到表单
        /// </summary>
        /// Author:admin
        /// Date:2015-10-21
        private void DrugReadData()
        {


            return;
            /*
            if (this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count == 0) return;
            EmsOrDrug emsDrug = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
            this.EmsHeadDO.Emsdrugs.Quan_med = emsDrug.Quan_med;
            this.EmsHeadDO.Emsdrugs.Id_unit_med = emsDrug.Id_unit_med;
            this.EmsHeadDO.Emsdrugs.Name_unit_med = emsDrug.Name_unit_med;
            this.EmsHeadDO.Emsdrugs.Quan_base = emsDrug.Quan_base;
            this.EmsHeadDO.Emsdrugs.Id_unit_base = emsDrug.Id_unit_base;
            this.EmsHeadDO.Emsdrugs.Name_unit_base = emsDrug.Name_unit_base;
            this.EmsHeadDO.Emsdrugs.Total_count = emsDrug.Quan_cur;
            this.EmsHeadDO.Emsdrugs.Total_count_unit = emsDrug.Name_unit_sale;
            this.EmsHeadDO.Emsdrugs.Id_total_count_unit = emsDrug.Id_unit_sale;
            */
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
            return cof.getControlByName(this.xapFormControl1,tabId, name).UserRender as XCheckBox;
        }

        public override void SaveBefore()
        {
            xapFormControl1.SaveForm();
            DrugWriteData();
        }
        
        /// <summary>
        /// 显示或隐藏单位名称，隐藏时记录名称
        /// </summary>
        /// <param name="type">out是出院带药为true ，in为出院带药为false，为空代表只记录当前单位名称</param>
        private void manageUnitName(string type)
        {
            int count = this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count;

            if (type == "out")
            {
                for (int i = 0; i < count; i++)
                {
                    if (mapUnit.ContainsKey(this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv))
                    {
                        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale = mapUnit[this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv];
                    }
                    
                }
            }
            else
            {
                for (int i = 0; i < count; i++)
                {
                    string Id_srv = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv;
                    if (mapUnit.ContainsKey(Id_srv))
                    {
                        string name = this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale;
                        if(name!=null && name!=""){
                            mapUnit[this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv] = name;
                        }
                        

                    }
                    else
                    {
                        mapUnit.Add(this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Id_srv, this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale);
                    }
                    if (type == "in")//院内用药
                    {
                        this.EmsHeadDO.Emsdrugs.EmsOrDrugList[i].Name_unit_sale = "";
                    }
                    
                }

            }




        }

        #endregion
        //设置执行次数和执行时间:这个是在开立的时候做的，二次查看的时候要根据使用次数算执行时间
        public void GetMpTimes(string id_freq)
        {
            //cof.GetDoseDrugData(id_freq, this.EmsHeadDO);
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
                //numRender.MaxValue = numf;
                numRender.MaxValue = numf;
                this.EmsHeadDO.Emsdrugs.Quan_firday_mp = numf;
            }
            else
            {
                numRender.ValueText = null;
                numRender.MaxValue = 0;
            }
        }
        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {



        }

        #endregion
    }
}
