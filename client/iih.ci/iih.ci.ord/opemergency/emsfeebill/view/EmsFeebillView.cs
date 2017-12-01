
using iih.ci.ord.ciordems.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.emsfeebill.model;
using iih.ci.ord.opemergency.view;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.events;
using xap.rui.control.forms.model;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.extentions;
using iih.ci.iih.ci.ord.i;
using iih.ci.ord.opemergency.declare;

namespace iih.ci.ord.opemergency.emsfeebill.view
{
    /// <summary>
    /// <para>描    述 :  医疗单费用视图                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.emsfeebill.view    </para>    
    /// <para>类 名 称 :  EmsFeebillView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  1/10/2017 2:42:44 PM             </para>
    /// <para>更新时间 :  1/10/2017 2:42:44 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class EmsFeebillView : BaseFormBizView
    {
        #region 变量
        private EmsFeebillViewModel model = new EmsFeebillViewModel();
        private XapFormGridControl tableGridControl;
        private bool enableEdit = false;

        #endregion

        #region 重写方法
        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsFeebillView/*"20170110025754895000"*/);
            this.SetFormDataSource(model.GetFormDataSource());
            this.RegisteFormEventImpl();
        }

        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            base.OnXapFormControl_Load(sender, e);
        }
        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);

            var formControl = sender as XapFormControl;
            if (formControl != null) {
                tableGridControl = formControl.GetGridView(BaseFormBizView.FORM_BODY_PAGECODE);

                //tableGridControl.MouseClick += OnItemSelected;
                //tableGridControl.DataTable.MultiCheckChanging += mutilCheckingEventArgs;
                //tableGridControl.DataTable.SelectedRowChanging += selectRowChanging;
               
            }
        }

        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            base.OnXapFormControl_ModelFilled(sender, e);

            tableGridControl.DataTable.Columns["Fg_treat"].ReadOnly = true;
            //非医保患者隐藏自费列
            if (string.IsNullOrEmpty(this.GetModel().GetEnt4BannerDTO().Id_hp)) {
                if (tableGridControl.DataTable.Columns["Fg_selfpay"].Visible == true) {
                    tableGridControl.DataTable.Columns["Fg_selfpay"].Visible = false;
                }
            }
        }

        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            var drug = e.DataObject as CiOrdFeeSrvDTO;

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

        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            var drug = e.DataObject as CiOrdFeeSrvDTO;
            if (e.BindingFieldName.Equals("Name_srv") && !e.RefResultSet.IsEmpty) {
                if (e.RefResultSet.IsEmpty) {
                    GetLogicEx().Clear<CiOrdFeeSrvDTO>(tableGridControl.GetFocusedRow<CiOrdFeeSrvDTO>());
                }
                else {
                    this.model.LoadEmsFeeSrv(drug);
                }

            }
            else if (e.BindingFieldName.Equals("Name_freq")) {

                this.model.ReCalculateInfo(drug);
            }
            //
            this.UpdateCustomerControlInfo(tableGridControl.GetFocusedRow(), drug);

            this.SentNotify(EventCodeType.NM_EXPENSE_DATACHANGED);
        }

        protected override void OnXapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (e.PropName.Equals("Use_days") || e.PropName.Equals("customercolumn_med_unit")) {
               
                if (tableGridControl != null && tableGridControl.DataTable.Rows.DataSourceRow.ContainsKey(e.Data) &&
                    tableGridControl.DataTable.Rows.DataSourceRow[e.Data] != null) {
                    var row = tableGridControl.DataTable.Rows.DataSourceRow[e.Data];
                    this.model.ReCalculateInfo(e.Data as CiOrdFeeSrvDTO);
                    this.UpdateCustomerControlInfo(row, e.Data as CiOrdFeeSrvDTO);
                }

            }
            else if (e.PropName.Equals("customercolumn_sale_unit")) {
                
                if (tableGridControl != null && tableGridControl.DataTable.Rows.DataSourceRow.ContainsKey(e.Data) &&
                    tableGridControl.DataTable.Rows.DataSourceRow[e.Data] != null) {
                    var row = tableGridControl.DataTable.Rows.DataSourceRow[e.Data];
                    var newDrug = e.Data as CiOrdFeeSrvDTO;
                    if (null == newDrug.Price) {
                        newDrug.Price = this.GetLogicEx().getSrvNotMMPri(newDrug.Id_srv, newDrug.Id_primd,null,this.GetModel().GetEnt4BannerDTO().Id_pripat); // 服务参照，没有把定价模式 id_primd 带出来--日后修改参照
                    }

                    if (newDrug.Quan_total_medu == null || newDrug.Quan_total_medu == 0) {
                        newDrug.Quan_total_medu = 1;
                    }
                    newDrug.Amt_cur = newDrug.Price * newDrug.Quan_total_medu;
                    this.UpdateCustomerControlInfo(row, newDrug);
                }
            }
        }

        protected override void OnXapFormControl_DataVisible(object sender, DataVisibleEventArgs e)
        {
            var drug = e.Data as CiOrdFeeSrvDTO;
            e.Visible = !drug.IsDELETED;
        }

        public override void Refresh(object param = null)
        {

            //if (needRefresh)
            {
                this.LoadData();
            }

        }
        

        public override BaseFormBizView ClearContext()
        {
            
            this.model.ClearContext();
            
            this.SetDataPolicy(false);
            
            return base.ClearContext();
        }

        public override void SetDataPolicy(bool flag)
        {
            base.SetDataPolicy(flag & EnableEdit());
        }

        #endregion

        #region 辅助方法

        public bool EnableEdit()
        {
            return this.enableEdit;
        }

        public String WherePartWith(string idorg, string iddep)
        {
            var srvScopeSql = this.Context.GetParam<String>(iddep, ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);
            if (srvScopeSql == null) {
                srvScopeSql = this.Context.GetParam<String>(idorg, ICiOrdNSysParamConst.SYS_PARAM_OrChkSrvScope4MakeupFee);
            }  

            return srvScopeSql + " and bd_srv.fg_use_op='Y' ";
        }

        /// <summary>
        /// 暂时记录 -- 以后作废该方法逻辑
        /// </summary>
        /// <param name="row"></param>
        /// <param name="feeSrv"></param>
        void UpdateCustomerControlInfo_1(XDataRow row, CiOrdFeeSrvDTO feeSrv)
        {
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_med_unit")) {
                if (feeSrv.Quan_med == null)
                    feeSrv.Quan_med = 0;
                if (feeSrv.Name_unit_med == null)
                    feeSrv.Name_unit_med = "";
                string strMed_unit = feeSrv.Quan_med + feeSrv.Name_unit_med;
                row.ColumnCellDict["customercolumn_med_unit"].SetValue(strMed_unit);
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_sale_unit")) {

                if (feeSrv.Quan_total_medu == null)
                    feeSrv.Quan_total_medu = 0;
                if (feeSrv.Name_unit_sale == null)
                    feeSrv.Name_unit_sale = "";
                string strMed_unit = feeSrv.Quan_total_medu + feeSrv.Name_unit_sale;
                row.ColumnCellDict["customercolumn_sale_unit"].SetValue(strMed_unit);
            }
        }
        /// <summary>
        /// 数量字段显示 总量信息
        /// </summary>
        /// <param name="row"></param>
        /// <param name="feeSrv"></param>
        void UpdateCustomerControlInfo(XDataRow row, CiOrdFeeSrvDTO feeSrv)
        {
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_med_unit")) {
                if (feeSrv.Fg_mm == null || !feeSrv.Fg_mm.Value) {
                    if (feeSrv.Quan_total_medu == null)
                        feeSrv.Quan_total_medu = 0;
                    if (feeSrv.Name_unit_sale == null)
                        feeSrv.Name_unit_sale = "";
                    string strMed_unit = feeSrv.Quan_total_medu + feeSrv.Name_unit_sale;
                    row.ColumnCellDict["customercolumn_med_unit"].SetValue(strMed_unit);
                }
                else {
                    if (feeSrv.Quan_cur == null)
                        feeSrv.Quan_cur = 0;
                    if (feeSrv.Name_unit_sale == null)
                        feeSrv.Name_unit_sale = "";
                    string strMed_unit = feeSrv.Quan_cur + feeSrv.Name_unit_sale;
                    row.ColumnCellDict["customercolumn_med_unit"].SetValue(strMed_unit);
                }
            }
            
        }

        #endregion

        #region 接口

        public BaseBizViewModel GetModel()
        {
            return model;
        }
        #endregion
    }
}
