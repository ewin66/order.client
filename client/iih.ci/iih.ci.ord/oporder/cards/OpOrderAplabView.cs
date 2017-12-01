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
using iih.ci.ord.ciorder;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.ord.ciorder.Validate;
using xap.cli.sdk.render;
using xap.rui.control.refcontrol.events;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.oporder.cards
{
    /// <summary>
    /// 检验医嘱单
    /// </summary>
    /// Author:admin
    /// Date:2015-10-13
    public partial class OpOrderAplabView :CiorderBaseControl
    {
        
        #region 变量定义区域
       

        #endregion

        #region 构造函数区域
        public OpOrderAplabView()
        {
            InitializeComponent();
            this.Load+=new EventHandler(OrderAplabView_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            this.xapFormControl1.RefFilter += this.OnRefFilter;
            this.SheetName = "门诊检验";
        }
        #endregion

        #region 公开属性区域

        EmsUIDTO CiHeadDo { get; set; }
        XapFormGridControl gv;
        private new LogicEx cof = LogicEx.GetInstance();
        #endregion


        #region 父类继承区域

        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            //OraplabDo = headDo.Emsoraplab;
            CiHeadDo = headDo;
         
        }
      

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            string[] di = new string[2];
            cof.GetPatDis(CiHeadDo, ref di);
            CiHeadDo.Emsaplab.Id_di = di[0];
            CiHeadDo.Emsaplab.Name_diag = di[1];

        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OpOrderAplabView;// "2015083107260929381D";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = CiHeadDo.Emsaplab;
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);

        }



        #endregion

        #region 内部事件区域
        void OrderAplabView_Load(object sender, System.EventArgs e)
        {
            this.OnInit();
        }
        private void xapFormControl1_FormCreated(object sender, EventArgs e)
        {

            //XTabControl tabControl = new XTabControl();
            //List<ControlTab> tabs = xapFormControl1.FormModel.Tabs;
            //dic = tabs[0].Pages[0].DicUserRenders;
            gv = xapFormControl1.GetGridView("list");//检验明细
            gv.MouseClick += new MouseEventHandler(gv_MouseClick);

            //gv_drug = this.xapFormControl1.GetGridView("item");//  

            //xap.cli.sdk.render.UserRender btnOK = xapFormControl1.GetUserRender("aplab", "btnSave");//保存
            //btnOK.MouseClick += new MouseEventHandler(btnOK_MouseClick);


        }

        void gv_MouseClick(object sender, MouseEventArgs e)
        {
        }
        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {

            //限制开始时间的时间范围，入院日期，最大提前日期
            UserRender us = xapFormControl1.GetUserRender("aplab", "dt_plan");
            xap.cli.sdk.render.Items.XCalendarTimerComboBox dt_begin = us.Renders[0] as xap.cli.sdk.render.Items.XCalendarTimerComboBox;
            DateTime dataA = (LogicEx.GetInstance()).GetServerDataTime();
            dt_begin.MinDate = dataA;
            dt_begin.MaxDate = cof.GetServerDataTime().AddDays(OrdParam.GetOrdParam.orBeforStartDays);


            gv.DataTable.DataSource = CiHeadDo.Emsaplab.EmsOrObsList;
            //gv_drug.DataTable.DataSource = CiHeadDo.Emsapobs.EmsOrDrugList;
            if (CiHeadDo.Emsaplab.EmsOrObsList.Count > 0)
               // gv.DataTable.Rows[0].Selected(true);
                  gv.DataTable.Rows[0].Selected = true;

        }
        //void btnOK_MouseClick(object sender, MouseEventArgs e)
        //{
        //    this.xapFormControl1.SaveForm();
        //    this.Save(this);
 
        //}


        private new void OnRefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_di"))
            {
                e.RefParams.AddParam("id_ent", CiHeadDo.PatInfo.Id_ent);
            }
        }

        #endregion

        #region 辅助处理函数
        public override IValidate GetOrdValidate()
        {
            return new OrderAplabValidate();
        }
        #endregion

        #region 状态处理区域

        //public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        //{

        //}

        #endregion
    }
}
