using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.forms.control;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.ciorder.Validate;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.forms.model;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.emsdi.d;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// 检验医嘱单
    /// </summary>
    /// Author:admin
    /// Date:2015-10-13
    public partial class OrderAplabView :CiorderBaseControl
    {
        
        #region 变量定义区域
        private string idDepMps;
        #endregion

        #region 构造函数区域
        public OrderAplabView()
        {
            InitializeComponent();
            this.Load+=new EventHandler(OrderAplabView_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            xapFormControl1.RefResult += new EventHandler<RefResultEventArgs>(xapFormControl1_RefResult);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
            SheetName = "检验医疗单";
        }

        void xapFormControl1_DataChanged(object sender, DataChangedEventArgs e)
        {
            if (!string.IsNullOrEmpty(e.PropName))
            {
                switch (e.PropName)
                {
                    case "Dt_plan":
                        EmsHeadDO.Dt_begin_ui = EmsHeadDO.Emsaplab.Dt_plan;//同步开始时间
                        break;
                }
            }
        }

        void xapFormControl1_RefResult(object sender, RefResultEventArgs e)
        {
             
        }
        #endregion

        #region 公开属性区域
        public override IValidate GetOrdValidate()
        {
            return new OrderAplabValidate();
        }
        XapFormGridControl gv;//, gv_drug;
        #endregion


        #region 父类继承区域

        public override void SaveBefore()
        {
            xapFormControl1.SaveForm();
            EmsObsLap[] lap =  xapFormControl1.GetSelected<EmsObsLap>();
            this.EmsHeadDO.Emsaplab.EmsOrObsList = lap;
            foreach (EmsObsLap obslap in this.EmsHeadDO.Emsaplab.EmsOrObsList)
            {
                obslap.Fg_chk = true;
            }
        }



        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            //OraplabDo = headDo.Emsoraplab;
            this.EmsHeadDO = headDo;
            OrWfDeptInfoDTO wf = new viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(this.EmsHeadDO.PatInfo.Code_entp, this.EmsHeadDO.PatInfo.Id_entp, this.EmsHeadDO.MedSrvDO.Sd_srvtp, this.EmsHeadDO.MedSrvDO.Id_srvca, this.EmsHeadDO.MedSrvDO.Id_srv, this.EmsHeadDO.MedSrvDO.Id_route, "id_mm", headDo.PatInfo.Id_dep_nur, headDo.PatInfo.Id_dep_phy);
             if (wf != null) idDepMps = wf.Id_mp_depts;
            string[] di = new string[2];
            if (this.EmsHeadDO.IsNEW)
            {
                if (wf != null) {
                    this.EmsHeadDO.Emsaplab.Id_mp_dep = wf.Firstid_mp_dept;
                    this.EmsHeadDO.Emsaplab.Name_mp_dep = wf.Firstname_mp_dept;
                }
               
            }
            base.OnRefreshData(headDo, e);
        }
      

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (this.EmsHeadDO == null) return;
            string[] di = new string[2];
            cof.GetPatDis(this.EmsHeadDO, ref di);
            if (this.EmsHeadDO.IsNEW && string.IsNullOrEmpty(this.EmsHeadDO.Emsaplab.Id_di))
            {
                this.EmsHeadDO.Emsaplab.Id_di = di[0];
                this.EmsHeadDO.Emsaplab.Name_diag = di[1];
            }
            else
            {
               // cof.GetDiname(this.EmsHeadDO,this.EmsHeadDO.Emsaplab.Id_di, ref di);
               //// this.EmsHeadDO.Emsaplab.Id_di = di[0];
               // this.EmsHeadDO.Emsaplab.Name_di = di[1];

            }
            if (gv != null) {
                gv.DataTable.DataSource = null;
            }
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderAplabView;// "2015083107260929381D";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.EmsHeadDO.Emsaplab;
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);

        }

        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_diag"))
            {
                e.RefParams.AddParam("id_ent",this.EmsHeadDO.PatInfo.Id_ent);

                //e.WherePart = " id_ent ='" + this.EmsHeadDO.PatInfo.Id_ent + "'";
            }
            else if (e.BindingFieldName.Equals("Name_mp_dep") && !string.IsNullOrWhiteSpace(idDepMps))
            {
                e.WherePart = string.Format("id_dep in ({0})", idDepMps);
            }
        }

        #endregion

        #region 内部事件区域
        void OrderAplabView_Load(object sender, System.EventArgs e)
        {
            this.OnInit();
        }
        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {

            XTabControl tabControl = new XTabControl();
            List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            Dictionary<string ,UserRender> dic = tabs[0].Pages[0].DicUserRenders;
            
            gv = xapFormControl1.GetGridView("list");//检验明细
            gv.MouseClick += new MouseEventHandler(gv_MouseClick);
            
            //gv_drug = this.xapFormControl1.GetGridView("item");//  

            //xap.cli.sdk.render.UserRender btnOK = xapFormControl1.GetUserRender("aplab", "btnSave");//保存
            //btnOK.MouseClick += new MouseEventHandler(btnOK_MouseClick);

            UserRender btnDel = xapFormControl1.GetUserRender("ordobs", "btnDel");//删除药品
            //btnDel.MouseClick += new MouseEventHandler(btnDel_MouseClick);
            UserRender btnAdd = xapFormControl1.GetUserRender("ordobs", "btnAdd");//添加药品
           // btnAdd.MouseClick += new MouseEventHandler(btnAdd_MouseClick);
            //隐藏检查药品
            if (this.xapFormControl1.GetUserRender("ordobs", "checkdrug")!= null)
            {
                this.xapFormControl1.GetUserRender("ordobs", "checkdrug").Visible = false;
            }
            if (this.xapFormControl1.GetGridView("drug")!=null)
            {
                this.xapFormControl1.GetGridView("drug").Visible = false;
            }
            if (btnDel!=null)
            {
                btnDel.Visible = false;
            }
            if (btnAdd!= null)
            {
                btnAdd.Visible = false;
            }
        }

        void gv_MouseClick(object sender, MouseEventArgs e)
        {
        }
        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            xapFormControl1.SetEditable(!IsReadOnly);
            SetGridPolicy(!IsReadOnly);
            //限制开始时间的时间范围，入院日期，最大提前日期
            //UserRender us = xapFormControl1.GetUserRender("aplab", "dt_plan");
            //xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
            ////DateTime dataA = new GetInHosTime().GetPatInHosTime(this.EmsHeadDO.PatInfo.Id_ent);
            //dt_begin.MinDate = this.EmsHeadDO.Emsaplab.Dt_plan;
            //dt_begin.MaxDate = ((DateTime)this.EmsHeadDO.Emsaplab.Dt_plan).AddDays(OrdParam.GetOrdParam.orBeforStartDays);
            
            //限制开始时间的时间范围，入院日期，最大提前日期
           TimerComboBoxMaxAndMin.GetInstance().setMaxMinTime(xapFormControl1, this.Context, "aplab", "dt_plan", EmsHeadDO.PatInfo.Id_ent);
            
            gv.Enabled = true;
            gv.DataTable.DataSource = this.EmsHeadDO.Emsaplab.EmsOrObsList;
            bool allSelectAll = false;
            if (this.EmsHeadDO.MedSrvDO.Fg_set == true)
            {
                for (int i = 0; i < this.EmsHeadDO.Emsaplab.EmsOrObsList.Count; i++)
                {
                    if (false == this.EmsHeadDO.Emsaplab.EmsOrObsList[i].Fg_edit)
                    {
                        gv.DataTable.Rows[i].Selected = true;
                        gv.DataTable.Rows[i].Enabled = false;
                        continue;
                    }
                    else {
                        allSelectAll = true;
                    }
                   if (this.EmsHeadDO.Emsaplab.EmsOrObsList[i].Fg_chk == null || this.EmsHeadDO.Emsaplab.EmsOrObsList[i].Fg_chk == false)
                        continue;
                        gv.DataTable.Rows[i].Selected = true;
                }
            }
            else
            {
                //非套服务 fg_body_update部位可修改标志=ture时，部位列字体置灰并斜体，用户鼠标点进去后，部位名称值清空，用户可手工录入部位。体位列可在下拉列表里重新选择。否则=false时，部位列和体位列为只读不可修改。

                for (int i = 0; i < this.EmsHeadDO.Emsaplab.EmsOrObsList.Count; i++)
                {
                    if (false == this.EmsHeadDO.Emsaplab.EmsOrObsList[i].Fg_edit)
                    {
                        gv.DataTable.Rows[i].Selected = true;
                        gv.DataTable.Rows[i].Enabled = false;
                        continue;
                    }
                    else {
                        allSelectAll = true;
                    }
                    if (this.EmsHeadDO.Emsaplab.EmsOrObsList[i].Fg_chk == null || this.EmsHeadDO.Emsaplab.EmsOrObsList[i].Fg_chk == false)
                        continue;
                        gv.DataTable.Rows[i].Selected = true;
                }
            }
            gv.AllowSelectAll(allSelectAll);
            gv.Enabled = !IsReadOnly;
            //if (this.EmsHeadDO.Emsaplab.EmsOrObsList.Count>0)
            //gv.DataTable.Rows[0].SetMultiSelectStatus(true);
            //药品 暂时不做
            //gv_drug.DataTable.DataSource = this.EmsHeadDO.Emsaplab.EmsOrDrugList;
            


        }
      




        #endregion

        #region 辅助处理函数
        private void SetGridPolicy(bool flag)
        {
            DataPolicy policy = new DataPolicy();
            policy.ClassName = "iih.ci.ord.ciordems.d.EmsObsItemDO";
            //policy.AllowNew = flag;
            policy.AllowEdit = flag;
            //policy.AllowRemove = flag;
            //policy.AllowSave = false;
            policy.FullEdit = flag;
            //policy.HideOther = true;
            //policy.MultiSelect = true;
            DataPolicy policy1 = new DataPolicy() {
                ClassName = "iih.ci.ord.ciordems.d.EmsObsLap",
                AllowEdit = flag,
                FullEdit = flag
            };
            xapFormControl1.SetEditPolicy(flag, new DataPolicy[2] { policy, policy1 });

            //gv_change.ReadOnly = false;
            //gv.ReadOnly = true;
            //gv.DataTable.ReadOnly = true;
        }
        #endregion

        #region 状态处理区域

        //public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        //{

        //}

        #endregion
    }
}
