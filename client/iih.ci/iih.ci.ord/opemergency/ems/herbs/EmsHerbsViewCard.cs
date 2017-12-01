using System;
using System.Collections.Generic;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.model;
using xap.cli.sdk.render;
using System.Windows.Forms;
using xap.cli.sdk.controls.herbalPrescription;
using iih.ci.ord.ciordems.d;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.ciorder.viewmodel.impext;
using xap.rui.appfw;
using iih.ci.ord.opemergency.validate;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using xap.cli.sdk.controls.DataView;
using xap.mw.core.data;
using iih.bl.hp.bdhpindicationdto.d;
using iih.ci.ord.opemergency.dialog;
using iih.ci.iih.ci.ord.i;
using xap.cli.context;
using xap.rui.control.extentions;
using xap.rui.engine;
using iih.ci.ord.opemergency.tool;
using iih.bd.iih.bd.bc.udi;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.ems.d;
using iih.ci.ord.opemergency.declare;
using iih.ci.ord.ciorder.d;

namespace iih.ci.ord.opemergency.ems
{
    /// <summary>
    /// <para>描    述 : 草药医疗单选项卡                      </para> 
    /// <para>项目名称 : iih.ci.ord.opemergency.ems     </para>    
    /// <para>类 名 称 : HerbsSrvItemView                </para> 
    /// <para>版 本 号 : v1.0.0.0                        </para> 
    /// <para>作    者 : qzwang                          </para> 
    /// <para>创建时间 : 2016/6/30 13:50:05              </para>
    /// <para>修 改 人 :                                 </para> 
    /// <para>更新时间 : 2016/6/30 13:50:05              </para> 
    /// <para>说    明 :                                 </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EmsHerbsViewCard : BaseEmsFormView
    {
        #region 变量定义区域
        HerBalMedicineCtr her;
      
        private EmsOrDrug selectDrugDo;
        //备注信息控件
        private XLabelBaseUserRender noteorLabel;
        //用户是否编辑了医嘱备注
        private bool userEditFlag;
        //医嘱备注获得焦点时的值
        private string focusText;
        #endregion

        #region 构造函数区域
        public EmsHerbsViewCard(IEventDelegate owner = null)
            : base(owner)
        {
            this.srvItemViewType = EmsViewType.EmsHerbsViewType;
            this.iValidate = new EmsHerbsValidate();
        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsHerbsViewCard/*"20160525101311355Q7L"*/);
            this.RegisteFormEventImpl();
            her = new HerBalMedicineCtr { MedicineName = "Name_mm", DosageName = "Quan_med", UsgeName = "Name_boildes", UnitName = "Name_unit_med", HerbalWidth = 99, HerbalHeight = 35 };
            her.SelectedClick += her_SelectedClick;
            her.SetDataVisible += OnHerBalMedicineCtr_DataVisible;
            var controls = new Dictionary<string, Control>();
            controls.Add("herCtl", her);
            this.GetXapFormControl().RegisterControl(controls);
             this.GetXapFormControl().EnterKeyDown += EmsRisViewCard_EnterKeyDown;
        }
        void EmsRisViewCard_EnterKeyDown(object sender, KeyEventArgs e)
        {
            XLabelBaseUserRender render = sender as XLabelBaseUserRender;
            if (render == null) return;
            switch (render.Name)
            {
                case "drugsUse_note_or":
                    this.SentNotify(EventCodeType.NM_EMS_SAVE_FOCUS);
                    e.Handled = true;
                    break;
                default:
                    break;

            }


        }

        /// <summary>
        /// 这个时间方法用来在数据显示的最后一刻，调整UI对象或者数据源对象
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void OnHerBalMedicineCtr_DataVisible(object sender, EventArgs e)
        {
            // 该事件应该将 参数 EventArgs 类型具体化 HerDataVisibleArgs，HerDataVisibleArgs中增加 Visible 属性
            var arg = e as HerDataVisibleArgs;
            if (arg.Data != null && arg.Data is EmsOrDrug)
            {
                (sender as UserRender).Visible = !(arg.Data as EmsOrDrug).IsDELETED;
            }
        }

        #endregion

        #region 接口方法
        public override void SetFocus()
        {
            if (GetXapFormControl() != null) {
                AssXapFormUtils.GetUserRender(GetXapFormControl(), "druguse.orders").Focus();
            }
        }
        #endregion

