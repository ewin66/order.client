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
using iih.ci.ord.ciorder;
using xap.rui.appfw;
using iih.ci.ord.ciorder.cards;
using xap.cli.sdk.render.Items;
using iih.ci.ord.ciorder.Validate;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.viewmodel.impext;
using xap.cli.sdk.controls.DataView;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.oporder.cards
{
    /// <summary>
    /// 草药医疗单
    /// </summary>
    /// Author:admin
    /// Date:2015-10-10
    public partial class OpOrderHerbsView : CiorderBaseControl
    {


        #region 变量定义区域

        public XapFormControl xapFormControl1;

        XapFormGridControl gv;//, gv_change;// 药品商品表，变动用药
        Dictionary<string, UserRender> dic = new Dictionary<string, UserRender>();//界面控件集合
         EmsOrDrug selectDrugDo=new EmsOrDrug();
         OrderDrugDesView desView = new OrderDrugDesView() { Dock = DockStyle.Fill };
         //用户是否编辑了医嘱备注
         private bool userEditFlag = false;
         //医嘱备注获得焦点时的值
         private string focusText;
        #endregion

        #region 构造函数区域

         public OpOrderHerbsView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderHerbsView_Load);
            xapFormControl1 = new XapFormControl();
            xapFormControl1.Padding = new System.Windows.Forms.Padding(0, 4, 0, 0);
            this.Controls.Add(xapFormControl1);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);

            this.xapFormControl1.RefResult += this.OnRefResult;
 

            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
            her = new HerBalMedicineCtr() { MedicineName = "Name_mm", DosageName = "Quan_med", UsgeName = "Name_boildes", UnitName = "Name_unit_med", HerbalWidth = 99, HerbalHeight = 35 };
            her.SelectedClick += new EventHandler(her_SelectedClick);
            Dictionary<string, Control> controls = new Dictionary<string, Control>();
            controls.Add("herCtl", her);
            this.xapFormControl1.RegisterControl(controls);
            this.SheetName = "草药医疗单";
        }
 

        void her_SelectedClick(object sender, EventArgs e)
        {
            selectDrugDo = her.GetFouceDo<EmsOrDrug>();
            gv.DataTable.DataSource =new BindingList<EmsOrDrug>(){selectDrugDo} ;
        }

        void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {
            switch (e.PropName)//计算结束日期
            {
                case "Dt_begin_ui":
                    DateTime adm =cof.GetServerDataTime();//TODO: 入院时间
                    string info = cof.CompareWithAdmission(EmsHeadDO.PatInfo.Id_ent, EmsHeadDO.Emsdrugs.Dt_begin_ui);
                    if (info != "")
                    {
                     this.ShowInfo(info);
                        return;
                    }
                    if (EmsHeadDO.Emsdrugs.Dt_begin_ui != null)
                    {
                        UserRender us = xapFormControl1.GetUserRender("drugsUse", "dt_end_ui");
                        xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
                        dt_begin.MinDate = EmsHeadDO.Emsdrugs.Dt_begin_ui.Value;
                    }
                    //草药在拆分时必须要有结束时间，出院带药界面中没有结束时间控件，所以将结束时间设为开始往后7天
                    //EmsHeadDO.Emsdrugs.Dt_end_ui = ((DateTime)EmsHeadDO.Emsdrugs.Dt_begin_ui).AddDays(7);
                    break;
                case "Dt_end_ui"://计算医嘱天数
                    EmsHeadDO.Emsdrugs.Use_days = cof.GetUseDays(EmsHeadDO.Emsdrugs.Dt_begin_ui, EmsHeadDO.Emsdrugs.Dt_end_ui);
                    break;
                case "Orders":
                    if (EmsHeadDO.Emsdrugs.Orders != null)
                    {
                        ((XNumbericUpDown)((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "orders_boil")).UserRender).MaxValue = (double)EmsHeadDO.Emsdrugs.Orders;
                        EmsHeadDO.Emsdrugs.Orders_boil = EmsHeadDO.Emsdrugs.Orders;
                    }
                    this.setTime_cur();
                    setQauntum(this.EmsHeadDO.Emsdrugs.Orders);
                    break;
            }
            if (!userEditFlag && !e.PropName.Equals("Note_or"))
            {
                cof.SetNoteOr(this.EmsHeadDO);
            }
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
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OpOrderHerbsView;// "20151218072433749U5F";// "20151218072433749U5F";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = EmsHeadDO.Emsdrugs;
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);

        }//频次
        protected override void OnRefResult(object sender, RefResultEventArgs e)
        {
            RefDataCollection data = e.RefResultSet;
            if (e.BindingFieldName == "Name_freq")
            {
                if (data.IsEmpty) {
                    EmsHeadDO.Emsdrugs.Sd_frequnitct = null;
                    EmsHeadDO.Emsdrugs.Id_freq = null;
                    EmsHeadDO.Emsdrugs.Freqct = null;
                    return;
                }
                string id_freq = data.FirstData["Id_freq"] as string;//获取字段值
                EmsHeadDO.Emsdrugs.Sd_frequnitct = data.FirstData["Sd_frequnitct"] as string;
                EmsHeadDO.Emsdrugs.Freqct = null;
                this.setTime_cur();
                setQauntum(this.EmsHeadDO.Emsdrugs.Orders);
            } 
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                //新增时候 参照写会
                EmsOrDrug drugNew = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
                if (e.RefResultSet.IsEmpty)
                {
                    drugNew.Id_srv = "";
                    drugNew.Name_srv = "";
                    drugNew.Spec_mm = "";
                    drugNew.Quan_med = null;
                    drugNew.Name_unit_med = "";
                    drugNew.Quan_cur = null;
                    drugNew.Name_unit_sale = "";
                    drugNew.Note_ext = "";
                    drugNew.Name_mm = "";
                    drugNew.Name_boildes = "";
                    return;
                }
                string strSrv = data.FirstData["Name"].ToString();
                if (EmsHeadDO.Emsdrugs.EmsOrDrugList.Count(p => p.Name_srv == strSrv) > 1)
                {
                    this.ShowInfo("存在相同的服务！");
                    drugNew.Name_srv = null;
                    drugNew.Id_srv = null;
                    return;
                }
                drugNew.Quan_med = double.Parse(data.FirstData["Quan_med"].ToString());
                XapDataList<EmsOrDrug> drugs = cof.GetSrvMm(EmsHeadDO, drugNew.Id_srv,EmsHeadDO.PatInfo.Code_entp);
                if (drugs.Count > 0)
                {
                    EmsOrDrug drugRef = drugs.FirstOrDefault();
                    cof.CopyTo(drugRef, drugNew, "Id_srv", "Name_srv");
                    cof.concateExtNote(new XapDataList<EmsOrDrug>() { drugNew }, EmsHeadDO.PatInfo, EmsHeadDO);
                }
                this.setTime_cur();
                setQauntum(this.EmsHeadDO.Emsdrugs.Orders);
            }



          
        }

        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            this.EmsHeadDO = headDo;
            //if (headDo.IsNEW)
            //{
            //    EmsHeadDO.Emsdrugs.EmsOrDrugList = EmsHeadDO.Emsdrugs.EmsOrDrug;
            //}
            if (this.Created)
            {
                this.LoadData();
            }
           // EmsHeadDO.Emsapobs.EmsOrObsList.ListChanged += new ListChangedEventHandler(EmsOrObsList_ListChanged);
            //DrugReadData();
        }

        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                e.WherePart = string.Format(" Sd_srvtp like '0103%'");

            }
            else if (e.BindingFieldName.Equals("Name_mm"))
            {
                EmsOrDrug drugDo = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
                if (drugDo.Id_srv == null)
                {
                    e.Cancel=true;
                    return;
                }
                e.WherePart = string.Format("BD_MM.id_mm in ({0})", cof.GetSrvMmStr(EmsHeadDO, drugDo.Id_srv));
            }
            else if (e.BindingFieldName.Equals("Name_dep"))
            {
                //if (EmsHeadDO.Emsdrugs.Str_mp_dep_ids != null && EmsHeadDO.Emsdrugs.Str_mp_dep_ids != "")
                //    e.WherePart = string.Format(" id_dep in({0})", EmsHeadDO.Emsdrugs.Str_mp_dep_ids);
                ////e.RefParams.AddParam("Dep", EmsHeadDO.Emsdrugs.Str_mp_dep_ids);
                if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Str_mp_dep_ids != null && EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Str_mp_dep_ids != "")
                    e.WherePart = string.Format(" id_dep in({0})", EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Str_mp_dep_ids);
            }
            else if (e.BindingFieldName.Equals("Name_route"))
            {
                e.WherePart = string.Format("id_route in ({0})", new GetSrvVsRouteImp().GetHerbRounte());
            }
            else if (e.BindingFieldName.Equals("Name_freq"))
            {//排除 临时 备用
                e.WherePart = string.Format("id_freq not in ({0}) and fg_active='Y'", "'0001AA1000000006BR2U','0001AA10000000079NW4'");
            }
            else if (e.BindingFieldName.Equals("Name_boildes"))
            {
                //if (EmsHeadDO.Emsdrugs.Id_boil != null)
                //{
                //    e.WherePart = string.Format("id_boil ='{0}' and ds=0", EmsHeadDO.Emsdrugs.Id_boil);
                //}
            }
           
        }
        public override IValidate GetOrdValidate()
        {
            return new OrderHerbsValidate();
        }

        #endregion

        #region 内部事件区域
        public override void SaveBefore()
        {
            if (EmsHeadDO.Emsdrugs.Orders_boil != null)
            {
                EmsHeadDO.Emsdrugs.Fg_bl = true;
            }
            xapFormControl1.SaveForm();
            cof.GetDrugTotal(EmsHeadDO);
            //DrugWriteData();
            //EmsHeadDO.Emsdrugs.Dt_begin_ui = EmsHeadDO.Emsdrugs.Dt_end_ui = null;

        }

        void OrderHerbsView_Load(object sender, EventArgs e)
        {
            OnInit();
        }
        HerBalMedicineCtr her;
        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {

            XTabControl tabControl = new XTabControl();
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            dic = tabs[0].Pages[0].DicUserRenders;

            XTabControl tab = tabs[0].tabContrl;
            //UserRender ur = xapFormControl1.GetUserRender("drugsUse", "name_dep");//获取表格上方最近的控件

            //Point p = new Point(ur.Location.X, ur.Location.Y + 20);//计算表格应该放的位置

           List<XLabelBaseUserRender> xap=   xapFormControl1.RendersListMustInput;
            gv = xapFormControl1.GetGridView("drug");//药品列表
            gv.MouseClick += new MouseEventHandler(gv_MouseClick);

            //gv_change = this.xapFormControl1.GetGridView("change");//变动用药

            //UserRender btnOK = xapFormControl1.GetUserRender("drugsUse", "btnSave");//保存
            //btnOK.MouseClick += new MouseEventHandler(btnOK_MouseClick);

            UserRender btndelete = xapFormControl1.GetUserRender("drugsUse", "btndelete");//删除
            btndelete.MouseClick += new MouseEventHandler(btndelete_MouseClick);
            UserRender btnAdd = this.xapFormControl1.GetUserRender("drugsUse", "btnAdd");//新增按钮
            btnAdd.MouseClick += new MouseEventHandler(btnAdd_MouseClick);



            SetGridPolicy(true);
            gv.DataTable.ReadOnly = false;
            gv.DataTable.Columns["Spec_mm"].ReadOnly = true;
            //gv.DataTable.Columns["Quan_med"].ReadOnly = true;

            //----------药品说明----------------------
            //为医嘱备注绑定事件
            ((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "note_or")).GotFocus += new EventHandler(OrderHerbsView_GotFocus);
            ((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "note_or")).LostFocus += new EventHandler(OrderHerbsView_LostFocus);

            XTabControl tabControl1 = tabs[0].tabContrl;
            XTabPage xtab = tabControl1.XTabPages[1];
            tabControl1.SelectedIndexChanged += new XTabControl.selectedIndexChanged(tabControl1_SelectedIndexChanged);
            xtab.Controls.Clear();
            xtab.Controls.Add(desView);
            //待歼付数
            ((XNumbericUpDown)((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "orders_boil")).UserRender).MinValue = 0;
            ((XNumbericUpDown)((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "orders")).UserRender).MinValue = 1;

        }

        void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            desView.ShowDrugDes(EmsHeadDO.Emsdrugs.EmsOrDrugList);
        }
        //草药删除
        void btndelete_MouseClick(object sender, MouseEventArgs e)
        {
            XDataRow row = gv.DataTable.GetFirstRow();
            //删除前应该提示一下吧？
            if (row != null)
            {
                EmsOrDrug delDo = row.DataSource as EmsOrDrug;
                cof.DeleteOrDrug(EmsHeadDO, delDo);
                gv.DataTable.DataSource = null;
            }
        }

        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            xapFormControl1.SetTabPageEnabled("drugsUse", !IsReadOnly);
            //IsReadOnly = false;
            gv.DataTable.DataSource = null;
            SetGridPolicy(!IsReadOnly);
            her.DataSource = EmsHeadDO.Emsdrugs.EmsOrDrugList;
            if (gv.DataTable.Rows.Count == 0 && EmsHeadDO.Emsdrugs.EmsOrDrugList.Count > 0)
            {
                gv.DataTable.DataSource = new BindingList<EmsOrDrug>() { this.EmsHeadDO.Emsdrugs.EmsOrDrugList.LastOrDefault() };
            }
            ((XNumbericUpDown)((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "orders_boil")).UserRender).MaxValue = (double)EmsHeadDO.Emsdrugs.Orders;
            if(EmsHeadDO.Emsdrugs.Dt_begin_ui==null){
                EmsHeadDO.Emsdrugs.Dt_begin_ui  = this.NowTime();
            }
            userEditFlag = !EmsHeadDO.IsNEW;
            if (EmsHeadDO.IsNEW)
            {
                this.setTime_cur();
                setQauntum(this.EmsHeadDO.Emsdrugs.Orders);
                //草药在拆分时必须要有结束时间，出院带药界面中没有结束时间控件，所以将结束时间设为开始往后7天去掉
                //EmsHeadDO.Emsdrugs.Dt_end_ui = ((DateTime)EmsHeadDO.Emsdrugs.Dt_begin_ui).AddDays(7);
                cof.SetNoteOr(this.EmsHeadDO);
            }
            //UserRender us = xapFormControl1.GetUserRender("drugsUse", "dt_begin_ui");
            //xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
            //dt_begin.MinDate = cof.GetServerDataTime();
                
        }

        void gv_MouseClick(object sender, MouseEventArgs e)
        {

            // 待修改
            //if (gv.GetFocusedRow().ClickCell.FieldName == "Name_mm")
            //{
            //    string id_srv = (gv.GetFocusedRow().RowDataSource as EmsOrDrug).Id_srv;//拿到 点击的药品对应服务的id_srv
            //    //根据服务id 取到 服务关联的药品 ，



            //    if (EmsHeadDO.Emsdrugs.EmsOrDrug.Count > 1)//如果只有一条
            //    {
            //        MmForm mmref = new MmForm(EmsHeadDO.Emsdrugs.EmsOrDrug);
            //        Point formPoint = Control.MousePosition;
            //        mmref.Local = formPoint;
            //        mmref.ShowDialog();
            //        if (mmref.DialogResult == DialogResult.OK)
            //        {
            //            //这样做是有缺陷的 原数据有 主键 sv  替换后的 数据是没有主键 sv 的 就不对了
            //            //EmsHeadDO.Emsdrugs.EmsOrDrugList.Clear();
            //            //EmsHeadDO.Emsdrugs.EmsOrDrugList.Add(mmref.drugmm);
            //            //正确的做法  只对 关键值进行替换
            //            EmsOrDrug orDrug = EmsHeadDO.Emsdrugs.EmsOrDrugList[gv.FocusedRowHandle];
            //            orDrug.Name_mm = mmref.drugmm.Name_mm;//药品名称
            //            orDrug.Spec_mm = mmref.drugmm.Spec_mm;//规格
            //            orDrug.Name_heath = mmref.drugmm.Name_heath;//医保类型
            //            orDrug.Limit = mmref.drugmm.Limit;//限制报销条件
            //            orDrug.Price = mmref.drugmm.Price;//参考价格

            //        }
            //    }


            //}
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
            gv.ReadOnly = false;
        }
        /// <summary>
        /// Drugs 表单药品剂量数据写到药品do
        /// </summary>
        /// Author:admin
        /// Date:2015-10-21
        private void DrugWriteData()
        {
            if (EmsHeadDO.Emsdrugs.EmsOrDrugList.Count == 0) return;
            EmsOrDrug orDrug = EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
            //orDrug.Name_mm = EmsHeadDO.Emsdrugs.Name_mm;//药品名称
            //orDrug.Spec_mm = EmsHeadDO.Emsdrugs.Spec_mm;//规格
            //orDrug.Name_heath = EmsHeadDO.Emsdrugs.Name_heath;//医保类型
            //orDrug.Limit = EmsHeadDO.Emsdrugs.Limit;//限制报销条件
            //orDrug.Price = EmsHeadDO.Emsdrugs.Price;//参考价格
            //if (EmsHeadDO.Emsdrugs.Total_count != null)
            //    orDrug.Quan_cur = (int)EmsHeadDO.Emsdrugs.Total_count;//总量
            //orDrug.Id_unit_base = EmsHeadDO.Emsdrugs.Id_unit_base;
            //orDrug.Name_unit_base = EmsHeadDO.Emsdrugs.Name_unit_base;
            //orDrug.Id_unit_med = EmsHeadDO.Emsdrugs.Id_unit_med;
            //orDrug.Name_unit_med = EmsHeadDO.Emsdrugs.Name_unit_med;
            //orDrug.Id_pgku_cur = EmsHeadDO.Emsdrugs.Id_total_count_unit;//基本包装单位，如：片
            //orDrug.Name_pgku_cur = EmsHeadDO.Emsdrugs.Total_count_unit;
            //if (EmsHeadDO.Emsdrugs.Id_total_count_unit == null)
            //{
            //    //orDrug.Id_pgku_cur =  EmsHeadDO.Emsdrugs.Id_unit_med ;
            //    //orDrug.Name_pgku_cur = EmsHeadDO.Emsdrugs.Name_unit_base;
            //}
            ////if (EmsHeadDO.Emsdrugs.Quan_base != null)
            //    //orDrug.Quan_base = EmsHeadDO.Emsdrugs.Quan_base;
            //orDrug.Quan_med = EmsHeadDO.Emsdrugs.Quan_med;

            //if (orDrug.Quan_med != null && EmsHeadDO.Emsdrugs.Orders != null)
            //{
            //    orDrug.Quan_cur = (int)(orDrug.Quan_med.Value) * EmsHeadDO.Emsdrugs.Orders.Value;
            //}

            EmsHeadDO.Emsdrugs.EmsOrDrugList.ToList().ForEach(p =>
            {
                if (p.Quan_med != null && EmsHeadDO.Emsdrugs.Orders != null)
                {
                    p.Quan_cur = (int)(p.Quan_med.ToDouble()) * EmsHeadDO.Emsdrugs.Orders.Value;
                }
            });
        }

        /// <summary>
        /// 编辑时候药品剂量数据写到表单
        /// </summary>
        /// Author:admin
        /// Date:2015-10-21
        private void DrugReadData()
        {
            if (EmsHeadDO.Emsdrugs.EmsOrDrugList.Count == 0) return;
            EmsOrDrug emsDrug = EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
            EmsHeadDO.Emsdrugs.Quan_med = emsDrug.Quan_med;
            //EmsHeadDO.Emsdrugs.Id_unit_med = emsDrug.Id_unit_med;
            //EmsHeadDO.Emsdrugs.Name_unit_med = emsDrug.Name_unit_med;
            EmsHeadDO.Emsdrugs.Quan_base = emsDrug.Quan_base;
            EmsHeadDO.Emsdrugs.Id_unit_base = emsDrug.Id_unit_base;
            EmsHeadDO.Emsdrugs.Name_unit_base = emsDrug.Name_unit_base;
            EmsHeadDO.Emsdrugs.Total_count = emsDrug.Quan_cur;
            EmsHeadDO.Emsdrugs.Total_count_unit = emsDrug.Name_unit_sale;
            EmsHeadDO.Emsdrugs.Id_total_count_unit = emsDrug.Id_unit_sale;
        }
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
        /// <summary>
        /// 计算总次数
        /// </summary>
        protected void setTime_cur()
        {
            //总次数
            this.EmsHeadDO.Emsdrugs.Times_cur = CalQuantumUtil.GetInstance().getTotalTimes(this.EmsHeadDO.Emsdrugs.Id_freq, this.EmsHeadDO.Emsdrugs.Use_days);
        }
        /// <summary>
        /// 计算总量
        /// </summary>
        /// <param name="drug"></param>
        protected void setQauntum(int? times_cur)
        {
            foreach (EmsOrDrug item in this.EmsHeadDO.Emsdrugs.EmsOrDrugList)
            {
                if (times_cur == null)
                {
                    times_cur = 0;
                    continue;
                }
                if (item.Fg_ctm != null && item.Fg_ctm == true)
                {
                    item.Quan_cur = CalQuantumUtil.GetInstance().getUnMMQuantum(item.Quan_med, times_cur);//GetLogicEx().getNotDrugTotal(drug.Quan_med, drug.Id_freq, drug.Freqct.Value, this.uiEmsDTO.Emsdrugs.Use_days.Value);
                }
                item.Quan_cur = CalQuantumUtil.GetInstance().getMMQuantum(item.Sd_opmutp, item.Quan_med, item.Factor_mb, item.Factor_cb, (int)times_cur);
            }
            //this.logicEx.GetDrugTotal(this.uiEmsDTO);

        }
        #endregion

        #region 状态处理区域



        #endregion
    }
}

