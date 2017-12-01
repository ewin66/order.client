using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.ciorder.viewmodel;
using xap.rui.control.basecontrol;
using xap.rui.control.formcontrol.model;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.rui.bizcontrol.BillFormTmplConst;

namespace iih.ci.ord.ciorder.cards
{
    /// <summary>
    /// 医嘱处方
    /// </summary>
    public partial class OrderPresView : XapListControl
    {
      

        #region 变量定义区域

        private XapFormControl xapFormControl;
        private OrderPresViewModel model;
        #endregion

        #region 构造函数区域
        public OrderPresView()
        {
            InitializeComponent();
            this.xapFormControl = new XapFormControl();
            this.xapFormControl.Dock = DockStyle.Fill;
            this.Load += new EventHandler(OrderPresView_Load);

            this.Controls.Add(this.xapFormControl);

        }

     

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        //[XapCommand(Name = "Open", Caption = "打开")]
        //public void OnOpen(object sender, EventArgs e)
        //{

        //}

        #endregion

        #region 事件发送区域

        //[XapEventSent(Name = "Say")]
        //public event EventHandler<XapEventArgs> Say;

        #endregion

        #region 事件接收区域

        //[XapEventRecv(Name = "Recv")]
        //public void OnRecv(object sender, XapEventArgs e)
        //{

        //}
        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            this.model = new OrderPresViewModel(null);
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            FormFile file =new FormFile();
            file.FormId = CiOrdBillFormTmplConst.CIORD_IP_OrderPresView;// "20151123024924760NRU";
            file.FormStyle = FormStyle.List;
            if (this.model != null)
            {
                file.ViewModel = this.model.getOrderPresSplitList();
            }
            this.xapFormControl.ViewFile = file;
        }

        #endregion

        #region 内部事件区域
        void OrderPresView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }
        #endregion

        #region 辅助处理函数

        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {

        }

        #endregion
    }
}
