using System;
using iih.bd.srv.medsrv.d;
using iih.bd.srv.medsrv.i;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.opemergency.validate;
using xap.cli.sdk.bindings;
using xap.mw.serviceframework;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.opemergency.ems.common;
using iih.ci.ord.opemergency.view;
using iih.ci.ord.opemergency.tool;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.opemergency.view.basic;
using xap.rui.control.forms.control;
using iih.ci.ord.opemergency.ems.dp;
using iih.bd.bc.udi;
using iih.ci.ord.ciorder.d;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.ems.d;
using iih.ci.ord.dto.d;
using xap.mw.coreitf.d;
using iih.ci.ord.ciorder.i;
using iih.ci.ord.cior.i;
using xap.rui.bizcontrol.IndicatorControl;
using xap.cli.sdk.render;
using xap.rui.control.extentions;
using xap.mw.func;
using iih.ci.ord.opemergency.declare;
using xap.rui.control.formcontrol.model;

/*
********************************************************************************

** 作者： 李程

** 创始时间：2016-6-30

** 修改人：李程

** 修改时间：2016-6-30

** 描述： 备血医疗单


*********************************************************************************
*/
namespace iih.ci.ord.opemergency.ems
{
    /// <summary>
    ///     备血医疗单
    /// </summary>
    public partial class EmsApbtViewCard : BaseEmsFormView
    {
        #region 构造函数区域
        private XIndicatorControl indicatorControl;
        private XLabelBaseUserRender checkbox;//是否有献血史
        public EmsApbtViewCard(IEventDelegate o)
            : base(o)
        {
            InitializeComponent();

            srvItemViewType = EmsViewType.EmsApbtViewType;
            iValidate = new EmsApbtValidate();
            this.GetXapFormControl().DataDisplay += new EventHandler<xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs>(EmsApbtViewCard_DataDisplay);
        }
        private void InitializeComponent()
        {
            //  this.xapFormControl = new xap.rui.control.forms.view.XapFormControl();
            this.SuspendLayout();

            XBindingList bindingList = new XBindingList();
            indicatorControl = new xap.rui.bizcontrol.IndicatorControl.XIndicatorControl();
            indicatorControl.Location = new System.Drawing.Point();
            bindingList.Add(new XBinding("ValueText", "Val_rstrptla"));
            //indicatorControl.BindingList = bindingList;
            indicatorControl.Category = "Val_restrptlab";
            indicatorControl.TitleName = "Name_srv";
            indicatorControl.Type = "Sd_restrptlabtp";
            indicatorControl.ValueString = "Val_rstrptla";
            indicatorControl.Unit = "Name_unit";

            indicatorControl.TopSpace = 0;
            indicatorControl.LeftSpace = 1;
            indicatorControl.RenderWidth = 238;
            indicatorControl.RenderTitleWidth = 84;
            indicatorControl.ColumnSpace = 8;

            System.Collections.Generic.Dictionary<string, System.Windows.Forms.Control> controls = new System.Collections.Generic.Dictionary<string, System.Windows.Forms.Control>();
            controls.Add("checkitem", indicatorControl);


            this.GetXapFormControl().RegisterControl(controls);

            this.Name = "OrderApbtView";
            this.ResumeLayout(false);
            this.PerformLayout();
        }
        protected override void InitializeBizView()
        {
            base.InitializeBizView();

            this.SetFormId(CiOrdBillFormTmplConst.CIORD_OP_EmsApbtViewCard/*"20160611043735428S0H"*/);

            this.SetGridPageCode("name_srv");

            this.RegisteFormEventImpl();

         
        }

        protected override void OnXapFormControl_FormCreated(object sender, EventArgs e)
        {
            base.OnXapFormControl_FormCreated(sender, e);

            checkbox = this.GetXapFormControl().GetUserRender("preblood", "fg_db") as XLabelBaseUserRender;
            checkbox.ValueTextChanged += new EventHandler(checkbox_ValueTextChanged);
            UserRender ur = this.GetXapFormControl().GetUserRender("preblood", "no_db");
            ur.Enabled = checkbox.Checked;
        }

