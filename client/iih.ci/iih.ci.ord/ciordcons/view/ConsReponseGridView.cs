using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.ci.ord.ciconsresponse.viewmodel;
using iih.ci.ord.cior.d;
using iih.ci.ord.ciordcons.dialog;
using iih.ci.ord.ciordcons.viewmodel;
using iih.ci.ord.dto.consdto.d;
using iih.ci.ord.opemergency.ems.dp;
using xap.cli.context;
using xap.cli.sdk.render;
using xap.cli.sdk.render.Items;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.basecontrol;
using xap.rui.control.extentions;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.control;
using xap.rui.control.forms.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciordcons.view
{
    public partial class ConsReponseGridView : XapListControl
    {
        private ConsGridViewModel model;
        private XapFormGridControl gv_consList;
        private OrdConsDTO consDto;
        private UserRender btnAgree;
        private string type = CiDictCodeConst.CONS_RESPONSE;

        public ConsReponseGridView()
        {
            InitializeComponent();
            this.Load += new EventHandler(ConsGridView_Load);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            this.xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            this.xapFormControl.AfterFocused += new EventHandler<DataFocusedEventArgs>(xapFormControl_AfterFocused);
        }

        #region 父类继承区域

        protected override void OnLoadData()
        {
            if (model!=null)return;
            string str = string.Format("AND  t1.fg_response='{0}' AND  t2.sd_su_cons in ({1}) AND  t1.id_dep = '{2}'", "N", "'4','5'", UserManager.getInstance().CurrentDept.Id_dep);
            model = new ConsGridViewModel(str);
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();

            if (model != null)
            {
                file.ViewModel = this.model.consList;
            }
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConsReponseGridView;// "20160607041900125DVU";
            file.FormStyle = FormStyle.List;
            this.xapFormControl.ViewFile = file;
            this.xapFormControl.SetEditPolicy(true);
        }
        #endregion
        #region 命令定义区域


        #endregion
        #region 内部事件区域
        void ConsGridView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        public override void OnSelected(object sender, TargetEventArgs e)
        {
            if ((e.Object is string))
            {
                string strWhere = e.Object as string;
                model.GetConList(UserManager.getInstance().CurrentDept.Id_dep, strWhere);
                if (model.consList.Count > 0)
                {
                    gv_consList.DataTable.UserMessage = null;
                }
                else
                {
                    gv_consList.DataTable.UserMessage = "未查询到数据！";
                }
                gv_consList.DataTable.DataSource = model.consList;
                for (int i = 0; i < model.consList.Count; i++)
                {
                    if (model.consList[i].Fg_urgent == true)
                        gv_consList.DataTable.Rows[i].ColumnCellDict["Urgent"].ForeColor = Color.Red;
                }
                btnAgree.Enabled = false;
            }
                

        }

        

        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            gv_consList.DataTable.DataSource = model.consList;
            for (int i=0;i<model.consList.Count;i++)
            {
                if (model.consList[i].Fg_urgent == true)
                        gv_consList.DataTable.Rows[i].ColumnCellDict["Urgent"].ForeColor = Color.Red;
            }
        }

        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
            gv_consList = xapFormControl.GetGridView("grid");
            gv_consList.ReadOnly = true;
            btnAgree = xapFormControl.GetUserRender("button", "btn_agree");
            btnAgree.Enabled = false;
            btnAgree.MouseClick += new MouseEventHandler(btnAgree_MouseClick);
        }

        void btnAgree_MouseClick(object sender, MouseEventArgs e)
        {
            CiordInviteConsDO inviteConsDo = this.model.btnEnable(consDto.Id_apcons);
            if (inviteConsDo.Fg_response == true)
            {
                this.ShowInfo(string.Format("本次会诊已由本科室的{0}于{1}应答!", inviteConsDo.Name_emp, inviteConsDo.Dt_response));
                return;
            }
            ConsResponseDialog dialog = new ConsResponseDialog(this.consDto)
            {
                Dock = DockStyle.Fill,
                Size = new Size(400, 300)

            };
            dialog.ShowDialog();
            if (dialog.DialogResult == DialogResult.OK )
            {
                this.xapFormControl.SaveForm();
                this.model.Save(dialog.dto, type, this.Context.PsnInfo.Id_psndoc, this.Context.Dept.Id_dep);
                this.SetStatusMsg("应答成功！");
                this.FireEvent();
                this.btnAgree.Enabled = false;

            }
        }

        void xapFormControl_AfterFocused(object sender, DataFocusedEventArgs e)
        {
            consDto = this.xapFormControl.GetSelected<OrdConsDTO>()[0];
           
            CiordInviteConsDO inviteConsDo = this.model.btnEnable(consDto.Id_apcons);
            if(inviteConsDo==null)return;
            if (inviteConsDo.Fg_response==false)
            {
                this.btnAgree.Enabled = true;
            }
            else
            {
                this.btnAgree.Enabled = false;
            }
            consDto.Fg_audit = true;
            this.FireSelected(this.model.GetApConsById(consDto));
            
        }

        void FireEvent()
        {
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, "AgreeSuccess");
            base.FireEventSent(this, args);
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            //string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            ////string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            //switch (uiEvent)
            //{
            //    //case "Query":
            //    //    this.SetDataSource();
            //    //    break;
            //    //default:
            //    //    break;
            //}
        }
        #endregion
    }
}
