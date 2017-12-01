using System;
using System.Linq;
using xap.rui.control.basecontrol;
using xap.rui.engine;
using xap.rui.control.forms.model;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.render;
using System.Windows.Forms;
using xap.rui.control.refcontrol.events;
using xap.rui.appfw;
using iih.ci.ord.opemergency.validate;
using iih.ci.ord.opemergency.dialog;
using xap.rui.control.forms.control;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.opemergency.tool;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using xap.rui.bizcontrol.BillFormTmplConst;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.control.extentions;
using iih.ci.iih.ci.ord.i;
using xap.mw.core.data;
using iih.bl.hp.bdhpindicationdto.d;
using xap.cli.sdk.render.Items;
using xap.cli.context;
using iih.ci.ord.ems.d;
using iih.ci.ord.ciorder.d;
using iih.bd.iih.bd.bc.udi;
using iih.bd.bc.udi;
using iih.ci.ord.opemergency.ems.dp;
using iih.ci.ord.opemergency.declare;
using System.Drawing;
using iih.en.pv.dto.d;
using xap.cli.sdk.controls.DataView;
using xap.mw.coreitf.d;
using iih.ci.ord.common.utils;
using System.Collections.Generic;
using iih.bd.pp.hpsrvorca.d;
using iih.bd.pp.mpayratiodf.d;
using iih.ci.ord.common.utils.msg;

namespace iih.ci.ord.opemergency.ems
{
    /// <summary>
    /// 西成药医疗单
    /// </summary>
    public partial class EmsDrugsViewCard : BaseEmsFormView
    {
        #region 常量定义
        public const string FORM_ORCARD_PAGECODE = "orcard";
        public const string FORM_CHGDOSE_PAGECODE = "dosage_table";
        //
        public new const int FORM_CARD_HEIGHT = 44;
        #endregion

        #region 变量定义区域
        private XapFormGridControl doseChangedDrugsGridCtrl;
        private String ciPharmMpInUsageScope;
        private BdHpIndicationDTOForm dialog;

        private string txt_Note_or = "";
        #endregion

        #region 构造函数区域

