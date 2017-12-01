using System;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;
using xap.rui.bizcontrol.IndicatorControl;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.events;
using System.Linq;
using iih.bd.bc.udi;
using iih.ci.ord.ciorder.Validate;
using xap.cli.sdk.bindings;
using iih.bd.srv.service.i;
using xap.mw.serviceframework;
using iih.bd.srv.ems.d;
using System.Collections.Generic;
using iih.bd.srv.dto.d;
using iih.bd.srv.ems.i;
using xap.cli.sdk.render.labelcontrol;
using xap.cli.sdk.render.Items;
using System.Globalization;
using iih.ci.ord.ems.d;
using xap.rui.appfw;
using xap.cli.sdk.controls.DataView;
using iih.ci.ord.emsdi.d;
using System.Drawing;
using xap.cli.sdk.render;
using xap.rui.control.commands;
using xap.rui.bizcontrol.BillFormTmplConst;
/********************************************************************************

** 作者： 张万青

** 创始时间：

** 修改人：张万青

** 修改时间：2016-6-30

** 描述： 手术医疗单功能页面


*********************************************************************************/
namespace iih.ci.ord.ciorder.cards
{
    ///// <summary>
    /// 手术医疗单
    /// </summary>
    /// Author:admin
    /// Date:2015-10-10
    public partial class OrderOpView : CiorderBaseControl
    {
        #region 变量定义区域

        private XapFormGridControl gv_mm;//卫材
        private XapFormGridControl gv_emp;//人员
        private XapFormGridControl gv_oper;//附加手术
        //private Dictionary<string, UserRender> dic = new Dictionary<string, UserRender>();
        private string[] adjustHeightIds = new string[] { "name_emp_operator", "name_emp_help1", "name_sugbodycod", "specialreq", "specialinstrument", "specialdes", "announcements" };
        private int preHeight = 0;
        private XIndicatorControl indicatorControl;
        private bool dataChanging;

        private string idDepMps;
        private string[] Fg_sugs;

        private string id_mm_selec;
        private PageCommands[] pageCommands;//页签的按钮
        private IBdSrvQryService qryservice;

        private ctlEx.OrdPageCommand emp_OrdPageCommand;
        #endregion

        #region 构造函数区域

        public OrderOpView()
        {
            dataChanging = false;
            Fg_sugs = new[] { "Fg_er_sug", "Fg_xq_sug", "Fg_zq_sug" };

            InitializeComponent();

            xapFormControl.Load += XapFormControl_Load;
            xapFormControl.FormCreated += XapFormControl_FormCreated;
            xapFormControl.ModelFilled += XapFormControl_ModelFilled;
            xapFormControl.DataChanged += XapFormControl_DataChanged;
            xapFormControl.RefFilter += XapFormControl_RefFilter;
            xapFormControl.RefResult += new EventHandler<RefResultEventArgs>(XapFormControl_RefResult);
            xapFormControl.AllowEditing += XapFormControl_AllowEditing;
            SheetName = "手术医疗单";
        }


        #endregion

        #region 公开属性区域

        #endregion

        #region 父类继承区域
        public override void OnStatus()
        {
            if (gv_emp != null && emp_OrdPageCommand!=null)
            {
                emp_OrdPageCommand.delCommand.Enabled = gv_emp.DataTable.Rows.Count > 0 && gv_emp.DataTable.SelectedRow != null
                    && gv_emp.DataTable.SelectedRow.Index > 1;
            }
        }

        protected override void OnLoadData()
        {
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderOpView;// "20151031071006815BDJ";
            if (EmsHeadDO != null)
            {
                file.ViewModel = EmsHeadDO.Emsapop;
            }
            file.FormStyle = FormStyle.Card;
            xapFormControl.ViewFile = file;
        }

