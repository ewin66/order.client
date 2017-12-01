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
    public partial class ConsReviewMdaGridView : XapListControl
    {
        private ConsGridViewModel model;
        private XapFormGridControl gv_consList;
        private OrdConsDTO consDto;
        private UserRender btnAgree;
        private string type = CiDictCodeConst.CONS_MADREVIEW;

        public ConsReviewMdaGridView()
        {
            InitializeComponent();
            this.Load += new EventHandler(ConsGridView1_Load);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
            this.xapFormControl.ModelFilled += new EventHandler(xapFormControl_ModelFilled);
            this.xapFormControl.AfterFocused += new EventHandler<DataFocusedEventArgs>(xapFormControl_AfterFocused);
        }

       

       

       
        #region 父类继承区域

        protected override void OnLoadData()
        {
            if (model!=null)return;
            string str = string.Format("AND  t2.sd_su_cons='2' and t3.fg_sign='Y' and t3.fg_canc='N'");
            model = new ConsGridViewModel(str);
        }

        protected override void OnFillData()
        {
            FormFile file = new FormFile();

            if (model != null)
            {
                file.ViewModel = this.model.consList;
            }
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConsReviewMdaGridView;// "20160618022403054JWA";
            file.FormStyle = FormStyle.List;
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
        void ConsGridView1_Load(object sender, EventArgs e)
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
            }
                

        }

        

        void xapFormControl_ModelFilled(object sender, EventArgs e)
        {
            gv_consList.DataTable.DataSource = model.consList;
            for (int i = 0; i < model.consList.Count; i++)
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
            OrdConsDTO dto = this.model.GetApConsById(this.consDto);
            if (dto.Sd_su_cons != CiDictCodeConst.SD_CIDI_DYWSP)
            {
                this.ShowInfo(string.Format("该会诊医务部已审批！"));
                return;
            }
            ConsReviewDialog dialog = new ConsReviewDialog(this.consDto)
            {
                Dock = DockStyle.Fill,
                Size = new Size(400, 300)

            };
            dialog.ShowDialog();
            if (dialog.DialogResult == DialogResult.OK )
            {
                this.xapFormControl.SaveForm();
                this.model.Save(dialog.dto, type, this.Context.PsnInfo.Id_psndoc, this.Context.Dept.Id_dep);
                this.SetStatusMsg("审批成功！");
                this.FireEvent();
                this.btnAgree.Enabled = false;
            }
        }

        void xapFormControl_AfterFocused(object sender, DataFocusedEventArgs e)
        {
            consDto = this.xapFormControl.GetSelected<OrdConsDTO>()[0];

            if (consDto.Sd_su_cons == CiDictCodeConst.SD_CIDI_DYWSP)
            {
                btnAgree.Enabled = true;
            }
            else
            {
                btnAgree.Enabled = false;
            }
            consDto.Fg_audit = true;
            this.FireSelected(consDto);
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
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            //string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            //switch (uiEvent)
            //{
            //    case UIEvent.LOAD:
            //        Dictionary<string, object>dic=eventArgs.Data["Data"] as Dictionary<string, object>;
            //        string str = dic["BeanConfigFilePath"].ToString();
            //        string[] strs = str.Split('\\');
            //        string xml = strs[strs.Length-1];
            //        switch (xml)
            //        {
            //            case CiDictCodeTypeConst.CICONS_REVIEW_ADM:
            //                this.type = CiDictCodeConst.CONS_MADREVIEW;
            //                break;
            //            case CiDictCodeTypeConst.CICONS_REVIEW_DEP:
            //                this.type = CiDictCodeConst.CONS_DEPREVIEW;
            //                break;
            //        }
            //        break;
            //    default:
            //        break;
            //}
        }
        #endregion
    }
}