        public EmsDrugsViewCard(IEventDelegate owner)
            : base(owner)
        {
            this.srvItemViewType = EmsViewType.EmsDrugsViewType;
            this.iValidate = new EmsDrugsValidate();


        }

        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsDrugsViewCard/*"20160611013726494FRI"*/);
            this.SetGridPageCode("");
            this.RegisteFormEventImpl();
            this.GetXapFormControl().EnterKeyDown += EmsRisViewCard_EnterKeyDown;
       
        }
        void EmsRisViewCard_EnterKeyDown(object sender, KeyEventArgs e)
        {
            XLabelBaseUserRender render = sender as XLabelBaseUserRender;
            if (render == null) return;
            switch (render.Name)
            {
                case "orcard_note_or":
                    this.SentNotify(EventCodeType.NM_EMS_SAVE_FOCUS);
                    e.Handled = true;
                    break;
                default:
                    break;

            }

        }
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            base.OnLoadData();
           
            try
            {
                ciPharmMpInUsageScope = this.Context.GetOrgParam<String>(ICiOrdNSysParamConst.SYS_PARAM_CiPharmGrpableUsageScope);

            }
            catch //(System.Exception ex)
            {
                ciPharmMpInUsageScope = null;
            }

        }


        public override bool OnEventHandle(object sender, DictionaryEventArgs e)
        {
            // 当前未加载完成或者未创建完成 不进行消息事件的相应
            if (this.IsLoading) return false;
            if (!this.Created) return false;
            if (!this.IsXapFormReady) return false;
            switch (AssToolEx.EventCodeOfEventArgs(e))
            {
                case EventCodeType.NM_EMS_ORSRV_SELECTCHANGED:
                    if (this.GetViewModel() != null && this.GetViewModel().GetSelectedObject() != null)
                    {
                        this.updateDrugInfo(this.GetViewModel().GetSelectedObject() as EmsOrDrug);
                        if (hpCanEdit())
                        {
                            SetHpControlEnabled();
                        }
                        else
                        {
                            this.setHpBaseUserRender(false);
                        }
                        return true;
                    }
                    break;
                case EventCodeType.NM_EMS_ORSRV_DATACHANGED:
                    var useDay = AssToolEx.ObjectOfEventArgs(e, "Use_days");
                    var frecq = AssToolEx.ObjectOfEventArgs(e, "Name_freq");
                    this.updateDrugInfo(this.GetViewModel().GetSelectedObject() as EmsOrDrug);
                    if (hpCanEdit())
                    {
                        SetHpControlEnabled();
                    }
                    else
                    {
                        this.setHpBaseUserRender(false);
                    }
                    if (useDay != null || frecq != null)
                    {
                        var cardDataSource = (GetViewModel().GetFormDataSource() as EmsDrugItemDO);
                        if (cardDataSource.Fg_mp_in != null && cardDataSource.Fg_mp_in.GetValueOrDefault())
                        {
                            int totalCount = this.GetLogicEx().GetDrugUseTotalCount(this.GetViewModel().GetEmsUIDTO() as EmsUIDTO);
                            if (totalCount > 0)
                            {
                                var mapinlabel = AssXapFormUtils.GetUserRender(this.GetXapFormControl(), "orcard.times_mp_in") as XLabelBaseUserRender;
                                if (mapinlabel != null)
                                {
                                    // 在院执行次数跟随总次数变化一致
                                    var numRender = mapinlabel.UserRender as XNumbericUpDown;
                                    numRender.MaxValue = totalCount;
                                    // if (cardDataSource.Times_mp_in > totalCount)
                                    {
                                        cardDataSource.Times_mp_in = totalCount;
                                    }
                                }
                            }
                        }
                    }
                    else
                    {
                        // 在院执行次数
                        HandleTimesMpInInfo(this.ciPharmMpInUsageScope, this.GetViewModel().GetFormDataSource() as EmsDrugItemDO);
                    }
                    break;
                case EventCodeType.EVENT_EXPENSE_DATACHANGED:
                    handleExpenseDataChanged(sender,e);
                    break;
                case EventCodeType.EVENT_EMS_DRUG_USAGE:
                    (AssXapFormUtils.GetUserRender(this.GetXapFormControl(), "orcard.name_routedes")as XLabelBaseUserRender).UserRender.Focus();
                    break;
                case EventCodeType.EVENT_EMS_REFRESULT:
                    drugHpShow();
                    break;
                default:
                    break;
            }
            return base.OnEventHandle(sender, e);
        }
        private void drugHpShow() {
            if (hpCanEdit())
            {
                EmsOrDrug drugitem = this.GetViewModel().GetSelectedObject() as EmsOrDrug;
                var bdhpdtos = drugitem.BdHpIndicationDTO;
                if (bdhpdtos != null && bdhpdtos.Count > 0)
                {
                    BdHpIndicationDTO bdhpdto = bdhpdtos[0] as BdHpIndicationDTO;
                    var code_hpindicjudged = bdhpdto.Code_hpindicjudged;
                    if (code_hpindicjudged != null && (code_hpindicjudged == HpIndicationRuleEnum.SYS_JUD_DOCCONFIRM || code_hpindicjudged == HpIndicationRuleEnum.DOC_CONFIRM))
                    {
                        showFgTreatDialog(null);
                    }

                    // 确认为非适应症时是否提醒医生 ,true 提醒，false 不提醒
                    String ishp =  SysParamUtils.getSysParam().SYS_PARAM_IsRemind4FgIndicFalseConfirmed.OrgParam;
                    if (bdhpdto.Fg_indic != FBoolean.True && code_hpindicjudged != null && ishp != null && ishp.StartsWith("true") && code_hpindicjudged == HpIndicationRuleEnum.SYS_CONFIRM)
                    {
                        string limitMsg = drugitem.Limit;
                        if (string.IsNullOrEmpty(limitMsg))
                        {
                            limitMsg = "医保规则校验结果为自费，但未设置限制条件";
                        }
                        BizAssMessageBoxUtil.ShowInforMsg(limitMsg);                        
                    }
                }

                // 特殊病患者校验
                CiEnContextDTO ctx = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
                string specialDisease = ((EmsDrugsViewModel)this.GetViewModel()).GetSpecialDiseaseJudgeRst(ctx, new List<EmsOrDrug> { drugitem });
                if (!string.IsNullOrEmpty(specialDisease))
                {
                    BizAssMessageBoxUtil.ShowWarningMsg(specialDisease);
                }

            }
        }
        public override void SetDataPolicy(bool flag)
        {

            this.allowEdit = flag;
            this.GetXapFormControl().SetEditable(flag);
        }

        /// <summary>
        /// 调整表单中元素高度
        /// </summary>
        public override BaseFormBizView AdjustLayout()
        {
            this.GetXapFormControl().SetToilHeight(this.Size.Height - FORM_CARD_HEIGHT);
            return this;
        }
        #endregion

        #region 内部事件区域
        protected override void OnXapFormControl_Load(object sender, EventArgs e)
        {
            //this.OnInit();
            this.GetXapFormControl().DataDisplay += new EventHandler<xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs>(EmsDrugsViewCard_DataDisplay);
        }

        void EmsDrugsViewCard_DataDisplay(object sender, xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs e)
        {
            XDataRow row = sender as XDataRow;
            if (row != null)
            {
                ChangeRowColor(new XDataRow[] { row });
            }
        }
        private void ChangeRowColor(XDataRow[] rows)
        {
            foreach (var row in rows)
            {
                if (row == null) return;
                bool fg_ur = false;
                Type dto = row.DataSource.GetType();
                bool? fg = dto.GetProperty("med_unit").GetValue(row.DataSource, null) as bool?;
                if (fg.HasValue)
                {
                    fg_ur = fg.Value;
                }

                row.UserForeColor = (fg_ur ? Color.Red : Color.Black);//文字变红
                //row.BackColor = (fg_ur ? Color.Red : Color.White);//背景变红
            }
        }
        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);
            // 获取 变动用药列表控件
            this.doseChangedDrugsGridCtrl = this.GetXapFormControl().GetGridView("dosage_table");
            if (this.doseChangedDrugsGridCtrl != null)
            {
                doseChangedDrugsGridCtrl.Parent.Parent.Parent.Visible = false;
                doseChangedDrugsGridCtrl.Parent.Parent.Parent.Height = 0;
                doseChangedDrugsGridCtrl.Parent.Parent.Parent.Width = 0;
                this.GetXapFormControl().RemoveRender(this.doseChangedDrugsGridCtrl);
                this.GetXapFormControl().Refresh();
            }
            if (hpCanEdit())
            {
                SetHpControlEnabled();
            }
            else
            {
                this.setHpBaseUserRender(false);
            }
            // 隐藏皮试标志
            this.GetLogicEx().getControlByName(this.GetXapFormControl(), FORM_CARD_PAGECODE, "fg_skintest").Visible = false;
            this.GetLogicEx().getControlByName(this.GetXapFormControl(), FORM_CARD_PAGECODE, "fg_self").ValueTextChanged += new EventHandler(EmsDrugsViewCard_ValueTextChanged);

            this.GetLogicEx().getControlByName(this.GetXapFormControl(), FORM_ORCARD_PAGECODE, "note_or").GotFocus += new EventHandler(Note_or_GotFocus);
            this.GetLogicEx().getControlByName(this.GetXapFormControl(), FORM_ORCARD_PAGECODE, "note_or").LostFocus += new EventHandler(Note_or_LostFocus);
        }
        /// <summary>
        /// 参照内容过滤条件
        /// </summary>
        /// <param name="sendthrow new NotImplementedException();er"></param>
        /// <param name="e"></param>
        //void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
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

        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            if (this.GetViewModel() == null)
                return;

            this.GetViewModel().OnRefResultData(e.BindingFieldName, e.RefResultSet);
        }

        private void Note_or_GotFocus(object sender, EventArgs e)
        {
            txt_Note_or = this.GetLogicEx().getControlByName(this.GetXapFormControl(), FORM_ORCARD_PAGECODE, "note_or").ValueText;
        }

        private void Note_or_LostFocus(object sender, EventArgs e)
        {
            (this.GetViewModel() as EmsDrugsViewModel).bEdit_Note_or = !txt_Note_or.Equals(this.GetLogicEx().getControlByName(this.GetXapFormControl(), FORM_ORCARD_PAGECODE, "note_or").ValueText);
        }

        /// <summary>
        /// 表单中数据改变的时候消息处理
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected override void OnXapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            #region 变动用药属性改变
            if (e.PropName.ToLower() == "fg_dose_anoma")
            {
                EmsUIDTO uiEmsDTO = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO);

                if (Boolean.Parse(e.Input.ToString()))
                {
                    if (uiEmsDTO.Emsdrugs.EmsOrDoseDrug.Count == 0)
                    {
                        uiEmsDTO.Emsdrugs.EmsOrDoseDrug =
                        this.GetLogicEx().GetFreqVsTimes(uiEmsDTO.Emsdrugs.Id_freq,
                            uiEmsDTO.Emsdrugs.Id_orsrv,
                            uiEmsDTO.Emsdrugs.Id_or);
                    }

                    var dlg = new DoseChangedDrugsDialog(uiEmsDTO.Emsdrugs.EmsOrDoseDrug);

                    dlg.SaveEvent += dlg_SaveEvent;
                    dlg.CancelEvent += dlg_SaveEvent;



                    uiEmsDTO.Emsdrugs.EmsOrDoseDrug.ToList().ForEach(p =>
                    {
                        p.Quan_med = uiEmsDTO.Emsdrugs.Quan_med;//剂量
                        p.Name_unit_med = uiEmsDTO.Emsdrugs.Name_unit_med;

                        p.Id_unit_med = uiEmsDTO.Emsdrugs.Id_unit_med;
                    });

                    dlg.ShowDialog();
                }
                else
                {
                    uiEmsDTO.Emsdrugs.EmsOrDoseDrug.Clear();
                }

            }
            #endregion
            if (e.Input != null)
                orSrvInfoChanged(e.PropName.ToLower(), e.Input.ToString());
            if (e.PropName.ToLower() == "fg_mp_in" || e.PropName.ToLower() == "times_mp_in" || e.PropName.ToLower() == "fg_treat"|| e.PropName.ToLower() == "fg_selfpay")
                this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);
            if (e.PropName.ToLower() == "name_routedes")
                if (!(this.GetViewModel() as EmsDrugsViewModel).bEdit_Note_or)
                {
                    this.GetLogicEx().SetNoteOr(this.GetViewModel().GetEmsUIDTO() as EmsUIDTO);
                }
        }

        void EmsDrugsViewCard_ValueTextChanged(object sender, EventArgs e)
        {
            orSrvInfoChanged((sender as XLabelBaseUserRender).Name.ToLower(), (sender as XLabelBaseUserRender).ValueText);
        }
        /// <summary>
        /// 医嘱项目改变的时候  
        /// </summary>
        /// <param name="field"></param>
        /// <param name="value"></param>
        private void orSrvInfoChanged(string field, string value)
        {
            // 有效性判断
            if (this.GetViewModel() == null)
            {
                return;
            }

            if (this.GetViewModel().GetSelectedObject() != null)
            {
                var drug = this.GetViewModel().GetSelectedObject() as EmsOrDrug;
                switch (field)
                {
                    case "fg_treat":
                        drug.Fg_treat = Boolean.Parse(value);
                        if (drug.Fg_hpindicjudged != (int)HpIndicJudgeEnum.NONEEDJUDGE)
                        drug.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED;//0不需要判断，1待判断，2已判断
                        this.SentNotify(EventCodeType.EVENT_EMS_ORSRV_HP_DATACHANGED, "Fg_treat", drug);
                        break;
                    case "fg_selfpay":
                        drug.Fg_selfpay = Boolean.Parse(value);
                        if (drug.Fg_hpindicjudged != (int)HpIndicJudgeEnum.NONEEDJUDGE)
                        drug.Fg_hpindicjudged =(int)HpIndicJudgeEnum.JUDGED;//0不需要判断，1待判断，2已判断
                        this.SentNotify(EventCodeType.EVENT_EMS_ORSRV_HP_DATACHANGED,"Fg_selfpay",drug);
                        if (drug.Fg_selfpay == FBoolean.True)
                        {
                            drug.Fg_treat = FBoolean.False;
                        }
                        else
                        {
                            CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
                            var drug2 = this.GetViewModel().getHPIndiccation(drug.Id_srv, drug.Id_mm, ciEnContextDTO) as EmsOrDrug;
                            this.showFgTreatDialog(drug2);
                            drug.Fg_treat = FBoolean.True;
                        }
                        break;
                    case "fg_self":
                        drug.Fg_self = Boolean.Parse(value);
                        drug.Fg_bl = !drug.Fg_self;
                        break;
                    case "card_fg_self":
                        drug.Fg_self = Boolean.Parse(value);
                        break;
                    case "fg_skintest":
                        drug.Fg_skintest = Boolean.Parse(value);
                        break;
                    case "fg_mp_in":
                        (this.GetViewModel().GetFormDataSource() as EmsDrugItemDO).Fg_mp_in = Boolean.Parse(value);
                        if (!Boolean.Parse(value))
                        {
                            (this.GetViewModel().GetFormDataSource() as EmsDrugItemDO).Times_mp_in = 0;
                        }
                        else
                        {
                            if ((this.GetViewModel().GetFormDataSource() as EmsDrugItemDO).Times_mp_in <= 0)
                                (this.GetViewModel().GetFormDataSource() as EmsDrugItemDO).Times_mp_in = 1;
                        }

                        this.GetXapFormControl().GetUserRender(FORM_ORCARD_PAGECODE, "times_mp_in").Enabled = Boolean.Parse(value) & this.GetXapFormControl().GetUserRender(FORM_ORCARD_PAGECODE, "fg_mp_in").Enabled;
                        this.SentNotify(EventCodeType.EVENT_EMS_ORSRV_DATACHANGED);
                        break;
                    case "fg_propc":
                        drug.Fg_propc = Boolean.Parse(value);
                        break;
                    case "times_mp_in":
                        (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Times_mp_in = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsdrugs.Times_mp_in;
                            break;
                }
            }
        }

        private void dlg_SaveEvent(object sender, MouseEventArgs e)
        {
            (sender as DoseChangedDrugsDialog).Close();
        }

        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            // 有效性判断
            if (this.GetViewModel() == null || (this.GetViewModel().GetTableDataSource() as XapDataList<EmsOrDrug>).Count == 0 )
                return;
            //如果loadsrv失败，不走modefilled方法
            if (string.IsNullOrEmpty((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsdrugs.Id_srv)) return;

            this.UnRegFormEvent_DataChanged();

            // 更新Card上的药品项目
            this.updateDrugInfo(this.GetViewModel().GetSelectedObject() as EmsOrDrug);

            var itemDO = this.GetViewModel().GetFormDataSource() as EmsDrugItemDO;

            // 如果是胰岛素的话，变动用药可以使用
            var ctrl = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_dose_anoma");

            ctrl.Visible = (itemDO.Id_srv == "0001AA10000000089WF2");// ##???? 服务id在数据库中不存在

            //	治疗用药、预防用药：只有抗生素类型的药品（BD_SRV_DRUG.fg_anti抗菌药物标志），才显示这两个控件。这两个选项框互斥。
            if (this.GetLogicEx().IsAntDrug(itemDO.Id_srv))
            {
                this.GetLogicEx().getControlByName(this.GetXapFormControl(), FORM_CARD_PAGECODE, "fg_propc").Visible = true;//抗菌药使用目的
            }
            else
            {
                this.GetLogicEx().getControlByName(this.GetXapFormControl(), FORM_CARD_PAGECODE, "fg_propc").Visible = false;//抗菌药使用目的
            }

            // 在院执行次数
            HandleTimesMpInInfo(this.ciPharmMpInUsageScope, itemDO);

            //是保外患者，隐藏自费标识
            object emsObj = this.GetViewModel().GetEmsUIDTO();
            if (emsObj != null)
            {
                EmsUIDTO emsUiDto = emsObj as EmsUIDTO;
                if (emsUiDto.PatInfo != null)
                {
                    if (isHideSelfpay(emsUiDto.PatInfo))
                    {
                        if (this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") != null)
                        {
                            var fg_selfpay = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") as XLabelBaseUserRender;
                            fg_selfpay.Visible = false;
                            if (this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_self") != null)
                            {
                                var fg_self = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_self");
                                fg_self.Location = fg_selfpay.Location;
                            }
                        }
                    }
                }
            }
            AdjustLayout();
            if (hpCanEdit())
            {
                SetHpControlEnabled();
            }
            else
            {
                this.setHpBaseUserRender(false);
            }

            this.RegFormEvent_DataChanged();

            (this.GetViewModel() as EmsDrugsViewModel).bEdit_Note_or = !(this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).IsNEW;
            if (!(this.GetViewModel() as EmsDrugsViewModel).bEdit_Note_or)
                GetLogicEx().SetNoteOr(this.GetViewModel().GetEmsUIDTO() as EmsUIDTO);
            // 新建时才弹出医保窗体
            if (((EmsUIDTO)this.GetViewModel().GetEmsUIDTO()).Status==DOStatus.NEW)
            drugHpShow();
        }

        protected void HandleTimesMpInInfo(String routeSets, EmsDrugItemDO itemDO)
        {
            // 如果医疗单处于不可以编辑状态，则针对于在院执行次数相关控制逻辑失效，不再需要处理
            if (!this.allowEdit)
                return;

            var fg_mp_in = AssXapFormUtils.GetUserRender(GetXapFormControl(), "orcard.fg_mp_in");
            var times_mp_in = AssXapFormUtils.GetUserRender(GetXapFormControl(), "orcard.times_mp_in");

            // 如果模型 在院执行标记为空 则不在院执行
            if (itemDO.Fg_mp_in == null)
            { // 
                fg_mp_in.Enabled = false;
                times_mp_in.Enabled = false;
                itemDO.Times_mp_in = 0;
            }

            // 如果用法在集合为空
            if (String.IsNullOrEmpty(routeSets))
            {
                String[] IVDrugSets = { BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG_ZX, BdSrvDictCodeConst.SD_SRVTP_DRUG_WESTDRUG_DSY }; //默认： 注射、溶媒
                var drug = (this.GetViewModel().GetTableDataSource() as XapDataList<EmsOrDrug>).FirstOrDefault(p => !p.IsDELETED);
                if (!String.IsNullOrEmpty(drug.Id_srv) && !String.IsNullOrEmpty(drug.Sd_srvtp))
                {
                    if (IVDrugSets.Contains(drug.Sd_srvtp.Substring(0, 6)))
                    {

                        if (itemDO.Fg_mp_in == null)
                        {
                            itemDO.Fg_mp_in = true;
                            itemDO.Times_mp_in = itemDO.Freqct * itemDO.Use_days;
                            int total = this.GetLogicEx().GetDrugUseTotalCount(this.GetViewModel().GetEmsUIDTO() as EmsUIDTO);
                            ((times_mp_in as XLabelBaseUserRender).UserRender as XNumbericUpDown).MaxValue = total;
                        }
                        else if (itemDO.Fg_mp_in == false)
                        {
                            itemDO.Fg_mp_in = false;
                            itemDO.Times_mp_in = 0;
                        }
                        else
                        {

                        }
                    }
                    // 没有配置可修改用法集合时候，都不能修改
                    fg_mp_in.Enabled = false;
                    times_mp_in.Enabled = false;

                }
            }
            else
            {
                // 如果当前用法非空并且当前的用法在系统参数配置的用法集合内时候，需要设置在院执行标志
                if (!String.IsNullOrEmpty(itemDO.Id_route) && routeSets.ToLower().IndexOf(itemDO.Id_route.ToLower()) >= 0)
                {
                    if (itemDO.Fg_mp_in == null)
                    {
                        itemDO.Fg_mp_in = true;
                        itemDO.Times_mp_in = itemDO.Freqct * itemDO.Use_days;
                    }
                    else if (!itemDO.Fg_mp_in.Value)
                    { // 这个逻辑永远不会执行，暂时注销
                        itemDO.Fg_mp_in = true;
                        itemDO.Times_mp_in = itemDO.Freqct * itemDO.Use_days;
                    }
                    //else {

                    //}
                    int total = this.GetLogicEx().GetDrugUseTotalCount(this.GetViewModel().GetEmsUIDTO() as EmsUIDTO);
                    ((times_mp_in as XLabelBaseUserRender).UserRender as XNumbericUpDown).MaxValue = total;
                    itemDO.Times_mp_in = itemDO.Times_mp_in > total ? total : itemDO.Times_mp_in;
                    fg_mp_in.Enabled = true;
                    times_mp_in.Enabled = itemDO.Fg_mp_in.Value;
                }
                else
                {
                    fg_mp_in.Enabled = false;
                    times_mp_in.Enabled = false;
                    itemDO.Times_mp_in = 0;
                    itemDO.Fg_mp_in = false;
                }
            }
            if (null == itemDO.Fg_mp_in) itemDO.Fg_mp_in = false;
            times_mp_in.Enabled = fg_mp_in.Enabled & itemDO.Fg_mp_in.Value;

        }
        protected void handleExpenseDataChanged(object sender, DictionaryEventArgs e)
        {
            if (e == null || e.Data == null) return;
            if (AssToolEx.ObjectOfEventArgs(e, "Fg_treat") != null)
            {
                var obj = AssToolEx.ObjectOfEventArgs(e, "Fg_treat");
                EmsOrDrug drug = obj as EmsOrDrug;
                EmsUIDTO emsUIDTO = this.GetViewModel().GetEmsUIDTO() as EmsUIDTO;
                XapDataList<EmsOrDrug> drugList = emsUIDTO.Emsdrugs.EmsOrDrugList;
                EmsOrDrug  matchDrug = drugList.ToList().FirstOrDefault(p=>p.Id_srv==drug.Id_srv);
                if (matchDrug != null) {
                    matchDrug.Fg_treat = drug.Fg_treat;
                    matchDrug.Fg_selfpay = matchDrug.Fg_treat == false ? true : matchDrug.Fg_selfpay;
                    matchDrug.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED;//0不需要判断，1待判断，2已判断;   
                }
            }
            else if (AssToolEx.ObjectOfEventArgs(e, "Fg_selfpay")!=null)
            {
                var obj = AssToolEx.ObjectOfEventArgs(e, "Fg_selfpay");
                EmsOrDrug drug = obj as EmsOrDrug;
                EmsUIDTO emsUIDTO = this.GetViewModel().GetEmsUIDTO() as EmsUIDTO;
                XapDataList<EmsOrDrug> drugList = emsUIDTO.Emsdrugs.EmsOrDrugList;
                EmsOrDrug matchDrug = drugList.ToList().FirstOrDefault(p => p.Id_srv == drug.Id_srv);
                if (matchDrug != null) {
                    matchDrug.Fg_selfpay = drug.Fg_selfpay;
                    matchDrug.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED;//0不需要判断，1待判断，2已判断;    
                }
            }
            EmsOrDrug drugitem = this.GetViewModel().GetSelectedObject() as EmsOrDrug;
            this.GetXapFormControl().DataChanged -= OnXapFormControl_DataChanged;
            updateDrugInfo(drugitem);
            this.GetXapFormControl().DataChanged += OnXapFormControl_DataChanged;
        }

        private void SetHpControlEnabled()
        {
            if (this.GetXapFormControl() == null) return;
            var drugitem = this.GetViewModel().GetSelectedObject() as EmsOrDrug;
            if (drugitem == null) return;
            var bdhpdtos = drugitem.BdHpIndicationDTO;
            var fg_treat = AssXapFormUtils.GetUserRender(GetXapFormControl(), "card.fg_treat") as XLabelBaseUserRender;
            if (fg_treat == null)
            {
                return;
            }
            fg_treat.ReadOnly = true;
            var label = AssXapFormUtils.GetUserRender(GetXapFormControl(), "card.label") as XLabel;
            var fg_selfpay = AssXapFormUtils.GetUserRender(GetXapFormControl(), "card.fg_selfpay") as XLabelBaseUserRender;

            if (bdhpdtos != null && bdhpdtos.Count > 0)
            {
                BdHpIndicationDTO bdhpdto = bdhpdtos[0] as BdHpIndicationDTO;
                var code_hpindicjudged = bdhpdto.Code_hpindicjudged;
                bool? fg_indic = drugitem.Fg_treat;
                if (code_hpindicjudged != null)
                {
                    switch (code_hpindicjudged)
                    {
                        case HpIndicationRuleEnum.NO_CONTROL:
                        case HpIndicationRuleEnum.SYS_CONFIRM:
                            if (bdhpdto.Fg_indic == null || !(bool)bdhpdto.Fg_indic)
                            {
                                setHpBaseUserRender(false);
                            }
                            else
                            {
                                fg_selfpay.Enabled = true;
                            }
                            label.MouseClick -= fg_treat_MouseClick;
                            fg_treat.MouseClick -= fg_treat_MouseClick;
                            break;
                        case HpIndicationRuleEnum.SYS_JUD_DOCCONFIRM:
                            label.MouseClick -= fg_treat_MouseClick;
                            label.MouseClick += fg_treat_MouseClick;
                            fg_treat.MouseClick -= fg_treat_MouseClick;
                            fg_treat.MouseClick += fg_treat_MouseClick;
                            Font f = new Font(label.Font.FontFamily, label.Font.Size, FontStyle.Underline, GraphicsUnit.Pixel);
                            label.Font = f;
                            setFgSefPayRenderEnable(fg_indic == null ? false : (bool)fg_indic);
                            break;
                        case HpIndicationRuleEnum.DOC_CONFIRM:
                            label.MouseClick -= fg_treat_MouseClick;
                            label.MouseClick += fg_treat_MouseClick;
                            fg_treat.MouseClick -= fg_treat_MouseClick;
                            fg_treat.MouseClick += fg_treat_MouseClick;
                            Font f1 = new Font(label.Font.FontFamily, label.Font.Size, FontStyle.Underline, GraphicsUnit.Pixel);
                            label.Font = f1;
                            setFgSefPayRenderEnable(fg_indic == null ? false : (bool)fg_indic);
                            break;
                    }

                    return;
                }

            }
            label.MouseClick -= fg_treat_MouseClick;
            fg_treat.MouseClick -= fg_treat_MouseClick;
            fg_selfpay.Enabled = false;

        }

        void fg_treat_MouseClick(object sender, MouseEventArgs e)
        {
            showFgTreatDialog(null);
        }
        /// <summary>
        /// 医保适应症弹窗处理
        /// </summary>
        private void showFgTreatDialog(EmsOrDrug drug)
        {
            EmsOrDrug drugitem = null;
            if (drug != null)
            {
                drugitem = drug;
            }
            else
            {
                drugitem = this.GetViewModel().GetSelectedObject() as EmsOrDrug;
            }
           
            BdHpIndicationDTO bdhpdto = drugitem.BdHpIndicationDTO[0] as BdHpIndicationDTO;
            FArrayList bdhpdtolist = new FArrayList();
            bdhpdtolist.Add(bdhpdto);
            drugitem.BdHpIndication = bdhpdtolist;
            var code_hpindicjudged = bdhpdto.Code_hpindicjudged;
            bool? isDefault = null;
            if (code_hpindicjudged == HpIndicationRuleEnum.SYS_JUD_DOCCONFIRM)
            {
                isDefault = drugitem.Fg_treat;
            }

            using (dialog = new BdHpIndicationDTOForm(drugitem.Limit, drugitem.Name_srv,isDefault))
            {
                // 适应症复选框
                var fg_treat = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_treat") as XLabelBaseUserRender;
                // 自费复选框
                var fg_selfpay = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") as XLabelBaseUserRender;
                String ishp = SysParamUtils.getSysParam().SYS_PARAM_IsRemind4FgIndicFalseConfirmed.OrgParam;
                if (bdhpdto.Fg_indic != FBoolean.True && code_hpindicjudged != null && ishp != null &&
                    ishp.StartsWith("true") && code_hpindicjudged == HpIndicationRuleEnum.SYS_CONFIRM)
                {
                    dialog.saveButton.Visible = false;
                    dialog.saveButton1.Visible = false;
                    dialog.saveButton2.Visible = false;
                    DialogResult dialogResult = dialog.ShowDialog();
                   
                    if (dialogResult == DialogResult.OK)
                    {
                        if (!this.GetXapFormControl().IsLoading)
                        {
                            fg_treat.Checked = true;
                            fg_selfpay.Checked = false;
                        }
                        drugitem.Fg_treat = true;
                        drugitem.Fg_selfpay = false;
                        drugitem.Fg_hpindicjudged = (int) HpIndicJudgeEnum.JUDGED; //0不需要判断，1待判断，2已判断;
                    }
                    else if (dialogResult == DialogResult.No)
                    {
                        if (!this.GetXapFormControl().IsLoading)
                        {
                            fg_treat.Checked = false;
                            // 执行完fg_treat.Checked 后，fg_selfpay.Enabled = false 导致赋值的时候，没有处方datachange事件，费用列表中的fg_selfpay状态不改变，导致后续保存自费标识错误
                            // 先修改自费服复选框可用，在设置选中状态
                            fg_selfpay.Enabled = true;
                            fg_selfpay.Checked = true;
                        }
                        drugitem.Fg_treat = false;
                        drugitem.Fg_selfpay = true;
                        drugitem.Fg_hpindicjudged = (int) HpIndicJudgeEnum.JUDGED; //0不需要判断，1待判断，2已判断;

                    }
                }
                else if (code_hpindicjudged == HpIndicationRuleEnum.SYS_JUD_DOCCONFIRM)
                {
                    dialog.saveButton1.Visible = false;
                    dialog.saveButton2.Visible = false;
                    drugitem.Fg_selfpay = false;
                    DialogResult dialogResult = dialog.ShowDialog();
                    dialog.saveButton1.Visible = false;
                    dialog.saveButton2.Visible = false;

                    if (dialogResult == DialogResult.OK)
                    {
                        if (!this.GetXapFormControl().IsLoading)
                        {
                            fg_treat.Checked = true;
                            fg_selfpay.Checked = false;
                        }
                        drugitem.Fg_treat = true;
                        drugitem.Fg_selfpay = false;
                        drugitem.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED; //0不需要判断，1待判断，2已判断;
                    }
                    else if (dialogResult == DialogResult.No)
                    {
                        if (!this.GetXapFormControl().IsLoading)
                        {
                            fg_treat.Checked = false;
                            // 执行完fg_treat.Checked 后，fg_selfpay.Enabled = false 导致赋值的时候，没有处方datachange事件，费用列表中的fg_selfpay状态不改变，导致后续保存自费标识错误
                            // 先修改自费服复选框可用，在设置选中状态
                            fg_selfpay.Enabled = true;
                            fg_selfpay.Checked = true;
                        }
                        drugitem.Fg_treat = false;
                        drugitem.Fg_selfpay = true;
                        drugitem.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED; //0不需要判断，1待判断，2已判断;

                    }
                }
                else if (code_hpindicjudged == HpIndicationRuleEnum.DOC_CONFIRM)
                {
                    Dictionary<String, MPayRatioDfDO> dic = new Dictionary<string, MPayRatioDfDO>();
                    
                    FArrayList list = bdhpdto.Mutipayratio_list;

                    if (list != null && list.Count > 0)
                    {

                        int i = 1;
                        foreach (MPayRatioDfDO mPayRatio in list)
                        {
                            dic.Add(i + "", mPayRatio);
                            i++;
                        }
                        dialog.dic = dic;
                        if (dic != null && dic.Count > 0)
                        {
                            if (dic != null && dic.Count == 2)
                            {
                                dialog.saveButton1.Text = dic["1"].Name;
                                dialog.saveButton2.Text = dic["2"].Name;
                            }
                            else if (dic != null && dic.Count == 1)
                            {
                                dialog.saveButton1.Text = dic["1"].Name;
                                dialog.saveButton2.Visible = false;
                            }
                            dialog.saveButton.Visible = false;
                        }
                        else
                        {
                            dialog.saveButton1.Visible = false;
                            dialog.saveButton2.Visible = false;
                        }
                    }
                    else
                    {
                        dialog.saveButton1.Visible = false;
                        dialog.saveButton2.Visible = false;
                    }

                    drugitem.Fg_selfpay = false;
                    DialogResult dialogResult = dialog.ShowDialog();

                    if (dialogResult == DialogResult.OK)
                    {
                        if (!this.GetXapFormControl().IsLoading)
                        {
                            fg_treat.Checked = true;
                            fg_selfpay.Checked = false;
                        }
                      
                        drugitem.Fg_treat = true;
                        drugitem.Fg_selfpay = false;
                        drugitem.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED; //0不需要判断，1待判断，2已判断;
                    }else if (dialogResult == DialogResult.Retry)
                    {
                        if (!this.GetXapFormControl().IsLoading)
                        {
                            fg_treat.Checked = true;
                            fg_selfpay.Checked = false;
                        }
                        drugitem.Indicitemid = dic["1"].Id_hpmpayratiodf;
                        drugitem.Fg_treat = true;
                        drugitem.Fg_selfpay = false;
                        drugitem.Fg_hpindicjudged = (int) HpIndicJudgeEnum.JUDGED; //0不需要判断，1待判断，2已判断;
                    }
                    else if (dialogResult == DialogResult.Yes)
                    {
                        if (!this.GetXapFormControl().IsLoading)
                        {
                            fg_treat.Checked = true;
                            fg_selfpay.Checked = false;
                        }
                        if (dic.Count==2)
                        {
                            drugitem.Indicitemid = dic["2"].Id_hpmpayratiodf;
                        }
                        drugitem.Fg_treat = true;
                        drugitem.Fg_selfpay = false;
                        drugitem.Fg_hpindicjudged = (int)HpIndicJudgeEnum.JUDGED; //0不需要判断，1待判断，2已判断
                    }
                    else if (dialogResult == DialogResult.No)
                    {
                        if (!this.GetXapFormControl().IsLoading)
                        {
                            fg_treat.Checked = false;
                            // 执行完fg_treat.Checked 后，fg_selfpay.Enabled = false 导致赋值的时候，没有处方datachange事件，费用列表中的fg_selfpay状态不改变，导致后续保存自费标识错误
                            // 先修改自费服复选框可用，在设置选中状态
                            fg_selfpay.Enabled = true;
                            fg_selfpay.Checked = true;
                        }
                        drugitem.Fg_treat = false;
                        drugitem.Fg_selfpay = true;
                        drugitem.Fg_hpindicjudged = (int) HpIndicJudgeEnum.JUDGED; //0不需要判断，1待判断，2已判断;

                    }
                }
                setFgSefPayRenderEnable(!fg_selfpay.Checked);
            }
        }

        /// <summary>
        /// 设置医保适应症复选框是否可用
        /// </summary>
        /// <param name="flag"></param>
        private void setHpBaseUserRender(bool flag)
        {
            if (!this.Created) return;
            if (this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_treat") != null)
            {
                var fg_treat = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_treat") as XLabelBaseUserRender;
                fg_treat.ReadOnly = !flag;
            }
            setFgSefPayRenderEnable(flag);
        }

        /// <summary>
        /// 设置自费复选框是否可用
        /// </summary>
        /// <param name="flag"></param>
        private void setFgSefPayRenderEnable(bool flag)
        {
            if (this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") != null)
            {
                var fg_selfpay = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") as XLabelBaseUserRender;
                fg_selfpay.Enabled = flag;
            }
        }

        /// <summary>
        /// 更新适应症、自费、皮试等状态
        /// </summary>
        /// <param name="drug"></param>
        private void updateDrugInfo(EmsOrDrug drug)
        {
            if (!this.Created || this.IsLoading) return;
            if (drug == null) return;
            // 预防和治疗
            var fg_propc = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_propc") as XLabelBaseUserRender;
            if (fg_propc != null)
            {
                if (drug.Fg_propc ?? false)
                {
                    fg_propc.ValueText = "True";
                }
                else
                {
                    fg_propc.ValueText = "False";
                }
            }

            // 适应症选中状态
            var fg_treat = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_treat") as XLabelBaseUserRender;
            if (null != fg_treat)
            {
                fg_treat.Checked = (drug.Fg_treat ?? false);
            }
            
            // 自费选中状态
            var fg_selfpay = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_selfpay") as XLabelBaseUserRender;
            if (null != fg_selfpay)
            {
                fg_selfpay.Checked = drug.Fg_selfpay ?? false;
            }
            
            // 皮试选状态
            var fg_skintest = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_skintest") as XLabelBaseUserRender;
            if (null != fg_skintest)
            {
                fg_skintest.Checked = (drug.Fg_skintest ?? false);
            }
            
            //var fg_dose_anoma = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_dose_anoma") as XLabelBaseUserRender;
            // fg_dose_anoma.Checked = drug.fg_dose_anoma.Value;
            // 自备药
            var fg_self = this.GetXapFormControl().GetUserRender(FORM_CARD_PAGECODE, "fg_self") as XLabelBaseUserRender;
            if (null != fg_self)
            {
                fg_self.Checked = (drug.Fg_self ?? false);
            }
            
        }

        #endregion
        protected bool hpCanEdit()
        {
            CiEnContextDTO ciEnContextDTO = BaseEmsView.BaseEmsInfoContext["CiEnContextDTO"] as CiEnContextDTO;
            //保外诊断标识
            string eu_hpbeyond = ciEnContextDTO.Eu_hpbeyond;
            bool isHighBusiness = false;
            if(ciEnContextDTO.Ent4BannerDTO.Sd_hptp!=null&&ciEnContextDTO.Ent4BannerDTO.Sd_hptp.StartsWith("2")){
                isHighBusiness = true;
            }
            //this.Context.GetOrgParam<bool>(ICiOrdNSysParamConst.SYS_PARAM_IsMedicalInsuranceEnable);
            if (this.allowEdit && !string.IsNullOrEmpty(ciEnContextDTO.Id_hp)
                && true == ciEnContextDTO.Fg_hpfundpay && HpBeyondEnum.HPDIAG.Equals(eu_hpbeyond)/*保内诊断*/
                &&!isHighBusiness/*高端商保走自费流程*/
                && isMedicalInsuranceEnable && this.opMedInsuranceAuditHandel == 0)
            {
                return true;
            }
            return false;
        }
        
    }
}