        public override void OnRefreshData(EmsUIDTO ems, object e)
        {
            EmsHeadDO = ems;
            this.CiEmsDTO = e as CiEmsDTO;
            OrWfDeptInfoDTO  wf = new viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(EmsHeadDO.PatInfo.Code_entp, 
                 EmsHeadDO.PatInfo.Id_entp, EmsHeadDO.MedSrvDO.Sd_srvtp, EmsHeadDO.MedSrvDO.Id_srvca, EmsHeadDO.MedSrvDO.Id_srv, 
                 EmsHeadDO.MedSrvDO.Id_route, "id_mm", EmsHeadDO.PatInfo.Id_dep_nur, EmsHeadDO.PatInfo.Id_dep_phy);
            idDepMps = wf == null ? "" : wf.Id_mp_depts;
            string[] di = new string[2];
            if (EmsHeadDO.IsNEW)
            {
                LoadIndicatorData();
                EmsHeadDO.Emsapop.Id_mp_dep = wf == null ? "" : wf.Firstid_mp_dept; ;
                EmsHeadDO.Emsapop.Name_mp_dep = wf == null ? "" : wf.Firstname_mp_dept;
                cof.GetPatDis(EmsHeadDO, ref di);
                EmsHeadDO.Emsapop.Id_di = di[0];
                EmsHeadDO.Emsapop.Name_diag = di[1];
            }

            if (Created)
            {
                this.LoadData();
            }
        }

        public override IValidate GetOrdValidate()
        {
            return new OrderOpValidate();
        }

        #endregion

        #region 内部事件区域

        private void XapFormControl_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        private void XapFormControl_RefFilter(object sender, RefActivatingEventArgs e)
        {
            //xapFormControl.SaveForm();
            if (e.BindingFieldName.Equals("Name_mp_dep") && !string.IsNullOrWhiteSpace(idDepMps))
            {
                e.WherePart = string.Format("sd_depttp in ('01','02','03') and id_dep in ({0})", idDepMps);
            }
            //其他人员-角色
            else if (e.BindingFieldName.Equals("Name_role"))
            {
                if (!(e.DataObject is EmsItemInOp))
                    return;
                string[] whereparts = new[] { CiDictCodeConst.SD_OP_ROLE_ZDYS, CiDictCodeConst.SD_OP_ROLE_DYZS };
                e.WherePart = string.Format("bd_udidoc.code not in ('{0}')", string.Join("','",whereparts));
            }
            //准备特殊器材-物品名称
            else if (e.BindingFieldName.Equals("Name_mm"))
            {
             if (!(e.DataObject is EmsItemInOp))
                    return;
                //物品名称不可重复
                //this.xapFormControl.SaveForm();
                XapDataList<EmsItemInOp> MMlist = this.EmsHeadDO.Emsapop.OpMmItem;
                string ids = "";
                foreach (EmsItemInOp item in MMlist)
                {
                    if (item.Id_mm != null)
                    {
                        if (id_mm_selec != null && item.Id_mm.Equals(id_mm_selec))
                            continue;
                        ids += "'" + item.Id_mm + "',";
                    }
                }
                //EmsItemInOp item = gv_mm.GetFocusedRow().RowDataSource as EmsItemInOp;
                if (ids.Length != 0)
                {
                    ids = ids.Substring(0, ids.Length - 1);
                    e.WherePart = string.Format("BD_MM.id_mm not in ({0})", ids);
                }
                
            }
            //附加手术-手术名称
            else if (e.BindingFieldName.Equals("Name_srv"))
            {
                if (!(e.DataObject is EmsItemInOp))
                    return;
                XapDataList<EmsItemInOp> MMlist = this.EmsHeadDO.Emsapop.OpAppendOpItem;
                string ids = "";
                foreach (EmsItemInOp item in MMlist)
                {
                    if (item.Id_srv != null)
                    {
                        ids += "'" + item.Id_srv + "',";
                    }
                }
                if (ids.Length != 0)
                {
                    ids = ids.Substring(0, ids.Length - 1);
                    e.WherePart = string.Format("sd_srvtp like '{0}%' and id_srv <> '{1}' and fg_active='{2}' and id_srv not in ({3})", "0401", EmsHeadDO.MedSrvDO.Id_srv, "Y", ids);
                }
                else {
                    e.WherePart = string.Format("sd_srvtp like '{0}%' and id_srv <> '{1}' and fg_active='{2}'", "0401", EmsHeadDO.MedSrvDO.Id_srv, "Y");
                }
                
            }else if (e.BindingFieldName.Equals("Name_diag"))
            {
               e.RefParams.AddParam("id_ent", EmsHeadDO.PatInfo.Id_ent);
            }
            else if (e.BindingFieldName.Equals("Name_emp_operator") || e.BindingFieldName.Equals("Name_emp_help1") || e.BindingFieldName.Equals("Name_emp_op"))
            {
                string ids = "";
               List<EmsItemInOp> itemList = EmsHeadDO.Emsapop.OpEmpItem.ToList<EmsItemInOp>();
               foreach (EmsItemInOp item in itemList)
               {
                   if (item.Id_emp_op != null)
                   {
                       ids += "'" + item.Id_emp_op + "',";
                   }
               }
               string strSql = string.Format(" bd_psndoc.activestate = '2' and bd_psndoc.id_group = '{0}' and bd_psndoc.sd_empwktp = '{1}'", this.Context.Group.Id_grp, BdResDictCodeConst.SD_EMPWKTP_DOC);
               if (ids.Length > 0)
               {
                   ids = ids.Substring(0, ids.Length - 1);
                   strSql += string.Format(" and bd_psndoc.id_psndoc not in ({0})", ids);
               }

               e.WherePart = strSql;
            }
        }