        private void checkbox_ValueTextChanged(object sender, EventArgs e)
        {
            UserRender ur = this.GetXapFormControl().GetUserRender("preblood", "no_db");
            ur.Enabled = !ur.Enabled;
            (ur as XLabelBaseUserRender).NullFlag = !ur.Enabled;
            if (!ur.Enabled)
                (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapbt.No_db = null;
        }

        protected override void OnXapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            var sbm = new StringObjectMap();
            if (e.BindingFieldName.Equals("Name_diag"))
            {
                e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName, sbm);
                e.RefParams.AddParam("id_ent", (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).PatInfo.Id_ent);
            }
            else if (e.BindingFieldName.Equals("Name_mp_dep"))
            {
                e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName, sbm);
            }
            else if (e.BindingFieldName.Equals("Name_srv")) {
                if ((this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).MedSrvDO.Fg_set != null && (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).MedSrvDO.Fg_set == true)
                {
                    e.RefParams.AddParam("Fg_set", "Y");
                }
                else
                {
                    e.RefParams.AddParam("Fg_set", "N");
                }

                e.RefParams.AddParam("Id_srv", (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).MedSrvDO.Id_srv);
            }
            else
            {
                e.WherePart = this.GetViewModel().OnRefFilterData(e.BindingFieldName, sbm);
            }
            foreach (var item in sbm)
            {
                e.RefParams.AddParam(item.Key, item.Value);
            }
        }



        protected override void OnXapFormControl_DataChanged(object sender, xap.rui.control.forms.model.DataChangedEventArgs e)
        {
            if (this.GetViewModel() == null || e.Input == null)
                return;
            updateCustomerControlInfo(GetGridControl().DataTable.GetFirstRow(), (GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapbt);

            if (!string.IsNullOrEmpty(e.PropName) && e.PropName.Equals("Name_srv"))
            {
                this.SentNotify(EventCodeType.NM_EMS_ORSRV_DATACHANGED);
            }
        }
        #endregion

        #region 父类继承区
        public override bool OnEventHandle(object sender, xap.rui.engine.DictionaryEventArgs e)
        {
            if (AssToolEx.EventCodeOfEventArgs(e).Equals(EventCodeType.EVENT_EMS_APBU_ADD))
            {
                var emsdto = (GetViewModel().GetEmsUIDTO() as EmsUIDTO);
                //备血医嘱开立，1、保存医嘱，2、后签署医嘱，3、生成用血医嘱
                if (orIsOpen())
                {
                    if (!this.SentNotify(EventCodeType.NM_EMS_SAVE) || this.GetViewModel().getCiOrderDO()==null)
                    {
                        return false;
                    }
                    LogicEx.GetInstance().SignCiOrder(new CiOrderDO[] { this.GetViewModel().getCiOrderDO() }, this.GetViewModel().GetEnt4BannerDTO());
                    if (!this.SentNotify(EventCodeType.EVENT_EMS_REFRESH)) return false; 
                    MedSrvDO medSrcDO = LogicEx.GetInstance().getApBuSrv();
                    if (null != medSrcDO && emsdto.CiordubDTO != null)
                    {
                        this.GetViewModel().SetCustomParam(creatBuEmsDO(this.GetViewModel().getCiOrderDO().Id_or, medSrcDO));
                        // SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParameter.TAGKEY, new EmsCreatedParameter(medSrcDO, null, emsdto.CiordubDTO));
                        this.SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParamList.TAGKEY, new EmsCreatedParamList() { new EmsCreatedParameter(medSrcDO, null, emsdto.CiordubDTO) });
                    }
                }//医嘱已签署，生成用血医嘱
                else {
                    MedSrvDO medSrcDO = LogicEx.GetInstance().getApBuSrv();
                    if ((this.GetViewModel().getCiEmsDTO() as CiEmsDTO).Id_or != null)
                    {
                        //拼接用血医嘱的元数据
                        creatBuEmsDO((this.GetViewModel().getCiEmsDTO() as CiEmsDTO).Id_or, medSrcDO);
                    }
                    if (null != medSrcDO && emsdto.CiordubDTO != null)
                    {
                        this.GetViewModel().SetCustomParam(emsdto.CiordubDTO);
                        // SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParameter.TAGKEY, new EmsCreatedParameter(medSrcDO, null, emsdto.CiordubDTO));
                        this.SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParamList.TAGKEY, new EmsCreatedParamList() { new EmsCreatedParameter(medSrcDO, null, emsdto.CiordubDTO) });
                    }
                }
                
            }
            return base.OnEventHandle(sender, e);
        }

        #endregion

        #region 内部事件区域

        protected override void OnXapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            if (e.PropName.Equals("Components_name") && null != this.GetViewModel() && !System.String.IsNullOrEmpty(GetViewModel().getCiEmsDTO().Id_or))
            {
                e.Cancel = true;
            }
            else
            {
                base.OnXapFormControl_AllowEditing(sender, e);
            }
        }
        protected override void OnXapFormControl_RefResult(object sender, RefResultEventArgs e)
       
        {
            // 参照取回数据后，处理显示名称 服务名称
            //if (e.BindingFieldName.Equals("Components_name"))
            //{
            //    // 如模型为空  第一次创建
            //    var service = XapServiceMgr.find<IMedsrvMDOCrudService>();
            //    MedSrvDO medSrcDO = service.findById((e.DataObject as EmsBtItemDO).Id_srv);
            //    // 第一次新建或者服务不一致，都认为重新计算UI展现
            //    int rowCount = GetXapFormControl().GetGridView("name_srv").DataTable.Rows.Count;
            //    if (GetViewModel() == null || rowCount == 1)
            //    {
            //        //SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParameter.TAGKEY, new EmsCreatedParameter(medSrcDO, null));
            //        this.SentNotify(EventCodeType.NM_EMS_CREATE, EmsCreatedParamList.TAGKEY, new EmsCreatedParamList() { new EmsCreatedParameter(medSrcDO, null) });
            //    }
            //}
            if (e.BindingFieldName.Equals("Components_name"))
            {
                if (e.RefResultSet.IsEmpty)
                {
                    SentNotify(EventCodeType.NM_EMS_CLOSE);
                }
                else
                {
                    this.GetViewModel().LoadMedSrv(new EmsCreatedParameter(new bd.srv.medsrv.d.MedSrvDO() { Id_srv = (e.DataObject as EmsBtItemDO).Id_srv }, null));
                }
            }
            else
            {
                base.OnXapFormControl_RefResult(sender, e);
            }
        }



        protected override void OnXapFormControl_ModelFilled(object sender, EventArgs e)
        {
            base.OnXapFormControl_ModelFilled(sender, e);
            this.ResetColumnsInfo(this.GetGridControl());
            if (GetViewModel() == null)
                return;

            GetGridControl().DataTable.DataSource = GetViewModel().GetTableDataSource();
            OnRefreshData();
            SetIndicatorControl();

            var dtAge = new DateTime(CommonExtentions.NowTime(this).Subtract(DateTime.Parse(this.GetViewModel().GetEnt4BannerDTO().Dt_birth)).Ticks);

            var nAge = dtAge.Year;

            try
            {
                int[] ages = CalcAgeArray.getAgeArray(DateTime.Parse(this.GetViewModel().GetEnt4BannerDTO().Dt_birth));
                if (ages != null)
                {
                    nAge = ages[0];
                }
            }
            catch //(Exception exc)
            {
                this.SetStatusMsg("年龄使用默认值");
            }

            var pregnat_num = AssXapFormUtils.GetUserRender(this.GetXapFormControl(), "preblood.pregnat_num") as XLabelBaseUserRender;
            if (null != pregnat_num && this.allowEdit)
            {
                // 1,男性; 2, 女
                pregnat_num.NullFlag = this.GetViewModel().GetEnt4BannerDTO().Sd_sex == "1" ||( nAge < 18 && this.GetViewModel().GetEnt4BannerDTO().Sd_sex == "2");
                pregnat_num.Enabled = !(this.GetViewModel().GetEnt4BannerDTO().Sd_sex == "1");
            }
            var parturition_cnt = AssXapFormUtils.GetUserRender(this.GetXapFormControl(), "preblood.parturition_cnt") as XLabelBaseUserRender;
            if (null != parturition_cnt && this.allowEdit)
            {
                parturition_cnt.NullFlag = this.GetViewModel().GetEnt4BannerDTO().Sd_sex == "1" || (nAge < 18 && this.GetViewModel().GetEnt4BannerDTO().Sd_sex == "2");
                parturition_cnt.Enabled = !(this.GetViewModel().GetEnt4BannerDTO().Sd_sex == "1");
            }
            
            var ur = AssXapFormUtils.GetUserRender( this.GetXapFormControl(), "preblood.no_db");
            ur.Enabled = checkbox.Checked;
            (ur as XLabelBaseUserRender).NullFlag = !ur.Enabled;
            if (!ur.Enabled)
                (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapbt.No_db = null;

            AdjustLayout();

            this.SetFocus();
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

        #endregion

        #region 函数区域

        public void OnRefreshData()
        {
            var emsdto = (GetViewModel().GetEmsUIDTO() as EmsUIDTO);

            if (emsdto == null)
                return;

            var di = new string[2];
            if (emsdto.Emsapbt.Id_di == null)
            {
                emsdto.Emsapbt.Id_di = di[0];
                emsdto.Emsapbt.Name_diag = di[1];
            }
        }


        private void SetIndicatorControl()
        {
            var emsdto = (GetViewModel().GetEmsUIDTO() as EmsUIDTO);
            var bindingList = new XBindingList();
            bindingList.Add(new XBinding("ValueText", "Val_rstrptla"));
            foreach (OrdApSugViewItemDO itemDo in emsdto.Emsapbt.BtLabItem)
            {
                if (itemDo.Val_rstrptla == null)
                    itemDo.Val_rstrptla = "";
            }

            indicatorControl.BindingList = bindingList;
            indicatorControl.DataSource = emsdto.Emsapbt.BtLabItem;

            indicatorControl.Enabled = this.allowEdit;
        }
        
        void EmsApbtViewCard_DataDisplay(object sender, xap.cli.sdk.controls.DataView.Model.XDataDisplayEventArgs e)
        {
            updateCustomerControlInfo(GetGridControl().DataTable.GetFirstRow(), (GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapbt);
        }

        /// <summary>
        /// 更新用户自定义列单元格信息
        /// </summary>
        /// <param name="row"></param>
        /// <param name="drug"></param>
        void updateCustomerControlInfo(XDataRow row, EmsBtItemDO Emsapbt)
        {
            if (Emsapbt == null)
            {
                return;
            }
            if (row != null && row.ColumnCellDict.ContainsKey("customercolumn_quan_bt"))
            {
                if (Emsapbt.Quan_med == null)
                    Emsapbt.Quan_med = 0;
                if (Emsapbt.Name_unit_med == null)
                    Emsapbt.Name_unit_med = "";
                string strMed_unit = Emsapbt.Quan_med.ToString() + Emsapbt.Name_unit_med;
                row.ColumnCellDict["customercolumn_quan_bt"].SetValue(strMed_unit);
            }
        }
        bool orIsOpen() {
            return this.GetViewModel().getCiEmsDTO() == null || (this.GetViewModel().getCiEmsDTO() as CiEmsDTO).Sd_su_or == null || (this.GetViewModel().getCiEmsDTO() as CiEmsDTO).Sd_su_or.Equals("0");
        }
        /// <summary>
        /// 创建用血医嘱元数据
        /// </summary>
        /// <param name="id_or"></param>
        /// <returns></returns>
        CiordubDTO creatBuEmsDO(string id_or, MedSrvDO medSrcDO)
        {
            CiorderAggDO ciagg = XapServiceMgr.find<ICiorderCrudService>().findById(id_or);
            CiOrderDO ciOrder = ciagg.getParentDO();
            OrdApBtDO[] btdos = XapServiceMgr.find<ICiorappbtMDOCrudService>().find("id_or='" + id_or + "'", null, FBoolean.False);
            OrdApBtDO btdo = btdos[0];
            OrdSrvDO mainSrv = null;
            foreach (OrdSrvDO ordsrv in ciagg.getOrdSrvDO()) {
                if (ordsrv.Eu_sourcemd != null && ordsrv.Eu_sourcemd == (int)OrSrvSourceFromEnum.PHYSIAN && ordsrv.Sd_srvtp == BdSrvDictCodeConst.SD_SRVTP_BLOODPROD_BLOODPROD_READYBLOOD) {
                    mainSrv = ordsrv;
                    break;
                }
            }
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO = new CiordubDTO();
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Id_or_rel = ciOrder.Id_or;
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Applyform = btdo.No_applyform;
            if (mainSrv != null) {
                (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Orsrvname = mainSrv.Name;
                (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Quan_medu = mainSrv.Quan_medu;
                (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Id_unit = mainSrv.Id_medu;
                (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Name_unit = mainSrv.Medu_name;
            }
            
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Id_srv = ciOrder.Id_srv;
            
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Dt_bt_pl = Convert.ToDateTime(btdo.Dt_bt_pl);
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Num_margin_bu = btdo.Num_margin_bu;
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Id_emp_sign = ciOrder.Id_emp_sign;
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Name_emp_sign = ciOrder.Emp_sign_name;
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Id_route = medSrcDO.Id_route;
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Name_route = medSrcDO.Route_name;
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Quan_medu_ub = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Quan_medu;
            (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO.Id_unit = (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).Emsapbt.Id_unit_med;
            return (this.GetViewModel().GetEmsUIDTO() as EmsUIDTO).CiordubDTO;
        }
        #endregion
    }
}