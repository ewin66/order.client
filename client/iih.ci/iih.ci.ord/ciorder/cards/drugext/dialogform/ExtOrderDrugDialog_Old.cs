using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.bd.srv.ortpl.d;
using xap.cli.sdk.render;
using iih.bd.bc.udi;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.inputmethod;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel;
using iih.bd.pp.hp.d;
using iih.ci.ord.ciorder.utils;
using xap.cli.sdk.render.Items;
using iih.bd.fc.orwf.d;
using xap.cli.context;
using xap.cli.sdk.form;
using xap.rui.control.refcontrol.events;
using iih.bd.fc.wf.d;
using iih.bd.pp.hpsrvorca.d;
using iih.ci.ord.emsdi.d;
using iih.ci.ord.i;

namespace iih.bd.srv.srvortpl.srvortpl.view
{
    public partial class ExtOrderDrugDialog_Old : XapBaseControl
    {
        #region 变量定义区
        public EmsDrugItemDO Emsdrugs = new EmsDrugItemDO();

        private EmsUIDTO CiHeadDo;

        private EmsOrDrug drug;

        private ExtOrderDrugDialogModel viewModel;

        public string flag = "0";

        public string lincStr = "";

        private string[] Ids2 = new string[] { "linc", "lincText", "fg_treat", "name_dep", "note_or" };

        private string[] Ids3 = new string[] { "name_dep", "note_or" };

        private LogicEx cof = LogicEx.GetInstance(); //new LogicEx();
        #endregion

        public ExtOrderDrugDialog_Old(EmsUIDTO CiHeadDo, EmsOrDrug drug)
        {
            InitializeComponent();
            this.CiHeadDo = CiHeadDo;
            this.drug = drug;
            xapFormControl.Load += xapFormControl_Load;
            xapFormControl.RefFilter += OnRefFilter;
            xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
        }

        protected override void OnFillData()
        {
            Emsdrugs.Note_or = this.drug.Note_or;
            Emsdrugs.Id_dep = this.drug.Id_mp_dep;
            Emsdrugs.Name_dep = this.drug.Name_mp_dep;
            Emsdrugs.Fg_treat = this.drug.Fg_treat;
            Emsdrugs.Fg_propc = this.drug.Fg_propc;
            FormFile file = new FormFile
            {
                FormId = "20160521023549155M1N",
                FormStyle = FormStyle.Card,
                ViewModel = Emsdrugs
            };
            xapFormControl.ViewFile = file;
        }
       
