
using System;
using System.Collections.Generic;
using System.ComponentModel;
using xap.rui.engine;
using xap.rui.engine.eventbroker;
using iih.en.pv.dto.d;
using xap.rui.engine.eventbroker.Handlers;
using System.Windows.Forms;
using iih.bd.bc.udi;
using xap.rui.engine.container;
using xap.cli.sdk.controls;
using iih.ci.ord.opemergency.assi.asscommon.viewmodel;
using iih.ci.ord.common.utils.msg;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :  加载就诊历史右侧内容区域</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.entphistory.view    </para>    
    /// <para>类 名 称 :  EntpHistoryContent					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  hums         				</para> 
    /// <para>修 改 人 :  hums         				</para> 
    /// <para>创建时间 :  2016/7/14 16:43:24             </para>
    /// <para>更新时间 :  2016/7/14 16:43:24             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistoryContent : EntHistoryBase
    {


        #region 变量定义区域

        /// <summary>
        /// 当前展现的用户组件
        /// </summary>
        private XUserControl xUserControl = null;

        private Dictionary<String, XUserControl> userCtrlDic = new Dictionary<string, XUserControl>();

        /// <summary>
        /// 事件交互类，与配置文件内的类进行交互
        /// </summary>
        private EntHistoryContentEnvet contentEvent;


        #endregion

        #region 构造函数区域

        public EntHistoryContent()
        {
            InitializeComponent();
        }

        public EntHistoryContent(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        /// <summary>
        /// 展现就诊信息的窗体
        /// </summary>
        public EntHistoryFrame EntHistoryFrame { get; set; }

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        /// <summary>
        /// 触发EntHistoryContentEnvet发送就诊相关内容选择事件
        /// <para>与接收事件FireEntpContentSelResult相对应</para>
        /// </summary>
        public void FireEntContentSel(DataEventArgs<Dictionary<string, string>> eventArgs)
        {
            if (contentEvent != null)
                contentEvent.fireEntContentSel(eventArgs);
        }

        /// <summary>
        /// 发送病历打印事件
        /// </summary>
        /// <param name="eventArgs"></param>
        public void FireEmrPrintEvent(DataEventArgs<Dictionary<string, string>> eventArgs)
        {
            if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(this.Code_entp)) {
                BizAssMessageBoxUtil.ShowInforMsg("就诊历史中不支持住院病历打印，请联系相关打印科室！");
                return;
            }
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, AssistantConstant.CI_EMR_PRINT_EVENT);
            contentEvent.FireEventSent(this, args);
        }

        /// <summary>
        /// 发送病历打印预览事件
        /// </summary>
        /// <param name="eventArgs"></param>
        public void FireEmrPrintViewEvent(DataEventArgs<Dictionary<string, string>> eventArgs)
        {
            if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(this.Code_entp))
            {
                BizAssMessageBoxUtil.ShowInforMsg("就诊历史中不支持住院病历打印预览，请联系相关打印科室！");
                return;
            }
            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, AssistantConstant.CI_EMR_PRINT_PRIVEW_EVENT);
            contentEvent.FireEventSent(this, args);
        }

        #endregion

        #region 事件接收区域

        // <summary>
        /// 接收就诊历史选择事件
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="agrs"></param>
        [EventSubscription("FirEntHisDiDTO", typeof(OnPublisher))]
        public void firEntHisDiDTO(object sender, DataEventArgs<EntHisDiDTO> args)
        {
            EntHisDiDTO entHisDiDTO = args.Data as EntHisDiDTO;

            if (entHisDiDTO != null)
            {
                // 如果就诊类型改变了，需要重新加载配置文件
                if (contentEvent.Code_entp != entHisDiDTO.Code_entp)
                {
                    this.Code_entp = entHisDiDTO.Code_entp;
                    this.Id_ent = entHisDiDTO.Id_ent;
                    this.loadContentUserControl();
                }
                else
                {
                    contentEvent.Id_ent = entHisDiDTO.Id_ent;
                }
                contentEvent.refreshEntpContent();
            }
            else
            {
                //TODO 日志、异常提示
            }
        }

        #endregion

        #region 父类继承区域

        protected override void OnLoadData()
        {
            base.OnLoadData();
        }

        protected override void OnFillData()
        {
            base.OnFillData();
        }

        #endregion

        #region 内部事件区域

        /// <summary>
        /// 加载就诊病历、医嘱、诊断
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void EntpHistoryContent_Load(object sender, System.EventArgs e)
        {

            if (string.IsNullOrEmpty(this.Code_entp))
            {
                this.Code_entp = this.Ent4BannerDTO.Code_entp;
            }
            if (string.IsNullOrEmpty(this.Id_ent))
            {
                this.Id_ent = this.Ent4BannerDTO.Id_ent;
            }
            this.loadContentUserControl();
        }

        #endregion

        #region 辅助处理函数

        private void loadContentUserControl()
        {
            string xmlCfgPath = null;
            if (xUserControl != null)
            {
                this.xapFormControl.RemoveRender(xUserControl);
            }

            xUserControl = new XUserControl();

            xmlCfgPath = this.getXmlCfgPath();
            xUserControl.Init(xmlCfgPath);
            xUserControl.Location = new System.Drawing.Point(0, 0);
            xUserControl.Size = this.Size;
            xUserControl.Dock = DockStyle.Fill;

            contentEvent = xUserControl.GetConfig().GetInstance("EntHistoryContentEnvet") as EntHistoryContentEnvet;
            if (contentEvent == null)
            {
                // 日志、提示信息
            }

            contentEvent.Id_ent = this.Id_ent;
            contentEvent.Code_entp = this.Code_entp;
            contentEvent.EntHistoryInitEvent = this.EntHistoryInitEvent;

            // 弹出窗口
            contentEvent.AssiViewFrame = this.AssiViewFrame;
            // 确定时是否关闭窗口
            contentEvent.IsConfirmCloseAssiFrame = this.IsConfirmCloseAssiFrame;

            this.setCfgInstanceProperty(xUserControl);

            this.xapFormControl.AddRender(xUserControl);
        }

        /// <summary>
        /// 根据不同的就诊类型获取获取对应的配置文件
        /// </summary>
        /// <returns></returns>
        private string getXmlCfgPath()
        {

            string xmlCfgPth = "modules\\iihci\\ui\\optrdocstation\\enthistory\\";
            if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(this.Code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(this.Code_entp))
            { // 门诊
                xmlCfgPth += "enthistory_op_config.xml";
            }
            else if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(this.Code_entp))
            {// 住院
                xmlCfgPth += "enthistory_ip_config.xml";
            }

            return xmlCfgPth;
        }

        /// <summary>
        /// 对已经实例化的对象设置公共属性
        /// </summary>
        /// <param name="xUserControl"></param>
        private void setCfgInstanceProperty(XUserControl xUserControl)
        {
            ConfigFactory config = xUserControl.GetConfig();
            // 获取配置文件中的view对象
            List<XBaseControl> xBaseCtrls = config.GetViews();

            foreach (XBaseControl ctrl in xBaseCtrls)
            {
                if (ctrl is EntHistoryBase)
                {
                    EntHistoryBase entHistory = (EntHistoryBase)ctrl;
                    entHistory.Ent4BannerDTO = this.Ent4BannerDTO;
                    entHistory.BaseContext = this.BaseContext;
                    entHistory.Id_ent = this.Id_ent;
                    entHistory.Code_entp = this.Code_entp;
                    entHistory.EntHistoryInitEvent = this.EntHistoryInitEvent;
                }
            }

            if (BdFcDictCodeConst.SD_CODE_ENTP_OP.Equals(this.Code_entp) || BdFcDictCodeConst.SD_CODE_ENTP_ET.Equals(this.Code_entp))
            { // 门诊

            }
            else if (BdFcDictCodeConst.SD_CODE_ENTP_IP.Equals(this.Code_entp))
            {// 住院

                //object ciDiagView = config.GetInstance("EntHistoryIPCiDiagView");
                //BeanPropertyUtil.SetValue(ciDiagView, "Id_ent", this.Id_ent);

            }
        }


        #endregion

        #region 状态处理区域

        #endregion
    }
}
