using System;
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
using iih.ci.ord.ciorder;
using iih.ci.ord.ciorder.cards;
using iih.ci.ord.ciorder.Validate;
using System.Linq;
using xap.rui.control.extentions;
using xap.rui.appfw;
using iih.ci.ord.ciorder.viewmodel.impext;
using xap.cli.sdk.render.Items;
using iih.mm.itf.material.d;
using xap.mw.core.data;
using iih.ci.ord.ciord.d;
using iih.ci.ord.ciorder.cards.drugext.dialogform;
using iih.ci.ord.cards.thread.dp;
using iih.ci.ord.opemergency.controls;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.controls.DataView;
using xap.cli.sdk.form;
using xap.cli.sdk.controls;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.oporder.cards
{
    public partial class OpOrderInfusionView : CiorderBaseControl
    {
        private bool bEdit_Note_or;
        private string txt_Note_or = "";

        public OpOrderInfusionView()
        {
            InitializeComponent();
            this.Load += new EventHandler(OrderInfusionView_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            this.xapFormControl1.RefResult += this.OnRefResult;
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            xapFormControl1.RefCanSelect += new EventHandler<RefCanSelectEventArgs>(xapFormControl1_RefCanSelect);
            xapFormControl1.AllowEditing += new EventHandler<AllowEditingEventArgs>(xapFormControl1_AllowEditing);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
            this.SheetName = "注射医疗单";
        
        }

        #region 变量定义区域
        XapFormGridControl gv;//, gv_change;// 药品商品表，变动用药
        Dictionary<string, UserRender> dic = new Dictionary<string, UserRender>();//界面控件集合
        private EmsOrDrug emsOrDrug=new EmsOrDrug();
        OrderDrugDesView desView = new OrderDrugDesView() { Dock = DockStyle.Fill };

        #endregion
        
        #region 构造函数区域

        #endregion

        #region 公开属性区域

        #endregion

        #region 事件发送区

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
            //foreach (EmsDrugItemDO item in EmsHeadDO.Emsdrugitems)
            //{
            //    listDrug.Add(item);
            //}

            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OpOrderInfusionView;// "20151023093809566GZQ";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = EmsHeadDO.Emsdrugs;
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);
        }
       
    
        public override void OnRefreshData(ciordems.d.EmsUIDTO headDo, object e)
        {
            if (headDo != null)
            {
                EmsHeadDO = headDo;
            }

            if (this.Created)
            {
                this.LoadData();
            }

            DrugReadData();
        }



        #endregion

        #region 内部事件区域
        void xapFormControl1_RefCanSelect(object sender, RefCanSelectEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                string name = (string)e.SelectingData["Name"];
                string id_srv = (string)e.SelectingData["Id_srv"];
                XapDataList<EmsOrDrug> drugs = cof.GetSrvMm(EmsHeadDO, id_srv,EmsHeadDO.PatInfo.Code_entp);
                if (drugs.Count == 1 && drugs[0].Id_mm == null)
                {
                    e.Cancel = true;
                    e.Message = string.Format("服务未绑定物品，请与信息科联系！");
                    return;
                }
                int i = 0;
                foreach (EmsOrDrug routeDo in EmsHeadDO.Emsdrugs.EmsOrDrugList)
                {
                    if (routeDo.Status != DOStatus.DELETED && routeDo.Name_srv == name)
                    {
                        i++;
                        if (i == 1)
                        {
                            e.Cancel = true;
                            e.Message = string.Format("因为重复，您选中的数据'{0}'禁止选中！",
                                (e.SelectingData == null) ? "Null" : e.SelectingData.DisplayText);
                            break;
                        }
                    }
                }

            }
        }
        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                e.WherePart = string.Format(" Sd_srvtp in ('010104','010204','010203','010103','010199')");

            }else if (e.BindingFieldName.Equals("Name_mm"))
            {
                EmsOrDrug drugDo = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
                if (drugDo.Id_srv == null) drugDo.Id_srv = "xxxx";
                e.WherePart = string.Format("id_mm in ({0})", cof.GetSrvMmStr(EmsHeadDO, drugDo.Id_srv));
            }else if (e.BindingFieldName.Equals("Name_dep"))
            {
                if (EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Str_mp_dep_ids != null && EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Str_mp_dep_ids != "")
                    e.WherePart = string.Format(" id_dep in({0})", EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Str_mp_dep_ids);
            }else if (e.BindingFieldName.Equals("Total_count_unit"))//计量单位
            {
                if (emsOrDrug.Str_unit_pkg_ids != null && emsOrDrug.Str_unit_pkg_ids != "")
                    e.WherePart = string.Format("id_measdoc in ({0})", emsOrDrug.Str_unit_pkg_ids);
            }else  if (e.BindingFieldName == "Name_route")
            {
                e.WherePart = string.Format("id_route in ({0})", new GetSrvVsRouteImp().GetDosageVsRounte("'" + string.Join("','", EmsHeadDO.Emsdrugs.EmsOrDrugList.Select(p => p.Id_srv).ToList()) + "'"));
            }else if (e.BindingFieldName.Equals("Name_unit_sale"))//计量单位
            {
                EmsOrDrug drug = xapFormControl1.GetFocused<EmsOrDrug>("drug");
                if (drug.Str_unit_pkg_ids != null && drug.Str_unit_pkg_ids != "")
                    e.WherePart = string.Format("id_measdoc in ({0})", drug.Str_unit_pkg_ids);
            }else if (e.BindingFieldName.Equals("Name_routedes"))
            {
                e.WherePart = string.Format("BD_ROUTE_DES.FG_ENTP_OP='Y'");
            }
            else if (e.BindingFieldName.Equals("Name_freq"))
            {
                e.WherePart = string.Format("FG_ACTIVE='Y'");
            }
        }
        public override void SaveBefore()
        {
            DrugWriteData();
        }
        void OrderInfusionView_Load(object sender, System.EventArgs e)
        {
            OnInit();
        }
        
        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            XTabControl tabControl = new XTabControl();
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            dic = tabs[0].Pages[0].DicUserRenders;
            
            gv = xapFormControl1.GetGridView("drug");//药品属性表
            gv.MouseClick += new MouseEventHandler(gv_MouseClick);
            gv.DataTable.DataDisplay += new EventHandler<XDataDisplayEventArgs>(xapFormControl1_DataDisplay);

            UserRender btnDel = this.xapFormControl1.GetUserRender("drugsUse", "del");//删除按钮
            btnDel.MouseClick += new MouseEventHandler(btnDel_MouseClick);

            UserRender btnAdd = this.xapFormControl1.GetUserRender("drugsUse", "btnAdd");//新增按钮
            btnAdd.MouseClick += new MouseEventHandler(btnAdd_MouseClick);

            SetGridPolicy(true);
            gv.ReadOnly = false;
            gv.DataTable.ReadOnly = false;

            //----------药品说明----------------------
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

        void Note_or_GotFocus(object sender, EventArgs e)
        {
            txt_Note_or = cof.getControlByName(xapFormControl1, "drugsUse", "note_or").ValueText;
        }

        void Note_or_LostFocus(object sender, EventArgs e)
        {
            this.bEdit_Note_or = !txt_Note_or.Equals(cof.getControlByName(xapFormControl1, "drugsUse", "note_or").ValueText);
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
        void xapFormControl1_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            if (e.Object is EmsOrDrug&&e.PropName.Equals("customercolumn_sale_unit")) { 
                e.Cancel = true;
            }
            else
            {
                e.Cancel = false;
            }
        }
        protected void xapFormControl1_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            var drug = e.Object as EmsOrDrug;

            // 更新用户自定义列信息
            this.updateCustomerControlInfo(row, drug);
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
        void tabControl1_SelectedIndexChanged(object sender, EventArgs e)
        {
            desView.ShowDrugDes(EmsHeadDO.Emsdrugs.EmsOrDrugList);
        }

        void btnAdd_MouseClick(object sender, MouseEventArgs e)
        {
            //EmsHeadDO.Emsdrugs.EmsOrDrugList.AddNew();
            if (this.EmsHeadDO.Emsdrugs.EmsOrDrugList.Count(p => String.IsNullOrEmpty(p.Id_srv) && String.IsNullOrEmpty(p.Sd_srvtp)) > 0)
            {
                this.ShowInfo("已经追加了一条空行记录，请先填写完整");
                return;
            }
            EmsOrDrug emsordrug = new EmsOrDrug();
            EmsHeadDO.Emsdrugs.EmsOrDrugList.Add(emsordrug);
            xap.cli.sdk.controls.DataView.XDataRow row = gv.DataTable.Rows.DataSourceRow[emsordrug];
            xap.cli.sdk.controls.DataView.XCellRender cell = row.ColumnCellDict["Name_srv"];
            gv.ShowEditor(cell); 
        }
        void btnDel_MouseClick(object sender, MouseEventArgs e)
        {
            if (gv.GetFocusedRow() != null)
            {
                EmsOrDrug delDo = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
                cof.DeleteOrDrug(EmsHeadDO, delDo);
            }
            else
            {
                this.ShowInfo("请选择一条数据删除！");
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
            var mmContainer = new XBaseControl();
            mmContainer.Size = new Size(473, 160);

            var query = from items in ds orderby items.Fact_count descending select items;

            var mm = new ExtMmRefView(LogicEx.GetInstance().ConvertDataSouse<EmsOrDrug>(query.ToList()), def,false);
            
            mm.Dock = DockStyle.Fill;
            mmContainer.AddRender(mm);
            var popWindow = new XContextForm(mmContainer);
            popWindow.Show(atPoint);
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
                        popWindow.Close();
                        return;
                    }

                }
                #endregion
                cof.CopyTo(mmDrug, orDrug, "Id_srv", "Name_srv");
                cof.concateMMSpecAndName(orDrug);
                orDrug.Fg_mm = true;
                popWindow.Close();
            };
            mm.Enabled = canEdit;
        }


        void gv_MouseClick(object sender, MouseEventArgs e)
        {
            //if (gv.FocusedRowHandle < 0) return;
          
            EmsOrDrug emsDrug = gv.GetFocusedRow().RowDataSource as EmsOrDrug;
            this.emsOrDrug = emsDrug;
            EmsHeadDO.Emsdrugs.Quan_med = emsDrug.Quan_med;
            if (emsDrug.Id_unit_med != null)
                EmsHeadDO.Emsdrugs.Id_unit_med = emsDrug.Id_unit_med;
            EmsHeadDO.Emsdrugs.Name_unit_med = emsDrug.Name_unit_med;
            EmsHeadDO.Emsdrugs.Quan_base = emsDrug.Quan_base;
            EmsHeadDO.Emsdrugs.Id_unit_base = emsDrug.Id_unit_base;
            EmsHeadDO.Emsdrugs.Name_unit_base = emsDrug.Name_unit_base;
            EmsHeadDO.Emsdrugs.Id_total_count_unit = emsDrug.Id_unit_sale;
            EmsHeadDO.Emsdrugs.Total_count_unit = emsDrug.Name_unit_sale;
            EmsHeadDO.Emsdrugs.Total_count = emsDrug.Quan_cur;

            EmsOrDrug drug = xapFormControl1.GetFocused<EmsOrDrug>("drug");
            XDataRow drow = sender as XDataRow;
            if (gv.GetFocusedRow().ClickCell.FieldName == "Name_mm")
            {
                EmsOrDrug emsordrug = gv.GetFocusedRow<EmsOrDrug>();
                if (emsordrug.Fg_ctm != null && emsordrug.Fg_ctm == true) return;//自定义服务时不能选择物品 2016-07-05 zwq
                string id_srv = (gv.GetFocusedRow().RowDataSource as EmsOrDrug).Id_srv;//拿到 点击的药品对应服务的id_srv
                if (string.IsNullOrEmpty(id_srv)) return;
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
            
            //}
        }


        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            EmsHeadDO.Emsdrugs.EmsOrDrug = cof.MmSortList(EmsHeadDO.Emsdrugs.EmsOrDrug);
            gv.DataTable.DataSource = EmsHeadDO.Emsdrugs.EmsOrDrugList;
            drugBindPropertyEventAndCacheUnimed(EmsHeadDO.Emsdrugs.EmsOrDrugList);
            
            foreach (EmsOrDrug item in EmsHeadDO.Emsdrugs.EmsOrDrugList)
            {
                if (true == item.Fg_ctm)
                {
                    item.PropertyChanged += new System.ComponentModel.PropertyChangedEventHandler(item_PropertyChanged);
                }
                if (!cacheUnitMed.ContainsKey(item.Id_unit_med))
                {
                    cacheUnitMed.Add(item.Id_unit_med, item.Name_unit_med);
                }
            }
            if (gv != null)
            {
                gv.DataTable.DataSource = EmsHeadDO.Emsdrugs.EmsOrDrugList;
                //加载时为自定义服务药品列表绑定事件，并缓存自定义服务的剂量单位 zwq 2016-07-18
                drugBindPropertyEventAndCacheUnimed(EmsHeadDO.Emsdrugs.EmsOrDrugList);
                cof.threadSetMaterialInfoOfDrug(EmsHeadDO.Emsdrugs.EmsOrDrug, middle);

            }
            fgoutstate();
            SetGridPolicy(!IsReadOnly);
            if(EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_skintest!=null&&EmsHeadDO.Emsdrugs.EmsOrDrugList[0].Fg_skintest==true){
                SkinTestLogic logic = new SkinTestLogic( EmsHeadDO.PatInfo);
                logic.skinTestLogic(EmsHeadDO.Emsdrugs.EmsOrDrugList[0]);
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
                    SkinTestLogic logic = new SkinTestLogic( EmsHeadDO.PatInfo);
                    logic.skinTestLogic(EmsHeadDO.Emsdrugs.EmsOrDrugList[0]);
                }
                setEndTime();
            }
            updateTableCustomerComtrol();
        }
        OrderSrvDoseViewModel drugChangeModel = new OrderSrvDoseViewModel();
        //DrugChangeDTO[] drugchange;
        void chkdoseDrug_ValueChanged(object sender, EventArgs e)
        {
            XLabelBaseUserRender check = sender as XLabelBaseUserRender;
            //if (gv_change != null && check != null)
            //    gv_change.Enabled = check.Checked;

            if (check.Checked)
            {
                  //drugchange = drugChangeModel.GetTime(EmsHeadDO.Emsdrugs.Id_freq);
                //gv_change.Enabled = true;
                //gv_change.OptionsBehavior.Editable = true;

            }
            else
            {
                  //drugchange = null;
            }
            //gv_change.GridControl.DataSource = drugchange;
            ((XNumbericUpDown)((XLabelBaseUserRender)xapFormControl1.GetUserRender("drugsUse", "times_mp_in")).UserRender).MinValue = 0;

        }
        
        
        //void btnOK_MouseClick(object sender, MouseEventArgs e)
        //{
        //    xapFormControl1.SaveForm();
        //    this.Save(this);
        //    EmsHeadDO.Sd_srvtp="";
 
        //}
        //频次
        protected override void OnRefResult(object sender, RefResultEventArgs e)
        {
              RefDataCollection data = e.RefResultSet;
            if (data == null || data.Count == 0)
            {
                this.ShowInfo("频次为空");
                return;
            }
            if (e.BindingFieldName == "Name_freq")
            {
                string id_freq = data.FirstData["Id_freq"] as string;//获取字段值
                string frequnit = data.FirstData["Id_freq"] as string;
                int freqct = int.Parse(data.FirstData["Freqct"].ToString());
                EmsHeadDO.Emsdrugs.Freqct = int.Parse(data.FirstData["Freqct"].ToString());
                EmsHeadDO.Emsdrugs.Sd_frequnitct = data.FirstData["Sd_frequnitct"] as string;
                GetDoseDrugData(id_freq);
                EmsHeadDO.Emsdrugs.Work_time = cof.GetWorkTime(id_freq);
                this.setTime_cur();
                setQauntum(this.EmsHeadDO.Emsdrugs.Times_cur);
                fgoutstate();
            }

            //新增时候 参照写会
            EmsOrDrug drugNew = xapFormControl1.GetFocused<EmsOrDrug>("drug");
            if (e.BindingFieldName.Equals("Name_srv"))
            {
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
                    return;
                }
                int focuIndex = gv.DataTable.FocusedRow.Index;
                if (data.FirstData["Id_srv"] == null) return;
                string id_srv = data.FirstData["Id_srv"] as string;
                string fg_ctm = data.FirstData["Fg_ctm"] as string;
                if (fg_ctm == null || "N" == fg_ctm)
                {
                    drugNew.PropertyChanged -= new System.ComponentModel.PropertyChangedEventHandler(item_PropertyChanged);
                    XapDataList<EmsOrDrug> drugs = cof.GetSrvMm(EmsHeadDO, id_srv, EmsHeadDO.PatInfo.Code_entp);

                    if (drugs.Count > 0)
                    {
                        //执行科室填充
                        DrugUtils.fillExecDetps(drugs, EmsHeadDO.Emsdrugs.Id_route, EmsHeadDO.PatInfo);
                        foreach (EmsOrDrug ems in drugs)
                        {
                            if (EmsHeadDO.Emsdrugs.EmsOrDrug.Contains(ems))
                                continue;
                            EmsHeadDO.Emsdrugs.EmsOrDrug.Add(ems);
                        }
                        EmsOrDrug drugRef = drugs.FirstOrDefault();
                        if (drugRef.Fg_skintest != null && drugRef.Fg_skintest == true)
                        {
                            SkinTestLogic logic = new SkinTestLogic(EmsHeadDO.PatInfo);
                            if (logic.skinTestLogic(drugRef).Equals("0"))
                            {
                                return;
                            }

                        }
                        cof.CopyTo(drugRef, drugNew, "Id_srv", "Name_srv");
                        cof.concateMMSpecAndName(drugNew);
                        cof.concateExtNote(new XapDataList<EmsOrDrug> { drugNew }, EmsHeadDO.PatInfo, EmsHeadDO);
                        //新启动一个线程设置服务的物品库存信息
                        cof.threadSetMaterialInfoOfDrug(drugs, middle);
                        this.setTime_cur();
                        setQauntum(this.EmsHeadDO.Emsdrugs.Times_cur);
                        //毒麻药品核对患者信息
                        //if (cof.verifyPois(drugNew.Fg_pois.Value, drugNew.Sd_pois))
                        //{
                        //    OrSrvAgentInfoDO agentInfo = cof.newOrSrvAgentInfoDOFromBanner(EmsHeadDO.PatInfo);
                        //    if (drugNew.Agentinfolist == null) {
                        //        drugNew.Agentinfolist = new FArrayList();
                        //    }
                        //    drugNew.Agentinfolist.Add(agentInfo);
                        //    CheckPatAgentInfoDialog dialog = new CheckPatAgentInfoDialog(agentInfo);
                        //    dialog.ShowDialog();
                        //}
                    }
                    else
                    {
                        this.ShowInfo("服务未绑定物品，请与信息科联系！", "提示");
                        drugNew.Id_srv = "";
                        drugNew.Name_srv = "";
                        drugNew.Spec_mm = "";
                        drugNew.Quan_med = null;
                        drugNew.Name_unit_med = "";
                        drugNew.Quan_cur = null;
                        drugNew.Name_unit_sale = "";
                        return;
                    }
                }
                else
                {
                    //参照回写是自定义服务时的操作
                    handleRefResultSrvIsFtmSrv(drugNew);
                }
               
            }
            this.updateTableCustomerComtrol();
        }


        void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {//0001AA10000000016LYA
            //e.PropName = "Id_freq";

            switch (e.PropName)//计算结束日期
            {

                case "Use_days"://医嘱天数
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
                        fgoutstate();
                    //设置停止时间和停止标志
                        setEndTime();
                    //}
                    break;

                //case "Quan_med":
                //    emsOrDrug.Quan_med = EmsHeadDO.Emsdrugs.Quan_med;
                //    break;
                //case "Name_unit_med":
                //    if (EmsHeadDO.Emsdrugs.Name_unit_med != null)
                //    {
                //        emsOrDrug.Name_unit_med = EmsHeadDO.Emsdrugs.Name_unit_med;
                //        emsOrDrug.Id_unit_med = EmsHeadDO.Emsdrugs.Id_unit_med;
                //    }
                //    break;
                //case "Quan_base":
                //    if (EmsHeadDO.Emsdrugs.Quan_base != null)
                //        emsOrDrug.Quan_base = EmsHeadDO.Emsdrugs.Quan_base;


                //    break;
                //case "Total_count":
                //    emsOrDrug.Id_pgku_cur = EmsHeadDO.Emsdrugs.Id_total_count_unit;
                //    if (EmsHeadDO.Emsdrugs.Id_total_count_unit == null)
                //        emsOrDrug.Id_pgku_cur = EmsHeadDO.Emsdrugs.Id_unit_med;
                //    if (EmsHeadDO.Emsdrugs.Total_count != null)
                //        emsOrDrug.Quan_cur = (int)EmsHeadDO.Emsdrugs.Total_count.Value;
                //    break;
                //case "Name_unit_base":
                //    if (EmsHeadDO.Emsdrugs.Name_unit_base != null)
                //        emsOrDrug.Name_unit_base = EmsHeadDO.Emsdrugs.Name_unit_base;

                //    break;
                //case "Id_unit_base":
                //    if (EmsHeadDO.Emsdrugs.Id_unit_base != null)
                //        emsOrDrug.Id_unit_base = EmsHeadDO.Emsdrugs.Id_unit_base;

                //    break;
                case "Fg_self":
                    if (EmsHeadDO.Emsdrugs.Fg_self == true)
                        EmsHeadDO.Emsdrugs.Fg_outp = !EmsHeadDO.Emsdrugs.Fg_self;
                    break;
                case "Fg_outp":
                    if (EmsHeadDO.Emsdrugs.Fg_outp == true)
                    {
                        EmsHeadDO.Emsdrugs.Fg_self = !EmsHeadDO.Emsdrugs.Fg_outp;
                        //ctlTotal.Enabled = true;
                    }
                    else
                    {
                        EmsHeadDO.Emsdrugs.Total_count = null;
                        //ctlTotal.Enabled = false;
                    }
                    break;
                case "Fg_treat":
                    EmsHeadDO.Emsdrugs.Fg_propc = !EmsHeadDO.Emsdrugs.Fg_treat;
                    break;
                case "Fg_propc":
                    EmsHeadDO.Emsdrugs.Fg_treat = !EmsHeadDO.Emsdrugs.Fg_propc;
                    break;
                case "customercolumn_menu":
                    this.setTime_cur();
                    setQauntum(this.EmsHeadDO.Emsdrugs.Times_cur);
                        
                    break;
                case "Fg_mp_in":
                    this.fgoutstate();
                    break;
                case "Name_routedes":
                    if (!bEdit_Note_or)
                    {
                        cof.SetNoteOr(this.EmsHeadDO);
                    }
                    break;

            }
            this.updateTableCustomerComtrol();
        }
      

        #endregion

        #region 辅助处理函数
        public override IValidate GetOrdValidate()
        {
          return  new OpOrderInfusionValidate();
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
        /// Drugs 表单药品剂量数据写到药品do
        /// </summary>
        /// Author:admin
        /// Date:2015-10-21
        private void DrugWriteData()
        {
            return;
            /*
            if (EmsHeadDO.Emsdrugs.EmsOrDrugList.Count == 0) return;
            EmsOrDrug orDrug = EmsHeadDO.Emsdrugs.EmsOrDrugList[0];
            //orDrug.Name_mm = EmsHeadDO.Emsdrugs.Name_mm;//药品名称
            //orDrug.Spec_mm = EmsHeadDO.Emsdrugs.Spec_mm;//规格
            //orDrug.Name_heath = EmsHeadDO.Emsdrugs.Name_heath;//医保类型
            //orDrug.Limit = EmsHeadDO.Emsdrugs.Limit;//限制报销条件
            //orDrug.Price = EmsHeadDO.Emsdrugs.Price;//参考价格
            if (EmsHeadDO.Emsdrugs.Total_count != null)
                orDrug.Quan_cur = (int)EmsHeadDO.Emsdrugs.Total_count;//总量
            orDrug.Id_unit_base = EmsHeadDO.Emsdrugs.Id_unit_base;
            orDrug.Name_unit_base = EmsHeadDO.Emsdrugs.Name_unit_base;
            orDrug.Id_unit_med = EmsHeadDO.Emsdrugs.Id_unit_med;
            orDrug.Name_unit_med = EmsHeadDO.Emsdrugs.Name_unit_med;
            orDrug.Id_pgku_cur = EmsHeadDO.Emsdrugs.Id_total_count_unit;//基本包装单位，如：片
            orDrug.Name_pgku_cur = EmsHeadDO.Emsdrugs.Total_count_unit;
            if (EmsHeadDO.Emsdrugs.Id_total_count_unit == null)
            {
                //orDrug.Id_pgku_cur =  EmsHeadDO.Emsdrugs.Id_unit_med ;
                //orDrug.Name_pgku_cur = EmsHeadDO.Emsdrugs.Name_unit_base;
            }
            //if (EmsHeadDO.Emsdrugs.Quan_base != null)
                //orDrug.Quan_base = EmsHeadDO.Emsdrugs.Quan_base;
                orDrug.Quan_med = EmsHeadDO.Emsdrugs.Quan_med;
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
             * if (EmsHeadDO.Emsdrugs.EmsOrDrugList.Count == 0) return;
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
            */
        }

        /// <summary>
        /// Gets the name of the control by.
        /// </summary>
        /// <param name="table">The table.</param>
        /// <param name="name">The name.</param>
        /// <returns></returns>
        /// Author:admin
        /// Date:2015-08-29
        private XLabelBaseUserRender getControlByName(string table, string name)
        {
            if (dic.Count == 0) return null;
            return dic[table + '_' + name] as XLabelBaseUserRender;
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
        /// 设置在院执行的可编辑状态和执行次数
        /// </summary>
        private void fgoutstate()
        {
            if (this.EmsHeadDO.Emsdrugs.Fg_mp_in == true)
            {
                (this.xapFormControl1.GetUserRender("drugsUse", "times_mp_in") as XLabelBaseUserRender).Enabled = true;
                int total = LogicEx.GetInstance().GetDrugUseTotalCount(this.EmsHeadDO);
                ((this.xapFormControl1.GetUserRender("drugsUse", "times_mp_in") as XLabelBaseUserRender).UserRender as XNumbericUpDown).MaxValue = total;
                if ((this.EmsHeadDO.Emsdrugs.Times_mp_in == null ? 0 : this.EmsHeadDO.Emsdrugs.Times_mp_in) > total)
                {
                    this.EmsHeadDO.Emsdrugs.Times_mp_in = total;
                }
            }
            else {
                (this.xapFormControl1.GetUserRender("drugsUse", "times_mp_in") as XLabelBaseUserRender).Enabled = false;
                (this.xapFormControl1.GetUserRender("drugsUse", "times_mp_in") as XLabelBaseUserRender).ValueText = "";
            }
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

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {



        }

        #endregion
    }
}
