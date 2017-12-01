using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordcons.dialog;
using iih.ci.ord.ciordcons.viewmodel;
using iih.ci.ord.dto.patdetaildto.d;
using xap.cli.context.events;
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciordcons.view
{
    public partial class ConsPatDetailCardView : XapFormControl
    {
        public ConsCardViewModel model;
        public UserRender btnEmr;
        private PatDetailDTO patDetail;
        public string funid;
         public ConsPatDetailCardView()
        {
            InitializeComponent();
            this.Load += new EventHandler(ConsCardView_Load);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            this.xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            //this.model = viewModel;
        }

        public void ClearForm()
        {
            this.xapFormControl.ClearFormData();
        }

        

       
        #region 父类继承区域

        protected override void OnLoadData()
        {
            //model = new OrTplCardViewModel(srvortpldo);
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();

            if (model != null && model.ConsDto!=null)
            {
                patDetail = this.model.GetConsPat(model.ConsDto.Id_en);
                if (patDetail==null)return;
                file.ViewModel = patDetail;
            }
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConsPatDetailCardView;// "20160607084827495WUV";
            file.FormStyle = FormStyle.Card;
            this.xapFormControl.ViewFile = file;
            this.xapFormControl.SetEditPolicy(false);
           
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
        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            if (Created)
            {
                this.xapFormControl.SetEditPolicy(true);
                string[] controls = { "id_ent","id_pat", "name_didef_dis", "sex_pat", "name_dep_phy", 
                                     "pat_age", "name_dep_nur", "name_nation", "name_bed",
                                      "name_idcardtp", "name_emp_phy", "name_idcard", "name_hp",
                                       "tel", "name_patcret", "addr_pat" };

                
                (this.xapFormControl.GetUserRender("patmsg", "id_ent") as XLabelBaseUserRender).ValueText = this.model.ConsDto.Code_en;
                this.ConsApContrlsEnable(controls, false);
            }
            
        }
        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            
            this.btnEmr = this.xapFormControl.GetUserRender("patmsg", "btnEmr");
            this.btnEmr.MouseClick += new MouseEventHandler(btnEmr_MouseClick);

        }

        void btnEmr_MouseClick(object sender, MouseEventArgs e)
        {
            //if (patDetail == null || funid == null || funid=="") return;
            //Dictionary<string, object> param = new Dictionary<string, object>();
            //param.Add("Code_entp", patDetail.Code_entp);
            //param.Add("Id_ent", patDetail.Id_ent);
            //XapEvents.OpenFuncEvent(this, new OpenFuncEventArgs(funid, param));

            //包装病历需要的数据
            Dictionary<string, object> treearg = new Dictionary<string, object>();
            if (patDetail != null && model.ConsDto!=null)
            {
                treearg.Add("IdEnt", this.model.ConsDto.Id_en);
                treearg.Add("IdPat", patDetail.Id_pat);
                treearg.Add("Entp", patDetail.Code_entp);//00门诊10住院
            }

            ConsMrCommonDialog mrCommonDialog = new ConsMrCommonDialog(treearg);
            mrCommonDialog.ShowDialog();
        }

        private void ConsApContrlsEnable(string[] keys, bool enable)
        {
            foreach (string key in keys)
            {
                (this.xapFormControl.GetUserRender("patmsg", key) as XLabelBaseUserRender).Enabled = enable;
            }
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            //string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            //switch (uiEvent)
            //{
            //    case UIEvent.SAVE:
            //        this.OnSave();
            //        break;
            //    default:
            //        break;
            //}
        }
        #endregion
    }
}
