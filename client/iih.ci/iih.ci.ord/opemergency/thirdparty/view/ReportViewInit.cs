
using iih.bd.bc.udi;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.opemergency.action.costant;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using xap.mw.serviceframework;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.basecontrol;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.thirdparty.view
{
    /// <summary>
    /// <para>描    述 :  </para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.thirdparty.view</para>    
    /// <para>类 名 称 :  ReportViewInit</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2017/4/7 17:20:32</para>
    /// <para>更新时间 :  2017/4/7 17:20:32</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class ReportViewInit : XapBaseControl
    {

        #region 变量定义区域

        private Ent4BannerDTO ent4BannerDTO;



        // 调用弹出页面方法
        private bool IsOpenReportView = false;

        private ReportView reportView { get; set; }



        #endregion

        #region 构造函数区域     

        public ReportViewInit()
        {

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
            else
            {
                this.ent4BannerDTO = null;
            }
        }

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        /// <summary>
        /// 加载报告
        /// </summary>
        /// <param name="uiEvent"></param>
        private void LoadLisReport(string uiEvent)
        {

            // 弹出tab页签写法
            //Dictionary<string, object> dic = new Dictionary<string, object>();
            //dic.Add("patientId", "000100184100"); // 参数传患者id
            //OpenFuncEventArgs eventArgs = new OpenFuncEventArgs("46105565", dic);
            //xap.cli.context.events.XapEvents.OpenFuncEvent(this, eventArgs);

            // 判断是否存在患者信息
            if (BizAssMessageBoxUtil.ShowPatIsNullMsg(this.ent4BannerDTO, ""))
            {
                return;
            }

            if (this.IsOpenReportView)
            {
                reportView.Dispose();
            }

            reportView = new ReportView();
            reportView.reportViewInit = this;
            reportView.context = this.Context;
            reportView.ent4BannerDTO = this.ent4BannerDTO;
            reportView.uiEvent = uiEvent; // 当前点击的按钮

            // 调用弹出页面方法            
            reportView.WindowState = FormWindowState.Maximized;
            this.IsOpenReportView = true;

            Control ctrl = this.Context.Config.GetInstance("OrdListView") as Control;
            if (ctrl == null)
            {
                reportView.ShowDialog();
            }
            else
            {
                reportView.ShowDialog(ctrl);
            }


        }




        #endregion

        #region 状态处理区域

        /// <summary>
        /// 接收检查报告、检验报告、数据中心、会诊
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="eventArgs"></param>
        public override void HandleState(object sender, DictionaryEventArgs eventArgs)
        {
            DictionaryEventArgs de = new DictionaryEventArgs();
            string uiEvent = eventArgs.Data[UIConst.UI_EVENT] as string;
            string newState = eventArgs.Data[UIConst.NEW_STATE] as string;
            switch (uiEvent)
            {
                case OpActionConstant.CONS_REPORT_ACTION://会诊
                case OpActionConstant.DATA_CENTER_ACTION: // 数据中心
                case OpActionConstant.RIS_HISTORY_REPORT_ACTION: //检查报告
                case OpActionConstant.LIS_HISTORY_REPORT_ACTION:// 展现历次就诊检查报告
                    this.LoadLisReport(uiEvent);
                    break;
            }
        }
        #endregion
    }
}
