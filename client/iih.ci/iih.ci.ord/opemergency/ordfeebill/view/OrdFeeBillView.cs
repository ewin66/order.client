
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.ordfeebill.model;
using System;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.cli.sdk.controls.DataView.Model;
using xap.cli.sdk.controls.DataView;
using System.Windows.Forms;
using xap.cli.sdk.render.DoctorOrderCard;
using System.IO;
using System.Xml.Serialization;
using xap.cli.sdk.render;
using iih.ci.ord.ciordems.d;
using xap.rui.control.formcontrol.model;
using iih.ci.ord.ciorder.d;
using xap.rui.control.forms.control;
using xap.rui.control.refcontrol.events;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.engine;
using iih.ci.ord.opemergency.tool;
using xap.rui.control.forms.model;
using iih.bl.hp.bdhpindicationdto.d;
using xap.mw.core.data;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.opemergency.dialog;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.ems.common;
using iih.bd.bc.udi;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.opemergency.view.basic;

namespace iih.ci.ord.opemergency.view.ordfeebill
{
    /// <summary>
    /// <para>描    述 :  医嘱费用清单                   			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.ordfeebill    </para>    
    /// <para>类 名 称 :  OrdFeeBillView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  wangqz         				</para> 
    /// <para>修 改 人 :  wangqz         				</para> 
    /// <para>创建时间 :  12/13/2016 7:38:31 PM             </para>
    /// <para>更新时间 :  12/13/2016 7:38:31 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OrdFeeBillView : BaseFormBizView
    {
        #region 变量定义
        protected OrdFeeBillViewModel model = new OrdFeeBillViewModel();
        /// <summary>
        /// 医嘱组件
        /// </summary>
        private DoctorOrderConfig doctorOrderConfig;

        /// <summary>
        /// 分组表格
        /// </summary>
        private XapFormGridControl tableGridControl;

        private bool isReadOnly = false;

        bool isDirty = false;

        private bool isError = false;

        public bool IsDirty()
        {
            return isDirty;
        }

        public bool IsError()
        {
            return isError;
        }

        public void SetReadOnly(bool rd)
        {
            this.isReadOnly = rd;
        }

        #endregion

        #region 构造方法
        public OrdFeeBillView() { }

        public OrdFeeBillView(BaseBizView o) : base(o) { }
        #endregion

        #region 覆盖方法

        /// <summary>
        /// 初始化业务视图
        /// </summary>
        protected override void InitializeBizView()
        {
            base.InitializeBizView();
            this.Name = "费用清单";
            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_OrdFeeBillView/*"20161213073708159000"*/);
            this.SetFormDataSource(model.GetTableDataSource());
            this.RegisteFormEventImpl();
        }

