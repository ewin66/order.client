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
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.data;
using xap.rui.control.refcontrol.events;
using xap.rui.control.forms.control;
using xap.mw.core.data;
using iih.ci.ord.ciorder;
using iih.ci.ord.ciorder.cards;
using xap.rui.control.extentions;
using xap.cli.sdk.render.Items;
using xap.rui.appfw;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.ciorder.Validate;
using iih.mm.itf.material.d;
using iih.ci.ord.ciord.d;
using iih.ci.ord.ciorder.cards.drugext.dialogform;
using iih.ci.ord.cards.thread.dp;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.controls.DataView.Model;
using iih.ci.ord.opemergency.controls;
using xap.mw.coreitf.d;
using xap.cli.sdk.form;
using xap.cli.sdk.controls;
using iih.en.pv.dto.d;
using iih.bd.srv.srvortpl.srvortpl.view;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.oporder.cards
{
    public partial class OpOrderDrugsView : CiorderBaseControl
    {
        private bool bEdit_Note_or;
        private string txt_Note_or = "";

        #region 变量定义区域
        XapFormGridControl gv; //gv_change;
        Dictionary<string, UserRender> dic = new Dictionary<string, UserRender>();
        new LogicEx cof = LogicEx.GetInstance();
        EmsOrDrug drug = new EmsOrDrug();
        OrderDrugDesView desView = new OrderDrugDesView() { Dock = DockStyle.Fill };
        #endregion

        #region 构造函数区域
        public OpOrderDrugsView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderDrugsView_Load);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            this.xapFormControl1.RefResult += xapFormControl1_RefResult;
            xapFormControl1.RefFilter += OnRefFilter;
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            xapFormControl1.DataChanging += new EventHandler<DataChangingEventArgs>(xapFormControl1_DataChanging);
            this.SheetName = "普药医疗单";
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
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OpOrderDrugsView;// "20151022081510559WSA";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = EmsHeadDO.Emsdrugs;// 新的
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);

        }
        public override IValidate GetOrdValidate()
        {
            return new OpOrderDrugsValidate();
        }


        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName == "Name_route")
            {
                e.WherePart = string.Format("id_route in ({0})", new GetSrvVsRouteImp().GetDosageVsRounte("'" + string.Join("','", EmsHeadDO.Emsdrugs.EmsOrDrugList.Select(p => p.Id_srv).ToList()) + "'"));
            }
            else if (e.BindingFieldName.Equals("Name_dep"))
            {
                if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Str_mp_dep_ids != null && EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Str_mp_dep_ids != "")
                    e.WherePart = string.Format(" id_dep in({0})", EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Str_mp_dep_ids);
            }
            else if (e.BindingFieldName.Equals("Total_count_unit"))//计量单位
            {
                if (drug.Str_unit_pkg_ids != null && drug.Str_unit_pkg_ids != "")
                    e.WherePart = string.Format("id_measdoc in ({0})", drug.Str_unit_pkg_ids);
            }
            else if (e.BindingFieldName.Equals("Name_unit_sale"))//计量单位
            {
                if (drug.Str_unit_pkg_ids != null && drug.Str_unit_pkg_ids != "")
                    e.WherePart = string.Format("id_measdoc in ({0})", drug.Str_unit_pkg_ids);
            }
            else if (e.BindingFieldName.Equals("Name_routedes"))
            {
                e.WherePart = string.Format("BD_ROUTE_DES.FG_ENTP_OP='Y'");
            }
            else if (e.BindingFieldName.Equals("Name_freq"))
            {
                e.WherePart = string.Format("bd_freq.FG_ACTIVE='Y'");
            }
        }



        public override void OnRefreshData(ciordems.d.EmsUIDTO headDo, object e)
        {
            if (headDo != null)
            {
                EmsHeadDO = headDo;

                //if (headDo.Status==DOStatus.NEW)
                //{
                //    if (headDo.Emsdrugs.EmsOrDrug.Count > 0)
                //    {
                //        EmsOrDrug or = new EmsOrDrug();
                //        or = cof.DoCopy<EmsOrDrug>(headDo.Emsdrugs.EmsOrDrug.FirstOrDefault());
                //        headDo.Emsdrugs.EmsOrDrugList.Add(or);
                //    }

                //}
                DrugReadData();
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

        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            EmsHeadDO.Emsdrugs.Fg_treat = true;//默认为治疗用药
            XTabControl tabControl = new XTabControl();
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            dic = tabs[0].Pages[0].DicUserRenders;
            gv = xapFormControl1.GetGridView("drug");//药品列表
            gv.MouseClick += new MouseEventHandler(gv_MouseClick);
            gv.DataTable.DataDisplay += new EventHandler<XDataDisplayEventArgs>(xapFormControl1_DataDisplay);
            //gv.DataTable.CellValueChanged += new CellValueChangedEventHandler(cellValueChanged);
            SetGridPolicy(true);
            gv.ReadOnly = false;
            gv.DataTable.ReadOnly = false;

            XTabControl tabControl1 = tabs[0].tabContrl;
            XTabPage xtab = tabControl1.XTabPages[1];
            tabControl1.SelectedIndexChanged += new XTabControl.selectedIndexChanged(tabControl1_SelectedIndexChanged);
            xtab.Controls.Clear();
            xtab.Controls.Add(desView);
            // 关联总量单元格编辑控件
            AttachQuanCurEditor();

            cof.getControlByName(xapFormControl1, "drugsUse", "note_or").GotFocus += new EventHandler(Note_or_GotFocus);
            cof.getControlByName(xapFormControl1, "drugsUse", "note_or").LostFocus += new EventHandler(Note_or_LostFocus);
        }
        void cellValueChanged(object sender, XCellValueChangedEventArgs e)
        {
            EmsOrDrug drug = e.Data as EmsOrDrug;
            XCellRender cell = sender as XCellRender;
            if (drug.Quan_med == 0 || drug.Quan_med == null)
            {
                cell.CustomBackColor = Color.FromArgb(255, 225, 225);
                cell.BackColor = Color.FromArgb(255, 225, 225);
            }
            else
            {
                cell.CustomBackColor = Color.FromArgb(203, 242, 252);
                cell.BackColor = Color.FromArgb(203, 242, 252);
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

        protected void xapFormControl1_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            var drug = e.Object as EmsOrDrug;

            // 更新用户自定义列信息
            this.updateCustomerControlInfo(row, drug);
        }
        protected virtual void AttachQuanCurEditor()
        {

            foreach (var col in gv.DataTable.Columns)
            {
                var fieldName = col.FieldName.ToLower();

                if ("customercolumn_sale_unit".Equals(fieldName))
                {
                    col.ColumnEdit = new QuanCurTableCell();
                    break;
                }
            }
        }
        void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            desView.ShowDrugDes(EmsHeadDO.Emsdrugs.EmsOrDrugList);
        }

        /// <summary>
        /// 弹出物品选择器
        /// </summary>
        /// <param name="ds"></param>
        /// <param name="def"></param>
        /// <param name="atPoint"></param>
        private void ShowMmSelector(XDataRow row, List<EmsOrDrug> ds, EmsOrDrug def, Point atPoint, bool canEdit = true)
        {
            var mmContainer = new XBaseControl();
            mmContainer.Size = new Size(473, 160);

            var query = from items in ds orderby items.Fact_count descending select items;

            var mm = new ExtMmRefView(LogicEx.GetInstance().ConvertDataSouse<EmsOrDrug>(query.ToList()), def, false);

            mm.Dock = DockStyle.Fill;
            mmContainer.AddRender(mm);
            var popWindow = new XContextForm(mmContainer);
            mm.Event_SelectChanged += (sender, e) =>
            {
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
                        popWindow.Close();
                        return;
                    }

                }
                #endregion
                cof.CopyTo(mmDrug, orDrug, "Id_srv", "Name_srv");
                cof.concateMMSpecAndName(orDrug);
                orDrug.Fg_mm = true;
                updateTableCustomerComtrol();
                popWindow.Close();
            };
            popWindow.Show(atPoint);
            mm.Enabled = canEdit;
        }


        void gv_MouseClick(object sender, MouseEventArgs e)
        {
            drug = xapFormControl1.GetFocused<EmsOrDrug>("drug");
            XDataRow drow = sender as XDataRow;
            if (gv.GetFocusedRow().ClickCell.FieldName == "Name_mm")
            {
                EmsOrDrug emsordrug = gv.GetFocusedRow<EmsOrDrug>();
                if (emsordrug.Fg_ctm != null && emsordrug.Fg_ctm == true) return;//自定义服务时不能选择物品 2016-07-05 zwq
                string id_srv = (gv.GetFocusedRow().RowDataSource as EmsOrDrug).Id_srv;//拿到 点击的药品对应服务的id_srv
                //根据服务id 取到 服务关联的药品 ，
                //根据服务id 取到 服务关联的药品 ，
                if (EmsHeadDO.Emsdrugs.EmsOrDrug.Count > 0)
                {
                    if (middle.getEmsOrDrugList() == null) return;
                    List<EmsOrDrug> list = middle.getEmsOrDrugList().ToList().Where<EmsOrDrug>(p => p.Id_srv == id_srv).ToList();
                    // 替换下边注释的逻辑
                    this.ShowMmSelector(drow, list, emsordrug, gv.PointToScreen(new Point(drow.ClickCell.Location.X, drow.Location.Y + drow.Size.Height + 1)), !IsReadOnly);

                    /*
                    ExtMmForm mmref = new ExtMmForm(cof.ConvertDataSouse<EmsOrDrug>(list), EmsHeadDO.Emsdrugs, emsordrug);
                    mmref.StartPosition = FormStartPosition.Manual;
                    mmref.Location = gv.PointToScreen(new Point(drow.ClickCell.Location.X, drow.Location.Y + drow.Size.Height + 1));
                    mmref.TopMost = true;
                    mmref.setEdit(!IsReadOnly);
                    if (mmref.ShowDialog() == DialogResult.OK)
                    {
                        EmsOrDrug orDrug = EmsHeadDO.Emsdrugs.EmsOrDrugList[gv.FocusedRowHandle];
                        if (mmref.drugmm == null)
                        {
                            if (orDrug.Fg_self == true)
                            {
                                orDrug.Name_mm = orDrug.Name_srv;
                                orDrug.Id_mm = null;
                            }
                            return;
                        }
                        #region 皮试逻辑的判断
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
                        #endregion
                        cof.CopyTo(mmref.drugmm, orDrug, "Id_srv", "Name_srv");
                        cof.concateMMSpecAndName(orDrug);

                    }//*/
                }
                cof.GetDrugTotal(EmsHeadDO);
                updateTableCustomerComtrol();
            }
        }


        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {

            EmsHeadDO.Emsdrugs.EmsOrDrug = cof.MmSortList(EmsHeadDO.Emsdrugs.EmsOrDrug);
            gv.DataTable.DataSource = EmsHeadDO.Emsdrugs.EmsOrDrugList;
            drugBindPropertyEventAndCacheUnimed(EmsHeadDO.Emsdrugs.EmsOrDrugList);
            SetGridPolicy(!IsReadOnly);
            if (cof.IsAntDrug(EmsHeadDO.Emsdrugs.Id_srv))
            {
                getControlByName("drugsUse", "fg_treat").Visible = true;//治疗用药
                getControlByName("drugsUse", "fg_propc").Visible = true;//预防用药
            }
            else
            {
                getControlByName("drugsUse", "fg_treat").Visible = false;//治疗用药
                getControlByName("drugsUse", "fg_propc").Visible = false;//预防用药

            } //自定义服务处理
            if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0] != null && (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_ctm == null || EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_ctm == false))
            {
                gv.DataTable.Columns[0].ReadOnly = true;
            }
            else
            {
                gv.DataTable.Columns[0].ReadOnly = false;
            }
            if (gv != null)
            {
                gv.DataTable.DataSource = EmsHeadDO.Emsdrugs.EmsOrDrugList;
                //加载时为自定义服务药品列表绑定事件，并缓存自定义服务的剂量单位 zwq 2016-07-18
                drugBindPropertyEventAndCacheUnimed(EmsHeadDO.Emsdrugs.EmsOrDrugList);
                cof.threadSetMaterialInfoOfDrug(EmsHeadDO.Emsdrugs.EmsOrDrug, middle);

            }
            bEdit_Note_or = !this.EmsHeadDO.IsNEW;
            if (EmsHeadDO.IsNEW)
            {
                cof.SetNoteOr(this.EmsHeadDO);
                this.setTime_cur();
                setQauntum(this.EmsHeadDO.Emsdrugs.Times_cur);
                if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_ctm == true) return;
                if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_skintest != null && EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_skintest == true)
                {
                    SkinTestLogic logic = new SkinTestLogic(EmsHeadDO.PatInfo);
                    logic.skinTestLogic(EmsHeadDO.Emsdrugs.EmsOrDrugList[0]);
                }
                //设置结束时间和停止标志
                setEndTime();
            }
            updateTableCustomerComtrol();
        }

        void xapFormControl1_DataChanging(object sender, DataChangingEventArgs e)
        {
            switch (e.PropName)//计算结束日期
            {
                case "Dt_begin_ui":
                    //DateTime adm = cof.GetServerDataTime();//TODO: 入院时间
                    string info = cof.CompareWithAdmission(EmsHeadDO.PatInfo.Id_ent, EmsHeadDO.Emsdrugs.Dt_begin_ui);
                    if (info != "")
                    {
                        this.ShowInfo(info);

                        e.Cancel = true;
                    }

                    break;
                default: break;
            }

        }



        void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {

            switch (e.PropName)//计算结束日期
            {

                case "Use_days"://医嘱天数
                    if (EmsHeadDO.Emsdrugs.Use_days == null)
                    {
                        EmsHeadDO.Emsdrugs.Dt_end_ui = null;
                        return;
                    }

                    //EmsHeadDO.Emsdrugs.Dt_end_ui = cof.GetEndTime(EmsHeadDO.Emsdrugs.Dt_begin_ui, EmsHeadDO.Emsdrugs.Use_days.Value);
                    //cof.GetDrugUseTotalCount(EmsHeadDO);//住院的也将该代码注释了，不知原因
                    //if (getControlByName("drugsUse", "fg_outp").ValueText == "true")
                    //{
                    //取模
                    int? m = EmsHeadDO.Emsdrugs.Use_days % 7;
                    //判断周期类型错误
                    //if (EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 && m % 7 != 0)
                    if ((EmsHeadDO.Emsdrugs.Name_freq.IndexOf("周") > 0 || EmsHeadDO.Emsdrugs.Name_freq.IndexOf("星期") > 0) && m % 7 != 0)
                    {
                        if (m == 0 || m == 6)
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

                    this.setTime_cur();
                    setQauntum(this.EmsHeadDO.Emsdrugs.Times_cur);
                    //设置结束时间和停止标志
                    setEndTime();
                    //}
                    break;
                //界面上没有相关字段
                //case "Dt_begin_ui":
                //    if (EmsHeadDO.Emsdrugs.Dt_begin_ui != null)
                //    {
                //        UserRender us = xapFormControl1.GetUserRender("drugsUse", "dt_end_ui");
                //        xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
                //        dt_begin.MinDate = EmsHeadDO.Emsdrugs.Dt_begin_ui.Value;
                //    }
                //    break;
                //case "Dt_end_ui"://计算医嘱天数
                //    EmsHeadDO.Emsdrugs.Use_days = cof.GetUseDays(EmsHeadDO.Emsdrugs.Dt_begin_ui, EmsHeadDO.Emsdrugs.Dt_end_ui);
                //    //获取总量 
                //     // EmsOrDrug drug = EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
                //     //drug.Quan_cur= cof.GetDrugUseTotalCount(EmsHeadDO);

                //    int useDay = cof.GetUseDays(EmsHeadDO.Emsdrugs.Dt_begin_ui, EmsHeadDO.Emsdrugs.Dt_end_ui);
                //    if (EmsHeadDO.Emsdrugs.Use_days != useDay) {
                //        EmsHeadDO.Emsdrugs.Use_days = useDay;
                //    }
                //    EmsOrDrug drug = EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
                //    if (getControlByName("drugsUse", "fg_outp").ValueText == "true")
                //    {
                //        //drug.Quan_cur = cof.GetDrugUseTotalCount(EmsHeadDO);
                //        cof.GetDrugTotal(EmsHeadDO);
                //    }

                //    break;
                //case "Name_freq"://计算执行时刻1
                //    if (e.Input != null && e.Input.ToString().Contains("日"))
                //    {
                //        getControlByName("drugsUse", "quan_firday_mp").Enabled = true;
                //        getControlByName("drugsUse", "work_time").Enabled = true;
                //    }
                //    else
                //    {
                //        getControlByName("drugsUse", "quan_firday_mp").Enabled = false;
                //        getControlByName("drugsUse", "work_time").Enabled = false;
                //    }

                //    //  先于 OnRefResult(object sender, RefResultEventArgs e)执行，会出现  这个地方获取的id 是上次的 而不是最新的
                //    break;

                case "Fg_long":
                    if (e.Input == null || e.Input.ToString().ToLower() == "false")
                    {
                        getControlByName("drugsUse", "use_days").Enabled = false;//临时 医嘱天数 不可输入
                        EmsHeadDO.Emsdrugs.Use_days = 1;

                    }
                    else
                    {
                        getControlByName("drugsUse", "use_days").Enabled = true;
                    }

                    break;
                case "Fg_self":
                    if (EmsHeadDO.Emsdrugs.Fg_self == true)
                        EmsHeadDO.Emsdrugs.Fg_outp = !EmsHeadDO.Emsdrugs.Fg_self;

                    break;
                case "Fg_outp":
                    if (EmsHeadDO.Emsdrugs.Fg_outp == true)
                    {
                        EmsHeadDO.Emsdrugs.Fg_self = !EmsHeadDO.Emsdrugs.Fg_outp;
                        //ctlTotal.Enabled = true;
                        gv.DataTable.Columns["Quan_cur"].ReadOnly = false;
                    }
                    else
                    {
                        gv.DataTable.Columns["Quan_cur"].ReadOnly = true;
                        EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Quan_cur = null;
                        //ctlTotal.Enabled = false;
                    }


                    break;
                case "Fg_treat":
                    EmsHeadDO.Emsdrugs.Fg_propc = !EmsHeadDO.Emsdrugs.Fg_treat;
                    break;
                case "Fg_propc":
                    EmsHeadDO.Emsdrugs.Fg_treat = !EmsHeadDO.Emsdrugs.Fg_propc;
                    break;
                case "Quan_cur":
                    GetStockReqDTO reqDto = new GetStockReqDTO();
                    string id_mm = EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Id_mm;
                    string id_dep_phy = EmsHeadDO.Emsdrugs.Id_dep;
                    //reqDto.Id_dep = id_dep_phy;
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
                            return;
                        }
                    }
                    break;
                case "customercolumn_menu":
                    this.setTime_cur();
                    setQauntum(this.EmsHeadDO.Emsdrugs.Times_cur);
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
            updateTableCustomerComtrol();

        }
        /// <summary>
        /// 更新列表每一行自定义单元格显示信息
        /// </summary>
        void updateTableCustomerComtrol()
        {
            foreach (XDataRow row in gv.DataTable.Rows)
            {
                this.updateCustomerControlInfo(row, row.DataSource as EmsOrDrug);
            }
        }
        /// <summary>
        /// 更新用户自定义列单元格信息
        /// </summary>
        /// <param name="row"></param>
        /// <param name="drug"></param>
        void updateCustomerControlInfo(XDataRow row, EmsOrDrug drug)
        {
            if (drug == null)
            {
                return;
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_menu"))
            {
                if (drug.Quan_med == null)
                    drug.Quan_med = 0;
                if (drug.Name_unit_med == null)
                    drug.Name_unit_med = "";
                string strMed_unit = drug.Quan_med + drug.Name_unit_med;
                row.ColumnCellDict["customercolumn_menu"].SetValue(strMed_unit);
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_sale_unit"))
            {

                if (drug.Quan_cur == null)
                    drug.Quan_cur = 0;
                if (drug.Name_unit_sale == null)
                    drug.Name_unit_sale = "";
                string strMed_unit = drug.Quan_cur + drug.Name_unit_sale;
                row.ColumnCellDict["customercolumn_sale_unit"].SetValue(strMed_unit);
            }
        }

        void xapFormControl1_RefResult(object sender, RefResultEventArgs e)
        {
            //长临标志：根据选择的频次，默认读取BD_FREQ. fg_long显示长临标志。
            if (e.BindingFieldName == "Name_freq")
            {
                RefDataCollection data = e.RefResultSet;
                if (data.Count == 0)
                {
                    return;
                }
                string id_freq = data.FirstData["Id_freq"] as string;//获取字段值
                EmsHeadDO.Emsdrugs.Sd_frequnitct = data.FirstData["Sd_frequnitct"] as string;
                EmsHeadDO.Emsdrugs.Freqct = null;
                if (data.FirstData["Freqct"].ToString() != "")
                    EmsHeadDO.Emsdrugs.Freqct = int.Parse(data.FirstData["Freqct"].ToString());
                EmsHeadDO.Emsdrugs.Fg_long = data.FirstData["Fg_long"].ToString() == "Y" ? true : false;
                this.setTime_cur();
                setQauntum(this.EmsHeadDO.Emsdrugs.Times_cur);
                ////可将下面放到算法里
                //if (data.FirstData["Fg_prnor"].ToString() == "Y")// 备用医嘱 true 并且 长临为 临时
                //{
                //    XLabelBaseUserRender tmpRender = getControlByName("drugsUse", "fg_long");

                //    if (tmpRender.ValueCode == "False")
                //    {
                //        getControlByName("drugsUse", "dt_fail").Enabled = true;//临时医嘱失效日期                       
                //        EmsHeadDO.Emsdrugs.Dt_fail = cof.GetSpareEndTime(EmsHeadDO.Emsdrugs.Dt_begin_ui.Value);
                //        getControlByName("drugsUse", "bak_des").ValueText = "";
                //    }
                //    else
                //    {
                //        getControlByName("drugsUse", "dt_fail").Enabled = false;//长期医嘱失效日期禁用
                //        EmsHeadDO.Emsdrugs.Dt_fail = null;
                //        EmsHeadDO.Emsdrugs.Use_days = null;
                //        getControlByName("drugsUse", "bak_des").ValueText = "执行最小间隔时间：6小时。";
                //    }

                //    getControlByName("drugsUse", "bak_des").Enabled = true;


                //}
                //else
                //{
                //    getControlByName("drugsUse", "dt_fail").Enabled = false;//临时医嘱失效日期
                //    getControlByName("drugsUse", "bak_des").Enabled = false;
                //    EmsHeadDO.Emsdrugs.Dt_fail = null;
                //}
                ////首日执行 只针对频次周期类型为‘天’的医嘱才可录入和显示首日执行次数，其他情况该控件隐藏。

                //string name_freq = data.FirstData["Name"] as string;//获取字段值
                ////if (name_freq.Contains("日"))
                ////{
                ////    getControlByName("drugsUse", "quan_firday_mp").Enabled = true;//首日执行次数
                ////    getControlByName("drugsUse", "work_time").Enabled = true;//首日执行时间
                ////}
                ////else
                ////{
                ////    getControlByName("drugsUse", "quan_firday_mp").Enabled = false;//首日执行次数
                ////    getControlByName("drugsUse", "work_time").Enabled = false;//首日执行时间

                ////}
                //string code_freq = data.FirstData["Code"] as string;//获取字段值
                //if (code_freq == "once")
                //{
                //    EmsHeadDO.Emsdrugs.Fg_long = false;//长临标识 变临时
                //    //getControlByName("drugsUse", "fg_long").Enabled = false;// 

                //    EmsHeadDO.Emsdrugs.Dt_end_ui = EmsHeadDO.Emsdrugs.Dt_begin_ui;
                //}
                //else
                //{
                //    // getControlByName("drugsUse", "fg_long").Enabled = true;// 
                //}



            }
            else if (e.BindingFieldName.Equals("Name_unit_sale"))
            {
                this.setTime_cur();
                setQauntum(this.EmsHeadDO.Emsdrugs.Times_cur);
            }
            this.updateTableCustomerComtrol();
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



        }


        /// <summary>
        /// 根据频次获取变动用药的 日期集合
        /// </summary>
        /// <param name="id_freq">The id_freq.</param>
        /// Author:admin
        /// Date:2015-10-08
        //private void GetDoseDrugData(string id_freq)
        //{
        //    EmsHeadDO.Emsdrugs.EmsOrDoseDrug = cof.GetFreqVsTimes(id_freq, EmsHeadDO.Emsdrugs.Id_orsrv, EmsHeadDO.Emsdrugs.Id_or);
        //}
        public override void SaveBefore()
        {
            DrugWriteData();
            //OrderDataVerify ver = new OrderDataVerify();
            //if (!ver.DrugDataVerify(EmsHeadDO, this))
            //    VerifyOk = false;
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
            drug = emsDrug;
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

    }
}
