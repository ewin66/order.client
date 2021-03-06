﻿using System;
using System.Collections.Generic;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.engine;
using iih.ci.ord.doctorhelper.commonorder.viewmodel;
using iih.ci.ord.dto.medicalroutinetreedto.d;

/********************************************************************************

** 作者： 李政

** 创始时间：2016-6-30

** 修改人：李政

** 修改时间：2016-6-30

** 描述： 常规模板


*********************************************************************************/
namespace iih.ci.ord.doctorhelper.commonorder.view
{
    public partial class conmonOrderTreeView : BaseHelperView
    {
      
        #region 变量定义区域
        //private XapFormControl xapFormControl;
        #endregion

        #region 构造函数区域
        public conmonOrderTreeView()
        {
            InitializeComponent();
            this.oTree1.TreeItemSelected += new xap.rui.control.tree.events.TreeItemEventHandler(oTree1_TreeItemSelected);
            this.Load += new EventHandler(conmonOrderTreeView_Load);
        }

   

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        //[XapCommand(Name = "Open", Caption = "打开")]
        //public void OnOpen(object sender, EventArgs e)
        //{

        //}
        private conmonOrderTreeViewModel model;
        private xap.rui.control.tree.otree.OTree oTree1;
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
            this.model = new conmonOrderTreeViewModel("1");
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
        /// <summary>
        /// 发送树节点选中事件到卡上显示数据
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void oTree1_TreeItemSelected(object sender, xap.rui.control.tree.events.TreeItemEventArgs e)
        {            
            // FireSelected事件传递参数使用Dictionary，commonOrderListView中通过dic中的key判断是否执行操作，
            // prescriptionTreeView与conmonOrderTreeView 中树节点构造对象相同，都使用FireSelected发送节点导致冲突
            Dictionary<string, object> selectedNodeDic = new Dictionary<string, object>();
            selectedNodeDic.Add("conmonOrderTreeView", oTree1.FocusedUserObject);
            this.FireSelected(selectedNodeDic);            

            Medicalroutinetreedto regularOr = oTree1.FocusedUserObject as Medicalroutinetreedto;
            if (regularOr == null)
            {
                this.Context["Id_ortmplca "] = "";
            }
            else
            {
                this.Context["Id_ortmplca"] = regularOr.Id_ortmplca;
            }

            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, "SelectNode");
            base.FireEventSent(this, args);
        }

        #endregion

        #region 辅助处理函数
        void conmonOrderTreeView_Load(object sender, EventArgs e)
        {
            this.OnInit();
        }
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

                    Dictionary<string, object> dic = eventArgs.Data["Data"] as Dictionary<string, object>;
                    if (dic != null)
                    {
                       
                    }
                    //this.LoadData();
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
