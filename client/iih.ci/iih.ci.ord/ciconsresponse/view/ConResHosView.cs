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
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciconsresponse.view
{
    public partial class ConResHosView : XapBaseControl
    {
        #region
        public ConResHosView()
        {
            InitializeComponent();
       
        
            xapFormControl1.Load += new EventHandler(xapFormControl1_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
        }

 
        #endregion


        #region 变量定义区域
        //EmsUIDTO CiHeadDo { get; set; }
        //XapFormGridControl gv_consItem, gv_assist;//会诊项目，协助方
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
            //this.model = new viewmodel.DiagcateTreeViewModel(this.querystr);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
         FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_ConResHosView;// "20151110112303724TTN";
            file.FormStyle = FormStyle.Card;
            //file.ViewModel = CiHeadDo.Emsapcons; 
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);
            //SetGridPolicy(true);
 
        }
        //public override void OnRefreshData(EmsUIDTO headDo, object e)
        //{
        //    if (headDo != null)
        //    {
        //        CiHeadDo = headDo;
        //    }

        //    if (this.Created)
        //    {
        //        this.LoadData();
        //    }
        //}


        #endregion

        #region 内部事件区域

        void xapFormControl1_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            //this.xapFormControl1.SetToilHeight(50);
            //UserRender btnSave = xapFormControl1.GetUserRender("cons", "btnSave");//保存
            //btnSave.MouseClick += new MouseEventHandler(btnSave_MouseClick);
            //gv_consItem = xapFormControl1.GetGridView("consitem");
            //gv_consItem.ReadOnly = true;
            //gv_assist = xapFormControl1.GetGridView("consorg");
            //gv_assist.ReadOnly = false;
            //SetTabCommand();
        }
        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            //gv_consItem.DataTable.DataSource =  CiHeadDo.Emsapcons.EmsConsItem;
            //gv_assist.DataTable.DataSource = CiHeadDo.Emsapcons.EmsConsAssistItem;

        }

      
 
        #endregion

        #region 辅助处理函数
      
        //private void SetGridPolicy(bool flag)
        //{
        //    DataPolicy policy = new DataPolicy();
        //    policy.ClassName = "iih.ci.ord.ciordems.d.EmsItemInCons";
        //    policy.AllowNew = flag;
        //    policy.AllowEdit = flag;
        //    policy.AllowRemove = flag;
        //    //policy.AllowSave = false;
        //    //policy.FullEdit = flag;
        //    //policy.HideOther = true;
        //    //policy.MultiSelect = true;

        //    xapFormControl1.SetEditPolicy(flag, new DataPolicy[1] { policy });
        //}
        void btnSave_MouseClick(object sender, MouseEventArgs e)
        {
            //this.xapFormControl1.SaveForm();
            //this.Save(this);
        }
        #endregion



        #region 状态处理区域

       
        #endregion
    }
}
