using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using xap.cli.sdk.render;
using xap.cli.sdk.render.labelcontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using iih.ci.ord.emsdi.d;
using xap.rui.control.refcontrol.events;
using iih.ci.ord.ciorder.utils;
using iih.ci.ord.dto.orderverify.d;
using xap.rui.control.extentions;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    /********************************************************************************

** 作者： 刘晓颖

** 创始时间：2016-6-30

** 修改人：刘晓颖

** 修改时间：2016-6-30

** 描述： 出院申请单页面


*********************************************************************************/
    public partial class OrderOutView : CiorderBaseControl
    {
     

        
          #region 构造函数区域
        public OrderOutView()
        {
  
            InitializeComponent();
            xapFormControl1.Load += new EventHandler(xapFormControl1_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            xapFormControl1.RefFilter += new EventHandler<RefActivatingEventArgs>(xapFormControl1_RefFilter);
            SheetName = "出院医疗单";
        }

        void xapFormControl1_RefFilter(object sender, RefActivatingEventArgs e)
        {
            if (e.BindingFieldName.Equals("Name_outtp"))
            {
                e.WherePart = string.Format("bd_udidoc.code <> '5'");
            }
        }

      

        
     
     
        #endregion


        #region 变量定义区域
        //XapFormGridControl gv_samp, gv_emp;//卫材，人员，附加手术
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
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderOutView;// "201511300506417101PJ";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.EmsHeadDO.Emsapout;// 新的
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);
 
        }
        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            if (headDo != null)
            {
                this.EmsHeadDO = headDo;
                OrWfDeptInfoDTO wf = new viewmodel.impext.GetDeptMpImp().GetDept_mp_ids(this.EmsHeadDO.PatInfo.Code_entp, this.EmsHeadDO.PatInfo.Id_entp, this.EmsHeadDO.MedSrvDO.Sd_srvtp, this.EmsHeadDO.MedSrvDO.Id_srvca, this.EmsHeadDO.MedSrvDO.Id_srv, this.EmsHeadDO.MedSrvDO.Id_route, "id_mm", this.EmsHeadDO.PatInfo.Id_dep_nur, this.EmsHeadDO.PatInfo.Id_dep_phy);
            }

            if (this.Created)
            {
                this.LoadData();
            }
        }


        #endregion

        #region 内部事件区域

        void xapFormControl1_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        void xapFormControl1_FormCreated(object sender, EventArgs e)
        {
            //this.xapFormControl1.SetToilHeight(50);
            //UserRender btnSave = xapFormControl1.GetUserRender("common", "btnSave");//保存
            //btnSave.MouseClick += new MouseEventHandler(btnSave_MouseClick);
            ////gv_samp = xapFormControl1.GetGridView("");
            ((this.xapFormControl1.GetUserRender("ordout", "fg_again31") as XLabelBaseUserRender).UserRender).ValueTextChanged += new EventHandler(OrderOutView_ValueTextChanged);
            if (this.EmsHeadDO.Emsapout.IsNEW)
                this.EmsHeadDO.Emsapout.Fg_death = false;
        }

        void OrderOutView_ValueTextChanged(object sender, EventArgs e)
        {
            if (!Created) return;
            if (sender == null)
                return;
            XCheckBox chk = (XCheckBox)sender;
            (this.xapFormControl1.GetUserRender("ordout", "des_again31") as XLabelBaseUserRender).Enabled = chk.Checked;
            if (chk.Checked != true) {
                (this.xapFormControl1.GetUserRender("ordout", "des_again31") as XLabelBaseUserRender).ValueText = "";   
            }
        }
        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            xapFormControl1.SetEditPolicy(!IsReadOnly);
            if (this.EmsHeadDO.Emsapout.IsNEW)
            {
                (this.xapFormControl1.GetUserRender("ordout", "des_again31") as XLabelBaseUserRender).Enabled = false;
            }
            else
            {
                (this.xapFormControl1.GetUserRender("ordout", "des_again31") as XLabelBaseUserRender).Enabled = (bool)this.EmsHeadDO.Emsapout.Fg_again31 && !IsReadOnly;
            }
            //限制开始时间的时间范围，入院日期，最大提前日期
            TimerComboBoxMaxAndMin.GetInstance().setMaxMinTime(xapFormControl1, this.Context, "ordout", "dt_out", EmsHeadDO.PatInfo.Id_ent);
            
            UserRender dt_out = xapFormControl1.GetUserRender("ordout", "dt_out");
            dt_out.Focus();
            
        }

        #endregion

        #region 辅助处理函数

        public override void SaveBefore()
        {
            //xapFormControl1.SaveForm();
            //if (this.EmsHeadDO.Emsapout.Des_outtp != null && this.EmsHeadDO.Emsapout.Des_outtp.Length > 150)
            //{
            //    this.ShowInfo("死亡描述字数超长了");
            //}
        }

        #endregion



        #region 状态处理区域

       
        #endregion


    }
}