        private void XapFormControl_RefResult(object sender, RefResultEventArgs e)
        {
           // string s = "0";
        }

        private void XapFormControl_FormCreated(object sender, EventArgs e)
        {
            xapFormControl.SetTabPageEnabled("opitem", !IsReadOnly);
            xapFormControl.SetTopPanelHeight(xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 535 : 335);
            xapFormControl.SetToilHeight(150);

            //List<ControlTab> tabs = xapFormControl.FormModel.Tabs;
            //dic = tabs[0].Pages[0].DicUserRenders;

            gv_emp = xapFormControl.GetGridView("otheremp");
            gv_mm = xapFormControl.GetGridView("eisai");
            gv_mm.DataTable.MouseClick += new System.Windows.Forms.MouseEventHandler(gv_mm_MouseClick);
            gv_oper = xapFormControl.GetGridView("addsug");

            //gv_mm.MouseClick += gv_mm_MouseClick;
            //if (EmsHeadDO.IsNEW || this.CiEmsDTO.Sd_su_or == null || this.CiEmsDTO.Sd_su_or == "0")
            {
                SetTabCommand();
            }
            preHeight = indicatorControl.Height;

            UserRender btn = xapFormControl.GetUserRender("opitem", "btn");
            if (btn != null)
                btn.Visible = false;
            //xapFormControl.SetEditPolicy(true);
            //SetGridPolicy(true);this.thisthis.
            xapFormControl.ShowTabPage("eisai", false);//隐藏卫材页签，高值耗材 需求不确定
           
        }

        private void gv_mm_MouseClick(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            EmsItemInOp emsItemInOp = ((XDataRow)sender).RowDataSource as EmsItemInOp;//获取选中卫材
            if (emsItemInOp != null)
            {
                id_mm_selec = emsItemInOp.Id_mm;
            }
        }

