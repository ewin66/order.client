using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.bd.bc.udi;
using iih.ci.ord.doctorhelper.ordertemplate.viewmodel;
using iih.ci.ord.dto.ordertpltree.d;
using iih.en.pv.dto.d;
using iih.en.pv.pativisit.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.basecontrol;
using xap.rui.control.engine.controls;
using xap.rui.control.forms.view;
using xap.rui.engine;

namespace iih.ci.ord.doctorhelper.ordertemplate.view
{
    /// <summary>
    /// <para>描    述 :  医嘱模板树</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.doctorhelper.ordertemplate.view</para>
    /// <para>类 名 称 :  Form1</para>
    /// <para>版 本 号 :  v1.0.0.0</para>
    /// <para>作    者 :  </para>
    /// <para>修 改 人 :  </para>
    /// <para>创建时间 :  2017/3/28 11:26:37</para>
    /// <para>更新时间 :  2017/3/28 11:26:37</para>
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public partial class OrderTemplateTreeView : BaseHelperView
    {
       

        #region 变量定义区域
        
        private OrderTemplateTreeViewModel model;
        private xap.rui.control.tree.otree.OTree oTree1;
        #endregion

        #region 构造函数区域
        public OrderTemplateTreeView()
        {
            InitializeComponent();
            this.oTree1.TreeItemSelected += new xap.rui.control.tree.events.TreeItemEventHandler(oTree1_TreeItemSelected);
            this.Load += new EventHandler(OrderTemplateTreeView_Load);
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

            Control control = this.Parent;
            while (control != null)
            {
                if(control is helperForm)
                {
                    helperForm form = control as helperForm;
                    Ent4BannerDTO = form.Ent4BannerDTO;
                    break;
                }
                else
                {
                    control = control.Parent;
                }
            }
            if (Ent4BannerDTO != null)
            {
                this.model = new OrderTemplateTreeViewModel(BdSrvDictCodeConst.SD_ORTPLTP_TEMPLATE, Ent4BannerDTO.Code_entp);
            }
            else
            {
                this.model = new OrderTemplateTreeViewModel(BdSrvDictCodeConst.SD_ORTPLTP_TEMPLATE, "10");
            }

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
            this.oTree1.MoveFirst();
            oTree1.ExpandToLevel(0);
        }

        #endregion

        #region 内部事件区域
        void OrderTemplateTreeView_Load(object sender, EventArgs e)
        {
             this.OnInit();
        }
        #endregion

        #region 辅助处理函数
        /// <summary>
        /// 发送树节点选中事件到卡上显示数据
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void oTree1_TreeItemSelected(object sender, xap.rui.control.tree.events.TreeItemEventArgs e)
        {
            this.FireSelected(oTree1.FocusedUserObject);

            //OrderTplTreeDto ordertplTree = oTree1.FocusedUserObject as OrderTplTreeDto;
            //if (ordertplTree == null)
            //{
            //    this.Context["Id_ent"] = "";
            //}
            //else
            //{
            //   // this.Context["Id_ent"] = ordertplTree.Id_ent;
            //}

            //DictionaryEventArgs args = new DictionaryEventArgs();
            //args.Data.Add(UIConst.UI_EVENT, "SelectNode");
            //base.FireEventSent(this, args);
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.REFRESH:
                    this.LoadData();
                    break;
                case UIEvent.LOAD:

                    //Dictionary<string, object> dic = eventArgs.Data[UIConst.DATA] as Dictionary<string, object>;
                    //if (dic != null)
                    //{

                    //    if (dic["PatientData"] != null)
                    //    {
                    //        this.patDo = (dic["PatientData"] as BannerData).Ent4BannerDTO;
                    //    }
                    //}
                    break;
                default:
                    break;
            }
        }

        #endregion
    }
}
