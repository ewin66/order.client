using System;
using System.Collections.Generic;

using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.refcontrol.events;
using xap.rui.control.refcontrol.data;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using xap.mw.serviceframework;
using iih.ci.ord.ciordems.d;
using xap.rui.appfw;
using xap.cli.sdk.controls.DataView.Model;
using xap.rui.control.extentions;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.view;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using iih.ci.ord.opemergency.controls;
using xap.rui.control.querycontrol.QuerySchema.Tools;
using xap.cli.sdk.form;
using System.Windows.Forms;
using iih.ci.iih.ci.ord.i;
using System.Drawing;
using iih.bd.srv.ems.d;
using iih.ci.ord.ciorder.d;
using xap.mw.core.data;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.common.utils;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.ems.d;
using iih.ci.ord.medicaresharing.mdeicalrule;
using iih.en.pv.dto.d;
using xap.mw.coreitf.d;
using iih.ci.ord.opemergency.declare;
using xap.rui.control.basecontrol;
using iih.bd.bc.udi;
using iih.ci.ord.dto.d;
using iih.ci.ord.medicaresharing;

namespace iih.ci.ord.opemergency.ems.common
{
    /// <summary>
    /// <para>描    述 : 医疗单通用表格控件                 </para> 
    /// <para>项目名称 : iih.ci.ord                        </para>    
    /// <para>类 名 称 : EmsDrugsTableViewCard             </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 : qzwang                            </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class EmsDrugSrvGridView : BaseEmsView
    {
        #region 变量定义
        private DelegateRunnable delegateRunnable ;
        #endregion

        #region 构造函数区域
        public EmsDrugSrvGridView(IEventDelegate o = null)
            : base(o)
        {
            this.allowEdit = true;
            this.srvItemViewType = EmsViewType.EmptyEmsViewType;
            this.delegateRunnable = new DelegateRunnable(this);
        }

        /// <summary>
        /// 初始化业务视图
        /// </summary>
        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetGridPageCode(BaseEmsView.FORM_BODY_PAGECODE);
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsDrugSrvGridView/*"20160604060824491H0C"*/);
            this.RegisteFormEventImpl();
        }
        #endregion

        #region 接口方法
        public override void SetFocus()
        {
            if (GetGridControl() != null && GetGridControl().DataTable.Rows.Count > 0)
            {
                GetGridControl().Focus();
                GetGridControl().DataTable.Rows[0].Selected = true;
                GetGridControl().DataTable.Rows[0].Focused = true;
                GetGridControl().DataTable.Rows[0].ColumnCellDict["Name_srv"].Focus();
            }
        }
        #endregion

        #region 父类继承区域
        public override Size GetFixedSize()
        {
            return base.GetFixedSize();
        }

        /// <summary>
        /// 清空上下文
        /// </summary>
        public override BaseFormBizView ClearContext()
        {
            base.ClearContext();
            this.SetEmsViewType(EmsViewType.EmptyEmsViewType);

            return this;
        }

        /// <summary>
        /// 添加空行数据
        /// </summary>
        /// <param name="param"></param>
        /// <returns></returns>
        public override BaseFormBizView AddRow(object param = null)
        {
            if (!this.Created || this.IsLoading) return this;

            base.AddRow(param);

            // 服务参照区域可以编辑
            if (this.GetGridControl() != null)
            {
                XapDataList<EmsOrDrug> drugList = (GetGridControl().DataTable.DataSource as XapDataList<EmsOrDrug>);
                this.GetGridControl().ShowEditor(drugList[drugList.Count - 1], "Name_srv");
            }
            return this;
        }
        #endregion

        #region 内部事件区域
        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        protected override void OnXapFormControl_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            var row = sender as XDataRow;
            var drug = e.Object as EmsOrDrug;

            // 更新用户自定义列信息
            this.updateCustomerControlInfo(row, drug);
        }

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            // 注册表格的单击事件
            this.GetGridControl().MouseClick += OnXapGridFormControl_MouseClick;
            // 关联总量单元格编辑控件
            this.AttachQuanCurEditor();
        }

        protected virtual BaseValueUnitTableCell CreateQuanCurControl()
        {
            return new CustomQuanCurControl(this);
        }

        protected virtual BaseValueUnitTableCell CreateQuanMedControl()
        {
            return new CustomQuanMedControl(this);
        }

        protected virtual void AttachQuanCurEditor()
        {

            foreach (var col in this.GetGridControl().DataTable.Columns)
            {
                var fieldName = col.FieldName.ToLower();

                if ("customercolumn_sale_unit".Equals(fieldName))
                {
                    col.ColumnEdit = CreateQuanCurControl();
                    break;
                }
            }
        }

        protected virtual void AttachQuanMedEditor()
        {

            foreach (var col in this.GetGridControl().DataTable.Columns)
            {
                var fieldName = col.FieldName.ToLower();

                if ("customercolumn_med_unit".Equals(fieldName))
                {
                    col.ColumnEdit = CreateQuanMedControl();
                    break;
                }
            }
        }

        /// <summary>
        /// 数据行是否在列表中可见
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_DataVisible(object sender, DataVisibleEventArgs e)
        {
            var item = e.Data as EmsOrDrug;
            e.Visible = !item.IsDELETED;
        }

        /// <summary>
        /// 数据改变时候的消息事件处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (this.GetViewModel() == null)
                return;
            // 获取表单对象
            var gv = sender as XapFormGridControl;
            if (gv != null && gv.DataTable.Rows.DataSourceRow.ContainsKey(e.Data) &&
                gv.DataTable.Rows.DataSourceRow[e.Data] != null)
            {
                this.GetViewModel().OnDataChanged(e.Data, e.PropName, e.Input.ToString());

                XDataRow row = gv.DataTable.Rows.DataSourceRow[e.Data];
                this.updateCustomerControlInfo(row, e.Data as EmsOrDrug);
                if (!string.IsNullOrEmpty(e.PropName) && e.PropName.Equals("Fg_treat"))
                {
                    this.SentNotify(EventCodeType.EVENT_EMS_ORSRV_HP_DATACHANGED, e.PropName, e.Data);    
                }
                else {
                    this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED, e.PropName, e.Input.ToString(), e.Data);    
                }
            }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        /// <summary>
        /// 更新用户自定义列单元格信息
        /// </summary>
        /// <param name="row"></param>
        /// <param name="drug"></param>
        protected virtual void updateCustomerControlInfo(XDataRow row, EmsOrDrug drug)
        {
            if (drug == null || row == null)
            {
                return;
            }
            if (row.ColumnCellDict.ContainsKey("customercolumn_med_unit"))
            {
                if (drug.Name_unit_medu_virtual == null)
                    drug.Name_unit_medu_virtual = "";
                String spltStr = drug.Name_unit_medu_virtual.Length > 0 && IsNumberic(drug.Name_unit_medu_virtual.Substring(0, 1)) ? "*" : "";
                string strMed_unit = drug.Quan_medu_virtual + spltStr + drug.Name_unit_medu_virtual;
                row.ColumnCellDict["customercolumn_med_unit"].SetValue(strMed_unit);
            }
            if (row.ColumnCellDict.ContainsKey("customercolumn_sale_unit"))
            {
                if (drug.Quan_cur == null)
                    drug.Quan_cur = 0;
                if (drug.Name_unit_sale == null)
                    drug.Name_unit_sale = "";
                String spltStr = drug.Name_unit_sale.Length > 0 && IsNumberic(drug.Name_unit_sale.Substring(0, 1)) ? "*" : "";
                string strCur_unit = drug.Quan_cur + spltStr + drug.Name_unit_sale;
                row.ColumnCellDict["customercolumn_sale_unit"].SetValue(strCur_unit);
            }
        }
        /////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        protected bool IsNumberic(string message)
        {
            try
            {

                int result = Convert.ToInt32(message);
                return true;
            }
            catch
            {
                return false;
            }
        }
        /// <summary>
        /// 列表布局改变时候的消息事件处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormGridControl_LayoutChanged(object sender, EventArgs e)
        {
            // 抛出事件，通知上层布局有改变
            this.SentNotify(EventCodeType.NM_UIMSG_LAYOUTCHANGED);
        }


        /// <summary>
        ///引用参照条件事件处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            var sbm = new StringObjectMap();
            e.SearchText = QueryHelper.SQLEnCode(e.SearchText);

            e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName, sbm);

            foreach (KeyValuePair<string, object> item in sbm)
            {
                e.RefParams.AddParam(item.Key, item.Value);
            }
        }
        
        protected override void OnXapFormControl_RefCanSelect(object sender, RefCanSelectEventArgs e)
        {
            if (this.GetEmsViewType().Equals(EmsViewType.EmsDrugsViewType))
            {
                if (!string.IsNullOrEmpty(e.BindingFieldName) && this.GetViewModel() != null && this.GetViewModel().GetEmsUIDTO() != null && e.BindingFieldName.Equals("Name_srv"))
                {
                    string id_srv = e.SelectingData["Id_srv"] as string;
                    string id_mm = e.SelectingData["Id_mm"] as string;
                    string id_srvca = e.SelectingData["Id_srvca"] as string;
                    string sd_srvtp = e.SelectingData["Sd_srvtp"] as string;
                    string name = e.SelectingData["Name"] as string;
                    EmsUIDTO emsUIDTO = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO);
                    XapDataList<EmsOrDrug> drugList = emsUIDTO.Emsdrugs.EmsOrDrugList;
                    if (drugList.Count <= 1)
                    {
                        e.Cancel = false;
                        return;
                    }
                    foreach (EmsOrDrug drug in drugList)
                    {
                        //可以选择相同服务的不同药品 2017-07-04修改
                        //if (drug.Status != DOStatus.DELETED && !string.IsNullOrEmpty(drug.Id_srv) && drug.Id_srv.Equals(id_srv))
                        if (drug.Status != DOStatus.DELETED && !string.IsNullOrEmpty(drug.Id_mm) && drug.Id_mm.Equals(id_mm))
                        {
                            e.Message = string.Format("因为重复，您选中的数据'{0}'禁止选中！", name);
                            e.Cancel = true;
                            return;
                        }
                    }
                    //OrWfDeptInfoDTO wf = new GetDeptMpImp().GetDept_mp_ids(this.GetViewModel().GetEnt4BannerDTO().Code_entp, this.GetViewModel().GetEnt4BannerDTO().Id_entp, sd_srvtp, id_srvca, id_srv, emsUIDTO.Emsdrugs.Id_route, "", this.GetViewModel().GetEnt4BannerDTO().Id_dep_nur, this.GetViewModel().GetEnt4BannerDTO().Id_dep_phy);
                    //if (!string.IsNullOrEmpty(wf.Firstid_mp_dept) && !wf.Firstid_mp_dept.Equals(emsUIDTO.Emsdrugs.Id_dep))
                    //{
                    //    e.Message = string.Format(name + String.Format(", 执行科室【{0}】与医疗单中不相同，不能开在一起！", wf.Firstname_mp_dept));
                    //    e.Cancel = true;
                    //    return;
                    //}
                }
                e.Cancel = false;
            }

        }
        /// <summary>
        /// 引用参照结果处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            RefDataCollection data = e.RefResultSet;
            var drug = e.DataObject as EmsOrDrug;
            if (!this.GetViewModel().IsEmpty() && this.GetViewModel().OnRefResultData(e.BindingFieldName, drug))
            {
                this.updateCustomerControlInfo(this.GetGridControl().GetFocusedRow(), drug);
                this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);
                return;
            }
            // 判断是否清空参照数据，则执行清空医疗单数据操作
            if (e.BindingFieldName.Equals("Name_srv"))
            {
                // 如果清空了参照服务内容
               if (data.IsEmpty && (this.GetViewModel().IsEmpty() || this.GetViewModel().GetCountWithOutDelete() <= 1))
                {
                    // 新建 或者 存储模型的id_or为空，则直接关闭
                    var emsUIDTO = this.GetViewModel().GetEmsUIDTO() as EmsUIDTO;
                    if (null == emsUIDTO || emsUIDTO.IsNEW || String.IsNullOrEmpty(this.GetViewModel().getCiEmsDTO().Id_or))
                    {
                        SentNotify(EventCodeType.NM_EMS_CLOSE);
                    }
                    return;
                }

                if (string.IsNullOrEmpty(drug.Id_srv))
                {
                    this.UnRegFormEvent_DataChanged();
                    string id_orsrv = drug.Id_orsrv;
                    GetLogicEx().Clear<EmsOrDrug>(drug,new String[]{"Status"});
                    drug.Id_orsrv = id_orsrv;

                    this.RegFormEvent_DataChanged();
                    return;
                }

                // 获取 BDSrvDO 数据
                //var service = XapServiceMgr.find<IMedsrvMDOCrudService>();
                //var medSrvDO = service.findById((e.DataObject as EmsOrDrug).Id_srv);

                var orDrug = e.DataObject as EmsOrDrug;
                //Ent4BannerDTO patDo = this.Context["banner"] as Ent4BannerDTO;
                Ent4BannerDTO patDo = this.GetViewModel().GetEnt4BannerDTO();
                List<MedicalSharingDTO> infoMedicalSharing = null;
                CiEnContextDTO ciEnContextDto = CiEnContextUtil.GetCiEnContext(patDo, EmsAppModeEnum.SVEMSAPPMODE, this.Context);//诊断是否保外的
                if (patDo != null && ciEnContextDto != null && ciEnContextDto.Eu_hpbeyond == HpBeyondEnum.HPDIAG && !EnDictCodeConst.SD_ENTP_EMERGENCY.Equals(patDo.Code_entp) && patDo.No_hp != null && patDo.Sd_hptp != null && patDo.Sd_hptp.StartsWith("1"))
                {
                    MedicalSharingDTO[] arrMedicalSharingDtos = new MedicalSharingDTO[1];
                    MedicalSharingDTO medicalSharing = new MedicalSharingDTO();
                    medicalSharing.Code = orDrug.Code_hpsrvorca;
                    medicalSharing.Name_srv = orDrug.Name_srv;
                    medicalSharing.Sd_srvtp = orDrug.Sd_srvtp;
                    arrMedicalSharingDtos[0] = medicalSharing;
                    infoMedicalSharing = MedicalSharingDateRule.MedicalSharingValidate(this.Context, arrMedicalSharingDtos, patDo);
                }
                if (infoMedicalSharing != null && infoMedicalSharing.Count > 0)
                {   //弹出医保共享信息
                    using (MedicalSharingInfoForm from = new MedicalSharingInfoForm(infoMedicalSharing))
                    {
                        if (from.ShowDialog() == DialogResult.OK)
                        {
                            orDrug.Fg_selfpay = FBoolean.True;
                            AsynchronousHandle(orDrug);
                        }
                        else
                        {
                            GetLogicEx().clearEmsOrDrugPropety(orDrug);
                        }
                    }
                }
                else
                {
                    // 异步调用
                    //delegateRunnable.DelayCall(AsynchronousHandle, orDrug);
                    AsynchronousHandle(orDrug);
                }
            }
            else
            {
                this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED, e.BindingFieldName, "Name_freq");
            }
        }

        protected virtual void AsynchronousHandle(Object param)
        {
            var drug = param as EmsOrDrug;
            bool? Fg_selfpay = drug.Fg_selfpay; 
            var medSrvDO = new MedSrvDO()
            {
                Id_srv = drug.Id_srv,
                Sd_srvtp = drug.Sd_srvtp,
                Name = drug.Name_srv
            };
            var id_mm = drug.Id_mm;
            this.GetXapFormControl().SetFormModified(true);
           
            // 如果新建医疗单成功则返回
            if (this.CreateNewEms(medSrvDO, id_mm, drug.Fg_selfpay))
            {
                this.SentNotify(EventCodeType.NM_EMS_REFRESULT);
                return;
            }

            // 向当前医疗单中追加服务项目
            if (!this.AppendSrv2Ems(medSrvDO, id_mm))
            {
                if (!string.IsNullOrEmpty(this.GetViewModel().GetErrorMsg()))
                this.ShowInfo(this.GetViewModel().GetErrorMsg());
            }
            else {
                if (this.GetViewModel().GetTipInfoMsg().Length > 0)
                {
                    this.ShowInfo(this.GetViewModel().GetTipInfoMsg());
                    this.GetViewModel().ClearTipInfo();
                }
            }
            this.SentNotify(EventCodeType.NM_EMS_REFRESULT);
            var row = this.GetGridControl().GetFocusedRow();
            if (row != null)
            {
                EmsOrDrug drowDrug = row.RowDataSource as EmsOrDrug;
                if (Fg_selfpay != null)
                {
                    drowDrug.Fg_selfpay = Fg_selfpay;
                }
                this.updateCustomerControlInfo(row, drowDrug);
            }

            this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);
        }

        /// <summary>
        /// 模型数据填充事件实现
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            // 重设表格表头外观信息（对齐方式、默认显示）
            ResetColumnsInfo(GetGridControl());

            // 为表格设置数据源
            GetGridControl().DataTable.DataSource = this.GetViewModel().GetTableDataSource();

            // 如果是普药医疗单时候，需要发出通知事件，数据为默认行数据
            if (this.srvItemViewType == EmsViewType.EmsDrugsViewType)
            {
                var drug = GetGridControl().GetFocusedRow<EmsOrDrug>();
                if (null != drug)
                {
                    this.SentNotify(EventCodeType.NM_EMS_ORSRV_SELECTCHANGED, "EmsOrDrug", drug);
                }
            }

            this.SetFocus();

            // 发送调整布局消息
            this.SentNotify(EventCodeType.NM_UIMSG_LAYOUTCHANGED);
        }

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            if (e.PropName.Equals("customercolumn_sale_unit"))
            {

            }
            else if (!e.PropName.Equals("Name_srv"))
            {
                e.Cancel = String.IsNullOrEmpty((e.Object as EmsOrDrug).Id_srv);
            }
            else
            {
                base.OnXapFormControl_AllowEditing(sender, e);
            }
        }

        protected virtual void OnXapGridFormControl_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            var row = sender as XDataRow;
            if (this.GetViewModel() != null && row != null && GetEmsViewType() != EmsViewType.EmsHerbsViewType)
            {
                this.GetViewModel().SetSelectedObject(row.RowDataSource);
            }

            if (GetEmsViewType() == EmsViewType.EmsHerbsViewType)
            {
                this.SentNotify(EventCodeType.NM_TABLE_CLICK, EventCodeType.NM_TABLE_CLICK, row);
            }


            this.SentNotify(EventCodeType.NM_EMS_ORSRV_SELECTCHANGED, "EmsOrDrug", row.RowDataSource);
        }
        #endregion

        #region 辅助处理函数
        /// <summary>
        /// 根据 MedSrvDO数据创建医疗单
        /// </summary>
        /// <param name="med"></param>
        /// <returns></returns>
        protected bool CreateNewEms(MedSrvDO med, String id_mm = null, FBoolean fg_selfpay = null)
        {
            bool isCreateEms = false;

            // 在表格模型为空的场景下，此时应该处于空医疗单状态，可以创建医疗单（表示当前还在默认的录入表格对象上）
            if (this.GetViewModel() == null)
            {
                isCreateEms = true;
            }
            else if (this.srvItemViewType == EmsViewType.EmsHerbsViewType)
            {
                // 在草药医疗单场景下，如果草药列表中只有一味药，也可以重新创建不同的医疗单
                var drugList = (this.GetViewModel() as EmsHerbsViewModel).getCardTable();

                isCreateEms |= drugList.Count == 1 && string.IsNullOrWhiteSpace(drugList[0].Id_orsrv);
            }
            else
            {
                var row = this.GetGridControl().GetFocusedRow();
                EmsOrDrug drug = row.RowDataSource as EmsOrDrug;
                // 在其他场景下，只要满足列表中只有一行数据，都可以再次新建医疗单
                isCreateEms |= GetGridControl().DataTable.Rows.Count == 1 && string.IsNullOrWhiteSpace(drug.Id_orsrv);
            }
            // 如果能够新建医疗单，则向父容器发出新建医疗单的通知事件
            if (isCreateEms)
            {
                this.SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParamList.TAGKEY, new EmsCreatedParamList { new EmsCreatedParameter(med, id_mm, fg_selfpay) });
            }

            return isCreateEms;
        }

        /// <summary>
        /// 在已有药品的医疗单中追加药品
        /// </summary>
        /// <param name="med"></param>
        /// <returns></returns>
        protected bool AppendSrv2Ems(MedSrvDO med, String id_mm = null)
        {
            GetXapFormControl().DataChanged -= OnXapFormControl_DataChanged;

            var ret = this.GetViewModel().LoadMedSrv(new EmsCreatedParameter(med, id_mm), this.GetGridControl().GetFocusedRow().Index);
            if (ret)
            {
                this.GetXapFormControl().DataChanged += OnXapFormControl_DataChanged;
            }

            return ret;
        }

       

        #endregion
    }
}