        private void XapFormControl_ModelFilled(object sender, EventArgs e)
        {
            SetIndicatorControl();
            var opitem = EmsHeadDO.Emsapop.OpEmpItem;
            if (!opitem.Any(t => t.Id_role == CiDictCodeConst.ID_OP_ROLE_ZDYS))
            {
                EmsItemInOp addnew = new EmsItemInOp
                {
                    Id_role = CiDictCodeConst.ID_OP_ROLE_ZDYS,
                    Sd_role = CiDictCodeConst.SD_OP_ROLE_ZDYS,
                    Name_role = "主刀医师"
                };
                opitem.Insert(0, addnew);
            }
            if (!opitem.Any(t => t.Id_role == CiDictCodeConst.ID_OP_ROLE_DYZS))
            {
                EmsItemInOp addnew = new EmsItemInOp
                {
                    Id_role = CiDictCodeConst.ID_OP_ROLE_DYZS,
                    Sd_role = CiDictCodeConst.SD_OP_ROLE_DYZS,
                    Name_role = "第一助手"
                };
                opitem.Insert(1, addnew);
            }
            //人员
            gv_emp.DataTable.DataSource = EmsHeadDO.Emsapop.OpEmpItem;
            //卫材
            gv_mm.DataTable.DataSource = EmsHeadDO.Emsapop.OpMmItem;
            //附加手术
            gv_oper.DataTable.DataSource = EmsHeadDO.Emsapop.OpAppendOpItem;

            XLabelBaseUserRender dt_planRender = xapFormControl.GetUserRender("opitem", "dt_plan") as XLabelBaseUserRender;
            dt_planRender.Focus();
            XCalendarTimerComboBox dt_planTimerComboBox = dt_planRender.UserRender as XCalendarTimerComboBox;

            //dt_planTimerComboBox.MaxDate = DateTime.Now.AddDays(-1);
            dt_planTimerComboBox.MinDate = EmsHeadDO.Emsapop.Dt_creat;

            if (EmsHeadDO.IsNEW || this.CiEmsDTO.Sd_su_or == null || this.CiEmsDTO.Sd_su_or == "0")
            {
                //计划手术时间大于申请时间即可
                //if (EmsHeadDO.Emsapop.Fg_er_sug != null && EmsHeadDO.Emsapop.Fg_er_sug == true)
                //{
                //    setDateTimeLabel("Fg_er_sug");
                //}
                //else if (EmsHeadDO.Emsapop.Fg_zq_sug != null && EmsHeadDO.Emsapop.Fg_zq_sug == true)
                //{
                //    setDateTimeLabel("Fg_zq_sug");
                //}
                //else if (EmsHeadDO.Emsapop.Fg_xq_sug != null && EmsHeadDO.Emsapop.Fg_xq_sug == true)
                //{
                //    setDateTimeLabel("Fg_xq_sug");
                //}
                SetGridPolicy(true);
            }
            else
            {
                indicatorControl.Enabled = false;
                xapFormControl.SetEditPolicy(false);
                SetGridPolicy(false);
            }
            (xapFormControl.GetUserRender("opitem", "name_diag") as XLabelBaseUserRender).Focus();
            //限制开始时间的时间范围，入院日期，最大提前日期
            TimerComboBoxMaxAndMin.GetInstance().setMaxMinTime(xapFormControl, this.Context, "opitem", "dt_plan", EmsHeadDO.PatInfo.Id_ent);
            TimerComboBoxMaxAndMin.GetInstance().setMinTime(xapFormControl, this.Context, "opitem", "dt_plan", EmsHeadDO.Emsapop.Dt_creat);
            if (this.pageCommands != null)
            {
                foreach (PageCommands pageCommands in this.pageCommands)
                {
                    foreach (XapCommand conmmands in pageCommands.Commands)
                    {
                        conmmands.Visible = !IsReadOnly;
                    }
                }
            }
        }        
        
        private void XapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (dataChanging)
                return;

            EmsOpitemDO item = e.Data as EmsOpitemDO;
            if (item == null)
                return;

