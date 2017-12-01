using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using iih.bd.srv.srvcate.d;
using iih.ci.ord.doctorhelper.classification.viewmodel;
using xap.rui.control.basecontrol;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.assi.medsrvclass.view
{
    public partial class OpmedSrvTreeView :  XapListControl
    {
        private xap.rui.control.tree.otree.OTree oTree1;

        #region 构造函数区域
        public OpmedSrvTreeView()
        {
            InitializeComponent();
            this.Load += new EventHandler(DiagcateTreeView_Load);
            this.oTree1.TreeItemSelected += new xap.rui.control.tree.events.TreeItemEventHandler(oTree1_TreeItemSelected);
            //MedParam.typeparameter = BdSrvDictCodeTypeConst.MEDSRV_DIAGTREAT;
        }
        /// <summary>
        /// 发送树节点选中事件到卡上显示数据
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void oTree1_TreeItemSelected(object sender, xap.rui.control.tree.events.TreeItemEventArgs e)
        {
            this.FireSelected(oTree1.FocusedUserObject);

            SrvCateDO srvcate = oTree1.FocusedUserObject as SrvCateDO;
            if (srvcate == null)
            {
                this.Context["Id_srvca"] = "";
            }
            else
            {
                this.Context["Id_srvca"] = srvcate.Id_srvca;
            }

            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, "SelectNode");
            base.FireEventSent(this, args);
            //throw new NotImplementedException();
        }
        #endregion


        #region 变量定义区域
        private medSrvTreeViewModel model;
        private string Querystr = " (a0.fg_entp_op = 'Y' or a0.fg_entp_er = 'Y') ";
        //private string typeparameter;
        #endregion
      

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        //[XapCommand(Name = "Open", Caption = "打开")]
        //public void OnOpen(object sender, EventArgs e)
        //{

        //}

        #endregion

       

        #region 父类继承区域

        /// <summary>
        /// 获取控件相关的数据，不涉及界面(不读写界面元素）。
        /// </summary>
        protected override void OnLoadData()
        {
            if (this.Querystr==null)
                return;
            this.model = new medSrvTreeViewModel(this.Querystr);
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
       
        }

        #endregion

        #region 内部事件区域
       
      
   
        /// <summary>
        /// 加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        void DiagcateTreeView_Load(object sender, EventArgs e)
        {
            base.OnInit();
        }
        #endregion

        #region 辅助处理函数
      
        #endregion



        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case UIEvent.LOAD:
                    //string medsrvtypestr = eventArgs.Data["Data"].ToString();

                Dictionary<string, object>dic=    eventArgs.Data["Data"] as Dictionary<string, object>;
                if (dic != null && dic.ContainsKey("medsrvtypestr"))
                {
                   string medsrvtypestr = dic["medsrvtypestr"].ToString();
                    if (medsrvtypestr != null || medsrvtypestr != "")
                    {
                        string[] strs = medsrvtypestr.Split(',');
                        this.Querystr = " (";
                        int i = 0;
                        foreach (string str in strs)
                        {
                            if (i != 0)
                                this.Querystr += " or";
                            this.Querystr += string.Format(" a0.code like '{0}%'", str);
                            i++;
                        }
                        this.Querystr+= ")";
                    }
                    this.LoadData();  
                 }
                 
                break;
                case UIEvent.SAVE_SUCCESS:
                    this.LoadData();
                    break;
                case UIEvent.PREVIEW:
                    //this.OnPreview();
                    break;
                case UIEvent.PRINT:
                    // this.OnPrint();
                    break;
                case UIEvent.ADD:
                    //this.OnAdd();
                    break;
                case UIEvent.DELETE:
                    //this.Delete();
                    break;
                case UIEvent.DISABLE:
                    // this.UpdateActivestate(ActiveStateEnum.STOP);
                    break;
                case UIEvent.ENABLE:
                    //this.UpdateActivestate(ActiveStateEnum.ACTIVE);
                    break;
                default:
                    break;
            }
        }
        #endregion
    }
}
