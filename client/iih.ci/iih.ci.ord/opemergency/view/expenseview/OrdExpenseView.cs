
using System;
using System.Collections.Generic;
using System.Linq;
using xap.rui.control.forms.control;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.ciordems.d;
using xap.rui.control.extentions;
using iih.ci.ord.opemergency.view.expenseview.model;
using xap.rui.appfw;
using xap.rui.control.forms.view;
using iih.ci.ord.ems.d;
using iih.en.pv.dto.d;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.ciorder.d;
using System.Windows.Forms;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using xap.mw.core.data;
using iih.bl.hp.bdhpindicationdto.d;
using iih.ci.ord.opemergency.dialog;
using iih.ci.ord.ciorder.utils;
using xap.cli.sdk.controls.DataView.Model;
using iih.bd.bc.udi;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.model;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.opemergency.ems.common;
using iih.bd.iih.bd.bc.udi;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.view.expenseview
{
    /// <summary>
    /// <para>描    述 :  费用清单             			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.view.expenseview    </para>    
    /// <para>类 名 称 :  OrderExpenseView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  2016/7/12 11:10:34             </para>
    /// <para>更新时间 :  2016/7/12 11:10:34             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class OrdExpenseView : BaseFormBizView
    {
        public enum EuRefreshState{ InitState=-1, UnchangedState = 0, NeedRefreshState = 1};
        #region 变量
        private XapFormGridControl tableGridControl;
        private ExpenseModel model;
        private EmsViewType emsViewType;
        private int needRefresh; // -1, 初始值，没有切换过费用页签；0，切换过费用页签，已经刷新过了；1，切换过费用页签，但费用页签需要刷新
        private bool enableEdit;
        private bool isDirty;
        #endregion

        #region 构造方法


        public OrdExpenseView(IEventDelegate o, bool enable = true, EmsViewType itemType = EmsViewType.EmptyEmsViewType)
            : base(o)
        {
            needRefresh = -1;

            isDirty = false;

            this.Name = "费用";
            this.emsViewType = itemType;

            this.enableEdit = enable;

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_OrdExpenseView/*"20160629070241175OMW"*/);

            this.RegisteFormEventImpl();

            //this.Load += OrderExpenseView_Load;
            //GetXapFormControl().FormCreated += OnXapFormControl_FormCreated;
        }

        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            OnInit();
        }
        

        #endregion

        #region 接口

        public OrdExpenseView SetNeedRefresh(int f)
        {
            this.needRefresh = f;
            
            return this;
        }

        public int NeedRefresh()
        {
            return needRefresh;
        }

        public bool IsDirty()
        {
            return isDirty;
        }

        public bool EnableEdit()
        {
            return this.enableEdit;
        }

        public OrdExpenseView SetEmsContext(object vm, CiEmsDTO sm)
        {
            if (sm == null) {
              
                this.SetNeedRefresh((int)EuRefreshState.InitState);
                return this;
            }
            this.GetModel().SetEmsViewModel(vm).SetEmsSaveModel(sm);

            return this;
        }


        public OrdExpenseView ResetModel(Ent4BannerDTO ent, EmsViewType type, XapDataList<EmsOrDrug> ds)
        {
            if (this.emsViewType != type || this.model == null) {
                this.emsViewType = type;
                this.model = ExpenseModelWith(type, ds);

            }
            this.model.SetEnt4BannerDTO(ent);
            return this;
        }

        public ExpenseModel GetModel()
        {
            return this.model;
        }

        #endregion

        #region 内部事件
        protected override void OnXapFormControl_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            var drug = e.Object as EmsOrDrug;
  
            this.UpdateCustomerControlInfo(row, drug);
        }
        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            var formControl = sender as XapFormControl;
            if (formControl != null) {
                tableGridControl = formControl.GetGridView(BaseFormBizView.FORM_BODY_PAGECODE);

                tableGridControl.MouseClick += OnXapFormControl_tableGridMouseClick;
                tableGridControl.DataTable.MultiCheckChanging += OnXapFormControl_MutilChecking;
                tableGridControl.DataTable.SelectedRowChanging += OnGridViewControl_SelectRowChanging;
                HandleHideGridColums();
            }

        }
        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            tableGridControl.DataTable.Columns["Fg_treat"].ReadOnly = true;
            //非医保患者隐藏自费列
            if (this.isHideSelfpay(this.GetModel().getEnt4BannerDTO()))
            {
                if (tableGridControl.DataTable.Columns["Fg_selfpay"].Visible == true) {
                    
                    tableGridControl.DataTable.Columns["Fg_selfpay"].Visible = false;
                }
            }
        }
        void OnXapFormControl_MutilChecking(object sender, MutilCheckingEventArgs e)
        {
            if (tableGridControl != null && tableGridControl.DataTable != null && e.RowIndex >= 0 && e.RowIndex < tableGridControl.DataTable.Rows.Count) {
                var drug = tableGridControl.DataTable.Rows[e.RowIndex].DataSource as EmsOrDrug;
                e.Cancel = DisableEditSrv(drug);
            }
        }
        void OnGridViewControl_SelectRowChanging(object sender, XSelectedRowChangingEventArgs e)
        {
            EmsOrDrug drug = (sender as XDataRow).DataSource as EmsOrDrug;
            e.Cancel = DisableEditSrv(drug); ;
        }

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            EmsOrDrug dataSource = e.Object as EmsOrDrug;

            if (!this.enableEdit) {
                e.Cancel = true;
                return;
            }

            // 费用描述字段不能编辑
            if (e.PropName.Equals("Des"))
            {
                e.Cancel = true;

                return;
            }
            // 如果频次为 Once ,禁止修改总量 -- 取消总量限制修改
            if ((e.PropName.Equals("Use_days") /*|| e.PropName.Equals("customercolumn_sale_unit")*/) && BdSrvDictCodeConst.SD_FREQUNIT_ONCE.Equals(dataSource.Sd_frequnitct))
            {
                
                e.Cancel = true;
            }
            else
            {
                e.Cancel = DisableEditHP(e.PropName, dataSource, DisableEditSrv(dataSource));
            }

           
        }

        /// <summary>
        /// 允许编辑医保列
        /// </summary>
        /// <param name="o"></param>
        /// <returns></returns>
        private Boolean DisableEditHP(string propName, EmsOrDrug dataSource, bool def)
        {
            if (propName.Equals("Fg_selfpay")) {
                FArrayList bdhpdtos = dataSource.BdHpIndicationDTO;
                if (bdhpdtos == null) {
                    bdhpdtos = new FArrayList();
                    BdHpIndicationDTO dto = HpJudgeUtil.getInstance().getBdHpIndicationDTO(dataSource.Id_srv, dataSource.Id_mm, this.GetModel().getEnt4BannerDTO());
                    if (dto != null) {
                        bdhpdtos.Add(dto);
                    }
                    dataSource.BdHpIndicationDTO = bdhpdtos;
                }
                //药品可以编辑
                if (hpCanEdit()) {
                    //符合医保判断条件，并且医保使用症为true的时候才可以操作
                    if (dataSource.BdHpIndicationDTO == null || dataSource.BdHpIndicationDTO.Count == 0 || string.IsNullOrEmpty((dataSource.BdHpIndicationDTO[0] as BdHpIndicationDTO).Code_hpindicjudged))
                    {
                        return true;
                    }
                    else
                    {
                        return dataSource.Fg_treat == null ? true : !(bool)dataSource.Fg_treat;
                    }
                }else{
                    return true;
                }
            }
            return def;
        }

        /// <summary>
        /// 允许编辑项目
        /// </summary>
        /// <param name="o"></param>
        /// <returns></returns>
        private Boolean DisableEditSrv(EmsOrDrug o)
        {
            if (null == o)
            {
                return false;
            }
            return !this.allowEdit || (o.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN ||
                o.Eu_sourcemd == (int)OrSrvSourceFromEnum.AGENTFROMPRIMD ||
                o.Eu_sourcemd == (int)OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD);
        }

        protected override void OnXapFormControl_DataVisible(object sender, DataVisibleEventArgs e)
        { 
            var drug = e.Data as EmsOrDrug;

            e.Visible = !drug.IsDELETED && (drug.Fg_bl != null && drug.Fg_bl.Value);
        }

        protected override void OnXapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (e.PropName.Equals("Use_days") || e.PropName.Equals("customercolumn_med_unit")) {
                var gv = sender as XapFormGridControl;
                if (gv != null && gv.DataTable.Rows.DataSourceRow.ContainsKey(e.Data) &&
                    gv.DataTable.Rows.DataSourceRow[e.Data] != null) {
                    XDataRow row = gv.DataTable.Rows.DataSourceRow[e.Data];
                    this.GetModel().ReCalculateInfo(e.Data as EmsOrDrug);
                    this.UpdateCustomerControlInfo(row, e.Data as EmsOrDrug);
                }

            }
            else if (e.PropName.Equals("customercolumn_sale_unit")) {
                var gv = sender as XapFormGridControl;
                if (gv != null && gv.DataTable.Rows.DataSourceRow.ContainsKey(e.Data) &&
                    gv.DataTable.Rows.DataSourceRow[e.Data] != null) {
                    XDataRow row = gv.DataTable.Rows.DataSourceRow[e.Data];
                    EmsOrDrug newDrug = e.Data as EmsOrDrug;
                    if (null == newDrug.Price) {
                        newDrug.Price = this.GetLogicEx().getSrvNotMMPri(newDrug.Id_srv, newDrug.Id_pri); // 服务参照，没有把定价模式 id_primd 带出来--日后修改参照
                    }

                    if (newDrug.Quan_cur == null || newDrug.Quan_cur == 0) {
                        newDrug.Quan_cur = 1;
                    }
                    newDrug.Totalprice = newDrug.Price * newDrug.Quan_cur;
                    this.UpdateCustomerControlInfo(row, e.Data as EmsOrDrug);
                }
            }

            this.SentNotify(EventCodeType.NM_EXPENSE_DATACHANGED, e.PropName, e.Data as EmsOrDrug);
        }


        void OnXapFormControl_tableGridMouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            this.model.SetCurrentSelect((sender as XDataRow).Index);
            if ((sender as XDataRow).ClickCell.FieldName.Equals("Fg_treat") && this.hpCanEdit()) {
                this.ShowHpDialog(sender);
            }
        }

        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            var unContains = new String[] { "Sv", "Id_orsrv", "Id_or_rel", "Status" };
            var drug = e.DataObject as EmsOrDrug;
            if (e.BindingFieldName.Equals("Name_srv") && !e.RefResultSet.IsEmpty) {
                if (e.RefResultSet.IsEmpty) {
                    this.UnRegFormEvent_DataChanged();
                   
                    GetLogicEx().Clear<EmsOrDrug>(drug, unContains);
                    this.RegFormEvent_DataChanged();
                    return;
                }
                if (this.model.HasSameFeeSrv(drug))
                {
                    this.ShowInfo("已经存在相同的费用服务");
                    this.UnRegFormEvent_DataChanged();
                    this.GetLogicEx().Clear<EmsOrDrug>(drug, unContains);
                    this.RegFormEvent_DataChanged();
                    return;
                }
                this.model.LoadEmsOrDrug(drug);
                
                

            }
            else if (e.BindingFieldName.Equals("Name_freq")) {

                this.model.ReCalculateInfo(drug);
            }
            //
            this.UpdateCustomerControlInfo(tableGridControl.GetFocusedRow(), drug);

            this.SentNotify(EventCodeType.NM_EXPENSE_DATACHANGED);
        }

        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            var drug = e.DataObject as EmsOrDrug;

            if (e.BindingFieldName.Equals("Name_srv")) {
                //  this.FireSelected(this.model.orConfirm);
                var sql = this.WherePartWith(this.Context.Org.Id_org, this.Context.Dept.Id_dep);
                if (sql != null) {
                    e.WherePart = sql;
                }
            }
            else if (e.BindingFieldName.Equals("Name_mp_dep") && drug.getAttrVal("str_id_mp_deps") != null) {
                e.WherePart = String.Format("id_dep in({0})", drug.getAttrVal<String>("str_id_mp_deps"));
            }
        }



        #endregion

        #region 辅助方法
        void UpdateCustomerControlInfo(XDataRow row, EmsOrDrug drug)
        {
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_med_unit")) {
                if (drug.Quan_med == null)
                    drug.Quan_med = 0;
                if (drug.Name_unit_med == null)
                    drug.Name_unit_med = "";
                string strMed_unit = drug.Quan_med + drug.Name_unit_med;
                row.ColumnCellDict["customercolumn_med_unit"].SetValue(strMed_unit);
                row.ColumnCellDict["customercolumn_med_unit"].HasError = drug.Quan_med == 0;
                row.ColumnCellDict["customercolumn_med_unit"].ErrorText = drug.Quan_med == 0 ? "数值不能为 0" : null;
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_sale_unit")) {

                if (drug.Quan_cur == null)
                    drug.Quan_cur = 0;
                if (drug.Name_unit_sale == null)
                    drug.Name_unit_sale = "";
                string strMed_unit = drug.Quan_cur + drug.Name_unit_sale;
                row.ColumnCellDict["customercolumn_sale_unit"].SetValue(strMed_unit);
                row.ColumnCellDict["customercolumn_sale_unit"].HasError = drug.Quan_cur == 0;
                row.ColumnCellDict["customercolumn_sale_unit"].ErrorText = drug.Quan_cur == 0 ? "数值不能为 0" : null;
            }
        }

        public String WherePartWith(string idorg, string iddep)
        {
            var srvScopeSql = this.Context.GetParam<String>(iddep, ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);// qryservice.getCiSrvCondition(iddep, ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);
            if (srvScopeSql == null)
                srvScopeSql = this.Context.GetParam<String>(idorg, ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee); // qryservice.getCiSrvCondition(idorg, ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);

            return srvScopeSql + " and bd_srv.fg_use_op='Y' ";
        }

        protected bool hpCanEdit()
        {
            CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
            //保外诊断标识
            string eu_hpbeyond = ciEnContextDTO.Eu_hpbeyond;
            //高端商保
            bool isHighBusiness = false;
            if (ciEnContextDTO.Ent4BannerDTO.Sd_hptp != null && ciEnContextDTO.Ent4BannerDTO.Sd_hptp.StartsWith("2"))
            {
                isHighBusiness = true;
            }
            //医保是否启用标识
            //this.Context.GetOrgParam<bool>(ICiOrdNSysParamConst.SYS_PARAM_IsMedicalInsuranceEnable);
            if (this.enableEdit && !isHighBusiness/*不是高端商保*/ &&true == ciEnContextDTO.Fg_hpfundpay && HpBeyondEnum.HPDIAG.Equals(ciEnContextDTO.Eu_hpbeyond)/*保内诊断*/ && isMedicalInsuranceEnable && this.opMedInsuranceAuditHandel == 0)
            {
                return true;
            }
            return false;
        }
        public void ShowHpDialog(object sender)
        {
            var row = sender as XDataRow;
            EmsOrDrug emsordrug = row.DataSource as EmsOrDrug;
            if (emsordrug != null)
            {
                if (row.ClickCell.FieldName.Equals("Fg_treat"))
                {
                    FArrayList bdhpdtos = emsordrug.BdHpIndicationDTO;
                    if (bdhpdtos == null)
                    {
                        bdhpdtos = new FArrayList();
                        BdHpIndicationDTO dto = HpJudgeUtil.getInstance().getBdHpIndicationDTO(emsordrug.Id_srv, emsordrug.Id_mm, this.GetModel().getEnt4BannerDTO());
                        if (dto != null)
                        {
                            bdhpdtos.Add(dto);
                        }
                        emsordrug.BdHpIndicationDTO = bdhpdtos;
                    }
                    if (bdhpdtos != null && bdhpdtos.Count > 0)
                    {
                        BdHpIndicationDTO bdhpdto = bdhpdtos[0] as BdHpIndicationDTO;
                        string code_hpindicjudged = bdhpdto.Code_hpindicjudged;
                        bool? isDefault = null;
                        if (code_hpindicjudged == "12")
                        {
                            isDefault = emsordrug.Fg_treat;
                        }
                        if (code_hpindicjudged != null)
                        {
                            switch (code_hpindicjudged)
                            {
                                case "12":
                                case "21":
                                    BdHpIndicationDTOForm dialog = new BdHpIndicationDTOForm(emsordrug.Limit, emsordrug.Name_srv, isDefault);
                                    DialogResult dialogResutl = dialog.ShowDialog();
                                    if (dialogResutl == DialogResult.OK)
                                    {
                                        emsordrug.Fg_treat = true;
                                        emsordrug.Fg_selfpay = false;
                                        emsordrug.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED;//0不需要判断，1待判断，2已判断;
                                    }
                                    else if(dialogResutl == DialogResult.No)
                                    {
                                        emsordrug.Fg_treat = false;
                                        emsordrug.Fg_selfpay = true;
                                        emsordrug.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED;//0不需要判断，1待判断，2已判断;
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }

        #endregion

        #region 覆盖方法
        public override void Refresh(object param = null)
        {

            //if (needRefresh)
            {
                this.LoadData();
            }

        }


        public override BaseFormBizView ClearContext()
        {
            if (this.GetModel() != null) {
                this.GetModel().ClearContext();
            }

            this.SetDataPolicy(false);
            this.emsViewType = EmsViewType.EmptyEmsViewType;
            //this.needRefresh = -1;
            this.SetNeedRefresh((int)EuRefreshState.InitState);
            return base.ClearContext();
        }

        public override void SetDataPolicy(bool flag)
        {
            //base.SetDataPolicy(flag & EnableEdit());
            base.SetDataPolicy(flag);
            this.enableEdit = flag;
        }

        protected override void OnLoadData()
        {
            base.OnLoadData();
            
            if (null != this.GetModel()) {
                this.GetModel().SetNullQryBuffer();

                if (this.NeedRefresh() == (int)EuRefreshState.NeedRefreshState )
                    this.model.Reload();
            }
                this.SetFormDataSource(null == this.model ? null : this.model.GetTableDataSource());
        }


        protected override void OnFillData()
        {

            //if (null != this.GetModel() && this.NeedRefresh() != 0 && this.GetModel().GetEmsSaveModel()!=null&&!this.GetModel().GetEmsSaveModel().IsUPDATED) {
            //    this.model.Refresh();
            //    this.SetNeedRefresh(0);
            //}
            if (this.NeedRefresh() == (int)EuRefreshState.NeedRefreshState)
            {
                this.model.Refresh();
                this.SetNeedRefresh((int)EuRefreshState.UnchangedState);
            }

            base.OnFillData();
        }

        private void HandleHideGridColums()
        {
            //if (this.tableGridControl == null)
            //    return;
            //// 检验检查医疗单时候，隐藏字段：频次、使用天数、总量
            //String[] szHidenColumn = { };
            //if (this.emsViewType == EmsViewType.EmsLisViewType || this.emsViewType == EmsViewType.EmsRisViewType) {
            //    szHidenColumn = new String[] { "Name_freq", "Use_days", "customercolumn_med_unit" };
            //}


            //foreach (XDataColumn col in this.tableGridControl.DataTable.Columns) {
            //    col.Visible = !szHidenColumn.Contains(col.FieldName);
            //}

        }

        #endregion

        #region 伪模型工厂方法
        protected ExpenseModel ExpenseModelWith(EmsViewType type, XapDataList<EmsOrDrug> ds)
        {
            ExpenseModel expenseMode = null;
            switch (type) {
                case EmsViewType.EmsDrugsViewType:
                case EmsViewType.EmsHerbsViewType:
                    expenseMode = new DrugsExpenseModel(ds);
                    break;
                case EmsViewType.EmsRisViewType:
                case EmsViewType.EmsLisViewType:
                    expenseMode = new LabObsExpenseModel(ds);
                    break;
                case EmsViewType.EmsApbtViewType:
                case EmsViewType.EmsApbuViewType:
                    expenseMode = new BloodExpenseModel(ds);
                    break;
                case EmsViewType.EmsConsViewType:
                    expenseMode = new ConsExpenseModel(ds);
                    break;
                case EmsViewType.EmsOpsViewType:
                    expenseMode = new OperationExpenseModel(ds);
                    break;
                case EmsViewType.EmsPathgyViewType:
                    expenseMode = new PathgyExpenseModel(ds);
                    break;
                case EmsViewType.EmsTreatViewType:
                    expenseMode = new CommonExpenseModel(ds);
                    break;
                default:
                    expenseMode = new ExpenseModel(null);
                    break;
            }
            return expenseMode;
        }
        #endregion

        #region 事件处理
        public override bool OnEventHandle(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            if (this.GetModel() == null)
                return base.OnEventHandle(sender, e);

            bool result = true;

            switch (AssToolEx.EventCodeOfEventArgs(e)) {
                case EventCodeType.EVENT_EMS_SAVESUCCESS:
                    if (this.model.GetTableDataSource() != null) {
                        
                            this.ClearContext();
                            isDirty = false;
                    }
                    break;
                case EventCodeType.EVENT_EXPENSE_ADD:
                    if (this.model.GetTableDataSource() != null) {
                        if (this.model.HasEmptyRow())
                        {
                            this.SetStatusMsg("已经存在一条空行，请填写完整后再新增");
                        }
                        else
                        {
                            this.model.AddRow();
                            isDirty = true;
                        }
                    }
                    else {
                        result = false;
                    }
                    break;
                case EventCodeType.EVENT_EXPENSE_DELETE:
                    if (tableGridControl != null) {
                        IEnumerable<EmsOrDrug> drugs =
                            from row in tableGridControl.DataTable.SelectedRows
                            select row.RowDataSource as EmsOrDrug;
                        if (drugs.Count() == 0) {
                            this.ShowInfo("请选择要删除的费用项目");
                            return true;
                        }
                        drugs.ToList().ForEach(p =>
                        {
                            this.model.DeleteRow(p);
                        });

                        isDirty = true;
                    }
                    else {
                        result = false;
                    }
                    break;


                case EventCodeType.EVENT_EMS_CLOSE:
                    ClearContext();
                    break;
                case EventCodeType.EVENT_EMS_ORSRV_DATACHANGED:
                    // 设置费用数据需要更新标志
                    this.SetNeedRefresh((int)EuRefreshState.NeedRefreshState);
                    if (this.GetModel() != null)
                        this.GetModel().DeleteAllItems();
                    //if (this.model != null && this.model.GetEmsSaveModel()!=null)
                    //{
                    //    this.model.GetEmsSaveModel().Fg_prisrvhandled = false;    
                    //}
                    isDirty = false;
                    break;
            }
            return result &= base.OnEventHandle(sender, e);
        }
        #endregion
        }
}
