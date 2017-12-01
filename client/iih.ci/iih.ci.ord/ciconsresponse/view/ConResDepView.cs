using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.ciconsresponse.viewmodel;
using xap.cli.sdk.render;
using xap.rui.control.forms.control;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.extentions;
using xap.rui.control.forms.model;
using xap.rui.engine;
using xap.rui.control.refcontrol.events;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciconsresponse.view
{
    public partial class ConResDepView : XapBaseControl
    {
        #region 构造函数区域
        public ConResDepView()
        {

            InitializeComponent();
            xapFormControl1.Load += new EventHandler(xapFormControl1_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            xapFormControl1.AfterFocused += new EventHandler<xap.rui.control.forms.model.DataFocusedEventArgs>(xapFormControl1_AfterFocused);
            this.xapFormControl1.RefResult += this.OnRefResult;
        }


       //频次
        protected override void OnRefResult(object sender, RefResultEventArgs e)
        {
             
        }
 


        #endregion


        #region 变量定义区域
 
        string strWhere = "";
        EmsConsItemDO cons;
        XapFormGridControl gv_consItem,gv_invite;//会诊项目，受邀对象
        ConResDepViewModel model = new ConResDepViewModel();
        private XRadioboxGroup group;
        #endregion


        #region 公开属性区域

        #endregion

        #region 命令定义区域


        #endregion

        #region 事件发送区域


        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConResDepView;// "20151116111338082SE7";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = model.cons;
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);
 

        }



        #endregion

        #region 内部事件区域

        void xapFormControl1_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            SetGridPolicy(true);
            this.xapFormControl1.SetTopPanelHeight(330);
            //this.xapFormControl1.SetToilHeight(50);

            UserRender btnSearch = xapFormControl1.GetUserRender("consres", "query");//保存
            btnSearch.MouseClick += new MouseEventHandler(btnSearch_MouseClick);
            //UserRender btn = xapFormControl1.GetUserRender("btn", "btnSave");//保存
            //btn.MouseClick += new MouseEventHandler(btnSave_MouseClick);
            gv_consItem = xapFormControl1.GetGridView("conslist");
            gv_consItem.ReadOnly = true;

            gv_invite = xapFormControl1.GetGridView("consitem");
            gv_invite.ReadOnly = false;
            gv_invite.DataTable.ReadOnly = false;
            gv_invite.DataTable.Columns["Name_org"].ReadOnly = true;
            gv_invite.DataTable.Columns["Name_dep_emp"].ReadOnly = true;
            gv_invite.DataTable.Columns["Name_emp_title"].ReadOnly = true;
            gv_invite.DataTable.Columns["Dt_response"].ReadOnly = true;

            group = this.xapFormControl1.GetUserRender("consres", "resgroup") as XRadioboxGroup;
            UserRender contp = xapFormControl1.GetUserRender("consres", "name_constp");//保存
            contp.Enabled = true;

            this.xapFormControl1.ShowTabPage("consitem", true);
        }

        void btnSearch_MouseClick(object sender, MouseEventArgs e)
        {
            XLabelBaseUserRender start = xapFormControl1.GetUserRender("consres", "start") as XLabelBaseUserRender;//保存
            XLabelBaseUserRender end = xapFormControl1.GetUserRender("consres", "end") as XLabelBaseUserRender;//保存
            XLabelBaseUserRender contp = xapFormControl1.GetUserRender("consres", "name_constp") as XLabelBaseUserRender;//保存

            strWhere = "";
            if(start.ValueText!=""&& end.ValueText!="")
            strWhere += string.Format("AND t2.dt_ap>='{0}' and t2.dt_ap<'{1}'",start.ValueText,end.ValueText);//日期
            if (!string.IsNullOrEmpty(model.cons.Id_constp))
                strWhere += string.Format(" AND t2.id_constp='{0}'", model.cons.Id_constp);//会诊类型
            //strWhere += string.Format(" AND  t1.fg_response='{0}'", group.ValueText == "已应答" ? "Y" : "N");//应答状态
            strWhere += string.Format(" AND  t2.sd_su_cons='{0}'", group.ValueText == "已应答" ? "2" : "1");//应答状态
            
            GetConsItem();


        }
        void xapFormControl1_AfterFocused(object sender, xap.rui.control.forms.model.DataFocusedEventArgs e)
        {
            if (e.Data is EmsItemInCons) return;
            cons = this.xapFormControl1.GetFocused<EmsConsItemDO>("conslist");
            //model.cons = cons;//直接赋对象 不行
            model.cons.Str_urgent = cons.Str_urgent;
            System.Reflection.PropertyInfo[] infos = model.cons.GetType().GetProperties();
            foreach (System.Reflection.PropertyInfo pf in cons.GetType().GetProperties())
            {
                System.Reflection.PropertyInfo prop = infos.FirstOrDefault(p => p.Name == pf.Name);
                if (prop.CanWrite)
                    prop.SetValue(model.cons, pf.GetValue(cons, null), null);
            }
            model.GetInviteCons(cons.Id_emsconsitem);//cons.Id_emsconsitem 为邀请对象的主键 ，id_srv 存储的为 会诊申请单主键


        }
        private void GetConsItem()
        {
            model.GetConsDep(strWhere);
            gv_consItem.DataTable.DataSource = model.consList;
        }
        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            gv_consItem.DataTable.DataSource = model.consList;
            
            gv_invite.DataTable.DataSource = model.inviteList;

         
        }



        #endregion

        #region 辅助处理函数

        void ConsSave()
        {
            if (cons!=null)
            {
                //更新会诊申请单的状态
                model.UpdateApConsStauts(cons.Id_srv);
                //更新应邀对象
                model.UpdateApConsInvite(cons.Id_emsconsitem);
                //刷新界面列表
                GetConsItem();
            }
       
        }
        private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy();

            policy.ClassName = "iih.ci.ord.ciordems.d.EmsItemInCons";
            //policy.AllowNew = flag;
            //policy.AllowEdit = flag;
            //policy.AllowRemove = flag;
            //policy.AllowSave = false;
            policy.FullEdit = flag;
            //policy.HideOther = true;
            //policy.MultiSelect = true;

            xapFormControl1.SetEditPolicy(flag, new DataPolicy[1] { policy });

           
        }
        #endregion



        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                
                case UIEvent.SAVE_SUCCESS:
                    //this.LoadData();
                    break;
                case "consres":
                    ConsSave();
                    break;
 
                default:
                    break;
            }
        }

        #endregion

    }
}
