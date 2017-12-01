
using System.ComponentModel;
using xap.rui.control.basecontrol;
using System.Windows.Forms;
using iih.en.pv.dto.d;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.lis
{
    /// <summary>
    /// <para>描    述 :  历次检验报告</para>
    /// <para>说    明 :  展现第三方历次检验报告</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.lis    </para>    
    /// <para>类 名 称 :  PastlistrptsView					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2016/9/28 10:27:16             </para>
    /// <para>更新时间 :  2016/9/28 10:27:16             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class PastlistrptsView : XapBaseControl
    {
        #region 变量定义区域

        private Ent4BannerDTO ent4BannerDTO;

        #endregion

        #region 构造函数区域

        public PastlistrptsView()
        {
            InitializeComponent();
        }

        public PastlistrptsView(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        #endregion

        #region 事件接收区域

        #endregion

        #region 父类继承区域

        /// <summary>
        /// 获取banner信息患者
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        public override void OnSelected(object sender, TargetEventArgs e)
        {
            BannerData bannerData = e.Object as BannerData;
            if (bannerData != null && bannerData.Ent4BannerDTO != null)
            {
                this.ent4BannerDTO = bannerData.Ent4BannerDTO;
            }
        }

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        private void LoadLisReport()
        {

            // 弹出tab页签写法
            //Dictionary<string, object> dic = new Dictionary<string, object>();
            //dic.Add("patientId", "000100184100"); // 参数传患者id
            //OpenFuncEventArgs eventArgs = new OpenFuncEventArgs("46105565", dic);
            //xap.cli.context.events.XapEvents.OpenFuncEvent(this, eventArgs);           

            // 调用弹出页面方法
            ListrptView listrptView = new ListrptView();
            listrptView.WindowState = FormWindowState.Maximized;
            listrptView.ShowDialog();
        }

        #endregion

        #region 状态处理区域

        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            DictionaryEventArgs de = new DictionaryEventArgs();
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case "DataCenterAction": // 数据中心
                case "RisHistoryReportAction": //检查报告
                case "LisHistoryReportAction":// 展现历次就诊检查报告
                    this.LoadLisReport();
                    break;
            }
        }
        #endregion

    }
}