            dataChanging = true;
            dynamic check = item.getAttrVal(e.PropName);
            if (check is xap.mw.coreitf.d.FBoolean)
            {
                
                if (!check && Fg_sugs.Contains(e.PropName))
                {
                    item.setAttrVal<bool?>(e.PropName, true);
                    dataChanging = false;
                    return;
                }

                switch (e.PropName)
                {
                    case "Fg_er_sug":
                        item.Fg_xq_sug = false;
                        item.Fg_zq_sug = false;
                        //setDateTimeLabel(e.PropName);
                        break;
                    case "Fg_xq_sug":
                        item.Fg_er_sug = false;
                        item.Fg_zq_sug = false;
                       // setDateTimeLabel(e.PropName);
                        break;
                    case "Fg_zq_sug":
                        item.Fg_er_sug = false;
                        item.Fg_xq_sug = false;
                       // setDateTimeLabel(e.PropName);
                        break;
                }
                
            }
            else
            {
                var opitem = EmsHeadDO.Emsapop.OpEmpItem;
                switch (e.PropName)
                {
                    case "Id_emp_operator":
                        var empop = opitem.FirstOrDefault(t => t.Id_role == CiDictCodeConst.ID_OP_ROLE_ZDYS);
                        if (empop != null)
                        {
                            empop.Id_emp_op = item.Id_emp_operator;
                            empop.Name_emp_op = item.Name_emp_operator;
                        }
                        break;
                    case "Id_emp_help1":
                        var help1 = opitem.FirstOrDefault(t => t.Id_role == CiDictCodeConst.ID_OP_ROLE_DYZS);
                        if (help1 != null)
                        {
                            help1.Id_emp_op = item.Id_emp_help1;
                            help1.Name_emp_op = item.Name_emp_help1;
                        }
                        break;
                    case "Name_sugbodycod":
                        this.setSpecialdesText();
                        break;
                    case "Specialreq":
                        this.setSpecialdesText();
                        break;
                    case "Specialinstrument":
                        this.setSpecialdesText();
                        break;
                    case "Dt_plan":
                        EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsapop.Dt_plan;//同步开始时间
                        break;
                }
            }
            dataChanging = false;
        }

        private void setDateTimeLabel(string p)
        {
            XLabelBaseUserRender dt_planRender = xapFormControl.GetUserRender("opitem", "dt_plan") as XLabelBaseUserRender;
            XLabelBaseUserRender dt_creatRender = xapFormControl.GetUserRender("opitem", "dt_creat") as XLabelBaseUserRender;
            XCalendarTimerComboBox dt_planTimerComboBox = dt_planRender.UserRender as XCalendarTimerComboBox;
            XCalendarTimerComboBox dt_creatTimerComboBox = dt_creatRender.UserRender as XCalendarTimerComboBox;
            switch (p)
            {
                case "Fg_er_sug":
                    dt_creatRender.Enabled = false;
                    dt_planRender.Enabled = true;
                    //EmsHeadDO.Emsapop.Dt_creat = DateTime.Now;
                    //EmsHeadDO.Emsapop.Dt_plan = DateTime.Now;
                    dt_planTimerComboBox.MaxDate = DateTime.Now;
                    dt_planTimerComboBox.MinDate = DateTime.Now;
                    break;
                case "Fg_xq_sug":
                    dt_creatRender.Enabled = false;
                    dt_planRender.Enabled = true;
                    //EmsHeadDO.Emsapop.Dt_creat = DateTime.Now;
                    //EmsHeadDO.Emsapop.Dt_plan = DateTime.Now;
                    break;
                case "Fg_zq_sug":
                    dt_creatRender.Enabled = true;
                    dt_planRender.Enabled = true;
                    string d2=DateTime.Now.AddDays(1).ToString("yyyy-MM-dd HH:mm:ss", DateTimeFormatInfo.InvariantInfo);
                    dt_planTimerComboBox.MaxDate = null;
                    dt_planTimerComboBox.MinDate = null;
                    //EmsHeadDO.Emsapop.Dt_creat = DateTime.Now.AddDays(1);
                    //EmsHeadDO.Emsapop.Dt_plan = DateTime.Now.AddDays(1);
                    //DateTime dt = DateTime.Now;
                    //设定最小时间的天数时，是day-1天
                    dt_creatTimerComboBox.MinDate = DateTime.Now;
                    break;
            }
        }