        /// <summary>
        /// 处理在表单加载完成后的逻辑，出发初始化操作
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            base.OnXapFormControl_Load(sender, e);
            OnInit();
        }

        /// <summary>
        /// 在向数据源中新增一行空记录时候的事件处理，主要做一些初始化数据
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_DataInitNew(object sender, DataInitNewEventArgs e)
        {
            base.OnXapFormControl_DataInitNew(sender, e);

            CiOrdFeeSrvDTO feeSrv = e.Object as CiOrdFeeSrvDTO;

            CiOrdFeeSrvDTO b = tableGridControl.DataTable.SelectedRows[0].RowDataSource as CiOrdFeeSrvDTO;
            {
                feeSrv.Id_or = b.Id_or;
                feeSrv.Content_or = b.Content_or;
                feeSrv.Dt_effe = b.Dt_effe;
                // feeSrv.setAttrVal("Ord_colligate",b.getAttrVal("Ord_colligate"));
                feeSrv.Eu_sourcemd = (int)OrSrvSourceFromEnum.PHYSIANFEEADD;
                
            }
        }

        /// <summary>
        /// 改写参照过滤条件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            var drug = e.DataObject as CiOrdFeeSrvDTO;

            if (e.BindingFieldName.Equals("Name_srv")) {
                e.WherePart = " bd_srv.fg_use_op='Y' and bd_srv.fg_or='N' and bd_srv.fg_bl = 'Y' ";  
            }
                //执行科室的名字匹配错了
            else if (e.BindingFieldName.Equals("Name_dep") && drug.getAttrVal("str_id_mp_deps") != null) {
                e.WherePart = String.Format("id_dep in({0})", drug.getAttrVal<String>("str_id_mp_deps"));
            }
        }

        /// <summary>
        /// 处理参照选择完成后的处理逻辑
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            var drug = e.DataObject as CiOrdFeeSrvDTO;
            if (e.BindingFieldName.Equals("Name_srv") ) {
                if (e.RefResultSet.IsEmpty) {
                    // 如果退格键 删除的服务为 非新建服务，则做删除处理
                    ClearRowData(drug);
                    // 如果含有 srv表的主键值，则设置该空行为更新数据；否则，为新建数据
                    if (!string.IsNullOrEmpty(drug.Id_orsrv))
                    {
                        drug.Status = DOStatus.UPDATED;
                    }
                    else
                    {
                        drug.Status = DOStatus.NEW;
                    }
                    //string[] notProps = { "Id_or", "Dt_effe", "Content_or" ,"Status", "Srv_sv"};
                    //GetLogicEx().Clear<CiOrdFeeSrvDTO>(drug, notProps);
                }
                else {
                    
                    if (!this.model.LoadFeeSrv(drug))
                    {
                        this.ShowInfo(this.model.GetErrorMsg());
                        string[] notProps = { "Id_or", "Dt_effe", "Content_or", "Status", "Srv_sv" };
                        GetLogicEx().Clear<CiOrdFeeSrvDTO>(drug, notProps);
                       
                    }
                }

            }
            // 更新自定义控件
            this.UpdateCustomerControlInfo(tableGridControl.GetFocusedRow(), drug);
        }

        private void ClearRowData(CiOrdFeeSrvDTO o)
        {
            o.Eu_sourcemd = null;
            o.Id_dep = null;
            o.Id_dep_srv = null;
            o.Id_emp_srv = null;
            o.Id_org_srv = null;
            o.Id_unit_sale = null;
            o.Name_unit_sale = null;
            o.Name_dep = null;
            o.Quan_total_medu = null;
            o.Amt_total = null;
            o.Id_srv = null;
            o.Name_srv = null;
        }

        /// <summary>
        /// 处理表单响应 Selected 事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            
            if (e.Object == null ||
                !(e.Object is xap.rui.bizcontrol.bannercontrol.BannerData) ||
                (e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO == null
                ) {

                this.model.ClearTableDataSource();
                OnFillData();
                return;
            }
            
            if (this.model != null) {
                

                this.model.SetEnt4BannerDTO((e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO);
                if (this.model.GetEnt4BannerDTO() != null && this.model.GetEnt4BannerDTO().Sd_status == EnDictCodeConst.SD_ENSTATUS_OP_FINISH)
                {
                    this.GetXapFormControl().SetEditable(false);
                }
                //OnLoadData();
                //OnFillData();
                LoadData();
            }
        }

        public override void HandleState(object sender, DictionaryEventArgs e)
        {
            if (!this.Created) return;

            switch (AssToolEx.EventCodeOfEventArgs(e)) {
                case UIEvent.SAVE_SUCCESS:
                    this.LoadData();
                    break;
            }
        }

        public override bool OnEventHandle(object sender, DictionaryEventArgs e)
        {
            
            return base.OnEventHandle(sender, e);
        }

        /// <summary>
        /// 异步加载数据
        /// </summary>
        protected override void OnLoadData()
        {
            var t1 = new AssCostTimeTool("切换患者时候，远程调用获取费用清单数据，耗时：", false);
            base.OnLoadData();
            if (null!= model) {
                this.model.Reload();
                this.SetFormDataSource(model.GetTableDataSource()); // 不得已，由于控件不支持，同一模型对象的数据刷新
            }
            t1.SaveTimeLog();
        }

        protected override void OnFillData()
        {
            var t1 = new AssCostTimeTool("切换患者时候，填充UI控件费用清单数据，耗时：", false);
            base.OnFillData();
            t1.SaveTimeLog();
        }

        /// <summary>
        /// 处理表格的编辑规则
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            // 由于网络延迟加载数据缓慢，此时禁止用户的所有操作
            if (this.IsLoading)
            {
                e.Cancel = true;
                return;
            }
            if (isReadOnly)
            {
                e.Cancel = true;
                return;
            }
            if (this.model.GetEnt4BannerDTO() != null && this.model.GetEnt4BannerDTO().Sd_status == EnDictCodeConst.SD_ENSTATUS_OP_FINISH)
            {
                e.Cancel = true;

                return;
            }
           
            // 费用描述字段不能编辑
            if (e.PropName.Equals("Des_srv")|| e.PropName.Equals("Code_or")) 
            {
                e.Cancel = true;

                return;
            }
            
            CiOrdFeeSrvDTO ordFeeBill = e.Object as CiOrdFeeSrvDTO;
            
            if (null != ordFeeBill) {
                CiOrderDO ord = this.model.GetOrderDO(ordFeeBill.Id_or);
                if (null != ord && ord.Fg_sign != null && ord.Fg_sign.Value)
                {
                    e.Cancel = true;
                    return;
                }
                if (string.IsNullOrEmpty(ordFeeBill.Id_srv) && !e.PropName.Equals("Name_srv"))
                {
                    e.Cancel = true;
                    return;
                }

               
                e.Cancel = DisableEditHP(e.PropName, ordFeeBill, DisableEditSrv(e.PropName, ordFeeBill)); //!EnableAllowEdit(e.PropName,ordFeeBill);
            }
        }

        /// <summary>
        /// 允许编辑医保列
        /// </summary>
        /// <param name="o"></param>
        /// <returns></returns>
        private Boolean DisableEditHP(string propName, CiOrdFeeSrvDTO dataSource, bool def)
        {
            if (propName.Equals("Fg_selfpay")) {
                FArrayList bdhpdtos = dataSource.BdHpIndicationList;
                if (bdhpdtos == null) {
                    bdhpdtos = new FArrayList();
                    BdHpIndicationDTO dto = HpJudgeUtil.getInstance().getBdHpIndicationDTO(dataSource.Id_srv, dataSource.Id_mm, 
                        this.GetModel().GetEnt4BannerDTO());
                    if (dto != null) {
                        bdhpdtos.Add(dto);
                    }
                    dataSource.BdHpIndicationList = bdhpdtos;
                }
                    //符合医保判断条件，并且医保使用症为true的时候才可以操作
                if (CanEditHp() && dataSource.BdHpIndicationList == null || dataSource.BdHpIndicationList.Count == 0 || string.IsNullOrEmpty((dataSource.BdHpIndicationList[0] as BdHpIndicationDTO).Code_hpindicjudged))
                {
                    return true;
                }
                else
                {
                    return dataSource.Fg_indic == null ? true : !(bool)dataSource.Fg_indic;
                }
                    
               
            }
            return def;
        }

        /// <summary>
        /// 允许编辑项目
        /// </summary>
        /// <param name="o"></param>
        /// <returns></returns>
        private Boolean DisableEditSrv(String fn,CiOrdFeeSrvDTO o)
        {
            return !EnableAllowEdit(fn,o) || fn.Equals("Price")|| fn.Equals("Amt_total");
        }

        /// <summary>
        /// 处理表格的显示规则
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_DataVisible(object sender, DataVisibleEventArgs e)
        {
            CiOrdFeeSrvDTO ordFeeBill = e.Data as CiOrdFeeSrvDTO;
            if (null != ordFeeBill) {
                e.Visible = !ordFeeBill.IsDELETED && ordFeeBill.Fg_bl != null && ordFeeBill.Fg_bl.Value;
            }
        }

        protected override void OnXapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            base.OnXapFormControl_DataChanged(sender, e);

            this.isDirty = true;

            if (e.PropName.Equals("customercolumn_med_unit")) {
                CiOrdFeeSrvDTO ordFeeBill = e.Data as CiOrdFeeSrvDTO;
                if (ordFeeBill.Price == null) ordFeeBill.Price = 0;
                if (ordFeeBill.Quan_total_medu == null) ordFeeBill.Quan_total_medu = 0;
                ordFeeBill.Amt_total = ordFeeBill.Price * ordFeeBill.Quan_total_medu;
            }
        }

        /// <summary>
        /// 处理表单创建完成之后的其他逻辑
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);

            tableGridControl = GetXapFormControl().GetGridView("table");
            tableGridControl.DataTable.CrossBackColor = true;

            tableGridControl.DataTable.SelectedRowChanged += OnTableGridControl_SelectedRowChanged;

            tableGridControl.DataTable.MouseClick += OnXapFormControl_MouseClick;

            // 初始化医嘱组件
            string path = Application.StartupPath + "\\modules\\iihci\\ui\\commoncontent\\OrderContent.xml";
            doctorOrderConfig = this.Deserialize(path);

            this.GetXapFormControl().SetRightMenuVisible(false, "table");
        }

        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            base.OnXapFormControl_ModelFilled(sender, e);

            // 禁用适应症
            if (tableGridControl != null && this.GetModel() != null && this.GetModel().GetEnt4BannerDTO() != null) {
                tableGridControl.DataTable.Columns["Fg_indic"].ReadOnly = true;

                //非医保患者隐藏自费列
                if (this.isHideSelfpay(this.GetModel().GetEnt4BannerDTO()))
                {
                    
                      tableGridControl.DataTable.Columns["Fg_selfpay"].Visible = false;
                     
                }
                else
                {
                    tableGridControl.DataTable.Columns["Fg_selfpay"].Visible = true;
                }
            }
            
        }
        void OnXapFormControl_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {

            if (!isReadOnly && sender is XDataRow && (sender as XDataRow).ClickCell.FieldName.Equals("Fg_indic") && CanEditHp() && EnableAllowEdit((sender as XDataRow).ClickCell.FieldName, (sender as XDataRow).DataSource as CiOrdFeeSrvDTO))
            {
                this.showHpDialog(sender);
            }
        }
        protected void OnTableGridControl_SelectedRowChanged(object sender, XSelectedRowChangedEventArgs e)
        {
            CiOrdFeeSrvDTO feeSrv = e.Data as CiOrdFeeSrvDTO;
            if (null != feeSrv && e.Selected) {
                CiOrderDO ord = this.model.GetOrderDO(feeSrv.Id_or);
                if (null != ord)
                {
                    if (this.model.GetEnt4BannerDTO() != null && this.model.GetEnt4BannerDTO().Sd_status == EnDictCodeConst.SD_ENSTATUS_OP_FINISH)
                    {
                        return;
                    }
                    this.SentMessage(ord.Sd_su_or.Equals("0") && LogicEx.GetInstance().isIdEmpOrEqualIdpsn(ord.Id_emp_or) ? EventCodeType.EVENT_FEEBILL_ALLOWEDIT : EventCodeType.EVENT_FEEBILL_FORBIDEDIT);
                    return;
                }
                this.SentMessage( EventCodeType.EVENT_FEEBILL_FORBIDEDIT);
            }

        }

        /// <summary>
        /// 处理在表格数据行显示的时候，自定义列的单元格数据处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            base.OnXapFormControl_DataDisplay(sender, e);
            var row = sender as XDataRow;
            if (row != null) {
                foreach (UserRender render in row.UserRenderList) {
                    if (render is DoctorOrderCard) {
                        var card = render as DoctorOrderCard;
                        card.DoctorOrderConfig = this.doctorOrderConfig;
                    }
                }

                // 更新用户自定义列信息
                this.UpdateCustomerControlInfo(row, e.Object as CiOrdFeeSrvDTO);
            }
          
            
        }
        #endregion

        #region 接口

        public void ClearSelectedState(XDataRow row = null)
        {
            if (row == null)
            {
                var listSelectedRows = tableGridControl.GetSelectedRows();
                if (listSelectedRows != null)
                {
                    for (int index = listSelectedRows.Count - 1; index >= 0; --index)
                    {
                        listSelectedRows[index].Selected = false;
                    }
                }
            }
            else
            {
                row.Selected = false;
            }
        }

        /// <summary>
        /// 获取模型对象
        /// </summary>
        /// <returns></returns>
        public BaseBizViewModel GetModel()
        {
            return this.model;
        }

        /// <summary>
        /// 新增空行事件处理
        /// </summary>
        public void OnAdd()
        {
            if (IsLoading)
            {
                return;
            }
            

            if (tableGridControl.DataTable.SelectedRows.Count > 0)
            {
                var rowDS = tableGridControl.DataTable.SelectedRows[0].RowDataSource as CiOrdFeeSrvDTO;
                if (rowDS != null && !this.model.HasEmptyFeeSrv(rowDS.Id_or))
                {
                    // 新增后选中行
                    var item = this.model.AddNew();
                    if (null != item)
                    {
                        var row = tableGridControl.DataTable.GetRow(item);
                        if (null != row)
                        {
                            row.Selected = true;
                            row.ColumnCellDict["Name_srv"].Focus();
                            row.DataTable.ParentControl.ShowEditor();
                        }
                    }
                }
                         
                isDirty = true;
             }
            
        }

        /// <summary>
        /// 删除空行事件处理
        /// </summary>
        public void OnDelete()
        {
            // 判断是否处于异步数据加载中，如果是，则返回停止删除动作
            if (IsLoading)
            {
                return;
            }

            // 定义错误变量
            String errInfo = "";

            // 判断当前是否选中了列表中的条目，且只选择了一条
            if (tableGridControl.DataTable.SelectedRows.Count == 1) {

                // 获取选中的元数据对象
                CiOrdFeeSrvDTO b = tableGridControl.DataTable.SelectedRows[0].RowDataSource as CiOrdFeeSrvDTO;

                // 判断是否允许编辑
                if (model.AllowEdit(b)) {

                    // 暂存分组信息
                    string id_or = b.Id_or;
                    // 删除选中的元数据对象
                    this.model.Delete(b);
                    // 获取所删除分组的医嘱的费用集合的最后一条记录，并作为删除操作后的选中条目
                    var srv = this.model.GetLastOfFeeSrv(id_or);
                    if (null != srv)
                    {
                        var rowObj = tableGridControl.DataTable.GetRow(srv) as XDataRow;
                        if (rowObj != null)
                        {
                            rowObj.Selected = true;
                        }
                    }
                    // 设置编辑标志
                    isDirty = true;
                }
                else {
                    errInfo = ("不能删除临床项目费用");
                }
                
            }
            else if (tableGridControl.DataTable.SelectedRows.Count == 0)
            {
                errInfo = ("请选择一条治疗操作费用记录");
            }
            else
            {
                errInfo = "不能删除多个费用";
            }

            if (!String.IsNullOrEmpty(errInfo)) {
                this.ShowInfo(errInfo);
            }
        }

        /// <summary>
        /// 保存已经改动的费用清单
        /// </summary>
        public void OnSave()
        {
            this.isError = false;
            // 是否异步数据加载没有完成
            if (IsLoading)
            {
                return;
            }
            // 如果没有修改不执行保存
            
            if (!isDirty)
            {
                return;
            }

            // 表单必填项检查
            if (this.GetXapFormControl().HasErrors)
            {
                this.isError = true;
                this.ShowInfo(string.IsNullOrEmpty(GetXapFormControl().ErrorAlertText) ? "费用清单中存在错误，请改正" : GetXapFormControl().ErrorAlertText);
                return;
            }

            if (!this.model.Save()) {
                this.isError = true;
                this.ShowInfo(model.GetErrorMsg());
                LoadData();
            }
            else {
                this.SetStatusMsg("费用清单保存成功");
                isDirty = false;
                var eventDic = new DictionaryEventArgs();
                eventDic.Data[UIConst.UI_EVENT] = "EmsFeesControl";
                this.FireEventSent(this, eventDic);
                LoadData();
               
            }
        }

        public void OnCancel()
        {
            isDirty = false;
            
            LoadData();
        }

        #endregion

        #region 私有方法
        /// <summary>
        /// 解析医嘱控件的xml配置
        /// </summary>
        /// <param name="path">医嘱控件对应的配置文件路径</param>
        /// <returns></returns>
        private DoctorOrderConfig Deserialize(string path)
        {
            DoctorOrderConfig doctorCfg = null;
            using (FileStream fs = new FileStream(path, FileMode.Open, FileAccess.Read)) {
                XmlSerializer xml = new XmlSerializer(typeof(DoctorOrderConfig));
                doctorCfg = (DoctorOrderConfig)xml.Deserialize(fs);
            }
            return doctorCfg;
        }
        /// <summary>
        /// 更新自定义 计量列信息
        /// </summary>
        /// <param name="row"></param>
        /// <param name="drug"></param>
        [Obsolete("警告：以后不再使用，请勿使用")]
        void UpdateCustomerControlInfo_1(XDataRow row, CiOrdFeeSrvDTO drug)
        {
            if (drug == null) {
                return;
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_med_unit")) {
                if (drug.Quan_med == null)
                    drug.Quan_med = 0;
                if (drug.Name_unit_med == null)
                    drug.Name_unit_med = "";
                string strMed_unit = drug.Quan_med + drug.Name_unit_med;
                row.ColumnCellDict["customercolumn_med_unit"].SetValue(strMed_unit);
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_sale_unit")) {

                if (drug.Quan_cur == null)
                    drug.Quan_cur = 0;
                if (drug.Name_unit_sale == null)
                    drug.Name_unit_sale = "";
                string strMed_unit = drug.Quan_cur + drug.Name_unit_sale;
                row.ColumnCellDict["customercolumn_sale_unit"].SetValue(strMed_unit);
            }
        }

        void UpdateCustomerControlInfo(XDataRow row, CiOrdFeeSrvDTO drug)
        {
            if (drug == null) {
                return;
            }

            String spltStr = "";
            // 非物品的总量单位默认都为 医学计量单位
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_med_unit")) {
                if (drug.Fg_mm == null || !drug.Fg_mm.Value) {
                    if (drug.Quan_total_medu == null)
                        drug.Quan_total_medu = 0;
                    if (drug.Name_unit_med == null)
                        drug.Name_unit_med = "";

                    if(drug.Name_unit_med.Length > 0 && IsNumberic(drug.Name_unit_med.Substring(0,1)))
                    {
                        spltStr = "*";
                    }
                    string strMed_unit = drug.Quan_total_medu + spltStr + drug.Name_unit_med;
                    row.ColumnCellDict["customercolumn_med_unit"].SetValue(strMed_unit);
                }
                else {
                    if (drug.Quan_cur == null)
                        drug.Quan_cur = 0;
                    if (drug.Name_unit_med == null)
                        drug.Name_unit_med = "";
                    if (drug.Name_unit_med.Length > 0 && IsNumberic(drug.Name_unit_med.Substring(0, 1)))
                    {
                        spltStr = "*";
                    }
                    string strMed_unit = drug.Quan_cur + spltStr + drug.Name_unit_sale;
                    row.ColumnCellDict["customercolumn_med_unit"].SetValue(strMed_unit);
                }
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_ord_colligate"))
            {
                row.ColumnCellDict["customercolumn_ord_colligate"].SetValue(drug.getAttrVal("Ord_colligate"));
            }
           
        }

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
        /// 判定允许编辑单元格
        /// </summary>
        /// <param name="propName"></param>
        /// <param name="ds"></param>
        /// <returns></returns>
        bool EnableAllowEdit(String propName, CiOrdFeeSrvDTO ds)
        {
            return model.AllowEdit(ds);
        }

        protected bool CanEditHp()
        {
            CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
            //保外诊断标识
            string eu_hpbeyond = ciEnContextDTO.Eu_hpbeyond;
            //医保是否启用标识
            //this.Context.GetOrgParam<bool>(ICiOrdNSysParamConst.SYS_PARAM_IsMedicalInsuranceEnable);
            if ( true == ciEnContextDTO.Fg_hpfundpay && HpBeyondEnum.HPDIAG.Equals(ciEnContextDTO.Eu_hpbeyond)/*保内诊断*/ && isMedicalInsuranceEnable && this.opMedInsuranceAuditHandel == 0)
            {
                return true;
            }
            return false;
        }

        public void showHpDialog(object sender)
        {
            var row = sender as XDataRow;
            CiOrdFeeSrvDTO emsordrug = row.DataSource as CiOrdFeeSrvDTO;
            if (emsordrug != null) {
                if (row.ClickCell.FieldName.Equals("Fg_indic")) {
                    FArrayList bdhpdtos = emsordrug.BdHpIndicationList;
                    if (bdhpdtos == null) {
                        bdhpdtos = new FArrayList();
                        BdHpIndicationDTO dto = HpJudgeUtil.getInstance().getBdHpIndicationDTO(emsordrug.Id_srv, emsordrug.Id_mm, this.GetModel().GetEnt4BannerDTO());
                        if (dto != null) {
                            bdhpdtos.Add(dto);
                        }
                        emsordrug.BdHpIndicationList = bdhpdtos;
                    }
                    if (bdhpdtos != null && bdhpdtos.Count > 0) {
                        BdHpIndicationDTO bdhpdto = bdhpdtos[0] as BdHpIndicationDTO;
                        string code_hpindicjudged = bdhpdto.Code_hpindicjudged;
                        bool? isDefault = null;
                        if (code_hpindicjudged == "12")
                        {
                            isDefault = emsordrug.Fg_treat;
                        }
                        if (code_hpindicjudged != null) {
                            switch (code_hpindicjudged) {
                                case "12":
                                case "21":
                                    BdHpIndicationDTOForm dialog = new BdHpIndicationDTOForm(emsordrug.Limit, emsordrug.Name_srv, isDefault);
                                    if (dialog.ShowDialog() == DialogResult.OK) {
                                        emsordrug.Fg_indic = true;
                                        emsordrug.Fg_selfpay = false;
                                    }
                                    else {
                                        emsordrug.Fg_indic = false;
                                        emsordrug.Fg_selfpay = true;
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
        #endregion
    }
}
