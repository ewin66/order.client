using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.doctorhelper.prescription.viewmodel;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.engine;
/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 协定处方树


*********************************************************************************/
namespace iih.ci.ord.doctorhelper.prescription.view
{
    /// <summary>
    /// 协定处方
    /// </summary>
    public partial class prescriptionTreeView : XapListControl
    {
     
        #region 变量定义区域

        private prescriptionTreeViewModel model;
        //private XapFormControl xapFormControl;
        private xap.rui.control.tree.otree.OTree oTree1;
        #endregion

        #region 构造函数区域
        public prescriptionTreeView()
        {
            InitializeComponent();
            this.oTree1.TreeItemSelected += new xap.rui.control.tree.events.TreeItemEventHandler(oTree1_TreeItemSelected);
            this.Load += new EventHandler(prescriptionTreeView_Load);
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
        {   //0001AA1000000000ELNX 是协定处方   sd 是 1
            //0001AA1000000000ELNW  是模板      sd 是 0
            this.model = new prescriptionTreeViewModel("0001AA1000000000ELNX");//##????
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            if (this.model == null)
                return;
            this.oTree1.ClearTree();
            this.oTree1.LoadData(this.model.TreeModel);
            oTree1.ExpandToLevel(0);
            oTree1.MoveFirst();
        }

        #endregion

        #region 内部事件区域
        protected void oTree1_TreeItemSelected(object sender, xap.rui.control.tree.events.TreeItemEventArgs e)
        {
            // FireSelected事件传递参数使用Dictionary，prescriptionListView中通过dic中的key判断是否执行操作
            // prescriptionTreeView与conmonOrderTreeView 中树节点构造对象相同，都使用FireSelected发送节点导致冲突
            Dictionary<string, object> selectedNodeDic = new Dictionary<string, object>();
            selectedNodeDic.Add("prescriptionTreeView", oTree1.FocusedUserObject);
            this.FireSelected(selectedNodeDic);
            //this.FireSelected(oTree1.FocusedUserObject);
        }
        #endregion

        #region 辅助处理函数
        void prescriptionTreeView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }

        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {

        }

        #endregion
    }
}
