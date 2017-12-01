using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.forms.model;
using xap.rui.control.forms.control;
using xap.cli.sdk.controls.tabControl;
using xap.rui.control.refcontrol.events;
using xap.cli.sdk.controls.DataView.Model;
using xap.rui.appfw;
using xap.rui.control.extentions;
using xap.cli.sdk.controls.DataView;
using iih.ci.iih.ci.ord.pub;
using iih.bd.bc.udi;
using iih.en.pv.dto.d;
using iih.bd.srv.deptstd2diag.d;
using xap.mw.coreitf.d;
using xap.rui.control.refcontrol.data;
using iih.bd.bc.cdsys.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.tool;
using xap.cli.sdk.controls;
using iih.ci.ord.opemergency.orddi.model;
using xap.rui.bizcontrol.bannerview;
using iih.ci.ord.opemergency.command;
using xap.rui.control.commands;
using xap.cli.sdk.form;
using iih.bd.srv.diagdef.d;
using iih.ci.ord.opemergency.action.costant;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.common.utils.msg;
using xap.mw.core.data;
using iih.ci.ord.common.utils;
using xap.cli.sdk.common.globalization;
using iih.ci.ord.opemergency.operateaction.baseoperate;
using iih.ci.diag.dto.d;
using iih.ci.diag.dto.judgedideletedto.d;
using iih.ci.ord.dto.d;
using iih.ci.ord.medicaresharing;
using xap.rui.engine.eventbroker;
using xap.rui.engine.eventbroker.Handlers;
using iih.ci.ord.opemergency.operateaction.opcomplete.view;
using iih.ci.ord.opemergency.orddi.didepend;
using xap.cli.sdk.common;
using iih.ci.ord.opemergency.orderlist.view;
using xap.rui.control.querycontrol.QuerySchema.Tools;
using xap.cli.sdk.controls.DataView.Extension.XOrderResult;

namespace iih.ci.ord.opemergency.orddi
{
    /// <summary>
    /// <para>描    述 : 门急诊医生工作站- 诊断维护视图    </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.view       </para>    
    /// <para>类 名 称 : DiListView                      </para> 
    /// <para>版 本 号 : v1.0.0.0                          </para> 
    /// <para>作    者 : qzwang                            </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05                </para>
    /// <para>修 改 人 :                                   </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05                </para> 
    /// <para>说    明 :                                   </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class DiListView : XapListControl, IPageCommand
    {
        #region 变量定义区域
        private XLayoutPanel panel;
        private XapFormControl xapFormControl;
        private XapBaseControl ownerControl;
        private XapFormGridControl controlxy;
        private XapFormGridControl controlzy;

        private ICallbackAction callbackAction;

        // 诊断明细条目模型
        private DiListViewModel model = new DiListViewModel();

        private Ent4BannerDTO ent4BannerDto;

        // 当前页签
        private int curSelTabIndex = 0;

        private string Di_standard_name = "";
        // 诊断列表值是否发生改变
        private bool isEdited = false;

        private bool canCheckNullFlag;

        private bool is_CellValueChanged = true;

        private List<PageCommands> pageCommandLsit;

        /// <summary>
        /// 临床诊断系统设置 参数与显示tab页签对应关系 SYS_PARAM_ClinicalDiagSysCfg="CIOR0025" 11  西医、12  中医、13  蒙医
        /// </summary>
        private Dictionary<string, string> dispalyTabPageDic = new Dictionary<string, string> {
            { "11","cidi_xy"},
            { "12","cidi_zy"},
            { "13","cidi_my"}// 目前还没有这个属性
        };

        private const string EmrTriggerSaveDiagEvent = "EmrTriggerSaveDiagEvent";
        #endregion

        #region 构造函数区域
        public DiListView()
        {
            UseInnerButton = false;
            InitializeComponent();
            this.xapFormControl.Load += new EventHandler(xapFormControl_Load);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);            
            canCheckNullFlag = false;
        }

        private void InitializeComponent()
        {
            this.xapFormControl = new xap.rui.control.forms.view.XapFormControl();
            panel = new XLayoutPanel();
            this.SuspendLayout();
            // 
            // xapFormControl1
            // 
            this.xapFormControl.AutoSize = true;

            panel.Dock = DockStyle.Fill;

            this.xapFormControl.Context = null;
            this.xapFormControl.File = null;
            this.xapFormControl.Location = new System.Drawing.Point(0, 0);
            this.xapFormControl.Name = "xapFormControl1";
            this.xapFormControl.Size = new System.Drawing.Size(592, 365);
            this.xapFormControl.TabIndex = 0;
            this.xapFormControl.ViewFile = null;

            panel.AddControl(this.xapFormControl, ControlPosition.Center);
            this.AddRender(panel);
            this.Name = "didtoMgrView";
            this.ResumeLayout(false);
            this.PerformLayout();
        }
        #endregion

        #region 公开属性区域
        public bool IsOrdersEmpty = false;

        public bool UseInnerButton { get; set; }

        public void SetEnt4BannerDTO(Ent4BannerDTO e)
        {
            this.ent4BannerDto = e;
        }
        public void SetOwnerControl(XapBaseControl o)
        {
            this.ownerControl = o;
        }

        public void SetCallbackAction(ICallbackAction a)
        {
            this.callbackAction = a;
        }

        public ICallbackAction GetCallbackAction()
        {
            return this.callbackAction;
        }
        #endregion

        #region 命令定义区域
        /// <summary>
        /// 新增
        /// </summary>
        private void onAdd()
        {
            BaseDTO dto;
            if (this.curSelTabIndex == 0)
            {
                dto = new Cidixy();
                this.model.xyCidiList.Add(dto as Cidixy);
            }
            else
            {
                dto = new Cididtozy();
                this.model.zyCidiList.Add(dto as Cididtozy);
            }
            if (GetCallbackAction() != null)
                GetCallbackAction().OnAddAction(dto);
        }

        /// <summary>
        /// 删除
        /// </summary>
        private void onDelete()
        {
            checkValidate4Delete(this.curSelTabIndex == 0 ? controlxy : controlzy);
        }

        /// <summary>
        /// 保存
        /// </summary>
        private void onSave(bool bCheckEmpty, bool isEmpty)
        {
            if (this.toSave(bCheckEmpty, isEmpty))
            {
                AssToolEx.SentMessage(ownerControl == null ? this : ownerControl, EventCodeType.EVENT_ORDI_SAVESUCCE, "DIDTOLIST",
                    this.model.SaveResult == null ? null : new List<DIDTO>(this.model.SaveResult), this.model.GetPatDiDescription());
                this.xapFormControl.SaveForm();
                isEdited = false;
                this.SetStatusMsg("诊断保存成功！");

                if (GetCallbackAction() != null)
                {
                    GetCallbackAction().OnCancelAction(this.model.GetPatDiDescription());
                }
            }
        }