        #region 内部事件区
        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            //初始化数据
            this.initData();
            this.reJustSize(flag);
            this.xapFormControl.Refresh();
            this.xapFormControl.SetEditPolicy(true);
        }
        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(Emsdrugs.Name_dep))
            {

                OrWfExDeptParamDTO param = new OrWfExDeptParamDTO();

                param.Eu_wftp = Convert.ToInt32(EnumFlow.NULL);            //    0执行与物资   1执行科室 2物资流向
                param.Code_entp = this.CiHeadDo.PatInfo.Code_entp;                             //     就诊类型

                param.Id_dept_ns = this.CiHeadDo.PatInfo.Id_dep_nur; //就诊护理病区
                param.Id_dept_or = UserManager.getInstance().CurrentDept.Id_dep;//开单科室
                param.Id_dept_en = this.CiHeadDo.PatInfo.Id_dep_phy; //id_dept_en;//就诊科室

                //dto.Recurstr = "";   //长临需要的   不知道 就为空


                param.Id_srv = drug.Id_srv;    //服务
                param.Sd_srvtp = drug.Sd_srvtp; //服务类型sd
                param.Id_srvca = drug.Id_srvca;//服务分类
                //dto.Innercode_srvca = "";//服务分类内码
                param.Id_mm = drug.Id_mm;          // 服务选取的关联物品
                param.Id_usage = this.CiHeadDo.Emsdrugs.Id_route;   //用法
                OrWfDeptInfoDTO deps = new ICiOrdQryServiceImpl().getExeDepts4CiOrSrvN(param);
                if (deps != null && deps.Orwfexedepts != null)
                {
                    foreach (OrWfExDeptDTO dep in deps.Orwfexedepts)
                    {
                        Emsdrugs.Id_dep = dep.Id_dept;
                        Emsdrugs.Name_dep = dep.Name_dept;
                        Emsdrugs.Str_mp_dep_ids += ",'" + dep.Id_dept + "'";
                    }

                }
            }
        }
        #endregion

        #region 辅助处理函数
        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {    
            if (e.BindingFieldName.Equals("Name_dep"))
            {
                if (CiHeadDo.Emsdrugs.Str_mp_dep_ids != null && CiHeadDo.Emsdrugs.Str_mp_dep_ids != "")
                    e.WherePart = string.Format(" id_dep in({0})", CiHeadDo.Emsdrugs.Str_mp_dep_ids);
            }
        }
        private void initData()
        {
            HPSrvorcaDO hp = viewModel.getHpSrvOrCaDO(this.CiHeadDo.PatInfo.Id_hp, this.CiHeadDo.Emsdrugs.Id_srv);
            string sdhp = "";
            string des = "";
            string str = "";
            if (hp != null)
            {
                sdhp = hp.Sd_hpsrvtp;
                des = hp.Des;
                str = "";
                if (!string.IsNullOrEmpty(sdhp))
                {
                    str += hp.Hpsrvtp_name;
                }
                if (!string.IsNullOrEmpty(des))
                {
                    if (string.IsNullOrEmpty(str))
                    {
                        str += des;
                    }
                    else
                    {
                        str += ",\r\n" + des;
                    }
                }
                lincStr = str;
            }
            bool Fg_anti = this.drug.Fg_anti.Value;
            flag = "0";
            //抗生素
            if (Fg_anti)
            {
                //是抗生素的药
                if (hp != null)
                {
                    flag = "0";
                    //存在医保计划,拼接字符串
                    cof.getControlByName(this.xapFormControl, "fg_propc", "lincText").ValueText=str;
                }
                else
                {
                    flag = "1";
                    (this.xapFormControl.GetUserRender( "fg_propc", "linc") as XLabel).Visible = false;
                    cof.getControlByName(this.xapFormControl, "fg_propc", "lincText").Visible = false;
                    cof.getControlByName(this.xapFormControl, "fg_propc", "fg_treat").Visible = false;
                }
            }
            else
            {
                (this.xapFormControl.GetUserRender("fg_propc", "propc") as XLabel).Visible = false;
                cof.getControlByName(this.xapFormControl, "fg_propc", "fg_propc").Visible = false;
                if (hp != null)
                {
                    flag = "2";
                    cof.getControlByName(this.xapFormControl, "fg_propc", "lincText").ValueText = str;
                }
                else
                {
                    flag = "3";
                    (this.xapFormControl.GetUserRender("fg_propc", "linc") as XLabel).Visible = false;
                    cof.getControlByName(this.xapFormControl, "fg_propc", "lincText").Visible = false;
                    cof.getControlByName(this.xapFormControl, "fg_propc", "fg_treat").Visible = false;
                }
            }
        }

        private void reJustSize(string sd)
        {
            switch (sd)
            {
                case "1":
                    cof.adjustHeight(this.xapFormControl, "fg_propc",Ids3,-94);
                    break;
                case "2":
                    cof.adjustHeight(this.xapFormControl, "fg_propc", Ids2, -25);
                    break;
                case "3":
                    cof.adjustHeight(this.xapFormControl, "fg_propc", Ids3, -121);
                    break;

            }
        }
        #endregion

        private void xapFormControl_Load(object sender, EventArgs e)
        {
            viewModel = new ExtOrderDrugDialogModel();
            OnFillData();
        }
    }
}
