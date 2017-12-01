using System;
using iih.ci.ord.cior.d;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.ciordems.d;
using xap.rui.bizcontrol.IndicatorControl;
using xap.rui.control.refcontrol.events;
using iih.bd.srv.ems.d;
using xap.cli.sdk.bindings;
using System.Drawing;
using iih.ci.ord.ciorder.Validate;
using xap.cli.sdk.render.labelcontrol;
using iih.ci.ord.ems.d;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.emsdi.d;
using xap.cli.sdk.render;
using iih.ci.ord.ciorder.utils;
using xap.cli.sdk.render.Items;
using xap.mw.coreitf.d;
using xap.rui.appfw;
using xap.rui.control.forms.model;
using xap.rui.bizcontrol.BillFormTmplConst;
using xap.rui.control.extentions;

/********************************************************************************

** 作者： 张万青

** 创始时间：

** 修改人：张万青

** 修改时间：2016-6-30

** 描述： 备血医疗单功能页面


*********************************************************************************/

namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// 备血医疗单
    /// </summary>
    public partial class OrderApbtView : CiorderBaseControl
    {
        #region 变量定义区域
        private bool isCreating = false;//页面是否处于加载过程中
        private XIndicatorControl indicatorControl;
        private int preHeight = 0;
        private string[] adjustHeightIds = new string[] { "name_labitmexplain", "no_applyform", "name_emp_create" };
        private string[] setEnableIds = new string[] { "dt_bt", "name_demandsu", "name_demandsu", "quan_med", "ML", "name_di", "name_pps", "name_mode", "name_his_bt", "growth", "pregnat_num", "parturition_cnt", "fg_db", "name_labitmexplain" };
        //设置输血前检查说明是否必填
        private bool _labitmexplainNullFlag=true;
        public bool labitmexplainNullFlag {
            get { return this._labitmexplainNullFlag; }
            set { 
                this._labitmexplainNullFlag = value;
            }
        }
        private bool isMove = true;
        private XLabelBaseUserRender bloodQuanRender;//输血量控件
        private string idDepMps;
        #endregion

        #region 构造函数区域

        public OrderApbtView()
        {
            InitializeComponent();
            xapFormControl.Load += XapFormControl_Load;
            xapFormControl.FormCreated += XapFormControl_FormCreated;
            xapFormControl.ModelFilled += XapFormControl_ModelFilled;
            xapFormControl.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl_DataChanged);
            xapFormControl.RefFilter += OnRefFilter;
            xapFormControl.RefResult += new EventHandler<RefResultEventArgs>(xapFormControl_RefResult);
            SheetName = "备血医疗单";
        }

        void xapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
            if (e.RefResultSet.IsEmpty) return;
            if (e.BindingFieldName.Equals("Name_srv")) {
               string med_name = e.RefResultSet.FirstData["Med_name"] as string;
                string quan_med = e.RefResultSet.FirstData["Quan_med"] as string;
               //设置输血量单位
               (bloodQuanRender.UserRender as XUnitTextBoxMul).UnitText = med_name;
               (bloodQuanRender.UserRender as XUnitTextBoxMul).ValueText = quan_med;
            }
        }

        #endregion

        #region 父类继承区域

        protected override void OnLoadData()
        {
            
            
        }

        public override void OnRefreshData(EmsUIDTO ems, object e)
        {
            this.labitmexplainNullFlag = true;
            EmsHeadDO = ems;
            this.CiEmsDTO = e as CiEmsDTO;
            if (EmsHeadDO == null)
                return;

            string[] di = new string[2];
            cof.GetPatDis(EmsHeadDO, ref di);
            if (EmsHeadDO.Emsapbt.Id_di == null)
            {
                EmsHeadDO.Emsapbt.Id_di = di[0];
                EmsHeadDO.Emsapbt.Name_diag = di[1];
            }
            if (EmsHeadDO.Emsapbt.BtLabItem.Count == 0)
            {
                LoadIndicatorData();

            }
            else {
                indicatorDataAllFilled(EmsHeadDO.Emsapbt.BtLabItem);
            }
            OrWfDeptInfoDTO wf = new viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(this.EmsHeadDO.PatInfo.Code_entp, EmsHeadDO.PatInfo.Id_entp, EmsHeadDO.MedSrvDO.Sd_srvtp, EmsHeadDO.MedSrvDO.Id_srvca, EmsHeadDO.MedSrvDO.Id_srv, EmsHeadDO.MedSrvDO.Id_route, "id_mm", EmsHeadDO.PatInfo.Id_dep_nur , EmsHeadDO.PatInfo.Id_dep_phy);
            if (wf != null) idDepMps = wf.Id_mp_depts;
            this.CiEmsDTO.Id_dep_mp = wf == null ? "" : wf.Firstid_mp_dept;
            if (this.EmsHeadDO.IsNEW)
            {
                if (wf != null)
                {
                    this.EmsHeadDO.Emsapbt.Id_mp_dep = wf.Firstid_mp_dept;
                    this.EmsHeadDO.Emsapbt.Name_mp_dep = wf.Firstname_mp_dept;
                }

            }
            if (this.Created)
            {
                this.LoadData();
            }
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            if (EmsHeadDO != null)
            {
                file.ViewModel = EmsHeadDO.Emsapbt;

            }
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderApbtView;// "20151026025230902VRK";
            file.FormStyle = FormStyle.Card;
            xapFormControl.ViewFile = file;
          
           
            
        }

        public override void SaveBefore()
        {
            xapFormControl.SaveForm();
        }

        public override IValidate GetOrdValidate()
        {
            return new OrderApbtValidate();
        }
        #endregion

        #region 内部事件区域

        private void XapFormControl_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        private void XapFormControl_ModelFilled(object sender, EventArgs e)
        {
            this.isCreating = true;
            //设置输血量单位
            (bloodQuanRender.UserRender as XUnitTextBoxMul).UnitText = EmsHeadDO.Emsapbt.Name_unit_med;
            (bloodQuanRender.UserRender as XUnitTextBoxMul).ValueText = Convert.ToString(EmsHeadDO.Emsapbt.Quan_med);
            SetIndicatorControl();
            if (isMove)
            {
                resetLocation();
                isMove = false;
            }

            UserRender ur = xapFormControl.GetUserRender("bt_card", "no_db");
            if (this.CiEmsDTO.Sd_su_or != "0" && this.CiEmsDTO.Sd_su_or != null)
            {
                cof.setEnable(this.xapFormControl, "bt_card", setEnableIds, false);
                this.xapFormControl.SetEditPolicy(false);
                this.indicatorControl.Enabled = false;
                ur.Enabled = false;
            }
            else {
                cof.setEnable(this.xapFormControl, "bt_card", setEnableIds, true);
                this.xapFormControl.SetEditPolicy(true);
                this.indicatorControl.Enabled = true;
                ur.Enabled = EmsHeadDO.Emsapbt.Fg_db == true ? true : false;
            }

            //1=男，2=女
            if (EmsHeadDO.PatInfo.Sd_sex == "2" && EmsHeadDO.PatInfo.Dt_birth != null)
            {
                DateTime dt = Convert.ToDateTime(EmsHeadDO.PatInfo.Dt_birth);
                int age = (DateTime.Now - dt).Days / 365;
                if (age >= 18 && (EmsHeadDO.Emsapbt.Parturition_cnt == null || EmsHeadDO.Emsapbt.Pregnat_num == null))
                {
                    (xapFormControl.GetUserRender("bt_card", "pregnat_num") as XLabelBaseUserRender).NullFlag = false;
                    (xapFormControl.GetUserRender("bt_card", "parturition_cnt") as XLabelBaseUserRender).NullFlag = false;
                }
            }

            //男性不显示孕史
            if (EmsHeadDO.PatInfo.Sd_sex == "1")
            {
                xapFormControl.GetUserRender("bt_card", "growth").Enabled = false;
                xapFormControl.GetUserRender("bt_card", "pregnat_num").Enabled = false;
                xapFormControl.GetUserRender("bt_card", "parturition_cnt").Enabled = false;
                Invalidate(true);
            }

            //设置输血前检查说明是否必填
            (xapFormControl.GetUserRender("bt_card", "name_labitmexplain") as XLabelBaseUserRender).NullFlag = labitmexplainNullFlag;

            UserRender dt_bt = xapFormControl.GetUserRender("bt_card", "dt_bt");
            dt_bt.Focus();
            //限制开始时间的时间范围，入院日期，最大提前日期
            TimerComboBoxMaxAndMin.GetInstance().setMaxMinTime(xapFormControl, this.Context, "bt_card", "dt_bt", EmsHeadDO.PatInfo.Id_ent);
            this.isCreating = false;
        }

        void xapFormControl_DataChanged(object sender, xap.rui.control.forms.model.DataChangedEventArgs e)
        {
            if(!string.IsNullOrEmpty(e.PropName)){
                switch (e.PropName)
                {
                    case "Dt_bt":
                        EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsapbt.Dt_bt;//同步开始时间
                        break;
                    case "Pregnat_num":
                        int? num = (int?)e.Input;
                        if (num == 0)
                        {
                            EmsHeadDO.Emsapbt.Parturition_cnt = 0;
                        }
                        //(xapFormControl.GetUserRender("bt_card", "parturition_cnt") as XLabelBaseUserRender).NullFlag = num != null && num == 0;
                        break;

                    case "Parturition_cnt":
                        int? cnt = (int?)e.Input;
                        if (cnt != null && cnt  > 0)
                        {
                            if (EmsHeadDO.Emsapbt.Pregnat_num <=0)
                            {
                                this.ShowInfo("孕数不能小于0");
                            }

                           
                        }
                        break;
                }
            }
        }

        private void XapFormControl_FormCreated(object sender, EventArgs e)
        {
            bloodQuanRender = xapFormControl.GetUserRender("bt_card", "blood_med") as XLabelBaseUserRender;
            bloodQuanRender.ValueTextChanged += new EventHandler(bloodQuanRender_ValueTextChanged);
            bloodQuanRender.MaxLength = 5;
            bloodQuanRender.MultilineNum = 1;
            (bloodQuanRender.UserRender as XUnitTextBoxMul).IsNumber = true;
            (bloodQuanRender.UserRender as XUnitTextBoxMul).MinValue = 1;

            preHeight = indicatorControl.Height;

            xapFormControl.GetUserRender("bt_card", "no_applyform").Enabled = false;
            xapFormControl.GetUserRender("bt_card", "name_emp_create").Enabled = false;
            //indicatorControl.Width = xapFormControl.ClientRectangle.Width;

            XLabelBaseUserRender checkbox = xapFormControl.GetUserRender("bt_card", "fg_db") as XLabelBaseUserRender;
            checkbox.ValueTextChanged += new EventHandler(checkbox_ValueTextChanged);
            UserRender ur = xapFormControl.GetUserRender("bt_card", "no_db");
            ur.Enabled = EmsHeadDO.Emsapbt.Fg_db == true ? true : false;

            if (ur is XLabelBaseUserRender)
            {
                (ur as XLabelBaseUserRender).NullFlag = !ur.Enabled;
            }
        }

        void bloodQuanRender_ValueTextChanged(object sender, EventArgs e)
        {
            XLabelBaseUserRender xLabel = sender as XLabelBaseUserRender;
            EmsHeadDO.Emsapbt.Quan_med = new FDouble(xLabel.ValueText);
        }

        private void checkbox_ValueTextChanged(object sender, EventArgs e)
        {
            if (isCreating) return;
            UserRender ur = xapFormControl.GetUserRender("bt_card", "no_db");
            ur.Enabled = !ur.Enabled;
            EmsHeadDO.Emsapbt.No_db = ur.Enabled ? null : "";
            if (ur is XLabelBaseUserRender)
            {
                (ur as XLabelBaseUserRender).NullFlag = !ur.Enabled;
            }
        }

        protected override void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_diag"))
            {
                e.RefParams.AddParam("id_ent", EmsHeadDO.PatInfo.Id_ent);
            }
            else if (e.BindingFieldName.Equals("Name_srv"))
            {
                if (EmsHeadDO.MedSrvDO.Fg_set != null && EmsHeadDO.MedSrvDO.Fg_set == true)
                {
                    e.RefParams.AddParam("Fg_set", "Y");
                }
                else {
                    e.RefParams.AddParam("Fg_set", "N");
                }
                
                e.RefParams.AddParam("Id_srv", EmsHeadDO.MedSrvDO.Id_srv);
            }
            else if (e.BindingFieldName.Equals("Name_mp_dep") && !string.IsNullOrWhiteSpace(idDepMps))
            {
                e.WherePart = string.Format("id_dep in ({0})", idDepMps);
            }
        }
        #endregion

        #region 辅助处理函数

        private void resetLocation() 
        {
           
                int itemCount = EmsHeadDO.Emsapbt.BtLabItem.Count;
                if (itemCount == 0)
                {
                    var render = xapFormControl.GetUserRender("bt_card", "item") as xap.cli.sdk.render.Items.XLabel;
                    render.Visible = false;
                    indicatorControl.Visible = false;
                    XLabelBaseUserRender labitem =
                        xapFormControl.GetUserRender("bt_card", "name_labitmexplain") as XLabelBaseUserRender;
                    labitem.Visible = false;
                    XLabelBaseUserRender emp_create =
                        xapFormControl.GetUserRender("bt_card", "name_emp_create") as XLabelBaseUserRender;
                    XLabelBaseUserRender no_applyform =
                        xapFormControl.GetUserRender("bt_card", "no_applyform") as XLabelBaseUserRender;
                    //var groupBox = xapFormControl.GetUserRender("bt_card", "appbtgroupbox") as xap.cli.sdk.render.Items.XGroupBox;
                    //groupBox.Location = new Point(render.Location.X, render.Location.Y);
                    emp_create.Location = new Point(emp_create.Location.X, render.Location.Y);
                    no_applyform.Location = new Point(no_applyform.Location.X, render.Location.Y);

                }
                else
                {
                    int currentControlHeight = indicatorControl.Height;
                    int poor = currentControlHeight - preHeight;
                    //var groupBox = xapFormControl.GetUserRender("bt_card", "appbtgroupbox") as xap.cli.sdk.render.Items.XGroupBox;
                    //groupBox.Location = new Point(groupBox.Location.X, groupBox.Location.Y+poor);
                    cof.adjustHeight(this.xapFormControl, "bt_card", adjustHeightIds, poor);
                }
           
        }
        /// <summary>
        /// 动态指标的布局
        /// </summary>
        private void SetIndicatorControl()
        {
            XBindingList bindingList = new XBindingList();
            bindingList.Add(new XBinding("ValueText", "Val_rstrptla"));
            indicatorControl.TopSpace = 0;
            indicatorControl.LeftSpace = 11;
            indicatorControl.RenderWidth = xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 256 : 230;
            indicatorControl.RenderTitleWidth = xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 154 : 144;
            indicatorControl.RowSpace = xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 10 : 5;
            indicatorControl.ColumnSpace = xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 20 : 12;
            indicatorControl.BindingList = bindingList;
            indicatorControl.DataSource = EmsHeadDO.Emsapbt.BtLabItem;
        }

        private void LoadIndicatorData()
        {
            if (EmsHeadDO == null || EmsHeadDO.Emsapbt == null || EmsHeadDO.Emsapbt.BtLabItem == null)
                return;

            EmsHeadDO.Emsapbt.BtLabItem.Clear();

            OrderApbtViewModel viewmodel = new OrderApbtViewModel();

            EmsDynamicIndexDTO[] dtos = viewmodel.getEmsDynamicIndexInfos(EmsHeadDO,this.CiEmsDTO.Id_srvof);

            foreach (EmsDynamicIndexDTO dto in dtos)
            {
                if (labitmexplainNullFlag&&string.IsNullOrEmpty(dto.Indexval))
                {
                    this.labitmexplainNullFlag = false;
                }
                if (dto.Enumvalues != null)
                {
                    dto.Enumvalues = " ," + dto.Enumvalues;
                }
                OrdApSugViewItemDO ordApSugViewItemDO = new OrdApSugViewItemDO()
                 {
                     Val_rstrptla = dto.Indexval == null ? "" : dto.Indexval,
                     Val_restrptlab = dto.Enumvalues == null ? " " :dto.Enumvalues.Replace(',', '|'),
                     Sd_restrptlabtp = dto.Datatype,
                     Name_srv = dto.Showname,
                     Name_unit = dto.Unitname,
                     Id_unit = dto.Id_unit,
                     Id_srv = dto.Id_srv
                 };
                ordApSugViewItemDO.PropertyChanged += new System.ComponentModel.PropertyChangedEventHandler(ordApSugViewItemDO_PropertyChanged);
                EmsHeadDO.Emsapbt.BtLabItem.Add(ordApSugViewItemDO);
            }
        }
        /// <summary>
        /// 判断动态指标是否全部填写
        /// </summary>
        /// <param name="BtLabItem"></param>
        void indicatorDataAllFilled(XapDataList<OrdApSugViewItemDO> btLabItems)
        {
            foreach (OrdApSugViewItemDO item in btLabItems)
            {
                item.PropertyChanged -= new System.ComponentModel.PropertyChangedEventHandler(ordApSugViewItemDO_PropertyChanged);
                if (string.IsNullOrEmpty(item.Val_rstrptla)) {
                    this.labitmexplainNullFlag = false;
                }
                item.PropertyChanged += new System.ComponentModel.PropertyChangedEventHandler(ordApSugViewItemDO_PropertyChanged);
            }
        }

        void ordApSugViewItemDO_PropertyChanged(object sender, System.ComponentModel.PropertyChangedEventArgs e)
        {
            //只要有一个动态指标没有赋值，输血前检查说明就为必填
            bool flag = true;
            foreach (OrdApSugViewItemDO dto in EmsHeadDO.Emsapbt.BtLabItem)
            {
                string s = dto.Val_rstrptla.Trim();
                if (string.IsNullOrEmpty(dto.Val_rstrptla) || string.IsNullOrEmpty(dto.Val_rstrptla.Trim()))
                {
                    flag = false;
                    break;
                }
            }
            (xapFormControl.GetUserRender("bt_card", "name_labitmexplain") as XLabelBaseUserRender).NullFlag = flag;
        }

        #endregion

    }
    
}