        private void XapFormControl_AllowEditing(object sender, AllowEditingEventArgs e)
        {
            EmsItemInOp item = e.Object as EmsItemInOp;
            if (item == null)
                return;

            string[] readonlyNames = new[] { "Name_role", "Name_emp_op" };
            string[] readonlyProps = new[] { CiDictCodeConst.SD_OP_ROLE_ZDYS, CiDictCodeConst.SD_OP_ROLE_DYZS };

            if (readonlyNames.Contains(e.PropName)&&readonlyProps.Contains(item.Sd_role))
                e.Cancel = true;
        }
        #endregion

        #region 辅助处理函数
        //设置特殊准备的默认值:@体位‘+’@器械‘+’@仪器。
        private void setSpecialdesText()
        {
           //体位
           XLabelBaseUserRender sugbodycod =  this.xapFormControl.GetUserRender("opitem", "name_sugbodycod") as XLabelBaseUserRender;
           XLabelBaseUserRender specialreq = this.xapFormControl.GetUserRender("opitem", "specialreq") as XLabelBaseUserRender;
           XLabelBaseUserRender specialinstrument = this.xapFormControl.GetUserRender("opitem", "specialinstrument") as XLabelBaseUserRender;
           //XLabelBaseUserRender specialdes = this.xapFormControl.GetUserRender("opitem", "specialdes") as XLabelBaseUserRender;
           string str = "";
            if(!string.IsNullOrEmpty(sugbodycod.ValueText))
            {
                str+=sugbodycod.ValueText;
            }
            if(!string.IsNullOrEmpty(specialreq.ValueText))
            {
                if(!str.Equals("")){
                    str+="+"+specialreq.ValueText;
                }else{
                    str+=specialreq.ValueText;
                }
            }
            if(!string.IsNullOrEmpty(specialinstrument.ValueText))
            {
                if(!str.Equals("")){
                    str+="+"+specialinstrument.ValueText;
                }else{
                    str+=specialinstrument.ValueText;
                }
            }
            this.EmsHeadDO.Emsapop.Specialdes = str;

        }

        private void resetLocation()
        {
            int itemCount = EmsHeadDO.Emsapop.OpLabItem.Count;
            if (itemCount == 0)
            {
                indicatorControl.Visible = false;
                var groupBox = xapFormControl.GetUserRender("opitem", "appbtgroupbox") as xap.cli.sdk.render.Items.XGroupBox;
                cof.adjustHeight(this.xapFormControl, "opitem", adjustHeightIds, -preHeight);
            }
            else
            {
                int currentControlHeight = indicatorControl.Height;
                int poor = currentControlHeight - preHeight;
                cof.adjustHeight(this.xapFormControl, "opitem", adjustHeightIds, poor);
            }
        }

        private void LoadIndicatorData()
        {
            if (EmsHeadDO == null || EmsHeadDO.Emsapop == null || EmsHeadDO.Emsapop.OpLabItem == null)
                return;

            EmsHeadDO.Emsapop.OpLabItem.Clear();
            this.qryservice = XapServiceMgr.find<IBdSrvQryService>();

            IEmsregistryMDOCrudService MDORService = XapServiceMgr.find<IEmsregistryMDOCrudService>();

            EmsDO emsDo = MDORService.findById(this.EmsHeadDO.Id_srvof);

            bool? fg_dyncitm_en = emsDo.Fg_dyncitm_crossentp;

            int? eu_dyncitmunit = emsDo.Eu_dyncitmunit;

            int? dyncitmunitct = emsDo.Cnt_dyncitmunit;

            string id_ent = EmsHeadDO.PatInfo.Id_ent;

            string id_pat = EmsHeadDO.PatInfo.Id_pat;

            EmsDynamicParamDTO paramDto = new EmsDynamicParamDTO();
            paramDto.Id_ems = this.EmsHeadDO.Id_srvof;
            paramDto.Fg_dyncitm_en = fg_dyncitm_en;
            paramDto.Eu_dyncitmunit = eu_dyncitmunit;
            paramDto.Id_ent = id_ent;
            paramDto.Id_pat = id_pat;
            paramDto.Dyncitmunitct = dyncitmunitct;

            EmsDynamicIndexDTO[] dtos = qryservice.getEmsDynamicIndexInfos(paramDto);
            //Datatype为编辑类型，0：输入框，其他为：下拉框
            foreach (EmsDynamicIndexDTO dto in dtos)
            {
                EmsHeadDO.Emsapop.OpLabItem.Add(new OrdApSugViewItemDO()
                {
                    Val_rstrptla = dto.Indexval==null?"":dto.Indexval,
                    Val_restrptlab = dto.Enumvalues == null ? "":"|"+ dto.Enumvalues.Replace(',', '|'),
                    Sd_restrptlabtp = dto.Datatype,
                    Name_srv = dto.Showname,
                    Name_unit = dto.Unitname,
                    Id_unit = dto.Id_unit,
                    Id_srv = dto.Id_srv
                });
            }
        }

