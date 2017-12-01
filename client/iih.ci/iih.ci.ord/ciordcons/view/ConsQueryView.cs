using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.ci.ord.ciordcons.viewmodel;
using xap.cli.context;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciordcons.view
{
    public partial class ConsQueryView : XapFormControl
    {

        //private ConsGridViewModel model;
        private XRadioboxGroup group;
        private string type;

        public ConsQueryView()
        {
            InitializeComponent();
            this.Load += new EventHandler(ConsQueryView_Load);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
        }

        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            group = this.xapFormControl.GetUserRender("query", "group") as XRadioboxGroup;
            //XLabelBaseUserRender start = xapFormControl.GetUserRender("query", "response") as XLabelBaseUserRender;
            //XLabelBaseUserRender end = xapFormControl.GetUserRender("query", "responsed") as XLabelBaseUserRender;
            
            UserRender btnSearch = xapFormControl.GetUserRender("query", "btn_query");
            btnSearch.MouseClick += new MouseEventHandler(btnSearch_MouseClick);
            if (type != null && type != CiDictCodeConst.CONS_RESPONSE && group != null)
            {
                foreach (XRadiobox box in group.UserRenderList)
                {
                    if (box.Text == "待应答")
                    {
                        box.Text = "待审批";
                    }
                    if (box.Text == "已应答")
                    {
                        box.Text = "已审批";
                    }
                }

            }
        }

       
        #region 父类继承区域

        protected override void OnLoadData()
        {
            //if (model == null)
            //    model = new ConsGridViewModel();
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();

            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConsQueryView;// "20160607033525518KO9";
            file.FormStyle = FormStyle.Card;
            this.xapFormControl.ViewFile = file;
            this.xapFormControl.SetEditPolicy(true);
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
        void ConsQueryView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        void btnSearch_MouseClick(object sender, MouseEventArgs e)
        {
            XLabelBaseUserRender start = xapFormControl.GetUserRender("query", "dt_start") as XLabelBaseUserRender;
            XLabelBaseUserRender end = xapFormControl.GetUserRender("query", "dt_end ") as XLabelBaseUserRender;
            string strWhere = "";
            if (start!=null && start.ValueText != "" )
                strWhere += string.Format("AND t2.dt_ap>='{0} {1}' ", start.ValueText,  "00:00:00");//日期
            if ( end != null  && end.ValueText != "")
                strWhere += string.Format("AND t2.dt_ap<='{0} {1}'",  end.ValueText, "23:59:59");//日期
            if(type==null)return;
            switch (type)
            {
                case CiDictCodeConst.CONS_RESPONSE://会诊应答
                    strWhere += string.Format(" AND  t1.fg_response='{0}'", group.ValueText == "已应答" ? "Y" : "N");//应答状态
                    strWhere += string.Format(" AND  t2.sd_su_cons in ({0})", group.ValueText == "已应答" ? "'6','5'" : "'4','5'");//应答状态
                    strWhere += string.Format(" AND  t1.id_dep = '{0}'", UserManager.getInstance().CurrentDept.Id_dep);//应答状态
                    break;
                case CiDictCodeConst.CONS_DEPREVIEW://科室审批
                    strWhere += string.Format(" AND  t2.sd_su_cons{0} and t3.fg_sign='Y' and t3.fg_canc='N'", group.ValueText == "已审批" ? "<> 0" : "='0'");
                    strWhere += string.Format(" AND  t3.id_dep_or = '{0}'", UserManager.getInstance().CurrentDept.Id_dep);

                    break;
                case CiDictCodeConst.CONS_MADREVIEW://医务部审批
                    strWhere += string.Format(" AND  t2.sd_su_cons{0} and t3.fg_sign='Y' and t3.fg_canc='N'", group.ValueText == "已审批" ? "<> all (0,1,2)" : "='2'");
                    break;
                default:
                    break;
            }

            //model.GetConList(UserManager.getInstance().CurrentDept.Id_dep, strWhere);
            this.FireSelected(strWhere);
            this.FireEvent();

        }

        void FireEvent()
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, "Query");
            base.FireEventSent(this, args);
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
                    Dictionary<string, object>dic=eventArgs.Data["Data"] as Dictionary<string, object>;
                    string str = dic["BeanConfigFilePath"].ToString();
                    string[] strs = str.Split('\\');
                    string xml = strs[strs.Length-1];
                    if (xml == CiDictCodeTypeConst.CICONS_RESPONSE)//应答
                    {
                        this.type = CiDictCodeConst.CONS_RESPONSE;
                    }
                    if (xml == CiDictCodeTypeConst.CICONS_REVIEW_DEP)//科室审批
                    {
                        this.type = CiDictCodeConst.CONS_DEPREVIEW;
                    }
                    if (xml == CiDictCodeTypeConst.CICONS_REVIEW_ADM)//医务审批
                    {
                        this.type = CiDictCodeConst.CONS_MADREVIEW;
                    }
                    
                    this.LoadData();   
                    break;
                case "AgreeSuccess":
                    this.btnSearch_MouseClick(null ,null);
                    break;
                default:
                    break;
            }
        }
        }
        #endregion
    }
