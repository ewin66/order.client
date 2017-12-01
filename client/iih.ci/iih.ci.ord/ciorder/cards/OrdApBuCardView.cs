using System.Collections.Generic;
using System.Linq;
using iih.bd.srv.medsrv.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.dto.d;
using iih.ci.ord.ems.d;
using xap.cli.context;
using xap.cli.sdk.render.Items;
using xap.mw.coreitf.d;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using System;
using iih.ci.ord.cior.d;
using iih.bd.bc.udi;
using xap.rui.control.extentions;
using xap.rui.bizcontrol.bannercontrol;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.cli.sdk.render.labelcontrol;

/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述：  用血医疗单

*********************************************************************************
*/

namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// 用血医疗单 card
    /// </summary>
    public partial class OrdApBuCardView : XapListControl
    {
        #region 变量定义区域

        private OrDataBing ordata;
        private OrdApBuCardViewModel _model;
        private XLabel l1, l2, l3;
        private EmsUIDTO emsUIDTO;
        private CiEmsDTO ciemsDto;
        private XLabelBaseUserRender cutQuanMedu;//备血申请量
        private XLabelBaseUserRender cutNumMarginBu;//可用血余量
        private XLabelBaseUserRender cutQuanMeduUb;//本次用血量
        #endregion

        #region 构造函数区域

        public OrdApBuCardView()
        {
            InitializeComponent();
            _model = new OrdApBuCardViewModel();
            this.xapFormControl.FormCreated += new System.EventHandler(xapFormControl_FormCreated);
            this.xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            this.xapFormControl.DataChanged += new System.EventHandler<xap.rui.control.forms.model.DataChangedEventArgs>(xapFormControl_DataChanged);
            this.xapFormControl.RefFilter += new EventHandler<xap.rui.control.refcontrol.events.RefActivatingEventArgs>(xapFormControl_RefFilter);
        }

        void xapFormControl_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_route"))
            {
                e.WherePart = string.Format("sd_srvtp like '{0}%'", BdSrvDictCodeConst.SD_SRVTP_BLOODPROD);
            }
        }

        void xapFormControl_DataChanged(object sender, xap.rui.control.forms.model.DataChangedEventArgs e)
        {
            //throw new System.NotImplementedException();

            switch (e.PropName)
            {
                case "applyform":
                 
                    break;
                case "orsrvname":

                    break;
                case "quan_medu":

                    break;
                case "num_margin_bu":

                    break;
                case "quan_medu_ub":

                    break;
                case "name_route":

                    break;
                case "name_emp_create":

                    break;
                case "dt_bu_pl_ub":

                    break;
                case "des_or":

                    break;
                case "no_applyform_ub":

                    break;
                case "dt_create":

                    break;
                default:
                    break;
                    
            }

        }

        void xapFormControl_FormCreated(object sender, System.EventArgs e)
        {
            this.xapFormControl.SetEditPolicy(true);
            initialization();
            Setunit();
            if (this._model.CiordubDto!=null&&this._model.CiordubDto.Id_apbu != null)
            {
                if (this.ciemsDto!=null&&this.ciemsDto.Sd_su_or != null && this.ciemsDto.Sd_su_or != "0")
                {
                    return;
                }
                //this.xapFormControl.SetEditPolicy(true);
            }
            //限制开始时间的时间范围，入院日期，最大提前日期
            
        }
         void bloodQuanRender_ValueTextChanged(object sender, EventArgs e)
        {
            XLabelBaseUserRender xLabel = sender as XLabelBaseUserRender;
            if (!string.IsNullOrEmpty(xLabel.Name)&&this._model.CiordubDto!=null) { 
                if(xLabel.Name.Equals("ubcard_cut_quan_medu")){
                    this._model.CiordubDto.Quan_medu = string.IsNullOrWhiteSpace(xLabel.ValueText) ? 0 : Convert.ToDouble(xLabel.ValueText);
                }
                else if (xLabel.Name.Equals("ubcard_cut_num_margin_bu"))
                {
                    this._model.CiordubDto.Num_margin_bu = string.IsNullOrWhiteSpace(xLabel.ValueText) ? 0 : Convert.ToDouble(xLabel.ValueText);
                }
                else if (xLabel.Name.Equals("ubcard_cut_quan_medu_ub"))
                {
                    this._model.CiordubDto.Quan_medu_ub = string.IsNullOrWhiteSpace(xLabel.ValueText) ? 0 : Convert.ToDouble(xLabel.ValueText);
                }
            }
            //EmsHeadDO.Emsapbt.Quan_med = new FDouble(xLabel.ValueText);
        }
        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            TimerComboBoxMaxAndMin.GetInstance().setMaxMinTime(xapFormControl, this.Context, "ubcard", "dt_bu_pl_ub", this.emsUIDTO.PatInfo.Id_ent);
            Setunit();
        }
        /// <summary>
        /// 初始化自定义控件,带单位的文本框
        /// </summary>
        private void initialization()
        {
            cutQuanMedu = xapFormControl.GetUserRender("ubcard", "cut_quan_medu") as XLabelBaseUserRender;
            cutQuanMedu.ValueTextChanged += new EventHandler(bloodQuanRender_ValueTextChanged);
            cutQuanMedu.MultilineNum = 1;
            (cutQuanMedu.UserRender as XUnitTextBoxMul).IsNumber = true;
            (cutQuanMedu.UserRender as XUnitTextBoxMul).MinValue = 1;
            (cutQuanMedu.UserRender as XUnitTextBoxMul).Enabled = false;

            cutNumMarginBu = xapFormControl.GetUserRender("ubcard", "cut_num_margin_bu") as XLabelBaseUserRender;
            cutNumMarginBu.ValueTextChanged += new EventHandler(bloodQuanRender_ValueTextChanged);
            cutNumMarginBu.MultilineNum = 1;
            (cutNumMarginBu.UserRender as XUnitTextBoxMul).IsNumber = true;
            (cutNumMarginBu.UserRender as XUnitTextBoxMul).MinValue = 0;
            cutNumMarginBu.Enabled = false;

            cutQuanMeduUb = xapFormControl.GetUserRender("ubcard", "cut_quan_medu_ub") as XLabelBaseUserRender;
            cutQuanMeduUb.ValueTextChanged += new EventHandler(bloodQuanRender_ValueTextChanged);
            cutQuanMeduUb.MultilineNum = 1;
            (cutQuanMeduUb.UserRender as XUnitTextBoxMul).IsNumber = true;
            (cutQuanMeduUb.UserRender as XUnitTextBoxMul).MinValue = 1;
        }
        private void Setunit()
        {
            this.xapFormControl.SetEditPolicy(true);
            if (_model.CiordubDto != null && cutQuanMedu!=null)
            {
                (cutQuanMedu.UserRender as XUnitTextBoxMul).UnitText = _model.CiordubDto.Name_unit;
                cutQuanMedu.Enabled = false;
                (cutQuanMedu.UserRender as XUnitTextBoxMul).ValueText = _model.CiordubDto.Quan_medu==null?"":Convert.ToString(_model.CiordubDto.Quan_medu);

                cutNumMarginBu.Enabled = true;
                (cutNumMarginBu.UserRender as XUnitTextBoxMul).Enabled = true;
                (cutNumMarginBu.UserRender as XUnitTextBoxMul).UnitText = _model.CiordubDto.Name_unit;
                (cutNumMarginBu.UserRender as XUnitTextBoxMul).ValueText = _model.CiordubDto.Num_margin_bu == null ? "" : Convert.ToString(_model.CiordubDto.Num_margin_bu);
                cutNumMarginBu.Enabled = false;
                (cutNumMarginBu.UserRender as XUnitTextBoxMul).Enabled = false;

                (cutQuanMeduUb.UserRender as XUnitTextBoxMul).UnitText = _model.CiordubDto.Name_unit;
                (cutQuanMeduUb.UserRender as XUnitTextBoxMul).ValueText = _model.CiordubDto.Quan_medu_ub == null ? "" : Convert.ToString(_model.CiordubDto.Quan_medu_ub);
            }
        }

        #endregion

        #region 父类继承区域

        /// <summary>
        ///     获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
           
        }

        /// <summary>
        ///     CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            var file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrdApBuCardView;// "20151130043957152MFL";
            file.FormStyle = FormStyle.Card;

            if (_model.CiordubDto != null)
            {
                 
               file.ViewModel = _model.CiordubDto;
                
            }
            xapFormControl.ViewFile = file;
        }


        public override void OnSelected(object sender, TargetEventArgs e)
        {
            var dto = e.Object as CiordubDTO;
            if (dto == null)
                return;
           


            if (dto.Id_apbu == null)
            {
                if (dto.No_applyform_ub == ""||dto.No_applyform_ub==null)
                {
                     dto.No_applyform_ub = this._model.getNoapp();
                }
               
                dto.Name_route = this._model.getRotName(dto.Id_route);
                dto.Dt_bu_pl_ub = this.NowTime();
                dto.Id_emp_create = UserManager.getInstance().CurrentPsnInfo.Id_psndoc;
                dto.Name_emp_create = UserManager.getInstance().CurrentPsnInfo.Name;
                dto.Dt_create = new FDateTime();
            }
            //dto.Quan_medu_ub = dto.Num_margin_bu;
            _model.CiordubDto = dto;
            OnFillData();
            if (this.ciemsDto==null||(this.ciemsDto.Sd_su_or == null || this.ciemsDto.Sd_su_or == "0"))
            {
                this.xapFormControl.SetEditPolicy(true);
            }
            else
            {
                this.xapFormControl.SetEditPolicy(false);
            }
            Setunit();
            //填充完数据后，要置空，不然下次再加载的数据时上一条的数据
            this.ciemsDto = null;
        }

        #endregion

        public void loadcard(EmsUIDTO emsHeadDO,CiEmsDTO emsdto)
        {
            this.emsUIDTO = emsHeadDO;
            this.ciemsDto = emsdto;
            if (this.emsUIDTO.CiordubDTO != null)
            {
                this._model.CiordubDto = this.emsUIDTO.CiordubDTO;
                if (!string.IsNullOrEmpty(this.ciemsDto.Id_or)) {
                    CiordubDTO ubDto = this._model.getOrderUBDto(this.ciemsDto.Id_or);
                    if (ubDto!=null)
                    this._model.CiordubDto.Quan_medu = ubDto.Quan_medu;
                }
                if (this.emsUIDTO.CiordubDTO.Id_apbu != null)
                {
                    this.LoadData();
                    if (this.ciemsDto.Sd_su_or != null && this.ciemsDto.Sd_su_or == "0")
                    {
                        this.xapFormControl.SetEditPolicy(true);
                    }
                    else {
                        OrdApBtDO apbtdo = this._model.getOrDerBtDto(this.emsUIDTO.CiordubDTO.Id_or_rel);
                        if (apbtdo != null)
                        {
                            this._model.CiordubDto.Applyform = apbtdo.No_applyform;
                            this._model.CiordubDto.Num_margin_bu = apbtdo.Num_margin_bu;
                        }
                        this.xapFormControl.SetEditPolicy(false);

                    }
                    
                }
                else
                {
                    this.LoadData();
                    this.xapFormControl.SetEditPolicy(false);

                }
                //if (ems.Id_or != null || ems.Id_or != "")
                //{
                //    this._model.getOrderUBDto(ems.Id_or);
                //    this._model.CiordubDto.Name_route = this._model.getRotName(this._model.CiordubDto.Id_route);

                //}
            }
            else
            {
                this._model.CiordubDto = null;
                this.LoadData();
                this.xapFormControl.SetEditPolicy(false);

            }
           
        }

        //public void save(MedSrvDO med, CiEmsDTO dto)
        //{
        //    if (this._model.CiordubDto.Id_or == null)
        //        return;
        //    this._model.save(this._model.ToCiEmsDto(med,dto, ordata));
        //}

        #region 状态控制区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            var uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;

            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    var dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    if (dic != null)
                    {
                        if (dic.Keys.Contains("ordata"))
                        {
                            ordata = dic["ordata"] as OrDataBing;

                        }

                    }

                    break;
            }
        }
        public string validateBeforeSave() {
            if (this.xapFormControl.HasErrors) {
                string errorInfo = this.xapFormControl.ErrorAlertText;
                return errorInfo;
            }
            return null;
        }
        #endregion
    }
}