using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.viewmodel;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.control.forms.control;
using iih.ci.ord.ciorder.utils;
using xap.rui.appfw;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards.extend
{
    public partial class MmRefView : XapBaseControl
    {
       
        #region 变量定义区域
        public XapFormControl xapFormControl;
        private MmRefViewModel model;
        XapFormGridControl gridView;
        XapDataList<EmsOrDrug> mms;
        LogicEx cof = LogicEx.GetInstance(); //new LogicEx();
        public event EventHandler DoubleClickEvent;

        #endregion

        #region 构造函数区域

        public MmRefView()
        {
            InitializeComponent();
            this.Load += new EventHandler(MmRefView_Load);
            xapFormControl=new XapFormControl();
            this.Controls.Add(xapFormControl);
            this.xapFormControl.FormCreated += new EventHandler(xapFormControl_FormCreated);
        }

        public MmRefView(XapDataList<EmsOrDrug> list):this()
        {
            this.mms = list;
        }

        void xapFormControl_FormCreated(object sender, EventArgs e)
        {
              gridView = this.xapFormControl.GetGridView("mm");
            gridView.DoubleClick += new EventHandler(gridView_DoubleClick);
            gridView.ReadOnly = true;
        }

        void gridView_DoubleClick(object sender, EventArgs e)
        {
            if (this.xapFormControl.GetSelected<EmsOrDrug>().Length == 0)
                return;
            if (this.DoubleClickEvent != null)
                DoubleClickEvent(SelectedDrug, e);
        }

        #endregion

        #region 公开属性区域

        public EmsOrDrug SelectedDrug
        {
            get
            {
                if (xapFormControl == null)
                    return null;

                return xapFormControl.GetSelected<EmsOrDrug>().FirstOrDefault();
            }
        }

        #endregion



        #region 父类继承区域
        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            this.model=new MmRefViewModel();
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file = new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_MmRefView;// "20150901071913646BGQ";
            file.ViewModel =  this.mms ;// this.model.mms;
            file.FormStyle = FormStyle.Card;
            this.xapFormControl.ViewFile = file;

        }



        #endregion

        #region 内部事件区域

        void MmRefView_Load(object sender, EventArgs e)
        {
            OnInit();
        }

        #endregion

        #region 辅助处理函数
       
        #endregion

        #region 状态处理区域

       

        #endregion
    }
}
