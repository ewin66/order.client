using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using iih.ci.ord.doctorhelper.newtemplate.viewmodel;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.controls.tabPanel;
using xap.rui.control.basecontrol;
using xap.rui.control.forms.view;
using xap.rui.control.tree.otree;
using xap.rui.engine;
using iih.bd.srv.ortpl.dto;
using iih.bd.srv.ortpl.d;
using xap.rui.control.tree.events;
using iih.bd.bc.udi;

namespace iih.ci.ord.opemergency.assi.OrderTemplate.view
{
    public partial class OpOrderTemplateTreeView : XapListControl
    {
        private NewOrderTemplateTreeViewModel model;
        private OTree oTree1;
        private XapFormControl xapFormControl;

        //树上图标
        private const string
            ImageKeyCa = "分类-1.png",
            ImageKeyModel = "医嘱模板-1.png",
            ImageKeyRoutine = "医技常规-1.png",
            ImageKeyFHMB = "复合模板-1.png",
            ImageKeyXY = "成组西成药-1.png",
            ImageKeyCY = "草药方剂-1.png";

        public OpOrderTemplateTreeView()
        {
            InitializeComponent();
            
            this.Load += new EventHandler(NewOrderTemplateTreeView_Load);
            this.xapFormControl =new XapFormControl();  
            this.xapFormControl.Dock = DockStyle.Fill;
            this.oTree1.TreeItemSelected += new xap.rui.control.tree.events.TreeItemEventHandler(oTree1_TreeItemSelected);
            this.xapFormControl.AddRender(this.oTree1);

            this.Controls.Add(xapFormControl);
        }
        /// <summary>
        /// 树的选中事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>

        protected void oTree1_TreeItemSelected(object sender, xap.rui.control.tree.events.TreeItemEventArgs e)
        {
            if (oTree1 != null) this.FireSelected(oTree1.FocusedUserObject);
        }

        void NewOrderTemplateTreeView_Load(object sender, EventArgs e)
        {
            this.model = new NewOrderTemplateTreeViewModel(this.Context, "0");
            XTabPanel  tabPanel = new XTabPanel();
            tabPanel.AddItems(model.DicScopetp);
            tabPanel.Dock = DockStyle.Top;
            tabPanel.Size = new System.Drawing.Size(290, 60);
            tabPanel.BackColor = System.Drawing.Color.White;
            tabPanel.SelectedIndex = 0;
            tabPanel.SelectedIndexChanged += new XTabPanel.selectedIndexChanged(tabPanel_SelectedIndexChanged);
            this.Controls.Add(tabPanel);
             this.OnInit();
        }

        /// <summary>
        /// 响应树目录更换页签
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void tabPanel_SelectedIndexChanged(object sender, EventArgs e)
        {
          //  this.currOrTmplCaDO = null;
            //this.currOrTmplDTO = null;

            XTab tab = (XTab)sender;
            model.GetCurrUdidocDO_SubOwnerType(tab.Value);
            this.LoadData();

            //onFireEventSent("SelectTab", viewModel.CurrUdidocDO_SubOwnerType);
        }



        #region 变量定义区域

        #endregion

        #region 构造函数区域


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

            if (this.model == null)
                this.model = new NewOrderTemplateTreeViewModel(this.Context, "0");
            model.LoadData();
           
        }

        /// <summary>
        /// CreateView执行完毕后，用LoadData的数据填充界面
        /// </summary>
        protected override void OnFillData()
        {
            this.oTree1.ClearTree();
            ResetFuncTreeImageEvent();//设置otree图标
            if (this.model == null)
                return;
            model.GetTreeKeyModel();
            oTree1.LoadData(model.lazyLoadTreeModel);
            oTree1.MoveFirst();
            this.oTree1.ExpandAll();
        }

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数
        /// <summary>
        /// 加载树项目图标
        /// </summary>
        private void ResetFuncTreeImageEvent()
        {
            this.oTree1.ClearCustomImages();

            this.oTree1.AddCustomImage(ImageKeyCa);
            this.oTree1.AddCustomImage(ImageKeyModel);
            this.oTree1.AddCustomImage(ImageKeyRoutine);
            this.oTree1.AddCustomImage(ImageKeyFHMB);
            this.oTree1.AddCustomImage(ImageKeyXY);
            this.oTree1.AddCustomImage(ImageKeyCY);

            this.oTree1.TreeItemGetImageIndex -= OnTreeItemGetImageIndex;
            this.oTree1.TreeItemGetImageIndex += OnTreeItemGetImageIndex;
        }

        /// <summary>
        /// 重置树项目图标
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnTreeItemGetImageIndex(object sender, TreeItemGetImageIndexEventArgs e)
        {
            var obj = oTree1.GetUserObject(e.Node);

            if (obj is OrTmplCaDO)
            {
                OrTmplCaDO caDO = obj as OrTmplCaDO;
                e.ImageKey = caDO.Fg_routine == true ? ImageKeyRoutine : ImageKeyModel;
            }
            else if (obj is OrTmplDTO)
            {
                OrTmplDTO dto = obj as OrTmplDTO;
                switch (dto.Sd_ortmpltp)
                {
                    case BdSrvDictCodeConst.SD_ORTMPLTP_FHMBA:
                        e.ImageKey = ImageKeyFHMB;
                        break;
                    case BdSrvDictCodeConst.SD_ORTMPLTP_CZXCY:
                        e.ImageKey = ImageKeyXY;
                        break;
                    case BdSrvDictCodeConst.SD_ORTMPLTP_CYFJ:
                        e.ImageKey = ImageKeyCY;
                        break;
                }
            }
            else
                e.ImageKey = ImageKeyCa;
        }
        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {

        }

        #endregion
    }
}