        /// <summary>
        /// 保存
        /// </summary>
        /// <param name="bCheckNull"></param>
        /// <returns></returns>
        private bool toSave(bool bCheckEmpty, bool isEmpty)
        {
            if (this.model.IsEmptyModel())
            {
                if (RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO)
                {
                    var OrdGridView = this.Context.Config.GetInstance("OrdListView") as OrdGridView;
                    if (null != OrdGridView)
                    {
                        IsOrdersEmpty = OrdGridView.IsOrdersEmpty();
                    }
                }
                if (IsOrdersEmpty)
                {
                    if (isEmpty || this.IsContinue("提示", "是否确认清空当前诊断？"))
                    {
                        this.model.saveEmptyDI(this.ent4BannerDto);
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    if (bCheckEmpty)
                    {
                        BizAssMessageBoxUtil.ShowWarningMsg("已经开立医嘱，请先下达诊断！");
                        resetGridCellFocus(controlxy, true);
                    }
                    return false;
                }
            }
            else
            {
                // 检查数据是否有主诊断，没有的话默认第一条为主诊断
                this.checkValidata4Majdi();
                //补充诊断不验证主诊断
                if (this.model.HeadDiDiagDO.Sd_ditp != CiDictCodeConst.SD_SUPPLY)
                {
                    string validate = this.CheckValidate4Save();
                    if (validate.Length > 0)
                    {
                        this.ShowInfo(validate);
                        return false;
                    }
                }

                this.model.save(this.ent4BannerDto);
                isEdited = false;
                if (this.model.SaveResult != null && this.model.SaveResult.Length > 0)
                {
                    foreach (DIDTO diDTO in this.model.SaveResult)
                    {
                        if (diDTO.Eu_hpbeyond == HpBeyondEnum.HPEXTERNALDIAG)
                        {
                            //BizAssMessageBoxUtil.ShowWarningMsg("存在保外诊断，患者应全额自费!");
                            AssToolEx.SentMessage(ownerControl == null ? this : ownerControl, EventCodeType.EVENT_EMS_REFRESH);
                            break;
                        }
                    }
                }
            }
            return true;
        }

        /// <summary>
        /// 保存成功
        /// </summary>
        private void onSaveSucess()
        {
            if (this.UseInnerButton && this.model != null && this.ent4BannerDto != null)
            {
                controlxy.DataTable.CellValueChanged -= controlxy_DataTable_CellValueChanged;
                this.model.Reload(this.ent4BannerDto.Id_ent);
                controlxy.DataTable.CellValueChanged += controlxy_DataTable_CellValueChanged;
            }
            if (this.controlxy != null && this.controlxy.DataTable != null && this.controlxy.DataTable.Rows.Count > 0)
                this.controlxy.DataTable.Rows[this.controlxy.DataTable.Rows.Count - 1].Selected = false;
        }

        /// <summary>
        /// 关闭
        /// </summary>
        private void onCancel()
        {
            if (isEdited)
            {
                if (!CommonExtentions.IsContinue(this, "提示", "已修改的诊断未保存，确认要关闭吗？"))
                {
                    return;
                }
            }

            if (GetCallbackAction() != null)
            {
                GetCallbackAction().OnCancelAction();
            }
        }
        #endregion

        #region 事件接收区域

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if (!Created) return;
            bool enableEdit = true;
            
            // 选择消息来自 科室常用 辅助录入表单
            if (sender is bannerOpdocstation)
            {
                var t1 = new AssCostTimeTool("切换患者时候，诊断列表加载耗时：", false);
                this.ent4BannerDto = null;
                if (null != this.model)
                {
                    this.model.ClearAll();
                    this.SetDataPolicy(false);
                    enableEdit = false;
                }

                if (e.Object != null)
                {
                    this.ent4BannerDto = (e.Object as xap.rui.bizcontrol.bannercontrol.BannerData).Ent4BannerDTO;

                    if (this.ent4BannerDto != null)
                    {
                        this.model.Reload(this.ent4BannerDto.Id_ent);
                        this.xapFormControl.SetFormModified(false); // 数据加载结束后设置表单状态为未修改，否则关闭节点会有是否保存提示
                        this.SetDataPolicy(this.ent4BannerDto.Sd_status != EnDictCodeConst.SD_ENSTATUS_OP_FINISH);
                        enableEdit = this.ent4BannerDto.Sd_status != EnDictCodeConst.SD_ENSTATUS_OP_FINISH;
                    }
                }
                t1.SaveTimeLog();
            }
            
            if (enableEdit)
            {
                if (null != this.controlxy && this.controlxy.Visible)
                {
                    int nIndex = this.model.DefaultLastXYDi();
                   
                    this.controlxy.DataTable.Rows[nIndex].Selected = true;
                    this.controlxy.DataTable.Rows[nIndex].Focused = true;
                    this.controlxy.DataTable.Rows[nIndex].ColumnCellDict["Id_didef_name"].Focus();
                    this.controlxy.DataTable.ParentControl.ShowEditor();
                }
                else
                {
                    int nIndex = this.model.DefaultLastZYDi();
                    this.controlzy.DataTable.Rows[nIndex].Selected = true;
                    this.controlzy.DataTable.Rows[nIndex].Focused = true;
                    this.controlzy.DataTable.Rows[nIndex].ColumnCellDict["Id_disease_name"].Focus();
                    this.controlzy.DataTable.ParentControl.ShowEditor();
                }
            }
            
        }

        [EventSubscription(EmrTriggerSaveDiagEvent, typeof(OnPublisher))]
        public void ReceivePubCiMr()
        {

        }
        #endregion

        #region 父类继承区域

        protected override void OnLoadData()
        {
            // 根据就诊ID, 创建模型
            if (this.ent4BannerDto != null)
                this.model.Reload(this.ent4BannerDto.Id_ent);
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_OP_DiListView;// "20160514090334695P4G";

            file.FormStyle = FormStyle.List;

            if (this.model != null)
            {
                file.ViewModel = this.model;
            }

            xapFormControl.ViewFile = file;

            this.SetDataPolicy(true);
        }

        #endregion

        #region 内部事件区域
        /// <summary>
        /// 加载
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl_Load(object sender, EventArgs e)
        {
            // 该方法能够触发 onLoadData 和 onFillData 事件机制
            this.OnInit();
        }

        /// <summary>
        /// 创建窗体
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            controlxy = (XapFormGridControl)this.xapFormControl.GetGridView("cidi_xy");
            controlzy = (XapFormGridControl)this.xapFormControl.GetGridView("cidi_zy");

            // 先去掉表格值改变事件，否则导致重复注册表格值改变事件
            if (this.controlxy != null && this.controlxy.DataTable != null)
            {
                controlxy.DataTable.CellValueChanged += controlxy_DataTable_CellValueChanged;
                if (this.controlxy.DataTable.Rows.Count > 0)
                    this.controlxy.DataTable.Rows[this.controlxy.DataTable.Rows.Count - 1].Selected = false;
            }
            if (this.controlzy != null && this.controlzy.DataTable != null)
            {
                controlzy.DataTable.CellValueChanged += controlzy_DataTable_CellValueChanged;
            }

            this.xapFormControl.TabPageSelectChanged += xapFormControl_TabPageSelectChanged;
            this.xapFormControl.RefResult += xapFormControl_RefResult;
            this.xapFormControl.RefFilter += xapFormControl_RefFilter;
            this.xapFormControl.RefCanSelect += xapFormControl_RefCanSelect;
            this.xapFormControl.RefCanRemove += XapFormControl_RefCanRemove;
            this.xapFormControl.ModelFilled += xapFormControl_ModelFilled;
            this.xapFormControl.AllowEditing += xapFormControl_AllowEditing;
            this.xapFormControl.DataDisplay += xapFormControl_DataDisplay;
            this.xapFormControl.EnterKeyDown += new EventHandler<KeyEventArgs>(xapFormControl_EnterKeyDown);

            this.AllowCheckNullWith(controlxy, canCheckNullFlag);
            this.AllowCheckNullWith(controlzy, canCheckNullFlag);

            // 获取当前科室，有关中西医标签配置标记
            string sysparam = this.model.SysParam;
            string[] dispalyParams;
            if (string.IsNullOrEmpty(sysparam))
            {
                dispalyParams = new string[] { "11" };
            }
            else
            {
                dispalyParams = sysparam.Split(',');
            }

            // 初始化时先将页签设置为隐藏状态，再根据配置的值加载对应的诊断页签
            this.xapFormControl.ShowTabPage("cidi_xy", false);// 西医诊断页签
            this.xapFormControl.ShowTabPage("cidi_zy", false);// 中医诊断页签

