
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.opemergency.operateaction.baseoperate
{
    /// <summary>
    /// <para>描    述 :  事件链中相关常量定义</para>
    /// <para>说    明 :  </para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.operateaction.baseoperate</para>    
    /// <para>类 名 称 :  OpOperateActionEvent</para> 
    /// <para>版 本 号 :  v1.0.0.0</para> 
    /// <para>作    者 :  HUMS</para> 
    /// <para>修 改 人 :  HUMS</para> 
    /// <para>创建时间 :  2016/11/1 16:16:37</para>
    /// <para>更新时间 :  2016/11/1 16:16:37</para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class OpOperateActionEvent
    {


        #region 事件名称

        /// <summary>
        /// 病历签名UiEvent
        /// </summary>
        public const string EMR_SIGN_NAME = "EmrSignName";
        /// <summary>
        /// 病历签名反馈结果UiEvent
        /// </summary>
        public const string EMR_SIGN_NAME_RESULT = "EmrSignNameResult";
        /// <summary>
        /// 签名失败
        /// </summary>
        public const int EMR_SIGN_NAME_FAILED = 0;
        /// <summary>
        /// 签名成功
        /// </summary>
        public const int EMR_SIGN_NAME_SUCC = 1;
        /// <summary>
        /// 拒绝签名
        /// </summary>
        public const int EMR_SIGN_NAME_REFUSE = 2;


        // 触发打印事件 传递参数为 OpActionConstant.OP_PRINT_ACTION

        /// <summary>
        /// 打印结束反馈事件
        /// </summary>
        public const string PRINT_COMPLETE = "PrintComplete";

        /// <summary>
        /// 清空banner事件中的key值
        /// </summary>
        public const string CLEAR_BANNER = "clearBanner";

        public const string EnCompleteClearEvent = "EnCompleteClearEvent";

        /// <summary>
        /// 患者待回诊
        /// </summary>
        public const string EN_PAT_SUSPEND = "EnPatSuspend";

        /// <summary>
        /// 切换用户触发当前患者相关处理事件
        /// </summary>
        public const string BANNER_SWITCHING_USER = "BannerSwitchingUser";
        /// <summary>
        /// 发送允许切换患者事件
        /// </summary>
        public const string BANNER_SWITCH_USER_EVENT = "BannerSwitchUserEvent";

        /// <summary>
        /// 切换用户触发病历相关的操作
        /// </summary>
        public const string EMR_BANNER_SWITCHING_USER = "EmrBannerSwitchingUser";
        /// <summary>
        /// 提示信息
        /// </summary>
        public const string MSG = "msg";

        #endregion

    }
}
