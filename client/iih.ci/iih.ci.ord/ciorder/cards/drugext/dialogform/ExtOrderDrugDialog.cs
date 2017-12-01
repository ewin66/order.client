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
using iih.en.pv.dto.d;
using xap.cli.sdk.controls.DataView.Model;

namespace iih.bd.srv.srvortpl.srvortpl.view
{
    public partial class ExtOrderDrugDialog : XapBaseControl
    {
        #region 变量定义区

        private EmsUIDTO CiHeadDo;

        private EmsOrDrug drug;

        private ExtOrderDrugDialogModel viewModel;

        public string flag = "0";

        public string lincStr = "";

        private string[] Ids2 = new string[] { "linc", "lincText", "fg_treat", "name_mp_dep","name_dep_wh", "note_or" };

        private string[] Ids3 = new string[] { "name_mp_dep", "name_dep_wh", "note_or" };

        private LogicEx cof = LogicEx.GetInstance(); //new LogicEx();

        Ent4BannerDTO PatInfo = null;
        #endregion


        public ExtOrderDrugDialog(EmsUIDTO CiHeadDo,EmsOrDrug drug)
        {
            InitializeComponent();
            this.CiHeadDo = CiHeadDo;
            this.PatInfo = this.CiHeadDo.PatInfo;
            this.drug = drug;
            xapFormControl.Load += xapFormControl_Load;
            xapFormControl.RefFilter += OnRefFilter;
            xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
        }
        public ExtOrderDrugDialog(Ent4BannerDTO bannerInfo, EmsOrDrug drug)
        {
            InitializeComponent();
            this.CiHeadDo = null;
            this.PatInfo = bannerInfo;
            this.drug = drug;
            xapFormControl.Load += xapFormControl_Load;
            xapFormControl.RefFilter += OnRefFilter;
            xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile
            {
                FormId = "20170106110035314000",
                FormStyle = FormStyle.Card,
                ViewModel = this.drug
            };
            xapFormControl.ViewFile = file;
        }
       
        #region 内部事件区
        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            //初始化数据
            this.initData(this.PatInfo!=null?this.PatInfo.Id_hp:null);
            this.reJustSize(flag);
            this.xapFormControl.Refresh();
            this.xapFormControl.SetEditPolicy(true);
        }
        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
           
        }
        #endregion

        #region 辅助处理函数
        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_mp_dep"))
            {
                if (this.drug.Str_mp_dep_ids != null && this.drug.Str_mp_dep_ids != "")
                    e.WherePart = string.Format(" id_dep in({0})", this.drug.Str_mp_dep_ids);
            }
            else if (e.BindingFieldName.Equals("Name_dep_wh")) {
                if (this.drug.Str_wh_dep_ids != null && this.drug.Str_wh_dep_ids != "")
                    e.WherePart = string.Format(" id_dep in({0})", this.drug.Str_wh_dep_ids);
            }
        }
        private void initData(string id_hp = null)
        {
            HPSrvorcaDO hp = viewModel.getHpSrvOrCaDO(id_hp, this.drug.Id_srv);
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
            bool Fg_anti = this.drug.Fg_anti == null ? false : this.drug.Fg_anti.Value;
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
                //(this.xapFormControl.GetUserRender("fg_propc", "propc") as XLabel).Visible = false;
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

        public String HasErroMsgs()
        {
            if (xapFormControl.HasErrors)
            {
                return String.IsNullOrEmpty(xapFormControl.ErrorAlertText) ? "界面上存在错误，请修改正确" : xapFormControl.ErrorAlertText;
            }
            return null;
        }

        public EmsOrDrug GetFormDataSource()
        {
            return this.drug;
        }

        
    }
}