            foreach (string param in dispalyParams)
            {
                // 根据配置系统参数显示不同的诊断页签
                if (dispalyTabPageDic.ContainsKey(param))
                {
                    string tabPageId = dispalyTabPageDic[param];
                    this.xapFormControl.ShowTabPage(tabPageId, true);//显示对应的诊断页签

                    if (UseInnerButton)
                    {
                        if (pageCommandLsit == null)
                        {
                            pageCommandLsit = new List<PageCommands>();
                        }

                        this.adjustGridColumns(param == "11" ? controlxy : controlzy);
                        this.SetDataPolicy(false);
                        PageCommands pageCommands = OrdListDiGridCommand.PageCommandsWith(tabPageId, this, false);
                        this.xapFormControl.SetupCommands(new PageCommands[] { pageCommands });
                        pageCommandLsit.Add(pageCommands);
                    }
                }
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="gv"></param>
        /// <param name="allow"></param>
        private void AllowCheckNullWith(XapFormGridControl gv, bool allow = true)
        {
            if (null == gv)
            {
                return;
            }

            foreach (XDataColumn column in gv.DataTable.Columns)
            {
                column.AllowCheckNull = allow;
            }
        }

        /// <summary>
        /// 调整表格列宽
        /// </summary>
        /// <param name="grid"></param>
        private void adjustGridColumns(XapFormGridControl grid)
        {
            if (grid != null && UseInnerButton)
            {
                int leftSpace = this.Size.Width - 2;
                foreach (XDataColumn col in grid.DataTable.Columns)
                {
                    col.Visible = !col.FieldName.Equals("Id_didef_code") && !col.FieldName.Equals("Id_disease_code") && !col.FieldName.Equals("Id_syndrome_code");

                    leftSpace -= (!col.Visible || col.FieldName.Equals("Supplement") || col.FieldName.Equals("Id_syndrome_name") ? 0 : col.Width) + 1;
                }
                XDataColumn adaptColumn = grid.DataTable.Columns["Supplement"];
                if (adaptColumn == null)
                {
                    adaptColumn = grid.DataTable.Columns["Id_syndrome_name"];
                }
                if (adaptColumn != null)
                {
                    adaptColumn.Width = leftSpace - 1;
                }
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl_EnterKeyDown(object sender, KeyEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            if (row.RowData["Id_didef_name"] != null && !String.IsNullOrEmpty(row.RowData["Id_didef_name"].ToString()))
            {
                if (row.IsLast)
                {
                    this.onAdd();
                }
                row.DataTable.Rows[row.Index + 1].Selected = true;
                row.DataTable.Rows[row.Index + 1].Focused = true;
                row.DataTable.Rows[row.Index + 1].ColumnCellDict["Id_didef_name"].Focus();
                row.DataTable.ParentControl.ShowEditor();
            }
            e.Handled = true;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl_DataDisplay(object sender, XDataDisplayEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            if (row != null)
            {
                this.setRowImageAndColor(new XDataRow[] { row }, false);
            }
        }
       
        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            if (e.Object is Cidixy && this.model.IsEmpty(e.Object as Cidixy))
            {
                e.Cancel = !e.PropName.Equals("Id_didef_name");
            }
            else if (e.Object is Cididtozy && this.model.IsEmpty(e.Object as Cididtozy))
            {
                e.Cancel = !e.PropName.Equals("Id_disease_name") && !e.PropName.Equals("Id_syndrome_name");
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            {
                this.controlxy.DataTable.DataSource = this.model.xyCidiList;
                this.controlzy.DataTable.DataSource = this.model.zyCidiList;

                if (this.model.xyCidiList.Count > 0)
                {
                    this.controlxy.ShowEditor(this.model.xyCidiList[0], "Id_didef_name");
                    this.controlxy.DataTable.Rows[0].Selected = true;
                }

                if (this.model.zyCidiList.Count > 0)
                {
                    this.controlzy.DataTable.Rows[0].Selected = true;
                }
            }            
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl_TabPageSelectChanged(object sender, EventArgs e)
        {
            XTabPage selectedPage = (XTabPage)sender;
            // 此处应该讲 Owner 属性放开，外界能够直接根据TabPage获取TabControl 对象
            XTabControl tabControl = (XTabControl)selectedPage.Parent.Parent;
            this.curSelTabIndex = tabControl.SelectedIndex;
        }

        /// <summary>
        /// 参照结果
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl_RefResult(object sender, xap.rui.control.refcontrol.events.RefResultEventArgs e)
        {
            if (e.RefResultSet.IsEmpty)
            {
                this.getRowImage(this.controlxy.GetFocusedRow(), "");
                return;
            }
            RefDataCollection data = e.RefResultSet;
            if (e.BindingFieldName.Equals("Id_didef_name"))
            {
                string Id_didef_name = data.FirstData["Id_cdsys"] as string;
                MedCdSystemDO[] ms = this.model.GetMedCdSystemList(Id_didef_name, 1);
                if (ms == null || ms.Length <= 0)
                {
                    e.DataObject.SetPropValue("Id_didef_name", null);
                    e.DataObject.SetPropValue("Id_didef_code", null);
                    e.DataObject.SetPropValue("Id_didef", null);
                    e.DataObject.SetPropValue("Di_standard", null);
                    e.DataObject.SetPropValue("Id_disys", null);
                    this.ShowInfo("此选项没有标准,请重新选择", "提示");
                }
                else
                {
                    e.DataObject.SetPropValue("Di_standard", ms[0].Id_cdsys);
                    e.DataObject.SetPropValue("Di_standard_code", ms[0].Code);
                    e.DataObject.SetPropValue("Di_standard_name", ms[0].Name);
                }
                this.setRowImageAndColor(new XDataRow[] { this.controlxy.GetFocusedRow() }, true);
            }
            else if (e.BindingFieldName.Equals("Id_disease_name"))
            {
                string Id_disease_name = data.FirstData["Id_cdsys"] as string;
                MedCdSystemDO[] ms = this.model.GetMedCdSystemList(Id_disease_name, 2);
                if (ms == null || ms.Length <= 0)
                {
                    e.DataObject.SetPropValue("Id_disease_name", null);
                    e.DataObject.SetPropValue("Id_disease_code", null);
                    e.DataObject.SetPropValue("Id_disease", null);
                    e.DataObject.SetPropValue("Di_standard", null);
                    e.DataObject.SetPropValue("Id_disys", null);
                    this.ShowInfo("此选项没有标准,请重新选择", "提示");
                }
                else
                {
                    e.DataObject.SetPropValue("Di_standard", ms[0].Id_cdsys);
                    e.DataObject.SetPropValue("Di_standard_code", ms[0].Code);
                    e.DataObject.SetPropValue("Di_standard_name", ms[0].Name);
                }
                Di_standard_name = data.FirstData["Id_cdsys"] as string;
                this.setRowImageAndColor(new XDataRow[] { this.controlzy.GetFocusedRow() }, true);
            }
            else if (e.BindingFieldName.Equals("Id_syndrome_name"))
            {
                string Id_didef_name = data.FirstData["Id_cdsys"] as string;
                MedCdSystemDO[] ms = this.model.GetMedCdSystemList(Id_didef_name, 2);
                if (ms == null || ms.Length <= 0)
                {
                    e.DataObject.SetPropValue("Id_syndrome_name", null);
                    e.DataObject.SetPropValue("Id_syndrome_code", null);
                    e.DataObject.SetPropValue("Id_syndrome", null);
                    e.DataObject.SetPropValue("Di_standard", null);
                    e.DataObject.SetPropValue("Id_disys", null);
                    this.ShowInfo("此选项没有标准,请重新选择", "提示");
                }
                else
                {
                    e.DataObject.SetPropValue("Di_standard", ms[0].Id_cdsys);
                    e.DataObject.SetPropValue("Di_standard_code", ms[0].Code);
                    e.DataObject.SetPropValue("Di_standard_name", ms[0].Name);
                }
                Di_standard_name = data.FirstData["Id_cdsys"] as string;
            }

            isEdited = true;
        }

        /// <summary>
        /// 参照是否可用
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void xapFormControl_RefCanSelect(object sender, xap.rui.control.refcontrol.events.RefCanSelectEventArgs e)
        {
            string code = e.SelectingData["Code"] as string;
            string name = e.SelectingData["Name"] as string;
            
            string repeatMsg = "";
            // 判断是否存在重复诊断
            if (IsContainsRepeatDidef(code, name, ref repeatMsg))
            {
                e.Message = repeatMsg;
                e.Cancel = true;
                return;
            }

            //诊断参照是否可切换，当医保就诊时，诊断存在关联的医嘱，不允许切换诊断
            Cidixy cidiDO = e.DataObject as Cidixy;
            if (cidiDO != null && cidiDO.Id_didef_code != null)
            {
                this.model.AllList.Add(cidiDO.Id_didef_code);
            }
            BaseDTO cidiDTO = e.DataObject as BaseDTO;
            if (isCiDiRelateCiOrders(cidiDTO)) 
            {
                e.Cancel = true;
            }            
        }

        /// <summary>
        /// 参照是否可删除
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void XapFormControl_RefCanRemove(object sender, RefCanRemoveEventArgs e)
        {
            
            BaseDTO cidiDTO = e.DataObject as BaseDTO;
            
            if (isCiDiRelateCiOrders(cidiDTO))
            {
                e.Cancel = true;
            }
        }

        /// <summary>
        /// 参照条件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void xapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            e.SearchText = QueryHelper.SQLEnCode(e.SearchText);
            //诊断
            if (e.BindingFieldName == "Id_didef_name")
            {
                e.WherePart = " bd_di_def.fg_active ='Y' and  bd_di_def.id_cdsystp ='" + CiDictCodeConst.ID_CI_DISYS_XYZDTX + "'";
            }
            //疾病
            else if (e.BindingFieldName == "Id_disease_name")
            {
                if (Di_standard_name != null)
                {
                    e.WherePart = " bd_di_def.fg_active ='Y' and  bd_di_def.id_cdsystp ='" + CiDictCodeConst.ID_CI_DISYS_ZYZDTX + "' and bd_di_def.fg_ds='N' and bd_di_def.id_cdsys = '" +
                                  Di_standard_name + "'";
                }
                else
                {
                    e.WherePart = " bd_di_def.fg_active ='Y' and  bd_di_def.id_cdsystp ='" + CiDictCodeConst.ID_CI_DISYS_ZYZDTX + "' and bd_di_def.fg_ds='N' ";
                }
            }
            //病症
            else if (e.BindingFieldName == "Id_syndrome_name")
            {
                if (Di_standard_name != null)
                {
                    e.WherePart = " bd_di_def.fg_active ='Y' and  bd_di_def.id_cdsystp ='" + CiDictCodeConst.ID_CI_DISYS_ZYZDTX + "' and bd_di_def.fg_ds='Y' and bd_di_def.id_cdsys = '" +
                                  Di_standard_name + "'";
                }
                else
                {
                    e.WherePart = " bd_di_def.fg_active ='Y' and  bd_di_def.id_cdsystp ='" + CiDictCodeConst.ID_CI_DISYS_ZYZDTX + "' and bd_di_def.fg_ds='Y'";
                }
            }
            //参照拼音码五笔码配置条件
            e.RefParams.AddParam("inputmethod", IndividualSettings.GetUserIndividualSetting(IndividualSettingConst.InputMethod));
        }

        /// <summary>
        /// 西医单元格值改变事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void controlxy_DataTable_CellValueChanged(object sender, XCellValueChangedEventArgs e)
        {
            onCellValueChanged(e.Column.FieldName, "xy", sender);
        }

        /// <summary>
        /// 中医单元格值改变事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void controlzy_DataTable_CellValueChanged(object sender, XCellValueChangedEventArgs e)
        {
            onCellValueChanged(e.Column.FieldName, "zy", sender);
        }

        /// <summary>
        /// 单元格值改变
        /// </summary>
        /// <param name="strColumn"></param>
        /// <param name="strCidiType"></param>
        /// <param name="sender"></param>
        private void onCellValueChanged(string strColumn, string strCidiType, object sender)
        {
            if (is_CellValueChanged)
            {
                if (strColumn == "Fg_majdi")
                {
                    is_CellValueChanged = false;
                    xap.cli.sdk.controls.DataView.Renders.XDataViewCheckBox ckBox = sender as xap.cli.sdk.controls.DataView.Renders.XDataViewCheckBox;
                    if (ckBox != null)
                    {
                        this.setMasterDiagInfo(ckBox.Row.RowDataSource);
                    }
                    is_CellValueChanged = true;
                }
            }
            this.isEdited = true;
        }
        #endregion

        #region 辅助处理函数
        /// <summary>
        /// 诊断助手获取诊断集合
        /// </summary>
        /// <param name="diagDefDOs"></param>
        private void getDiFromHelper(DiagDefDO[] diagDefDOs)
        {
            List<DiagDefDO> lstDiagDefDOs = diagDefDOs.ToList<DiagDefDO>();
            if (lstDiagDefDOs != null && lstDiagDefDOs.Count > 0)
            {
                // 检查添加的诊断是否重复
                string errorInfoString = this.checkValidate4Repeat(lstDiagDefDOs);
                if (!String.IsNullOrEmpty(errorInfoString))
                {
                    if (lstDiagDefDOs.Count > 0)
                    {
                        if (!this.IsContinue("操作提示", errorInfoString + "是否继续录入其他诊断？"))
                        {
                            return;
                        }
                    }
                    else
                    {
                        this.ShowInfo(errorInfoString);
                    }
                }

                List<String> lstIdDefs = new List<string>();
                foreach (var diagDefDO in lstDiagDefDOs)
                {
                    lstIdDefs.Add(diagDefDO.Id_didef);
                    if (diagDefDO.Id_cdsystp == CiDictCodeConst.ID_CI_DISYS_XYZDTX && this.model.IsShowXYPage())
                    {
                        getCidixyFromHelper(diagDefDO);
                    }
                    else if (diagDefDO.Id_cdsystp == CiDictCodeConst.ID_CI_DISYS_ZYZDTX && this.model.IsShowZYPage())
                    {
                        getCidizyFromHelper(diagDefDO);
                    }
                }
                List<XDataRow> lstXDataRowxy = new List<XDataRow>();
                List<XDataRow> lstXDataRowzy = new List<XDataRow>();
                foreach (var row in controlxy.DataTable.Rows.DataRowList)
                {
                    if (lstIdDefs.Contains((row.DataSource as Cidixy).Id_didef))
                    {
                        lstXDataRowxy.Add(row);
                    }
                }
                //foreach (var row in controlzy.DataTable.Rows.DataRowList)
                //{
                //    if (lstIdDefs.Contains((row.DataSource as Cididtozy).))
                //    {
                //        lstXDataRowzy.Add(row);
                //    }
                //}

                if (lstXDataRowxy.Count > 0)
                    this.setRowImageAndColor(lstXDataRowxy.ToArray(), true);
                //if (lstXDataRowzy.Count > 0)
                //    this.setRowImageAndColor(lstXDataRowzy.ToArray(), true);
            }
        }

        /// <summary>
        /// 诊断助手获取西医诊断集合
        /// </summary>
        /// <param name="diagDefDO"></param>
        private void getCidixyFromHelper(DiagDefDO diagDefDO)
        {
            bool isNewItem = false;
            controlxy.DataTable.CellValueChanged -= controlxy_DataTable_CellValueChanged;
            controlxy.CloseEditor();
            List<Cidixy> listxy = new List<Cidixy>(this.model.xyCidiList.ToArray());
            isEdited = true;
            Cidixy xy = this.model.GetXYEmptyRow();
            if (xy == null)
            {
                xy = new Cidixy();
                listxy.Add(xy);
                isNewItem = true;
            }
            setCidixyValue(xy, diagDefDO, listxy.IndexOf(xy));

            controlxy.DataTable.CellValueChanged += controlxy_DataTable_CellValueChanged;

            if (isNewItem)
                this.model.xyCidiList.Add(xy);
        }

        /// <summary>
        /// 诊断助手获取中医诊断集合
        /// </summary>
        /// <param name="diagDefDO"></param>
        private void getCidizyFromHelper(DiagDefDO diagDefDO)
        {
            bool isNewItem = false;
            controlzy.DataTable.CellValueChanged -= controlzy_DataTable_CellValueChanged;
            controlzy.CloseEditor();
            List<Cididtozy> listzy = new List<Cididtozy>(this.model.zyCidiList.ToArray());
            isEdited = true;
            Cididtozy zy = this.model.GetZYEmptyRow();
            if (zy == null)
            {
                zy = new Cididtozy();
                listzy.Add(zy);
                isNewItem = true;
            }
            setCidizyValue(zy, diagDefDO, listzy.IndexOf(zy));

            // 检查添加的常用诊断，在中医列表中是否有重复
            controlzy.DataTable.CellValueChanged += controlzy_DataTable_CellValueChanged;

            if (isNewItem)
                this.model.zyCidiList.Add(zy);
        }

        /// <summary>
        /// 西医诊断对象转换
        /// </summary>
        /// <param name="cidixy"></param>
        /// <param name="diDO"></param>
        /// <param name="index"></param>
        private void setCidixyValue(Cidixy cidixy, DiagDefDO diDO, int index)
        {
            MedCdSystemDO[] ms = model.GetMedCdSystemList(diDO.Id_cdsys, 1);

            cidixy.Id_ditp = this.model.HeadDiDiagDO.Id_ditp;
            cidixy.Id_ditp_code = this.model.HeadDiDiagDO.Code_ditp;
            cidixy.Id_ditp_name = this.model.HeadDiDiagDO.Code_ditp;

            cidixy.Id_didef = diDO.Id_didef;
            cidixy.Id_didef_code = diDO.Code;
            cidixy.Id_didef_name = diDO.Name;
            //cidixy.Supplement
            cidixy.Id_dep_create = this.Context.Dept.Id_dep;
            cidixy.Id_dep_creat_name = this.Context.Dept.Name;
            cidixy.Fg_suspdi = false;
            //cidixy.Fg_majdi
            checkValidata4Majdi();

            cidixy.Di_standard = diDO.Id_cdsys;
            cidixy.Di_standard_code = diDO.Cdsys_code;
            cidixy.Di_standard_name = diDO.Cdsys_name;

            cidixy.Id_disys = diDO.Id_cdsystp;
            cidixy.Sd_disys = diDO.Sd_cdsystp;
            //cidixy.Id_disys_name

            cidixy.Fg_self = false;
            //cidixy.Id_parent
            cidixy.Sortno = index.ToString();

            cidixy.Fg_ur = diDO.Fg_ur;
            cidixy.Fg_chronic = diDO.Fg_chronic;
            cidixy.Fg_special = diDO.Fg_special;
            cidixy.Id_infectiontp = diDO.Id_infectiontp;
            cidixy.Sd_infectiontp = diDO.Sd_infectiontp;
        }

        /// <summary>
        /// 中医诊断对象转换
        /// </summary>
        /// <param name="cidizy"></param>
        /// <param name="diDO"></param>
        /// <param name="num"></param>
        /// <param name="index"></param>
        private void setCidizyValue(Cididtozy cidizy, DiagDefDO diDO, int index)
        {
            cidizy.Id_ditp = this.model.HeadDiDiagDO.Id_ditp;
            cidizy.Sd_ditp = this.model.HeadDiDiagDO.Sd_ditp;
            cidizy.Id_ditp_name = this.model.HeadDiDiagDO.Name_ditp;

            MedCdSystemDO[] ms = model.GetMedCdSystemList(diDO.Id_cdsys, 2);
            if (ms == null || ms.Length <= 0)
            {
                this.ShowInfo("此选项没有标准,请重新选择", "提示");
            }
            else
            {
                cidizy.Di_standard = diDO.Id_cdsys;
                cidizy.Di_standard_code = diDO.Cdsys_code;
                cidizy.Di_standard_name = diDO.Cdsys_name;
            }

            cidizy.Di_disease = diDO.Id_didef;
            cidizy.Id_disease_code = diDO.Code;
            cidizy.Id_disease_name = diDO.Name;

            //cidizy.Id_syndrome
            //cidizy.Id_syndrome_code
            //cidizy.Id_syndrome_name

            cidizy.Id_dep_create = this.Context.Dept.Id_dep;
            cidizy.Id_dep_create_name = this.Context.Dept.Name;
            cidizy.Fg_suspdi = false;
            //cidixy.Fg_majdi
            checkValidata4Majdi();

            cidizy.Id_disys = diDO.Id_cdsystp;
            cidizy.Sd_disys = diDO.Sd_cdsystp;
            //cidixy.Id_disys_name

            cidizy.Fg_self = false;
            //cidixy.Id_parent
            cidizy.Sortno = index.ToString();

            cidizy.Fg_ur = diDO.Fg_ur;
            cidizy.Fg_chronic = diDO.Fg_chronic;
            cidizy.Fg_special = diDO.Fg_special;
            cidizy.Id_infectiontp = diDO.Id_infectiontp;
            cidizy.Sd_infectiontp = diDO.Sd_infectiontp;
        }

        /// <summary>
        /// 检查主诊断标志是否设置
        /// </summary>
        private void checkValidata4Majdi()
        {
            XapDataList<Cidixy> listxy = this.model.xyCidiList;
            XapDataList<Cididtozy> listzy = this.model.zyCidiList;

            // 定义标志变量，用来标记整个诊断列表是否为空
            // 如果整个列表为空，则不进行主诊断设置
            bool isAllEmpty = true;
            bool hasMajDI = false;
            foreach (Cidixy xy in listxy)
            {
                if (this.model.IsEmpty(xy))
                    continue;
                hasMajDI |= xy.Fg_majdi == null || !((bool)xy.Fg_majdi) ? false : true;
                isAllEmpty &= false;
            }
            foreach (Cididtozy zy in listzy)
            {
                if (this.model.IsEmpty(zy))
                    continue;

                hasMajDI |= zy.Fg_majdi == null || !((bool)zy.Fg_majdi) ? false : true;
                isAllEmpty &= false;
            }

            if (!hasMajDI && !isAllEmpty)
            {
                if (listxy != null && listxy.Count > 0)
                {
                    Cidixy xy = this.model.xyCidiList.ElementAt(0);
                    xy.Fg_majdi = true;
                }
                else if (listzy != null && listzy.Count > 0)
                {
                    Cididtozy zy = this.model.zyCidiList.ElementAt(0);
                    zy.Fg_majdi = true;
                }
            }
        }

        /// <summary>
        /// 根据诊断编码判断诊断是否重复
        /// </summary>
        /// <param name="didef_code">诊断编码</param>
        /// <param name="didef_name">诊断名称</param>
        /// <returns>true  存在相同编码诊断，false 不存在相同编码诊断</returns>
        private bool IsContainsRepeatDidef(string didef_code,string didef_name, ref string repeatMsg)
        {   
            string msg = "存在相同编码诊断：" + didef_name + "(" + didef_code + ")";
            XapDataList<Cidixy> listxy = this.model.xyCidiList;
            XapDataList<Cididtozy> listzy = this.model.zyCidiList;

            if (string.IsNullOrEmpty(didef_code) || string.IsNullOrEmpty(didef_name))
            {
                repeatMsg = "当前诊断编码或名称为空！";
                return true;
            }

            // 遍历西医诊断判断是否重复
            if (listxy != null && listxy.Count > 0)
            {

                foreach (Cidixy item in listxy)
                {
                    if (this.model.IsEmpty(item))
                        continue;

                    if (didef_code.Equals(item.Id_didef_code))
                    {
                        repeatMsg = "西医诊断中" + msg;
                        return true;
                    }
                }
            }

            if (listzy != null && listzy.Count > 0)
            {
                foreach (Cididtozy item in listzy)
                {
                    if (this.model.IsEmpty(item))
                        continue;

                    if (didef_code.Equals(item.Id_disease_code))
                    {
                        repeatMsg = "中医诊断中" + msg;
                        return true;
                    }else if (didef_code.Equals(item.Id_syndrome_code))
                    {
                        repeatMsg = "症候诊断中" + msg;
                        return true;
                    }
                }
            }

            return false;
        }
        
        /// <summary>
        /// 诊断批量录入校验是否存在重复诊断
        /// </summary>
        /// <param name="lstDiagDefDOs"></param>
        /// <returns></returns>
        private string checkValidate4Repeat(List<DiagDefDO> lstDiagDefDOs)
        {
            string mes = "";
            Dictionary<string, string> dictionary = new Dictionary<string, string>();
            XapDataList<Cidixy> listxy = this.model.xyCidiList;
            XapDataList<Cididtozy> listzy = this.model.zyCidiList;
            if (listxy != null && listxy.Count > 0)
            {
                foreach (Cidixy item in listxy)
                {
                    // 空行数据不进行检查
                    if (this.model.IsEmpty(item))
                        continue;

                    if (item.Id_didef_code != null)
                    {
                        if (!dictionary.ContainsKey(item.Id_didef_code))
                            dictionary.Add(item.Id_didef_code, item.Id_didef_name);
                    }
                }
            }
            if (listzy != null && listzy.Count > 0)
            {
                foreach (Cididtozy item in listzy)
                {
                    // 中医空行不进行检查
                    if (this.model.IsEmpty(item))
                        continue;

                    if (item.Id_syndrome_code != null)
                    {
                        if (!dictionary.ContainsKey(item.Id_disease_code))
                            dictionary.Add(item.Id_disease_code, item.Id_disease_name);
                    }
                }
            }
            List<DiagDefDO> DiagDefDOsRepeat = new List<DiagDefDO>();
            foreach (var defDO in lstDiagDefDOs)
            {
                if (dictionary.ContainsKey(defDO.Code))
                {
                    DiagDefDOsRepeat.Add(defDO);
                    if (defDO.Id_cdsystp == CiDictCodeConst.ID_CI_DISYS_XYZDTX)
                        mes += "西医诊断 : [" + defDO.Name + " " + defDO.Code + "]  重复 \n";
                }
                else if (defDO.Id_cdsystp == CiDictCodeConst.ID_CI_DISYS_ZYZDTX)
                {
                    if (dictionary.ContainsKey(defDO.Code))
                        mes += "中医诊断 : [" + defDO.Name + " " + defDO.Code + "]  重复 \n";
                }
            }

            foreach (var defDO in DiagDefDOsRepeat)
            {
                lstDiagDefDOs.Remove(defDO);
            }

            return mes;
        }

        /// <summary>
        /// 校验删除
        /// </summary>
        /// <param name="tableGrid"></param>
        private void checkValidate4Delete(XapFormGridControl tableGrid)
        {
            
            var rowList = tableGrid.GetSelectedRows();
            
            if (rowList.Count == 0)
            {
                this.ShowInfo("请选择需要删除的诊断！");
                return;
            }

            var selectRow = rowList[0];
            BaseDTO cidiDTO = selectRow.DataSource as BaseDTO;
            // string Id_diitm = BeanUtils.GetValue(cidiDTO, "Id_diitm") as string;
            //if (Id_diitm != null)
            //{
         

            //空行不删除
            string name_didef = BeanUtils.GetValue(cidiDTO, "Id_didef_name") as string;
            string name_disease = BeanUtils.GetValue(cidiDTO, "Id_disease_name") as string;
            if (string.IsNullOrEmpty(name_didef) && string.IsNullOrEmpty(name_disease))
            {
                return;
            }

            if (isCiDiRelateCiOrders(cidiDTO))
            {
                return;
            }

            //}
            bool fg_majdi = false;
            switch (this.curSelTabIndex)
            {
                case 0:
                    Cidixy xy = this.model.xyCidiList.ElementAt(selectRow.Index);
                    fg_majdi = xy.Fg_majdi == true;
                    this.model.DeleteCidixyAt(selectRow.Index);
                    if (GetCallbackAction() != null)
                        GetCallbackAction().OnDeleteAction(xy);
                    onDeleteMaidixy(fg_majdi);
                    if (this.model.xyCidiList.Count > selectRow.Index)
                        tableGrid.SelectRow(selectRow.Index);
                    else if (this.model.xyCidiList.Count > 0)
                        tableGrid.SelectRow(0);
                    break;
                case 1:
                    Cididtozy zy = this.model.zyCidiList.ElementAt(selectRow.Index);
                    fg_majdi = zy.Fg_majdi == true;
                    this.model.DeleteCididtozyAt(selectRow.Index);
                    if (GetCallbackAction() != null)
                        GetCallbackAction().OnDeleteAction(zy);
                    onDeleteMaidizy(fg_majdi);
                    if (this.model.zyCidiList.Count > selectRow.Index)
                        tableGrid.SelectRow(selectRow.Index);
                    else if (this.model.zyCidiList.Count > 0)
                        tableGrid.SelectRow(0);
                    break;
            }
            this.isEdited = true;
            
        }

        /// <summary>
        /// 删除西医主诊断
        /// </summary>
        /// <param name="fg_majdi"></param>
        private void onDeleteMaidixy(bool fg_majdi)
        {
            if (fg_majdi)
            {
                if (!this.model.IsCidixyListEmpty())
                {
                    this.model.xyCidiList[0].Fg_majdi = true;
                }
                else if (!this.model.IsCidizyListEmpty())
                {
                    this.model.zyCidiList[0].Fg_majdi = true;
                }
            }
        }

        /// <summary>
        /// 删除西医中诊断
        /// </summary>
        /// <param name="fg_majdi"></param>
        private void onDeleteMaidizy(bool fg_majdi)
        {
            if (fg_majdi)
            {
                if (!this.model.IsCidizyListEmpty())
                {
                    this.model.zyCidiList[0].Fg_majdi = true;
                }
                else if (!this.model.IsCidixyListEmpty())
                {
                    this.model.xyCidiList[0].Fg_majdi = true;
                }
            }
        }

        /// <summary>
        /// 校验保存
        /// </summary>
        /// <returns></returns>
        private string CheckValidate4Save()
        {
            if (this.xapFormControl.HasErrors)
            {
                // 由于此处增加表单错误检查，会检查表格中的必填项，跟业务需求冲突，暂时屏蔽。
                return this.xapFormControl.ErrorAlertText;
            }
            string IsValidated = "";
            Dictionary<string, FBoolean> dicFgMajdi = new Dictionary<string, FBoolean>();
            XapDataList<Cidixy> listxy = this.model.xyCidiList;

            XapDataList<Cididtozy> listzy = this.model.zyCidiList;
            if ((listxy == null || listxy.Count == 0) && (listzy == null || listzy.Count == 0))
            {
                if (this.model.HeadDiDiagDO.Dt_di != null)
                {
                    /* cidicount = "0";*/
                    return IsValidated = "";
                }
                else
                {
                    /* cidicount = "0";*/
                    return IsValidated = "没有诊断信息";
                }
            }

            // 标示整个列表无数据
            bool isAllEmpty = true;
            int xyflag = 0;
            int zyflag = 0;
            int flag = 0;
            String msg = "";
            if (listxy != null && listxy.Count > 0)
            {
                foreach (Cidixy xy in listxy)
                {
                    // 空行数据不进行检验
                    if (this.model.IsEmpty(xy))
                    {
                        continue;
                    }

                    isAllEmpty &= false;
                    if (xy != null && xy.Fg_majdi != null && (bool)xy.Fg_majdi)
                    {

                        xyflag++;
                    }
                    if (xy.Id_didef_name == null || xy.Di_standard_name == null)
                    {
                        msg += "【诊断名称】不能为空!\n";
                        flag++;
                    }
                }
            }

            if (listzy != null && listzy.Count > 0)
            {
                foreach (Cididtozy zy in listzy)
                {
                    // 空行数据不进行检验
                    if (this.model.IsEmpty(zy))
                        continue;

                    isAllEmpty &= false;
                    if (zy != null && zy.Fg_majdi != null && (bool)zy.Fg_majdi)
                    {
                        zyflag++;
                    }
                    if (zy.Id_disease_name == null)
                    {
                        msg += "【疾病诊断】不能为空!\n";
                        flag++;
                    }
                    // 
                    
                    //if (zy.Id_syndrome_name == null)
                    //{
                    //    msg += "【症候诊断】不能为空!\n";
                    //    flag++;
                    //}
                    
                }
            }

            // 如果全是空行，则不进行检查
            if (isAllEmpty)
            {
                return "";
            }

            if (flag > 0)
            {
                IsValidated = string.IsNullOrEmpty(msg)? "有必选项未填写，请检查":msg;
                return IsValidated;
            }

            if (xyflag + zyflag == 1)
            {
                IsValidated = "";
            }
            else if (xyflag + zyflag > 1)
            {
                IsValidated = "请选择一个主诊断";
            }
            else if (xyflag + zyflag < 1)
            {
                IsValidated = "请设置一个主诊断";
            }

            return IsValidated;
        }

        /// <summary>
        /// 初始设置主诊断
        /// </summary>
        /// <param name="rowDs"></param>
        private void setMasterDiagInfo(Object rowDs)
        {
            if (null == this.model)
            {
                return;
            }

            this.model.xyCidiList.ToList().ForEach(di =>
            {
                di.Fg_majdi = false;
            });

            this.model.zyCidiList.ToList().ForEach(di =>
            {
                di.Fg_majdi = false;
            });

            // 指定特定记录为主诊断：西医诊断
            if (rowDs is Cidixy)
            {
                this.model.xyCidiList.ToList().ForEach(di =>
                {
                    if (this.model.IsEmpty(di))
                    {
                        di.Fg_majdi = null;
                    }
                    else if (di == rowDs)
                    {
                        di.Fg_majdi = true;
                    }
                    else
                    {
                        di.Fg_majdi = false;
                    }
                });
            }
            // 指定特定中医诊断为主诊断
            else if (rowDs is Cididtozy)
            {
                this.model.zyCidiList.ToList().ForEach(di =>
                {
                    if (this.model.IsEmpty(di))
                    {
                        di.Fg_majdi = null;
                    }
                    else if (di == rowDs)
                    {
                        di.Fg_majdi = true;
                    }
                    else
                    {
                        di.Fg_majdi = false;
                    }
                });
            }

        }

        /// <summary>
        /// 设置诊断列表的可编辑状态
        /// </summary>
        /// <param name="flag"></param>
        private void SetDataPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy();

            // 在启用内部按钮逻辑的时候
            if (UseInnerButton)
            {
                //policy.AllowNew = flag;
                policy.AllowEdit = flag;
                //policy.AllowRemove = flag;
                //policy.AllowSave = flag;
                policy.FullEdit = true;
                //policy.MultiSelect = true;
                policy.InlineEdit = true;
                //policy.a
                policy.AutoNewRow = false;

                if (pageCommandLsit != null && pageCommandLsit.Count > 0)
                {
                    foreach (PageCommands pageCommands in pageCommandLsit)
                    {
                        pageCommands.Commands.ForEach(cmd =>
                        {
                            cmd.Enabled = flag;
                        });
                    }
                }
            }
            else
            {
                policy.AllowNew = false;
                policy.AllowEdit = flag;
                policy.AllowRemove = false;
                policy.AllowSave = false;
                policy.FullEdit = true;
                policy.MultiSelect = true;
                policy.InlineEdit = true;
                //policy.a
                policy.AutoNewRow = false;
            }

            xapFormControl.SetEditPolicy(flag, new DataPolicy[] { policy });


        }

        private Dictionary<string, FBoolean> dicSpecdi = new Dictionary<string, FBoolean>();
        private Dictionary<string, FBoolean> dicSelfPaidDi = new Dictionary<string, FBoolean>();
        /// <summary>
        /// 诊断标识
        /// </summary>
        /// <param name="row"></param>
        private void setRowImageAndColor(XDataRow[] rows, bool bShowSelfPaidDi)
        {
            List<string> lstIdSpecdis = new List<string>();
            List<string> lstIdSelfPaidDis = new List<string>();
            foreach (var row in rows)
            {
                if (row == null)
                    continue;
                Type dto = row.DataSource.GetType();
                object obj = dto.GetProperty("Id_didef") == null ? null : dto.GetProperty("Id_didef").GetValue(row.DataSource, null);
                String id_didef = obj == null ? "" : obj as String;
                if (!String.IsNullOrEmpty(id_didef))
                {
                    if (!dicSpecdi.ContainsKey(id_didef))
                    {
                        lstIdSpecdis.Add(id_didef);
                    }

                    if (!dicSelfPaidDi.ContainsKey(id_didef))
                    {
                        lstIdSelfPaidDis.Add(id_didef);
                    }
                }
            }

            FMap mapSpecdi = null;
            FMap mapSelfPaidDi = null;
            if (lstIdSpecdis.Count > 0)
            {
                mapSpecdi = this.model.CheckSpecdi(this.ent4BannerDto.Id_hp, this.ent4BannerDto.Id_pat, lstIdSpecdis.ToArray());
                if (mapSpecdi != null)
                {
                    foreach (var key in mapSpecdi.Keys)
                    {
                        dicSpecdi.Add(key, mapSpecdi[key] as FBoolean);
                    }
                }
            }
            if (lstIdSelfPaidDis.Count > 0)
            {
                mapSelfPaidDi = this.model.CheckSelfPaidDi(this.ent4BannerDto.Id_hp, this.ent4BannerDto.Code_entp, lstIdSelfPaidDis.ToArray());
                if (mapSelfPaidDi != null)
                {
                    foreach (var key in mapSelfPaidDi.Keys)
                    {
                        dicSelfPaidDi.Add(key, mapSelfPaidDi[key] as FBoolean);
                    }
                }
            }

            String strSelfPaidDiNames = "";
            foreach (var row in rows)
            {
                if (row == null) 
                    continue;

                bool isHpPat = CiEnContextUtil.IsHpPat(this.ent4BannerDto);//患者是否医保就诊
                
                Type dto = row.DataSource.GetType();
                object obj = dto.GetProperty("Id_didef") == null ? null : dto.GetProperty("Id_didef").GetValue(row.DataSource, null);
                String id_didef = obj == null ? "" : obj as String;

                object objname = dto.GetProperty("Id_didef_name") == null ? null : dto.GetProperty("Id_didef_name").GetValue(row.DataSource, null);
                String name = objname == null ? "" : objname as String;
                
                bool isSelfPaidDi = dicSelfPaidDi != null && dicSelfPaidDi.ContainsKey(id_didef) && dicSelfPaidDi[id_didef];
                bool isSpecdi = dicSpecdi != null && dicSpecdi.ContainsKey(id_didef) && dicSpecdi[id_didef];
                bool? fg_ur = dto.GetProperty("Fg_ur").GetValue(row.DataSource, null) as bool?;
                bool? fg_chronic = dto.GetProperty("Fg_chronic").GetValue(row.DataSource, null) as bool?;

                
                if (fg_ur != null && fg_ur.HasValue && fg_ur.Value)
                {
                    row.UserForeColor = Color.Red;//字体红色
                    //row.BackColor = Color.Red;//背景红色
                    getRowImage(row, "传染病");
                }
                else if (isHpPat && ((fg_chronic != null && fg_chronic.HasValue && fg_chronic.Value) || name.Contains("行动不便")))
                {
                    row.UserForeColor = Color.Blue;//字体蓝色
                    //row.BackColor = Color.Blue;//背景蓝色
                    getRowImage(row, "慢性病");
                }
                else if (isHpPat && isSelfPaidDi)
                {
                    row.UserForeColor = Color.Orange;//字体橙色
                    //row.BackColor = Color.Orange;//背景橙色
                    getRowImage(row, "自费");

                    if (name.Length > 0)
                    {
                        strSelfPaidDiNames += ",【" + name+"】";
                    }
                }
                else if (isHpPat && isSpecdi)
                {
                    row.UserForeColor = Color.Blue;//字体蓝色
                    //row.BackColor = Color.Blue;//背景蓝色
                    getRowImage(row, "特殊病");
                }
                else
                {
                    row.UserForeColor = Color.Black;//字体黑色
                    //row.BackColor = Color.White;//背景白色
                    getRowImage(row, "");
                }
            }
            if (bShowSelfPaidDi && strSelfPaidDiNames.Length > 0)
            {
                this.ShowInfo("请注意：" + strSelfPaidDiNames.Substring(1) + "是保外诊断，当次就诊所有未缴费处方都将转变为自费处方，患者应全额自付。");
            }
        }

        /// <summary>
        /// 获取诊断标识图标
        /// </summary>
        /// <param name="row"></param>
        /// <param name="resultList"></param>
        /// <param name="imageName"></param>
        private void getRowImage(XDataRow row, string imageName)
        {
            if (row.ColumnCellDict.ContainsKey("customercolumn_di_tip"))
            {
                List<XOrderResultData> resultList = new List<XOrderResultData>();
                XOrderResultData resultData = new XOrderResultData();
                if (imageName.Length > 0)
                {
                    resultData.Type = "1";
                    resultData.Value = "1";
                    resultData.ImagePath = "\\res\\image\\desktop\\表格icon\\" + imageName + ".png";
                    resultData.ValueText = imageName;
                }
                resultList.Add(resultData);
                (row.ColumnCellDict["customercolumn_di_tip"] as XCellRender).Value = resultList;
            }
        }

        /// <summary>
        /// 判断保外诊断是否关联医嘱，如果已经关联医嘱提示不允许删除
        /// </summary>
        /// <param name="ciDiDTO">对应 Cididtozy，Cidixy</param>
        /// <returns></returns>
        private bool isCiDiRelateCiOrders(BaseDTO ciDiDTO)
        {
            
            string Id_didef_code = BeanUtils.GetValue(ciDiDTO, "Id_didef_code") as string;
            string id_didef = BeanUtils.GetValue(ciDiDTO, "Id_didef") as string;
            if (string.IsNullOrEmpty(id_didef))
            {
                return false;
            }
            //获取自费诊断标识 by yzh
            bool? fg_hpbeyond = BeanUtils.GetObjValue(ciDiDTO, "Fg_hpbeyond") as bool?;
            if (this.ent4BannerDto != null && this.ent4BannerDto.Sd_hptp != null &&
               this.ent4BannerDto.Sd_hptp.StartsWith("1"))//医保的患者
            {
                if (fg_hpbeyond != null && fg_hpbeyond == true)
                {
                    XapDataList<Cidixy> cidixylist = this.model.xyCidiList;//诊断列表上所有数据
                    int euhpbeyond_count = 0;
                    foreach (var rowdata in cidixylist)
                    {
                        Cidixy cidixy = rowdata as Cidixy;
                        string name_didef = cidixy.Id_didef_name;
                        if (string.IsNullOrEmpty(name_didef)) continue;
                        if (cidixy.Fg_hpbeyond == true)
                        {
                            if (euhpbeyond_count > 1) break;
                            euhpbeyond_count++;
                        }
                        //cidixy.Fg_hpbeyond;
                    }
                    XapDataList<Cididtozy> cidizylist = this.model.zyCidiList;
                    foreach (var rowdata in cidizylist)
                    {
                        Cididtozy cidizy = rowdata as Cididtozy;
                        string name_disease = cidizy.Id_disease_name;
                        if (string.IsNullOrEmpty(name_disease)) continue;
                        if (cidizy.Fg_hpbeyond == true)
                        {
                            if (euhpbeyond_count > 1) break;
                            euhpbeyond_count++;
                        }
                        //cidixy.Fg_hpbeyond;
                    }
                    if (euhpbeyond_count <= 1)
                    {
                        // 判断是否存在保外诊断相关医嘱
                        bool isRelated = this.model.IsCiDiRelateCiOrders(this.ent4BannerDto, id_didef);
                        if (isRelated)
                        {
                            BizAssMessageBoxUtil.ShowWarningMsg("有医嘱因该诊断变为自费，请处理后再删除！");
                            return true;
                        }
                    }
                }
            }
                
           

            string[] dicodeall = null;
            if (this.model.AllList != null && this.model.AllList.Count > 0)
            {
                dicodeall = new string[this.model.AllList.Count];
                int i = 0;
                foreach (string dicode in this.model.AllList)
                {
                    dicodeall[i] = dicode;
                    i++;
                }
            }

            //诊断依赖
            if (this.ent4BannerDto != null && this.ent4BannerDto.Sd_hptp != null &&
                this.ent4BannerDto.Sd_hptp.StartsWith("1"))//医保的患者
            {
                string[] code = { Id_didef_code };
                List<Judgedideletedto> listinfo = this.model.GetDiDependDtos(this.ent4BannerDto.Id_ent, code, dicodeall);
                if (listinfo != null && listinfo.Count > 0)
                {
                    using (DiDependForm from = new DiDependForm(listinfo))
                    {
                        if (from.ShowDialog() == DialogResult.Cancel)
                        {
                            return true;
                        }
                    }
                }
            }

            if (this.model.AllList != null && this.model.AllList.Count > 0)
            {
                int i = 0;
                foreach (string dicode in this.model.AllList)
                {
                    if (dicode == Id_didef_code)
                    {
                        this.model.AllList.RemoveAt(i);
                        break;
                    }
                    i++;
                }
            }

            return false;
        }

        /// <summary>
        /// 校验诊断状态
        /// </summary>
        /// <param name="bCheckEmpty">是否检验空诊断</param>
        /// <returns></returns>
        public bool CheckDiEditable(bool bCheckEmpty)
        {
            if (this.ent4BannerDto != null && RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO)
            {
                if (bCheckEmpty && this.model.IsEmptyModel())
                {
                    this.ShowInfo("请先下达诊断！");
                    resetGridCellFocus(controlxy, true);
                    return false;
                }
                else if (isEdited)
                {
                    isEdited = false;
                    this.onSave(bCheckEmpty, false);
                    return true;
                }
            }
            return true;
        }

        /// <summary>
        /// 设置单元格编辑状态
        /// </summary>
        /// <param name="gridControl"></param>
        /// <param name="data"></param>
        /// <param name="isXy"></param>
        private void resetGridCellFocus(XapFormGridControl gridControl, bool isXy)
        {
            if (gridControl.DataTable.Rows.Count > 0)
            {
                gridControl.DataTable.Rows[0].Selected = true;
                List<XCellRender> lstCell = gridControl.DataTable.Rows[0].CellList;
                foreach (var cell in lstCell)
                {
                    if ((!isXy && cell.FieldName.Equals("Id_disease_name")) || (isXy && cell.FieldName.Equals("Id_didef_name")))
                    {
                        gridControl.ShowEditor(cell);
                    }
                }
            }
        }

        /// <summary>
        /// 发送消息
        /// </summary>
        /// <param name="strEventCode"></param>
        /// <param name="dataDic"></param>
        /// <param name="sender"></param>
        private void sentMessage(String strEventCode, Dictionary<string, object> dataDic, object sender)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, strEventCode);
            args.Data.Add(UIConst.DATA, dataDic);
            this.FireEventSent(sender, args);
        }
        #endregion

        #region 状态处理区域
        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            if (this.IsLoading)
                return;
            // 事件派发
            callDispatchAction(eventArgs.Data[UIConst.UI_EVENT] as string, sender);
        }