        private void SetIndicatorControl()
        {
            XBindingList bindingList = new XBindingList();
            bindingList.Add(new XBinding("ValueText", "Val_rstrptla"));
            indicatorControl.TopSpace = 0;
            indicatorControl.LeftSpace = 9;
            indicatorControl.RenderWidth = xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 260 : 236;
            indicatorControl.RenderTitleWidth = 84;
            indicatorControl.RowSpace = xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 10 : 5;
            indicatorControl.ColumnSpace = xap.cli.sdk.common.RelativeUIParam.RELATIVERATIO > xap.cli.sdk.common.RelativeUIParam.TEMPLETECHANGEDRATIO ? 50 : 12;
            indicatorControl.BindingList = bindingList;
            indicatorControl.DataSource = EmsHeadDO.Emsapop.OpLabItem;
        }

        private void SetGridPolicy(bool flag)
        {
            DataPolicy dp = new DataPolicy
            {
                ClassName = "iih.ci.ord.ciordems.d.EmsItemInOp",
                AllowEdit = flag,
                FullEdit = true
            };

            xapFormControl.SetEditPolicy(flag, new [] { dp });
        }

        public void SetTabCommand()
        {
            emp_OrdPageCommand = new ctlEx.OrdPageCommand();
            pageCommands = new PageCommands[]
            {
                //设置手术人员的按钮
                emp_OrdPageCommand.pageCommands(
                    "otheremp",
                    delegate{ EmsHeadDO.Emsapop.OpEmpItem.AddNew(); },
                    delegate
                    {
                        if (gv_emp.GetFocusedRow() != null)
                            EmsHeadDO.Emsapop.OpEmpItem.Delete(gv_emp.GetFocusedRow().RowDataSource as EmsItemInOp, false);
                    },true),
                //设置手术卫材的按钮
                new ctlEx.OrdPageCommand().pageCommands(
                    "eisai",
                    delegate
                    {
                        EmsHeadDO.Emsapop.OpMmItem.Add(new EmsItemInOp { Quan_cur = 1});
                    },
                    delegate
                    {
                        if (gv_mm.GetFocusedRow() != null)
                            EmsHeadDO.Emsapop.OpMmItem.Delete(gv_mm.GetFocusedRow().RowDataSource as EmsItemInOp, false);
                    },true),
                //设置附加手术的按钮
                new ctlEx.OrdPageCommand().pageCommands(
                    "addsug",
                    delegate{ EmsHeadDO.Emsapop.OpAppendOpItem.AddNew(); },
                    delegate{
                        if (gv_oper.GetFocusedRow() != null)
                            EmsHeadDO.Emsapop.OpAppendOpItem.Delete(gv_oper.GetFocusedRow().RowDataSource as EmsItemInOp, false);
                    },true)
            };
            xapFormControl.SetupCommands(pageCommands);
        }
        #endregion

    }
}
