using iih.ci.ord.common.utils.msg;
using iih.ci.ord.opemergency.assi.asscommon.dto;
using iih.ci.ord.opemergency.assi.asscommon.util;
using System;
using System.Collections.Generic;
using System.Windows.Forms;
using System.Xml;
using xap.cli.sdk.controls;
using xap.cli.sdk.controls.tabControl;
using xap.cli.sdk.form;
using xap.rui.engine;
using xap.rui.engine.xlayouts;

namespace iih.ci.ord.opemergency.assi.asscommon.view
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon.view</para>
    /// <para>类 名 称 :  AssiViewFrame</para>
    /// <para>版 本 号 :  v1.0.0.0</para>
    /// <para>作    者 :  HUMS</para>
    /// <para>修 改 人 :  HUMS</para>
    /// <para>创建时间 :  2016/12/15 11:25:12</para>
    /// <para>更新时间 :  2016/12/15 11:25:12</para>
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class AssiViewFrame : XForm
    {

        #region 变量定义区域


        /// <summary>
        /// 监听鼠标点击事件
        /// </summary>
        //private AssiMouseEventHandler mouseEventHandler;



        /// <summary>
        /// 当前处于激活状态的tab页签id
        /// </summary>
        //private string activeTabId;

        /// <summary>
        /// 初始化控件
        /// </summary>
        private XUserControl xUserControl;

        #endregion

        #region 构造函数区域

        public AssiViewFrame()
        {
            InitializeComponent();

            this.FormClosing += new FormClosingEventHandler(AssiViewFrame_FormClosing);
        }

        void AssiViewFrame_FormClosing(object sender, FormClosingEventArgs e)
        {
           
        }

        #endregion

        #region 公开属性区域

        /// <summary>
        /// 助手窗口是否已经打开
        /// </summary>

        /// <summary>
        /// 窗口打开方式
        /// </summary>
        public AssiFrameOpenModel FrameOpenModel { get; set; }

        /// <summary>
        /// 助手窗体显示位置，left左侧，right 右侧
        /// </summary>
        public AssiFrameLocation FrameLocation { get; set; }

        /// <summary>
        /// 设置点击鼠标左键不需要关闭辅助录入窗口的XapBaseControl集合
        /// </summary>
        public List<XBaseControl> MouseInXBaseCtrlList { get; set; }

        /// <summary>
        /// 窗口加载的配置文件
        /// </summary>
        public Dictionary<AssiFrameLocation, string> ConfigPathDic { get; set; }

        /// <summary>
        /// 弹出助手页面的基类
        /// </summary>
        public AssistantBtnBaseView assistantBtnBaseView { get; set; }
        /// <summary>
        /// 助手窗口是否已经打开
        /// </summary>
        private bool isFrameOpened = false;

        public bool IsFrameOpened
        {
            get
            {
                return isFrameOpened;
            }

            set
            {
                isFrameOpened = value;
            }
        }

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        #endregion

        #region 内部事件区域

        /// <summary>
        /// 窗体加载事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void AssiViewFrame_Load(object sender, System.EventArgs e)
        {
            // 添加监听鼠标点击事件，鼠标点击this，MouseClickXapCtrlList区域外时，需要关闭辅助录入窗口
            //mouseEventHandler = new AssiMouseEventHandler(this, MouseInXBaseCtrlList);
            //Application.AddMessageFilter(mouseEventHandler);
        }

        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 加载助手窗体
        /// </summary>
        /// <param name="parentCtrl"></param>
        /// <param name="classId"></param>
        public void loadFrame(XBaseControl parentCtrl, XUserControl xUserControl, AssiBtnDTO btnDTO)
        {
            this.xUserControl = xUserControl;
            this.xapFormControl.AddRender(xUserControl);

            if (btnDTO.ButtonId == "btnOpTemplateFrame")
            {
                this.loadFramePithy(parentCtrl, xUserControl, btnDTO);
                return;
            }         

            LayoutPanelManager layoutPanelManager = xUserControl.GetConfig().GetInstance("LayoutPanelManager") as LayoutPanelManager;            

            for (int n = 0; n < layoutPanelManager.ManagedPanels.Count; n++)
            {

                LayoutManagedPanel layoutManaged = layoutPanelManager.ManagedPanels[n] as LayoutManagedPanel;
                if (btnDTO.PanelManagerId == layoutManaged.Id )
                {
                    if (layoutManaged.Controls.Count < 1)
                    {
                        XmlNode node = xUserControl.GetConfig().GetNode("ManagedPanel", layoutManaged.Id);
                        xUserControl.GetConfig().CreateManagedPanelControl(layoutManaged, node);                        
                    }
                    layoutPanelManager.SelectedIndex = n;

                    foreach (Control ctrTemp in layoutManaged.Controls)
                    {
                        if (ctrTemp is XLayoutPanel)
                        {
                            if ((ctrTemp as XLayoutPanel).ControlCenter is XTabControl)
                            {
                                //if (ctrTemp is XTabControl)
                                {
                                    var tabCtr = (ctrTemp as XLayoutPanel).ControlCenter as XTabControl;
                                    for (var j = 0; j < tabCtr.XTabPages.Count; j++)
                                    {
                                        if (btnDTO.XTabPageId.Equals(tabCtr.XTabPages[j].Id))
                                        {
                                            tabCtr.SelectedIndex = j;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
            }

            int i = 0;
            Control control = xUserControl.GetControl();
            foreach (Control obj in control.Controls)
            {
                XTabPage xtabPage = obj as XTabPage;
                if (xtabPage != null)
                {
                    i++;
                    if (i == 3)
                    {
                        xtabPage.Select();
                    }
                }
            }

            //layoutPanelManager.SelectedIndex = 1;

            // 如果窗体已经打开，只进行切换tab页签
            if (!IsFrameOpened)
            {
                IsFrameOpened = true;

                if (this.FrameOpenModel == AssiFrameOpenModel.SHOW_DIALOG)
                {
                    this.ShowDialog(parentCtrl);
                }
                else
                {
                    this.Show(parentCtrl);
                }
            }
        }
        /// <summary>
        /// 加载助手窗体
        /// </summary>
        /// <param name="parentCtrl"></param>
        /// <param name="classId"></param>
        public void loadFramePithy(XBaseControl parentCtrl, XUserControl xUserControl, AssiBtnDTO btnDTO)
        {

            LayoutPanelManager layoutPanelManager = xUserControl.GetConfig().GetInstance("LayoutPanelManager") as LayoutPanelManager;

            for (int n = 0; n < layoutPanelManager.ManagedPanels.Count; n++)
            {

                LayoutManagedPanel layoutManaged = layoutPanelManager.ManagedPanels[n] as LayoutManagedPanel;
                if (btnDTO.modelType == null || btnDTO.modelType != "complex")
                {
                    if ("OrdertemplatePithy" == layoutManaged.Id)
                    {
                        if (layoutManaged.Controls.Count < 1)
                        {
                            XmlNode node = xUserControl.GetConfig().GetNode("ManagedPanel", layoutManaged.Id);
                            xUserControl.GetConfig().CreateManagedPanelControl(layoutManaged, node);
                        }
                        layoutPanelManager.SelectedIndex = n;
                        break;
                    }
                }
                else {
                    if ("OrdertemplateComplex" == layoutManaged.Id)
                    {
                        if (layoutManaged.Controls.Count < 1)
                        {
                            XmlNode node = xUserControl.GetConfig().GetNode("ManagedPanel", layoutManaged.Id);
                            xUserControl.GetConfig().CreateManagedPanelControl(layoutManaged, node);
                        }
                        layoutPanelManager.SelectedIndex = n;
                        break;
                    }
                }
            }
            if (!IsFrameOpened)
            {
                IsFrameOpened = true;

                if (this.FrameOpenModel == AssiFrameOpenModel.SHOW_DIALOG)
                {
                    this.ShowDialog(parentCtrl);
                }
                else
                {
                    this.Show(parentCtrl);
                }
            }
           
        }

        
        protected override void OnClosed(EventArgs e)
        {
            this.IsFrameOpened = false;

            // 当窗口关闭时，清除页面绑定的鼠标点击事件
            //if (mouseEventHandler != null)
            //{
            //    Application.RemoveMessageFilter(mouseEventHandler);
            //}

            this.xapFormControl.RemoveRenderAll();

            if (this.assistantBtnBaseView != null)
            {   
                this.assistantBtnBaseView.AssiViewFrameClosed();
            }

            base.OnClosed(e);
        }
        public void switchToComplex() {
            assistantBtnBaseView.switchToComplex();
        }
        public void switchToPithy() {
            assistantBtnBaseView.switchToPithy();
        }
        #endregion

        #region 状态处理区域

        #endregion


    }
}
