

using iih.ci.ord.common.log;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.opemergency.thirdparty.viewmodel;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.cli.context;
using xap.cli.context.events;
using xap.cli.sdk.form;
using xap.mw.log;
using xap.rui.engine;
using xap.rui.control.browser;
using xap.cli.sdk.controls;

namespace iih.ci.ord.opemergency.thirdparty.view
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.thirdparty.view</para>
    /// <para>类 名 称 :  ReportView</para>
    /// <para>版 本 号 :  v1.0.0.0</para>
    /// <para>作    者 :  HUMS</para>
    /// <para>修 改 人 :  HUMS</para>
    /// <para>创建时间 :  2017/4/7 17:19:48</para>
    /// <para>更新时间 :  2017/4/7 17:19:48</para>
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public partial class ReportView : XForm
    {
        #region 变量定义区域        

        #endregion

        #region 构造函数区域    

        public ReportView()
        {
            InitializeComponent();
        }

        #endregion

        #region 公开属性区域

        /// <summary>
        /// 加载报告的参数
        /// </summary>
        public Dictionary<String, object> paramDic { get; set; }

        /// <summary>
        /// 报告初始化类
        /// </summary>
        public ReportViewInit reportViewInit { get; set; }

        /// <summary>
        /// 上下文环境
        /// </summary>
        public BaseContext context { get; set; }

        /// <summary>
        /// banner对象
        /// </summary>
        public Ent4BannerDTO ent4BannerDTO { get; set; }

        /// <summary>
        /// 查看报告点击的action ,用于区分检查、检验、数据中心、会诊
        /// </summary>
        public string uiEvent { get; set; }

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
        /// 报告加载
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void ReportView_Load(object sender, System.EventArgs e)
        {
            ReportViewModel reportViewModel = new ReportViewModel(this.context);

            Dictionary<string, object> paramDic = reportViewModel.GetParamDic(this.uiEvent, this.ent4BannerDTO);

            if (!paramDic.ContainsKey("funCode"))
            {
                BizAssMessageBoxUtil.ShowWarningMsg("加载报告时未获取到功能节点编码！");
                return;
            }

            string funCode = paramDic["funCode"] as string;
            paramDic.Remove("funCode");
            Control ctrl = XapEvents.GetFuncEvent(this, new GetFuncEventArgs(funCode, paramDic));
            // XCefWebBrowser webBrower = ctrl as XCefWebBrowser;

            EmbedControl webBrower = ctrl as EmbedControl;



            string title = MenuItemController.GetInstance().FuncIdAndNameMapper[funCode];

            StringBuilder msgBuilder = new StringBuilder();
            string url = webBrower.Arguments;
            msgBuilder.Append("打开节点[" + title + "];节点编码：" + funCode + " ； 请求地址："+ url);
            string logMsg = LogManagerUtil.GetEnInfo(msgBuilder.ToString(), this.ent4BannerDTO);
            LogManager.GetLogger().InfoEx(logMsg);

            this.Text = title;
            ctrl.Dock = DockStyle.Fill;
            this.AddRender(ctrl);
        }

        #endregion

        #region 辅助处理函数

        #endregion

        #region 状态处理区域

        #endregion


    }
}
