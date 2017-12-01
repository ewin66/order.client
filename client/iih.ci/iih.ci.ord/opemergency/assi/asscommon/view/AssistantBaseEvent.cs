
using iih.ci.ord.opemergency.assi.asscommon.viewmodel;
using iih.en.pv.dto.d;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using xap.rui.bizcontrol.bannercontrol;
using xap.rui.control.basecontrol;
using xap.rui.engine;

namespace iih.ci.ord.opemergency.assi.asscommon.view
{
    /// <summary>
    /// <para>描    述 :  助手基类</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.assi.asscommon</para>
    /// <para>类 名 称 :  AssistantBaseEvent</para>
    /// <para>版 本 号 :  v1.0.0.0</para>
    /// <para>作    者 :  HUMS</para>
    /// <para>修 改 人 :  HUMS</para>
    /// <para>创建时间 :  2016/10/20 17:32:33</para>
    /// <para>更新时间 :  2016/10/20 17:32:33</para>
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public partial class AssistantBaseEvent : AssistantBase
    {

        #region 变量定义区域

        /// <summary>
        ///  诊断助手服务
        /// </summary>
        protected AssistantCidiViewModel assiCidiViewModel;

        /// <summary>
        /// 医嘱助手服务
        /// </summary>
        protected AssistantCiOrderViewModel assiCiorderViewModel;

        #endregion

        #region 构造函数区域

        public AssistantBaseEvent()
        {
            assiCidiViewModel = new AssistantCidiViewModel();
            assiCiorderViewModel = new AssistantCiOrderViewModel();
            InitializeComponent();
        }

        public AssistantBaseEvent(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        #endregion

        #region 公开属性区域  
            
        /// <summary>
        /// banner对象
        /// </summary>
        public Ent4BannerDTO Ent4BannerDTO { get; set; }

        #endregion

        #region 命令定义区域

        #endregion

        #region 事件发送区域

        /// <summary>
        /// 发送回写病历事件 到EmrEditorInitEvent 
        /// </summary>
        /// <param name="obj">事件发出者</param>
        /// <param name="dataObj">发送给病历的数据</param>
        protected void FireMrWriteBackBizEvent(object obj, object dataObj)
        {

            DictionaryEventArgs args = new DictionaryEventArgs();
            args.Data.Add(UIConst.UI_EVENT, AssistantConstant.CI_EMR_WRITE_BACK_EVENT);

            Dictionary<string, object> dataDic = new Dictionary<string, object>();
            // 病历的段落回写返回数据key值固定是lsPhase
            dataDic.Add(AssistantConstant.CI_EMR_WRITE_BACK_DATA, dataObj);

            args.Data.Add(UIConst.DATA, dataDic);
            this.FireEventSent(obj, args);
        }

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
                this.Ent4BannerDTO = bannerData.Ent4BannerDTO;

                // 诊断助手服务
                assiCidiViewModel.ent4BannerDTO = this.Ent4BannerDTO;
                assiCidiViewModel.context = this.Context;

                // 医嘱助手服务
                assiCiorderViewModel.ent4BannerDTO = this.Ent4BannerDTO;
                assiCiorderViewModel.context = this.Context;
            }
        }

        #endregion

        #region 内部事件区域

        #endregion

        #region 辅助处理函数

        #endregion

        #region 状态处理区域

        #endregion

    }
}
