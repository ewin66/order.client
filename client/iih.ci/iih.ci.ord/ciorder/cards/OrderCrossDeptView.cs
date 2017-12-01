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
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.ciorder.Validate;
using xap.rui.control.forms.model;
using xap.rui.control.refcontrol.events;
using xap.cli.sdk.render;
using iih.ci.ord.ciorder.utils;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    /********************************************************************************

 ** 作者： 刘晓颖

 ** 创始时间：2016-8-1

 ** 修改人：刘晓颖

 ** 修改时间：2016-8-1

 ** 描述： 跨科申请单页面


 *********************************************************************************/
    public partial class OrderCrossDeptView : CiorderBaseControl
    {
        private OrderTransViewModel model = new OrderTransViewModel();
          #region 构造函数区域
        public OrderCrossDeptView()
        {
            InitializeComponent();
            xapFormControl1.Load += new EventHandler(xapFormControl1_Load);
            xapFormControl1.FormCreated += new EventHandler(xapFormControl1_FormCreated);
            xapFormControl1.ModelFilled += new EventHandler(xapFormControl1_ModelFilled);
            xapFormControl1.DataChanged += new EventHandler<DataChangedEventArgs>(xapFormControl1_DataChanged);
            xapFormControl1.RefFilter += new EventHandler<RefActivatingEventArgs>(xapFormControl1_RefFilter);
            this.xapFormControl1.RefResult += new EventHandler<RefResultEventArgs>(xapFormControl1_RefResult);
            SheetName = "跨科医疗单";
        }


       
     
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
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderCrossDeptView;// "20160801051931538XOM";
            file.FormStyle = FormStyle.Card;
            file.ViewModel = this.EmsHeadDO.Emsaptrans;// 新的
            this.xapFormControl1.ViewFile = file;
            xapFormControl1.SetEditPolicy(true);
 
        }
        public override void OnRefreshData(EmsUIDTO headDo, object e)
        {
            if (headDo != null)
            {
                this.EmsHeadDO = headDo;
                headDo.Emsaptrans.Fg_tech_trans = true;//跨科标志

            }

            if (this.Created)
            {
                this.LoadData();
            }
        }

        void xapFormControl1_DataChanged(object sender, xap.rui.control.forms.model.DataChangedEventArgs e)
        {
            if (e.PropName == "Id_dep_to" && e.Data is EmsTransItemDO)
            {
                EmsTransItemDO item = e.Data as EmsTransItemDO;
                item.Id_dep_nur_to = null;
                item.Name_dep_nur_to = null;

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
        }
        void xapFormControl1_ModelFilled(object sender, EventArgs e)
        {
            UserRender name_dep_to = xapFormControl1.GetUserRender("trans", "name_dep_to");
            name_dep_to.Focus();
            xapFormControl1.SetEditPolicy(!IsReadOnly);
            TimerComboBoxMaxAndMin.GetInstance().setMinTime(this.xapFormControl1,this.Context, "trans", "dt_end", this.EmsHeadDO.Emsaptrans.Dt_effe);
        }
        void xapFormControl1_RefFilter(object sender, xap.rui.control.refcontrol.events.RefActivatingEventArgs e)
        {
            string fieldName = e.BindingFieldName;
            if ("Name_dep_nur_to".Equals(fieldName))
            {
                string id_dep = this.EmsHeadDO.Emsaptrans.Id_dep_to;
                if (id_dep == null)
                {
                    e.WherePart = "1=1";
                    return;
                }
                string nurids = model.getNurAreaOfDep(id_dep);
                if (nurids == null || nurids == "") e.Cancel = true;
                e.WherePart = string.Format("id_dep in ({0}) and sd_depttp like '02%'", nurids);
            }
            if ("Name_dep_to".Equals(fieldName))
            {
                string id_dep = this.EmsHeadDO.Emsaptrans.Id_dep_from;
                if (id_dep == null) return;
                e.WherePart = string.Format("id_dep <> '{0}' and sd_depttp like '01%'", id_dep);
            }
        }


        void xapFormControl1_RefResult(object sender, RefResultEventArgs e)
        {

        }
        #endregion

        #region 辅助处理函数

        public override IValidate GetOrdValidate()
        {
            return new OrderTransValidate();
        }
        #endregion



        #region 状态处理区域

       
        #endregion


    }
}
