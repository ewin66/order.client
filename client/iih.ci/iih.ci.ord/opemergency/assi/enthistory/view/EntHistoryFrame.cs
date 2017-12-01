using System.Windows.Forms;
using xap.cli.sdk.form;
using iih.en.pv.dto.d;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.assi.enthistory.view
{
    /// <summary>
    /// <para>描    述 :  加载就诊历史窗体</para>
    /// <para>说    明 :  用于展现就诊历史树，以及就诊对应的医嘱、诊断、病历</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.entphistory.view    </para>    
    /// <para>类 名 称 :  EntpHistoryFrame					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/7/14 13:52:19             </para>
    /// <para>更新时间 :  2016/7/14 13:52:19             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class EntHistoryFrame : XForm
    {

        #region 变量定义区域

        #endregion

        #region 构造函数区域

        public EntHistoryFrame()
        {
            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        /// <summary>
        /// banner数据
        /// </summary>
        public Ent4BannerDTO BannerDTO { get; set; }
        /// <summary>
        /// 当前环境
        /// </summary>
        public BaseContext BaseContext { get; set; }
        /// <summary>
        /// 与门诊病历、医嘱、诊断交互的类
        /// </summary>
        public EntHistoryInitEvent EntHistoryInitEvent { get; set; }

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

        protected void EntpHistoryFrame_Load(object sender, System.EventArgs e)
        {
            XUserControl xUserControl = new XUserControl();
            xUserControl.Init("modules\\iihci\\ui\\optrdocstation\\enthistory\\enthistory_config.xml");


            EntHistory entHistory = xUserControl.GetConfig().GetInstance("EntHistory") as EntHistory;
            EntHistoryContent entHistoryContent = xUserControl.GetConfig().GetInstance("EntHistoryContent") as EntHistoryContent;
            EntHistoryBtn entHistoryBtn = xUserControl.GetConfig().GetInstance("EntHistoryBtn") as EntHistoryBtn;

            entHistory.Ent4BannerDTO = this.BannerDTO;

            entHistoryContent.Ent4BannerDTO = this.BannerDTO;
            entHistoryContent.EntHistoryInitEvent = this.EntHistoryInitEvent;
            entHistoryContent.BaseContext = this.BaseContext;

            entHistoryBtn.EntHistoryFrame = this;
            entHistoryBtn.Ent4BannerDTO = this.BannerDTO;

            xUserControl.Dock = DockStyle.Fill;
            this.xapFormControl.AddRender(xUserControl);
        }


        #endregion

        #region 辅助处理函数



        #endregion

        #region 状态处理区域

        #endregion



    }
}
