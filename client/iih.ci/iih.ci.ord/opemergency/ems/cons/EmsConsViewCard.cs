using System;
using iih.ci.ord.opemergency.validate;
using xap.rui.control.refcontrol.events;
using xap.rui.control.forms.model;
using xap.rui.control.forms.control;
using xap.rui.control.refcontrol.data;
using iih.bd.srv.medsrv.i;
using xap.mw.serviceframework;
using iih.bd.srv.medsrv.d;
using xap.cli.sdk.controls.DataView;
using xap.rui.control.extentions;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.controls.DataView.Repository;
using iih.ci.ord.opemergency.controls;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.appfw;
using iih.ci.ord.opemergency.declare;
using xap.rui.control.formcontrol.model;
using xap.mw.coreitf.d;

namespace iih.ci.ord.opemergency.ems
{
    /// <summary>
    /// <para>描    述 :  会诊医疗单视图                   			</para>
    /// <para>说    明 :  会诊                  			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ems    </para>    
    /// <para>类 名 称 :  EmsConsViewCard					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  7/28/2016 5:25:00 PM             </para>
    /// <para>更新时间 :  7/28/2016 5:25:00 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EmsConsViewCard : BaseEmsFormView
    {

        #region 变量定义区域

        #endregion

        #region 构造函数区域
        public EmsConsViewCard(IEventDelegate o = null)
            : base(o)
        {
            
            this.srvItemViewType = EmsViewType.EmsConsViewType;
            this.iValidate = new EmsConsValidate();

            this.allowEdit = true;
        }
        #endregion

        #region 父类继承区域

        protected override void ResetColumnsInfo(XapFormGridControl gv)
        {
            base.ResetColumnsInfo(gv);

            XapDataList<EmsConsItemDO> emsConsItemDOs = this.GetViewModel().GetTableDataSource() as XapDataList<EmsConsItemDO>;
            // 多科室会诊，true 多科室，false 单个科室
            bool fg_deps = emsConsItemDOs[0].Fg_deps == true;
            // 如果是多科室，只显示受邀方，如果是单科室会诊，显示科室、受邀医生，不显示受邀方
            this.GetGridControl().DataTable.Columns["customercolumn_dep_invitors"].Visible = fg_deps;

            // 受邀科室
            this.GetGridControl().DataTable.Columns["Name_dep_emp"].Visible = !fg_deps;
            // 受邀医生
            this.GetGridControl().DataTable.Columns["Name_emp_doctor"].Visible = !fg_deps;
        }

        /// <summary>
        /// 发送树节点选中事件到卡上显示数据
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void SetDataPolicy(bool flag)
        {
            //DataPolicy policy = new DataPolicy();
            //policy.AllowNew = false;
            //policy.AllowEdit = flag;
            //policy.AllowRemove = false;
            //policy.AllowSave = false;
            //policy.FullEdit = flag;

            //this.GetXapFormControl().SetEditPolicy(flag, new DataPolicy[1] { policy });
            this.allowEdit = flag;
            this.GetXapFormControl().SetEditable(flag);
        }

        #endregion

        #region 内部事件区域
        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsConsViewCard/*"20160616082030628KFU"*/);
            this.SetGridPageCode("table");
            this.RegisteFormEventImpl();
        }

        protected override void OnXapFormControl_DataDisplay(object sender, xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs e)
        {
            XDataRow row = sender as XDataRow;

            if (row != null && row.RowDataSource is EmsConsItemDO)
                this.updateCustomerControlInfo(row);
        }


        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            base.OnXapFormControl_ModelFilled(sender, e);
            this.ResetColumnsInfo(this.GetGridControl());
            if (this.GetViewModel() == null)
            {
                AdjustLayout();
                this.ShowInfo("会诊数据模型为空！");
                return;
            }

            GetGridControl().DataTable.DataSource = this.GetViewModel().GetTableDataSource();

            AdjustLayout();
        }

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);

            // 挂载自定义控件
            initDepInvitorEditor();
        }

        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            var sbm = new StringObjectMap();
            if (this.GetViewModel() != null)
            {
                e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName, sbm);
                
            }
            else
            {
                e.WherePart = "";
            }
            foreach (var item in sbm)
            {
                e.RefParams.AddParam(item.Key, item.Value);
            }
        }

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {

            var ds = e.Object as EmsConsItemDO;
            if (e.PropName.Equals("Price"))
            {
                e.Cancel = !(ds.Eu_blmd == Convert.ToInt32(MedSrvBlModeEnum.MANUALBL));
            }
            else if(e.PropName.Equals("Name_srv") && null != this.GetViewModel() && !System.String.IsNullOrEmpty(GetViewModel().getCiEmsDTO().Id_or))
            {
                e.Cancel = true;
            }
            else
            {
                base.OnXapFormControl_AllowEditing(sender, e);
            }
        }

        /// <summary>
        /// 引用参照结果处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            if (this.GetViewModel() != null && this.GetViewModel().OnRefResultData(e.BindingFieldName, e.RefResultSet as RefDataCollection))
            {
                return;
            }
            // 参照取回数据后，处理显示名称 服务名称
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                if (e.RefResultSet.IsEmpty)
                {
                    SentNotify(EventCodeType.NM_EMS_CLOSE);
                }
                else
                {
                    this.GetViewModel().LoadMedSrv(new EmsCreatedParameter(new bd.srv.medsrv.d.MedSrvDO() { Id_srv = (e.DataObject as EmsConsItemDO).Id_srv }, null));
                }
                // 如模型为空  第一次创建
                //IMedsrvMDOCrudService service = XapServiceMgr.find<IMedsrvMDOCrudService>();
                //MedSrvDO medSrcDO = service.findById((e.DataObject as EmsConsItemDO).Id_srv);
                //// 第一次新建或者服务不一致，都认为重新计算UI展现
                //int rowCount = this.GetGridControl().DataTable.Rows.Count;
                //var rowDatasource = this.GetGridControl().GetFocusedRow<EmsConsItemDO>();
                //if (this.GetViewModel() == null || rowCount == 1 ) {
                //    this.SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParamList.TAGKEY, new EmsCreatedParamList() { new EmsCreatedParameter(medSrcDO, null) });
                //}
                // 暂时注释下列代码，由于保存逻辑不支持 诊疗服务 更新
                //if (this.GetViewModel() == null || (rowCount == 1 && string.IsNullOrEmpty(rowDatasource.Id_orsrv))) {
                //    this.SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParamList.TAGKEY, new EmsCreatedParamList() { new EmsCreatedParameter(medSrcDO, null) });
                //}
                //else {
                //    AppendSrv2Ems(medSrcDO);
                //    this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);
                //    LoadData();
                //}

            }
        }
        public override void SetFocus()
        {
            if (GetGridControl() != null && GetGridControl().DataTable.Rows.Count > 0)
            {
                GetGridControl().Focus();
                GetGridControl().DataTable.Rows[0].CellList[0].Focus();
                GetGridControl().DataTable.Rows[0].Selected = true;
            }
        }

        protected bool AppendSrv2Ems(MedSrvDO med)
        {
            GetXapFormControl().DataChanged -= OnXapFormControl_DataChanged;

            var ret = this.GetViewModel().LoadMedSrv(new EmsCreatedParameter(med, null), this.GetGridControl().GetFocusedRow().Index);

            this.GetXapFormControl().DataChanged += OnXapFormControl_DataChanged;

            return ret;
        }

        #endregion

        #region 辅助处理区域

        /// <summary>
        /// 设置表格中受邀方字段可编辑
        /// </summary>
        private void initDepInvitorEditor()
        {

            XRepositoryRefEdit edit = new XRepositoryRefEdit(this.GetGridControl());
            edit.RefEditor = new CustomRefControl(this.GetGridControl(), edit);
            foreach (var col in this.GetGridControl().DataTable.Columns)
            {
                string fieldName = col.FieldName.ToLower();

                if ("customercolumn_dep_invitors".Equals(fieldName))
                {
                    col.ColumnEdit = edit;
                    break;
                }
            }
        }

        void updateCustomerControlInfo(XDataRow row)
        {
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_dep_invitors"))
            {
                row.ColumnCellDict["customercolumn_dep_invitors"].SetValue(CustomRefControl.ConstructInvitedDeptInfo((row.RowDataSource as EmsConsItemDO).EmsConsAssistItem));
            }

        }
        #endregion

    }
}