        /// <summary>
        /// 处理事件派发
        /// </summary>
        /// <param name="uiEvent"></param>
        private void callDispatchAction(String uiEvent,object sender)
        {
            switch (uiEvent)
            {
                // 增加一条空诊断
                case "OpDiAddAction":
                    this.onAdd();
                    break;
                // 保存诊断
                case "OpDiSaveAction":
                    if (isEdited)
                    {
                        this.onSave(true, false);
                    }
                    break;
                // 删除诊断
                case "OpDiDeleteAction":
                    this.onDelete();
                    break;
                // 关闭诊断 -- 不能执行
                case "OpDiCloseAction":
                    // 获取根视图对象
                    this.onCancel();
                    break;
                case OpActionConstant.OP_REFRESH_ALL_ACTION:// 门诊刷新
                    //门急诊医生站刷新，判断诊断是否为空，诊断是否更改
                    if (RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO)
                    {
                        this.CheckDiEditable(false);
                        if (this.model != null && this.ent4BannerDto != null)
                            this.model.Reload(this.ent4BannerDto.Id_ent);
                    }
                    break;
                case OpActionConstant.OP_COMPLETE_DI_SEND_ACTION:
                    //诊毕，判断诊断是否为空，诊断是否更改
                    if (RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO)
                    {
                        if (this.CheckDiEditable(true))
                        {
                            Dictionary<string, object> dataDic = new Dictionary<string, object>();
                            dataDic.Add(OpActionConstant.OP_COMPLETE_DI_RECEIVE_ACTION, null);
                            sentMessage(OpActionConstant.OP_COMPLETE_DI_RECEIVE_ACTION, dataDic, sender);
                        }
                    }
                    break;
                case OpActionConstant.OP_DI_SEND_OR_SIGN_ACTION:
                    if (RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO)
                    {
                        if (this.CheckDiEditable(true))
                        {
                            Dictionary<string, object> dataDic = new Dictionary<string, object>();
                            dataDic.Add(OpActionConstant.OP_DI_RECEIVE_OR_SIGN_ACTION, null);
                            sentMessage(OpActionConstant.OP_DI_RECEIVE_OR_SIGN_ACTION, dataDic, sender);
                        }
                    }
                    break;
                case OpActionConstant.OP_DI_SEND_OR_OPEN_ACTION:
                    if (RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO)
                    {
                        if (this.CheckDiEditable(true))
                        {
                            Dictionary<string, object> dataDic = new Dictionary<string, object>();
                            dataDic.Add(OpActionConstant.OP_DI_RECEIVE_OR_OPEN_ACTION, null);
                            sentMessage(OpActionConstant.OP_DI_RECEIVE_OR_OPEN_ACTION, dataDic, sender);
                        }
                    }
                    break;
                case OpActionConstant.OP_CANCEL_DI_SEND_ACTION:
                    //取消接诊，判断诊断是否为空，诊断是否更改
                    if (RelativeUIParam.RELATIVERATIO > RelativeUIParam.TEMPLETECHANGEDRATIO && isEdited && this.ent4BannerDto != null)
                    {
                        this.onSave(false, true);
                    }
                    Dictionary<string, object> dic = new Dictionary<string, object>();
                    dic.Add(OpActionConstant.OP_CANCEL_DI_RECEIVE_ACTION, null);
                    sentMessage(OpActionConstant.OP_CANCEL_DI_RECEIVE_ACTION, dic, sender);
                    break;
                case EventCodeType.EVENT_ORDI_SAVESUCCE:
                    // 保存诊断成功时候处理
                    onSaveSucess();
                    break;
                case OpActionConstant.OP_DI_ASSI_ACTION:
                    this.getDiFromHelper(sender as DiagDefDO[]);
                    break;
                case OpOperateActionEvent.BANNER_SWITCHING_USER:
                    //更换患者，判断诊断是否为空，诊断是否更改
                    this.CheckDiEditable(false);
                    break;
            }
        }

        /// <summary>
        /// 启用内部按钮时候，响应按钮事件动作
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public void OnPageCommand(object sender, EventArgs e)
        {
            if (sender is XapCommand)
            {
                callDispatchAction((sender as XapCommand).Command, sender);
            }
        }

      
        #endregion
    }
}
