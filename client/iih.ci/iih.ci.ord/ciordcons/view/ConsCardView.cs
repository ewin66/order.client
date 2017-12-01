using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordcons.viewmodel;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.dto.consdto.d;
using xap.cli.context;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.control.refcontrol.events;
using xap.rui.engine;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciordcons.view
{
    public partial class ConsCardView : XapFormControl
    {
        private ConsPatDetailCardView patvView;
        private ConsCardViewModel model;
        private XapFormGridControl gv_eview,gv_invite;
        private UserRender btnEdit, btSave, btnCancle;
        private string  id_ent ;
        private string type;
        private string funId;
        private bool flag=false;

        public ConsCardView()
        {
            InitializeComponent();
            this.xapFormControl.Load += new EventHandler(ConsCardView_Load);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            this.xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            this.xapFormControl.RefFilter += new EventHandler<RefActivatingEventArgs>(OnRefFilter);
            xapFormControl.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl_DataChanged);
            if (model != null) return;
            model = new ConsCardViewModel();
        }
        

       
        #region 父类继承区域

        protected override void OnLoadData()
        {
            if(model!=null)return;
            model = new ConsCardViewModel();
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();

            if (model != null && this.model.xapAggDo != null)
            {
               
                file.ViewModel = this.model.xapAggDo;
            }
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConsCardView;// "20160623081634990LYX";
            file.FormStyle = FormStyle.Card;
            this.xapFormControl.ViewFile = file;
            
        }
        #endregion
        #region 命令定义区域

        //[XapCommand(Name = "Save")]
        //public void OnSave()
        //{
        //    if (this.xapFormControl.HasErrors.Equals(false) || this.xapFormControl2.HasErrors.Equals(false))
        //        this.xapFormControl.SaveForm();
        //    this.model.ortpldo.Fg_active = true;
        //    this.xapFormControl2.SaveForm();
        //    this.model.OnSave();
        //    this.SetStatusMsg("保存成功！");
        //}
        //[XapCommand(Name = "Cancel")]
        //public void OnCancel()
        //{
        //}

        #endregion
        #region 内部事件区域
        void ConsCardView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            

            XTabPage patPage = this.xapFormControl.GetTabPageByTabCode("patmsg");
            if (patPage != null)
            {
                //patPage.PageControl.Visible = false;
                this.patvView= new ConsPatDetailCardView() { Dock = DockStyle.Fill };
                if (!this.patvView.Created)
                    this.patvView.CreateControl();
                patPage.PageControl = this.patvView;
                if(this.id_ent!=null){
                    this.patvView.model = this.model;
                    this.patvView.LoadData();
                }

            }
            this.gv_eview = this.xapFormControl.GetGridView("review");
            this.gv_invite = this.xapFormControl.GetGridView("consorg");
            this.btnEdit = this.xapFormControl.GetUserRender("consap", "btn_edit");
            this.btSave = this.xapFormControl.GetUserRender("consap", "btn_save");
            this.btnCancle = this.xapFormControl.GetUserRender("consap", "btn_cancle");
            this.btnEdit.Visible = false;
            this.btSave.Visible = false;
            this.btnCancle.Visible = false;
            this.btnEdit.MouseClick += new MouseEventHandler(button_MouseClick);
            this.btSave.MouseClick += new MouseEventHandler(button_MouseClick);
            this.btnCancle.MouseClick += new MouseEventHandler(button_MouseClick);
        }

        void button_MouseClick(object sender, MouseEventArgs e)
        {
            if (btnEdit.Contains(e.Location))
            {
                //string[] str = { "dt_plan", "place" };
                //this.ConsApContrlsEnable(str, true);
                SetPolicy(false);
                this.btnEdit.Enabled = false;
                this.btSave.Enabled = true;
                this.btnCancle.Enabled = true;
                string[] str = {  "fg_urgent", "des_psp", "des_emr" };
                this.ConsApContrlsEnable(str, false);
                this.FireEvent(UIEvent.EDIT);            
            }
            if (btSave.Contains(e.Location))
            {
                if (!this.xapFormControl.HasErrors)
                {
                    SetPolicy(false);
                    this.btnEdit.Enabled = true;
                    this.btSave.Enabled = false;
                    this.btnCancle.Enabled = false;
                    this.xapFormControl.SaveForm();
                    this.model.SaveEdit();
                    string[] str = {"dt_plan", "fg_urgent", "des_psp", "des_emr", "place"};
                    this.ConsApContrlsEnable(str, false);
                    this.FireEvent(UIEvent.SAVE_SUCCESS);
                    this.SetStatusMsg("保存成功！");
                }
                else
                {
                    this.xapFormControl.ShowInfo("请修正当前页面错误！");
                }
            }
            if (btnCancle.Contains(e.Location))
            {
                SetPolicy(false);
                this.btnEdit.Enabled = true;
                this.btSave.Enabled = false;
                this.btnCancle.Enabled = false;
                string[] str = { "dt_plan", "fg_urgent", "des_psp", "des_emr", "place" };
                this.ConsApContrlsEnable(str, false);
                this.FireEvent(UIEvent.CANCEL);    
            }
        }
        void FireEvent(string eventstr)
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, eventstr);
            base.FireEventSent(this, args);
        }
        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {

            this.SetPolicy(false);
            if (this.type == CiDictCodeConst.CONS_MADREVIEW )
            {
                this.flag =true;
                this.btnEdit.Visible = true;
                this.btSave.Visible = true;
                this.btnCancle.Visible = true;
                if (this.model.ConsDto==null)return;
                if (this.model.ConsDto.Sd_su_cons == CiDictCodeConst.SD_CIDI_DYWSP)
                {
                    this.btnEdit.Enabled = true;
                    this.btSave.Enabled = false;
                    this.btnCancle.Enabled = false;
                }
                else
                {
                    this.btnEdit.Enabled = false;
                    this.btSave.Enabled = false;
                    this.btnCancle.Enabled = false;
                }
                string[] str = { "dt_plan", "fg_urgent", "des_psp", "des_emr", "place" };
                this.ConsApContrlsEnable(str, false);
            } else if (this.type == CiDictCodeConst.CONS_DEPREVIEW)
            {
                this.flag = true;
                this.btnEdit.Visible = true;
                this.btSave.Visible = true;
                this.btnCancle.Visible = true;
                if (this.model.ConsDto == null) return;
                if (this.model.ConsDto.Sd_su_cons == CiDictCodeConst.SD_CIDI_DKSSP)
                {
                    this.btnEdit.Enabled = true;
                    this.btSave.Enabled = false;
                    this.btnCancle.Enabled = false;
                }
                else
                {
                    this.btnEdit.Enabled = false;
                    this.btSave.Enabled = false;
                    this.btnCancle.Enabled = false;
                }
                string[] str = { "dt_plan", "fg_urgent", "des_psp", "des_emr", "place" };
                this.ConsApContrlsEnable(str, false);
            }
            else
            {
                this.flag = false;
                string[] str = { "dt_plan", "fg_urgent", "des_psp", "des_emr", "place" };
                this.ConsApContrlsEnable(str, false);
                this.btnEdit.Visible = false;
                this.btSave.Visible = false;
                this.btnCancle.Visible = false;
            }
            //this.gv_invite.Enabled = this.flag;
            //限制开始时间的时间范围，入院日期，最大提前日期
            if (this.id_ent != null)
            {
                TimerComboBoxMaxAndMin.GetInstance()
                    .setMaxMinTime(xapFormControl, this.Context, "cons", "dt_plan",
                        this.id_ent);
            }
        }

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if ((e.Object is OrdConsDTO))
            {
                this.model.ConsDto = e.Object as OrdConsDTO;
                this.patvView.model = this.model;
                if (this.patvView.Created)
                {
                    this.patvView.LoadData();
                    this.patvView.funid = this.funId;
                }
                this.model.GetConsApData(this.model.ConsDto.Id_apcons, this.type);
                this.LoadData();
                this.SetPolicy(false);
                //限制开始时间的时间范围，入院日期，最大提前日期
                if (this.model.ConsDto.Id_en != null)
                {
                    TimerComboBoxMaxAndMin.GetInstance()
                        .setMaxMinTime(xapFormControl, this.Context, "consap", "dt_plan",
                            this.model.ConsDto.Id_en);
                }
             }
        }

        private void ConsApContrlsEnable(string[] keys,bool enable)
        {
            foreach (string key in keys)
            {
                (this.xapFormControl.GetUserRender("consap", key) as XLabelBaseUserRender).Enabled = enable;
            }
        }

        public void SetPolicy(bool enable)
        {
            DataPolicy ploicy = new DataPolicy();
            ploicy.FullEdit = enable;
            ploicy.AllowEdit = enable;
            ploicy.ClassName = "iih.ci.ord.cior.d.CiordInviteConsDO";
            this.xapFormControl.SetEditPolicy(true, new DataPolicy[] { ploicy });
        }

        protected override void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_emp"))
            {
                string str = "";

                string id_dep = this.gv_invite.GetFocusedRow<CiordInviteConsDO>().Id_dep;
                if (id_dep != null)
                {
                    str += " id_dep='" + id_dep + "'";

                }
                if (str == "") return;
                e.WherePart = str;
            }
            if (e.BindingFieldName.Equals("Name_dep"))
            {
                string str = "";
                str += string.Format("id_dep <> '{0}' and  SD_DEPTTP='01'", UserManager.getInstance().CurrentDept.Id_dep);
                if (str == "") return;
                e.WherePart = str;
            }
           
        }

        void xapFormControl_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (e.PropName == "Name_dep" && e.Data is CiordInviteConsDO)
            {
                CiordInviteConsDO item = e.Data as CiordInviteConsDO;
                item.Id_emp= null;
                item.Name_emp= null;

            }
            if (e.PropName == "Name_emp" && e.Data is CiordInviteConsDO)
            {
                CiordInviteConsDO item = e.Data as CiordInviteConsDO;
                item.Id_emp_title = null;
                item.Name_emp_title = null;
            }
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            //string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    Dictionary<string, object> dic=eventArgs.Data["Data"] as Dictionary<string, object>;
                    string str = dic["BeanConfigFilePath"].ToString();
                    string[] strs = str.Split('\\');
                    string xml = strs[strs.Length-1];
                    switch (xml)
                    {
                        case CiDictCodeTypeConst.CICONS_RESPONSE:
                            this.type = CiDictCodeConst.CONS_RESPONSE;
                            this.funId = CiDictCodeTypeConst.CICONS_RESPONSE_ID;
                            break;
                        case CiDictCodeTypeConst.CICONS_REVIEW_ADM:
                            this.type = CiDictCodeConst.CONS_MADREVIEW;
                            this.funId = CiDictCodeTypeConst.CICONS_REVIEW_ADM_ID;
                            break;
                        case CiDictCodeTypeConst.CICONS_REVIEW_DEP:
                            this.type = CiDictCodeConst.CONS_DEPREVIEW;
                            this.funId = CiDictCodeTypeConst.CICONS_REVIEW_DEP_ID;
                            break;
                        case CiDictCodeTypeConst.CICONS_RESPONSE_DIAG:
                            this.funId = CiDictCodeTypeConst.CICONS_RESPONSE_DIAG_ID;
                            this.id_ent = dic["Id_ent"].ToString();
                            this.model.GetConsByIdent(UserManager.getInstance().CurrentDept.Id_dep, id_ent);
                            if (this.patvView != null && this.patvView.Created)
                            {
                                this.patvView.model = this.model;
                                this.patvView.LoadData();
                            }
                        
                            //this.LoadData();
                            break;
                        default:
                            break;
                    }
                    break;
                case "AgreeSuccess":
                    this.model.ConsDto = null;
                    //if (patvView.ViewFile!=null)
                    this.patvView.ClearForm();
                    this.xapFormControl.ClearFormData();
                    this.OnLoadData();
                    break;
                case "Query":
                    this.patvView.ClearForm();
                    this.patvView.btnEmr.Enabled = false;
                    this.xapFormControl.ClearFormData();
                    this.btnEdit.Enabled = false;
                    this.btSave.Enabled = false;
                    this.btnCancle.Enabled = false;
                    string[] str1 = { "dt_plan", "fg_urgent", "des_psp", "des_emr", "place" };
                    this.ConsApContrlsEnable(str1, false);
                    break;
                default:
                    break;
            }
        }
        #endregion
    }
}