        #region 内部事件区域
        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            base.OnXapFormControl_Load(sender, e);
            isMedicalInsuranceEnable = this.Context.GetOrgParam<bool>(ICiOrdNSysParamConst.SYS_PARAM_IsMedicalInsuranceEnable);
            this.opMedInsuranceAuditHandel = this.Context.GetOrgParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OpMedInsuranceAuditHandleMode);
            this.OnInit();
        }

        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            if (this.GetViewModel() == null)
                return; 

            this.GetViewModel().OnRefResultData(e.BindingFieldName, this.userEditFlag);
        }
        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            noteorLabel = this.GetXapFormControl().GetUserRender("drugsUse", "note_or") as XLabelBaseUserRender;
            noteorLabel.GotFocus += new EventHandler(noteorLabel_GotFocus);
            noteorLabel.LostFocus += new EventHandler(noteorLabel_LostFocus);

        }
        /// <summary>
        /// 备注信息控件失去焦点
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void noteorLabel_LostFocus(object sender, EventArgs e)
        {
            if (focusText != noteorLabel.ValueText)
            {
                this.userEditFlag = true;
            }
        }
        /// <summary>
        /// 备注信息控件获得焦点
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void noteorLabel_GotFocus(object sender, EventArgs e)
        {
            focusText = noteorLabel.ValueText;
        }
        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (this.GetViewModel() == null)
                return;

            her.DataSource = (this.GetViewModel().GetFormDataSource() as EmsDrugItemDO).EmsOrDrugList;
            her.Enabled = true;
            this.userEditFlag = !(this.GetViewModel().getCiEmsDTO() as CiEmsDTO).IsNEW;
            if (!this.userEditFlag) {
                GetLogicEx().SetNoteOr(this.GetViewModel().GetEmsUIDTO() as EmsUIDTO);
            }
            // 数据模型填充时候，是否需要发送医嘱数据改变消息事件还需要待定
            //this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);
        }

        protected override void OnXapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (this.GetViewModel() == null)
                return;

            this.GetViewModel().OnDataChanged(e.Data, e.PropName, null);

            if (e.Input == null)
                return;

            this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);
        }

        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_route"))
            {
                e.WherePart = string.Format("id_route in ({0})", new GetSrvVsRouteImp().GetHerbRounte());
            }
            else if (e.BindingFieldName.Equals("Name_freq"))
            {//排除 临时 备用
                e.WherePart = string.Format("id_freq not in ({0})", "'0001AA1000000006BR2U','0001AA10000000079NW4'");
            }
            else
            {
                if (this.GetViewModel() != null)
                {
                    e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName);
                }
                else
                {
                    e.WherePart = "";
                }
            }
        }
        #endregion

        #region 重载方法
        public override void SetDataPolicy(bool flag)
        {
            //this.GetXapFormControl().SetEditPolicy(flag);

            //allowEdit = flag;
            this.allowEdit = flag;
            this.GetXapFormControl().SetEditable(flag);
          
        }

        public override bool OnEventHandle(object sender, DictionaryEventArgs e)
        {
            
            switch (AssToolEx.EventCodeOfEventArgs(e))
            {
                case EventCodeType.EVENT_EMS_ORSRV_DATACHANGED:
                     int count = GetHerBalMedicineCtr().dispCount;

                     for (int index = 0; index < count; ++index) {

                     }
                    break;
                case EventCodeType.EVENT_EMS_DRUG_USAGE:
                    (AssXapFormUtils.GetUserRender(this.GetXapFormControl(), "drugsUse.name_routedes") as XLabelBaseUserRender).UserRender.Focus();
                    break;
                case EventCodeType.EVENT_EMS_REFRESULT:
                    if (hpCanEdit())
                    {
                        EmsOrDrug emsordrug = this.GetViewModel().GetSelectedObject() as EmsOrDrug;
                        var bdhpdtos = emsordrug.BdHpIndicationDTO;
                        if (bdhpdtos != null && bdhpdtos.Count > 0)
                        {
                            BdHpIndicationDTO bdhpdto = bdhpdtos[0] as BdHpIndicationDTO;
                            var code_hpindicjudged = bdhpdto.Code_hpindicjudged;
                            if (code_hpindicjudged != null && (code_hpindicjudged == "12" || code_hpindicjudged == "21"))
                            {
                                showHpDialog(emsordrug);
                            }
                        }
                    }
                    break;
                case EventCodeType.EVENT_EMS_CARDFOCUS:
                    getControlByName("drugsUse", "orders").UserRender.Focus();
                    break;
                default:
                    break;
            }
            return base.OnEventHandle(sender, e);
        }
        #endregion

        #region 按钮事件区
        public override void Cell_MouseClick(object sender)
        {
            var row = sender as XDataRow;
            EmsOrDrug emsordrug = row.DataSource as EmsOrDrug;
            if (emsordrug != null)
            {
                if (row.ClickCell.FieldName.Equals("Fg_treat"))
                {
                    FArrayList bdhpdtos = emsordrug.BdHpIndicationDTO;
                    if (bdhpdtos != null && bdhpdtos.Count > 0)
                    {
                        BdHpIndicationDTO bdhpdto = bdhpdtos[0] as BdHpIndicationDTO;
                        string code_hpindicjudged = bdhpdto.Code_hpindicjudged;
                        if (code_hpindicjudged != null)
                        {
                            switch (code_hpindicjudged)
                            {
                                case "12":
                                case "21":
                                    showHpDialog(emsordrug);
                                    break;
                            }
                        }
                    }
                }
            }
        }
        void her_SelectedClick(object sender, EventArgs e)
        {
            selectDrugDo = her.GetFouceDo<EmsOrDrug>();
            this.GetViewModel().ClearTableDataSource();
            (this.GetViewModel().GetTableDataSource() as XapDataList<EmsOrDrug>).Add(selectDrugDo);
            //int selectedIndex = (her.DataSource as XapDataList<EmsOrDrug>).IndexOf(selectDrugDo);
            this.GetViewModel().SetSelectedObject(selectDrugDo);
        }
        #endregion

        #region 辅助方法
        /// <summary>
        /// 获取草药列表控件
        /// </summary>
        /// <returns></returns>
        public HerBalMedicineCtr GetHerBalMedicineCtr()
        {
            return this.her;
        }

        public override BaseFormBizView AdjustLayout()
        {
           // this.GetXapFormControl().SetToilHeight(this.Size.Height - GetFixedSize().Height - TABLE_HEIGHT_OFFSET);

            return this;
        }
        private void showHpDialog(EmsOrDrug emsordrug)
        {
            BdHpIndicationDTO bdhpdto = emsordrug.BdHpIndicationDTO[0] as BdHpIndicationDTO;
            var code_hpindicjudged = bdhpdto.Code_hpindicjudged;
            bool? isDefault = null;
            if (code_hpindicjudged == "12")
            {
                isDefault = emsordrug.Fg_treat;
            }
            using (BdHpIndicationDTOForm dialog = new BdHpIndicationDTOForm(emsordrug.Limit, emsordrug.Name_srv, isDefault))
            {
                DialogResult dialogResult = dialog.ShowDialog();
                if (dialogResult == DialogResult.OK)
                {
                    emsordrug.Fg_treat = true;
                    emsordrug.Fg_selfpay = false;
                    emsordrug.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED;//0不需要判断，1待判断，2已判断;
                }
                else if (dialogResult == DialogResult.No)
                {
                    emsordrug.Fg_treat = false;
                    emsordrug.Fg_selfpay = true;
                    emsordrug.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED;//0不需要判断，1待判断，2已判断
                }
            }
        }
        protected bool hpCanEdit()
        {
            //医保是否启用标识
            //this.Context.GetOrgParam<bool>(ICiOrdNSysParamConst.SYS_PARAM_IsMedicalInsuranceEnable);
            if (this.allowEdit && this.GetViewModel().GetEmsUIDTO() != null && !string.IsNullOrEmpty((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).PatInfo.Id_hp)
                && true == (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).PatInfo.Fg_hpfundpay && isMedicalInsuranceEnable && this.opMedInsuranceAuditHandel == 0)
            {
                return true;
            }
            return false;
        }

        private XLabelBaseUserRender getControlByName(string tableKey, string name)
        {
            XLabelBaseUserRender tmpUserRender = this.GetXapFormControl().GetUserRender(tableKey, name) as XLabelBaseUserRender;
            return tmpUserRender;
        }

        #endregion
    }
}
